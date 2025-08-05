package main.java.hexlet.code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchEngine {
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
}
