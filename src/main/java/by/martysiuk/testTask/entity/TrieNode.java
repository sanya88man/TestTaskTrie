package by.martysiuk.testTask.entity;

import java.util.HashMap;
import java.util.Map;

/**
 * Public class of Trie node
 */
public class TrieNode {
    private final Map<Character, TrieNode> children = new HashMap<>();
    private boolean endOfWord;
    private int wordUsagesAmount;

    Map<Character, TrieNode> getChildren() {
        return children;
    }

    boolean isEndOfWord() {
        return endOfWord;
    }

    void setEndOfWord(boolean endOfWord) {
        this.endOfWord = endOfWord;
    }

    int getWordUsagesAmount() {
        return wordUsagesAmount;
    }

    void incrementWordUsages() {
        this.wordUsagesAmount++;
    }
}
