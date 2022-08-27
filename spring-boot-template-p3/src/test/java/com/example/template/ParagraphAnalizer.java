package com.example.template;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ParagraphAnalizer {
    private static final int LIMIT_BANNED_WORDS = 100;
    private static final int LIMIT_PARAGRAPH_LENGTH = 1000;
    private static final int LIMIT_BANNED_WORD_LENGTH = 10;
    String[] especialCharacters = {"\"","!","?","'",",",";","."};
    public String mostCommonnWord(String paragraph, String[] bannedWords) {
        //bannedWords
        if(bannedWords.length>LIMIT_BANNED_WORDS)
            throw new ParagraphAnalizerLimitException(String.format("Banned word limit exceded:%d",LIMIT_BANNED_WORDS));
        if(paragraph.length()>LIMIT_PARAGRAPH_LENGTH)
            throw new ParagraphAnalizerLimitException(String.format("Paragraph limit exceded:%d",LIMIT_PARAGRAPH_LENGTH));

        for (String bannedWord:bannedWords) {
            if(bannedWord.length()>LIMIT_BANNED_WORD_LENGTH){
                throw new ParagraphAnalizerLimitException(String.format("Banned Word limit exceded:%d",LIMIT_BANNED_WORD_LENGTH));
            };
        }


        paragraph = replaceSpecialCharactersBySpace(paragraph);
        String[] paragraphArray = paragraph.split(" " );
        Set<String> paragraphSet = new HashSet<String>();
        Arrays.stream(paragraphArray).forEach(word -> paragraphSet.add(word));

        Arrays.stream(bannedWords).forEach(bannedWord -> paragraphSet.remove(bannedWord));

        //String[] uniqueWords = (String[]) paragraphSet.toArray();
        String[] uniqueWords = paragraphSet.toArray(new String[0]);
        int[] countWords = new int[uniqueWords.length];

        int indexMax=0;
        int valueMax=0;
        int index=0;

        for (String uniqueWord:uniqueWords) {
            int count=0;
            for (String word:paragraphArray) {
                if(word.equalsIgnoreCase(uniqueWord)){
                    count++;
                }
            }
            countWords[index]=count;

            if(valueMax<=count){
                valueMax=count;
                indexMax=index;
            }

            index++;
        }

        return uniqueWords[indexMax];
    }

    public String replaceSpecialCharactersBySpace(String word){
        for (String ec:especialCharacters) {
            word = word.replace(ec," ");
        }
        return word;
    }
}
