//package LeetCode.Q68TextJustification;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class Solution {
//    public List<String> fullJustify(String[] words, int maxWidth) {
//        List<String> result = new ArrayList<>();
//
//        List<String> curr = new ArrayList<>();
//        int sentLen = -1;
//        for(String word : words) {
//            if(sentLen<maxWidth) {
//                sentLen+=1+word.length();
//                curr.add(word);
//            } else {
//                sentLen = -1;
//                int extra_space = maxWidth - sentLen;
//                int base = extra_space / curr.size();
//                StringBuilder sb = new StringBuilder();
//                for(String w : curr) {
//                    if(sb.length()!=0 || sb.length()!=maxWidth) {
//
//                    }
//                }
//                curr = new ArrayList<>();
//            }
//        }
//    }
//}
