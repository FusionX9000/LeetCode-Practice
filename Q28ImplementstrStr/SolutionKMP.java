package LeetCode.Q28ImplementstrStr;

public class SolutionKMP {
    public int strStr(String haystack, String needle) {
        int[] table = prepareTable(needle);
        int k = -1;
        for(int i = 0; i<haystack.length(); i++) {
            while(k>-1 && needle.charAt(k+1)!=haystack.charAt(i)) {
                k=table[k];
            }
            if(needle.charAt(k+1)==haystack.charAt(i)) {
                k++;
                if(k==needle.length()-1) return i-k;
            }
        }
        return -1;
    }
    public int[] prepareTable(String substring) {
        int[] table = new int[substring.length()];
        table[0]=-1;
        int k=-1;
        for(int i = 1; i<substring.length(); i++) {
            while(k> -1 && substring.charAt(k+1)!=substring.charAt(i)) {
                k=table[k];
            }
            if(substring.charAt(k+1)==substring.charAt(i)) {
                k++;
            }
            table[i]=k;
        }
        return table;
    }
    public static void main(String[] args) {
        SolutionKMP s = new SolutionKMP();
        String s1 = "hello";
        String s2 = "ll";
        System.out.println(s.strStr("hello","o"));
    }
}
