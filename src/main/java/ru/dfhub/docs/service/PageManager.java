package ru.dfhub.docs.service;

import org.markdown4j.Markdown4jProcessor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class PageManager {

    private final Markdown4jProcessor mdp = new Markdown4jProcessor();

    public String getContent(String pagePath) throws IOException {
        return parseMarkdown(readFile(pagePath));
    }

    private String readFile(String path) throws IOException {
        Path filePath = Path.of(System.getenv("DOCS_CONTENT_DIR") + path);
        return Files.readString(filePath);
    }

    private String parseMarkdown(String markdown) {
        try {
            return mdp.process(markdown);
        } catch (IOException e) {
            return "<p>An error occurred trying to process markdown</p><br><p class='error'>%s</p>".formatted(e.fillInStackTrace());
        }
    }
}
