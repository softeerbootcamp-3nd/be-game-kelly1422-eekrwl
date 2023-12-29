import java.util.Arrays;
import java.util.Scanner;

public class Omoke {
    private char map[][];
    private String player[] = new String[2];
    private char stone[] = {'O', 'X'};
    private int nowStoneX;
    private int nowStoneY;
    private String nowName;
    Scanner sc = new Scanner(System.in);

    public void startGame() {
        System.out.println("오목 게임을 시작합니다.");
        Scanner sc = new Scanner(System.in);
        map = new char[17][17];
        for (int i = 0 ; i < 17; i++) {
            Arrays.fill(map[i], '•');
        }
    }

    public void setPlayerName() {
        System.out.println("먼저 돌을 놓는 플레이어의 이름을 입력해주세요,");
        player[0] = sc.next();

        System.out.println("다음 플레이어의 이름을 입력해주세요.");
        while(true) {
            player[1] = sc.next();
            if (!player[0].equals(player[1])) break;
            else System.out.println("중복된 이름입니다. 다른 이름을 입력해주세요.");
        }
    }

    public void putStone(int cnt) {
        nowName = player[cnt%2];
        System.out.println(nowName + "님, 돌을 둘 좌표를 입력해주세요.");

        nowStoneX = sc.nextInt();
        nowStoneY = sc.nextInt();

        while (true) {
            if (!isInBoard(nowStoneX, nowStoneY)) {
                System.out.println("놓을 수 있는 위치가 아닙니다.");
            } else if (map[nowStoneX][nowStoneY] != '•') {
                System.out.println("이미 다른 돌이 놓여져 있습니다.");
            } else {
                break;
            }
            nowStoneX = sc.nextInt();
            nowStoneY = sc.nextInt();
        }

        map[nowStoneX][nowStoneY] = stone[cnt%2];
    }

    public boolean hasWinner() {
        int[][] dir = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, -1}, {-1, 1}};
        char nowStone = map[nowStoneX][nowStoneY];
        for (int i = 0; i < 4; i++) {
            int cnt = 0;
            int tmpX = nowStoneX + (dir[i*2][0]);
            int tmpY = nowStoneY + (dir[i*2][1]);
            while (isInBoard(tmpX, tmpY) && map[tmpX][tmpY] == nowStone) {
                cnt++;
                tmpX += dir[i*2][0];
                tmpY += dir[i*2][1];
            }

            tmpX = nowStoneX + (dir[i*2+1][0]);
            tmpY = nowStoneY + (dir[i*2+1][1]);
            while (isInBoard(tmpX, tmpY) && map[tmpX][tmpY] == nowStone) {
                cnt++;
                tmpX += dir[i*2+1][0];
                tmpY += dir[i*2+1][1];
            }

            if (cnt == 4) {
                PrintBoard.print(map);
                System.out.println(nowName + "님 승리하셨습니다.🎉");
                return true;
            }
        }
        return false;
    }

    public boolean isInBoard(int x, int y) {
        return (x >= 0 && x <= 16) && (y >= 0 && y <= 16);
    }

    public char[][] getMap() {
        return map;
    }
}