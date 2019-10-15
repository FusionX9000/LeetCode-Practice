package LeetCode.Q58LengthOfLastWord;

public class Solution {
    public int lengthOfLastWord(String s) {
        int len = 0;
        boolean space = false;
        for(int i = s.length()-1; i>=0; i--) {
            if(s.charAt(i)!=' ') {
                space=true;
                len++;
            }
            else if(space) return len;
        }
        return len;
    }
}
