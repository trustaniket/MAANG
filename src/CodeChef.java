import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class CodeChef {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();

        Integer[] arr = new Integer[size];
        sc.nextLine();
        for(int i = 0; i < size; i++)
            arr[i] = sc.nextInt();

        Arrays.sort(arr, Collections.reverseOrder());



        int out = 0;

        for(int i = 1; i < size - 1; i++){
            arr[i+1] = arr[i-1] + arr[i];
        }

        System.out.println(arr[size-1]);
    }
}
