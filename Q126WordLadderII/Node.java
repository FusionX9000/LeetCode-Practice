package LeetCode.Q126WordLadderII;
public class Node {
    String val;
    int index;
    public Node(int index, String val) {
        this.val = val;
        this.index = index;
    }
    @Override
    public String toString() { return "Index: "+index+", val: "+val; }
}
