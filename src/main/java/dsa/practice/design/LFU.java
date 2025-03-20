package dsa.practice.design;

import java.util.*;

public class LFU {

    Map<Integer, Set<String>> data;
    Map<String, Integer> freq;
    public LFU() {
        data = new LinkedHashMap<>();
        freq = new HashMap<>();
    }

    public void inc(String key) {
        if (freq.containsKey(key)) {
            // removal
            Integer currentFrequency = freq.get(key);
            Set<String> values = data.get(currentFrequency);
            values.remove(key);
            if (values.isEmpty()) {
                data.remove(currentFrequency);
            }
            // insertion
            Set<String> currentValues = data.getOrDefault(currentFrequency + 1, new HashSet<>());
            currentValues.add(key);
            data.put(currentFrequency + 1, currentValues);
        } else {
            freq.put(key, 1);
            Set<String> values = data.getOrDefault(1, new HashSet<>());
            values.add(key);
            data.put(1, values);
        }

    }

    public void dec(String key) {
        if (freq.containsKey(key)) {
            // removal
            Integer currentFrequency = freq.get(key);
            Set<String> values = data.get(currentFrequency);
            values.remove(key);
            if (values.isEmpty()) {
                data.remove(currentFrequency);
            }
            // insertion
            Set<String> currentValues = data.getOrDefault(currentFrequency - 1, new HashSet<>());
            currentValues.add(key);
            data.put(currentFrequency - 1, currentValues);
        }
    }

    public String getMaxKey() {
        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();
        LinkedHashMap<Integer, Integer> x = new LinkedHashMap<>();
        data.keySet().iterator();
        return "";
    }

    public String getMinKey() {
        return "";
    }
}
