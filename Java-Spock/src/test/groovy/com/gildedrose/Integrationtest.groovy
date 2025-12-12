package com.gildedrose

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import spock.lang.Specification

import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths

class Integrationtest extends Specification {

    private final PrintStream originalOut = System.out;
    private ByteArrayOutputStream outContent;

    @BeforeEach
    void setup() {
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    void testSystemOut() {
        given:
        String expected = readExpectedOutput()

        when:
        TexttestFixture.main()
        String actual = outContent.toString().trim()

        then:
        Assertions.assertEquals(expected, actual);
    }

    private String readExpectedOutput() {
        Path path = Paths.get(
                getClass().getClassLoader()
                        .getResource("testfixture_expected_outcome.txt")
                        .toURI()
        )
        return new String(Files.readAllBytes(path)).trim()
    }
}
