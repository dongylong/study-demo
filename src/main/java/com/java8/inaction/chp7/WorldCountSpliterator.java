package com.java8.inaction.chp7;


import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * @author dongyl
 * @date 09:48 11/16/18
 * @project study-demo
 */
public class WorldCountSpliterator implements Spliterator<Character> {
    private final String string;
    private int currentChar = 0;

    public WorldCountSpliterator(String string) {
        this.string = string;
    }

    @Override
    public boolean tryAdvance(Consumer<? super Character> action) {
        //处理当前字符
        action.accept(string.charAt(currentChar++));
        //true：还有字符需要处理
        return currentChar < string.length();
    }

    @Override
    public Spliterator<Character> trySplit() {
        int currentSize = string.length() - currentChar;
        if (currentSize < 10) {
            //字符可直接顺序处理
            return null;
        }
        //将试探拆分位置设定为要解析的String的中间
        for (int splitPos = currentSize / 2 + currentChar; splitPos < string.length(); splitPos++) {
            //拆分位置前进直到下一个空格
            if (Character.isWhitespace(string.codePointAt(splitPos))) {
                //创建一个新WordCounter-Spliterator来解析string从开始到拆分位置的部分
                Spliterator<Character> spliterator = new WorldCountSpliterator(string.substring(currentChar, splitPos));
                //将这个WordCounter-Spliterator的起始位置设为拆分位置
                currentChar = splitPos;
                return spliterator;
            }
        }
        return null;
    }

    @Override
    public long estimateSize() {
        return string.length() - currentChar;
    }

    @Override
    public int characteristics() {
        return ORDERED + SIZED + SUBSIZED + NONNULL + IMMUTABLE;
    }
}