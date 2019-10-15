package LeetCode.Q60PermutationSequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    public String getPermutation(int n, int k) {
        int fact=1;
        StringBuilder sb = new StringBuilder();

        // LinkedList gives better removal time but get() is O(n), so overall doesn't affect time complexity
        List<Integer> arr = new ArrayList<Integer>();
        for(int i = 1; i<=n; i++) {
            arr.add(i);
            fact*=i;
        }

        for(k--; n>0; n--) {
            fact/=n;
            sb.append(arr.remove(k/ fact));
            k = k % fact;
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.getPermutation(4,14));
    }
}
