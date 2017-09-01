package net.galvin.algorithm.sort;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Insert {

    public int[] sort(int[] arr){
        if ( arr == null || arr.length <= 1 ){
            return arr;
        }
        int length = arr.length;
        for(int i = 1; i < length;i++){
            int k = i-1;
            int temp = arr[i];
            while(k >= 0){
                if(arr[k] > temp){
                    arr[k+1] = arr[k];
                }else{
                    break;
                }
                arr[k] = temp;
                k--;
            }
        }

        return arr;
    }


    public static void main(String[] args){

        //准备数据
        List<Integer> intList = new ArrayList<Integer>();
        for(int i = 0; i < 1000000; i++){
            intList.add(1000000-i);
        }
        int[] arr = new int[intList.size()];
        for(int j = 0; j < arr.length; j++){
            arr[j] = intList.get(j);
        }

        //打印
//        for(int temp : arr){
//            System.out.print(temp + ", ");
//        }

        //排序
        System.out.println("");
        long start = Calendar.getInstance().getTimeInMillis();
        arr = new Insert().sort(arr);
        long end = Calendar.getInstance().getTimeInMillis();
        System.out.println("所需毫秒：" + (end - start));
//        for(int temp : arr){
//            System.out.print(temp + ", ");
//        }
    }

    /**
     1. 该排序算法是简单插入排序算法。
     2. 排序思想：通过遍历，把最小的找出来，记录下标，然后和目的位置进行交换。
     3. 和冒泡排序比较：
             和冒泡排序一样是一个非常简单的排序算法。
             把一条新的记录插入到一个有序的数组中时，通有序数组进行比较，把大的数据往后面移动，然后把新的记录赋值合适的位置。
             冒泡排序进行的是完全交换，插入排序进行的是半交换，比冒泡排序要快。
     4. 简单选择排序的阶：O(n^2), 是稳定的排序。
     5. 实战测试：4核CPU和8G内存下，对100000个整型元素的数组排序， 逆序需要 5646 毫秒， 有序需要：5798毫秒
     */

}
