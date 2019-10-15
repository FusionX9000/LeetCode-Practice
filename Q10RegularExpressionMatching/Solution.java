package LeetCode.Q10RegularExpressionMatching;

//class Result {
//    int pos;
//    boolean match;
//    public Result(boolean match, int pos) {
//        this.match = match;
//        this.pos = pos;
//    }
//}

public class Solution {
//    public boolean isMatch(String s, String p) {
//        int i = 0;
//        int pos = 0;
//        Result res;
//        while(pos<s.length() && i<p.length()) {
//            if(i<p.length()-1 && p.charAt(i+1)=='*') {
//                res = isMatch(p.charAt(i),true,s,pos);
//                i+=1;
//            } else {
//                res = isMatch(p.charAt(i),false,s,pos);
//            }
//            if(!res.match) return false;
//            i+=1;
//            pos = res.pos;
//        }
//        System.out.println(pos);
//        return pos==s.length() && i==p.length();
//    }
//    public Result isMatch(char m, boolean star, String s, int pos) {
//        System.out.println("char: "+m+" star: "+star+" string: "+s+" pos: "+pos);
//        if (pos >= s.length()) return new Result(star, -1);
//        if (!star) {
//            if (m != '.' && s.charAt(pos) != m) return new Result(false, -1);
//            return new Result(true, pos + 1);
//        }
//        while (pos<s.length() && (m=='.' || s.charAt(pos) == m)) {
//            pos += 1;
//        }
//        return new Result(true, pos);
//    }


    public boolean isMatch(String s, String p) {
        if(p.isEmpty()) return s.isEmpty();
        boolean firstMatch = !s.isEmpty() && (s.charAt(0)==p.charAt(0) || p.charAt(0)=='.');
        if(p.length()>=2 && p.charAt(1)=='*') {
            return (firstMatch && isMatch(s.substring(1),p)) || isMatch(s,p.substring(2));
        } else {
            return firstMatch && isMatch(s.substring(1),p.substring(1));
        }
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        String str = "aaa";
        String p = "a.a";
        System.out.println(s.isMatch(str,p));
    }
}
