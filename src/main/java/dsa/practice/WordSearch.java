package dsa.practice;

import java.util.*;

class TrieNode {
    Map<Character, TrieNode> children;
    boolean isWord;
    String word;

    public TrieNode() {
        children = new HashMap<>();
        isWord = false;
    }
}

class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insertWord(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            if (!current.children.containsKey(word.charAt(i))) {
                current.children.put(word.charAt(i), new TrieNode());
            }
            current = current.children.get(word.charAt(i));
        }
        current.isWord = true;
        current.word = word;
    }

}

public class WordSearch {
    Set<String> outputWords;
    int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private boolean isValid(int i, int n, int j, int m) {
        return i < n && j < m && i >= 0 && j >= 0;
    }

    private void dfs(char[][] board, int i, int j, int n, int m, boolean[][] visited, TrieNode root) {
        char current = board[i][j];
        visited[i][j] = true;
        if (root.isWord) {
            outputWords.add(root.word);
            root.isWord = false;
        }
        for (int[] dir : dirs) {
            int newI = i + dir[0];
            int newJ = j + dir[1];
            if (isValid(newI, n, newJ, m) && !visited[newI][newJ] && root.children.containsKey(board[newI][newJ])) {
                dfs(board, newI, newJ, n, m, visited, root.children.get(board[newI][newJ]));
            }

        }
        visited[i][j] = false;
    }

    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insertWord(word);
        }
        outputWords = new HashSet<>();
        int n = board.length;
        int m = board[0].length;
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (trie.root.children.containsKey(board[i][j])) {
                    dfs(board, i, j, n, m, visited, trie.root.children.get(board[i][j]));
                }
            }
        }
        return new ArrayList<>(outputWords);
    }
}