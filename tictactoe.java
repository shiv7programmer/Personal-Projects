import java.util.Scanner;

public class tictactoe {
    public static String choiceofShape;
    public int choiceofnumber;
    public static int position;
    public static String[] array = new String[9];
    Scanner scan = new Scanner(System.in);

    public String ShapeChoice() {
        System.out.println("Game Menu:");
        System.out.println("1. X");
        System.out.println("2. O");
        System.out.println("Please pick a number of a shape you want to play with: ");
        choiceofnumber = scan.nextInt();
        choiceofShape = "";
        if (choiceofnumber == 1) {
            choiceofShape = "X";
            System.out.println("Player 1 Shape: " + choiceofShape);
        } else if (choiceofnumber == 2) {
            choiceofShape = "O";
            System.out.println("Player 1 Shape: " + choiceofShape);
        } else
            choiceofShape = "Invalid Input";
        return choiceofShape;
    }

    public void createBoard(String[] array) {
        System.out.println();
        for (int i = 0; i < array.length; i += 3) {
            System.out.println(" " + array[i] + " | " + array[i + 1] + " | " + array[i + 2]);
            if (i < 6)
                System.out.println("------------");
        }
        System.out.println();
    }

    public int positionChoice() {
        System.out.println("Positon Menu");
        System.out.println("1. Top Row Left Square");
        System.out.println("2. Top Row Middle Square");
        System.out.println("3. Top Row Right Square");
        System.out.println("4. Middle Row Left Square");
        System.out.println("5. Middle Row Middle Square");
        System.out.println("6. Middle Row Right Square");
        System.out.println("7. Bottom Row Left Square");
        System.out.println("8. Bottom Row Middle Square");
        System.out.println("9. Bottom Row Right Square");
        System.out.println("Please enter the number to place your shape: ");
        int user_choice = scan.nextInt() - 1;
        return user_choice;
    }

    public boolean checkEmptyPosition(int pos) {
        return array[pos].equals(" ");
    }

    public void EditBoard(String[] array, int position) {
        array[position] = choiceofShape;
    }

    public String ChangeShape(String choice) {
        if (choice.equals("X")) {
            choiceofShape = "O";
        } else if (choice.equals("O")) {
            choiceofShape = "X";
        }
        return choiceofShape;
    }

    public boolean checkWin(String[] array) {
        int[][] winPatterns = {
                { 0, 1, 2 }, { 3, 4, 5 }, { 6, 7, 8 },
                { 0, 3, 6 }, { 1, 4, 7 }, { 2, 5, 8 },
                { 0, 4, 8 }, { 2, 4, 6 }
        };

        for (int[] pattern : winPatterns) {
            if (array[pattern[0]].equals(choiceofShape) && array[pattern[1]].equals(choiceofShape)
                    && array[pattern[2]].equals(choiceofShape)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkDraw(String[] array) {
        for (String s : array) {
            if (s.equals(" ")) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("Welcome to the Game of TIC TAC TOE!");
        tictactoe callmethod = new tictactoe();
        for (int i = 0; i < array.length; i++) {
            array[i] = " ";
        }
        callmethod.ShapeChoice();
        callmethod.createBoard(array);
        for (int i = 0; i < array.length; i++) {
            position = callmethod.positionChoice();
            while (!callmethod.checkEmptyPosition(position)) {
                System.out.println("Position already taken! Choose a different spot.");
                position = callmethod.positionChoice();
            }
            callmethod.EditBoard(array, position);
            callmethod.createBoard(array);
            if (callmethod.checkWin(array)) {
                System.out.println("Player (" + choiceofShape + ") wins!");
                break;
            }
            if (callmethod.checkDraw(array)) {
                System.out.println("It's a draw!");
                break;
            }
            choiceofShape = callmethod.ChangeShape(choiceofShape);
        }
        System.out.println("Game Over!");
    }
}
