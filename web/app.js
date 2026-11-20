import { LESSONS } from './lessons.js';

const STORAGE_KEY = 'tekenstap_web_prefs_v1';

const KID_COLORS = [
  { name: 'Zwart', hex: '#1e1a16' },
  { name: 'Bruin', hex: '#795548' },
  { name: 'Rood', hex: '#e53935' },
  { name: 'Oranje', hex: '#d0552b' },
  { name: 'Geel', hex: '#f2b705' },
  { name: 'Groen', hex: '#43a047' },
  { name: 'Blauw', hex: '#1e88e5' },
  { name: 'Paars', hex: '#8e24aa' }
];

const BRUSH_TOOLS = [
  { id: 'PENCIL', label: '✏️ Potlood' },
  { id: 'FINELINER', label: '🖊️ Stift' },
  { id: 'MARKER', label: '🖍️ Markeer' },
  { id: 'ERASER', label: '🧽 Gum' }
];

const BRUSH_WIDTHS = [
  { label: 'Dun', size: 3, dotPx: 7 },
  { label: 'Normaal', size: 6, dotPx: 12 },
  { label: 'Dik', size: 11, dotPx: 18 }
];

const KID_PROMPTS = [
  'Teken een vrolijke draak die bellen blaast!',
  'Teken jouw droomboomhut met een touwladder.',
  'Maak een grappig monstertje met 3 ogen en een hoed.',
  'Teken een raket op weg naar een planeet vol snoep.',
  'Teken je lievelingsdier met een coole zonnebril!'
];

function loadPrefs() {
  try {
    const raw = localStorage.getItem(STORAGE_KEY);
    if (raw) {
      const parsed = JSON.parse(raw);
      return {
        completedIds: Array.isArray(parsed.completedIds) ? parsed.completedIds : [],
        showConstruction: parsed.showConstruction ?? true,
        showGrid: parsed.showGrid ?? true,
        speed: typeof parsed.speed === 'number' ? parsed.speed : 1,
        lastLessonId: parsed.lastLessonId || null
      };
    }
  } catch (_) {}
  return { completedIds: [], showConstruction: true, showGrid: true, speed: 1, lastLessonId: null };
}

function savePrefs(prefs) {
  try {
    localStorage.setItem(STORAGE_KEY, JSON.stringify(prefs));
  } catch (_) {}
}

const state = {
  prefs: loadPrefs(),
  activeTab: 'home',
  category: 'ALL',
  search: '',
  // Player state
  lesson: LESSONS[0],
  stepIndex: 0,
  stepProgress: 0,
  isPlaying: true,
  autoPlayAll: false,
  practiceMode: 'ON_PAPER',
  ghostAlpha: 0.30,
  lessonStrokes: [],
  lessonRedo: [],
  lessonTool: 'PENCIL',
  lessonColor: '#1e1a16',
  lessonWidth: 6,
  // Free sketchbook state
  sketchStrokes: [],
  sketchRedo: [],
  sketchTool: 'PENCIL',
  sketchColor: '#1e1a16',
  sketchWidth: 6,
  sketchGrid: 'DOTS',
  promptIdx: 0
};

// ---------------- VECTOR SAMPLER FOR SMOOTH ANIMATED STROKES ----------------
function sampleStrokeContours(cmds, mapX, mapY, mapSize) {
  const contours = [];
  let current = [];
  let cx = 0, cy = 0;

  const pushPt = (x, y) => {
    current.push({ x, y });
    cx = x;
    cy = y;
  };

  for (const cmd of cmds) {
    const op = cmd[0];
    if (op === 'M') {
      if (current.length > 0) contours.push(current);
      current = [];
      pushPt(mapX(cmd[1]), mapY(cmd[2]));
    } else if (op === 'L') {
      const tx = mapX(cmd[1]), ty = mapY(cmd[2]);
      const steps = 16;
      const sx = cx, sy = cy;
      for (let i = 1; i <= steps; i++) {
        const t = i / steps;
        pushPt(sx + (tx - sx) * t, sy + (ty - sy) * t);
      }
    } else if (op === 'Q') {
      const qx = mapX(cmd[1]), qy = mapY(cmd[2]);
      const tx = mapX(cmd[3]), ty = mapY(cmd[4]);
      const sx = cx, sy = cy;
      const steps = 24;
      for (let i = 1; i <= steps; i++) {
        const t = i / steps;
        const u = 1 - t;
        pushPt(u * u * sx + 2 * u * t * qx + t * t * tx, u * u * sy + 2 * u * t * qy + t * t * ty);
      }
    } else if (op === 'C') {
      const c1x = mapX(cmd[1]), c1y = mapY(cmd[2]);
      const c2x = mapX(cmd[3]), c2y = mapY(cmd[4]);
      const tx = mapX(cmd[5]), ty = mapY(cmd[6]);
      const sx = cx, sy = cy;
      const steps = 30;
      for (let i = 1; i <= steps; i++) {
        const t = i / steps;
        const u = 1 - t;
        pushPt(
          u * u * u * sx + 3 * u * u * t * c1x + 3 * u * t * t * c2x + t * t * t * tx,
          u * u * u * sy + 3 * u * u * t * c1y + 3 * u * t * t * c2y + t * t * t * ty
        );
      }
    } else if (op === 'circle' || op === 'oval') {
      if (current.length > 0) contours.push(current);
      current = [];
      const ocx = mapX(cmd[1]), ocy = mapY(cmd[2]);
      const rx = mapSize(cmd[3]);
      const ry = op === 'circle' ? rx : mapSize(cmd[4]);
      const steps = 42;
      for (let i = 0; i <= steps; i++) {
        const a = (i / steps) * Math.PI * 2;
        pushPt(ocx + Math.cos(a) * rx, ocy + Math.sin(a) * ry);
      }
    } else if (op === 'arc') {
      if (current.length > 0) contours.push(current);
      current = [];
      const acx = mapX(cmd[1]), acy = mapY(cmd[2]);
      const rx = mapSize(cmd[3]), ry = mapSize(cmd[4]);
      const startDeg = cmd[5], sweepDeg = cmd[6];
      const steps = 28;
      for (let i = 0; i <= steps; i++) {
        const a = ((startDeg + (sweepDeg * i) / steps) * Math.PI) / 180;
        pushPt(acx + Math.cos(a) * rx, acy + Math.sin(a) * ry);
      }
    }
  }
  if (current.length > 0) contours.push(current);
  return contours;
}

