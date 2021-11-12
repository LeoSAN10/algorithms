package bsu.entity;

public class HybridMergeSort extends Sort{

    public HybridMergeSort(int k) {
        super(k);
    }

    public void sort(int arr[], int l, int r)
    {
        if (l < r) {
            int m =l+ (r-l)/2;

            if (m - l < k) {
                insertionSort(arr, l, m);
            } else {
                sort(arr, l, m);
            }
            if (r - m + 1 < k) {
                insertionSort(arr, m + 1, r);
            } else {
                sort(arr, m + 1, r);
            }

            merge(arr, l, m, r);
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


    private void merge(int arr[], int l, int m, int r)
    {

        int n1 = m - l + 1;
        int n2 = r - m;


        int L[] = new int[n1];
        int R[] = new int[n2];


        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];


        int i = 0, j = 0;

        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
}
