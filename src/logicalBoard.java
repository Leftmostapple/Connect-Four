public class logicalBoard {
    int[][] board = new int[6][7];
    boolean player1Turn = false;

    public boolean switchPlayerTurn(){
        if(player1Turn){
            player1Turn = false;
        } else {
            player1Turn = true;
        }
        return player1Turn;
    }

    public int[][] getLogicalBoard(){
        return board;
    }

    public static int player1Move(int row, int column, int[][] board){
        while(row+1 < board.length){
            if(board[row+1][column] == 0){
                row++;
            } else {
                board[row][column] = 1;
                return row;
            }
        }
        board[row][column] = 1;
        return row;
    }

    public static int player2Move(int row, int column, int[][] board){
        while(row+1 < board.length){
            if(board[row+1][column] == 0){
                row++;
            } else {
                board[row][column] = 2;
                return row;
            }
        }
        board[row][column] = 2;
        return row;
    }

    public int findConnectFour(int player){
        int[][] logicalArray = getLogicalBoard();
        int gameCondition = 0;

        for(int i = 0; i < logicalArray.length; i++){
            for(int j = 0; j < logicalArray[i].length; j++){
                if(logicalArray[i][j] == player){
                    int counter = 0;
                    for(int h = 0; h < 4; h++){
                        if(i+h < logicalArray.length) {
                            if (logicalArray[i + h][j] == player) {
                                counter++;
                                if (counter == 4) {
                                    gameCondition = player;
                                    return gameCondition;
                                }
                            } else {
                                break;
                            }
                        }
                    }
                }

                if(logicalArray[i][j] == player){
                    int counter = 0;
                    for(int h = 0; h < 4; h++){
                        if(j+h < logicalArray[i].length) {
                            if (logicalArray[i][j+h] == player) {
                                counter++;
                                if (counter == 4) {
                                    gameCondition = player;
                                    return gameCondition;
                                }
                            } else {
                                break;
                            }
                        }
                    }
                }

                if(logicalArray[i][j] == player){
                    int counter = 0;
                    for(int h = 0; h < 4; h++){
                        if(j+h < logicalArray[i].length && i+h < logicalArray.length) {
                            if (logicalArray[i+h][j+h] == player) {
                                counter++;
                                if (counter == 4) {
                                    gameCondition = player;
                                    return gameCondition;
                                }
                            } else {
                                break;
                            }
                        }
                    }
                }

                if(logicalArray[i][j] == player){
                    int counter = 0;
                    for(int h = 0; h < 4; h++){
                        if(j-h >= 0 && i+h < logicalArray.length) {
                            if (logicalArray[i+h][j-h] == player) {
                                counter++;
                                if (counter == 4) {
                                    gameCondition = player;
                                    return gameCondition;
                                }
                            } else {
                                break;
                            }
                        }
                    }
                }
            }
        }

        return gameCondition;
    }

    public static void printBoard(int[][] board){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
        System.out.println("\n\n");
    }
}
