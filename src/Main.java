import javax.swing.*;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Color;

public class Main {
    public static void main(String[] args) {

        setupBoard board = new setupBoard();
        logicalBoard boardLogic = new logicalBoard();
        int[][] logicArray = boardLogic.getLogicalBoard();

        JButton[][] buttons = board.createBoard();


        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons[i].length; j++) {
                int row = i;
                int column = j;


                buttons[i][j].addActionListener(e -> {
                    int gameCondition = 0;
                    if (logicArray[row][column] == 0) {
                        boolean player1Turn = boardLogic.switchPlayerTurn();
                        
                        if (player1Turn) {

                            int newRow = logicalBoard.player1Move(row, column, logicArray);
                            buttons[newRow][column].setBackground(Color.RED);
                            gameCondition = boardLogic.findConnectFour(1);

                            if(gameCondition == 1){
                                System.out.println("Player 1 Wins!");
                                board.changeStatusLabel("Player 1 Wins!", Color.RED);
                                board.endGame(Color.RED);
                            }

                        } else {
                            int newRow = logicalBoard.player2Move(row, column, logicArray);
                            buttons[newRow][column].setBackground(Color.BLUE);
                            gameCondition = boardLogic.findConnectFour(2);
                            if(gameCondition == 2){
                                System.out.println("Player 2 Wins!");
                                board.changeStatusLabel("Player 2 Wins!", Color.BLUE);
                                board.endGame(Color.BLUE);
                            }
                        }
                    }
                    logicalBoard.printBoard(logicArray);
                });
            }
        }
    }
}