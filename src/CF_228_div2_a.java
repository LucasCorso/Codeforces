import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Corso on 10.02.14.
 */

/*
A. Лиса и игра с числами
ограничение по времени на тест1 секунда
ограничение по памяти на тест256 мегабайт
вводстандартный ввод
выводстандартный вывод
Лиса Сиель играет с числами.

У Сиель есть n положительных целых чисел: x1, x2, ..., xn. Она может выполнять следующие операции столько раз, сколько ей нужно: выбрать два различных индекса i и j, таких, что выполняется условие xi > xj, а затем выполнить присвоение xi = xi - xj. Цель игры в том, чтобы сделать сумму всех чисел как можно меньше.

Пожалуйста, помогите Сиель найти эту минимальную сумму.

Входные данные
В первой строке содержится целое число n (2 ≤ n ≤ 100). Затем во второй строке записано n целых чисел: x1, x2, ..., xn (1 ≤ xi ≤ 100).

Выходные данные
Выведите единственное целое число — требуемую минимальную сумму.

Примеры тестов
входные данные
2
1 2
выходные данные
2
входные данные
3
2 4 6
выходные данные
6
входные данные
2
12 18
выходные данные
12
входные данные
5
45 12 27 30 18
выходные данные
15
 */


public class CF_228_div2_a {
    private int n;
    private int[] array;

    CF_228_div2_a(int n, int[] array) {
        this.n = n;
        this.array = array;

    }

    public int counting() {
        if (array.length > 1) {
            Arrays.sort(array);
            while (true) {
                if (array[array.length-1] > array[array.length-1]) {
                    array[array.length-1] = array[array.length-1] - array[array.length-2];
                    Arrays.sort(array);
                } else {
                    if (array[array.length-1] > array[0]){
                        for (int j = array.length-1; j>=0; j--){
                            if (array[array.length-1]> array[j]){
                                array[array.length-1] = array[array.length-1] -  array[j];
                                Arrays.sort(array);
                                continue;
                            }
                        }
                    } else {
                    break;}
                }
            }
        } else {
            return array[0];
        }
        int result = 0;
        for (int i: array){
            result+=i;
        }
        return result;
    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = input.nextInt();
        }

        CF_228_div2_a solution = new CF_228_div2_a(n, array);
        System.out.println(solution.counting());
    }
}
