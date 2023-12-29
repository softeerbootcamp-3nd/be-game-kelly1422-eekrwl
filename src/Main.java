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
            if (cnt == 17*17) {
                System.out.println("게임 판이 가득 찼습니다. 승자 없이 게임이 종료되었습니다.");
                break;
            }
        }
    }
}