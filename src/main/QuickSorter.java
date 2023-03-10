package main;

import java.util.Random;

public class QuickSorter implements IntSorter{

    @Override
    public void sort(int[] a) {
        int begin = 0;
        int end = a.length-1;
        int pivotIndex = new Random().nextInt(end-begin) + begin;
        int pivot = a[pivotIndex];

        int swapTemp = a[pivotIndex];
        a[pivotIndex] = a[end];
        a[end] = swapTemp;

        int pointer = partition(a, begin, end, pivot);

        recursive(a, begin, pointer - 1);
        recursive(a, pointer + 1, end);

    }

    public void recursive(int[] a, int begin, int end){
        if (begin >= end) {
            return;
        }

        int pivotIndex = new Random().nextInt(end-begin) + begin;

        int pivot = a[pivotIndex];

        int swapTemp = a[pivotIndex];
        a[pivotIndex] = a[end];
        a[end] = swapTemp;


        int pointer = partition(a, begin, end, pivot);

        recursive(a, begin, pointer-1);
        recursive(a, pointer+1, end);
    }

    private int partition(int[] a, int begin, int end, int pivot) {
        int left = begin;
        int right = end;

        while(left < right){
            while (a[left] <= pivot && left < right) {
                left++;
            }
            while (a[right] >= pivot && left < right) {
                right--;
            }

            int swapTemp = a[left];
            a[left] = a[right];
            a[right] = swapTemp;
        }
        int swapTemp = a[left];
        a[left] = a[end];
        a[end] = swapTemp;

        return left;
    }

}
