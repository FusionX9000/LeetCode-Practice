package LeetCode.Q6ZigZagConversion;

import java.util.ArrayList;
import java.util.List;

public class Question {
    void printZigZag(String s, int n) {
        boolean goingDown = false;
        int rowSize = Math.min(n,s.length());
        List<StringBuilder> rows = new ArrayList<>(rowSize);
        for (int i = 0; i<rowSize; i++) {
            rows.add(new StringBuilder());
        }
        int currRow = 0;
        for(char c : s.toCharArray()) {
            if(currRow==0 || currRow==n-1) {
                goingDown = !goingDown;
            }
            rows.get(currRow).append(c);
            currRow+= goingDown ? 1 : -1;
        }
        StringBuilder f = new StringBuilder();
        for(StringBuilder row : rows) {
            f.append(row);
        }
        System.out.println(f.toString());
    }
    public static void main(String[] args) {
        Question q = new Question();
        q.printZigZag("PAYPALISHIRING",3);
        System.out.println('1'-'0');
    }
}
