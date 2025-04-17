package LeetCode_3238;

public class Solution {
    private static final int MAX_COLORS = 11;
    public int winningPlayerCount(int n, int[][] pick) {
         int[][] playerColorMatrix = new int[n][MAX_COLORS];
        // initialize each possible player
        for (int i = 0; i < n; i++) {
            int[] zeroInitializer = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
            playerColorMatrix[i] = zeroInitializer;
        }
        //System.out.println("INITIAL PLAYER COLOR MATRIX");
        //printPlayerColorMatrix(playerColorMatrix, n);

        // Process pick
        int rows = pick.length;
        for (int r=0; r < rows; r++) {
            int playerNumber = pick[r][0];
            int playerColor = pick[r][1];
           // System.out.println("Player: " + playerNumber + " Color: " + playerColor);
            playerColorMatrix[playerNumber][playerColor] += 1;
            //printPlayerColorMatrix(playerColorMatrix, n);
        }

        //System.out.println("FINAL PLAYER COLOR MATRIX");
        //printPlayerColorMatrix(playerColorMatrix, n);
        // Count the number of winning players
        int winningPlayers = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < MAX_COLORS; j++) {
                if (playerColorMatrix[i][j] > i) {
                    winningPlayers += 1;
                    break;
                }
            }
        }
        return winningPlayers;
    }

    public void printPlayerColorMatrix(int[][] playerColorMatrix, int n) {
        System.out.println("Player Color Matrix: ");
        for (int r=0; r < n; r++) {
            System.out.print("row: " + r +  ": ");
            for (int c=0; c < 10; c++) {
                System.out.print(playerColorMatrix[r][c] + " ");
            }
            System.out.println();
        }
        System.out.println("*** Player Color Matrix ***\n\n");
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] pick = {
                {0,0},{1,0},{1,0},{2,1},{2,1},{2,0}
        };
        int winningPlayers = solution.winningPlayerCount(4, pick);
        System.out.println("Winning players: " + winningPlayers);
    }
}
