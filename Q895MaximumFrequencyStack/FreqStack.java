package LeetCode.Q895MaximumFrequencyStack;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

public class FreqStack {

    private HashMap<Integer,Integer> elementFreq;
    private HashMap<Integer,Deque<Integer>> freqStack;
    private int maxFreq;

    public FreqStack() {
        maxFreq=1;
        elementFreq = new HashMap<>();
        freqStack = new HashMap<>();
    }

    public void push(int x) {
        int freq = elementFreq.getOrDefault(x,0)+1;
        elementFreq.put(x,freq);
        maxFreq = Math.max(freq,maxFreq);
        freqStack.computeIfAbsent(freq,z->new LinkedList<>()).push(x);
    }

    public int pop() {
        int element = freqStack.get(maxFreq).pop();
        System.out.println(element);
        elementFreq.put(element,maxFreq-1);
        if(freqStack.get(maxFreq).size()==0) {
            freqStack.remove(maxFreq);
            maxFreq--;
        }
        return element;
    }

    public static void main(String[] args) {
        FreqStack fs = new FreqStack();
        fs.push(5);
        fs.push(7);
        fs.push(5);
        fs.push(7);
        fs.push(4);
        fs.push(5);
        fs.pop();
        fs.pop();
        fs.pop();
        fs.pop();
        fs.pop();
        fs.pop();
    }
}
