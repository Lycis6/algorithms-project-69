package test.java.org.example;

import main.java.hexlet.code.SearchEngine;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class SearchEngineTest {
    @Test public void noMatchesTest1() {
        assertEquals(new ArrayList<>(), SearchEngine.search(List.of(
                Map.of("id", "doc1", "text", "Hello, world"),
                Map.of("id", "doc2", "text", "I am programming on JAVA"),
                Map.of("id", "doc3", "text", "Hello. This is a text"),
                Map.of("id", "doc4", "text", "This is a kind of useless text")),
                "word"));
    }
    @Test public void noMatchesTest2() {
        assertEquals(new ArrayList<>(), SearchEngine.search(List.of(
                Collections.emptyMap(),
                Collections.emptyMap(),
                Map.of("id", "doc1", "text", "Hello, world"),
                Collections.emptyMap()
        ), "word"));
    }

    @Test public void noMatchesTest3() {
        assertEquals(new ArrayList<>(), SearchEngine.search(List.of(
                Map.of("id", "doc1", "text", "Hello, world")
        ), "word"));
    }

    @Test public void noMatchesTest4() {
        assertEquals(new ArrayList<>(), SearchEngine.search(List.of(
                Map.of("id", "doc1", "text", "Hello,world!")
        ), " "));
    }

    @Test public void noMatchesTest5() {
        assertEquals(new ArrayList<>(), SearchEngine.search(List.of(
                Map.of("id", "doc1", "text", "Hello, world")
        ), "!"));
    }

    @Test public void matchesTest1() {
        assertEquals(List.of("doc1", "doc3"), SearchEngine.search(List.of(
                Map.of("id", "doc1", "text", "Hello, world"),
                Map.of("id", "doc2", "text", "I am programming on JAVA"),
                Map.of("id", "doc3", "text", "Hello. This is a text"),
                Map.of("id", "doc4", "text", "This is a kind of useless text")),
                "Hello"));
    }

    @Test public void MatchesTest2() {
        assertEquals(List.of("doc1"), SearchEngine.search(List.of(
                Collections.emptyMap(),
                Collections.emptyMap(),
                Map.of("id", "doc1", "text", "Hello, world"),
                Collections.emptyMap()
        ), "world"));
    }

    @Test public void MatchesTest3() {
        assertEquals(List.of("doc1"), SearchEngine.search(List.of(
                Map.of("id", "doc1", "text", "Hello, world")
        ), "world"));
    }

    @Test public void MatchesTest4() {
        assertEquals(List.of("doc1"), SearchEngine.search(List.of(
                Map.of("id", "doc1", "text", "Hello, world")
        ), " "));
    }

    @Test public void MatchesTest5() {
        assertEquals(List.of("doc1"), SearchEngine.search(List.of(
                Map.of("id", "doc1", "text", "Hello, world")
        ), ","));
    }

    @Test public void MatchesTest6() {
        assertEquals(List.of("doc1", "doc2"), SearchEngine.search(List.of(
                Map.of("id", "doc1", "text", "I can't shoot straight unless I've had a pint!"),
                Map.of("id", "doc2", "text", "Don't shoot shoot shoot that thing at me."),
                Map.of("id", "doc3", "text", "I'm your shooter.")
        ), "shoot"));
    }


    @Test public void emptyArrayTest() {
        assertEquals(new ArrayList<>(), SearchEngine.search(new ArrayList<>(), "query"));
    }

    @Test public void emptyMapTest() {
        assertEquals(new ArrayList<>(), SearchEngine.search(List.of(new HashMap<>()), "query"));
    }
}
