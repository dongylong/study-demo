package com.java8.oreilly.chp6;

import com.java8.oreilly.chp6.bean.Album;
import com.java8.oreilly.chp6.bean.Track;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class parallelStreamDemo {
    /**
     * 6.1
     *
     * @return
     */
    public int serialArraySum() {
        List<String> albums = new ArrayList();
        return albums.stream()
                .flatMap(Album::getTracks)
                .mapToInt(Track::getLength)
                .sum();

    }

    /**
     * 6.2
     *
     * @return
     */
    public int parallelArraySum() {
        List<String> albums = new ArrayList();
        return albums.parallelStream()
                .flatMap(Album::getTracks)
                .mapToInt(Track::getLength)
                .sum();
    }

    /**
     * 6.3 使用蒙特卡洛模拟法并行化模拟投掷子事件
     *
     * @return Map<Integer, Double> 点数之和到他们的概率的映射
     */
    public Map<Integer, Double> parallelDiceRolls() {

        int N = 10;
        double fraction = 1.0 / N;
        return
                //使用intStream的range方法创建大小为N的流
                IntStream.range(0, N)
                        //使用parallel方法使流的并行化操作
                        .parallel()
                        //twoDiceThrows函数模拟连续投掷两次骰子子事件，返回值为两次点数之和
                        //使用mapToObj方法以便在流上使用该函数
                        .mapToObj(twoDiceThrows())
                        //得到需要合并的所有结果的流
                        // groupingBy方法将点数一样的结果合并。
                        .collect(groupingBy(side -> side
                                //使用summingDouble方法完成这一步。
                                , summingDouble(n -> fraction)));
    }
}
