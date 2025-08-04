package test.java.org.example;

import org.junit.Test;

import hexlet.code.SearchEngine;

import static org.junit.Assert.*;

public class AppTest {
    @Test public void appHasAGreeting() {
        SearchEngine classUnderTest = new SearchEngine();
        assertNotNull("app should have a greeting", classUnderTest.getGreeting());
    }
}