function drawGrid(ctx, w, h, gridStyle) {
  if (gridStyle === 'NONE') return;
  if (gridStyle === 'DOTS') {
    ctx.fillStyle = '#d6cec2';
    const step = 22;
    for (let x = step; x < w; x += step) {
      for (let y = step; y < h; y += step) {
        ctx.beginPath();
        ctx.arc(x, y, 1.3, 0, Math.PI * 2);
        ctx.fill();
      }
    }
  } else if (gridStyle === 'GRID') {
    ctx.strokeStyle = '#e7dfd3';
    ctx.lineWidth = 1;
    const step = 26;
    for (let x = step; x < w; x += step) {
      ctx.beginPath();
      ctx.moveTo(x, 0);
      ctx.lineTo(x, h);
      ctx.stroke();
    }
    for (let y = step; y < h; y += step) {
      ctx.beginPath();
      ctx.moveTo(0, y);
      ctx.lineTo(w, y);
      ctx.stroke();
    }
  }
}

function drawContoursPartial(ctx, contours, fraction) {
  let totalPts = 0;
  for (const c of contours) totalPts += Math.max(0, c.length - 1);
  if (totalPts === 0 || fraction <= 0.001) return null;

  let remaining = totalPts * Math.min(1, fraction);
  let tip = null;

  for (const pts of contours) {
    if (pts.length < 2 || remaining <= 0) continue;
    ctx.beginPath();
    ctx.moveTo(pts[0].x, pts[0].y);
    const segs = pts.length - 1;
    if (remaining >= segs) {
      for (let i = 1; i < pts.length; i++) ctx.lineTo(pts[i].x, pts[i].y);
      remaining -= segs;
      tip = pts[pts.length - 1];
    } else {
      const whole = Math.floor(remaining);
      const frac = remaining - whole;
      for (let i = 1; i <= whole; i++) ctx.lineTo(pts[i].x, pts[i].y);
      const pA = pts[whole];
      const pB = pts[Math.min(whole + 1, pts.length - 1)];
      const lx = pA.x + (pB.x - pA.x) * frac;
      const ly = pA.y + (pB.y - pA.y) * frac;
      ctx.lineTo(lx, ly);
      tip = { x: lx, y: ly };
      remaining = 0;
    }
    ctx.stroke();
  }
  return tip;
}

function renderTutorialStroke(ctx, stroke, bounds, fraction, isActiveStep, ghostMode, ghostAlpha) {
  const { left, top, side } = bounds;
  const mapX = (nx) => left + nx * side;
  const mapY = (ny) => top + ny * side;
  const mapSize = (n) => n * side;

  const contours = sampleStrokeContours(stroke.cmds, mapX, mapY, mapSize);
  ctx.save();
  ctx.lineCap = 'round';
  ctx.lineJoin = 'round';

  const baseW = stroke.kind === 'CONSTRUCTION' ? 1.8 : stroke.kind === 'OUTLINE' ? 3.5 : stroke.kind === 'DETAIL' ? 2.6 : 2.0;
  ctx.lineWidth = baseW * (side / 340);

  if (stroke.kind === 'CONSTRUCTION') {
    ctx.setLineDash([7, 6]);
    ctx.strokeStyle = ghostMode ? `rgba(77,136,184,${ghostAlpha * 1.15})` : 'rgba(77,136,184,0.62)';
  } else if (isActiveStep && !ghostMode) {
    ctx.strokeStyle = '#d0552b';
  } else if (stroke.kind === 'SHADING') {
    ctx.strokeStyle = ghostMode ? `rgba(107,98,89,${ghostAlpha * 0.85})` : 'rgba(107,98,89,0.72)';
  } else {
    ctx.strokeStyle = ghostMode ? `rgba(35,31,28,${ghostAlpha})` : '#231f1c';
  }

  const tip = drawContoursPartial(ctx, contours, fraction);
  ctx.restore();
  return tip;
}

function drawPencilCursor(ctx, tip) {
  if (!tip) return;
  ctx.save();
  ctx.fillStyle = 'rgba(208, 85, 43, 0.22)';
  ctx.beginPath();
  ctx.arc(tip.x, tip.y, 13, 0, Math.PI * 2);
  ctx.fill();

  ctx.fillStyle = '#d0552b';
  ctx.beginPath();
  ctx.arc(tip.x, tip.y, 4, 0, Math.PI * 2);
  ctx.fill();

  ctx.lineCap = 'round';
  ctx.strokeStyle = '#231f1c';
  ctx.lineWidth = 3;
  ctx.beginPath();
  ctx.moveTo(tip.x, tip.y);
  ctx.lineTo(tip.x + 6, tip.y - 6);
  ctx.stroke();

  ctx.strokeStyle = '#e5a93c';
  ctx.lineWidth = 7;
  ctx.beginPath();
  ctx.moveTo(tip.x + 6, tip.y - 6);
  ctx.lineTo(tip.x + 24, tip.y - 24);
  ctx.stroke();

  ctx.strokeStyle = '#d0552b';
  ctx.beginPath();
  ctx.moveTo(tip.x + 24, tip.y - 24);
  ctx.lineTo(tip.x + 27, tip.y - 27);
  ctx.stroke();
  ctx.restore();
}

