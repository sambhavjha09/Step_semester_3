import java.util.Scanner;
import java.util.Random;
public class RockPaperScissors {

    static String playRound(String playerMove, String computerMove) {
        if (playerMove.equals(computerMove)) {
            return "Draw";
        }

        if ((playerMove.equals("Rock") && computerMove.equals("Scissors")) ||
            (playerMove.equals("Paper") && computerMove.equals("Rock")) ||
            (playerMove.equals("Scissors") && computerMove.equals("Paper"))) {
            return "Player Wins";
        }

        return "Computer Wins";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int n = 5;
        String[] playerMoves = new String[n];
        String[] computerMoves = new String[n];
        String[] results = new String[n];
        String[] moves = {"Rock", "Paper", "Scissors"};
        int wins = 0;
        int losses = 0;
        int draws = 0;

        for (int i = 0; i < n; i++) {
            System.out.print("Enter your move: ");
            playerMoves[i] = sc.next();
            computerMoves[i] = moves[random.nextInt(3)];
            results[i] = playRound(playerMoves[i], computerMoves[i]);

            if (results[i].equals("Player Wins")) {
                wins++;
            } else if (results[i].equals("Computer Wins")) {
                losses++;
            } else {
                draws++;
            }
        }
        double winPercentage = (wins * 100.0) / n;

        System.out.println();
        System.out.println("Final Summary");

        System.out.printf("%-8s %-15s %-17s %-15s%n",
                "Round", "Player Move", "Computer Move", "Result");

        for (int i = 0; i < n; i++) {
            System.out.printf("%-8d %-15s %-17s %-15s%n",
                    i + 1, playerMoves[i], computerMoves[i], results[i]);
        }
        System.out.println();
        System.out.println("Wins   : " + wins);
        System.out.println("Losses : " + losses);
        System.out.println("Draws  : " + draws);
        System.out.printf("Win %%  : %.1f%%%n", winPercentage);
        sc.close();
    }
}