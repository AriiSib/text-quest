package com.khokhlov.service;

import org.junit.jupiter.api.Test;

import java.nio.file.Paths;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class QuestionServiceTest {

    @Test
    void should_ThrowNullPointerException_when_InvalidPathToJson() {
        assertThrows(NullPointerException.class, () -> {
            Paths.get(Objects.requireNonNull(getClass()
                    .getClassLoader()
                    .getResource("invalidPath")).toURI());
        });

        assertThrows(NullPointerException.class, () -> {
            Paths.get(Objects.requireNonNull(getClass()
                    .getClassLoader()
                    .getResource(null)).toURI());
        });
    }
}