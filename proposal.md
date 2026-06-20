# Tic‑Tac‑Toe JavaFX Project Proposal

---

## 1. Overview
A modern, premium‑styled **Tic‑Tac‑Toe** game built with **JavaFX**. The application will run on Windows, offering a sleek dark‑theme UI with glass‑morphism effects, smooth hover animations, and responsive layout. It is designed for two local players with an optional future AI opponent.

## 2. Objectives
1. **Fully functional game logic** – turn management, win/draw detection, reset capability.
2. **Premium UI** – dark background, custom Google Font *Outfit*, glass‑like panels, animated cell clicks.
3. **Build reproducibility** – Maven‑based project with a self‑contained wrapper for easy execution.
4. **Extensibility** – clean architecture allowing future features (AI, scoreboard, multi‑board sizes).

## 3. Technical Design
- **Project structure**
  - `pom.xml` – Maven configuration with Java 17 and JavaFX 22 dependencies.
  - `src/main/java/com/example/tictactoe/`
    - `Main.java` – entry point launching the `GameBoard` UI.
    - `GameBoard.java` – UI layout (GridPane) and game logic.
  - `src/main/resources/`
    - `style.css` – dark glass‑morphism stylesheet, custom font import.
    - `mvnw` / `mvnw.cmd` – Maven Wrapper for zero‑install builds.
- **UI/UX**
  - 3×3 grid of buttons sized 100 px, rounded corners, hover scale (1.05×) and fade‑in animation.
  - Status label shows current player, winner, or draw.
  - “Reset” button clears the board and restarts X’s turn.
- **Build & Run**
  ```powershell
  cd D:\tictactoe
  .\mvnw.cmd clean javafx:run
  ```
  This downloads Maven (if needed), resolves JavaFX modules, compiles, and launches the app.

## 4. Timeline & Deliverables
| Milestone | Description | Duration |
|-----------|-------------|----------|
| **Setup & Wrapper** | Create Maven wrapper, project skeleton, and basic pom.xml. | 1 day |
| **Game Logic** | Implement `GameBoard` with win/draw detection and reset. | 2 days |
| **Premium UI** | Design `style.css`, add animations, dark theme, custom font. | 2 days |
| **Testing & Polish** | Manual UI testing, bug fixing, final screenshots. | 1 day |
| **Documentation** | Write README, proposal.md, usage guide. | 1 day |

**Total effort:** ~7 working days.

---
*Prepared for the Tic‑Tac‑Toe JavaFX project.*
