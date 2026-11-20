package com.example.data

internal object LessonCatalogPart1 {
    val lessons: List<DrawingLesson> = listOf(
        // 1. 3D Kubus & Schaduw
        DrawingLesson(
            id = "kubus_3d",
            title = "3D Kubus & Schaduw",
            subtitle = "Leer diepte en lichtval tekenen vanuit een simpel vierkant.",
            category = LessonCategory.BASIS,
            difficulty = Difficulty.MAKKELIJK,
            durationMinutes = 5,
            pathOrder = 1,
            accentHex = 0xFFD0552B,
            steps = listOf(
                DrawingStep(
                    stepNumber = 1,
                    title = "Het voorste vierkant",
                    instruction = "Teken eerst een recht vierkant iets linksonder het midden. Dit wordt de voorkant van je kubus.",
                    tip = "Gebruik lichte, losse polsbewegingen. Je hoeft geen liniaal te gebruiken!",
                    strokes = listOf(
                        LessonStroke(
                            kind = StrokeKind.CONSTRUCTION,
                            commands = listOf(
                                StrokeCommand.MoveTo(0.22f, 0.56f),
                                StrokeCommand.LineTo(0.64f, 0.56f),
                                StrokeCommand.MoveTo(0.43f, 0.35f),
                                StrokeCommand.LineTo(0.43f, 0.77f)
                            )
                        ),
                        LessonStroke(
                            kind = StrokeKind.OUTLINE,
                            commands = listOf(
                                StrokeCommand.MoveTo(0.25f, 0.38f),
                                StrokeCommand.LineTo(0.61f, 0.38f),
                                StrokeCommand.LineTo(0.61f, 0.74f),
                                StrokeCommand.LineTo(0.25f, 0.74f),
                                StrokeCommand.LineTo(0.25f, 0.38f)
                            )
                        )
                    )
                ),
                DrawingStep(
                    stepNumber = 2,
                    title = "Dieptelijnen naar achteren",
                    instruction = "Trek vanuit drie hoeken (linksboven, rechtsboven en rechtsonder) drie evenwijdige lijnen schuin naar rechtsboven.",
                    tip = "Let op dat alle drie de schuine lijnen precies dezelfde richting en lengte hebben.",
                    strokes = listOf(
                        LessonStroke(
                            kind = StrokeKind.OUTLINE,
                            commands = listOf(
                                StrokeCommand.MoveTo(0.25f, 0.38f),
                                StrokeCommand.LineTo(0.42f, 0.23f)
                            )
                        ),
                        LessonStroke(
                            kind = StrokeKind.OUTLINE,
                            commands = listOf(
                                StrokeCommand.MoveTo(0.61f, 0.38f),
                                StrokeCommand.LineTo(0.78f, 0.23f)
                            )
                        ),
                        LessonStroke(
                            kind = StrokeKind.OUTLINE,
                            commands = listOf(
                                StrokeCommand.MoveTo(0.61f, 0.74f),
                                StrokeCommand.LineTo(0.78f, 0.59f)
                            )
                        )
                    )
                ),
                DrawingStep(
                    stepNumber = 3,
                    title = "De achterkant sluiten",
                    instruction = "Verbind de uiteinden van je dieptelijnen met een horizontale lijn bovenaan en een verticale lijn rechts.",
                    tip = "Houd de lijnen mooi recht ten opzichte van je voorste vierkant.",
                    strokes = listOf(
                        LessonStroke(
                            kind = StrokeKind.OUTLINE,
                            commands = listOf(
                                StrokeCommand.MoveTo(0.42f, 0.23f),
                                StrokeCommand.LineTo(0.78f, 0.23f),
                                StrokeCommand.LineTo(0.78f, 0.59f)
                            )
                        )
                    )
                ),
                DrawingStep(
                    stepNumber = 4,
                    title = "Tafellijn & onzichtbare ribben",
                    instruction = "Voeg optioneel de achterste hulpribben toe om de vorm te snappen, en teken een tafellijn achter de kubus.",
                    tip = "De lichtblauwe hulplijnen helpen je zien dat de kubus echt op een oppervlak staat.",
                    strokes = listOf(
                        LessonStroke(
                            kind = StrokeKind.CONSTRUCTION,
                            commands = listOf(
                                StrokeCommand.MoveTo(0.42f, 0.23f),
                                StrokeCommand.LineTo(0.42f, 0.59f),
                                StrokeCommand.LineTo(0.78f, 0.59f),
                                StrokeCommand.MoveTo(0.25f, 0.74f),
                                StrokeCommand.LineTo(0.42f, 0.59f)
                            )
                        ),
                        LessonStroke(
                            kind = StrokeKind.DETAIL,
                            commands = listOf(
                                StrokeCommand.MoveTo(0.12f, 0.70f),
                                StrokeCommand.LineTo(0.25f, 0.70f),
                                StrokeCommand.MoveTo(0.72f, 0.70f),
                                StrokeCommand.LineTo(0.88f, 0.70f)
                            )
                        )
                    )
                ),
                DrawingStep(
                    stepNumber = 5,
                    title = "Schaduw arceren",
                    instruction = "Stel je voor dat de zon linksboven schijnt. Arceer de rechterzijkant en teken een slagschaduw op de tafel.",
                    tip = "Zet schuine potloodstreepjes dicht naast elkaar voor een natuurlijk resultaat.",
                    strokes = listOf(
                        LessonStroke(
                            kind = StrokeKind.SHADING,
                            commands = listOf(
                                StrokeCommand.MoveTo(0.64f, 0.42f), StrokeCommand.LineTo(0.75f, 0.31f),
                                StrokeCommand.MoveTo(0.64f, 0.50f), StrokeCommand.LineTo(0.75f, 0.39f),
                                StrokeCommand.MoveTo(0.64f, 0.58f), StrokeCommand.LineTo(0.75f, 0.47f),
                                StrokeCommand.MoveTo(0.64f, 0.66f), StrokeCommand.LineTo(0.75f, 0.55f)
                            )
                        ),
                        LessonStroke(
                            kind = StrokeKind.SHADING,
                            commands = listOf(
                                StrokeCommand.MoveTo(0.62f, 0.74f), StrokeCommand.LineTo(0.86f, 0.74f),
                                StrokeCommand.MoveTo(0.66f, 0.71f), StrokeCommand.LineTo(0.84f, 0.71f),
                                StrokeCommand.MoveTo(0.70f, 0.68f), StrokeCommand.LineTo(0.82f, 0.68f)
                            )
                        )
                    )
                )
            )
        ),

        // 2. Slapende Kat
        DrawingLesson(
            id = "slapende_kat",
            title = "Slapende Kat",
            subtitle = "Een knusse opgerolde kat van zachte ovalen en vloeiende lijnen.",
            category = LessonCategory.DIEREN,
            difficulty = Difficulty.MAKKELIJK,
            durationMinutes = 6,
            pathOrder = 2,
            accentHex = 0xFFD69A2D,
            steps = listOf(
                DrawingStep(
                    stepNumber = 1,
                    title = "Cirkel voor kop en ovaal voor lijf",
                    instruction = "Teken links een cirkel voor het kopje en rechts daarnaast een groter liggend ovaal voor het lijfje.",
                    tip = "Laat de cirkel en het ovaal elkaar een klein beetje overlappen.",
                    strokes = listOf(
                        LessonStroke(
                            kind = StrokeKind.CONSTRUCTION,
                            commands = listOf(
                                StrokeCommand.Circle(0.32f, 0.52f, 0.13f),
                                StrokeCommand.Oval(0.55f, 0.58f, 0.24f, 0.16f)
                            )
                        )
                    )
                ),
                DrawingStep(
                    stepNumber = 2,
                    title = "Kopje en puntige oortjes",
                    instruction = "Teken de ronde contour van het hoofdje met twee zachte driehoekige kattenoren bovenop.",
                    tip = "Maak de oorpuntjes net iets afgerond, dat oogt vriendelijker.",
                    strokes = listOf(
                        LessonStroke(
                            kind = StrokeKind.OUTLINE,
                            commands = listOf(
                                StrokeCommand.MoveTo(0.22f, 0.44f),
                                StrokeCommand.LineTo(0.20f, 0.31f),
                                StrokeCommand.QuadTo(0.26f, 0.35f, 0.30f, 0.39f),
                                StrokeCommand.QuadTo(0.34f, 0.39f, 0.37f, 0.39f),
                                StrokeCommand.QuadTo(0.41f, 0.34f, 0.44f, 0.31f),
                                StrokeCommand.LineTo(0.44f, 0.46f),
                                StrokeCommand.CubicTo(0.46f, 0.58f, 0.40f, 0.65f, 0.32f, 0.65f),
                                StrokeCommand.CubicTo(0.22f, 0.65f, 0.18f, 0.55f, 0.22f, 0.44f)
                            )
                        )
                    )
                ),
                DrawingStep(
                    stepNumber = 3,
                    title = "De ronde rug",
                    instruction = "Trek een grote, ontspannen boog vanaf de nek over het ruggetje naar de onderkant van het lijf.",
                    tip = "Volg gewoon je hulplijn van het grote ovaal.",
                    strokes = listOf(
                        LessonStroke(
                            kind = StrokeKind.OUTLINE,
                            commands = listOf(
                                StrokeCommand.MoveTo(0.44f, 0.46f),
                                StrokeCommand.CubicTo(0.56f, 0.39f, 0.78f, 0.43f, 0.79f, 0.58f),
                                StrokeCommand.CubicTo(0.79f, 0.71f, 0.64f, 0.75f, 0.42f, 0.74f)
                            )
                        )
                    )
                ),
                DrawingStep(
                    stepNumber = 4,
                    title = "Krulstaart en pootje",
                    instruction = "Teken een zachte krulstaart die om het lichaam ligt en een klein pootje dat onder het kinnetje rust.",
                    tip = "Maak het puntje van de staart lekker dik en pluizig.",
                    strokes = listOf(
                        LessonStroke(
                            kind = StrokeKind.OUTLINE,
                            commands = listOf(
                                StrokeCommand.MoveTo(0.75f, 0.67f),
                                StrokeCommand.CubicTo(0.84f, 0.75f, 0.68f, 0.84f, 0.48f, 0.80f),
                                StrokeCommand.CubicTo(0.42f, 0.79f, 0.43f, 0.73f, 0.50f, 0.73f),
                                StrokeCommand.CubicTo(0.62f, 0.74f, 0.72f, 0.71f, 0.72f, 0.66f)
                            )
                        ),
                        LessonStroke(
                            kind = StrokeKind.OUTLINE,
                            commands = listOf(
                                StrokeCommand.MoveTo(0.25f, 0.63f),
                                StrokeCommand.CubicTo(0.18f, 0.66f, 0.18f, 0.73f, 0.28f, 0.73f),
                                StrokeCommand.LineTo(0.39f, 0.73f)
                            )
                        )
                    )
                ),
                DrawingStep(
                    stepNumber = 5,
                    title = "Slapende oogjes & snorharen",
                    instruction = "Teken twee rustige U-boogjes voor de gesloten oogjes, een piepklein neusje en drie snorharen aan elke kant.",
                    tip = "Houd de snorharen kort en speels met losse polsstreepjes.",
                    strokes = listOf(
                        LessonStroke(
                            kind = StrokeKind.DETAIL,
                            commands = listOf(
                                StrokeCommand.Arc(0.27f, 0.50f, 0.03f, 0.025f, 15f, 150f),
                                StrokeCommand.Arc(0.37f, 0.50f, 0.03f, 0.025f, 15f, 150f),
                                StrokeCommand.MoveTo(0.31f, 0.54f),
                                StrokeCommand.LineTo(0.33f, 0.54f),
                                StrokeCommand.LineTo(0.32f, 0.56f),
                                StrokeCommand.LineTo(0.31f, 0.54f),
                                StrokeCommand.MoveTo(0.24f, 0.54f), StrokeCommand.LineTo(0.14f, 0.52f),
                                StrokeCommand.MoveTo(0.24f, 0.57f), StrokeCommand.LineTo(0.14f, 0.58f),
                                StrokeCommand.MoveTo(0.40f, 0.54f), StrokeCommand.LineTo(0.49f, 0.52f),
                                StrokeCommand.MoveTo(0.40f, 0.57f), StrokeCommand.LineTo(0.49f, 0.58f)
                            )
                        )
                    )
                ),
                DrawingStep(
                    stepNumber = 6,
                    title = "Binnenoren & vachtstreepjes",
                    instruction = "Werk de binnenkant van de oortjes af en voeg drie zachte streepjes op het ruggetje toe.",
                    tip = "Je slapende kat is helemaal af — goed gedaan!",
                    strokes = listOf(
                        LessonStroke(
                            kind = StrokeKind.SHADING,
                            commands = listOf(
                                StrokeCommand.MoveTo(0.23f, 0.41f),
                                StrokeCommand.LineTo(0.22f, 0.35f),
                                StrokeCommand.LineTo(0.27f, 0.39f),
                                StrokeCommand.MoveTo(0.39f, 0.40f),
                                StrokeCommand.LineTo(0.42f, 0.35f),
                                StrokeCommand.LineTo(0.42f, 0.42f),
                                StrokeCommand.MoveTo(0.55f, 0.44f), StrokeCommand.QuadTo(0.56f, 0.50f, 0.54f, 0.54f),
                                StrokeCommand.MoveTo(0.62f, 0.45f), StrokeCommand.QuadTo(0.63f, 0.51f, 0.61f, 0.55f),
                                StrokeCommand.MoveTo(0.69f, 0.47f), StrokeCommand.QuadTo(0.69f, 0.53f, 0.67f, 0.57f)
                            )
                        )
                    )
                )
            )
        ),

        // 3. Tulp in een Vaas
        DrawingLesson(
            id = "tulp_vaas",
            title = "Tulp in een Vaas",
            subtitle = "Symmetrie en elegante bloemblaadjes oefenen in 5 simpele stappen.",
            category = LessonCategory.NATUUR,
            difficulty = Difficulty.MAKKELIJK,
            durationMinutes = 6,
            pathOrder = 3,
            accentHex = 0xFF477856,
            steps = listOf(
                DrawingStep(
                    stepNumber = 1,
                    title = "Middenlijn en vaasvorm",
                    instruction = "Teken een verticale middenlijn om alles in balans te houden, met onderaan een ovaal voor de buik van de vaas.",
                    tip = "Een symmetrie-as maakt vazen en flessen meteen veel makkelijker!",
                    strokes = listOf(
                        LessonStroke(
                            kind = StrokeKind.CONSTRUCTION,
                            commands = listOf(
                                StrokeCommand.MoveTo(0.50f, 0.14f),
                                StrokeCommand.LineTo(0.50f, 0.86f),
                                StrokeCommand.Oval(0.50f, 0.70f, 0.14f, 0.13f)
                            )
                        )
                    )
                ),
                DrawingStep(
                    stepNumber = 2,
                    title = "De contouren van de vaas",
                    instruction = "Teken de bovenste opening als een smal ovaaltje en verbind die met twee sierlijke S-lijnen naar de platte bodem.",
                    tip = "Kijk afwisselend links en rechts van de middenlijn voor gelijke rondingen.",
                    strokes = listOf(
                        LessonStroke(
                            kind = StrokeKind.OUTLINE,
                            commands = listOf(
                                StrokeCommand.Oval(0.50f, 0.53f, 0.075f, 0.024f),
                                StrokeCommand.MoveTo(0.425f, 0.53f),
                                StrokeCommand.CubicTo(0.43f, 0.59f, 0.35f, 0.64f, 0.36f, 0.73f),
                                StrokeCommand.CubicTo(0.37f, 0.81f, 0.42f, 0.84f, 0.50f, 0.84f),
                                StrokeCommand.CubicTo(0.58f, 0.84f, 0.63f, 0.81f, 0.64f, 0.73f),
                                StrokeCommand.CubicTo(0.65f, 0.64f, 0.57f, 0.59f, 0.575f, 0.53f)
                            )
                        )
                    )
                ),
                DrawingStep(
                    stepNumber = 3,
                    title = "De steel en lange bladeren",
                    instruction = "Laat vanuit de vaasopening een licht gebogen steel omhoog groeien en teken twee spitse tulpenbladeren.",
                    tip = "Een lichte boog in de steel geeft de bloem meteen leven en beweging.",
                    strokes = listOf(
                        LessonStroke(
                            kind = StrokeKind.OUTLINE,
                            commands = listOf(
                                StrokeCommand.MoveTo(0.49f, 0.54f),
                                StrokeCommand.QuadTo(0.48f, 0.42f, 0.50f, 0.34f),
                                StrokeCommand.MoveTo(0.51f, 0.54f),
                                StrokeCommand.QuadTo(0.50f, 0.42f, 0.52f, 0.34f),
                                StrokeCommand.MoveTo(0.49f, 0.53f),
                                StrokeCommand.CubicTo(0.39f, 0.49f, 0.33f, 0.39f, 0.35f, 0.32f),
                                StrokeCommand.CubicTo(0.41f, 0.37f, 0.46f, 0.44f, 0.49f, 0.51f),
                                StrokeCommand.MoveTo(0.52f, 0.53f),
                                StrokeCommand.CubicTo(0.62f, 0.50f, 0.68f, 0.41f, 0.65f, 0.34f),
                                StrokeCommand.CubicTo(0.59f, 0.39f, 0.54f, 0.45f, 0.51f, 0.51f)
                            )
                        )
                    )
                ),
                DrawingStep(
                    stepNumber = 4,
                    title = "De tulp tekenen",
                    instruction = "Teken eerst het middelste komvormige bloemblad en voeg daarna het linker-, rechter- en achterste puntje toe.",
                    tip = "Begin met een U-vorm en laat de bovenkant iets naar binnen krullen.",
                    strokes = listOf(
                        LessonStroke(
                            kind = StrokeKind.OUTLINE,
                            commands = listOf(
                                StrokeCommand.MoveTo(0.51f, 0.35f),
                                StrokeCommand.CubicTo(0.39f, 0.34f, 0.38f, 0.21f, 0.44f, 0.16f),
                                StrokeCommand.QuadTo(0.48f, 0.20f, 0.51f, 0.23f),
                                StrokeCommand.QuadTo(0.54f, 0.20f, 0.58f, 0.16f),
                                StrokeCommand.CubicTo(0.64f, 0.21f, 0.63f, 0.34f, 0.51f, 0.35f),
                                StrokeCommand.MoveTo(0.46f, 0.18f),
                                StrokeCommand.QuadTo(0.51f, 0.12f, 0.56f, 0.18f)
                            )
                        )
                    )
                ),
                DrawingStep(
                    stepNumber = 5,
                    title = "Waterlijn, glans & schaduw",
                    instruction = "Teken een licht waterlijntje in de vaas, een glansstreep op de ronding en zachte nerfjes in de bladeren.",
                    tip = "Kleine lichtaccenten maken glas en water meteen herkenbaar.",
                    strokes = listOf(
                        LessonStroke(
                            kind = StrokeKind.DETAIL,
                            commands = listOf(
                                StrokeCommand.MoveTo(0.38f, 0.65f),
                                StrokeCommand.QuadTo(0.50f, 0.67f, 0.62f, 0.65f),
                                StrokeCommand.MoveTo(0.49f, 0.54f),
                                StrokeCommand.LineTo(0.49f, 0.76f),
                                StrokeCommand.MoveTo(0.40f, 0.39f),
                                StrokeCommand.QuadTo(0.44f, 0.44f, 0.47f, 0.49f),
                                StrokeCommand.MoveTo(0.61f, 0.40f),
                                StrokeCommand.QuadTo(0.57f, 0.45f, 0.53f, 0.49f)
                            )
                        ),
                        LessonStroke(
                            kind = StrokeKind.SHADING,
                            commands = listOf(
                                StrokeCommand.MoveTo(0.40f, 0.69f),
                                StrokeCommand.CubicTo(0.39f, 0.74f, 0.41f, 0.79f, 0.44f, 0.81f),
                                StrokeCommand.MoveTo(0.58f, 0.72f),
                                StrokeCommand.LineTo(0.61f, 0.69f),
                                StrokeCommand.MoveTo(0.57f, 0.76f),
                                StrokeCommand.LineTo(0.61f, 0.73f)
                            )
                        )
                    )
                )
            )
        ),

        // 4. Warme Chocomel
        DrawingLesson(
            id = "kopje_koffie",
            title = "Warme Chocomel",
            subtitle = "Teken een grote gezellige mok met warme chocolademelk en stoom.",
            category = LessonCategory.DINGEN,
            difficulty = Difficulty.MAKKELIJK,
            durationMinutes = 5,
            pathOrder = 4,
            accentHex = 0xFF8C4A27,
            steps = listOf(
                DrawingStep(
                    stepNumber = 1,
                    title = "Twee liggende ovalen",
                    instruction = "Teken in het midden een plat rondje voor de bovenkant van de mok, en onderaan een groter plat rondje voor het schoteltje.",
                    tip = "Maak de zijkanten mooi rond, niet puntig!",
                    strokes = listOf(
                        LessonStroke(
                            kind = StrokeKind.CONSTRUCTION,
                            commands = listOf(
                                StrokeCommand.Oval(0.46f, 0.46f, 0.21f, 0.065f),
                                StrokeCommand.Oval(0.46f, 0.74f, 0.29f, 0.08f)
                            )
                        )
                    )
                ),
                DrawingStep(
                    stepNumber = 2,
                    title = "De vorm van de mok",
                    instruction = "Trek de bovenrand netjes over en teken twee bolle zijkanten naar beneden.",
                    tip = "Zo wordt het een lekkere dikke chocomel-mok!",
                    strokes = listOf(
                        LessonStroke(
                            kind = StrokeKind.OUTLINE,
                            commands = listOf(
                                StrokeCommand.Oval(0.46f, 0.46f, 0.21f, 0.065f),
                                StrokeCommand.MoveTo(0.25f, 0.46f),
                                StrokeCommand.CubicTo(0.25f, 0.66f, 0.34f, 0.75f, 0.46f, 0.75f),
                                StrokeCommand.CubicTo(0.58f, 0.75f, 0.67f, 0.66f, 0.67f, 0.46f)
                            )
                        )
                    )
                ),
                DrawingStep(
                    stepNumber = 3,
                    title = "Het oortje & het schoteltje",
                    instruction = "Teken rechts een groot oor om vast te houden en maak het schoteltje onder de mok af.",
                    tip = "Stop het schoteltje achter de mok zodat de mok ervoor staat.",
                    strokes = listOf(
                        LessonStroke(
                            kind = StrokeKind.OUTLINE,
                            commands = listOf(
                                StrokeCommand.MoveTo(0.66f, 0.50f),
                                StrokeCommand.CubicTo(0.79f, 0.48f, 0.79f, 0.66f, 0.63f, 0.66f),
                                StrokeCommand.MoveTo(0.66f, 0.54f),
                                StrokeCommand.CubicTo(0.74f, 0.53f, 0.74f, 0.62f, 0.64f, 0.62f),
                                StrokeCommand.MoveTo(0.27f, 0.69f),
                                StrokeCommand.CubicTo(0.14f, 0.72f, 0.15f, 0.82f, 0.46f, 0.82f),
                                StrokeCommand.CubicTo(0.77f, 0.82f, 0.78f, 0.72f, 0.65f, 0.69f)
                            )
                        )
                    )
                ),
                DrawingStep(
                    stepNumber = 4,
                    title = "Chocomel & stoomkrullen",
                    instruction = "Teken een boogje voor de chocomel in de mok en laat twee vrolijke stoomslingers omhoog kringelen.",
                    tip = "Wiebel je potlood als een slangetje voor de stoom!",
                    strokes = listOf(
                        LessonStroke(
                            kind = StrokeKind.DETAIL,
                            commands = listOf(
                                StrokeCommand.MoveTo(0.28f, 0.48f),
                                StrokeCommand.QuadTo(0.46f, 0.43f, 0.64f, 0.48f),
                                StrokeCommand.MoveTo(0.39f, 0.36f),
                                StrokeCommand.CubicTo(0.35f, 0.30f, 0.44f, 0.25f, 0.39f, 0.18f),
                                StrokeCommand.MoveTo(0.51f, 0.35f),
                                StrokeCommand.CubicTo(0.47f, 0.28f, 0.57f, 0.23f, 0.52f, 0.15f)
                            )
                        )
                    )
                ),
                DrawingStep(
                    stepNumber = 5,
                    title = "Glans & schaduw",
                    instruction = "Zet een glansstreepje op de voorkant en een klein schaduwlijntje onder het schoteltje.",
                    tip = "Super! Misschien kun je er nog marshmallows bij tekenen!",
                    strokes = listOf(
                        LessonStroke(
                            kind = StrokeKind.SHADING,
                            commands = listOf(
                                StrokeCommand.MoveTo(0.31f, 0.56f),
                                StrokeCommand.QuadTo(0.32f, 0.65f, 0.37f, 0.70f),
                                StrokeCommand.MoveTo(0.30f, 0.84f), StrokeCommand.LineTo(0.68f, 0.84f),
                                StrokeCommand.MoveTo(0.36f, 0.865f), StrokeCommand.LineTo(0.64f, 0.865f)
                            )
                        )
                    )
                )
            )
        ),

        // 5. Schattige Pinguin
        DrawingLesson(
            id = "vrolijke_pinguin",
            title = "Schattige Pinguïn",
            subtitle = "Begin met een simpele eivorm en bouw een lieve pinguïn op.",
            category = LessonCategory.DIEREN,
            difficulty = Difficulty.MAKKELIJK,
            durationMinutes = 7,
            pathOrder = 5,
            accentHex = 0xFF3B6E8C,
            steps = listOf(
                DrawingStep(
                    stepNumber = 1,
                    title = "Eivorm & kruishulplijn",
                    instruction = "Teken een groot staand ovaal in het midden en zet er een verticaal en horizontaal hulplijntje in voor het gezicht.",
                    tip = "De oogjes komen straks net boven de bovenste horizontale lijn.",
                    strokes = listOf(
                        LessonStroke(
                            kind = StrokeKind.CONSTRUCTION,
                            commands = listOf(
                                StrokeCommand.Oval(0.50f, 0.54f, 0.22f, 0.27f),
                                StrokeCommand.MoveTo(0.50f, 0.24f),
                                StrokeCommand.LineTo(0.50f, 0.84f),
                                StrokeCommand.MoveTo(0.28f, 0.41f),
                                StrokeCommand.LineTo(0.72f, 0.41f)
                            )
                        )
                    )
                ),
                DrawingStep(
                    stepNumber = 2,
                    title = "Kopje en mollig lijfje",
                    instruction = "Teken een vloeiende buitenlijn met een iets smaller nekje en een lekker rond buikje onderaan.",
                    tip = "Ronde, vloeiende vormen maken stripdiertjes direct schattig.",
                    strokes = listOf(
                        LessonStroke(
                            kind = StrokeKind.OUTLINE,
                            commands = listOf(
                                StrokeCommand.MoveTo(0.50f, 0.26f),
                                StrokeCommand.CubicTo(0.35f, 0.26f, 0.32f, 0.37f, 0.35f, 0.45f),
                                StrokeCommand.CubicTo(0.28f, 0.56f, 0.29f, 0.78f, 0.50f, 0.79f),
                                StrokeCommand.CubicTo(0.71f, 0.78f, 0.72f, 0.56f, 0.65f, 0.45f),
                                StrokeCommand.CubicTo(0.68f, 0.37f, 0.65f, 0.26f, 0.50f, 0.26f)
                            )
                        )
                    )
                ),
                DrawingStep(
                    stepNumber = 3,
                    title = "Het hartvormige witte buikvlak",
                    instruction = "Teken twee boogjes boven de ogen die naar beneden lopen langs de binnenkant van de buik.",
                    tip = "Zo ontstaat het klassieke pinguïn-maskertje.",
                    strokes = listOf(
                        LessonStroke(
                            kind = StrokeKind.OUTLINE,
                            commands = listOf(
                                StrokeCommand.MoveTo(0.50f, 0.33f),
                                StrokeCommand.CubicTo(0.43f, 0.30f, 0.37f, 0.36f, 0.39f, 0.45f),
                                StrokeCommand.CubicTo(0.34f, 0.57f, 0.36f, 0.73f, 0.50f, 0.74f),
                                StrokeCommand.CubicTo(0.64f, 0.73f, 0.66f, 0.57f, 0.61f, 0.45f),
                                StrokeCommand.CubicTo(0.63f, 0.36f, 0.57f, 0.30f, 0.50f, 0.33f)
                            )
                        )
                    )
                ),
                DrawingStep(
                    stepNumber = 4,
                    title = "Vleugeltjes en zwemvliezen",
                    instruction = "Teken aan beide kanten een vrolijk opstaand vleugeltje en onderaan twee kleine pootjes met teentjes.",
                    tip = "Laat de vleugels een beetje naar buiten wijzen alsof hij zwaait.",
                    strokes = listOf(
                        LessonStroke(
                            kind = StrokeKind.OUTLINE,
                            commands = listOf(
                                StrokeCommand.MoveTo(0.33f, 0.48f),
                                StrokeCommand.CubicTo(0.22f, 0.51f, 0.20f, 0.62f, 0.26f, 0.64f),
                                StrokeCommand.QuadTo(0.29f, 0.62f, 0.30f, 0.58f),
                                StrokeCommand.MoveTo(0.67f, 0.48f),
                                StrokeCommand.CubicTo(0.78f, 0.51f, 0.80f, 0.62f, 0.74f, 0.64f),
                                StrokeCommand.QuadTo(0.71f, 0.62f, 0.70f, 0.58f),
                                StrokeCommand.MoveTo(0.38f, 0.78f),
                                StrokeCommand.CubicTo(0.33f, 0.84f, 0.42f, 0.86f, 0.47f, 0.80f),
                                StrokeCommand.MoveTo(0.53f, 0.80f),
                                StrokeCommand.CubicTo(0.58f, 0.86f, 0.67f, 0.84f, 0.62f, 0.78f)
                            )
                        )
                    )
                ),
                DrawingStep(
                    stepNumber = 5,
                    title = "Oogjes en snavel",
                    instruction = "Zet twee ronde oogjes links en rechts van de middenlijn, met daartussen een zacht driehoekig snaveltje.",
                    tip = "Laat een klein wit lichtpuntje over in de ogen voor extra uitdrukking.",
                    strokes = listOf(
                        LessonStroke(
                            kind = StrokeKind.DETAIL,
                            commands = listOf(
                                StrokeCommand.Circle(0.43f, 0.39f, 0.022f),
                                StrokeCommand.Circle(0.57f, 0.39f, 0.022f),
                                StrokeCommand.MoveTo(0.46f, 0.41f),
                                StrokeCommand.QuadTo(0.50f, 0.39f, 0.54f, 0.41f),
                                StrokeCommand.QuadTo(0.50f, 0.46f, 0.46f, 0.41f)
                            )
                        )
                    )
                ),
                DrawingStep(
                    stepNumber = 6,
                    title = "Winterse sjaal & schaduw",
                    instruction = "Teken een knus sjaaltje om het nekje met twee flappende uiteinden en lichte schaduw onder de voetjes.",
                    tip = "Fantastisch gedaan! Probeer hem eens in kleur na te tekenen.",
                    strokes = listOf(
                        LessonStroke(
                            kind = StrokeKind.DETAIL,
                            commands = listOf(
                                StrokeCommand.MoveTo(0.35f, 0.46f),
                                StrokeCommand.QuadTo(0.50f, 0.50f, 0.65f, 0.46f),
                                StrokeCommand.LineTo(0.65f, 0.51f),
                                StrokeCommand.QuadTo(0.50f, 0.55f, 0.35f, 0.51f),
                                StrokeCommand.LineTo(0.35f, 0.46f),
                                StrokeCommand.MoveTo(0.56f, 0.52f),
                                StrokeCommand.LineTo(0.58f, 0.64f),
                                StrokeCommand.LineTo(0.64f, 0.62f),
                                StrokeCommand.LineTo(0.62f, 0.51f)
                            )
                        ),
                        LessonStroke(
                            kind = StrokeKind.SHADING,
                            commands = listOf(
                                StrokeCommand.MoveTo(0.33f, 0.86f), StrokeCommand.LineTo(0.67f, 0.86f)
                            )
                        )
                    )
                )
            )
        )
    )
}
