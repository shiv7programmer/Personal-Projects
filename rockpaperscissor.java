import java.util.Scanner;
import java.util.Random;

public class rockpaperscissor {
    Scanner scan = new Scanner(System.in);
    Random rand = new Random();

    public String takeInput() {
        System.out.println("Welcome to the Game of Rock Paper and Scissor!");
        System.out.println("Best out of 5!");
        System.out.println("Game Menu:");
        System.out.println("1. Rock");
        System.out.println("2. Paper");
        System.out.println("3. Scissor");
        System.out.println("Please pick a number for your move: ");
        int choiceNumber = scan.nextInt();
        String playerMove = "";
        switch (choiceNumber) {
            case 1:
                playerMove = "Rock";
                break;
            case 2:
                playerMove = "Paper";
                break;
            case 3:
                playerMove = "Scissor";
                break;
            default:
                playerMove = "Invalid Input";
        }
        System.out.println("Player Shape: " + playerMove);
        return playerMove;
    }

    public String compInput() {
        int compNum = rand.nextInt(3) + 1;
        String computerMove = "";
        switch (compNum) {
            case 1:
                computerMove = "Rock";
                break;
            case 2:
                computerMove = "Paper";
                break;
            case 3:
                computerMove = "Scissor";
                break;
        }
        System.out.println("Computer Shape: " + computerMove);
        return computerMove;
    }

    public boolean checkWin(String player, String computer) {
        return (player.equals("Rock") && computer.equals("Scissor")) ||
                (player.equals("Scissor") && computer.equals("Paper")) ||
                (player.equals("Paper") && computer.equals("Rock"));
    }

    public boolean checkDraw(String player, String computer) {
        return player.equals(computer);
    }

    public static void main(String[] args) {
        rockpaperscissor callmethod = new rockpaperscissor();
        int round = 0;
        int playerPoint = 0;
        int computerPoint = 0;
        while (round < 5) {
            String playerMove = callmethod.takeInput();
            String computerMove = callmethod.compInput();
            if (playerMove.equals("Invalid Input")) {
                System.out.println("Invalid move. Try again.\n");
                continue;
            }
            if (callmethod.checkDraw(playerMove, computerMove)) {
                System.out.println("It's a draw!");
            } else if (callmethod.checkWin(playerMove, computerMove)) {
                System.out.println("Player (" + playerMove + ") wins!\n");
                playerPoint++;
            } else {
                System.out.println("Computer (" + computerMove + ") wins!\n");
                computerPoint++;
            }
            round++;
            System.out.println();
        }
        System.out.println("Final Score: Player " + playerPoint + " - " + computerPoint + " Computer");
        if (playerPoint > computerPoint) {
            System.out.println("Player wins by " + (playerPoint - computerPoint));
        } else if (playerPoint < computerPoint) {
            System.out.println("Computer wins by " + (computerPoint - playerPoint));
        } else {
            System.out.println("It's a tie!");
        }
        System.out.println();
        System.out.println("Game Over!");
    }
}