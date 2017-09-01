package net.galvin.algorithm.sort;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class SimpleQuick {

    public int[] sort(int[] arr,int left,int right){
        if ( arr == null || arr.length <= 1 ){
            return arr;
        }
        if(left < right){
            int i = left;
            int j = right - 1;
            while(true){
                while(i < right){
                    if(arr[i] > arr[right]){
                        break;
                    }
                    i++;
                }
                while(left < j){
                    if(arr[j] < arr[right]){
                        break;
                    }
                    j--;
                }
                if(i >= j) break;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
            int temp = arr[right];
            arr[right] = arr[i];
            arr[i] = temp;
            sort(arr,left,i - 1);
            sort(arr,i + 1, right);
        }
        return arr;
    }


    public static void main(String[] args){

        //准备数据
        List<Integer> intList = new ArrayList<Integer>();
        for(int i = 0; i < 10000; i++){
            intList.add(10000 - i);
        }
        int[] arr = new int[intList.size()];
        for(int j = 0; j < arr.length; j++){
            arr[j] = intList.get(j);
        }

        //打印
        for(int temp : arr){
            System.out.print(temp + ", ");
        }

        //排序
        System.out.println("");
        long start = Calendar.getInstance().getTimeInMillis();
        arr = new SimpleQuick().sort(arr,0,arr.length-1);
        long end = Calendar.getInstance().getTimeInMillis();
        System.out.println("所需毫秒：" + (end - start));
        for(int temp : arr){
            System.out.print(temp + ", ");
        }
    }

    /**
     1. 该排序算法是快速排序算法。
     2. 应用最广泛的高级排序算法
     3. 排序思想： 这里找最后一个数为基准，将小于基准的数放在一个分区，大于基准的数放在一个分区；重复上面操作；
     4. 快速排序的阶： O(nlogn)，不是稳定的排序算法， 比冒泡和简单的插入排序要快很多。
     5. 实战测试：4核CPU和8G内存下，对100000个整型元素的数组排序， 出现虚拟机栈溢出。
     6. 实战测试：4核CPU和8G内存下，对10000个整型元素的数组排序， 逆序需要 207 毫秒， 有序需要：142 毫秒

     7. 问题： 基准选择的盲目性，导致性能下降；当数组的数量很少的时候，还接着使用快速排序方法，很是浪费；栈溢出问题；
     */

}
