package LeetCode.Q91DecodeWays;

import java.util.HashMap;

public class Solution {
    public int numDecodings(String s) {
        if(s.length()==0) return 0;
        Integer[] cache = new Integer[s.length()+1];
        cache[s.length()]=1;
        return numDecodings(s,0,cache);
    }

    public int numDecodings(String s, int pos, Integer[] cache) {
        if (cache[pos]!=null) return cache[pos];
        cache[pos]=0;
        if(pos<s.length()-1) {
            int num = Integer.parseInt(s.substring(pos,pos+2));
            if(num>=10 && num<=26) {
                cache[pos]+= numDecodings(s,pos+2,cache);
            }
        }
        cache[pos]+=s.charAt(pos)=='0' ? 0 : numDecodings(s,pos+1,cache);
        return cache[pos];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.numDecodings("12"));
    }
}