function renderThumbnailCanvas(canvas, lesson) {
  const dpr = window.devicePixelRatio || 1;
  const w = canvas.clientWidth || 160;
  const h = canvas.clientHeight || 140;
  canvas.width = w * dpr;
  canvas.height = h * dpr;
  const ctx = canvas.getContext('2d');
  ctx.scale(dpr, dpr);
  ctx.clearRect(0, 0, w, h);

  const side = Math.min(w, h) * 0.86;
  const bounds = { left: (w - side) / 2, top: (h - side) / 2, side };

  for (const step of lesson.steps) {
    for (const stroke of step.strokes) {
      if (stroke.kind === 'CONSTRUCTION') continue;
      const mapX = (nx) => bounds.left + nx * bounds.side;
      const mapY = (ny) => bounds.top + ny * bounds.side;
      const mapSize = (n) => n * bounds.side;
      const contours = sampleStrokeContours(stroke.cmds, mapX, mapY, mapSize);
      ctx.save();
      ctx.lineCap = 'round';
      ctx.lineJoin = 'round';
      ctx.lineWidth = stroke.kind === 'OUTLINE' ? 2.4 : stroke.kind === 'DETAIL' ? 1.8 : 1.3;
      ctx.strokeStyle =
        stroke.kind === 'DETAIL' ? lesson.accentHex : stroke.kind === 'SHADING' ? 'rgba(35,31,28,0.45)' : '#231f1c';
      drawContoursPartial(ctx, contours, 1);
      ctx.restore();
    }
  }
}

function renderTutorialFrame() {
  const canvas = document.getElementById('tutorial-canvas');
  if (!canvas) return;
  const rect = canvas.getBoundingClientRect();
  if (rect.width < 10) return;

  const dpr = window.devicePixelRatio || 1;
  if (canvas.width !== Math.round(rect.width * dpr) || canvas.height !== Math.round(rect.height * dpr)) {
    canvas.width = Math.round(rect.width * dpr);
    canvas.height = Math.round(rect.height * dpr);
  }
  const ctx = canvas.getContext('2d');
  ctx.setTransform(dpr, 0, 0, dpr, 0, 0);

  const w = rect.width;
  const h = rect.height;
  ctx.fillStyle = '#fffdf8';
  ctx.fillRect(0, 0, w, h);
  if (state.prefs.showGrid) drawGrid(ctx, w, h, 'DOTS');

  const ghostMode = state.practiceMode === 'ON_SCREEN';
  if (ghostMode && state.ghostAlpha <= 0.01) return;

  const side = Math.min(w, h) * 0.90;
  const bounds = { left: (w - side) / 2, top: (h - side) / 2, side };
  const lesson = state.lesson;
  const sIdx = Math.min(state.stepIndex, lesson.steps.length - 1);

  for (let i = 0; i < sIdx; i++) {
    for (const stroke of lesson.steps[i].strokes) {
      if (stroke.kind === 'CONSTRUCTION' && !state.prefs.showConstruction) continue;
      renderTutorialStroke(ctx, stroke, bounds, 1, false, ghostMode, state.ghostAlpha);
    }
  }

  const visible = lesson.steps[sIdx].strokes.filter(
    (s) => s.kind !== 'CONSTRUCTION' || state.prefs.showConstruction
  );
  if (visible.length > 0) {
    const span = 1 / visible.length;
    let activeTip = null;
    visible.forEach((stroke, idx) => {
      const local = Math.max(0, Math.min(1, (state.stepProgress - idx * span) / span));
      if (local > 0) {
        const tip = renderTutorialStroke(ctx, stroke, bounds, local, !ghostMode, ghostMode, state.ghostAlpha);
        if (tip && local < 1) activeTip = tip;
      }
    });
    if (activeTip && !ghostMode) drawPencilCursor(ctx, activeTip);
  }
}

// ---------------- INTERACTIVE USER DRAWING CANVAS ----------------
function renderUserStrokesCanvas(canvas, strokes, activeStroke, gridStyle, transparentBg) {
  const rect = canvas.getBoundingClientRect();
  if (rect.width < 10) return;
  const dpr = window.devicePixelRatio || 1;
  if (canvas.width !== Math.round(rect.width * dpr) || canvas.height !== Math.round(rect.height * dpr)) {
    canvas.width = Math.round(rect.width * dpr);
    canvas.height = Math.round(rect.height * dpr);
  }
  const ctx = canvas.getContext('2d');
  ctx.setTransform(dpr, 0, 0, dpr, 0, 0);
  const w = rect.width;
  const h = rect.height;

  ctx.clearRect(0, 0, w, h);
  if (!transparentBg) {
    ctx.fillStyle = '#fffdf8';
    ctx.fillRect(0, 0, w, h);
    drawGrid(ctx, w, h, gridStyle);
  }

  const all = activeStroke ? [...strokes, activeStroke] : strokes;
  for (const s of all) {
    if (!s.points.length) continue;
    ctx.save();
    ctx.lineCap = 'round';
    ctx.lineJoin = 'round';
    if (s.tool === 'ERASER') {
      ctx.globalCompositeOperation = transparentBg ? 'destination-out' : 'source-over';
      ctx.strokeStyle = '#fffdf8';
      ctx.fillStyle = '#fffdf8';
      ctx.lineWidth = s.width * 2.5;
    } else if (s.tool === 'MARKER') {
      ctx.globalAlpha = 0.38;
      ctx.strokeStyle = s.color;
      ctx.fillStyle = s.color;
      ctx.lineWidth = s.width * 2.0;
    } else if (s.tool === 'PENCIL') {
      ctx.globalAlpha = 0.82;
      ctx.strokeStyle = s.color;
      ctx.fillStyle = s.color;
      ctx.lineWidth = s.width;
    } else {
      ctx.strokeStyle = s.color;
      ctx.fillStyle = s.color;
      ctx.lineWidth = s.width;
    }

    if (s.points.length === 1) {
      ctx.beginPath();
      ctx.arc(s.points[0].x * w, s.points[0].y * h, ctx.lineWidth / 2, 0, Math.PI * 2);
      ctx.fill();
    } else {
      ctx.beginPath();
      ctx.moveTo(s.points[0].x * w, s.points[0].y * h);
      for (let i = 1; i < s.points.length; i++) {
        const p0 = s.points[i - 1];
        const p1 = s.points[i];
        const mx = ((p0.x + p1.x) / 2) * w;
        const my = ((p0.y + p1.y) / 2) * h;
        ctx.quadraticCurveTo(p0.x * w, p0.y * h, mx, my);
      }
      const last = s.points[s.points.length - 1];
      ctx.lineTo(last.x * w, last.y * h);
      ctx.stroke();
    }
    ctx.restore();
  }
}

