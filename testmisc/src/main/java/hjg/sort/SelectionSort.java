package hjg.sort;

import hjg.mianshi.Utils;

public class SelectionSort {
	 
    private static void selectSortTest() {
        int[] sortArray = { 5, 2, 4, 1, 3 };
        Utils.printArray("选择排序前: ",sortArray);
        selectSort(sortArray); 
        Utils.printArray("选择排序后: ",sortArray);
    }
 
    public static void selectSort(int[] sort) {
        int temp;
        for (int i = 0; i < sort.length - 1; i++) {
            for (int j = i + 1; j < sort.length; j++) {
                if (sort[i] > sort[j]) {
                    temp = sort[i];
                    sort[i] = sort[j];
                    sort[j] = temp;
                }
            }
        }
    }
 
    public static void heapSortTest(){
        int[] arr = { 5, 2, 4, 1, 3 };
        Utils.printArray("堆排序前：",arr);
        heapSort(arr);
        Utils.printArray("堆排序后：",arr);
    }
     
    public static void heapSort(int[] arr) {
        int arrLen = arr.length;
        int temp = 0;
         
        //建立堆
        for (int i = (arrLen-1) / 2; i >= 0; i--)
            adjustHeap(arr, i, arrLen);
         
        //调整堆
        for (int i = arrLen - 2; i >= 0; i--) {
            temp = arr[i + 1];
            arr[i + 1] = arr[0];
            arr[0] = temp;
            adjustHeap(arr, 0, i + 1);
             
//          Utils.printArray("第"+(9-i)+"次调整：",arr);
        }
    }
 
    public static void adjustHeap(int[] arr, int ri, int n) {
        int temp = arr[ri];
        int ci = 2 * ri + 1;
        while (ci <= n - 1) {
            if (ci < n - 1 && arr[ci] < arr[ci + 1])
                ci++;
             
            if (temp >= arr[ci])
                break;
            arr[(ci - 1) / 2] = arr[ci];
            ci = 2 * ci + 1;
        }
        arr[(ci - 1) / 2] = temp;
    }
     
    public static void main(String [] args){
        selectSortTest();
        heapSortTest();
    }
}