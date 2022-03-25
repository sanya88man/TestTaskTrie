package by.martysiuk.testTask.util;

import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

/**
 * Public class for parsing words from file
 */
public class FileProcess {
    /**
     * Method for parsing local file
     *
     * @return array of words
     */
    public static String[] parseFile() {
        String path = "book.txt";
        try {
            return handleContent(Files.readString(Path.of(path), StandardCharsets.UTF_8));
        } catch (IOException e) {
            System.out.println("Cannot read content from file with path: " + e.getMessage());
        }
        return new String[0];
    }

    /**
     * Method for parsing multipart file
     *
     * @return array of words
     */
    public static String[] parseFile(final MultipartFile multipartFile) {
        File file = new File(System.getProperty("java.io.tmpdir") + "/" + multipartFile.getName());
        try {
            multipartFile.transferTo(file);
            return handleContent(FileUtils.readFileToString(file, StandardCharsets.UTF_8));
        } catch (IOException e) {
            System.out.println("Cannot read content from multipart file: " + e.getMessage());
        }
        return new String[0];
    }

    private static String[] handleContent(String content) {
        return Stream.of(content.split("[^A-Za-zА-Яа-я]+")).map(String::toLowerCase).toArray(String[]::new);
    }
}