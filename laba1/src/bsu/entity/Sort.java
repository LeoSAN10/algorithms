package bsu.entity;

public abstract class Sort {
    protected int k;

    public Sort(int k) {
        this.k = k;
    }

    public void setK(int k) {
        this.k = k;
    }

    public abstract void sort(int[] arr, int start, int end);
}
