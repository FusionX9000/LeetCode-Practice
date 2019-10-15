package LeetCode.Q65ValidNumber;

//interface Node {
//    int sign = 0;
//    int decimal = 1;
//    int exponent = 2;
//    int exp_sign = 3;
//    int exp_int = 4;
//
//    boolean optional = false;
//
//    public boolean getType();
//    public boolean isOptional();
//    public String getValue();
//}

import java.util.*;

public class Solution {

    public boolean isNumber(String s) {
        s = s.trim();
        if(s.length()==0) return false;
        System.out.println(s);


        int[][] tt = {
                {1,2,9,7},
                {7,2,9,7},
                {7,2,3,4},
                {7,8,7,4},
                {5,6,7,7},
                {7,6,7,7},
                {7,6,7,7},
                {7,7,7,7},
                {7,8,7,4},
                {7,8,7,7}
        };

        int state = 0;

//        for(char c : s.toCharArray()) {
//            if(state==7) return false;
//            else if(c>='0' && c<='9') state = map.get(state).get('d');
//            else if(c=='+' || c=='-') state = map.get(state).get('s');
//            else state = map.get(state).getOrDefault(c,7);
//        }

        for(char c : s.toCharArray()) {
            if(state==7) return false;
            if(c>='0' && c<='9') state = tt[state][1];
            else if(c=='+' || c=='-') state = tt[state][0];
            else if(c=='.') state = tt[state][2];
            else if(c=='e') state = tt[state][3];
            else return false;
        }

        return state==2 || state==8 || state==6 || state==3;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isNumber("."));
    }
}