function attachDrawingHandlers(canvas, getConfig, onCommit, redrawFn) {
  let drawing = false;
  let active = null;

  const getNormPt = (e) => {
    const r = canvas.getBoundingClientRect();
    return {
      x: Math.max(0, Math.min(1, (e.clientX - r.left) / Math.max(1, r.width))),
      y: Math.max(0, Math.min(1, (e.clientY - r.top) / Math.max(1, r.height)))
    };
  };

  canvas.addEventListener('pointerdown', (e) => {
    e.preventDefault();
    canvas.setPointerCapture(e.pointerId);
    drawing = true;
    const cfg = getConfig();
    active = { points: [getNormPt(e)], tool: cfg.tool, color: cfg.color, width: cfg.width };
    redrawFn(active);
  });

  canvas.addEventListener('pointermove', (e) => {
    if (!drawing || !active) return;
    const pt = getNormPt(e);
    const last = active.points[active.points.length - 1];
    if (Math.abs(pt.x - last.x) > 0.0015 || Math.abs(pt.y - last.y) > 0.0015) {
      active.points.push(pt);
      redrawFn(active);
    }
  });

  const end = () => {
    if (!drawing) return;
    drawing = false;
    if (active && active.points.length > 0) onCommit(active);
    active = null;
    redrawFn(null);
  };

  canvas.addEventListener('pointerup', end);
  canvas.addEventListener('pointercancel', end);
}

function downloadPng(strokes, filename) {
  const size = 1200;
  const off = document.createElement('canvas');
  off.width = size;
  off.height = size;
  const ctx = off.getContext('2d');
  ctx.fillStyle = '#fffdf8';
  ctx.fillRect(0, 0, size, size);

  for (const s of strokes) {
    if (!s.points.length) continue;
    ctx.save();
    ctx.lineCap = 'round';
    ctx.lineJoin = 'round';
    const scale = 2.4;
    if (s.tool === 'ERASER') {
      ctx.strokeStyle = '#fffdf8';
      ctx.fillStyle = '#fffdf8';
      ctx.lineWidth = s.width * 2.5 * scale;
    } else if (s.tool === 'MARKER') {
      ctx.globalAlpha = 0.38;
      ctx.strokeStyle = s.color;
      ctx.fillStyle = s.color;
      ctx.lineWidth = s.width * 2.0 * scale;
    } else if (s.tool === 'PENCIL') {
      ctx.globalAlpha = 0.82;
      ctx.strokeStyle = s.color;
      ctx.fillStyle = s.color;
      ctx.lineWidth = s.width * scale;
    } else {
      ctx.strokeStyle = s.color;
      ctx.fillStyle = s.color;
      ctx.lineWidth = s.width * scale;
    }
    if (s.points.length === 1) {
      ctx.beginPath();
      ctx.arc(s.points[0].x * size, s.points[0].y * size, ctx.lineWidth / 2, 0, Math.PI * 2);
      ctx.fill();
    } else {
      ctx.beginPath();
      ctx.moveTo(s.points[0].x * size, s.points[0].y * size);
      for (let i = 1; i < s.points.length; i++) {
        const p0 = s.points[i - 1], p1 = s.points[i];
        ctx.quadraticCurveTo(p0.x * size, p0.y * size, ((p0.x + p1.x) / 2) * size, ((p0.y + p1.y) / 2) * size);
      }
      const last = s.points[s.points.length - 1];
      ctx.lineTo(last.x * size, last.y * size);
      ctx.stroke();
    }
    ctx.restore();
  }

  const link = document.createElement('a');
  link.download = `${filename.toLowerCase().replace(/[^a-z0-9]+/g, '_')}.png`;
  link.href = off.toDataURL('image/png');
  link.click();
}

