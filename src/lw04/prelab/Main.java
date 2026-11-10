package lw04.prelab;

import java.util.*;
 
public class Main {
 
    static void insertionSort(int[] a, int passes) {
        for (int i = 1; i <= passes; i++) {
            int n = a[i];
            int j = i - 1;
            
            while (j >= 0 && a[j] < n) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = n;   
        }
    }
 
   
    static int linearSearch(int[] a, int target) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == target) {
                return i;
            }
        }
        return -1;
    }
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(Main.class.getResourceAsStream("branches.txt"));
 
        int n = sc.nextInt();
        int[] branches = new int[n];
        for (int i = 0; i < n; i++) {
            branches[i] = sc.nextInt();
        }
 
        int m = sc.nextInt();
        int[] targets = new int[m];
        for (int i = 0; i < m; i++) {
            targets[i] = sc.nextInt();
        }
        sc.close();
 
        insertionSort(branches, 3);
 
        // tampilkan array setelah 3 pass
        for (int i = 0; i < n; i++) {
            System.out.print(branches[i]);
            if (i < n - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
 
        // cari tiap target
        for (int i = 0; i < m; i++) {
            int index = linearSearch(branches, targets[i]);
            if (index != -1) {
                System.out.println(targets[i] + ": FOUND at index " + index);
            } else {
                System.out.println(targets[i] + ": NOT FOUND");
            }
        }
    }
}
 

