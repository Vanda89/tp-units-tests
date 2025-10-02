package fr.diginamic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AppTest {

    @Test
    void shouldAlwaysPass() {
        assertTrue(true, "This test should always pass");
    }

    @Test
    void mainShouldRunWithoutException() {
        App.main(new String[]{});
        assertTrue(true, "Main should run without exception");
    }
}
