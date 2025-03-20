package dsa.practice;

import java.util.Comparator;
import java.util.PriorityQueue;

class Node {
    Character value;
    Node left;
    Node right;
    int frequency;
    public Node(Character value, Node left, Node right, int frequency) {
        this.value = value;
        this.left = left;
        this.right = right;
        this.frequency = frequency;
    }
}
public class HuffmanEncoding {
    public void preOrderTraversal(Node root, String parent) {
        if (root!= null) {
            if (root.value != '$') {
                System.out.println(root.value + " " + parent);
            }
            preOrderTraversal(root.left, parent + "0");
            preOrderTraversal(root.right,parent + "1");
        }
    }
    public void getCodes(String s, int[] frequency) {
        PriorityQueue<Node> minHeap = new PriorityQueue<>(Comparator.comparingInt(n -> n.frequency));
        for (int i=0; i<frequency.length; i++) {
            char c = s.charAt(i);
            minHeap.offer(new Node(c, null, null, frequency[i]));
        }
        while (minHeap.size()>=2) {
            Node leftNode = minHeap.poll();
            Node rightNode = minHeap.poll();
            Node rootNode = new Node('$', leftNode, rightNode, leftNode.frequency + rightNode.frequency);
            minHeap.offer(rootNode);
        }
        Node root = minHeap.poll();
        preOrderTraversal(root, "");
    }
}
