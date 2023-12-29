public class PrintBoard {
    public static void print (char[][] board) {
        System.out.print("   ");
        for (int i = 0; i < 17; i++) {
            System.out.printf("%2d ", i);
        }
        System.out.println();
        for (int i = 0; i < 17; i++) {
            System.out.printf("%2d ", i);
            for (int j = 0; j < 17; j++) {
                System.out.printf("%2c ", board[i][j]);
            }
            System.out.println();
        }
    }
}
