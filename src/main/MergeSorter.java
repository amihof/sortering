package main;

public class MergeSorter implements IntSorter{

    @Override
    public void sort(int[] a) {
        int length = a.length;
        int r = 0;
        int K = 75;

        if (length < 2){
            return;
        }

        if (length - r > K){
            int mid = length /2;
            int [] left = new int[mid];
            int [] right = new int[length-mid];

            int k = 0;
            for(int i = 0;i<length;++i){
                if(i<mid){
                    left[i] = a[i];
                }
                else{
                    right[k] = a[i];
                    k = k+1;
                }
            }
            sort(left);
            sort(right);

            merge(left,right,a,mid,length-mid);
        }else{
            insertionSort(a);
        }

    }

    public void merge(int[] left, int[] right, int[] a, int leftSize, int rightSize){
        int i=0,l=0,r = 0;

        while(l<leftSize && r<rightSize){

            if(left[l]<right[r]){
                a[i++] = left[l++];
            }
            else{
                a[i++] = right[r++];
            }
        }

        while(l<leftSize){
            a[i++] = left[l++];
        }
        while(r<rightSize){
            a[i++] = right[r++];
        }

    }

    public void insertionSort(int[] a){
        int N = a.length;
        for (int i = 0; i < N; i++) {
            for (int j = i; j > 0 && a[j] < a[j-1]; j--) {
                int x = a[j]; a[j] = a[j-1]; a[j-1] = x;
            }
        }
    }
}
