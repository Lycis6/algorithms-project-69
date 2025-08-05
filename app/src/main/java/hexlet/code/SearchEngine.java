package main.java.hexlet.code;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SearchEngine {
    public static List<String> search(List<Map<String, String>> docs, String query) {
        if(docs.isEmpty())
            return new ArrayList<>();
        List<String> result = new ArrayList<>();
        String normalizedQuery = query.replaceAll("\\p{Punct}", "");
        for(Map<String, String> doc : docs) {
            boolean contains = false;
            if(!doc.isEmpty()){
                if(query.equals(" ") || query.matches("\\p{Punct}")){
                    if(doc.get("text").contains(query))
                        result.add(doc.get("id"));
                    continue;
                }
                for(String word : doc.get("text").replaceAll("\\p{Punct}", "").split(" ")) {
                    if(word.equals(normalizedQuery)) {
                        contains = true;
                        break;
                    }
                }
                if(contains)
                    result.add(doc.get("id"));
            }
        }
        return result;
    }
}
