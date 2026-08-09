import java.util.Scanner;

public class Majorelement {
    public int[] menu() {
        Scanner scan = new Scanner(System.in);
        System.out.print("How many number you want to enter: ");
        int num = scan.nextInt();
        System.out.println("");
        scan.nextLine();
        System.out.println("Enter the " + num + " integers: ");
        String numbers = scan.nextLine();
        String[] strNums = numbers.split(" ");
        int[] intArray = new int[strNums.length];

        for (int i = 0; i < strNums.length; i++) {
            intArray[i] = Integer.parseInt(strNums[i]);
        }
        return intArray;
    }

    public void InsertionSort(int[] array) {
        for (int p = 1; p < array.length; p++) {
            int tmp = array[p];
            int j = p;
            for (; j > 0 && tmp < array[j - 1]; j--)
                array[j] = array[j - 1];
            array[j] = tmp;
        }
    }

    public int[] check(int n, int[] arr) {
        int checkarr[] = new int[arr.length];
        int value = (n / 3);
        for (int i = 0; i < arr.length; i++) {
            int count = 1;
            boolean alreadyCounted = false;
            for (int k = 0; k < i; k++) {
                if (arr[i] == arr[k]) {
                    alreadyCounted = true;
                    break;
                }
            }
            if (alreadyCounted)
                continue;

            for (int j = i + 1; j < arr.length - 1; j++) {
                if (arr[i] == arr[j])
                    count++;

            }
            if (count > value)
                checkarr[i] = arr[i];

        }
        return checkarr;
    }

    public static void main(String[] args) {
        Majorelement callmethod = new Majorelement();
        int arr[] = callmethod.menu();
        System.out.print("Input Array: " + "{");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("}");
        callmethod.InsertionSort(arr);

        System.out.print("Sorted Array: " + "{");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("}");

        /*
         * System.out.print("Output Array: " + "{");
         * int[] outputarr = callmethod.check(arr.length, arr);
         * for (int i = 0; i < outputarr.length; i++) {
         * if (outputarr[i] != 0)
         * System.out.print(outputarr[i] + " ");
         * }
         * System.out.println("}");
         */
    }
}