package bsu.action;

import bsu.entity.Sort;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class AlgorithmAction {

    private void insertionSort(int arr[], int begin,int end)
    {
        for (int i = begin; i <= end; ++i) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }

            arr[j + 1] = key;
        }
    }


    public void fillArraysWithRandomAndGauss(int[][] arrays, int m) {
        Random random = new Random();
        final int R = arrays.length;
        final int N = arrays[0].length;
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < N; j++) {
                if (i+1 % 2 == 0) {
                    arrays[i][j] = (int) random.nextGaussian() * m;
                } else {
                    arrays[i][j] = random.nextInt(m);
                }
            }
        }
    }

    public int findTheOptimalK(int[][] arrays, Sort sortObj, int k, boolean toPrint) {
        final int R = arrays.length;
        final int N = arrays[0].length;
        final int GAP = N/50;
        long start;
        long end;
        long currTimeInMillis;
        long minTimeInMillis = Long.MAX_VALUE;
        long bestK = -1;
        for( ; k < N/2; k+=GAP) {
            sortObj.setK(k);
            int[][] tempArrays = new int[arrays.length][];
            for(int i = 0; i < arrays.length; i++) {
                tempArrays[i] = arrays[i].clone();
            }
            if (toPrint) System.out.println("K = " + k);
            start = System.nanoTime();
            for(int i = 0; i < R; i++) {
                sortObj.sort(tempArrays[i],0, N-1);
            }
            end = System.nanoTime();
            currTimeInMillis = TimeUnit.NANOSECONDS.toMillis(end - start);
            if (currTimeInMillis < minTimeInMillis) {
                minTimeInMillis = currTimeInMillis;
                bestK = k;
            }
            if (toPrint) {
                System.out.println("Execution time = " + currTimeInMillis);
                System.out.println("=================================================================");
            }
        }

        if(toPrint) System.out.println("Min execution time: " + minTimeInMillis + " millis with K = " + bestK);
        return (int) bestK;
    }

    public void printArrays(int[][] arrays) {
        for(int[] arr : arrays) {
            System.out.println(Arrays.toString(arr));
        }
    }
}
