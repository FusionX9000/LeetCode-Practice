package LeetCode.Q22GenerateParentheses;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateParenthesis("",result,n,n);
        return result;
    }
    public void generateParenthesis(String prefix, List<String> result, int leftB, int rightB) {
        if(leftB>rightB) {
            return;
        } else if(leftB==0 && rightB==0) {
            result.add(prefix);
        }
        if(leftB!=0) {
            generateParenthesis(prefix+"(",result,leftB-1,rightB);
        }
        if(leftB<rightB) {
            generateParenthesis(prefix+")",result,leftB,rightB-1);
        }
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        List<String> result = s.generateParenthesis(3);
        for(String r : result) {
            System.out.println(r);
        }
    }
}
