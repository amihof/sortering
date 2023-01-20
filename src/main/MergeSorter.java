package main;

import java.util.Arrays;
import java.util.Random;

public class MergeSorter implements IntSorter{

    @Override
    public void sort(int[] a) {
        int length = a.length;

        if (length < 2){
            return;
        }

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

    public static void main(String[] args) {
        IntSorter sorter = new MergeSorter();

        Random rand = new Random();
        int[] array = new int[10];

        for(int i = 0; i< array.length;i++){
            array[i] = rand.nextInt(50);
        }
        System.out.println("UnSorted Array: " + Arrays.toString(array));
        sorter.sort(array);
        System.out.println("Sorted array: " + Arrays.toString(array));
    }
}