// ---------------- STUDIO TOOLBAR BUILDER ----------------
function renderToolbar(containerId, opts) {
  const el = document.getElementById(containerId);
  if (!el) return;
  el.innerHTML = `
    <div class="toolbar-row">
      <div class="tool-group">
        ${BRUSH_TOOLS.map(
          (t) => `<button class="chip-sm ${opts.tool === t.id ? 'active' : ''}" data-tool="${t.id}">${t.label}</button>`
        ).join('')}
      </div>
      <div class="tool-group">
        <button class="icon-btn-sm" data-action="undo" ${opts.canUndo ? '' : 'disabled'} title="Stap terug">↩</button>
        <button class="icon-btn-sm" data-action="redo" ${opts.canRedo ? '' : 'disabled'} title="Opnieuw">↪</button>
        <button class="icon-btn-sm" data-action="clear" ${opts.hasStrokes ? '' : 'disabled'} title="Alles wissen">🗑</button>
        <button class="icon-btn-sm" data-action="download" ${opts.hasStrokes ? '' : 'disabled'} title="Download PNG">⬇️</button>
      </div>
    </div>
    <div class="toolbar-row">
      <div class="swatch-group">
        ${KID_COLORS.map(
          (c) =>
            `<button class="swatch-btn ${opts.tool !== 'ERASER' && opts.color === c.hex ? 'active' : ''}" style="background:${c.hex}" data-color="${c.hex}" aria-label="${c.name}"></button>`
        ).join('')}
      </div>
      <div class="width-group">
        ${BRUSH_WIDTHS.map(
          (w) =>
            `<button class="width-btn ${opts.width === w.size ? 'active' : ''}" data-width="${w.size}" aria-label="${w.label}"><span class="width-dot" style="width:${w.dotPx}px;height:${w.dotPx}px"></span></button>`
        ).join('')}
      </div>
    </div>
  `;

  el.querySelectorAll('[data-tool]').forEach((b) => b.addEventListener('click', () => opts.onTool(b.dataset.tool)));
  el.querySelectorAll('[data-color]').forEach((b) => b.addEventListener('click', () => opts.onColor(b.dataset.color)));
  el.querySelectorAll('[data-width]').forEach((b) =>
    b.addEventListener('click', () => opts.onWidth(Number(b.dataset.width)))
  );
  el.querySelector('[data-action="undo"]')?.addEventListener('click', opts.onUndo);
  el.querySelector('[data-action="redo"]')?.addEventListener('click', opts.onRedo);
  el.querySelector('[data-action="clear"]')?.addEventListener('click', opts.onClear);
  el.querySelector('[data-action="download"]')?.addEventListener('click', opts.onDownload);
}

// ---------------- UI RENDERING & NAVIGATION ----------------
function showTab(tab) {
  state.activeTab = tab;
  document.getElementById('app-nav').classList.toggle('hidden', tab === 'player');
  document.querySelectorAll('.view').forEach((v) => v.classList.remove('active'));
  document.getElementById(`view-${tab}`).classList.add('active');
  document.querySelectorAll('.nav-btn').forEach((b) => b.classList.toggle('active', b.dataset.tab === tab));

  if (tab === 'home') renderHome();
  if (tab === 'path') renderPath();
  if (tab === 'sketchbook') renderSketchbook();
  if (tab === 'player') renderPlayerUi();
}

function renderHome() {
  const completed = state.prefs.completedIds;
  document.getElementById('hero-stars-pill').textContent = `${completed.length} van ${LESSONS.length} sterren verdiend`;

  const resume =
    LESSONS.find((l) => l.id === state.prefs.lastLessonId) ||
    LESSONS.find((l) => !completed.includes(l.id)) ||
    LESSONS[0];
  document.getElementById('hero-eyebrow').textContent = state.prefs.lastLessonId ? 'Ga verder met tekenen' : 'Begin vandaag';
  document.getElementById('hero-lesson-title').textContent = resume.title;
  document.getElementById('hero-start-btn').onclick = () => openLesson(resume.id);

  const q = state.search.trim().toLowerCase();
  const filtered = LESSONS.filter((l) => {
    const catOk = state.category === 'ALL' || l.category === state.category;
    const qOk =
      !q ||
      l.title.toLowerCase().includes(q) ||
      l.subtitle.toLowerCase().includes(q) ||
      l.categoryLabel.toLowerCase().includes(q);
    return catOk && qOk;
  });

  const grid = document.getElementById('lesson-grid');
  const empty = document.getElementById('lesson-empty');
  grid.innerHTML = '';
  empty.classList.toggle('hidden', filtered.length > 0);

  for (const lesson of filtered) {
    const isDone = completed.includes(lesson.id);
    const card = document.createElement('article');
    card.className = `lesson-card ${isDone ? 'completed' : ''}`;
    card.innerHTML = `
      <div class="thumb-wrap">
        <canvas class="thumb-canvas"></canvas>
        <span class="steps-pill">${lesson.steps.length} stappen</span>
        ${isDone ? '<span class="done-badge" title="Voltooid">✓</span>' : ''}
      </div>
      <h3 class="lesson-title">${lesson.title}</h3>
      <p class="lesson-subtitle">${lesson.subtitle}</p>
      <div class="lesson-meta">
        <span class="diff-badge diff-${lesson.difficulty}">${lesson.difficultyLabel}</span>
        <span>⏱ ${lesson.durationMinutes} min</span>
      </div>
    `;
    card.addEventListener('click', () => openLesson(lesson.id));
    grid.appendChild(card);
    requestAnimationFrame(() => renderThumbnailCanvas(card.querySelector('.thumb-canvas'), lesson));
  }
}

