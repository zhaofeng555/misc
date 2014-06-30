package hjg.sort;

import hjg.mianshi.Utils;

public class MergeSort {
	 
    private static void mergeSortTest() {
        int[] in = { 2, 5, 3, 8, 6, 7, 1, 4, 0, 9 };
        Utils.printArray("归并排序前：",in);
        int a[] = mergeSort(in);
        Utils.printArray("归并排序后：",a);
    }
 
    private static int[] mergeSort(int[] arr) {
        if (arr.length == 1) {
            return arr;
        } else {
            int[] arrL = new int[arr.length / 2];
            int[] arrR = new int[arr.length - arr.length / 2];
            int mid = arr.length / 2;
            for (int i = 0; i < mid; i++) {
                arrL[i] = arr[i];
            }
            for (int i = mid, j = 0; i < arr.length; i++, j++) {
                arrR[j] = arr[i];
            }
            int[] sortedArrL = mergeSort(arrL);
            int[] sortedArrR = mergeSort(arrR);
            int[] resultArr = mergeTwoArr(sortedArrL, sortedArrR);
            return resultArr;
        }
    }
 
    private static int[] mergeTwoArr(int[] arrL, int[] arrR) {
        int i = 0, j = 0;
        int[] arrTmp = new int[arrL.length + arrR.length];
        int foot = 0;
        while (i < arrL.length && j < arrR.length) {
            if (arrL[i] <= arrR[j]) {
                arrTmp[foot++] = arrL[i++];
            } else {
                arrTmp[foot++] = arrR[j++];
            }
        }
        if (i == arrL.length) {
            while (j < arrR.length) {
                arrTmp[foot++] = arrR[j++];
            }
        } else {
            while (i < arrL.length) {
                arrTmp[foot++] = arrL[i++];
            }
        }
        return arrTmp;
    }
     
    public static void main(String[] args) {
        mergeSortTest();
    }
}