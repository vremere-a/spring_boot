package com.example.demo.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;
import org.springframework.core.io.ClassPathResource;

public class FileReaderImpl implements FileReader {

    @Override
    public String readFile() {
        InputStream resource = null;
        try {
            resource = new ClassPathResource("test.csv").getInputStream();
        } catch (IOException e) {
            throw new RuntimeException("Can't find file", e);
        }
        try {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(resource))) {
                return reader.lines().collect(Collectors.joining("\n"));
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
    }
}
