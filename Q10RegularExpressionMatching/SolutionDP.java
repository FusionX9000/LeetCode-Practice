package LeetCode.Q10RegularExpressionMatching;

import java.util.HashMap;

public class SolutionDP {
    Boolean[][] memo;
    public boolean isMatch(String s, String p) {
        memo = new Boolean[s.length()+1][p.length()+1];
        return isMatch(s,p,0,0);
    }
    public boolean isMatch(String s, String p, int i, int j) {
        if(memo[i][j]!=null) return memo[i][j];
        if(j>=p.length()) return i>=s.length();
        boolean firstMatch = i!=s.length() && (s.charAt(i)==p.charAt(j) || p.charAt(j)=='.');
        boolean result;
        if(j < p.length()-1 && p.charAt(j+1)=='*') {
             result = (firstMatch && isMatch(s,p,i+1,j)) || isMatch(s,p,i,j+2);
        } else {
            result =  firstMatch && isMatch(s,p,i+1,j+1);
        }
        memo[i][j] = result;
        return memo[i][j];
    }

    public static void main(String[] args) {
        SolutionDP s = new SolutionDP();
        String str = "aab";
        String p = "c*a*b";
        System.out.println(s.isMatch(str,p));
    }
}
