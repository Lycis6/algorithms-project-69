package main.java.hexlet.code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchEngine {
    /*
    TASK 3

    public static List<String> search(List<Map<String, String>> docs, String query) {
        if(docs.isEmpty())
            return new ArrayList<>();
        Map<String, Integer> queryCountByDocs = new HashMap<>();
        String normalizedQuery = query.replaceAll("\\p{Punct}", "");
        for(Map<String, String> doc : docs) {
            if(!doc.isEmpty()){
                for(String word : doc.get("text").replaceAll("\\p{Punct}", "").split(" ")) {
                    if(word.equals(normalizedQuery)) {
                        if(queryCountByDocs.containsKey(doc.get("id")))
                            queryCountByDocs.put(doc.get("id"), queryCountByDocs.get(doc.get("id")) + 1);
                        else
                            queryCountByDocs.put(doc.get("id"), 1);
                    }
                }
            }
        }
        return sortDocsDesc(queryCountByDocs);
    }

    private static List<String> sortDocsDesc(Map<String, Integer> queryCountByDocs) {
        List<String> result = new ArrayList<>();
        for(Map.Entry<String, Integer> entry1 : queryCountByDocs.entrySet()) {
            for(Map.Entry<String, Integer> entry2 : queryCountByDocs.entrySet()) {
                if(entry2.getValue() > entry1.getValue()) {
                    entry1 = entry2;
                }
            }
            result.add(entry1.getKey());
            entry1.setValue(0);
        }
        return result;
    }
    */

    /*
    // TASK 4
    public static List<String> search(List<Map<String, String>> docs, String query){
        if(docs.isEmpty() || query.isEmpty())
            return new ArrayList<>();
        String normalizedQuery = query.replaceAll("\\p{Punct}", "");
        List<Map<String, Integer>> keyWordCountByDocsArray = new ArrayList<>();
        for(String keyWord: normalizedQuery.split(" ")){
            keyWordCountByDocsArray.add(searchByKeyWord(docs, keyWord));
        }
        return rangeDocs(keyWordCountByDocsArray, docs);
    }

    private static Map<String, Integer> searchByKeyWord(List<Map<String, String>> docs, String keyWord) {
        Map<String, Integer> keyWordCountByDocs = new HashMap<>();
        for(Map<String, String> doc : docs) {
            if(!doc.isEmpty()){
                for(String word : doc.get("text").replaceAll("\\p{Punct}", "").split(" ")) {
                    if(word.equals(keyWord)) {
                        if(keyWordCountByDocs.containsKey(doc.get("id")))
                            keyWordCountByDocs.put(doc.get("id"), keyWordCountByDocs.get(doc.get("id")) + 1);
                        else
                            keyWordCountByDocs.put(doc.get("id"), 1);
                    }
                }
            }
        }
        return keyWordCountByDocs;
    }

    private static List<String> rangeDocs(List<Map<String, Integer>> keyWordCountByDocsArray,
                                          List<Map<String, String>> docs) {
        List<String> rangeDocs = new ArrayList<>();
        Map<String, Integer> docsByKeyWordExistence = new HashMap<>();
        Map<String, Integer> docsByKeyWordCount = new HashMap<>();
        int keyWordFlag = 0;
        int keyWordCounter = 0;
        for(Map<String, String> doc : docs) {
            for(Map<String, Integer> keyWord : keyWordCountByDocsArray){
                if(keyWord.containsKey(doc.get("id"))) {
                    keyWordFlag++;
                    keyWordCounter = keyWordCounter + keyWord.get(doc.get("id"));
                }
            }
            if(keyWordFlag != 0){
                docsByKeyWordExistence.put(doc.get("id"), keyWordFlag);
                docsByKeyWordCount.put(doc.get("id"), keyWordCounter);
            }
            keyWordFlag = 0;
            keyWordCounter = 0;
        }

        for(Map.Entry<String, Integer> entry1 : docsByKeyWordExistence.entrySet()){
            for(Map.Entry<String, Integer> entry2 : docsByKeyWordExistence.entrySet()){
                if(entry2.getValue() > entry1.getValue()) {
                    entry1 = entry2;
                }
                else if(entry2.getValue() == entry1.getValue()) {
                    if(docsByKeyWordCount.get(entry2.getKey()) > docsByKeyWordCount.get(entry1.getKey())) {
                        entry1 = entry2;
                    }
                }
            }
            rangeDocs.add(entry1.getKey());
            entry1.setValue(0);
            docsByKeyWordCount.put(entry1.getKey(), 0);
        }
        return rangeDocs;
    }
     */

    // TASK 5
    public static List<String> search(List<Map<String, String>> docs, String query){
        if(docs.isEmpty() || query.isEmpty())
            return new ArrayList<>();
        String normalizedQuery = query.replaceAll("\\p{Punct}", "");
        List<Map<String, Integer>> keyWordCountByDocsArray = new ArrayList<>();
        for(String keyWord: normalizedQuery.split(" ")){
            keyWordCountByDocsArray.add(searchByKeyWord(docs, keyWord));
        }
        return rangeDocs(keyWordCountByDocsArray, docs);
    }

    private static Map<String, Integer> searchByKeyWord(List<Map<String, String>> docs, String keyWord) {
        Map<String, Integer> keyWordCountByDocs = new HashMap<>();
        for(Map<String, String> doc : docs) {
            if(!doc.isEmpty()){
                for(String word : doc.get("text").replaceAll("\\p{Punct}", "").split(" ")) {
                    if(word.equals(keyWord)) {
                        if(keyWordCountByDocs.containsKey(doc.get("id")))
                            keyWordCountByDocs.put(doc.get("id"), keyWordCountByDocs.get(doc.get("id")) + 1);
                        else
                            keyWordCountByDocs.put(doc.get("id"), 1);
                    }
                }
            }
        }
        return keyWordCountByDocs;
    }

    private static List<String> rangeDocs(List<Map<String, Integer>> keyWordCountByDocsArray,
                                          List<Map<String, String>> docs) {
        List<String> rangeDocs = new ArrayList<>();
        Map<String, Integer> docsByKeyWordExistence = new HashMap<>();
        Map<String, Integer> docsByKeyWordCount = new HashMap<>();
        int keyWordFlag = 0;
        int keyWordCounter = 0;
        for(Map<String, String> doc : docs) {
            for(Map<String, Integer> keyWord : keyWordCountByDocsArray){
                if(keyWord.containsKey(doc.get("id"))) {
                    keyWordFlag++;
                    keyWordCounter = keyWordCounter + keyWord.get(doc.get("id"));
                }
            }
            if(keyWordFlag != 0){
                docsByKeyWordExistence.put(doc.get("id"), keyWordFlag);
                docsByKeyWordCount.put(doc.get("id"), keyWordCounter);
            }
            keyWordFlag = 0;
            keyWordCounter = 0;
        }

        for(Map.Entry<String, Integer> entry1 : docsByKeyWordExistence.entrySet()){
            for(Map.Entry<String, Integer> entry2 : docsByKeyWordExistence.entrySet()){
                if(entry2.getValue() > entry1.getValue()) {
                    entry1 = entry2;
                }
                else if(entry2.getValue() == entry1.getValue()) {
                    if(docsByKeyWordCount.get(entry2.getKey()) > docsByKeyWordCount.get(entry1.getKey())) {
                        entry1 = entry2;
                    }
                }
            }
            rangeDocs.add(entry1.getKey());
            entry1.setValue(0);
            docsByKeyWordCount.put(entry1.getKey(), 0);
        }
        return rangeDocs;
    }

    public static Map<String, List<String>> indexing(String query, List<Map<String, String>> docs){
        Map<String, List<String>> index = new HashMap<>();
        String normalizedQuery = query.replaceAll("\\p{Punct}", "");
        for(String keyWord: normalizedQuery.split(" ")){
            List<String> result = new ArrayList<>();
            for(Map<String, String> doc: docs){
                boolean contains = false;
                for(String word : doc.get("text").replaceAll("\\p{Punct}", "").split(" ")) {
                    if(word.equals(keyWord)) {
                        contains = true;
                        break;
                    }
                }
                if(contains){
                    result.add(doc.get("id"));
                }
            }
            index.put(keyWord, result);
        }
        return index;
    }


}
