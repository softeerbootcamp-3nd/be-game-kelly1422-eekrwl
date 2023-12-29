import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Omoke omoke = new Omoke();
        int cnt = 0;

        omoke.startGame();
        omoke.setPlayerName();
        while(true) {
            PrintBoard.print(omoke.getMap());
            omoke.putStone(cnt);
            if (omoke.hasWinner()) {
                break;
            }
            cnt++;
        }
    }
}