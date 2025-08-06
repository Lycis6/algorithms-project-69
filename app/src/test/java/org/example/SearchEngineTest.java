package test.java.org.example;

import hexlet.code.SearchEngine;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Collections;
import java.util.List;
import static org.junit.Assert.assertEquals;

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

    @Test public void noMatchesTest6() {
        assertEquals(new ArrayList<>(), SearchEngine.search(List.of(
                Map.of("id", "doc1", "text", "Hello, world"),
                Map.of("id", "doc2", "text", "I am programming on JAVA"),
                Map.of("id", "doc3", "text", "Hello. This is a text"),
                Map.of("id", "doc4", "text", "This is a kind of useless text")),
                "apple!"));
    }

    @Test public void matchesTest1() {
        assertEquals(List.of("doc1", "doc3"), SearchEngine.search(List.of(
                Map.of("id", "doc1", "text", "Hello, world"),
                Map.of("id", "doc2", "text", "I am programming on JAVA"),
                Map.of("id", "doc3", "text", "Hello. This is a text"),
                Map.of("id", "doc4", "text", "This is a kind of useless text")),
                "Hello"));
    }

    @Test public void matchesTest2() {
        assertEquals(List.of("doc1"), SearchEngine.search(List.of(
                Collections.emptyMap(),
                Collections.emptyMap(),
                Map.of("id", "doc1", "text", "Hello, world"),
                Collections.emptyMap()
        ), "world"));
    }

    @Test public void matchesTest3() {
        assertEquals(List.of("doc1"), SearchEngine.search(List.of(
                Map.of("id", "doc1", "text", "Hello, world")
        ), "world"));
    }

    @Test public void matchesTest4() {
        assertEquals(List.of("doc2", "doc1"), SearchEngine.search(List.of(
                Map.of("id", "doc1", "text", "I can't shoot straight unless I've had a pint!"),
                Map.of("id", "doc2", "text", "Don't shoot shoot shoot that thing at me."),
                Map.of("id", "doc3", "text", "I'm your shooter.")
        ), "shoot"));
    }

    @Test public void matchesTest5() {
        assertEquals(List.of("doc2", "doc1"), SearchEngine.search(List.of(
                Map.of("id", "doc1", "text", "I can't shoot straight unless I've had a pint!"),
                Map.of("id", "doc2", "text", "Don't shoot shoot shoot that thing at me."),
                Map.of("id", "doc3", "text", "I'm your shooter.")
        ), "shoot!!!!"));
    }

    @Test public void matchesTest6() {
        assertEquals(List.of("doc1"), SearchEngine.search(List.of(
                Map.of("id", "doc1", "text", "I can't shoot straight unless I've had a pint!"),
                Map.of("id", "doc2", "text", "Don't shoot shoot shoot that thing at me."),
                Map.of("id", "doc3", "text", "I'm your shooter.")
        ), "pint?!!!!"));
    }

    @Test public void matchesTest7() {
        assertEquals(List.of("doc1"), SearchEngine.search(List.of(
                Map.of("id", "doc1", "text", "I can't shoot straight unless I've had a pint!"),
                Map.of("id", "doc2", "text", "Don't shoot shoot shoot that thing at me."),
                Map.of("id", "doc3", "text", "I'm your shooter.")
        ), "...pint?!!!!"));
    }

    @Test public void matchesTest8() {
        assertEquals(List.of("doc3", "doc4", "doc1"), SearchEngine.search(List.of(
                Map.of("id", "doc1", "text", "I can't shoot straight unless I've had a pint!"),
                Map.of("id", "doc2", "text", "Don't shoot shoot shoot that thing at me."),
                Map.of("id", "doc3", "text", "I'm your shooter, pint... for it."),
                Map.of("id", "doc4", "text", "I can't shoot straight unless I've had a pint!))")
        ), "...pint?!!!!"));
    }

    @Test public void matchesTest9() {
        assertEquals(List.of("doc5", "doc1", "doc3"), SearchEngine.search(List.of(
                        Map.of("id", "doc1", "text", "Hello, world"),
                        Map.of("id", "doc2", "text", "I am programming on JAVA"),
                        Map.of("id", "doc3", "text", "Hello. This is a text"),
                        Map.of("id", "doc4", "text", "This is a kind of useless text"),
                        Map.of("id", "doc5", "text", "Hello you!")),
                "Hello?"));
    }

    @Test public void matchesTest10() {
        assertEquals(List.of("doc1", "doc5", "doc2", "doc3"), SearchEngine.search(List.of(
                        Map.of("id", "doc1", "text", "Hello, world"),
                        Map.of("id", "doc2", "text", "I am programming on JAVA. Hello, Hello, Hello!"),
                        Map.of("id", "doc3", "text", "Hello, Hello. This is a text"),
                        Map.of("id", "doc4", "text", "This is a kind of useless text"),
                        Map.of("id", "doc5", "text", "Hello you! Hello, I say!")),
                "Hello?"));
    }

    @Test public void matchesTest11() {
        assertEquals(List.of("doc2", "doc1"), SearchEngine.search(List.of(
                Map.of("id", "doc1", "text", "I can't shoot shoot straight unless I've had a pint!"),
                Map.of("id", "doc2", "text", "Don't shoot shoot shoot shoot shoot that thing at me."),
                Map.of("id", "doc3", "text", "I'm your shooter.")
        ), "...shoot?!!!!"));
    }

    @Test public void matchesTest12() {
        assertEquals(List.of("doc2"), SearchEngine.search(List.of(
                Map.of("id", "doc1", "text", "I can't straight unless I've had a pint!"),
                Map.of("id", "doc2", "text", "Don't shoot shoot shoot shoot shoot that thing at me."),
                Map.of("id", "doc3", "text", "I'm your shooter.")
        ), "...shoot?!!!!"));
    }

    @Test public void matchesTest13() {
        assertEquals(List.of("doc2", "doc3", "doc1"), SearchEngine.search(List.of(
                Map.of("id", "doc1", "text", "I can't straight unless I've had a pint! Look at shoot"),
                Map.of("id", "doc2", "text", "Don't shoot shoot shoot shoot shoot that thing at me."),
                Map.of("id", "doc3", "text", "A I'm your shooter. Shoot, shoot, shoot.")
        ), "...shoot me?!!!!"));
    }

    @Test public void matchesTest14() {
        assertEquals(List.of("doc3", "doc1", "doc2", "doc4"), SearchEngine.search(List.of(
                Map.of("id", "doc1", "text", "I like walk to park every single day, also i like"
                        + " relaxing"),
                Map.of("id", "doc2", "text", "Eating fast food that what I like"),
                Map.of("id", "doc3", "text", "I like playing different sport games on nature."),
                Map.of("id", "doc4", "text", "A lot of people likes spending free time with there"
                        + " friends"
                        + " playing smth")), "like playing"));
    }

    @Test public void matchesTest15() {
        assertEquals(List.of("doc2", "doc3", "doc1"), SearchEngine.search(List.of(
                Map.of("id", "doc1", "text", "the cat sat on the mat"),
                Map.of("id", "doc2", "text", "the dog chased the cat"),
                Map.of("id", "doc3", "text", "the dog barked loudly")
        ), "dog cat"));
    }

    @Test public void matchesTest16() {
        assertEquals(List.of("doc1", "doc2", "doc3"), SearchEngine.search(List.of(
                Map.of("id", "doc1", "text", "apple orange banana"),
                Map.of("id", "doc2", "text", "apple apple fruit orange"),
                Map.of("id", "doc3", "text", "banana fruit salad")
         ), "apple banana"));
    }

    @Test public void matchesTest17() {
        assertEquals(List.of("doc2", "doc1"), SearchEngine.search(List.of(
                Map.of("id", "doc1", "text", "I can't shoot straight unless I've had a pint!"),
                Map.of("id", "doc2", "text", "Don't shoot shoot shoot that thing at me."),
                Map.of("id", "doc3", "text", "I'm your shooter.")
        ), "shoot at me, nerd"));
    }

    @Test public void emptyArrayTest() {
        assertEquals(new ArrayList<>(), SearchEngine.search(new ArrayList<>(), "query"));
    }

    @Test public void emptyMapTest() {
        assertEquals(new ArrayList<>(), SearchEngine.search(List.of(new HashMap<>()), "query"));
    }
}
