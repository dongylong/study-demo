package com.datastructuress.algorithm.analysis.chp4;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author dongyl
 * @date 11:13 1/1/18
 * @project study-demo
 */
public class TreeMapAndTreeSet {

    public static Map<String, List<String>> compueAdjacentWords(List<String> theWords) {
        //89000words 4sec
        Map<String, List<String>> adjWords = new TreeMap<>();
        Map<Integer, List<String>> wordsByLength = new TreeMap<>();
        for (String w : theWords) {
            update(wordsByLength, w.length(), w);
        }
        for (Map.Entry<Integer, List<String>> entry : wordsByLength.entrySet()) {
            int groupNum = entry.getKey();
            List<String> groupsWord = entry.getValue();
            for (int i = 0; i < groupNum; i++) {
                Map<String, List<String>> repToWard = new TreeMap<>();
                for (String str : groupsWord) {
                    String rep = str.substring(0, 1) + str.substring(i + 1);
                    update(repToWard, rep, str);
                }
                for (List<String> wordClique : repToWard.values()) {
                    if (wordClique.size() >= 2) {
                        for (String s1 : wordClique) {
                            for (String s2 : wordClique) {
                                if (s1 != s2) {
                                    update(adjWords, s1, s2);
                                }
                            }
                        }
                    }
                }
            }
        }
        return adjWords;
    }

    /**
     * 计算一个映射的函数，该映射函数作为关键字并且只有一个字母不同的一列单词作为关键字的值。将单词按照长度分组。
     *
     * @param theWords
     * @return
     */
    public static Map<String, List<String>> compueAdjacentWords2(List<String> theWords) {
        //89000words 16sec
        Map<String, List<String>> adjWords = new TreeMap<>();
        Map<Integer, List<String>> wordsByLength = new TreeMap<>();
        for (String w : theWords) {
            update(wordsByLength, w.length(), w);
        }
        for (List<String> groupWords : wordsByLength.values()) {
            String[] words = new String[groupWords.size()];
            groupWords.toArray(words);
            for (int i = 0; i < words.length; i++) {
                for (int j = i + 1; j < words.length; j++) {
                    if (oneCharOff(words[i], words[j])) {
                        update(adjWords, words[i], words[j]);
                        update(adjWords, words[j], words[i]);
                    }
                }
            }
        }
        return adjWords;

    }

    private static void update(Map<Integer, List<String>> m, int key, String value) {
        List<String> lst = m.get(key);
        if (lst == null) {
            lst = new ArrayList<>();
            m.put(key, lst);
        }
        lst.add(value);
    }

    /**
     * 计算一个Map对象的函数,该对象以一些单词作为关键字而以只在一个字母处不同的一列单词作为关键字的值。
     *
     * @param theWords 8900words 75sec
     * @return
     */
    public static Map<String, List<String>> compueAdjacentWords1(List<String> theWords) {


        Map<String, List<String>> adjWords = new TreeMap<>();
        String[] words = new String[theWords.size()];
        theWords.toArray(words);
        for (int i = 0; i < words.length; i++) {
            for (int j = i; i < words.length; i++) {
                if (oneCharOff(words[i], words[j])) {
                    update(adjWords, words[i], words[j]);
                    update(adjWords, words[j], words[i]);
                }
            }
        }
        return adjWords;
    }

    private static void update(Map<String, List<String>> m, String key, String value) {
        List<String> lst = m.get(key);
        if (lst == null) {
            lst = new ArrayList<>();
            m.put(key, lst);
        }
        lst.add(value);
    }

    public static void printHighChangeables(Map<String, List<String>> adjWords, int minWords) {
        for (Map.Entry<String, List<String>> entry : adjWords.entrySet()) {
            List<String> words = entry.getValue();
            if (words.size() >= minWords) {
                System.out.print(entry.getKey() + " (" + words.size() + " ) : ");
                for (String w : words) {
                    System.out.println(" " + w);
                }
                System.out.println();
            }
        }
    }

    public static boolean oneCharOff(String w1, String w2) {
        if (w1.length() != w2.length()) {
            return false;
        }
        int diffs = 0;
        for (int i = 0; i < w1.length(); i++) {
            if (w1.charAt(i) != w2.charAt(i)) {
                if (++diffs > 1) {
                    return false;
                }
            }
        }
        return diffs == 1;
    }
}
