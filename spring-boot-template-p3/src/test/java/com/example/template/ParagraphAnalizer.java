package com.example.template;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toMap;

public class ParagraphAnalizer {
    private static final int LIMIT_BANNED_WORDS = 100;
    private static final int LIMIT_PARAGRAPH_LENGTH = 1000;
    private static final int LIMIT_BANNED_WORD_LENGTH = 10;
    String[] especialCharacters = {"\"","!","?","'",",",";","."};
    public String mostCommonnWord(String paragraph, String[] bannedWords) {
        //bannedWords
        validateConstrains(paragraph,bannedWords);

        paragraph = replaceSpecialCharactersBySpace(paragraph);
        String[] wordArray = paragraph.split(" " );

        Map<String, Integer> mapWordsCount = new HashMap<> ();

        Arrays.stream(wordArray).forEach(word -> {
            word=word.trim();
            if(!word.isEmpty() && word!=null && !(Arrays.stream(bannedWords).anyMatch(word::equalsIgnoreCase))){
                word = word.toLowerCase();
                if(mapWordsCount.containsKey(word)){
                    mapWordsCount.put(word, mapWordsCount.get(word) + 1);
                }
                else{
                    mapWordsCount.put(word.toLowerCase(),1);
                }
            }
        });

        Map<String, Integer>  mapSortedCountWords = desendingOrderByValue(mapWordsCount);
        return mapSortedCountWords.entrySet().iterator().next().getKey();
    }

    public Map<String, Integer> desendingOrderByValue(Map<String, Integer>  mapWordsCount){
        return mapWordsCount
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(
                        toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,
                                LinkedHashMap::new));
    }

    private void validateConstrains(String paragraph, String[] bannedWords) {
        if(bannedWords.length>LIMIT_BANNED_WORDS)
            throw new ParagraphAnalizerLimitException(String.format("Banned word limit exceded:%d",LIMIT_BANNED_WORDS));
        if(paragraph.length()>LIMIT_PARAGRAPH_LENGTH)
            throw new ParagraphAnalizerLimitException(String.format("Paragraph limit exceded:%d",LIMIT_PARAGRAPH_LENGTH));

        for (String bannedWord:bannedWords) {
            if(bannedWord.length()>LIMIT_BANNED_WORD_LENGTH){
                throw new ParagraphAnalizerLimitException(String.format("Banned Word limit exceded:%d",LIMIT_BANNED_WORD_LENGTH));
            };
        }
    }

    public String replaceSpecialCharactersBySpace(String word){
        for (String ec:especialCharacters) {
            word = word.replace(ec," ");
        }
        return word;
    }
}
