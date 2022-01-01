package hackerrank.java.dataStructures;


import java.util.Scanner;

public class Java1DArrayPart2 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] a = new int[n];
        for(int i = 0 ; i < n; i++){
            int val = scan.nextInt();
            a[i] = val;
        }
        scan.close();

        // Prints each sequential element in array a
        for (int value : a) {
            System.out.println(value);
        }
    }
}
