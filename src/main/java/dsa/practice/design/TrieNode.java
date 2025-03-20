package dsa.practice.design;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
    int frequency;
    // Maps characters to their respective child nodes.
    Map<Character, TrieNode> childNodes;

    TrieNode() {
        frequency = 0;
        childNodes = new HashMap<>();
    }
}
