package ru.vitvlkv.arrays;

import java.util.*;

public class CountOfSmallerNumbersAfterSelf {

    public List<Integer> countSmallerMy(int[] nums) {
        int N = nums.length;
        List<Integer> counts = new ArrayList<>(N);

        // The problem with TreeSet is that it doesn't allow duplicates
        TreeMap<Integer, Integer> tree = new TreeMap<>();

        // O(N * N)
        for (int i = N - 1; i >= 0; --i) {
            int num = nums[i];

            // O(log N)
            tree.merge(num, 1, (oldVal, val) -> oldVal == null ? val : oldVal + val);

            // O(N)
            int count = 0;
            for (Map.Entry<Integer, Integer> entry : tree.entrySet()) {
                if (entry.getKey() == num) {
                    break;
                }
                count += entry.getValue();
            }

            // O(1)
            counts.add(count);
        }

        // O(N)
        Collections.reverse(counts);
        return counts;
    }


    public List<Integer> countSmallerOthers(int[] nums) {
        List<Integer> data = new ArrayList<Integer>();
        List<Integer> output = new ArrayList<Integer>();

        for(int i=nums.length-1;i>=0;i--){
            int index = binarySearch(0,data.size()-1,data,nums[i]);
            output.add(index);
            data.add(index,nums[i]);
        }
        Collections.reverse(output);
        return output;
    }

    private int binarySearch(int start,int end, List<Integer> data, int target){
        while(start<=end){

            int mid = start +(end-start)/2;

            if(data.get(mid)<target){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }

        return start;
    }
}