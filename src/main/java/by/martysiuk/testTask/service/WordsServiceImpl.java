package by.martysiuk.testTask.service;

import by.martysiuk.testTask.entity.Trie;
import by.martysiuk.testTask.entity.TrieImpl;
import by.martysiuk.testTask.util.FileProcess;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;

/**
 * WordsAmountService Implementation
 */
@Service
public class WordsServiceImpl implements WordsService {

    @Override
    public int findWordUsages(final String word) {
        Trie trie = new TrieImpl();
        Arrays.stream(FileProcess.parseFile()).forEach(trie::insert);
        return trie.findWordUsagesAmount(word);
    }

    @Override
    public int findWordUsages(final String word, final MultipartFile file) {
        Trie trie = new TrieImpl();
        Arrays.stream(FileProcess.parseFile(file)).forEach(trie::insert);
        return trie.findWordUsagesAmount(word);
    }
}