package by.martysiuk.testTask.controller;

import by.martysiuk.testTask.service.WordsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * API for getting word usages amount
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("api/task")
public class WordsController {
    private final WordsService wordsAmountService;

    /**
     * Endpoint for getting word usages amount
     */
    @GetMapping(params = {"word"})
    public ResponseEntity<Integer> getWordUsagesAmount(@RequestParam("word") final String word) {
        return new ResponseEntity<>(wordsAmountService.findWordUsages(word), HttpStatus.OK);
    }

    /**
     * Endpoint for getting word usages amount with file attachment
     */
    @PostMapping(value = "/file", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE}, params = {"word", "file"})
    public ResponseEntity<Integer> getWordUsagesAmountWithFileAttach(
            @RequestPart("word") final String word,
            @RequestPart("file") final MultipartFile file) {
        return new ResponseEntity<>(wordsAmountService.findWordUsages(word, file), HttpStatus.OK);
    }
}

