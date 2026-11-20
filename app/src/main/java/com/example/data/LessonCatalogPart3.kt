package com.example.data

internal object LessonCatalogPart3 {
    val lessons: List<DrawingLesson> = listOf(
        // 11. Ruimteraket
        DrawingLesson(
            id = "raket_ruimte",
            title = "Ruimteraket",
            subtitle = "Vlieg naar de sterren met een stoere raket en vlammen.",
            category = LessonCategory.DINGEN,
            difficulty = Difficulty.MAKKELIJK,
            durationMinutes = 5,
            pathOrder = 11,
            accentHex = 0xFFD0552B,
            steps = listOf(
                DrawingStep(
                    stepNumber = 1,
                    title = "Middenlijn en raketromp",
                    instruction = "Teken een verticale middenlijn en daar omheen een grote puntige boog voor de romp van de raket.",
                    tip = "Maak hem lekker spits bovenaan zodat hij snel door de ruimte vliegt!",
                    strokes = listOf(
                        LessonStroke(
                            kind = StrokeKind.CONSTRUCTION,
                            commands = listOf(
                                StrokeCommand.MoveTo(0.50f, 0.12f),
                                StrokeCommand.LineTo(0.50f, 0.88f)
                            )
                        ),
                        LessonStroke(
                            kind = StrokeKind.OUTLINE,
                            commands = listOf(
                                StrokeCommand.MoveTo(0.50f, 0.16f),
                                StrokeCommand.CubicTo(0.36f, 0.30f, 0.35f, 0.52f, 0.40f, 0.68f),
                                StrokeCommand.LineTo(0.60f, 0.68f),
                                StrokeCommand.CubicTo(0.65f, 0.52f, 0.64f, 0.30f, 0.50f, 0.16f)
                            )
                        )
                    )
                ),
                DrawingStep(
                    stepNumber = 2,
                    title = "Neuskegel en patrijspoort",
                    instruction = "Zet een gebogen streep onder de punt en teken een groot rond raampje in het midden.",
                    tip = "Teken nog een kleiner cirkeltje in het raam voor de metalen rand.",
                    strokes = listOf(
                        LessonStroke(
                            kind = StrokeKind.OUTLINE,
                            commands = listOf(
                                StrokeCommand.MoveTo(0.41f, 0.31f),
                                StrokeCommand.QuadTo(0.50f, 0.34f, 0.59f, 0.31f),
                                StrokeCommand.Circle(0.50f, 0.46f, 0.075f),
                                StrokeCommand.Circle(0.50f, 0.46f, 0.052f)
                            )
                        )
                    )
                ),
                DrawingStep(
                    stepNumber = 3,
                    title = "De drie zijvinnen",
                    instruction = "Teken links en rechts twee gebogen vinnen en één smalle middenvin onderaan.",
                    tip = "De vinnen zorgen dat de raket mooi rechtop kan staan.",
                    strokes = listOf(
                        LessonStroke(
                            kind = StrokeKind.OUTLINE,
                            commands = listOf(
                                StrokeCommand.MoveTo(0.38f, 0.54f),
                                StrokeCommand.CubicTo(0.27f, 0.59f, 0.26f, 0.70f, 0.31f, 0.75f),
                                StrokeCommand.QuadTo(0.36f, 0.70f, 0.40f, 0.67f),
                                StrokeCommand.MoveTo(0.62f, 0.54f),
                                StrokeCommand.CubicTo(0.73f, 0.59f, 0.74f, 0.70f, 0.69f, 0.75f),
                                StrokeCommand.QuadTo(0.64f, 0.70f, 0.60f, 0.67f),
                                StrokeCommand.MoveTo(0.50f, 0.58f),
                                StrokeCommand.LineTo(0.50f, 0.73f)
                            )
                        )
                    )
                ),
                DrawingStep(
                    stepNumber = 4,
                    title = "Grote raketvlammen",
                    instruction = "Teken uit de onderkant golvende vuurvlammen die naar een punt lopen.",
                    tip = "Zet een kleinere vlam in het midden voor extra kracht!",
                    strokes = listOf(
                        LessonStroke(
                            kind = StrokeKind.DETAIL,
                            commands = listOf(
                                StrokeCommand.MoveTo(0.42f, 0.68f),
                                StrokeCommand.CubicTo(0.38f, 0.77f, 0.44f, 0.84f, 0.50f, 0.89f),
                                StrokeCommand.CubicTo(0.56f, 0.84f, 0.62f, 0.77f, 0.58f, 0.68f),
                                StrokeCommand.MoveTo(0.46f, 0.69f),
                                StrokeCommand.QuadTo(0.50f, 0.80f, 0.54f, 0.69f)
                            )
                        )
                    )
                ),
                DrawingStep(
                    stepNumber = 5,
                    title = "Sterretjes & glans",
                    instruction = "Teken fonkelende sterretjes om de raket heen en een lichtstreepje op het glas.",
                    tip = "3, 2, 1... lancering! Supergetekend!",
                    strokes = listOf(
                        LessonStroke(
                            kind = StrokeKind.DETAIL,
                            commands = listOf(
                                StrokeCommand.MoveTo(0.22f, 0.25f), StrokeCommand.LineTo(0.22f, 0.31f),
                                StrokeCommand.MoveTo(0.19f, 0.28f), StrokeCommand.LineTo(0.25f, 0.28f),
                                StrokeCommand.MoveTo(0.77f, 0.23f), StrokeCommand.LineTo(0.77f, 0.29f),
                                StrokeCommand.MoveTo(0.74f, 0.26f), StrokeCommand.LineTo(0.80f, 0.26f),
                                StrokeCommand.Circle(0.20f, 0.46f, 0.015f),
                                StrokeCommand.Circle(0.80f, 0.47f, 0.015f),
                                StrokeCommand.Arc(0.50f, 0.46f, 0.032f, 0.032f, 200f, 70f)
                            )
                        )
                    )
                )
            )
        ),

        // 12. Lieve Dinosaurus
        DrawingLesson(
            id = "vrolijke_dino",
            title = "Lieve Dinosaurus",
            subtitle = "Een vriendelijke langnek-dino met ronde pootjes en vlekjes.",
            category = LessonCategory.DIEREN,
            difficulty = Difficulty.MAKKELIJK,
            durationMinutes = 6,
            pathOrder = 12,
            accentHex = 0xFF477856,
            steps = listOf(
                DrawingStep(
                    stepNumber = 1,
                    title = "Groot ei voor het lijf & klein kopje",
                    instruction = "Teken rechtsonder een liggend ovaal voor het lijfje en linksboven een klein ovaaltje voor het kopje.",
                    tip = "Laat genoeg ruimte ertussen voor de lange nek!",
                    strokes = listOf(
                        LessonStroke(
                            kind = StrokeKind.CONSTRUCTION,
                            commands = listOf(
                                StrokeCommand.Oval(0.53f, 0.61f, 0.21f, 0.14f),
                                StrokeCommand.Oval(0.25f, 0.28f, 0.09f, 0.065f)
                            )
                        )
                    )
                ),
                DrawingStep(
                    stepNumber = 2,
                    title = "Kop, lange nek & rug",
                    instruction = "Verbind het ronde kopje met een sierlijke lange S-bocht naar de bolle rug van je dino.",
                    tip = "Teken deze lijn rustig in één vloeiende beweging.",
                    strokes = listOf(
                        LessonStroke(
                            kind = StrokeKind.OUTLINE,
                            commands = listOf(
                                StrokeCommand.MoveTo(0.25f, 0.34f),
                                StrokeCommand.CubicTo(0.14f, 0.34f, 0.14f, 0.21f, 0.26f, 0.21f),
                                StrokeCommand.CubicTo(0.35f, 0.21f, 0.34f, 0.39f, 0.37f, 0.50f),
                                StrokeCommand.CubicTo(0.48f, 0.44f, 0.68f, 0.46f, 0.74f, 0.58f)
                            )
                        )
                    )
                ),
                DrawingStep(
                    stepNumber = 3,
                    title = "Lange staart & dikke buik",
                    instruction = "Trek vanaf het ruggetje een puntige staart naar rechts en sluit de onderkant langs de buik naar de nek.",
                    tip = "Maak de punt van de staart een beetje omhoog gekruld.",
                    strokes = listOf(
                        LessonStroke(
                            kind = StrokeKind.OUTLINE,
                            commands = listOf(
                                StrokeCommand.MoveTo(0.74f, 0.58f),
                                StrokeCommand.CubicTo(0.84f, 0.62f, 0.89f, 0.58f, 0.90f, 0.53f),
                                StrokeCommand.CubicTo(0.87f, 0.65f, 0.78f, 0.72f, 0.66f, 0.73f),
                                StrokeCommand.MoveTo(0.28f, 0.33f),
                                StrokeCommand.CubicTo(0.31f, 0.48f, 0.28f, 0.65f, 0.38f, 0.72f)
                            )
                        )
                    )
                ),
                DrawingStep(
                    stepNumber = 4,
                    title = "Vier stevige dino-pootjes",
                    instruction = "Teken twee voorpootjes en twee achterpootjes onder het lijfje, met daartussen de buiklijn.",
                    tip = "Geef elke poot onderaan een plat voetje zodat hij goed staat.",
                    strokes = listOf(
                        LessonStroke(
                            kind = StrokeKind.OUTLINE,
                            commands = listOf(
                                StrokeCommand.MoveTo(0.38f, 0.72f),
                                StrokeCommand.LineTo(0.38f, 0.84f),
                                StrokeCommand.LineTo(0.45f, 0.84f),
                                StrokeCommand.LineTo(0.46f, 0.74f),
                                StrokeCommand.QuadTo(0.53f, 0.76f, 0.60f, 0.74f),
                                StrokeCommand.LineTo(0.60f, 0.84f),
                                StrokeCommand.LineTo(0.67f, 0.84f),
                                StrokeCommand.LineTo(0.67f, 0.72f),
                                StrokeCommand.MoveTo(0.47f, 0.75f),
                                StrokeCommand.LineTo(0.48f, 0.82f),
                                StrokeCommand.LineTo(0.53f, 0.82f),
                                StrokeCommand.LineTo(0.53f, 0.75f)
                            )
                        )
                    )
                ),
                DrawingStep(
                    stepNumber = 5,
                    title = "Oogje, lach & dino-vlekjes",
                    instruction = "Teken een lief oogje, een klein glimlachje en een paar ronde vlekjes op zijn rug!",
                    tip = "Superleuk! Je lieve dino is klaar.",
                    strokes = listOf(
                        LessonStroke(
                            kind = StrokeKind.DETAIL,
                            commands = listOf(
                                StrokeCommand.Circle(0.23f, 0.26f, 0.016f),
                                StrokeCommand.MoveTo(0.17f, 0.30f),
                                StrokeCommand.QuadTo(0.21f, 0.32f, 0.25f, 0.30f),
                                StrokeCommand.Circle(0.52f, 0.56f, 0.032f),
                                StrokeCommand.Circle(0.61f, 0.61f, 0.024f),
                                StrokeCommand.Circle(0.45f, 0.61f, 0.020f)
                            )
                        ),
                        LessonStroke(
                            kind = StrokeKind.SHADING,
                            commands = listOf(
                                StrokeCommand.MoveTo(0.34f, 0.86f), StrokeCommand.LineTo(0.73f, 0.86f)
                            )
                        )
                    )
                )
            )
        ),

        // 13. Sprookjeskasteel
        DrawingLesson(
            id = "eenvoudig_kasteel",
            title = "Sprookjeskasteel",
            subtitle = "Bouw een groot kasteel met torens, vlaggetjes en een boogpoort.",
            category = LessonCategory.DINGEN,
            difficulty = Difficulty.GEMIDDELD,
            durationMinutes = 8,
            pathOrder = 13,
            accentHex = 0xFF3B6E8C,
            steps = listOf(
                DrawingStep(
                    stepNumber = 1,
                    title = "Drie basisblokken",
                    instruction = "Teken een lage brede muur in het midden en links en rechts twee hogere smalle torens.",
                    tip = "Met drie simpele rechthoeken staat je hele kasteel meteen recht!",
                    strokes = listOf(
                        LessonStroke(
                            kind = StrokeKind.CONSTRUCTION,
                            commands = listOf(
                                StrokeCommand.MoveTo(0.50f, 0.14f), StrokeCommand.LineTo(0.50f, 0.84f)
                            )
                        ),
                        LessonStroke(
                            kind = StrokeKind.OUTLINE,
                            commands = listOf(
                                StrokeCommand.MoveTo(0.20f, 0.44f), StrokeCommand.LineTo(0.34f, 0.44f),
                                StrokeCommand.LineTo(0.34f, 0.82f), StrokeCommand.LineTo(0.20f, 0.82f), StrokeCommand.LineTo(0.20f, 0.44f),
                                StrokeCommand.MoveTo(0.66f, 0.44f), StrokeCommand.LineTo(0.80f, 0.44f),
                                StrokeCommand.LineTo(0.80f, 0.82f), StrokeCommand.LineTo(0.66f, 0.82f), StrokeCommand.LineTo(0.66f, 0.44f),
                                StrokeCommand.MoveTo(0.34f, 0.56f), StrokeCommand.LineTo(0.66f, 0.56f),
                                StrokeCommand.MoveTo(0.34f, 0.82f), StrokeCommand.LineTo(0.66f, 0.82f)
                            )
                        )
                    )
                ),
                DrawingStep(
                    stepNumber = 2,
                    title = "De hoge middentoren",
                    instruction = "Teken achter de muur een grote hoge middentoren die boven alles uitsteekt.",
                    tip = "Maak hem net iets breder dan de zijtorens.",
                    strokes = listOf(
                        LessonStroke(
                            kind = StrokeKind.OUTLINE,
                            commands = listOf(
                                StrokeCommand.MoveTo(0.41f, 0.56f),
                                StrokeCommand.LineTo(0.41f, 0.34f),
                                StrokeCommand.LineTo(0.59f, 0.34f),
                                StrokeCommand.LineTo(0.59f, 0.56f)
                            )
                        )
                    )
                ),
                DrawingStep(
                    stepNumber = 3,
                    title = "Puntdaken en wapperende vlaggen",
                    instruction = "Zet op elke toren een puntig driehoekig dak en bovenop vrolijke vlaggetjes!",
                    tip = "Maak de daken iets breder dan de torens zodat ze mooi oversteken.",
                    strokes = listOf(
                        LessonStroke(
                            kind = StrokeKind.OUTLINE,
                            commands = listOf(
                                StrokeCommand.MoveTo(0.18f, 0.44f), StrokeCommand.LineTo(0.27f, 0.27f), StrokeCommand.LineTo(0.36f, 0.44f),
                                StrokeCommand.MoveTo(0.64f, 0.44f), StrokeCommand.LineTo(0.73f, 0.27f), StrokeCommand.LineTo(0.82f, 0.44f),
                                StrokeCommand.MoveTo(0.39f, 0.34f), StrokeCommand.LineTo(0.50f, 0.16f), StrokeCommand.LineTo(0.61f, 0.34f),
                                StrokeCommand.MoveTo(0.27f, 0.27f), StrokeCommand.LineTo(0.27f, 0.20f), StrokeCommand.LineTo(0.33f, 0.22f), StrokeCommand.LineTo(0.27f, 0.24f),
                                StrokeCommand.MoveTo(0.50f, 0.16f), StrokeCommand.LineTo(0.50f, 0.09f), StrokeCommand.LineTo(0.57f, 0.11f), StrokeCommand.LineTo(0.50f, 0.13f),
                                StrokeCommand.MoveTo(0.73f, 0.27f), StrokeCommand.LineTo(0.73f, 0.20f), StrokeCommand.LineTo(0.79f, 0.22f), StrokeCommand.LineTo(0.73f, 0.24f)
                            )
                        )
                    )
                ),
                DrawingStep(
                    stepNumber = 4,
                    title = "Kantelen & grote kasteelpoort",
                    instruction = "Teken blokjes (kantelen) boven op de middenmuur en een grote ronde poort onderaan.",
                    tip = "Teken verticale strepen in de poort zodat het net houten planken lijken.",
                    strokes = listOf(
                        LessonStroke(
                            kind = StrokeKind.OUTLINE,
                            commands = listOf(
                                StrokeCommand.MoveTo(0.34f, 0.56f),
                                StrokeCommand.LineTo(0.34f, 0.52f), StrokeCommand.LineTo(0.39f, 0.52f), StrokeCommand.LineTo(0.39f, 0.56f),
                                StrokeCommand.MoveTo(0.61f, 0.56f),
                                StrokeCommand.LineTo(0.61f, 0.52f), StrokeCommand.LineTo(0.66f, 0.52f), StrokeCommand.LineTo(0.66f, 0.56f),
                                StrokeCommand.MoveTo(0.43f, 0.82f),
                                StrokeCommand.LineTo(0.43f, 0.69f),
                                StrokeCommand.CubicTo(0.43f, 0.61f, 0.57f, 0.61f, 0.57f, 0.69f),
                                StrokeCommand.LineTo(0.57f, 0.82f)
                            )
                        )
                    )
                ),
                DrawingStep(
                    stepNumber = 5,
                    title = "Raampjes & stenen",
                    instruction = "Zet kleine boograampjes in de torens, planklijnen op de poort en een paar baksteentjes.",
                    tip = "Je eigen sprookjeskasteel staat klaar!",
                    strokes = listOf(
                        LessonStroke(
                            kind = StrokeKind.DETAIL,
                            commands = listOf(
                                StrokeCommand.MoveTo(0.47f, 0.64f), StrokeCommand.LineTo(0.47f, 0.82f),
                                StrokeCommand.MoveTo(0.50f, 0.63f), StrokeCommand.LineTo(0.50f, 0.82f),
                                StrokeCommand.MoveTo(0.53f, 0.64f), StrokeCommand.LineTo(0.53f, 0.82f),
                                StrokeCommand.MoveTo(0.25f, 0.56f), StrokeCommand.LineTo(0.25f, 0.51f),
                                StrokeCommand.QuadTo(0.27f, 0.48f, 0.29f, 0.51f), StrokeCommand.LineTo(0.29f, 0.56f),
                                StrokeCommand.MoveTo(0.71f, 0.56f), StrokeCommand.LineTo(0.71f, 0.51f),
                                StrokeCommand.QuadTo(0.73f, 0.48f, 0.75f, 0.51f), StrokeCommand.LineTo(0.75f, 0.56f),
                                StrokeCommand.MoveTo(0.48f, 0.45f), StrokeCommand.LineTo(0.48f, 0.40f),
                                StrokeCommand.QuadTo(0.50f, 0.37f, 0.52f, 0.40f), StrokeCommand.LineTo(0.52f, 0.45f)
                            )
                        ),
                        LessonStroke(
                            kind = StrokeKind.SHADING,
                            commands = listOf(
                                StrokeCommand.MoveTo(0.23f, 0.68f), StrokeCommand.LineTo(0.30f, 0.68f),
                                StrokeCommand.MoveTo(0.69f, 0.73f), StrokeCommand.LineTo(0.76f, 0.73f),
                                StrokeCommand.MoveTo(0.14f, 0.83f), StrokeCommand.LineTo(0.86f, 0.83f)
                            )
                        )
                    )
                )
            )
        ),

        // 14. Lieve Vlinder
        DrawingLesson(
            id = "lieve_vlinder",
            title = "Lieve Vlinder",
            subtitle = "Teken grote mooie vleugels links en rechts precies in spiegelbeeld.",
            category = LessonCategory.NATUUR,
            difficulty = Difficulty.MAKKELIJK,
            durationMinutes = 5,
            pathOrder = 14,
            accentHex = 0xFFD69A2D,
            steps = listOf(
                DrawingStep(
                    stepNumber = 1,
                    title = "Middenlijn en vlinderlijfje",
                    instruction = "Teken een verticale lijn, een klein rond kopje bovenaan en een langwerpig lijfje.",
                    tip = "De middenlijn zorgt dat beide vleugels mooi even groot worden!",
                    strokes = listOf(
                        LessonStroke(
                            kind = StrokeKind.CONSTRUCTION,
                            commands = listOf(
                                StrokeCommand.MoveTo(0.50f, 0.14f), StrokeCommand.LineTo(0.50f, 0.84f)
                            )
                        ),
                        LessonStroke(
                            kind = StrokeKind.OUTLINE,
                            commands = listOf(
                                StrokeCommand.Circle(0.50f, 0.31f, 0.045f),
                                StrokeCommand.Oval(0.50f, 0.54f, 0.038f, 0.19f)
                            )
                        )
                    )
                ),
                DrawingStep(
                    stepNumber = 2,
                    title = "Twee grote bovenvleugels",
                    instruction = "Teken vanuit het bovenste lijfje links en rechts een grote ronde vleugel omhoog.",
                    tip = "Kijk goed hoe hoog je links gaat zodat rechts net zo hoog wordt.",
                    strokes = listOf(
                        LessonStroke(
                            kind = StrokeKind.OUTLINE,
                            commands = listOf(
                                StrokeCommand.MoveTo(0.46f, 0.42f),
                                StrokeCommand.CubicTo(0.28f, 0.16f, 0.12f, 0.28f, 0.21f, 0.48f),
                                StrokeCommand.CubicTo(0.26f, 0.56f, 0.39f, 0.54f, 0.46f, 0.51f),
                                StrokeCommand.MoveTo(0.54f, 0.42f),
                                StrokeCommand.CubicTo(0.72f, 0.16f, 0.88f, 0.28f, 0.79f, 0.48f),
                                StrokeCommand.CubicTo(0.74f, 0.56f, 0.61f, 0.54f, 0.54f, 0.51f)
                            )
                        )
                    )
                ),
                DrawingStep(
                    stepNumber = 3,
                    title = "Twee ondervleugels",
                    instruction = "Teken onder de bovenvleugels links en rechts twee druppelvormige ondervleugels.",
                    tip = "Maak ze iets kleiner dan de bovenvleugels!",
                    strokes = listOf(
                        LessonStroke(
                            kind = StrokeKind.OUTLINE,
                            commands = listOf(
                                StrokeCommand.MoveTo(0.46f, 0.53f),
                                StrokeCommand.CubicTo(0.25f, 0.54f, 0.22f, 0.76f, 0.36f, 0.78f),
                                StrokeCommand.CubicTo(0.44f, 0.79f, 0.47f, 0.69f, 0.46f, 0.62f),
                                StrokeCommand.MoveTo(0.54f, 0.53f),
                                StrokeCommand.CubicTo(0.75f, 0.54f, 0.78f, 0.76f, 0.64f, 0.78f),
                                StrokeCommand.CubicTo(0.56f, 0.79f, 0.53f, 0.69f, 0.54f, 0.62f)
                            )
                        )
                    )
                ),
                DrawingStep(
                    stepNumber = 4,
                    title = "Krullende voelsprieten",
                    instruction = "Teken twee gekrulde voelsprieten op het kopje met een klein bolletje aan het eind.",
                    tip = "Voeg ook twee lieve oogjes en een glimlachje toe als je wilt!",
                    strokes = listOf(
                        LessonStroke(
                            kind = StrokeKind.DETAIL,
                            commands = listOf(
                                StrokeCommand.MoveTo(0.48f, 0.27f),
                                StrokeCommand.CubicTo(0.44f, 0.18f, 0.38f, 0.16f, 0.36f, 0.20f),
                                StrokeCommand.Circle(0.36f, 0.20f, 0.012f),
                                StrokeCommand.MoveTo(0.52f, 0.27f),
                                StrokeCommand.CubicTo(0.56f, 0.18f, 0.62f, 0.16f, 0.64f, 0.20f),
                                StrokeCommand.Circle(0.64f, 0.20f, 0.012f)
                            )
                        )
                    )
                ),
                DrawingStep(
                    stepNumber = 5,
                    title = "Vrolijke vleugelstippen",
                    instruction = "Versier de vleugels met grote en kleine stippen en streepjes op het lijf.",
                    tip = "In 'Teken Op Scherm' kun je de stippen in allerlei kleuren inkleuren!",
                    strokes = listOf(
                        LessonStroke(
                            kind = StrokeKind.DETAIL,
                            commands = listOf(
                                StrokeCommand.Circle(0.28f, 0.37f, 0.052f),
                                StrokeCommand.Circle(0.72f, 0.37f, 0.052f),
                                StrokeCommand.Circle(0.36f, 0.66f, 0.036f),
                                StrokeCommand.Circle(0.64f, 0.66f, 0.036f),
                                StrokeCommand.MoveTo(0.47f, 0.48f), StrokeCommand.LineTo(0.53f, 0.48f),
                                StrokeCommand.MoveTo(0.47f, 0.55f), StrokeCommand.LineTo(0.53f, 0.55f),
                                StrokeCommand.MoveTo(0.47f, 0.62f), StrokeCommand.LineTo(0.53f, 0.62f)
                            )
                        )
                    )
                )
            )
        ),

        // 15. IJsje met Drie Bolletjes
        DrawingLesson(
            id = "lekker_ijsje",
            title = "IJsje met Drie Bolletjes",
            subtitle = "Een vrolijk ijshoorntje met drie bolletjes, slagroom en een kers!",
            category = LessonCategory.DINGEN,
            difficulty = Difficulty.MAKKELIJK,
            durationMinutes = 5,
            pathOrder = 15,
            accentHex = 0xFFD0552B,
            steps = listOf(
                DrawingStep(
                    stepNumber = 1,
                    title = "De driehoek van het hoorntje",
                    instruction = "Teken onderaan een grote driehoek op z'n kop met een randje erbovenop.",
                    tip = "Een omgekeerde ijshoorn-driehoek is supermakkelijk om mee te beginnen.",
                    strokes = listOf(
                        LessonStroke(
                            kind = StrokeKind.CONSTRUCTION,
                            commands = listOf(
                                StrokeCommand.MoveTo(0.50f, 0.14f), StrokeCommand.LineTo(0.50f, 0.88f)
                            )
                        ),
                        LessonStroke(
                            kind = StrokeKind.OUTLINE,
                            commands = listOf(
                                StrokeCommand.MoveTo(0.35f, 0.56f),
                                StrokeCommand.LineTo(0.65f, 0.56f),
                                StrokeCommand.LineTo(0.50f, 0.86f),
                                StrokeCommand.LineTo(0.35f, 0.56f)
                            )
                        )
                    )
                ),
                DrawingStep(
                    stepNumber = 2,
                    title = "Twee onderste ijsbolletjes",
                    instruction = "Teken op het hoorntje twee dikke ronde bollen naast elkaar met golvende smeltrandjes.",
                    tip = "Golflijntjes onderaan de bolletjes laten ze heerlijk zacht lijken!",
                    strokes = listOf(
                        LessonStroke(
                            kind = StrokeKind.OUTLINE,
                            commands = listOf(
                                StrokeCommand.Arc(0.41f, 0.48f, 0.105f, 0.10f, 165f, 200f),
                                StrokeCommand.Arc(0.59f, 0.48f, 0.105f, 0.10f, 175f, 200f),
                                StrokeCommand.MoveTo(0.32f, 0.54f),
                                StrokeCommand.QuadTo(0.37f, 0.59f, 0.42f, 0.55f),
                                StrokeCommand.QuadTo(0.50f, 0.60f, 0.57f, 0.55f),
                                StrokeCommand.QuadTo(0.63f, 0.59f, 0.68f, 0.54f)
                            )
                        )
                    )
                ),
                DrawingStep(
                    stepNumber = 3,
                    title = "Derde bolletje & kers op top",
                    instruction = "Zet midden bovenop het derde bolletje met een lekkere ronde kers en steeltje!",
                    tip = "Welke smaak krijgen de drie bolletjes? Aardbei, vanille of chocola?",
                    strokes = listOf(
                        LessonStroke(
                            kind = StrokeKind.OUTLINE,
                            commands = listOf(
                                StrokeCommand.Arc(0.50f, 0.33f, 0.115f, 0.105f, 165f, 210f),
                                StrokeCommand.MoveTo(0.39f, 0.37f),
                                StrokeCommand.QuadTo(0.45f, 0.42f, 0.50f, 0.39f),
                                StrokeCommand.QuadTo(0.55f, 0.42f, 0.61f, 0.37f),
                                StrokeCommand.Circle(0.50f, 0.20f, 0.036f),
                                StrokeCommand.MoveTo(0.50f, 0.17f),
                                StrokeCommand.QuadTo(0.53f, 0.12f, 0.57f, 0.12f)
                            )
                        )
                    )
                ),
                DrawingStep(
                    stepNumber = 4,
                    title = "Wafelruitjes op het hoorntje",
                    instruction = "Teken schuine streepjes eerst de ene kant op, en dan kruislings de andere kant op.",
                    tip = "Zo maak je meteen een echt krokant wafelijsje!",
                    strokes = listOf(
                        LessonStroke(
                            kind = StrokeKind.DETAIL,
                            commands = listOf(
                                StrokeCommand.MoveTo(0.39f, 0.64f), StrokeCommand.LineTo(0.56f, 0.56f),
                                StrokeCommand.MoveTo(0.43f, 0.72f), StrokeCommand.LineTo(0.62f, 0.62f),
                                StrokeCommand.MoveTo(0.47f, 0.79f), StrokeCommand.LineTo(0.56f, 0.74f),
                                StrokeCommand.MoveTo(0.61f, 0.64f), StrokeCommand.LineTo(0.44f, 0.56f),
                                StrokeCommand.MoveTo(0.57f, 0.72f), StrokeCommand.LineTo(0.38f, 0.62f),
                                StrokeCommand.MoveTo(0.53f, 0.79f), StrokeCommand.LineTo(0.44f, 0.74f)
                            )
                        )
                    )
                ),
                DrawingStep(
                    stepNumber = 5,
                    title = "Spikkels & glans",
                    instruction = "Strooi vrolijke discodip-spikkels over het ijs en zet een glansboogje op de kers.",
                    tip = "Mmm, ziet er heerlijk uit!",
                    strokes = listOf(
                        LessonStroke(
                            kind = StrokeKind.DETAIL,
                            commands = listOf(
                                StrokeCommand.MoveTo(0.45f, 0.29f), StrokeCommand.LineTo(0.47f, 0.31f),
                                StrokeCommand.MoveTo(0.54f, 0.28f), StrokeCommand.LineTo(0.53f, 0.31f),
                                StrokeCommand.MoveTo(0.50f, 0.34f), StrokeCommand.LineTo(0.52f, 0.35f),
                                StrokeCommand.MoveTo(0.38f, 0.45f), StrokeCommand.LineTo(0.40f, 0.47f),
                                StrokeCommand.MoveTo(0.60f, 0.45f), StrokeCommand.LineTo(0.58f, 0.47f),
                                StrokeCommand.Arc(0.50f, 0.20f, 0.018f, 0.018f, 200f, 65f)
                            )
                        )
                    )
                )
            )
        ),

        // 16. Lachende Zon & Regenboog
        DrawingLesson(
            id = "vrolijke_zon",
            title = "Zon & Regenboog",
            subtitle = "Teken donzige wolken, een grote regenboog en een vrolijke zon.",
            category = LessonCategory.NATUUR,
            difficulty = Difficulty.MAKKELIJK,
            durationMinutes = 5,
            pathOrder = 16,
            accentHex = 0xFFD69A2D,
            steps = listOf(
                DrawingStep(
                    stepNumber = 1,
                    title = "Twee wolkjes onderaan",
                    instruction = "Teken linksonder en rechtsonder twee zachte wolkjes met een platte onderkant.",
                    tip = "De regenboog komt zometeen precies tussen de twee wolkjes!",
                    strokes = listOf(
                        LessonStroke(
                            kind = StrokeKind.OUTLINE,
                            commands = listOf(
                                StrokeCommand.MoveTo(0.14f, 0.74f),
                                StrokeCommand.CubicTo(0.10f, 0.65f, 0.20f, 0.59f, 0.26f, 0.64f),
                                StrokeCommand.CubicTo(0.30f, 0.57f, 0.42f, 0.60f, 0.40f, 0.68f),
                                StrokeCommand.CubicTo(0.45f, 0.70f, 0.44f, 0.76f, 0.38f, 0.76f),
                                StrokeCommand.LineTo(0.16f, 0.76f),
                                StrokeCommand.MoveTo(0.60f, 0.76f),
                                StrokeCommand.CubicTo(0.55f, 0.71f, 0.58f, 0.63f, 0.64f, 0.64f),
                                StrokeCommand.CubicTo(0.68f, 0.57f, 0.80f, 0.59f, 0.79f, 0.67f),
                                StrokeCommand.CubicTo(0.86f, 0.67f, 0.88f, 0.75f, 0.82f, 0.76f),
                                StrokeCommand.LineTo(0.60f, 0.76f)
                            )
                        )
                    )
                ),
                DrawingStep(
                    stepNumber = 2,
                    title = "De grote regenboog-bogen",
                    instruction = "Teken vier grote regenboog-bogen naast elkaar van de ene wolk naar de andere.",
                    tip = "Volg elke keer rustig het boogje erboven!",
                    strokes = listOf(
                        LessonStroke(
                            kind = StrokeKind.OUTLINE,
                            commands = listOf(
                                StrokeCommand.Arc(0.50f, 0.66f, 0.26f, 0.26f, 190f, 160f),
                                StrokeCommand.Arc(0.50f, 0.66f, 0.22f, 0.22f, 190f, 160f),
                                StrokeCommand.Arc(0.50f, 0.66f, 0.18f, 0.18f, 190f, 160f),
                                StrokeCommand.Arc(0.50f, 0.66f, 0.14f, 0.14f, 190f, 160f)
                            )
                        )
                    )
                ),
                DrawingStep(
                    stepNumber = 3,
                    title = "De grote cirkelzon",
                    instruction = "Teken rechtsboven of linksboven een mooie ronde cirkel voor het zonnetje.",
                    tip = "We zetten hem linksboven zodat hij vrolijk over de regenboog kijkt!",
                    strokes = listOf(
                        LessonStroke(
                            kind = StrokeKind.OUTLINE,
                            commands = listOf(
                                StrokeCommand.Circle(0.24f, 0.26f, 0.10f)
                            )
                        )
                    )
                ),
                DrawingStep(
                    stepNumber = 4,
                    title = "Zonnestralen rondom",
                    instruction = "Teken vrolijke lange en korte zonnestralen rond het zonnetje.",
                    tip = "Wissel lange en korte straaltjes af — dat geeft een speels effect!",
                    strokes = listOf(
                        LessonStroke(
                            kind = StrokeKind.DETAIL,
                            commands = listOf(
                                StrokeCommand.MoveTo(0.24f, 0.13f), StrokeCommand.LineTo(0.24f, 0.08f),
                                StrokeCommand.MoveTo(0.24f, 0.39f), StrokeCommand.LineTo(0.24f, 0.44f),
                                StrokeCommand.MoveTo(0.11f, 0.26f), StrokeCommand.LineTo(0.06f, 0.26f),
                                StrokeCommand.MoveTo(0.37f, 0.26f), StrokeCommand.LineTo(0.42f, 0.26f),
                                StrokeCommand.MoveTo(0.15f, 0.17f), StrokeCommand.LineTo(0.11f, 0.13f),
                                StrokeCommand.MoveTo(0.33f, 0.17f), StrokeCommand.LineTo(0.37f, 0.13f),
                                StrokeCommand.MoveTo(0.15f, 0.35f), StrokeCommand.LineTo(0.11f, 0.39f),
                                StrokeCommand.MoveTo(0.33f, 0.35f), StrokeCommand.LineTo(0.37f, 0.39f)
                            )
                        )
                    )
                ),
                DrawingStep(
                    stepNumber = 5,
                    title = "Vrolijk gezichtje op de zon",
                    instruction = "Teken twee oogjes en een grote blije glimlach op de zon (en kleur de regenboog in!).",
                    tip = "Wat een stralende tekening — geweldig gedaan!",
                    strokes = listOf(
                        LessonStroke(
                            kind = StrokeKind.DETAIL,
                            commands = listOf(
                                StrokeCommand.Circle(0.205f, 0.24f, 0.014f),
                                StrokeCommand.Circle(0.275f, 0.24f, 0.014f),
                                StrokeCommand.MoveTo(0.195f, 0.285f),
                                StrokeCommand.QuadTo(0.24f, 0.33f, 0.285f, 0.285f)
                            )
                        )
                    )
                )
            )
        )
    )
}
