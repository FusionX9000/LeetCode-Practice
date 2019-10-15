package LeetCode.Q38CountAndSay;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public String countAndSay(int n) {
        if(n<1) return "";
        StringBuilder res = new StringBuilder("1");
        for(int i = 1; i<n; i++) {
            StringBuilder fres = new StringBuilder();
            int count = 0;
            int j = -1;
            while(++j<res.length()) {
                count++;
                if(j==res.length()-1 || res.charAt(j)!=res.charAt(j+1)) {
                    fres.append(count).append(res.charAt(j));
                    count = 0;
                }
            }
            res = fres;
        }
        return res.toString();
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.countAndSay(5));
    }
}