function renderPath() {
  const completed = state.prefs.completedIds;
  document.getElementById('path-progress-label').textContent = `${completed.length} / ${LESSONS.length} lessen`;
  document.getElementById('path-progress-fill').style.width = `${(completed.length / LESSONS.length) * 100}%`;

  const nextLesson = LESSONS.find((l) => !completed.includes(l.id));
  const timeline = document.getElementById('path-timeline');
  timeline.innerHTML = '';

  for (const lesson of LESSONS) {
    const isDone = completed.includes(lesson.id);
    const isNext = nextLesson && nextLesson.id === lesson.id;
    const row = document.createElement('div');
    row.className = 'path-node';
    row.innerHTML = `
      <div class="path-num ${isDone ? 'done' : isNext ? 'next' : ''}">${isDone ? '✓' : lesson.pathOrder}</div>
      <div class="path-card ${isNext ? 'next' : ''}">
        <canvas class="path-thumb"></canvas>
        <div class="path-info">
          ${isNext ? '<div class="path-tag">VOLGENDE STAP</div>' : isDone ? '<div class="path-tag done">VOLTOOID</div>' : ''}
          <strong>${lesson.title}</strong>
          <div class="subtitle-sm">${lesson.categoryLabel} • ${lesson.steps.length} stappen • ${lesson.durationMinutes} min</div>
        </div>
        <span>▶</span>
      </div>
    `;
    row.querySelector('.path-card').addEventListener('click', () => openLesson(lesson.id));
    timeline.appendChild(row);
    requestAnimationFrame(() => renderThumbnailCanvas(row.querySelector('.path-thumb'), lesson));
  }
}

function renderSketchbook() {
  document.getElementById('sketch-prompt-text').textContent = KID_PROMPTS[state.promptIdx];
  document.querySelectorAll('#sketch-grid-chips [data-grid]').forEach((b) => {
    b.classList.toggle('active', b.dataset.grid === state.sketchGrid);
  });

  const canvas = document.getElementById('free-sketch-canvas');
  requestAnimationFrame(() => renderUserStrokesCanvas(canvas, state.sketchStrokes, null, state.sketchGrid, false));

  renderToolbar('sketch-toolbar', {
    tool: state.sketchTool,
    color: state.sketchColor,
    width: state.sketchWidth,
    canUndo: state.sketchStrokes.length > 0,
    canRedo: state.sketchRedo.length > 0,
    hasStrokes: state.sketchStrokes.length > 0,
    onTool: (t) => { state.sketchTool = t; renderSketchbook(); },
    onColor: (c) => {
      state.sketchColor = c;
      if (state.sketchTool === 'ERASER') state.sketchTool = 'PENCIL';
      renderSketchbook();
    },
    onWidth: (w) => { state.sketchWidth = w; renderSketchbook(); },
    onUndo: () => {
      if (!state.sketchStrokes.length) return;
      state.sketchRedo.push(state.sketchStrokes.pop());
      renderSketchbook();
    },
    onRedo: () => {
      if (!state.sketchRedo.length) return;
      state.sketchStrokes.push(state.sketchRedo.pop());
      renderSketchbook();
    },
    onClear: () => {
      state.sketchStrokes = [];
      state.sketchRedo = [];
      renderSketchbook();
    },
    onDownload: () => downloadPng(state.sketchStrokes, 'mijn_tekenstap_schets')
  });
}

function openLesson(lessonId) {
  const lesson = LESSONS.find((l) => l.id === lessonId) || LESSONS[0];
  state.lesson = lesson;
  state.stepIndex = 0;
  state.stepProgress = 0;
  state.isPlaying = true;
  state.autoPlayAll = false;
  state.lessonStrokes = [];
  state.lessonRedo = [];
  state.prefs.lastLessonId = lesson.id;
  savePrefs(state.prefs);
  showTab('player');
}

function renderPlayerUi() {
  const lesson = state.lesson;
  const step = lesson.steps[state.stepIndex];
  const total = lesson.steps.length;

  document.getElementById('player-lesson-title').textContent = lesson.title;
  document.getElementById('player-step-badge').textContent = `Stap ${step.stepNumber}/${total}`;
  document.getElementById('instruction-step-pill').textContent = `Stap ${step.stepNumber} van ${total}`;
  document.getElementById('instruction-title').textContent = step.title;
  document.getElementById('instruction-text').textContent = step.instruction;
  document.getElementById('instruction-tip').textContent = `Tip: ${step.tip}`;

  document.getElementById('mode-paper-btn').classList.toggle('active', state.practiceMode === 'ON_PAPER');
  document.getElementById('mode-screen-btn').classList.toggle('active', state.practiceMode === 'ON_SCREEN');

  const drawCanvas = document.getElementById('lesson-draw-canvas');
  const lessonToolbar = document.getElementById('lesson-toolbar');
  const ghostChip = document.getElementById('ghost-chip');
  const isScreen = state.practiceMode === 'ON_SCREEN';

  drawCanvas.classList.toggle('hidden', !isScreen);
  lessonToolbar.classList.toggle('hidden', !isScreen);
  ghostChip.classList.toggle('hidden', !isScreen);

  document.getElementById('play-pause-btn').textContent = state.isPlaying ? '⏸' : '▶';
  document.getElementById('step-scrubber').value = Math.round(state.stepProgress * 100);
  document.getElementById('speed-btn').textContent = `${state.prefs.speed}x`;
  document.getElementById('autoplay-chip').classList.toggle('active', state.autoPlayAll);
  document.getElementById('construction-chip').classList.toggle('active', state.prefs.showConstruction);
  document.getElementById('grid-chip').classList.toggle('active', state.prefs.showGrid);
  ghostChip.classList.toggle('active', state.ghostAlpha > 0.01);
  ghostChip.textContent =
    state.ghostAlpha <= 0.01 ? '👁️ Gids: Uit' : state.ghostAlpha < 0.22 ? '👁️ Gids: Zacht' : '👁️ Gids: Aan';

  const prevBtn = document.getElementById('prev-step-btn');
  const nextBtn = document.getElementById('next-step-btn');
  prevBtn.disabled = state.stepIndex === 0;
  const isLast = state.stepIndex === total - 1;
  nextBtn.textContent = isLast ? 'Klaar! ✓' : 'Volgende →';
  nextBtn.classList.toggle('finish', isLast);

  const dots = document.getElementById('step-dots');
  dots.innerHTML = '';
  for (let i = 0; i < total; i++) {
    const d = document.createElement('button');
    d.className = `step-dot ${i === state.stepIndex ? 'active' : i < state.stepIndex ? 'done' : ''}`;
    d.setAttribute('aria-label', `Ga naar stap ${i + 1}`);
    d.addEventListener('click', () => {
      state.stepIndex = i;
      state.stepProgress = 0;
      state.isPlaying = true;
      renderPlayerUi();
    });
    dots.appendChild(d);
  }

  if (isScreen) {
    renderToolbar('lesson-toolbar', {
      tool: state.lessonTool,
      color: state.lessonColor,
      width: state.lessonWidth,
      canUndo: state.lessonStrokes.length > 0,
      canRedo: state.lessonRedo.length > 0,
      hasStrokes: state.lessonStrokes.length > 0,
      onTool: (t) => { state.lessonTool = t; renderPlayerUi(); },
      onColor: (c) => {
        state.lessonColor = c;
        if (state.lessonTool === 'ERASER') state.lessonTool = 'PENCIL';
        renderPlayerUi();
      },
      onWidth: (w) => { state.lessonWidth = w; renderPlayerUi(); },
      onUndo: () => {
        if (!state.lessonStrokes.length) return;
        state.lessonRedo.push(state.lessonStrokes.pop());
        renderPlayerUi();
      },
      onRedo: () => {
        if (!state.lessonRedo.length) return;
        state.lessonStrokes.push(state.lessonRedo.pop());
        renderPlayerUi();
      },
      onClear: () => {
        state.lessonStrokes = [];
        state.lessonRedo = [];
        renderPlayerUi();
      },
      onDownload: () => downloadPng(state.lessonStrokes, state.lesson.title)
    });
    requestAnimationFrame(() => renderUserStrokesCanvas(drawCanvas, state.lessonStrokes, null, 'NONE', true));
  }

  requestAnimationFrame(renderTutorialFrame);
}

