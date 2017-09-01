package net.galvin.algorithm.sort;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ProSimpleQuick {

    public int[] sort(int[] arr,int left,int right){
        if ( arr == null || arr.length <= 1 ){
            return arr;
        }
        if(right - left >= 9 ){
            int i = left;
            int j = right;
            int mid = (left + right) / 2;
            if(arr[i] > arr[mid]){
                int temp = arr[i];
                arr[i] = arr[mid];
                arr[mid] = temp;
            }
            if(arr[i] > arr[j]){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
            if(arr[mid] > arr[j]){
                int temp = arr[mid];
                arr[mid] = arr[j];
                arr[j] = temp;
            }
            int temp = arr[mid];
            arr[mid] = arr[right - 1];
            arr[right - 1] = temp;

            int k = i;
            int l = right - 1;
            int m = k;
            int n = l - 1;
            while(true){
                while(m < l){
                    if(arr[m] > arr[l]){
                        break;
                    }
                    m++;
                }
                while(k < n){
                    if(arr[n] < arr[l]){
                        break;
                    }
                    n--;
                }
                if(m >= n) break;
                int tem = arr[m];
                arr[m] = arr[n];
                arr[n] = tem;
            }
            int tem = arr[l];
            arr[l] = arr[m];
            arr[m] = tem;
            sort(arr,left,m - 1);
            sort(arr,m + 1, right);
        }else {
            int i = left + 1;
            int j = right;
            for ( ; i <= j; i++){
                int k = i - 1;
                int temp = arr[i];
                while(true){
                    if(arr[k] > arr[i]){
                        arr[k + 1] = arr[k];
                    }else{
                        break;
                    }
                    arr[k] = temp;
                    k--;
                }
            }
        }
        return arr;
    }


    public static void main(String[] args){

        List<Integer> intList = new ArrayList<Integer>();
        for(int i = 0; i < 100000; i++){
            intList.add(100000 - i);
        }
        int[] arr = new int[intList.size()];
        for(int j = 0; j < arr.length; j++){
            arr[j] = intList.get(j);
        }
        for(int temp : arr){
            System.out.print(temp + ", ");
        }
        System.out.println("");
        long start = Calendar.getInstance().getTimeInMillis();
        arr = new ProSimpleQuick().sort(arr,0,arr.length-1);
        long end = Calendar.getInstance().getTimeInMillis();
        System.out.println("所需毫秒：" + (end - start));
        for(int temp : arr){
            System.out.print(temp + ", ");
        }
    }

    /**
     1. 该快速排序法是对简单快速排序法的一个改进。
     2. 当数组的数量小于10的时候，拒绝使用快速排序，使用插入法排序。这样做提高了性能，有效减少了栈溢出的概率。
     3. 基准的选择不再盲目性： arr[left] <= arr[mid] <= arr[right],交换， arr[mid]和arr[right]，基准为：arr[right].
     4. 实战测试：4核CPU和8G内存下，对100000个整型元素的数组排序， 逆序需要 20 毫秒， 有序需要：23 毫秒
     */

}
