package dsa.practice.design;

import java.util.ArrayList;
import java.util.List;

public class SuffixTrie {
    public List<String> stringMatching(String[] words) {
        List<String> matchingWords = new ArrayList<>();
        TrieNode root = new TrieNode();
        for (String word : words) {
            for (int startIndex = 0; startIndex < word.length(); startIndex++) {
                // Insert each suffix starting from index startIndex.
                insertWord(root, word.substring(startIndex));
            }
        }
        for (String word : words) {
            if (isSubstring(root, word)) {
                matchingWords.add(word);
            }
        }

        return matchingWords;
    }

    private void insertWord(TrieNode root, String word) {
        TrieNode currentNode = root;
        for (char c : word.toCharArray()) {
            // If the character already exists as a child node, move to it.
            currentNode.childNodes.putIfAbsent(c, new TrieNode());
            currentNode = currentNode.childNodes.get(c);
            currentNode.frequency++; // Increment the frequency of the node.
        }
    }

    private boolean isSubstring(TrieNode root, String word) {
        TrieNode currentNode = root;
        for (char c : word.toCharArray()) {
            // Traverse the Trie following the characters of the word.
            currentNode = currentNode.childNodes.get(c);
        }
        // A word is a substring if its frequency in the Trie is greater than 1.
        return currentNode.frequency > 1;
    }
}