// ---------------- ANIMATION LOOP ----------------
let lastFrameTs = null;
function animationLoop(ts) {
  if (lastFrameTs == null) lastFrameTs = ts;
  const dt = ts - lastFrameTs;
  lastFrameTs = ts;

  if (state.activeTab === 'player' && state.isPlaying) {
    const duration = Math.max(800, 2600 / state.prefs.speed);
    state.stepProgress = Math.min(1, state.stepProgress + dt / duration);
    document.getElementById('step-scrubber').value = Math.round(state.stepProgress * 100);
    renderTutorialFrame();

    if (state.stepProgress >= 1) {
      if (state.autoPlayAll && state.stepIndex < state.lesson.steps.length - 1) {
        state.isPlaying = false;
        setTimeout(() => {
          if (state.activeTab === 'player' && state.autoPlayAll) {
            state.stepIndex += 1;
            state.stepProgress = 0;
            state.isPlaying = true;
            renderPlayerUi();
          }
        }, 700);
      } else {
        state.isPlaying = false;
        document.getElementById('play-pause-btn').textContent = '▶';
      }
    }
  }
  requestAnimationFrame(animationLoop);
}

// ---------------- EVENT LISTENERS & INIT ----------------
function init() {
  document.querySelectorAll('.nav-btn').forEach((btn) => {
    btn.addEventListener('click', () => showTab(btn.dataset.tab));
  });

  document.getElementById('lesson-search').addEventListener('input', (e) => {
    state.search = e.target.value;
    renderHome();
  });

  document.querySelectorAll('#category-chips [data-category]').forEach((btn) => {
    btn.addEventListener('click', () => {
      state.category = btn.dataset.category;
      document.querySelectorAll('#category-chips [data-category]').forEach((b) =>
        b.classList.toggle('active', b.dataset.category === state.category)
      );
      renderHome();
    });
  });

  document.getElementById('tips-toggle').addEventListener('click', () => {
    const body = document.getElementById('tips-body');
    const hidden = body.classList.toggle('hidden');
    document.getElementById('tips-arrow').textContent = hidden ? '▼' : '▲';
  });

  document.querySelectorAll('#sketch-grid-chips [data-grid]').forEach((b) => {
    b.addEventListener('click', () => {
      state.sketchGrid = b.dataset.grid;
      renderSketchbook();
    });
  });

  document.getElementById('next-prompt-btn').addEventListener('click', () => {
    state.promptIdx = (state.promptIdx + 1) % KID_PROMPTS.length;
    document.getElementById('sketch-prompt-text').textContent = KID_PROMPTS[state.promptIdx];
  });

  // Player controls
  document.getElementById('player-back-btn').addEventListener('click', () => {
    window.speechSynthesis?.cancel();
    showTab('home');
  });

  document.getElementById('mode-paper-btn').addEventListener('click', () => {
    state.practiceMode = 'ON_PAPER';
    renderPlayerUi();
  });

  document.getElementById('mode-screen-btn').addEventListener('click', () => {
    state.practiceMode = 'ON_SCREEN';
    renderPlayerUi();
  });

  document.getElementById('play-pause-btn').addEventListener('click', () => {
    if (!state.isPlaying && state.stepProgress >= 0.999) state.stepProgress = 0;
    state.isPlaying = !state.isPlaying;
    document.getElementById('play-pause-btn').textContent = state.isPlaying ? '⏸' : '▶';
  });

  document.getElementById('replay-step-btn').addEventListener('click', () => {
    state.stepProgress = 0;
    state.isPlaying = true;
    renderPlayerUi();
  });

  document.getElementById('step-scrubber').addEventListener('input', (e) => {
    state.isPlaying = false;
    state.stepProgress = Number(e.target.value) / 100;
    document.getElementById('play-pause-btn').textContent = '▶';
    renderTutorialFrame();
  });

  document.getElementById('speed-btn').addEventListener('click', () => {
    const s = state.prefs.speed;
    state.prefs.speed = s < 0.75 ? 1 : s < 1.25 ? 1.5 : 0.5;
    savePrefs(state.prefs);
    renderPlayerUi();
  });

  document.getElementById('autoplay-chip').addEventListener('click', () => {
    state.autoPlayAll = !state.autoPlayAll;
    if (state.autoPlayAll && !state.isPlaying) {
      if (state.stepProgress >= 0.999 && state.stepIndex < state.lesson.steps.length - 1) {
        state.stepIndex += 1;
        state.stepProgress = 0;
      }
      state.isPlaying = true;
    }
    renderPlayerUi();
  });

  document.getElementById('construction-chip').addEventListener('click', () => {
    state.prefs.showConstruction = !state.prefs.showConstruction;
    savePrefs(state.prefs);
    renderPlayerUi();
  });

  document.getElementById('grid-chip').addEventListener('click', () => {
    state.prefs.showGrid = !state.prefs.showGrid;
    savePrefs(state.prefs);
    renderPlayerUi();
  });

  document.getElementById('ghost-chip').addEventListener('click', () => {
    state.ghostAlpha = state.ghostAlpha > 0.22 ? 0.14 : state.ghostAlpha > 0.01 ? 0 : 0.30;
    renderPlayerUi();
  });

  document.getElementById('speak-step-btn').addEventListener('click', () => {
    if (!('speechSynthesis' in window)) return;
    window.speechSynthesis.cancel();
    const step = state.lesson.steps[state.stepIndex];
    const utt = new SpeechSynthesisUtterance(`Stap ${step.stepNumber}. ${step.title}. ${step.instruction}`);
    utt.lang = 'nl-NL';
    window.speechSynthesis.speak(utt);
  });

  document.getElementById('prev-step-btn').addEventListener('click', () => {
    if (state.stepIndex > 0) {
      state.stepIndex -= 1;
      state.stepProgress = 0;
      state.isPlaying = true;
      renderPlayerUi();
    }
  });

  document.getElementById('next-step-btn').addEventListener('click', () => {
    if (state.stepIndex < state.lesson.steps.length - 1) {
      state.stepIndex += 1;
      state.stepProgress = 0;
      state.isPlaying = true;
      renderPlayerUi();
    } else {
      if (!state.prefs.completedIds.includes(state.lesson.id)) {
        state.prefs.completedIds.push(state.lesson.id);
        savePrefs(state.prefs);
      }
      openCompleteModal();
    }
  });

  // Attach interactive pointer drawing handlers
  const freeCanvas = document.getElementById('free-sketch-canvas');
  attachDrawingHandlers(
    freeCanvas,
    () => ({ tool: state.sketchTool, color: state.sketchColor, width: state.sketchWidth }),
    (stroke) => {
      state.sketchStrokes.push(stroke);
      state.sketchRedo = [];
      renderSketchbook();
    },
    (active) => renderUserStrokesCanvas(freeCanvas, state.sketchStrokes, active, state.sketchGrid, false)
  );

  const lessonCanvas = document.getElementById('lesson-draw-canvas');
  attachDrawingHandlers(
    lessonCanvas,
    () => ({ tool: state.lessonTool, color: state.lessonColor, width: state.lessonWidth }),
    (stroke) => {
      state.lessonStrokes.push(stroke);
      state.lessonRedo = [];
      renderPlayerUi();
    },
    (active) => renderUserStrokesCanvas(lessonCanvas, state.lessonStrokes, active, 'NONE', true)
  );

  window.addEventListener('resize', () => {
    if (state.activeTab === 'player') {
      renderTutorialFrame();
      if (state.practiceMode === 'ON_SCREEN') {
        renderUserStrokesCanvas(lessonCanvas, state.lessonStrokes, null, 'NONE', true);
      }
    } else if (state.activeTab === 'sketchbook') {
      renderUserStrokesCanvas(freeCanvas, state.sketchStrokes, null, state.sketchGrid, false);
    }
  });

  renderHome();
  requestAnimationFrame(animationLoop);
}

function openCompleteModal() {
  const modal = document.getElementById('complete-modal');
  const next = LESSONS.find((l) => l.pathOrder === state.lesson.pathOrder + 1);
  document.getElementById('complete-modal-text').textContent =
    `Je hebt '${state.lesson.title}' helemaal afgetekend en een nieuwe ster verdiend!`;

  const shareBtn = document.getElementById('modal-share-btn');
  shareBtn.classList.toggle('hidden', state.lessonStrokes.length === 0);
  shareBtn.onclick = () => downloadPng(state.lessonStrokes, state.lesson.title);

  const nextBtn = document.getElementById('modal-next-btn');
  if (next) {
    nextBtn.textContent = `Volgende: ${next.title}`;
    nextBtn.onclick = () => {
      modal.classList.add('hidden');
      openLesson(next.id);
    };
  } else {
    nextBtn.textContent = 'Terug naar lessen';
    nextBtn.onclick = () => {
      modal.classList.add('hidden');
      showTab('home');
    };
  }

  document.getElementById('modal-home-btn').onclick = () => {
    modal.classList.add('hidden');
    showTab('home');
  };

  modal.classList.remove('hidden');
}

init();
