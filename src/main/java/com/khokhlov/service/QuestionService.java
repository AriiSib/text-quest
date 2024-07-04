package com.khokhlov.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.khokhlov.model.Data;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class QuestionService {

    private Data result;

    public QuestionService() {
        Path path = null;
        try {
            path = Paths.get(getClass().getClassLoader()
                    .getResource("data.json").toURI());

            Stream<String> lines = Files.lines(path);
            String data = lines.collect(Collectors.joining("\n"));
            lines.close();

            ObjectMapper om = new ObjectMapper();
            result = om.readValue(data, Data.class);
        } catch (URISyntaxException | IOException e) {
            throw new RuntimeException(e);
        }
    }


    public Data readFromFile() {
        return result;
    }
}
