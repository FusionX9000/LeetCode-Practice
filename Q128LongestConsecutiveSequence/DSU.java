package LeetCode.Q128LongestConsecutiveSequence;

import LeetCode.Utility.*;

public class DSU {

    int[] parents;
    int[] size;

    public DSU(int n) {
        parents = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i]=i;
            size[i]=1;
        }
    }

    public int find(int x) {
        if(x==parents[x]) {
            return x;
        }
        parents[x]=find(parents[x]);
        return parents[x];
    }

    public boolean union(int a, int b) {
        int roota = find(a);
        int rootb = find(b);

        if(roota==rootb) return false;

        if(size[roota]>=size[rootb]) {
            parents[rootb] = roota;
            size[roota]+=size[rootb];
        } else {
            parents[roota] = rootb;
            size[rootb]+=size[roota];
        }
        return true;
    }

    public int maxSize() {
        int max = size[0];
        for (int i = 1; i < size.length; i++) {
            max = Math.max(max,size[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        DSU s = new DSU(10);
    }
}
