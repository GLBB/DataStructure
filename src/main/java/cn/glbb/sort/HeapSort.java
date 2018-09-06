package cn.glbb.sort;

import java.util.ArrayList;

// 最小堆
public class HeapSort {
    ArrayList<Integer> list = new ArrayList<>();

    public HeapSort(int[] arr){
        for (int i=0; i<arr.length; i++) {
            insert(arr[i]);
        }
        int i = 0;
        while (list.size()>0){
            int value = remove();
            arr[i++] = value;
        }
    }

    private void insert(int key){
        list.add(key);
        int current = list.size() - 1;
        int parent = (current - 1)/2;
        while (parent>0){
            if (list.get(current) < list.get(parent)){
                int temp = list.get(current);
                list.set(current,list.get(parent));
                list.set(parent,temp);
                current = parent;
                parent = (parent - 1)/2;
            }else
                break;
        }
    }

    private int remove(){
        if (list.size()==0){
            throw new RuntimeException("空");
        }
        int result = list.get(0);
        list.set(0,list.get(list.size()-1));
        list.remove(list.size()-1);

        int current = 0;
        while (current < list.size()){
            int leftSonIndex = 2*current + 1;
            int rightSonIndex = 2*current + 2;

            if (leftSonIndex>=list.size()){
                break;
            }
            // 最小值的索引
            int minIndex = leftSonIndex;
            if (rightSonIndex<list.size()){
                if (list.get(leftSonIndex) > list.get(rightSonIndex)){
                    minIndex = rightSonIndex;
                }
            }

            if (list.get(minIndex)<list.get(current)){
                int temp = list.get(minIndex);
                list.set(minIndex,list.get(current));
                list.set(current,temp);
            }
            current = minIndex;
        }

        return result;
    }

}
