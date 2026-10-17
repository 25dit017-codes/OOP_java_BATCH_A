import java.util.Random;
import java.util.Scanner;

public class RPSLS {
    enum Move { ROCK, PAPER, SCISSORS, LIZARD, SPOCK }

    static String winner(Move a, Move b) {
        if (a == b) return "Tie";
        return switch (a) {
            case ROCK -> (b == Move.SCISSORS || b == Move.LIZARD) ? "Player" : "Computer";
            case PAPER -> (b == Move.ROCK || b == Move.SPOCK) ? "Player" : "Computer";
            case SCISSORS -> (b == Move.PAPER || b == Move.LIZARD) ? "Player" : "Computer";
            case LIZARD -> (b == Move.PAPER || b == Move.SPOCK) ? "Player" : "Computer";
            case SPOCK -> (b == Move.ROCK || b == Move.SCISSORS) ? "Player" : "Computer";
        };
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        Move[] moves = Move.values();
        int playerScore = 0, computerScore = 0, ties = 0;

        for (int round = 1; round <= 5; round++) {
            System.out.println("\nRound " + round);
            System.out.println("Moves: ROCK, PAPER, SCISSORS, LIZARD, SPOCK");
            System.out.print("Enter your move: ");
            Move playerMove;
            try {
                playerMove = Move.valueOf(sc.next().toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid move. Round repeated.");
                round--;
                continue;
            }

            Move computerMove = moves[random.nextInt(moves.length)];
            System.out.println("Your move: " + playerMove);
            System.out.println("Computer move: " + computerMove);
            String result = winner(playerMove, computerMove);
            if (result.equals("Player")) playerScore++;
            else if (result.equals("Computer")) computerScore++;
            else ties++;
            System.out.println("Round result: " + result);
        }

        System.out.println("\n--- Final Score ---");
        System.out.println("Player: " + playerScore);
        System.out.println("Computer: " + computerScore);
        System.out.println("Ties: " + ties);
        if (playerScore > computerScore) System.out.println("Overall winner: Player");
        else if (computerScore > playerScore) System.out.println("Overall winner: Computer");
        else System.out.println("Overall result: Tie");
        sc.close();
    }
}
