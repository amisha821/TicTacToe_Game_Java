# Tic‑Tac‑Toe JavaFX – Project Description

## Project Summary
A sleek, desktop‑only **Tic‑Tac‑Toe** game built with **JavaFX 22** and **Maven**. It features a premium dark‑theme UI with glass‑morphism effects, smooth hover animations, and clear turn‑based gameplay for two local players.

## Features
- **Two‑player local mode** – X starts, alternating turns.
- **Win detection** – Highlights the winning line with a distinct color.
- **Draw detection** – Announces a draw when the board is full.
- **Reset button** – Clears the board and starts a new game.
- **Premium UI** – Dark background, custom Google Font *Outfit*, glass‑morphism panels, animated cell clicks.
- **Cross‑platform** – Runs on any system with Java 17+ and JavaFX support (tested on Windows).

## Technology Stack
- **Language**: Java 17
- **UI Framework**: JavaFX 22 (controls & FXML)
- **Build Tool**: Maven 3.9.6 (wrapper included for zero‑install builds)
- **Styling**: CSS with dark theme, glass‑morphism, and smooth transitions.
- **Version Control**: Git (ready for GitHub).

## Repository Layout
```
[tictactoe/]
│   pom.xml                     # Maven configuration (JavaFX deps, plugins)
│   description.md              # This file – project overview for GitHub
│   proposal.md                 # Project proposal & timeline (internal)
│   mvnw, mvnw.cmd              # Maven Wrapper – self‑contained build
│   .mvn/                       # Wrapper JAR & properties
│
├─ src/main/java/com/example/tictactoe/
│   ├─ Main.java                # JavaFX Application entry point
│   └─ GameBoard.java           # UI layout, game logic, animations
│
├─ src/main/resources/
│   ├─ style.css                # Dark glass‑morphism stylesheet, custom font
│   └─ (optional) assets/...    # Images or other resources
│
└─ target/                      # Generated build artifacts (after mvn package)
```

## Installation & Running
1. **Clone the repository** (or copy the folder to your machine).
2. Open a terminal in the project root (`D:\tictactoe`).
3. Run the application using the Maven Wrapper (no prior Maven install required):
   ```powershell
   .\mvnw.cmd clean javafx:run
   ```
   - The wrapper will download Maven automatically, resolve JavaFX modules, compile the code, and launch the UI.
4. Alternatively, if you have Maven installed globally, you can use:
   ```bash
   mvn clean javafx:run
   ```

## How to Contribute
- **Fork** the repository on GitHub.
- Create a new **feature branch** for any enhancements (e.g., AI opponent, scoreboard).
- Follow the existing coding style (Java 17, JavaFX conventions, CSS naming).
- Submit a **pull request** with a clear description of changes.

## License
This project is released under the **MIT License** – feel free to use, modify, and distribute.


