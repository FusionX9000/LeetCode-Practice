package LeetCode.Q76MinimumWindowSubstring;

public class SolutionOptimised {
    public String minWindow(String s, String t) {
        if (t.length() == 0 || s.length() == 0 || s.length() < t.length()) return "";

        Integer[] map = createMap(t);

        int left = 0;
        int right = 0;

        int minLeft = 0;
        int minRight = s.length();

        int charCount = t.length();
        boolean found = false;

        for (right = 0; right < s.length(); right++) {
            char atRight = s.charAt(right);

            if(map[atRight]!=null) {
                map[atRight]-=1;
                if(map[atRight]>=0) charCount--;
            }

            while(left<=right && charCount==0) {
                found=true;
                char atLeft = s.charAt(left);
                if(minRight-minLeft+1>right-left+1) {
                    minLeft=left;
                    minRight=right;
                }
                if(map[atLeft]!=null) {
                    map[atLeft]+=1;
                    if(map[atLeft]>0) charCount++;
                }
                left++;
            }
        }
        return found ? s.substring(minLeft, minRight + 1) : "";
    }

    public Integer[] createMap(String t) {
        Integer[] map = new Integer[128];
        for (char ch : t.toCharArray()) {
            map[ch]=map[ch]==null ? 1 : map[ch]+1;
        }
        return map;
    }

    public static void main(String[] args) {
        SolutionOptimised s = new SolutionOptimised();
        String S = "ADOBECODEBANC";
        String T = "DANC";
        System.out.println(s.minWindow(S, T));
    }
}
