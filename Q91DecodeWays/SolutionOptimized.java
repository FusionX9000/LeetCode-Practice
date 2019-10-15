package LeetCode.Q91DecodeWays;

import java.util.ArrayList;
import java.util.Arrays;

public class SolutionOptimized {
    public int numDecodings(String s) {
        if(s.length()==0) return 0;
        int[] cache = new int[s.length()+1];
        cache[s.length()]=1;
        cache[s.length()-1] = s.charAt(s.length()-1)=='0' ? 0 : 1;
        for(int i = s.length()-2; i>=0; i--) {
            int ch = s.charAt(i) - '0';
            int ch2 = s.charAt(i+1) - '0';
            if((ch==1) || (ch==2 && ch2>=0 && ch2<=6)) cache[i]+=cache[i+2];
            if(s.charAt(i)!='0') cache[i]+=cache[i+1];
        }
        return cache[0];
    }

    public static void main(String[] args) {
        SolutionOptimized s = new SolutionOptimized();
        System.out.println(s.numDecodings("109"));
    }
}
