package com.datastructuress.algTest.tree;

import org.apache.commons.collections.CollectionUtils;

import java.util.*;

/**
 * @author dongyl
 * @date 14:16 12/29/17
 * @project study-demo
 */
public class CaseInsensitiveCompare {

    private static void printHighChangeables(Map<String, List<String>> adjWords, int minWords) {
        for (Map.Entry<String, List<String>> entry : adjWords.entrySet()) {
            List<String> words = entry.getValue();
            if (words.size() >= minWords) {
                System.out.println(entry.getKey() + "(" + words.size() + ")");
                for (String w : words) {
                    System.out.println("word : " + w);
                }
            }
        }
    }

    private Map<String,List<String>> computeAdjacentWords(List<String> theWords){
        Map<String,List<String>> adjWords = new TreeMap<>();
        int wordsSize = theWords.size();
        String[] words = new String[wordsSize];
        theWords.toArray(words);
        for(int i = 0 ; i <wordsSize;i++){
            for(int j =i;j<wordsSize;j++){
                if(oneCharOff(words[i],words[j])){
                    update(adjWords,words[i],words[j]);
                    update(adjWords,words[j],words[i]);
                }
            }
        }
        return adjWords;
    }

    private void update(Map<String, List<String>> m, String key, String value) {
        List<String> lst = m.get(key);
        if(CollectionUtils.isEmpty(lst)){
            lst = new ArrayList<>();
            m.put(key,lst);
        }else {
            lst.add(value);
        }
    }

    private boolean oneCharOff(String w1, String w2) {
        if (w1.length() != w2.length()) {
            return false;
        }

        int diff = 0;
        for (int i = 0; i < w1.length(); i++) {
            if (w1.charAt(i) != w2.charAt(i)) {
                if (++diff > 1) {
                    return false;
                }
            }
        }
        return diff == 1;
    }

    public static void main(String[] args) {
        Set<String> s = new TreeSet<>();
        s.add("hello");
        s.add("hello");
        System.out.println(s.size() + "...." + s);
    }

}
