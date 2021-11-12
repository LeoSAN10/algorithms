package bsu.entity;

public class HybridQuickSort extends Sort {

    public HybridQuickSort(int k) {
        super(k);
    }

    public void sort(int[] arr, int low, int high)
    {

        if (arr == null || arr.length == 0){
            return;
        }

        if (low >= high){
            return;
        }

        int middle = low + (high - low) / 2;
        int pivot = arr[middle];

        int i = low, j = high;
        while (i <= j)
        {
            while (arr[i] < pivot)
            {
                i++;
            }
            while (arr[j] > pivot)
            {
                j--;
            }
            if (i <= j)
            {
                swap (arr, i, j);
                i++;
                j--;
            }
        }
        if (low < j){
            if (j - low < k) {
                insertionSort(arr, low, j);
            } else {
                sort(arr, low, j);
            }
        }
        if (high > i){
            if (high - i < k) {
                insertionSort(arr, i, high);
            } else{
                sort(arr, i, high);
            }
        }
    }

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

    private void swap (int array[], int x, int y)
    {
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }
}
