package dsa.practice.design;

import java.util.*;

class Node {
    int frequency;
    Set<String> data;
    Node prev;
    Node next;
    public Node(int frequency) {
        this.frequency = frequency;
        data = new HashSet<>();
        data = new LinkedHashSet<>();
        new ArrayList<>(data);
    }
}
public class MaxMinStruct {
    Map<String, Node> keyFreq;
    Node start;
    Node end;
    public MaxMinStruct() {
        start = new Node(0);
        end = new Node(0);
        start.next = end;
        end.prev = start;
        keyFreq = new HashMap<>();
    }

    private void addNewNode(Node left, Node right, int frequency, String key) {
        Node current = new Node(frequency);
        current.data.add(key);
        current.prev = left;
        current.next = right;

        left.next = current;
        right.prev = current;

        keyFreq.put(key, current);
    }

    private void removeNode(Node node) {
        Node prev = node.prev;
        prev.next = node.next;
        node.next.prev = prev;
        node.prev = null;
        node.next = null;
    }

    public void inc(String key) {
        if (keyFreq.containsKey(key)) {
            Node curFreqNode = keyFreq.get(key);
            curFreqNode.data.remove(key);
            Node nextNode = curFreqNode.next;
            if (nextNode == end || nextNode.frequency != curFreqNode.frequency + 1) {
                addNewNode(curFreqNode, curFreqNode.next, curFreqNode.frequency + 1, key);
            } else {
                curFreqNode.next.data.add(key);
                keyFreq.put(key, curFreqNode.next);
            }
            if (curFreqNode.data.isEmpty()) {
                // remove this node
                removeNode(curFreqNode);
            }
        } else {
            Node firstNode = start.next;
            if (firstNode == end || firstNode.frequency > 1) {
                addNewNode(start, start.next, 1, key);
            } else {
                firstNode.data.add(key);
                keyFreq.put(key, firstNode);
            }
        }
    }

    public void dec(String key) {
        if (!keyFreq.containsKey(key)) {
            return;
        }
        Node node = keyFreq.get(key);
        node.data.remove(key);
        int currentFreq = node.frequency;
        if (currentFreq == 1) {
            keyFreq.remove(key);
        } else {
            Node prevNode = node.prev;
            if (prevNode == start || prevNode.frequency != currentFreq - 1) {
                addNewNode(prevNode, node, currentFreq - 1, key);
            } else {
                prevNode.data.add(key);
                keyFreq.put(key, prevNode);
            }
        }
        if (node.data.isEmpty()) {
            // remove this node
            removeNode(node);
        }
    }

    public String getMaxKey() {
        if (end.prev == start) {
            return "";
        }
        return end.prev.data.iterator().next();
    }

    public String getMinKey() {
        if (start.next == end) {
            return "";
        }
        return start.next.data.iterator().next();
    }
}
