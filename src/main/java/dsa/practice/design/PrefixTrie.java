package dsa.practice.design;

public class PrefixTrie {

    private void insertWord(TrieNode root, String word) {
        TrieNode currentNode = root;
        for (char c : word.toCharArray()) {
            // If the character already exists as a child node, move to it.
            currentNode.childNodes.putIfAbsent(c, new TrieNode());
            currentNode = currentNode.childNodes.get(c);
            currentNode.frequency++; // Increment the frequency of the node.
        }
    }
    private int search(TrieNode root, String pref) {
        TrieNode currentNode = root;
        for (char c : pref.toCharArray()) {
            // If the character already exists as a child node, move to it.
            currentNode = currentNode.childNodes.get(c);
            if (currentNode == null) {
                return 0;
            }
        }
        return currentNode.frequency;
    }
    public int prefixCount(String[] words, String pref) {
        TrieNode root = new TrieNode();
        for (String w : words) {
            insertWord(root, w);
        }
        return search(root, pref);
    }
}
