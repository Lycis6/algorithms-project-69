package test.java.org.example;

import hexlet.code.SearchEngine;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import static org.junit.Assert.assertEquals;

public class IndexingTest {
    @Test public void testIndexing1() {
        assertEquals(Map.of(
                "some", List.of("doc1", "doc2"),
                "text", List.of("doc1", "doc2"),
                "too", List.of("doc2")),
                SearchEngine.indexing(List.of(
                        Map.of("id", "doc1", "text", "some text"),
                        Map.of("id", "doc2", "text", "some text too me")
                ), "some text too"));
    }

    @Test public void testIndexing2() {
        assertEquals(Map.of(
                        "some", List.of("doc1", "doc2", "doc4"),
                        "text", List.of("doc1", "doc2"),
                        "too", List.of("doc1", "doc2")),
                SearchEngine.indexing(List.of(
                        Map.of("id", "doc1", "text", "some text. It is here too"),
                        Map.of("id", "doc2", "text", "some text too me"),
                        Map.of("id", "doc3", "text", "Hello, world!"),
                        Map.of("id", "doc4", "text", "some kind of humor")
                ), "some text too"));
    }

    @Test public void testIndexing3() {
        assertEquals(Map.of(
                        "some", List.of("doc1", "doc2", "doc4"),
                        "text", List.of("doc1", "doc2"),
                        "too", List.of("doc1", "doc2"),
                        "hello", List.of("doc3"),
                        "you", new ArrayList<>()),
                SearchEngine.indexing(List.of(
                        Map.of("id", "doc1", "text", "some text. It is here too"),
                        Map.of("id", "doc2", "text", "some text too me"),
                        Map.of("id", "doc3", "text", "Hello, world!"),
                        Map.of("id", "doc4", "text", "some kind of humor")
                ), "some text too. Hello, you"));
    }
}
