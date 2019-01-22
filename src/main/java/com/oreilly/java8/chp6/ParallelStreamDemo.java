//package com.oreilly.java8.chp6;
//
//import com.oreilly.java8.chp6.bean.Album;
//import com.oreilly.java8.chp6.bean.Track;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.Map;
//import java.util.stream.IntStream;
//
//public class ParallelStreamDemo {
//    /**
//     * 6.1
//     *
//     * @return
//     */
//    public int serialArraySum() {
//        List<String> albums = new ArrayList();
//        return albums.stream()
//                .flatMap(Album::getTracks)
//                .mapToInt(Track::getLength)
//                .sum();
//
//    }
//
//    /**
//     * 6.2
//     *
//     * @return
//     */
//    public int parallelArraySum() {
//        List<String> albums = new ArrayList();
//        return albums.parallelStream()
//                .flatMap(Album::getTracks)
//                .mapToInt(Track::getLength)
//                .sum();
//    }
//
//    /**
//     * 6.3 使用蒙特卡洛模拟法并行化模拟投掷子事件
//     *
//     * @return Map<Integer                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               ,                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               Double> 点数之和到他们的概率的映射
//     */
//    public Map<Integer, Double> parallelDiceRolls() {
//
//        int N = 10;
//        double fraction = 1.0 / N;
//        return
//                //使用intStream的range方法创建大小为N的流
//                IntStream.range(0, N)
//                        //使用parallel方法使流的并行化操作
//                        .parallel()
//                        //twoDiceThrows函数模拟连续投掷两次骰子子事件，返回值为两次点数之和
//                        //使用mapToObj方法以便在流上使用该函数
//                        .mapToObj(twoDiceThrows())
//                        //得到需要合并的所有结果的流
//                        // groupingBy方法将点数一样的结果合并。
//                        .collect(groupingBy(side -> side
//                                //使用summingDouble方法完成这一步。
//                                , summingDouble(n -> fraction)));
//    }
//
//    /**
//     * 并行求和
//     *
//     * @param values
//     * @return
//     */
//    private int addIntegers(List<Integer> values) {
//        return values.parallelStream().mapToInt(i -> i).sum();
//    }
//
//    /**
//     * 6.8 使用并行化数组操作初始化数组
//     *
//     * @param size
//     * @return
//     */
//    public static double[] paralllelInitialize(int size) {
//        double[] values = new double[size];
//        Arrays.parallelSetAll(values, i -> i);
//        return values;
//    }
//
//    /**
//     * 6.9 计算简单滑动平均数
//     *
//     * @param values
//     * @param n
//     * @return
//     */
//    public static double[] simpleMovingAverage(double[] values
//            , int n) {
//        //不修改原有数据，复制了一份数据
//        double[] sums = Arrays.copyOf(values, values.length);
//        //并行操作，将数组的元素相加 sum保存求和结果
//        Arrays.parallelPrefix(sums, Double::sum);
//        int start = n - 1;
//        return IntStream.range(start, sums.length)
//                .mapToDouble(i -> {
//                    double prefix = i == start ? 0 : sums[i - n];
//                    //使用总和减去窗口起始值，然后除以n得平均值
//                    return (sums[i] - prefix) / n;
//                })
//                //流转化为数组
//                .toArray();
//    }
//
//    /**
//     * 6.10 顺序求列表中数字的平方和
//     *
//     * @param range
//     * @return
//     */
//    public static int sequentialSumOfSquares(IntStream range) {
//        return range.map(x -> x * x)
//                .sum();
//    }
//
//    /**
//     * 6.11 列表中的数字相乘，然后再将所得结果乘以5
//     * 有缺陷
//     *
//     * @param linkedListOfNumbers
//     * @return
//     */
//    public static int multiplyThrough(List<Integer> linkedListOfNumbers) {
//        return linkedListOfNumbers.stream()
//                .reduce(5, (acc, x)
//                        -> x * acc);
//    }
//
//    /**
//     * 6.12 求列表元素的平方和
//     * 性能不高
//     *
//     * @return
//     */
//    public int slowSumOfSuares(List<Integer> linkedListOfNumbers) {
//        return linkedListOfNumbers.parallelStream()
//                .map(x -> x * x)
//                .reduce(0, (acc, x) -> acc + x);
//    }
//
//}
