import java.util.Scanner;

/**
 * Created by Corso on 10.02.14.
 */

public class CF_228_div2_b {

    private char[][] array;

    public CF_228_div2_b(char[][] array) {
        this.array = array;

    }

    public boolean counting() {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[i][j] == '#') {

                    if (j != 0 && j != array.length - 1  && i<=array.length-3) {
                        if ( array[i + 1][j] == '#' &&
                                array[i + 2][j] == '#' &&
                                array[i + 1][j - 1] == '#' &&
                                array[i + 1][j + 1] == '#') {
                            array[i][j] = '0';
                            array[i + 1][j] = '0';
                            array[i + 2][j] = '0';
                            array[i + 1][j - 1] = '0';
                            array[i + 1][j + 1] = '0';
                        }

                    }
                }
            }

        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[i][j] == '#') {
                    count++;
                }
            }
        }
        if (count == 0) {
            return true;
        } else {
            return false;
        }

    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        char[][] array = new char[n][n];
        char[] temp;
        String[] arr = new String[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = input.next();
        }


        for (int i = 0; i < arr.length; i++) {
            temp = arr[i].toCharArray();
            for (int j = 0; j < temp.length; j++) {
                array[i][j] = temp[j];
            }
        }


        CF_228_div2_b solution = new CF_228_div2_b(array);
        if (solution.counting()) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
