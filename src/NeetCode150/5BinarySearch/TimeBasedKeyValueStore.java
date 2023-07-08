//// 2023/07/08 // 11:37 //

//// 981. Time Based Key-Value Store // Medium //

// Design a time-based key-value data structure that can store multiple values for the same key
// at different time stamps and retrieve the key's value at a certain timestamp.

// Implement the TimeMap class:
// * TimeMap() Initializes the object of the data structure.
// * void set(String key, String value, int timestamp)
// Stores the key key with the value value at the given time timestamp.
// * String get(String key, int timestamp) Returns a value such that set was called previous,
// with timestamp_prev <= timestamp. If there are multiple such values, it returns the value
// associated with the largest timestamp_prev. If there are no values, it returns "".

// Example 1:
// Input
// ["TimeMap", "set", "get", "get", "set", "get", "get"]
// [[], ["foo", "bar", 1], ["foo", 1], ["foo", 3], ["foo", "bar2", 4], ["foo", 4], ["foo", 5]]
// Output
// [null, null, "bar", "bar", null, "bar2", "bar2"]

// Explanation
// TimeMap timeMap = new TimeMap();
// timeMap.set("foo", "bar", 1); // store the key "foo" and value "bar" along wit timestamp = 1.
// timeMap.get("foo", 1); // return "bar"
// timeMap.get("foo", 3); // return "bar", since there is no value corresponding to too at timestamp 3
// and timestamp 2, then the only value is at timestamp 1 is "bar".
// timeMap.set("foo", "bar2", 4); // store the key "foo" and value "bar2" along with timestamp = 4.
// timeMap.get("foo", 4); // return "bar2"
// timeMap.get("foo", 5); // return "bar2"

// Constraints:
// * 1 <= key.length, value.length <= 100
// * key and value consist of lowercase English letters and digits.
// * 1 <= timestamp <= 10^7
// * All the timestamps timestamp of set are strictly increasing.
// * At most 2 * 10^5 calls will be made to set and get.

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

class TimeBasedKeyValueStore {

    // To solve this problem, we can use a hash map to store the key-value pairs,
    // where the key is the actual key and the value is a sorted map.
    // The sorted map stores the values for the key sorted by their timestamps.
    // We can use a TreeMap to implement the sorted map since it stores the key-value paris in sorted order of keys.

    // In the set() method, we can first check if the key is already present in the hash map.
    // If it is present, we can retrieve the sorted map and add the new value to it.
    // If the key is not present, we can create a new sorted map and add the key-value pari to the hash map.

    // In the get() method, we can first check if the key is present in the hash map.
    // If it is not present, we can return "". If the key is present, we can retrieve
    // the sorted map and use the floorEntry() method of the TreeMap
    // to find the largest value with a time timestamp less than or equal to the given timestamp.

    Map<String, TreeMap<Integer, String>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) {
            map.put(key, new TreeMap<>());
        }
        map.get(key).put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }
        TreeMap<Integer, String> values = map.get(key);
        Integer time = values.floorKey(timestamp);
        if (time == null) {
            return "";
        }
        return values.get(time);
    }

    // Time Complexity:
    // The time complexity of the set() method is O(logn) since we are using a TreeMap
    // which has O(logn) time complexity for insertion.
    // The time complexity of the get() method is also O(logn) since we are using the
    // floorKey() method of the TreeMap which has O(logn) time complexity.

    // Space Complexity:
    // The space complexity of the solution is O(n) where n is the number of key-value pairs
    // stored in the hash map.

}
