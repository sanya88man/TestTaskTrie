package by.martysiuk.testTask.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * Interface for getting words amount
 */
public interface WordsService {
    /**
     * Method for getting word usages amount in local file
     */
    int findWordUsages(String word);

    /**
     * Method for getting word usages amount in multipart file
     */
    int findWordUsages(String word, MultipartFile file);
}
