// TekenStap — Alle 10 Nederlandse tekenlessen voor kinderen
export const LESSONS = [
  {
    id: 'kubus_3d',
    title: '3D Kubus & Schaduw',
    subtitle: 'Leer diepte en schaduw tekenen vanuit een simpel vierkant.',
    category: 'BASIS',
    categoryLabel: 'Basis',
    difficulty: 'MAKKELIJK',
    difficultyLabel: 'Makkelijk',
    durationMinutes: 5,
    pathOrder: 1,
    accentHex: '#d0552b',
    steps: [
      {
        stepNumber: 1,
        title: 'Het voorste vierkant',
        instruction: 'Teken eerst een recht vierkant iets linksonder het midden. Dit wordt de voorkant van je kubus.',
        tip: 'Gebruik losse polsbewegingen. Je hebt geen liniaal nodig!',
        strokes: [
          { kind: 'CONSTRUCTION', cmds: [['M', 0.22, 0.56], ['L', 0.64, 0.56], ['M', 0.43, 0.35], ['L', 0.43, 0.77]] },
          { kind: 'OUTLINE', cmds: [['M', 0.25, 0.38], ['L', 0.61, 0.38], ['L', 0.61, 0.74], ['L', 0.25, 0.74], ['L', 0.25, 0.38]] }
        ]
      },
      {
        stepNumber: 2,
        title: 'Dieptelijnen naar achteren',
        instruction: 'Trek vanuit drie hoeken drie schuine lijnen precies dezelfde kant op naar rechtsboven.',
        tip: 'Let op dat alle drie de lijnen even lang en schuin zijn.',
        strokes: [
          { kind: 'OUTLINE', cmds: [['M', 0.25, 0.38], ['L', 0.42, 0.23]] },
          { kind: 'OUTLINE', cmds: [['M', 0.61, 0.38], ['L', 0.78, 0.23]] },
          { kind: 'OUTLINE', cmds: [['M', 0.61, 0.74], ['L', 0.78, 0.59]] }
        ]
      },
      {
        stepNumber: 3,
        title: 'De achterkant sluiten',
        instruction: 'Verbind de uiteinden van je schuine lijnen met een liggende lijn boven en een staande lijn rechts.',
        tip: 'Kijk goed of de lijnen netjes recht blijven!',
        strokes: [
          { kind: 'OUTLINE', cmds: [['M', 0.42, 0.23], ['L', 0.78, 0.23], ['L', 0.78, 0.59]] }
        ]
      },
      {
        stepNumber: 4,
        title: 'Tafellijn & hulpribben',
        instruction: 'Zet een tafellijn achter de kubus zodat hij stevig op een tafel staat.',
        tip: 'De lichtblauwe lijntjes laten zien hoe de achterkant eruit zou zien als de kubus van glas was.',
        strokes: [
          { kind: 'CONSTRUCTION', cmds: [['M', 0.42, 0.23], ['L', 0.42, 0.59], ['L', 0.78, 0.59], ['M', 0.25, 0.74], ['L', 0.42, 0.59]] },
          { kind: 'DETAIL', cmds: [['M', 0.12, 0.70], ['L', 0.25, 0.70], ['M', 0.72, 0.70], ['L', 0.88, 0.70]] }
        ]
      },
      {
        stepNumber: 5,
        title: 'Schaduw arceren',
        instruction: 'Stel dat de zon linksboven schijnt: kras schuine schaduwstreepjes op de rechterkant en op de tafel.',
        tip: 'Zet schuine potloodstreepjes dicht naast elkaar!',
        strokes: [
          { kind: 'SHADING', cmds: [['M', 0.64, 0.42], ['L', 0.75, 0.31], ['M', 0.64, 0.50], ['L', 0.75, 0.39], ['M', 0.64, 0.58], ['L', 0.75, 0.47], ['M', 0.64, 0.66], ['L', 0.75, 0.55]] },
          { kind: 'SHADING', cmds: [['M', 0.62, 0.74], ['L', 0.86, 0.74], ['M', 0.66, 0.71], ['L', 0.84, 0.71], ['M', 0.70, 0.68], ['L', 0.82, 0.68]] }
        ]
      }
    ]
  },
  {
    id: 'slapende_kat',
    title: 'Slapende Kat',
    subtitle: 'Een knusse opgerolde kat van zachte ovalen en vloeiende lijnen.',
    category: 'DIEREN',
    categoryLabel: 'Dieren',
    difficulty: 'MAKKELIJK',
    difficultyLabel: 'Makkelijk',
    durationMinutes: 6,
    pathOrder: 2,
    accentHex: '#d69a2d',
    steps: [
      {
        stepNumber: 1,
        title: 'Cirkel voor kop en ovaal voor lijf',
        instruction: 'Teken links een cirkel voor het kopje en rechts daarnaast een groter liggend ei voor het lijfje.',
        tip: 'Laat de cirkel en het ei elkaar een klein stukje raken.',
        strokes: [
          { kind: 'CONSTRUCTION', cmds: [['circle', 0.32, 0.52, 0.13], ['oval', 0.55, 0.58, 0.24, 0.16]] }
        ]
      },
      {
        stepNumber: 2,
        title: 'Kopje en puntige oortjes',
        instruction: 'Teken de ronde lijn van het hoofdje met twee driehoekige kattenoren bovenop.',
        tip: 'Maak de oorpuntjes een beetje rond, dat kijkt lief!',
        strokes: [
          { kind: 'OUTLINE', cmds: [['M', 0.22, 0.44], ['L', 0.20, 0.31], ['Q', 0.26, 0.35, 0.30, 0.39], ['Q', 0.34, 0.39, 0.37, 0.39], ['Q', 0.41, 0.34, 0.44, 0.31], ['L', 0.44, 0.46], ['C', 0.46, 0.58, 0.40, 0.65, 0.32, 0.65], ['C', 0.22, 0.65, 0.18, 0.55, 0.22, 0.44]] }
        ]
      },
      {
        stepNumber: 3,
        title: 'De ronde rug',
        instruction: 'Trek een grote, ontspannen boog vanaf de nek over het ruggetje naar de onderkant.',
        tip: 'Volg gewoon je blauwe hulplijn van het grote ei.',
        strokes: [
          { kind: 'OUTLINE', cmds: [['M', 0.44, 0.46], ['C', 0.56, 0.39, 0.78, 0.43, 0.79, 0.58], ['C', 0.79, 0.71, 0.64, 0.75, 0.42, 0.74]] }
        ]
      },
      {
        stepNumber: 4,
        title: 'Krulstaart en pootje',
        instruction: 'Teken een zachte krulstaart die om het lijfje ligt en een klein pootje onder de kin.',
        tip: 'Maak de staart lekker dik en pluizig!',
        strokes: [
          { kind: 'OUTLINE', cmds: [['M', 0.75, 0.67], ['C', 0.84, 0.75, 0.68, 0.84, 0.48, 0.80], ['C', 0.42, 0.79, 0.43, 0.73, 0.50, 0.73], ['C', 0.62, 0.74, 0.72, 0.71, 0.72, 0.66]] },
          { kind: 'OUTLINE', cmds: [['M', 0.25, 0.63], ['C', 0.18, 0.66, 0.18, 0.73, 0.28, 0.73], ['L', 0.39, 0.73]] }
        ]
      },
      {
        stepNumber: 5,
        title: 'Slapende oogjes & snorharen',
        instruction: 'Teken twee boogjes voor de gesloten oogjes, een piepklein neusje en drie snorharen links en rechts.',
        tip: 'Snorharen mogen lekker zwieren!',
        strokes: [
          { kind: 'DETAIL', cmds: [['arc', 0.27, 0.50, 0.03, 0.025, 15, 150], ['arc', 0.37, 0.50, 0.03, 0.025, 15, 150], ['M', 0.31, 0.54], ['L', 0.33, 0.54], ['L', 0.32, 0.56], ['L', 0.31, 0.54], ['M', 0.24, 0.54], ['L', 0.14, 0.52], ['M', 0.24, 0.57], ['L', 0.14, 0.58], ['M', 0.40, 0.54], ['L', 0.49, 0.52], ['M', 0.40, 0.57], ['L', 0.49, 0.58]] }
        ]
      },
      {
        stepNumber: 6,
        title: 'Binnenoren & streepjes',
        instruction: 'Teken kleine driehoekjes in de oren en drie zachte tijgerstreepjes op de rug.',
        tip: 'Je slapende poes is helemaal af — goed gedaan!',
        strokes: [
          { kind: 'SHADING', cmds: [['M', 0.23, 0.41], ['L', 0.22, 0.35], ['L', 0.27, 0.39], ['M', 0.39, 0.40], ['L', 0.42, 0.35], ['L', 0.42, 0.42], ['M', 0.55, 0.44], ['Q', 0.56, 0.50, 0.54, 0.54], ['M', 0.62, 0.45], ['Q', 0.63, 0.51, 0.61, 0.55], ['M', 0.69, 0.47], ['Q', 0.69, 0.53, 0.67, 0.57]] }
        ]
      }
    ]
  },
  {
    id: 'tulp_vaas',
    title: 'Tulp in een Vaas',
    subtitle: 'Oefen mooie bloemblaadjes en een symmetrische vaas in 5 stappen.',
    category: 'NATUUR',
    categoryLabel: 'Natuur',
    difficulty: 'MAKKELIJK',
    difficultyLabel: 'Makkelijk',
    durationMinutes: 6,
    pathOrder: 3,
    accentHex: '#477856',
    steps: [
      {
        stepNumber: 1,
        title: 'Middenlijn en vaasvorm',
        instruction: 'Teken een rechte lijn van boven naar beneden in het midden, met onderaan een cirkel voor de vaas.',
        tip: 'Met een middenlijn worden links en rechts mooi hetzelfde!',
        strokes: [
          { kind: 'CONSTRUCTION', cmds: [['M', 0.50, 0.14], ['L', 0.50, 0.86], ['oval', 0.50, 0.70, 0.14, 0.13]] }
        ]
      },
      {
        stepNumber: 2,
        title: 'De contouren van de vaas',
        instruction: 'Teken een plat rondje voor de opening en buig twee S-lijnen naar de platte bodem.',
        tip: 'Kijk om de beurt links en rechts van de middenlijn.',
        strokes: [
          { kind: 'OUTLINE', cmds: [['oval', 0.50, 0.53, 0.075, 0.024], ['M', 0.425, 0.53], ['C', 0.43, 0.59, 0.35, 0.64, 0.36, 0.73], ['C', 0.37, 0.81, 0.42, 0.84, 0.50, 0.84], ['C', 0.58, 0.84, 0.63, 0.81, 0.64, 0.73], ['C', 0.65, 0.64, 0.57, 0.59, 0.575, 0.53]] }
        ]
      },
      {
        stepNumber: 3,
        title: 'Steel en lange bladeren',
        instruction: 'Laat een stevige steel omhoog groeien en teken twee spitse tulpenbladeren.',
        tip: 'Een klein boogje in de steel maakt de bloem lekker levendig.',
        strokes: [
          { kind: 'OUTLINE', cmds: [['M', 0.49, 0.54], ['Q', 0.48, 0.42, 0.50, 0.34], ['M', 0.51, 0.54], ['Q', 0.50, 0.42, 0.52, 0.34], ['M', 0.49, 0.53], ['C', 0.39, 0.49, 0.33, 0.39, 0.35, 0.32], ['C', 0.41, 0.37, 0.46, 0.44, 0.49, 0.51], ['M', 0.52, 0.53], ['C', 0.62, 0.50, 0.68, 0.41, 0.65, 0.34], ['C', 0.59, 0.39, 0.54, 0.45, 0.51, 0.51]] }
        ]
      },
      {
        stepNumber: 4,
        title: 'De tulp tekenen',
        instruction: 'Teken een dikke U-vorm en maak bovenaan de puntige bloemblaadjes van de tulp.',
        tip: 'Laat de puntjes iets naar elkaar toe buigen.',
        strokes: [
          { kind: 'OUTLINE', cmds: [['M', 0.51, 0.35], ['C', 0.39, 0.34, 0.38, 0.21, 0.44, 0.16], ['Q', 0.48, 0.20, 0.51, 0.23], ['Q', 0.54, 0.20, 0.58, 0.16], ['C', 0.64, 0.21, 0.63, 0.34, 0.51, 0.35], ['M', 0.46, 0.18], ['Q', 0.51, 0.12, 0.56, 0.18]] }
        ]
      },
      {
        stepNumber: 5,
        title: 'Waterlijn, glans & nerfjes',
        instruction: 'Teken een waterlijntje in de vaas, een glansstreep op de bolling en nerfjes in de bladeren.',
        tip: 'Wat een prachtige lente-tekening!',
        strokes: [
          { kind: 'DETAIL', cmds: [['M', 0.38, 0.65], ['Q', 0.50, 0.67, 0.62, 0.65], ['M', 0.49, 0.54], ['L', 0.49, 0.76], ['M', 0.40, 0.39], ['Q', 0.44, 0.44, 0.47, 0.49], ['M', 0.61, 0.40], ['Q', 0.57, 0.45, 0.53, 0.49]] },
          { kind: 'SHADING', cmds: [['M', 0.40, 0.69], ['C', 0.39, 0.74, 0.41, 0.79, 0.44, 0.81], ['M', 0.58, 0.72], ['L', 0.61, 0.69], ['M', 0.57, 0.76], ['L', 0.61, 0.73]] }
        ]
      }
    ]
  },
  {
    id: 'kopje_koffie',
    title: 'Warme Chocomel',
    subtitle: 'Teken een grote gezellige mok met warme chocolademelk en stoom.',
    category: 'DINGEN',
    categoryLabel: 'Dingen',
    difficulty: 'MAKKELIJK',
    difficultyLabel: 'Makkelijk',
    durationMinutes: 5,
    pathOrder: 4,
    accentHex: '#8c4a27',
    steps: [
      {
        stepNumber: 1,
        title: 'Twee liggende ovalen',
        instruction: 'Teken in het midden een plat rondje voor de bovenkant van de mok, en onderaan een groter plat rondje voor het schoteltje.',
        tip: 'Maak de zijkanten mooi rond, niet puntig!',
        strokes: [
          { kind: 'CONSTRUCTION', cmds: [['oval', 0.46, 0.46, 0.21, 0.065], ['oval', 0.46, 0.74, 0.29, 0.08]] }
        ]
      },
      {
        stepNumber: 2,
        title: 'De vorm van de mok',
        instruction: 'Trek de bovenrand netjes over en teken twee bolle zijkanten naar beneden.',
        tip: 'Zo wordt het een lekkere dikke chocomel-mok!',
        strokes: [
          { kind: 'OUTLINE', cmds: [['oval', 0.46, 0.46, 0.21, 0.065], ['M', 0.25, 0.46], ['C', 0.25, 0.66, 0.34, 0.75, 0.46, 0.75], ['C', 0.58, 0.75, 0.67, 0.66, 0.67, 0.46]] }
        ]
      },
      {
        stepNumber: 3,
        title: 'Het oortje & het schoteltje',
        instruction: 'Teken rechts een groot oor om vast te houden en maak het schoteltje onder de mok af.',
        tip: 'Stop het schoteltje achter de mok zodat de mok ervoor staat.',
        strokes: [
          { kind: 'OUTLINE', cmds: [['M', 0.66, 0.50], ['C', 0.79, 0.48, 0.79, 0.66, 0.63, 0.66], ['M', 0.66, 0.54], ['C', 0.74, 0.53, 0.74, 0.62, 0.64, 0.62], ['M', 0.27, 0.69], ['C', 0.14, 0.72, 0.15, 0.82, 0.46, 0.82], ['C', 0.77, 0.82, 0.78, 0.72, 0.65, 0.69]] }
        ]
      },
      {
        stepNumber: 4,
        title: 'Chocomel & stoomkrullen',
        instruction: 'Teken een boogje voor de chocomel in de mok en laat twee vrolijke stoomslingers omhoog kringelen.',
        tip: 'Wiebel je potlood als een slangetje voor de stoom!',
        strokes: [
          { kind: 'DETAIL', cmds: [['M', 0.28, 0.48], ['Q', 0.46, 0.43, 0.64, 0.48], ['M', 0.39, 0.36], ['C', 0.35, 0.30, 0.44, 0.25, 0.39, 0.18], ['M', 0.51, 0.35], ['C', 0.47, 0.28, 0.57, 0.23, 0.52, 0.15]] }
        ]
      },
      {
        stepNumber: 5,
        title: 'Glans & schaduw',
        instruction: 'Zet een glansstreepje op de voorkant en een klein schaduwlijntje onder het schoteltje.',
        tip: 'Super! Misschien kun je er nog marshmallows bij tekenen!',
        strokes: [
          { kind: 'SHADING', cmds: [['M', 0.31, 0.56], ['Q', 0.32, 0.65, 0.37, 0.70], ['M', 0.30, 0.84], ['L', 0.68, 0.84], ['M', 0.36, 0.865], ['L', 0.64, 0.865]] }
        ]
      }
    ]
  },
  {
    id: 'vrolijke_pinguin',
    title: 'Schattige Pinguïn',
    subtitle: 'Begin met een simpele eivorm en bouw een lieve pinguïn met sjaal.',
    category: 'DIEREN',
    categoryLabel: 'Dieren',
    difficulty: 'MAKKELIJK',
    difficultyLabel: 'Makkelijk',
    durationMinutes: 7,
    pathOrder: 5,
    accentHex: '#3b6e8c',
    steps: [
      {
        stepNumber: 1,
        title: 'Eivorm & kruishulplijn',
        instruction: 'Teken een groot staand ei in het midden en zet er een kruis doorheen voor het gezicht.',
        tip: 'De oogjes komen straks net boven de liggende lijn.',
        strokes: [
          { kind: 'CONSTRUCTION', cmds: [['oval', 0.50, 0.54, 0.22, 0.27], ['M', 0.50, 0.24], ['L', 0.50, 0.84], ['M', 0.28, 0.41], ['L', 0.72, 0.41]] }
        ]
      },
      {
        stepNumber: 2,
        title: 'Kopje en mollig lijfje',
        instruction: 'Teken een vloeiende buitenlijn met een iets smaller nekje en een lekker rond buikje.',
        tip: 'Ronde vormen maken dieren meteen extra lief.',
        strokes: [
          { kind: 'OUTLINE', cmds: [['M', 0.50, 0.26], ['C', 0.35, 0.26, 0.32, 0.37, 0.35, 0.45], ['C', 0.28, 0.56, 0.29, 0.78, 0.50, 0.79], ['C', 0.71, 0.78, 0.72, 0.56, 0.65, 0.45], ['C', 0.68, 0.37, 0.65, 0.26, 0.50, 0.26]] }
        ]
      },
      {
        stepNumber: 3,
        title: 'Het witte buikvlak',
        instruction: 'Teken twee boogjes boven de ogen die als een hartje langs de buik naar beneden lopen.',
        tip: 'Zo ontstaat het bekende pinguïn-maskertje!',
        strokes: [
          { kind: 'OUTLINE', cmds: [['M', 0.50, 0.33], ['C', 0.43, 0.30, 0.37, 0.36, 0.39, 0.45], ['C', 0.34, 0.57, 0.36, 0.73, 0.50, 0.74], ['C', 0.64, 0.73, 0.66, 0.57, 0.61, 0.45], ['C', 0.63, 0.36, 0.57, 0.30, 0.50, 0.33]] }
        ]
      },
      {
        stepNumber: 4,
        title: 'Vleugeltjes en voetjes',
        instruction: 'Teken aan beide kanten een vrolijk vleugeltje en onderaan twee kleine pootjes.',
        tip: 'Laat de vleugels een beetje zwaaien!',
        strokes: [
          { kind: 'OUTLINE', cmds: [['M', 0.33, 0.48], ['C', 0.22, 0.51, 0.20, 0.62, 0.26, 0.64], ['Q', 0.29, 0.62, 0.30, 0.58], ['M', 0.67, 0.48], ['C', 0.78, 0.51, 0.80, 0.62, 0.74, 0.64], ['Q', 0.71, 0.62, 0.70, 0.58], ['M', 0.38, 0.78], ['C', 0.33, 0.84, 0.42, 0.86, 0.47, 0.80], ['M', 0.53, 0.80], ['C', 0.58, 0.86, 0.67, 0.84, 0.62, 0.78]] }
        ]
      },
      {
        stepNumber: 5,
        title: 'Oogjes en snavel',
        instruction: 'Zet twee ronde kraaloogjes links en rechts, en daartussen een driehoekig snaveltje.',
        tip: 'Een klein neusje maakt hem helemaal blij.',
        strokes: [
          { kind: 'DETAIL', cmds: [['circle', 0.43, 0.39, 0.022], ['circle', 0.57, 0.39, 0.022], ['M', 0.46, 0.41], ['Q', 0.50, 0.39, 0.54, 0.41], ['Q', 0.50, 0.46, 0.46, 0.41]] }
        ]
      },
      {
        stepNumber: 6,
        title: 'Winterse sjaal & schaduw',
        instruction: 'Teken een warme sjaal om het nekje en zet een schaduwlijntje onder de voetjes.',
        tip: 'Knap gedaan! Geef de sjaal straks jouw lievelingskleur.',
        strokes: [
          { kind: 'DETAIL', cmds: [['M', 0.35, 0.46], ['Q', 0.50, 0.50, 0.65, 0.46], ['L', 0.65, 0.51], ['Q', 0.50, 0.55, 0.35, 0.51], ['L', 0.35, 0.46], ['M', 0.56, 0.52], ['L', 0.58, 0.64], ['L', 0.64, 0.62], ['L', 0.62, 0.51]] },
          { kind: 'SHADING', cmds: [['M', 0.33, 0.86], ['L', 0.67, 0.86]] }
        ]
      }
    ]
  },
  {
    id: 'simpel_portret',
    title: 'Portret met Hulplijnen',
    subtitle: 'Ontdek waar de ogen, neus en mond horen bij een gezicht.',
    category: 'GEZICHTEN',
    categoryLabel: 'Gezichten',
    difficulty: 'GEMIDDELD',
    difficultyLabel: 'Gemiddeld',
    durationMinutes: 8,
    pathOrder: 6,
    accentHex: '#d0552b',
    steps: [
      {
        stepNumber: 1,
        title: 'Ei-vorm & verhoudingslijnen',
        instruction: 'Teken een ovaal en zet de ooglijn precies in het midden (halverwege het hoofd!).',
        tip: 'Veel mensen tekenen de ogen te hoog, maar halverwege klopt precies!',
        strokes: [
          { kind: 'CONSTRUCTION', cmds: [['oval', 0.50, 0.47, 0.20, 0.26], ['M', 0.50, 0.18], ['L', 0.50, 0.76], ['M', 0.28, 0.47], ['L', 0.72, 0.47], ['M', 0.36, 0.59], ['L', 0.64, 0.59], ['M', 0.39, 0.66], ['L', 0.61, 0.66]] }
        ]
      },
      {
        stepNumber: 2,
        title: 'Kaaklijn en nek',
        instruction: 'Teken de zachte kin en twee licht gebogen lijnen voor de nek.',
        tip: 'Maak de kin mooi zacht en rond.',
        strokes: [
          { kind: 'OUTLINE', cmds: [['M', 0.30, 0.45], ['C', 0.30, 0.62, 0.40, 0.73, 0.50, 0.74], ['C', 0.60, 0.73, 0.70, 0.62, 0.70, 0.45], ['M', 0.41, 0.71], ['Q', 0.41, 0.80, 0.37, 0.85], ['M', 0.59, 0.71], ['Q', 0.59, 0.80, 0.63, 0.85]] }
        ]
      },
      {
        stepNumber: 3,
        title: 'Oren en wenkbrauwen',
        instruction: 'Teken de oren tussen de ooglijn en de neuslijn, en twee boogjes voor de wenkbrauwen.',
        tip: 'Tussen de twee ogen past ongeveer één extra oog!',
        strokes: [
          { kind: 'OUTLINE', cmds: [['M', 0.30, 0.47], ['C', 0.25, 0.47, 0.25, 0.59, 0.31, 0.59], ['M', 0.70, 0.47], ['C', 0.75, 0.47, 0.75, 0.59, 0.69, 0.59], ['M', 0.36, 0.42], ['Q', 0.41, 0.39, 0.46, 0.41], ['M', 0.54, 0.41], ['Q', 0.59, 0.39, 0.64, 0.42]] }
        ]
      },
      {
        stepNumber: 4,
        title: 'Ogen, neus en glimlach',
        instruction: 'Teken de oogjes op de middenlijn, een simpel neusje en een vriendelijke lach.',
        tip: 'Een simpele neus ziet er meteen heel mooi uit!',
        strokes: [
          { kind: 'DETAIL', cmds: [['M', 0.37, 0.47], ['Q', 0.41, 0.44, 0.45, 0.47], ['Q', 0.41, 0.50, 0.37, 0.47], ['circle', 0.41, 0.47, 0.015], ['M', 0.55, 0.47], ['Q', 0.59, 0.44, 0.63, 0.47], ['Q', 0.59, 0.50, 0.55, 0.47], ['circle', 0.59, 0.47, 0.015], ['M', 0.49, 0.49], ['Q', 0.47, 0.57, 0.50, 0.59], ['Q', 0.52, 0.595, 0.53, 0.58], ['M', 0.44, 0.65], ['Q', 0.50, 0.68, 0.56, 0.65], ['M', 0.47, 0.685], ['Q', 0.50, 0.695, 0.53, 0.685]] }
        ]
      },
      {
        stepNumber: 5,
        title: 'Kapsel met volume',
        instruction: 'Teken het haar iets boven de schedel langs zodat het lekker luchtig zit.',
        tip: 'Teken het haar als één grote vorm, niet elk haartje los.',
        strokes: [
          { kind: 'OUTLINE', cmds: [['M', 0.29, 0.45], ['C', 0.25, 0.30, 0.36, 0.16, 0.52, 0.17], ['C', 0.68, 0.18, 0.75, 0.31, 0.71, 0.46], ['M', 0.30, 0.37], ['C', 0.38, 0.34, 0.46, 0.28, 0.50, 0.25], ['C', 0.56, 0.31, 0.64, 0.35, 0.70, 0.39]] }
        ]
      },
      {
        stepNumber: 6,
        title: 'Kraagje & nekschaduw',
        instruction: 'Teken een T-shirtkraagje onderaan en een klein schaduwlijntje onder de kin.',
        tip: 'Wauw, een echt portret getekend!',
        strokes: [
          { kind: 'DETAIL', cmds: [['M', 0.37, 0.84], ['Q', 0.50, 0.90, 0.63, 0.84]] },
          { kind: 'SHADING', cmds: [['M', 0.44, 0.75], ['L', 0.55, 0.74], ['M', 0.45, 0.775], ['L', 0.53, 0.765]] }
        ]
      }
    ]
  },
  {
    id: 'vrolijke_hond',
    title: 'Vrolijke Puppy',
    subtitle: 'Teken een lieve zittende puppy met flaporen en een kwispelstaart.',
    category: 'DIEREN',
    categoryLabel: 'Dieren',
    difficulty: 'GEMIDDELD',
    difficultyLabel: 'Gemiddeld',
    durationMinutes: 8,
    pathOrder: 7,
    accentHex: '#d69a2d',
    steps: [
      {
        stepNumber: 1,
        title: 'Kopje, snuit en lijf',
        instruction: 'Begin met een cirkel voor de kop, een klein ovaal voor de snuit en een groter ei voor het lijf.',
        tip: 'Met deze drie rondjes staat je hondje meteen goed!',
        strokes: [
          { kind: 'CONSTRUCTION', cmds: [['circle', 0.44, 0.34, 0.14], ['oval', 0.41, 0.40, 0.08, 0.055], ['oval', 0.53, 0.63, 0.15, 0.18]] }
        ]
      },
      {
        stepNumber: 2,
        title: 'Kop en hangende flaporen',
        instruction: 'Teken de ronde kop en twee lekkere lange flaporen die naar beneden hangen.',
        tip: 'Maak de oren lekker zacht en rond onderaan.',
        strokes: [
          { kind: 'OUTLINE', cmds: [['M', 0.32, 0.28], ['C', 0.36, 0.18, 0.52, 0.18, 0.56, 0.28], ['M', 0.32, 0.28], ['C', 0.24, 0.34, 0.22, 0.47, 0.28, 0.48], ['C', 0.33, 0.48, 0.34, 0.39, 0.33, 0.34], ['M', 0.56, 0.28], ['C', 0.64, 0.33, 0.65, 0.47, 0.59, 0.48], ['C', 0.54, 0.48, 0.54, 0.38, 0.55, 0.33], ['M', 0.33, 0.42], ['Q', 0.44, 0.50, 0.55, 0.42]] }
        ]
      },
      {
        stepNumber: 3,
        title: 'Rug en voorpootjes',
        instruction: 'Teken de gebogen rug naar beneden en twee rechte voorpootjes met zachte voetjes.',
        tip: 'De pootjes staan stevig op de grond.',
        strokes: [
          { kind: 'OUTLINE', cmds: [['M', 0.55, 0.46], ['C', 0.66, 0.52, 0.70, 0.68, 0.66, 0.79], ['M', 0.39, 0.47], ['L', 0.39, 0.78], ['C', 0.39, 0.82, 0.46, 0.82, 0.46, 0.78], ['L', 0.46, 0.58], ['M', 0.50, 0.58], ['L', 0.50, 0.78], ['C', 0.50, 0.82, 0.57, 0.82, 0.57, 0.78], ['L', 0.56, 0.56]] }
        ]
      },
      {
        stepNumber: 4,
        title: 'Achterpoot & kwispelstaart',
        instruction: 'Teken de gebogen achterpoot rechtsonder en een vrolijk omhoog gekruld staartje.',
        tip: 'Zometeen zetten we beweegstreepjes bij de staart!',
        strokes: [
          { kind: 'OUTLINE', cmds: [['M', 0.57, 0.79], ['L', 0.68, 0.79], ['C', 0.71, 0.74, 0.66, 0.67, 0.60, 0.69], ['M', 0.68, 0.72], ['C', 0.77, 0.68, 0.80, 0.57, 0.74, 0.54], ['Q', 0.70, 0.58, 0.68, 0.66]] }
        ]
      },
      {
        stepNumber: 5,
        title: 'Oogjes, snuit & blije tong',
        instruction: 'Teken twee vrolijke kraaloogjes, een honden-neus en een schattige blije tong.',
        tip: 'Kleine oogjes dicht bij de neus geven een echte puppy-snoet!',
        strokes: [
          { kind: 'DETAIL', cmds: [['circle', 0.39, 0.32, 0.020], ['circle', 0.49, 0.32, 0.020], ['oval', 0.44, 0.37, 0.026, 0.017], ['M', 0.44, 0.387], ['L', 0.44, 0.415], ['M', 0.39, 0.41], ['Q', 0.44, 0.44, 0.49, 0.41], ['M', 0.43, 0.425], ['C', 0.42, 0.46, 0.46, 0.46, 0.455, 0.425]] }
        ]
      },
      {
        stepNumber: 6,
        title: 'Halsband & penning',
        instruction: 'Geef je puppy een halsband met een rond penningkje en kwispelstreepjes bij de staart.',
        tip: 'Super! Je puppy is klaar om te spelen.',
        strokes: [
          { kind: 'DETAIL', cmds: [['M', 0.36, 0.46], ['Q', 0.45, 0.51, 0.55, 0.46], ['M', 0.37, 0.49], ['Q', 0.45, 0.54, 0.55, 0.49], ['circle', 0.45, 0.535, 0.020], ['M', 0.79, 0.56], ['Q', 0.82, 0.59, 0.80, 0.63]] },
          { kind: 'SHADING', cmds: [['M', 0.34, 0.82], ['L', 0.71, 0.82]] }
        ]
      }
    ]
  },
  {
    id: 'berglandschap',
    title: 'Berglandschap',
    subtitle: 'Teken bergtoppen, dennenbomen, wolkjes en een glinsterend meer.',
    category: 'NATUUR',
    categoryLabel: 'Natuur',
    difficulty: 'GEMIDDELD',
    difficultyLabel: 'Gemiddeld',
    durationMinutes: 7,
    pathOrder: 8,
    accentHex: '#477856',
    steps: [
      {
        stepNumber: 1,
        title: 'Kader en horizonlijn',
        instruction: 'Teken een rechthoekig kader als een schilderijtje, en een lijn onder het midden voor het meer.',
        tip: 'Met een lijstje lijkt je tekening net een ansichtkaart!',
        strokes: [
          { kind: 'CONSTRUCTION', cmds: [['M', 0.14, 0.18], ['L', 0.86, 0.18], ['L', 0.86, 0.82], ['L', 0.14, 0.82], ['L', 0.14, 0.18], ['M', 0.14, 0.58], ['L', 0.86, 0.58]] }
        ]
      },
      {
        stepNumber: 2,
        title: 'De grote bergtoppen',
        instruction: 'Teken drie hoge driehoekige bergen met karteltjes en een lijn van de top naar beneden.',
        tip: 'Bergen hoeven niet kaarsrecht — hobbelige lijntjes lijken juist echt op rotsen!',
        strokes: [
          { kind: 'OUTLINE', cmds: [['M', 0.14, 0.58], ['L', 0.29, 0.36], ['L', 0.41, 0.46], ['L', 0.55, 0.27], ['L', 0.71, 0.45], ['L', 0.79, 0.38], ['L', 0.86, 0.48], ['M', 0.55, 0.27], ['L', 0.52, 0.42], ['L', 0.56, 0.58]] }
        ]
      },
      {
        stepNumber: 3,
        title: 'Zon en zachte wolken',
        instruction: 'Teken een opkomend zonnetje tussen de bergen en twee donzige wolkjes in de lucht.',
        tip: 'Platte onderkanten maken wolkjes extra mooi!',
        strokes: [
          { kind: 'OUTLINE', cmds: [['arc', 0.39, 0.39, 0.06, 0.06, 185, 175], ['M', 0.20, 0.29], ['Q', 0.25, 0.25, 0.30, 0.27], ['Q', 0.35, 0.25, 0.38, 0.29], ['L', 0.20, 0.29], ['M', 0.64, 0.26], ['Q', 0.70, 0.22, 0.75, 0.24], ['Q', 0.79, 0.23, 0.81, 0.26], ['L', 0.64, 0.26]] }
        ]
      },
      {
        stepNumber: 4,
        title: 'Dennenbomen op de oever',
        instruction: 'Teken links een heuveltje met twee driehoekige dennenboompjes.',
        tip: 'Dingen vooraan maken de bergen erachter heel groot!',
        strokes: [
          { kind: 'OUTLINE', cmds: [['M', 0.14, 0.67], ['Q', 0.28, 0.69, 0.36, 0.76], ['M', 0.22, 0.51], ['L', 0.17, 0.62], ['L', 0.27, 0.62], ['L', 0.22, 0.51], ['M', 0.22, 0.62], ['L', 0.22, 0.68], ['M', 0.30, 0.56], ['L', 0.26, 0.67], ['L', 0.34, 0.67], ['L', 0.30, 0.56], ['M', 0.30, 0.67], ['L', 0.30, 0.71]] }
        ]
      },
      {
        stepNumber: 5,
        title: 'Bergschaduw & rimpels in het water',
        instruction: 'Kras schaduw op de rechterkant van de bergen en zet rustige lijntjes op het water.',
        tip: 'Prachtig! Je hebt een echt schilderij gemaakt.',
        strokes: [
          { kind: 'SHADING', cmds: [['M', 0.55, 0.33], ['L', 0.63, 0.39], ['M', 0.55, 0.39], ['L', 0.66, 0.47], ['M', 0.56, 0.46], ['L', 0.68, 0.54], ['M', 0.29, 0.39], ['L', 0.35, 0.45], ['M', 0.29, 0.45], ['L', 0.38, 0.53]] },
          { kind: 'DETAIL', cmds: [['M', 0.45, 0.63], ['L', 0.68, 0.63], ['M', 0.50, 0.68], ['L', 0.75, 0.68], ['M', 0.42, 0.73], ['L', 0.63, 0.73], ['M', 0.54, 0.77], ['L', 0.78, 0.77]] }
        ]
      }
    ]
  },
  {
    id: 'strip_gezicht',
    title: 'Grappig Stripgezicht',
    subtitle: 'Speel met grote cartoon-ogen, wilde haren en een vrolijke grijns.',
    category: 'GEZICHTEN',
    categoryLabel: 'Gezichten',
    difficulty: 'MAKKELIJK',
    difficultyLabel: 'Makkelijk',
    durationMinutes: 5,
    pathOrder: 9,
    accentHex: '#d0552b',
    steps: [
      {
        stepNumber: 1,
        title: 'Ronde basis met gebogen kruis',
        instruction: 'Teken een grote cirkel en een licht gebogen kruis dat iets naar rechts kijkt.',
        tip: 'Door het kruis schuin te buigen lijkt het alsof hij opzij kijkt!',
        strokes: [
          { kind: 'CONSTRUCTION', cmds: [['circle', 0.50, 0.52, 0.22], ['M', 0.52, 0.28], ['Q', 0.57, 0.52, 0.52, 0.76], ['M', 0.27, 0.50], ['Q', 0.52, 0.54, 0.73, 0.49]] }
        ]
      },
      {
        stepNumber: 2,
        title: 'Grote stripogen & bolle neus',
        instruction: 'Teken twee grote eivormige ogen dicht bij elkaar en een dikke bolle cartoon-neus.',
        tip: 'Grote ogen zijn het geheim van grappige stripfiguren!',
        strokes: [
          { kind: 'OUTLINE', cmds: [['oval', 0.46, 0.46, 0.065, 0.08], ['oval', 0.60, 0.46, 0.065, 0.08], ['M', 0.53, 0.49], ['C', 0.64, 0.48, 0.64, 0.58, 0.52, 0.57]] }
        ]
      },
      {
        stepNumber: 3,
        title: 'Wangen, kin en oor',
        instruction: 'Teken het oortje links en de ronde wanglijn onder de kin door.',
        tip: 'Maak de wang lekker bol!',
        strokes: [
          { kind: 'OUTLINE', cmds: [['M', 0.31, 0.44], ['C', 0.24, 0.46, 0.25, 0.58, 0.31, 0.58], ['C', 0.33, 0.72, 0.46, 0.76, 0.58, 0.72], ['C', 0.68, 0.68, 0.72, 0.58, 0.71, 0.46]] }
        ]
      },
      {
        stepNumber: 4,
        title: 'Wild haar bovenop',
        instruction: 'Teken grote pieken en krullen boven op zijn hoofd.',
        tip: 'Maak de ene lok groot en de andere klein — lekker gek!',
        strokes: [
          { kind: 'OUTLINE', cmds: [['M', 0.30, 0.43], ['C', 0.27, 0.31, 0.35, 0.21, 0.44, 0.25], ['C', 0.46, 0.16, 0.58, 0.15, 0.60, 0.25], ['C', 0.68, 0.22, 0.75, 0.32, 0.71, 0.44]] }
        ]
      },
      {
        stepNumber: 5,
        title: 'Pupillen, wenkbrauwen & grote lach',
        instruction: 'Zet de stipjes in zijn ogen, opgetrokken wenkbrauwen en een superblije glimlach!',
        tip: 'Wauw, wat kijkt hij vrolijk!',
        strokes: [
          { kind: 'DETAIL', cmds: [['circle', 0.48, 0.47, 0.020], ['circle', 0.62, 0.47, 0.020], ['M', 0.40, 0.35], ['Q', 0.45, 0.31, 0.50, 0.34], ['M', 0.56, 0.34], ['Q', 0.62, 0.31, 0.67, 0.35], ['M', 0.42, 0.61], ['Q', 0.53, 0.71, 0.65, 0.60], ['M', 0.40, 0.60], ['L', 0.43, 0.63], ['M', 0.36, 0.61], ['L', 0.39, 0.63]] }
        ]
      }
    ]
  },
  {
    id: 'retro_camera',
    title: 'Retro Fotocamera',
    subtitle: 'Teken een coole camera met ronde lens, knopjes en flitslicht.',
    category: 'DINGEN',
    categoryLabel: 'Dingen',
    difficulty: 'UITDAGEND',
    difficultyLabel: 'Uitdagend',
    durationMinutes: 9,
    pathOrder: 10,
    accentHex: '#3b6e8c',
    steps: [
      {
        stepNumber: 1,
        title: 'Rechthoek & middenkruis',
        instruction: 'Teken een brede rechthoek en zet een kruis iets rechts van het midden voor de lens.',
        tip: 'Het kruis helpt je de ronde lens precies op de goede plek te zetten!',
        strokes: [
          { kind: 'CONSTRUCTION', cmds: [['M', 0.18, 0.34], ['L', 0.82, 0.34], ['L', 0.82, 0.74], ['L', 0.18, 0.74], ['L', 0.18, 0.34], ['M', 0.52, 0.30], ['L', 0.52, 0.78], ['M', 0.16, 0.55], ['L', 0.84, 0.55]] }
        ]
      },
      {
        stepNumber: 2,
        title: 'Afgeronde camera & bovenrand',
        instruction: 'Trek de camera met ronde hoekjes over en zet een rechte streep langs de bovenkant.',
        tip: 'Ronde hoeken maken hem extra stoer!',
        strokes: [
          { kind: 'OUTLINE', cmds: [['M', 0.22, 0.34], ['L', 0.78, 0.34], ['Q', 0.82, 0.34, 0.82, 0.38], ['L', 0.82, 0.70], ['Q', 0.82, 0.74, 0.78, 0.74], ['L', 0.22, 0.74], ['Q', 0.18, 0.74, 0.18, 0.70], ['L', 0.18, 0.38], ['Q', 0.18, 0.34, 0.22, 0.34], ['M', 0.18, 0.43], ['L', 0.82, 0.43]] }
        ]
      },
      {
        stepNumber: 3,
        title: 'De grote cameralens',
        instruction: 'Teken drie cirkels in elkaar rond het kruis: de buitenrand, de ring en het glas.',
        tip: 'Neem je tijd voor mooie ronde cirkels!',
        strokes: [
          { kind: 'OUTLINE', cmds: [['circle', 0.52, 0.56, 0.145], ['circle', 0.52, 0.56, 0.115], ['circle', 0.52, 0.56, 0.068]] }
        ]
      },
      {
        stepNumber: 4,
        title: 'Zoeker & drukknopje',
        instruction: 'Teken het kapje bovenop, het kleine klikknopje rechtsboven en het kijkraampje links.',
        tip: 'Nu zie je meteen dat het een fotocamera is!',
        strokes: [
          { kind: 'OUTLINE', cmds: [['M', 0.41, 0.34], ['L', 0.44, 0.25], ['L', 0.60, 0.25], ['L', 0.63, 0.34], ['M', 0.68, 0.34], ['L', 0.68, 0.29], ['L', 0.75, 0.29], ['L', 0.75, 0.34], ['M', 0.24, 0.365], ['L', 0.34, 0.365], ['L', 0.34, 0.41], ['L', 0.24, 0.41], ['L', 0.24, 0.365]] }
        ]
      },
      {
        stepNumber: 5,
        title: 'Grip, lensglans & oogjes',
        instruction: 'Teken een streep voor het handvat, twee haakjes aan de zijkanten en glansboogjes in de lens.',
        tip: 'Twee kleine glansjes laten het glas echt glimmen!',
        strokes: [
          { kind: 'DETAIL', cmds: [['M', 0.27, 0.43], ['L', 0.27, 0.74], ['arc', 0.52, 0.56, 0.045, 0.045, 200, 60], ['circle', 0.55, 0.59, 0.012], ['M', 0.18, 0.47], ['L', 0.15, 0.47], ['L', 0.15, 0.51], ['L', 0.18, 0.51], ['M', 0.82, 0.47], ['L', 0.85, 0.47], ['L', 0.85, 0.51], ['L', 0.82, 0.51]] }
        ]
      },
      {
        stepNumber: 6,
        title: 'Textuur & schaduw',
        instruction: 'Zet kleine streepjes op het handvat en een lijntje onder de camera. Je hebt alle 10 lessen uitgespeeld!',
        tip: 'Wat een meesterwerk — download je tekening of probeer hem uit je hoofd!',
        strokes: [
          { kind: 'SHADING', cmds: [['M', 0.20, 0.49], ['L', 0.25, 0.46], ['M', 0.20, 0.55], ['L', 0.25, 0.52], ['M', 0.20, 0.61], ['L', 0.25, 0.58], ['M', 0.20, 0.67], ['L', 0.25, 0.64], ['M', 0.20, 0.77], ['L', 0.80, 0.77]] }
        ]
      }
    ]
  }
];
