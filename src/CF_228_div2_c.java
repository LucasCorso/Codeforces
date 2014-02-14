import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CF_228_div2_c {

    /**
     * Created by Corso on 10.02.14.
     */
//test
    public static int counting(int[] array) {
        int count = 0;
        boolean b;
        int temp = 0;
        List<List<Integer>> arrayLists = new ArrayList<List<Integer>>();

        Arrays.sort(array);
        for (int i = 1; i <= array.length; i++) {
            b = true;
            for (int j = 1; j <= i; j++) {
                arrayLists.add(new ArrayList<Integer>());
            }

            for (int k = array.length - 1; k >= 0; k--) {
                if (temp >= arrayLists.size()) {
                    temp = 0;
                }

                for (int x = 0; x < arrayLists.get(temp).size(); x++) {
                    arrayLists.get(temp).set(x, arrayLists.get(temp).get(x)-1);
                    if (arrayLists.get(temp).get(x) < 0) {
                        b = false;
                    }
                }
                arrayLists.get(temp).add(array[k]);
                temp++;
            }


            if (b == true) {
                count = i;
                break;
            }
            arrayLists.clear();
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] array = new int[input.nextInt()];
        for (int a = 0; a < array.length; a++) {
            array[a] = input.nextInt();
        }
        System.out.println(CF_228_div2_c.counting(array));
    }
//test
}