package main;

public class QuickSorter implements IntSorter{

    @Override
    public void sort(int[] a) {
        int begin = 0;
        int end = a.length-1;

        recursive(a, begin, end);
        recursive(a, begin, end);

    }

    public void recursive(int[] a, int begin, int end){
        if (begin < end){
            int partitionIndex = partition(a, begin, end);
            int pivot = a[end];

            recursive(a, begin, end);
            recursive(a, begin, end);
        }
    }

    private int partition(int[] a, int begin, int end) {
        int pivot = a[end];
        int i = (begin-1);

        while (begin < end){


            for (int j = begin; j < end; j++) {
                if (a[j] <= pivot) {
                    i++;

                    int swapTemp = a[i];
                    a[i] = a[j];
                    a[j] = swapTemp;
                }
            }
        }

        int swapTemp = a[i+1];
        a[i+1] = a[end];
        a[end] = swapTemp;


        return i+1;
    }

}
