package LeetCode.Q981TaskScheduler;

import java.util.*;

public class TimeMap {

    class Item {
        String value;
        int timeStamp;

        public Item(String v, int t) {
            value = v;
            timeStamp = t;
        }
    }

    HashMap<String, List<Item>> keysMap;

    public TimeMap() {
        keysMap = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        keysMap.putIfAbsent(key, new ArrayList<>());
        keysMap.get(key).add(new Item(value, timestamp));
    }

    public String get(String key, int timestamp) {
        List<Item> itemStack = keysMap.get(key);
        if (itemStack == null) return "";
        String result = binarySearch(itemStack,timestamp);
        System.out.println(result);
        return result;
    }

    public String binarySearch(List<Item> itemStack, int timestamp) {
        int lo = 0;
        int hi = itemStack.size() - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            Item midItem = itemStack.get(mid);
            if (itemStack.get(mid).timeStamp <= timestamp && ((mid < hi && itemStack.get(mid + 1).timeStamp > timestamp) || mid == hi)) {
                    return itemStack.get(mid).value;
            } else if(itemStack.get(mid).timeStamp > timestamp) {
                hi=mid-1;
            } else {
                lo=mid+1;
            }
        }
        return "";
    }

    public static void main(String[] args) {
        TimeMap tm = new TimeMap();
        tm.set("foo","bar",1);
        tm.get("foo",1);
        tm.get("foo",3);
        tm.set("foo","bar2",4);
        tm.get("foo",5);
    }
}
