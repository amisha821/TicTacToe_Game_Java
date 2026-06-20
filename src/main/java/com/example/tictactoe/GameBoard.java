package com.example.tictactoe;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.util.Duration;
import javafx.animation.ScaleTransition;
import javafx.animation.FadeTransition;

public class GameBoard extends VBox {
    private static final int SIZE = 3;
    private final Button[][] cells = new Button[SIZE][SIZE];
    private boolean xTurn = true; // X starts
    private final Label statusLabel = new Label("Turn: X");
    private final Button resetButton = new Button("Reset");

    public GameBoard() {
        setSpacing(10);
        setPadding(new Insets(20));
        setAlignment(Pos.CENTER);

        // Title
        Label title = new Label("Tic‑Tac‑Toe");
        title.setFont(Font.font("Outfit", FontWeight.BOLD, 24));
        title.setTextAlignment(TextAlignment.CENTER);

        // Grid
        GridPane grid = new GridPane();
        grid.setHgap(5);
        grid.setVgap(5);
        grid.setAlignment(Pos.CENTER);
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                Button btn = new Button();
                btn.setPrefSize(100, 100);
                btn.setFocusTraversable(false);
                final int row = i, col = j;
                btn.setOnAction(e -> handleMove(row, col));
                cells[i][j] = btn;
                grid.add(btn, j, i);
            }
        }

        // Bottom controls
        HBox bottom = new HBox(15, statusLabel, resetButton);
        bottom.setAlignment(Pos.CENTER);
        resetButton.setOnAction(e -> resetGame());

        getChildren().addAll(title, grid, bottom);
    }

    private void handleMove(int row, int col) {
        Button btn = cells[row][col];
        if (!btn.getText().isEmpty()) {
            return; // already taken
        }
        String mark = xTurn ? "X" : "O";
        btn.setText(mark);
        animateCell(btn);
        if (checkWin(mark)) {
            statusLabel.setText("Winner: " + mark);
            disableBoard();
        } else if (isDraw()) {
            statusLabel.setText("Draw!");
        } else {
            xTurn = !xTurn;
            statusLabel.setText("Turn: " + (xTurn ? "X" : "O"));
        }
    }

    private void animateCell(Button btn) {
        ScaleTransition st = new ScaleTransition(Duration.millis(150), btn);
        st.setFromX(0.8);
        st.setFromY(0.8);
        st.setToX(1.0);
        st.setToY(1.0);
        st.play();

        FadeTransition ft = new FadeTransition(Duration.millis(150), btn);
        ft.setFromValue(0.3);
        ft.setToValue(1.0);
        ft.play();
    }

    private boolean checkWin(String mark) {
        // rows & columns
        for (int i = 0; i < SIZE; i++) {
            if (cells[i][0].getText().equals(mark) &&
                cells[i][1].getText().equals(mark) &&
                cells[i][2].getText().equals(mark)) {
                highlightLine(cells[i][0], cells[i][1], cells[i][2]);
                return true;
            }
            if (cells[0][i].getText().equals(mark) &&
                cells[1][i].getText().equals(mark) &&
                cells[2][i].getText().equals(mark)) {
                highlightLine(cells[0][i], cells[1][i], cells[2][i]);
                return true;
            }
        }
        // diagonals
        if (cells[0][0].getText().equals(mark) &&
            cells[1][1].getText().equals(mark) &&
            cells[2][2].getText().equals(mark)) {
            highlightLine(cells[0][0], cells[1][1], cells[2][2]);
            return true;
        }
        if (cells[0][2].getText().equals(mark) &&
            cells[1][1].getText().equals(mark) &&
            cells[2][0].getText().equals(mark)) {
            highlightLine(cells[0][2], cells[1][1], cells[2][0]);
            return true;
        }
        return false;
    }

    private void highlightLine(Button... winners) {
        for (Button b : winners) {
            b.setStyle("-fx-background-color: #ffb74d; -fx-text-fill: #000000; -fx-font-weight: bold;");
        }
    }

    private boolean isDraw() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (cells[i][j].getText().isEmpty()) {
                    return false;
                }
            }
        }
        return true;
    }

    private void disableBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                cells[i][j].setDisable(true);
            }
        }
    }

    private void resetGame() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                cells[i][j].setText("");
                cells[i][j].setDisable(false);
                cells[i][j].setStyle("");
            }
        }
        xTurn = true;
        statusLabel.setText("Turn: X");
    }
}
