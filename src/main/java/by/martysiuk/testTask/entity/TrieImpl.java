package by.martysiuk.testTask.entity;

/**
 * Trie data structure implementation
 */
public class TrieImpl implements Trie {
    private TrieNode root;

    /**
     * Public Trie constructor, which initialize root
     */
    public TrieImpl() {
        root = new TrieNode();
    }

    @Override
    public void insert(final String word) {
        TrieNode current = root;
        for (char l : word.toCharArray()) {
            current = current.getChildren().computeIfAbsent(l, c -> new TrieNode());
        }
        current.setEndOfWord(true);
        current.incrementWordUsages();
    }

    @Override
    public boolean delete(final String word) {
        return delete(root, word, 0);
    }

    @Override
    public boolean containsNode(final String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode node = current.getChildren().get(ch);
            if (node == null) {
                return false;
            }
            current = node;
        }
        return current.isEndOfWord();
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public int findWordUsagesAmount(String word) {
        TrieNode current = root;
        word = word.toLowerCase();
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode node = current.getChildren().get(ch);
            if (node == null) {
                return 0;
            }
            current = node;
        }
        return current.getWordUsagesAmount();
    }

    /**
     * Private method for deleting node
     */
    private boolean delete(final TrieNode current, final String word, final int index) {
        if (index == word.length()) {
            if (!current.isEndOfWord()) {
                return false;
            }
            current.setEndOfWord(false);
            return current.getChildren().isEmpty();
        }
        char ch = word.charAt(index);
        TrieNode node = current.getChildren().get(ch);
        if (node == null) {
            return false;
        }
        boolean shouldDeleteCurrentNode = delete(node, word, index + 1) && !node.isEndOfWord();

        if (shouldDeleteCurrentNode) {
            current.getChildren().remove(ch);
            return current.getChildren().isEmpty();
        }
        return false;
    }
}