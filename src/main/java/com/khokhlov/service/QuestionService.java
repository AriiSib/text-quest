package com.khokhlov.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.khokhlov.consts.Consts;
import com.khokhlov.model.Data;
import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RequiredArgsConstructor
public class QuestionService {

    private final ObjectMapper objectMapper;

    public Data readFromFile() {
        try {
            Path path = Paths.get(Objects.requireNonNull(getClass()
                    .getClassLoader()
                    .getResource(Consts.PATH_TO_JSON)).toURI());

            try (Stream<String> lines = Files.lines(path)) {
                String data = lines.collect(Collectors.joining("\n"));
                return objectMapper.readValue(data, Data.class);
            }
        } catch (URISyntaxException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}