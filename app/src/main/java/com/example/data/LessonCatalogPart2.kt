package com.example.data

internal object LessonCatalogPart2 {
    val lessons: List<DrawingLesson> = listOf(
        // 6. Portret met Hulplijnen
        DrawingLesson(
            id = "simpel_portret",
            title = "Portret met Hulplijnen",
            subtitle = "Ontdek de klassieke verhoudingen voor een natuurlijk gezicht.",
            category = LessonCategory.GEZICHTEN,
            difficulty = Difficulty.GEMIDDELD,
            durationMinutes = 8,
            pathOrder = 6,
            accentHex = 0xFFD0552B,
            steps = listOf(
                DrawingStep(
                    stepNumber = 1,
                    title = "Ovaal & verhoudingslijnen",
                    instruction = "Teken een rustig ovaal. Zet een verticale lijn precies door het midden en een horizontale oog-lijn halverwege.",
                    tip = "De ogen zitten echt halverwege het hele hoofd (dus niet te hoog!).",
                    strokes = listOf(
                        LessonStroke(
                            kind = StrokeKind.CONSTRUCTION,
                            commands = listOf(
                                StrokeCommand.Oval(0.50f, 0.47f, 0.20f, 0.26f),
                                StrokeCommand.MoveTo(0.50f, 0.18f), StrokeCommand.LineTo(0.50f, 0.76f),
                                StrokeCommand.MoveTo(0.28f, 0.47f), StrokeCommand.LineTo(0.72f, 0.47f),
                                StrokeCommand.MoveTo(0.36f, 0.59f), StrokeCommand.LineTo(0.64f, 0.59f),
                                StrokeCommand.MoveTo(0.39f, 0.66f), StrokeCommand.LineTo(0.61f, 0.66f)
                            )
                        )
                    )
                ),
                DrawingStep(
                    stepNumber = 2,
                    title = "Kaaklijn en nek",
                    instruction = "Teken de kaaklijn iets smaller richting de kin en voeg twee licht gebogen neklijnen toe onder de oren.",
                    tip = "Maak de kin zacht en iets minder puntig dan het onderste ovaal.",
                    strokes = listOf(
                        LessonStroke(
                            kind = StrokeKind.OUTLINE,
                            commands = listOf(
                                StrokeCommand.MoveTo(0.30f, 0.45f),
                                StrokeCommand.CubicTo(0.30f, 0.62f, 0.40f, 0.73f, 0.50f, 0.74f),
                                StrokeCommand.CubicTo(0.60f, 0.73f, 0.70f, 0.62f, 0.70f, 0.45f),
                                StrokeCommand.MoveTo(0.41f, 0.71f),
                                StrokeCommand.QuadTo(0.41f, 0.80f, 0.37f, 0.85f),
                                StrokeCommand.MoveTo(0.59f, 0.71f),
                                StrokeCommand.QuadTo(0.59f, 0.80f, 0.63f, 0.85f)
                            )
                        )
                    )
                ),
                DrawingStep(
                    stepNumber = 3,
                    title = "Oren en wenkbrauwen",
                    instruction = "Teken de oren precies tussen de oog-lijn en neus-lijn, en zet twee zachte bogen voor de wenkbrauwen.",
                    tip = "De afstand tussen de twee ogen is ongeveer één oogbreedte.",
                    strokes = listOf(
                        LessonStroke(
                            kind = StrokeKind.OUTLINE,
                            commands = listOf(
                                StrokeCommand.MoveTo(0.30f, 0.47f),
                                StrokeCommand.CubicTo(0.25f, 0.47f, 0.25f, 0.59f, 0.31f, 0.59f),
                                StrokeCommand.MoveTo(0.70f, 0.47f),
                                StrokeCommand.CubicTo(0.75f, 0.47f, 0.75f, 0.59f, 0.69f, 0.59f),
                                StrokeCommand.MoveTo(0.36f, 0.42f),
                                StrokeCommand.QuadTo(0.41f, 0.39f, 0.46f, 0.41f),
                                StrokeCommand.MoveTo(0.54f, 0.41f),
                                StrokeCommand.QuadTo(0.59f, 0.39f, 0.64f, 0.42f)
                            )
                        )
                    )
                ),
                DrawingStep(
                    stepNumber = 4,
                    title = "Ogen, neus en vriendelijke glimlach",
                    instruction = "Teken amandelvormige oogjes op de middenlijn, een simpel neusbrugje en een ontspannen mond.",
                    tip = "Minder lijnen voor de neus oogt vaak veel eleganter dan te veel strepen!",
                    strokes = listOf(
                        LessonStroke(
                            kind = StrokeKind.DETAIL,
                            commands = listOf(
                                StrokeCommand.MoveTo(0.37f, 0.47f),
                                StrokeCommand.QuadTo(0.41f, 0.44f, 0.45f, 0.47f),
                                StrokeCommand.QuadTo(0.41f, 0.50f, 0.37f, 0.47f),
                                StrokeCommand.Circle(0.41f, 0.47f, 0.015f),
                                StrokeCommand.MoveTo(0.55f, 0.47f),
                                StrokeCommand.QuadTo(0.59f, 0.44f, 0.63f, 0.47f),
                                StrokeCommand.QuadTo(0.59f, 0.50f, 0.55f, 0.47f),
                                StrokeCommand.Circle(0.59f, 0.47f, 0.015f),
                                StrokeCommand.MoveTo(0.49f, 0.49f),
                                StrokeCommand.QuadTo(0.47f, 0.57f, 0.50f, 0.59f),
                                StrokeCommand.QuadTo(0.52f, 0.595f, 0.53f, 0.58f),
                                StrokeCommand.MoveTo(0.44f, 0.65f),
                                StrokeCommand.QuadTo(0.50f, 0.68f, 0.56f, 0.65f),
                                StrokeCommand.MoveTo(0.47f, 0.685f),
                                StrokeCommand.QuadTo(0.50f, 0.695f, 0.53f, 0.685f)
                            )
                        )
                    )
                ),
                DrawingStep(
                    stepNumber = 5,
                    title = "Kapsel met volume",
                    instruction = "Teken het haar altijd iets buiten het schedel-ovaal zodat het volume krijgt, met een scheiding of lok.",
                    tip = "Denk aan haar als één geheel vorm in plaats van losse sprietjes.",
                    strokes = listOf(
                        LessonStroke(
                            kind = StrokeKind.OUTLINE,
                            commands = listOf(
                                StrokeCommand.MoveTo(0.29f, 0.45f),
                                StrokeCommand.CubicTo(0.25f, 0.30f, 0.36f, 0.16f, 0.52f, 0.17f),
                                StrokeCommand.CubicTo(0.68f, 0.18f, 0.75f, 0.31f, 0.71f, 0.46f),
                                StrokeCommand.MoveTo(0.30f, 0.37f),
                                StrokeCommand.CubicTo(0.38f, 0.34f, 0.46f, 0.28f, 0.50f, 0.25f),
                                StrokeCommand.CubicTo(0.56f, 0.31f, 0.64f, 0.35f, 0.70f, 0.39f)
                            )
                        )
                    )
                ),
                DrawingStep(
                    stepNumber = 6,
                    title = "Kraagje & zachte nekschaduw",
                    instruction = "Teken een simpel T-shirtkraagje onderaan de nek en arceer zacht onder de kin voor diepte.",
                    tip = "De slagschaduw onder de kin maakt het portret meteen ruimtelijk.",
                    strokes = listOf(
                        LessonStroke(
                            kind = StrokeKind.DETAIL,
                            commands = listOf(
                                StrokeCommand.MoveTo(0.37f, 0.84f),
                                StrokeCommand.QuadTo(0.50f, 0.90f, 0.63f, 0.84f)
                            )
                        ),
                        LessonStroke(
                            kind = StrokeKind.SHADING,
                            commands = listOf(
                                StrokeCommand.MoveTo(0.44f, 0.75f), StrokeCommand.LineTo(0.55f, 0.74f),
                                StrokeCommand.MoveTo(0.45f, 0.775f), StrokeCommand.LineTo(0.53f, 0.765f)
                            )
                        )
                    )
                )
            )
        ),

        // 7. Vrolijke Puppy
        DrawingLesson(
            id = "vrolijke_hond",
            title = "Vrolijke Puppy",
            subtitle = "Teken een lieve zittende puppy met flaporen en kwispelstaart.",
            category = LessonCategory.DIEREN,
            difficulty = Difficulty.GEMIDDELD,
            durationMinutes = 8,
            pathOrder = 7,
            accentHex = 0xFFD69A2D,
            steps = listOf(
                DrawingStep(
                    stepNumber = 1,
                    title = "Kopje, snuit en lijf",
                    instruction = "Begin met een cirkel voor de kop, een klein ovaal voor de snuit en een peervormig ovaal voor het zittende lijf.",
                    tip = "Deze drie basisvormen bepalen meteen de hele houding.",
                    strokes = listOf(
                        LessonStroke(
                            kind = StrokeKind.CONSTRUCTION,
                            commands = listOf(
                                StrokeCommand.Circle(0.44f, 0.34f, 0.14f),
                                StrokeCommand.Oval(0.41f, 0.40f, 0.08f, 0.055f),
                                StrokeCommand.Oval(0.53f, 0.63f, 0.15f, 0.18f)
                            )
                        )
                    )
                ),
                DrawingStep(
                    stepNumber = 2,
                    title = "Kop en hangende flaporen",
                    instruction = "Teken de ronde kop en voeg aan beide kanten twee lange, zachte flaporen toe.",
                    tip = "Laat het linkeroor iets naar voren vallen voor een speels effect.",
                    strokes = listOf(
                        LessonStroke(
                            kind = StrokeKind.OUTLINE,
                            commands = listOf(
                                StrokeCommand.MoveTo(0.32f, 0.28f),
                                StrokeCommand.CubicTo(0.36f, 0.18f, 0.52f, 0.18f, 0.56f, 0.28f),
                                StrokeCommand.MoveTo(0.32f, 0.28f),
                                StrokeCommand.CubicTo(0.24f, 0.34f, 0.22f, 0.47f, 0.28f, 0.48f),
                                StrokeCommand.CubicTo(0.33f, 0.48f, 0.34f, 0.39f, 0.33f, 0.34f),
                                StrokeCommand.MoveTo(0.56f, 0.28f),
                                StrokeCommand.CubicTo(0.64f, 0.33f, 0.65f, 0.47f, 0.59f, 0.48f),
                                StrokeCommand.CubicTo(0.54f, 0.48f, 0.54f, 0.38f, 0.55f, 0.33f),
                                StrokeCommand.MoveTo(0.33f, 0.42f),
                                StrokeCommand.QuadTo(0.44f, 0.50f, 0.55f, 0.42f)
                            )
                        )
                    )
                ),
                DrawingStep(
                    stepNumber = 3,
                    title = "Rug, buik en voorpootjes",
                    instruction = "Teken de gebogen rug naar achteren en twee rechte voorpootjes met ronde teentjes op de grond.",
                    tip = "De voorpootjes staan mooi stevig onder de borst.",
                    strokes = listOf(
                        LessonStroke(
                            kind = StrokeKind.OUTLINE,
                            commands = listOf(
                                StrokeCommand.MoveTo(0.55f, 0.46f),
                                StrokeCommand.CubicTo(0.66f, 0.52f, 0.70f, 0.68f, 0.66f, 0.79f),
                                StrokeCommand.MoveTo(0.39f, 0.47f),
                                StrokeCommand.LineTo(0.39f, 0.78f),
                                StrokeCommand.CubicTo(0.39f, 0.82f, 0.46f, 0.82f, 0.46f, 0.78f),
                                StrokeCommand.LineTo(0.46f, 0.58f),
                                StrokeCommand.MoveTo(0.50f, 0.58f),
                                StrokeCommand.LineTo(0.50f, 0.78f),
                                StrokeCommand.CubicTo(0.50f, 0.82f, 0.57f, 0.82f, 0.57f, 0.78f),
                                StrokeCommand.LineTo(0.56f, 0.56f)
                            )
                        )
                    )
                ),
                DrawingStep(
                    stepNumber = 4,
                    title = "Achterpoot & kwispelstaart",
                    instruction = "Voeg de gebogen achterpoot rechtsonder toe en een vrolijk omhoog gekruld staartje.",
                    tip = "Twee kleine bewegingsstreepjes naast de staart laten hem echt kwispelen!",
                    strokes = listOf(
                        LessonStroke(
                            kind = StrokeKind.OUTLINE,
                            commands = listOf(
                                StrokeCommand.MoveTo(0.57f, 0.79f),
                                StrokeCommand.LineTo(0.68f, 0.79f),
                                StrokeCommand.CubicTo(0.71f, 0.74f, 0.66f, 0.67f, 0.60f, 0.69f),
                                StrokeCommand.MoveTo(0.68f, 0.72f),
                                StrokeCommand.CubicTo(0.77f, 0.68f, 0.80f, 0.57f, 0.74f, 0.54f),
                                StrokeCommand.QuadTo(0.70f, 0.58f, 0.68f, 0.66f)
                            )
                        )
                    )
                ),
                DrawingStep(
                    stepNumber = 5,
                    title = "Oogjes, snuit & blije tong",
                    instruction = "Teken twee vrolijke kraaloogjes, een glimmende honden-neus en een schattig glimlachje met tongetje.",
                    tip = "De oogjes iets dicht bij de neus geven een echte puppy-look.",
                    strokes = listOf(
                        LessonStroke(
                            kind = StrokeKind.DETAIL,
                            commands = listOf(
                                StrokeCommand.Circle(0.39f, 0.32f, 0.020f),
                                StrokeCommand.Circle(0.49f, 0.32f, 0.020f),
                                StrokeCommand.Oval(0.44f, 0.37f, 0.026f, 0.017f),
                                StrokeCommand.MoveTo(0.44f, 0.387f), StrokeCommand.LineTo(0.44f, 0.415f),
                                StrokeCommand.MoveTo(0.39f, 0.41f),
                                StrokeCommand.QuadTo(0.44f, 0.44f, 0.49f, 0.41f),
                                StrokeCommand.MoveTo(0.43f, 0.425f),
                                StrokeCommand.CubicTo(0.42f, 0.46f, 0.46f, 0.46f, 0.455f, 0.425f)
                            )
                        )
                    )
                ),
                DrawingStep(
                    stepNumber = 6,
                    title = "Halsband & penning",
                    instruction = "Geef je puppy een halsbandje met een rond penningkje en wat grondschaduw onder de pootjes.",
                    tip = "Super! Je hebt een complete puppy uit 3 basisvormen getekend.",
                    strokes = listOf(
                        LessonStroke(
                            kind = StrokeKind.DETAIL,
                            commands = listOf(
                                StrokeCommand.MoveTo(0.36f, 0.46f),
                                StrokeCommand.QuadTo(0.45f, 0.51f, 0.55f, 0.46f),
                                StrokeCommand.MoveTo(0.37f, 0.49f),
                                StrokeCommand.QuadTo(0.45f, 0.54f, 0.55f, 0.49f),
                                StrokeCommand.Circle(0.45f, 0.535f, 0.020f),
                                StrokeCommand.MoveTo(0.79f, 0.56f), StrokeCommand.QuadTo(0.82f, 0.59f, 0.80f, 0.63f)
                            )
                        ),
                        LessonStroke(
                            kind = StrokeKind.SHADING,
                            commands = listOf(
                                StrokeCommand.MoveTo(0.34f, 0.82f), StrokeCommand.LineTo(0.71f, 0.82f)
                            )
                        )
                    )
                )
            )
        ),

        // 8. Berglandschap bij Zonsopgang
        DrawingLesson(
            id = "berglandschap",
            title = "Berglandschap",
            subtitle = "Creëer diepte met voorgrond, bergtoppen, dennen en een meer.",
            category = LessonCategory.NATUUR,
            difficulty = Difficulty.GEMIDDELD,
            durationMinutes = 7,
            pathOrder = 8,
            accentHex = 0xFF477856,
            steps = listOf(
                DrawingStep(
                    stepNumber = 1,
                    title = "Kader en horizonlijn",
                    instruction = "Teken een zacht kader en zet net onder het midden een rechte horizonlijn voor het bergmeer.",
                    tip = "Een kader rondom een landschap laat het meteen als een kunstwerkje lijken.",
                    strokes = listOf(
                        LessonStroke(
                            kind = StrokeKind.CONSTRUCTION,
                            commands = listOf(
                                StrokeCommand.MoveTo(0.14f, 0.18f),
                                StrokeCommand.LineTo(0.86f, 0.18f),
                                StrokeCommand.LineTo(0.86f, 0.82f),
                                StrokeCommand.LineTo(0.14f, 0.82f),
                                StrokeCommand.LineTo(0.14f, 0.18f),
                                StrokeCommand.MoveTo(0.14f, 0.58f),
                                StrokeCommand.LineTo(0.86f, 0.58f)
                            )
                        )
                    )
                ),
                DrawingStep(
                    stepNumber = 2,
                    title = "De grote bergtoppen",
                    instruction = "Teken drie overlappende bergtoppen met scherpe, licht onregelmatige lijnen en een bergkam naar beneden.",
                    tip = "Maak de lijnen niet te strak — kleine knikjes geven rotsachtige textuur!",
                    strokes = listOf(
                        LessonStroke(
                            kind = StrokeKind.OUTLINE,
                            commands = listOf(
                                StrokeCommand.MoveTo(0.14f, 0.58f),
                                StrokeCommand.LineTo(0.29f, 0.36f),
                                StrokeCommand.LineTo(0.41f, 0.46f),
                                StrokeCommand.LineTo(0.55f, 0.27f),
                                StrokeCommand.LineTo(0.71f, 0.45f),
                                StrokeCommand.LineTo(0.79f, 0.38f),
                                StrokeCommand.LineTo(0.86f, 0.48f),
                                StrokeCommand.MoveTo(0.55f, 0.27f),
                                StrokeCommand.LineTo(0.52f, 0.42f),
                                StrokeCommand.LineTo(0.56f, 0.58f)
                            )
                        )
                    )
                ),
                DrawingStep(
                    stepNumber = 3,
                    title = "Zon en zachte wolken",
                    instruction = "Teken een opkomende cirkelzon tussen de bergen en twee simpele laaghangende wolken hoog in de lucht.",
                    tip = "De achterste lijnen vervagen een beetje voor extra diepte.",
                    strokes = listOf(
                        LessonStroke(
                            kind = StrokeKind.OUTLINE,
                            commands = listOf(
                                StrokeCommand.Arc(0.39f, 0.39f, 0.06f, 0.06f, 185f, 175f),
                                StrokeCommand.MoveTo(0.20f, 0.29f),
                                StrokeCommand.QuadTo(0.25f, 0.25f, 0.30f, 0.27f),
                                StrokeCommand.QuadTo(0.35f, 0.25f, 0.38f, 0.29f),
                                StrokeCommand.LineTo(0.20f, 0.29f),
                                StrokeCommand.MoveTo(0.64f, 0.26f),
                                StrokeCommand.QuadTo(0.70f, 0.22f, 0.75f, 0.24f),
                                StrokeCommand.QuadTo(0.79f, 0.23f, 0.81f, 0.26f),
                                StrokeCommand.LineTo(0.64f, 0.26f)
                            )
                        )
                    )
                ),
                DrawingStep(
                    stepNumber = 4,
                    title = "Dennenbomen op de voorgrond",
                    instruction = "Teken links aan de oever een groepje eenvoudige dennenbomen om de voorgrond dichtbij te halen.",
                    tip = "Teken eerst het stammetje en bouw met driehoekige zigzags van boven naar beneden.",
                    strokes = listOf(
                        LessonStroke(
                            kind = StrokeKind.OUTLINE,
                            commands = listOf(
                                StrokeCommand.MoveTo(0.14f, 0.67f),
                                StrokeCommand.QuadTo(0.28f, 0.69f, 0.36f, 0.76f),
                                StrokeCommand.MoveTo(0.22f, 0.51f),
                                StrokeCommand.LineTo(0.17f, 0.62f), StrokeCommand.LineTo(0.27f, 0.62f), StrokeCommand.LineTo(0.22f, 0.51f),
                                StrokeCommand.MoveTo(0.22f, 0.62f), StrokeCommand.LineTo(0.22f, 0.68f),
                                StrokeCommand.MoveTo(0.30f, 0.56f),
                                StrokeCommand.LineTo(0.26f, 0.67f), StrokeCommand.LineTo(0.34f, 0.67f), StrokeCommand.LineTo(0.30f, 0.56f),
                                StrokeCommand.MoveTo(0.30f, 0.67f), StrokeCommand.LineTo(0.30f, 0.71f)
                            )
                        )
                    )
                ),
                DrawingStep(
                    stepNumber = 5,
                    title = "Bergschaduw & rimpels in het water",
                    instruction = "Arceer de rechterkant van de bergen voor schaduw en zet horizontale glinsterlijntjes in het meer.",
                    tip = "De schaduw aan één kant geeft direct drie dimensies aan het hele dal.",
                    strokes = listOf(
                        LessonStroke(
                            kind = StrokeKind.SHADING,
                            commands = listOf(
                                StrokeCommand.MoveTo(0.55f, 0.33f), StrokeCommand.LineTo(0.63f, 0.39f),
                                StrokeCommand.MoveTo(0.55f, 0.39f), StrokeCommand.LineTo(0.66f, 0.47f),
                                StrokeCommand.MoveTo(0.56f, 0.46f), StrokeCommand.LineTo(0.68f, 0.54f),
                                StrokeCommand.MoveTo(0.29f, 0.39f), StrokeCommand.LineTo(0.35f, 0.45f),
                                StrokeCommand.MoveTo(0.29f, 0.45f), StrokeCommand.LineTo(0.38f, 0.53f)
                            )
                        ),
                        LessonStroke(
                            kind = StrokeKind.DETAIL,
                            commands = listOf(
                                StrokeCommand.MoveTo(0.45f, 0.63f), StrokeCommand.LineTo(0.68f, 0.63f),
                                StrokeCommand.MoveTo(0.50f, 0.68f), StrokeCommand.LineTo(0.75f, 0.68f),
                                StrokeCommand.MoveTo(0.42f, 0.73f), StrokeCommand.LineTo(0.63f, 0.73f),
                                StrokeCommand.MoveTo(0.54f, 0.77f), StrokeCommand.LineTo(0.78f, 0.77f)
                            )
                        )
                    )
                )
            )
        ),

        // 9. Grappig Stripgezicht
        DrawingLesson(
            id = "strip_gezicht",
            title = "Grappig Stripgezicht",
            subtitle = "Speel met expressieve grote ogen, wilde lokken en cartoonlijnen.",
            category = LessonCategory.GEZICHTEN,
            difficulty = Difficulty.MAKKELIJK,
            durationMinutes = 5,
            pathOrder = 9,
            accentHex = 0xFFD0552B,
            steps = listOf(
                DrawingStep(
                    stepNumber = 1,
                    title = "Ronde basis met kruis",
                    instruction = "Teken een grote speelse cirkel en een licht gebogen middellijn die iets naar rechts kijkt.",
                    tip = "Door de middenlijn iets te buigen kijkt je stripfiguur schuin weg — super dynamisch!",
                    strokes = listOf(
                        LessonStroke(
                            kind = StrokeKind.CONSTRUCTION,
                            commands = listOf(
                                StrokeCommand.Circle(0.50f, 0.52f, 0.22f),
                                StrokeCommand.MoveTo(0.52f, 0.28f),
                                StrokeCommand.QuadTo(0.57f, 0.52f, 0.52f, 0.76f),
                                StrokeCommand.MoveTo(0.27f, 0.50f),
                                StrokeCommand.QuadTo(0.52f, 0.54f, 0.73f, 0.49f)
                            )
                        )
                    )
                ),
                DrawingStep(
                    stepNumber = 2,
                    title = "Grote stripogen & dikke neus",
                    instruction = "Teken twee grote ronde ogen dicht tegen elkaar met een flinke bolle neus die eroverheen wipt.",
                    tip = "Overlappende ogen en neus geven direct echte striptekening-charme.",
                    strokes = listOf(
                        LessonStroke(
                            kind = StrokeKind.OUTLINE,
                            commands = listOf(
                                StrokeCommand.Oval(0.46f, 0.46f, 0.065f, 0.08f),
                                StrokeCommand.Oval(0.60f, 0.46f, 0.065f, 0.08f),
                                StrokeCommand.MoveTo(0.53f, 0.49f),
                                StrokeCommand.CubicTo(0.64f, 0.48f, 0.64f, 0.58f, 0.52f, 0.57f)
                            )
                        )
                    )
                ),
                DrawingStep(
                    stepNumber = 3,
                    title = "Wangen, kin en oor",
                    instruction = "Trek de buitenlijn van het gezicht langs de grote lachwang en teken links een rond striptoortje.",
                    tip = "Maak de buitenlijn lekker vloeiend en zelfverzekerd.",
                    strokes = listOf(
                        LessonStroke(
                            kind = StrokeKind.OUTLINE,
                            commands = listOf(
                                StrokeCommand.MoveTo(0.31f, 0.44f),
                                StrokeCommand.CubicTo(0.24f, 0.46f, 0.25f, 0.58f, 0.31f, 0.58f),
                                StrokeCommand.CubicTo(0.33f, 0.72f, 0.46f, 0.76f, 0.58f, 0.72f),
                                StrokeCommand.CubicTo(0.68f, 0.68f, 0.72f, 0.58f, 0.71f, 0.46f)
                            )
                        )
                    )
                ),
                DrawingStep(
                    stepNumber = 4,
                    title = "Wild haar bovenop",
                    instruction = "Teken piekerige of krullende haarplukken boven op de kruin zodat hij een eigen karakter krijgt.",
                    tip = "Varieer de grootte van de lokken (groot, klein, groot) voor een leuk ritme.",
                    strokes = listOf(
                        LessonStroke(
                            kind = StrokeKind.OUTLINE,
                            commands = listOf(
                                StrokeCommand.MoveTo(0.30f, 0.43f),
                                StrokeCommand.CubicTo(0.27f, 0.31f, 0.35f, 0.21f, 0.44f, 0.25f),
                                StrokeCommand.CubicTo(0.46f, 0.16f, 0.58f, 0.15f, 0.60f, 0.25f),
                                StrokeCommand.CubicTo(0.68f, 0.22f, 0.75f, 0.32f, 0.71f, 0.44f)
                            )
                        )
                    )
                ),
                DrawingStep(
                    stepNumber = 5,
                    title = "Pupillen, wenkbrauwen & brede grijns",
                    instruction = "Zet de pupillen schuin naar rechts, voeg hoog opgetrokken wenkbrauwen toe en een grote blije glimlach!",
                    tip = "Kijk wat er gebeurt als je de wenkbrauwen iets schuin zet — meteen vol emotie!",
                    strokes = listOf(
                        LessonStroke(
                            kind = StrokeKind.DETAIL,
                            commands = listOf(
                                StrokeCommand.Circle(0.48f, 0.47f, 0.020f),
                                StrokeCommand.Circle(0.62f, 0.47f, 0.020f),
                                StrokeCommand.MoveTo(0.40f, 0.35f),
                                StrokeCommand.QuadTo(0.45f, 0.31f, 0.50f, 0.34f),
                                StrokeCommand.MoveTo(0.56f, 0.34f),
                                StrokeCommand.QuadTo(0.62f, 0.31f, 0.67f, 0.35f),
                                StrokeCommand.MoveTo(0.42f, 0.61f),
                                StrokeCommand.QuadTo(0.53f, 0.71f, 0.65f, 0.60f),
                                StrokeCommand.MoveTo(0.40f, 0.60f),
                                StrokeCommand.LineTo(0.43f, 0.63f),
                                StrokeCommand.MoveTo(0.36f, 0.61f),
                                StrokeCommand.LineTo(0.39f, 0.63f)
                            )
                        )
                    )
                )
            )
        ),

        // 10. Retro Fotocamera
        DrawingLesson(
            id = "retro_camera",
            title = "Retro Fotocamera",
            subtitle = "Combineer strakke rechthoeken en concentrische cirkels tot een coole camera.",
            category = LessonCategory.DINGEN,
            difficulty = Difficulty.UITDAGEND,
            durationMinutes = 9,
            pathOrder = 10,
            accentHex = 0xFF3B6E8C,
            steps = listOf(
                DrawingStep(
                    stepNumber = 1,
                    title = "Basisrechthoek & middenkruis",
                    instruction = "Teken een brede rechthoek als camerabody en zet een kruislijn iets rechts van het midden voor de lens.",
                    tip = "De kruislijn helpt je om de lens mooi rond en gecentreerd te krijgen.",
                    strokes = listOf(
                        LessonStroke(
                            kind = StrokeKind.CONSTRUCTION,
                            commands = listOf(
                                StrokeCommand.MoveTo(0.18f, 0.34f),
                                StrokeCommand.LineTo(0.82f, 0.34f),
                                StrokeCommand.LineTo(0.82f, 0.74f),
                                StrokeCommand.LineTo(0.18f, 0.74f),
                                StrokeCommand.LineTo(0.18f, 0.34f),
                                StrokeCommand.MoveTo(0.52f, 0.30f), StrokeCommand.LineTo(0.52f, 0.78f),
                                StrokeCommand.MoveTo(0.16f, 0.55f), StrokeCommand.LineTo(0.84f, 0.55f)
                            )
                        )
                    )
                ),
                DrawingStep(
                    stepNumber = 2,
                    title = "Afgeronde body & bovenplaat",
                    instruction = "Trek de body met zacht afgeronde hoeken over en voeg een scheidingslijn toe voor de metalen bovenplaat.",
                    tip = "Ronde hoekjes geven direct dat typische vintage gevoel.",
                    strokes = listOf(
                        LessonStroke(
                            kind = StrokeKind.OUTLINE,
                            commands = listOf(
                                StrokeCommand.MoveTo(0.22f, 0.34f),
                                StrokeCommand.LineTo(0.78f, 0.34f),
                                StrokeCommand.QuadTo(0.82f, 0.34f, 0.82f, 0.38f),
                                StrokeCommand.LineTo(0.82f, 0.70f),
                                StrokeCommand.QuadTo(0.82f, 0.74f, 0.78f, 0.74f),
                                StrokeCommand.LineTo(0.22f, 0.74f),
                                StrokeCommand.QuadTo(0.18f, 0.74f, 0.18f, 0.70f),
                                StrokeCommand.LineTo(0.18f, 0.38f),
                                StrokeCommand.QuadTo(0.18f, 0.34f, 0.22f, 0.34f),
                                StrokeCommand.MoveTo(0.18f, 0.43f),
                                StrokeCommand.LineTo(0.82f, 0.43f)
                            )
                        )
                    )
                ),
                DrawingStep(
                    stepNumber = 3,
                    title = "De grote cameralens",
                    instruction = "Teken drie concentrische cirkels rond je middenkruis: de buitenring, de lensrand en het binnenste glas.",
                    tip = "Draai desnoods je pols rustig mee bij het tekenen van de grote cirkel.",
                    strokes = listOf(
                        LessonStroke(
                            kind = StrokeKind.OUTLINE,
                            commands = listOf(
                                StrokeCommand.Circle(0.52f, 0.56f, 0.145f),
                                StrokeCommand.Circle(0.52f, 0.56f, 0.115f),
                                StrokeCommand.Circle(0.52f, 0.56f, 0.068f)
                            )
                        )
                    )
                ),
                DrawingStep(
                    stepNumber = 4,
                    title = "Zoeker, flitser & ontspanknop",
                    instruction = "Teken het prisma-kapje bovenop, een klein knopje rechtsboven en het rechthoekige kijkglas links.",
                    tip = "Deze kleine details maken het meteen onmiskenbaar een fotocamera.",
                    strokes = listOf(
                        LessonStroke(
                            kind = StrokeKind.OUTLINE,
                            commands = listOf(
                                StrokeCommand.MoveTo(0.41f, 0.34f),
                                StrokeCommand.LineTo(0.44f, 0.25f),
                                StrokeCommand.LineTo(0.60f, 0.25f),
                                StrokeCommand.LineTo(0.63f, 0.34f),
                                StrokeCommand.MoveTo(0.68f, 0.34f),
                                StrokeCommand.LineTo(0.68f, 0.29f),
                                StrokeCommand.LineTo(0.75f, 0.29f),
                                StrokeCommand.LineTo(0.75f, 0.34f),
                                StrokeCommand.MoveTo(0.24f, 0.365f),
                                StrokeCommand.LineTo(0.34f, 0.365f),
                                StrokeCommand.LineTo(0.34f, 0.41f),
                                StrokeCommand.LineTo(0.24f, 0.41f),
                                StrokeCommand.LineTo(0.24f, 0.365f)
                            )
                        )
                    )
                ),
                DrawingStep(
                    stepNumber = 5,
                    title = "Grip, glans in de lens & draagoogjes",
                    instruction = "Teken een verticale handgreep links, twee kleine oogjes aan de zijkanten en lichtreflecties in het lensglas.",
                    tip = "Twee kleine diagonale boogjes in de lens zorgen voor een echt glaseffect!",
                    strokes = listOf(
                        LessonStroke(
                            kind = StrokeKind.DETAIL,
                            commands = listOf(
                                StrokeCommand.MoveTo(0.27f, 0.43f), StrokeCommand.LineTo(0.27f, 0.74f),
                                StrokeCommand.Arc(0.52f, 0.56f, 0.045f, 0.045f, 200f, 60f),
                                StrokeCommand.Circle(0.55f, 0.59f, 0.012f),
                                StrokeCommand.MoveTo(0.18f, 0.47f),
                                StrokeCommand.LineTo(0.15f, 0.47f),
                                StrokeCommand.LineTo(0.15f, 0.51f),
                                StrokeCommand.LineTo(0.18f, 0.51f),
                                StrokeCommand.MoveTo(0.82f, 0.47f),
                                StrokeCommand.LineTo(0.85f, 0.47f),
                                StrokeCommand.LineTo(0.85f, 0.51f),
                                StrokeCommand.LineTo(0.82f, 0.51f)
                            )
                        )
                    )
                ),
                DrawingStep(
                    stepNumber = 6,
                    title = "Textuur & slagschaduw",
                    instruction = "Geef het grip-leer een fijne arcering en zet een lichte schaduw onder de camera. Gefeliciteerd, je hebt het hele pad voltooid!",
                    tip = "Deel je tekening of probeer hem nu uit je hoofd na te tekenen.",
                    strokes = listOf(
                        LessonStroke(
                            kind = StrokeKind.SHADING,
                            commands = listOf(
                                StrokeCommand.MoveTo(0.20f, 0.49f), StrokeCommand.LineTo(0.25f, 0.46f),
                                StrokeCommand.MoveTo(0.20f, 0.55f), StrokeCommand.LineTo(0.25f, 0.52f),
                                StrokeCommand.MoveTo(0.20f, 0.61f), StrokeCommand.LineTo(0.25f, 0.58f),
                                StrokeCommand.MoveTo(0.20f, 0.67f), StrokeCommand.LineTo(0.25f, 0.64f),
                                StrokeCommand.MoveTo(0.20f, 0.77f), StrokeCommand.LineTo(0.80f, 0.77f)
                            )
                        )
                    )
                )
            )
        )
    )
}
