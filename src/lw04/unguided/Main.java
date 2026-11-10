package lw04.unguided;

import java.util.*;

public class Main {
    
    static void bubbleSort(int[] a, int passes) {
        int n = a.length;
        for (int i = 0; i < passes; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (a[j] < a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
    }

    static int binarSearch(int[] a, int target) {
        int low = 0;
        int high = a.length - 1;
        int steps = 0;

        while (low <= high) {
            int mid = (low + high) / 2;
            steps++;

            if (a[mid] == target) {
                return steps;
            } else if (a[mid] < target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return steps;
    }

    static int binarySearchIndex(int[] a, int target) {
        int low = 0;
        int high = a.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (a[mid] == target) {
                return mid;
            } else if (a[mid] < target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(Main.class.getResourceAsStream("parcels.txt"));

        int n = sc.nextInt();
        int[] parcels = new int[n];

        for (int i = 0; i < n; i++) {
            parcels[i] = sc.nextInt();
        }

        int m = sc.nextInt();
        int[] targets = new int[m];

        for (int i = 0; i < m; i++) {
            targets[i] = sc.nextInt();
        }
        sc.close();

        //sorting 2 passes
        bubbleSort(parcels, 2);

        //simpan hasil sorting 2 passes
        int[] afterTwoPasses = new int[n];
        for (int i = 0; i < n; i++) {
            afterTwoPasses[i] = parcels[i];
        }

        //lanjut sorting sampai selesai
        bubbleSort(parcels, n - 3);

        //output
        System.out.println("==== After 2 Passes ====");

        for (int i = 0; i < n; i++) {
            System.out.print(afterTwoPasses[i]);
            if (i < n - 1) {
                System.out.print(" ");
            }
        }

        System.out.println();
        System.out.println("==== Fully Sorted ====");

        for (int i = 0; i < n; i++) {
            System.out.print(parcels[i]);

            if (i < n - 1) {
                System.out.print(" ");
            }
        }

        System.out.println();
        System.out.println("==== Search Results ====");

        for (int i = 0; i < m; i++) {

            int index = binarySearchIndex(parcels, targets[i]);
            int steps = binarSearch(parcels, targets[i]);

            if (index != -1) {
                System.out.println(targets[i] + ": FOUND at index " + index + " (steps: " + steps + ")");
            } else {
                System.out.println(targets[i] + ": NOT FOUND (steps: " + steps + ")");
            }
        }
    }
}