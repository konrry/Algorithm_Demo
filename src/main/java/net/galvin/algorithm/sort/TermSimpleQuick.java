package net.galvin.algorithm.sort;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class TermSimpleQuick {

    public int[] sort(int[] arr,int left,int right){
        if ( arr == null || arr.length <= 1 ){
            return arr;
        }
        if(right - left >= 9){
            while(right - left >= 9 ){
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
                if(l - m > m - k){
                    sort(arr,m + 1, right);
                    right = m - 1;
                }else{
                    sort(arr,left,m - 1);
                    left = m + 1;
                }
            }
        } else {
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
        for(int i = 0; i < 1000000; i++){
            intList.add(1000000 - i);
        }
        int[] arr = new int[intList.size()];
        for(int j = 0; j < arr.length; j++){
            arr[j] = intList.get(j);
        }
//        for(int temp : arr){
//            System.out.print(temp + ", ");
//        }
        System.out.println("");
        long start = Calendar.getInstance().getTimeInMillis();
        arr = new TermSimpleQuick().sort(arr,0,arr.length-1);
        long end = Calendar.getInstance().getTimeInMillis();
        System.out.println("所需毫秒：" + (end - start));
//        for(int temp : arr){
//            System.out.print(temp + ", ");
//        }
    }

    /**
     1. 该快速排序法是终极版的快速排序。
     2. 删除底部递归：小的分区使用递归，大的分区使用循环。
     3. 基准的选择不再盲目性： arr[left] <= arr[mid] <= arr[right],交换， arr[mid]和arr[right]，基准为：arr[right].
     4. 实战测试：4核CPU和8G内存下，对100000个整型元素的数组排序， 逆序需要 17 毫秒， 有序需要：28 毫秒
     4. 实战测试：4核CPU和8G内存下，对1000000个整型元素的数组排序， 逆序需要 55 毫秒， 有序需要：57 毫秒
     */

}
