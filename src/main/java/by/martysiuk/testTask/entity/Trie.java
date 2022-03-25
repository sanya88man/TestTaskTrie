package by.martysiuk.testTask.entity;

/**
 * Interface of trie data structure
 */
public interface Trie {
    /**
     * Method inserts word into trie
     */
    void insert(String word);

    /**
     * Method remove word from trie
     */
    boolean delete(String word);

    /**
     * Method checks does trie contain certain word
     */
    boolean containsNode(String word);

    /**
     * Method checks does trie contain nodes
     */
    boolean isEmpty();

    /**
     * Method for getting word usages amount
     *
     * @param word is searching word
     */
    int findWordUsagesAmount(String word);
}
