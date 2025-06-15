import java.util.Scanner;
import java.util.Random;

public class BoardGameDiceRoller {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        System.out.println("Welcome to my Dice Roller!");

        System.out.print("Enter number of players: ");
        int numPlayers = sc.nextInt();
        sc.nextLine(); // consume newline

        System.out.print("Enter number of sides on the dice ");
        int sides = sc.nextInt();
        sc.nextLine(); // consume newline

        System.out.print("Enter how many dice to roll per turn: ");
        int numDice = sc.nextInt();
        sc.nextLine(); // consume newline

        int currentPlayer = 1;

        while (true) {
            System.out.println("\nPlayer " + currentPlayer + "'s turn. Press Enter to roll the dice...");
            sc.nextLine();

            int sum = 0;
            int[] diceRolls = new int[numDice];
            for (int i = 0; i < numDice; i++) {
                diceRolls[i] = rand.nextInt(sides) + 1;
                sum += diceRolls[i];
            }

            System.out.print("You rolled: ");
            for (int roll : diceRolls) {
                System.out.print(roll + " ");
            }
            System.out.println("\nTotal: " + sum);

            if (numDice == 2 && diceRolls[0] == diceRolls[1]) {
                System.out.println("Doubles! You get an extra turn.");
            } else {
                currentPlayer++;
                if (currentPlayer > numPlayers) {
                    currentPlayer = 1;
                }
            }

            System.out.print("Roll again? (yes/no): ");
            String answer = sc.nextLine().trim().toLowerCase();
            if (!answer.equals("yes")) {
                System.out.println("Thanks for playing! Goodbye.");
                break;
            }
        }

        sc.close();
    }
}
