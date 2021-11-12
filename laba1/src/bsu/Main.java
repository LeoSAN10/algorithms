package bsu;

import bsu.action.AlgorithmAction;
import bsu.entity.HybridMergeSort;
import bsu.entity.HybridQuickSort;
import bsu.entity.Sort;

public class Main {
    private static int K = 5;
    private static final int R = 10;
    private static final int N = 20_000;
    private static final int M = 1000;

    public static void main(String[] args) {
        AlgorithmAction algAction = new AlgorithmAction();
        int[][] arrays = new int[R][N];
        algAction.fillArraysWithRandomAndGauss(arrays, M);
        algAction.printArrays(arrays);
        Sort hybridQuickSort = new HybridQuickSort(K);
        Sort hybridMergeSort = new HybridMergeSort(K);
        System.out.println("=== with quick sort ====");
        algAction.findTheOptimalK(arrays, hybridQuickSort, K, true);
        System.out.println("===with merge sort ===================");
        algAction.findTheOptimalK(arrays, hybridMergeSort, K,true);
    }



}
