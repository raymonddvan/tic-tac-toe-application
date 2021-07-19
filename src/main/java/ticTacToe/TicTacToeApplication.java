package ticTacToe;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class TicTacToeApplication extends Application {
    private Turn turn;
    
    public TicTacToeApplication() {
        this.turn = new Turn();
    }
    
    @Override
    public void start(Stage window) {
    	window.setTitle("TicTacToe Application");
        BorderPane layout = new BorderPane();
        layout.setPrefSize(300, 90);
        Label turnText = new Label("Turn: " + turn.getTurn());
        turnText.setPadding(new Insets(10, 10, 10, 10));
        turnText.setFont(Font.font("Verdana", 40));
        
        GridPane buttonLayout = new GridPane();
        buttonLayout.setVgap(10);
        buttonLayout.setHgap(10);
        buttonLayout.setPadding(new Insets(10, 10, 10, 10));
        
        Button[][] buttonBoard = new Button[3][3];
        TicTacToeBoard ticTacToeBoard = new TicTacToeBoard(buttonBoard);
    	for (int i = 0; i < 3; i++) {
    		for (int j = 0; j < 3; j++) {
    			Button button = new Button(" ");
                button.setFont(Font.font("Monospaced", 40));
                button.setOnAction((event) -> {
                    if (button.getText().equals(" ") && ticTacToeBoard.checkForWin() == false) {
                        button.setText(turn.getTurn());
                        turn.switchTurns();
                        turnText.setText("Turn: " + turn.getTurn());
                        ticTacToeBoard.inputBoard();
                    }
                    if (ticTacToeBoard.checkForWin() == true) {
                        turnText.setText("Winner: " + ticTacToeBoard.getWinner());
                    }
                    else if (ticTacToeBoard.checkForWin() == false && turn.getNumberOfTurns() == 9) {
                    	turnText.setText("It's a tie!");
                    }
                });
                buttonBoard[i][j] = button;
                buttonLayout.add(button, i, j);
    		}
    	}
    	
        HBox utilityButtons = new HBox();
        Button newGameButton = new Button();
        newGameButton.setText("New Game");
        newGameButton.setOnAction((event) -> {
        	ticTacToeBoard.clearBoard();
            turn.resetTurn();
            turnText.setText("Turn: " + turn.getTurn());
        });
        utilityButtons.getChildren().addAll(newGameButton);
        utilityButtons.setSpacing(10);
        utilityButtons.setPadding(new Insets(10, 10, 10, 10));
        
        layout.setTop(turnText);
        layout.setCenter(buttonLayout);
        layout.setBottom(utilityButtons);
        
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.show();
    }
    

    public static void main(String[] args) {
        launch(TicTacToeApplication.class);
    }

}
