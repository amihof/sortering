package main;

import java.util.TreeMap;

public class TreeMapExample implements IntSorter{
    private int[] array;

    @Override
    public void sort(int[] a) {
        array = a;
        TreeMap<Integer, Integer> treeMap = new TreeMap<Integer, Integer>();

        for(int i = 0; i < array.length; i++) {
            if (treeMap.containsKey(array[i])) {
                int nbrOccur = treeMap.get(array[i]);
                nbrOccur++;
                treeMap.put(array[i], nbrOccur);
            } else {
                treeMap.put(array[i], 1);
            }
        }
        System.out.println(treeMap);

        for(int i = 0; i < array.length; i++) {
            int key = treeMap.firstKey();
            if(treeMap.get(key) == 1){
                array[i] = treeMap.pollFirstEntry().getKey();
            } else {
                int nbrOccur2 = treeMap.get(key); //Hitta value av första key
                for(int j = i; j < nbrOccur2+i; j++){
                    array[j] = key;
                }
                i += nbrOccur2-1; //Hoppa fram i en yttre loopen till nästa unika tal
                treeMap.pollFirstEntry();
            }
        }
    }
}