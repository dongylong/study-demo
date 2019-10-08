package com.study.algorithms.chp2;

/**
 * @author dongyl
 * @version 1.0
 * @title
 * @description 使用优先队列的多向归并
 * @created 2019-07-19 09:06
 * @changeRecord
 */
public class Muiliway {
    public static void megeg(In[] streams) {
        int N = streams.length;
        IndexMinPQ<String> pg = new IndexMinPQ(N);
        for (int i = 0; i < N; i++) {
            if (!streams[i].isEmpty()) {
                pq.insert(i, streams[i], readString());
            }
        }
        while (!pq.isEmpty) {
            StdOut.printLn(pq.min());
            int i = pq.delMin();
            if (!streams[i].isEmpty()) {
                pq.insert(i, streams[i], readString());
            }
        }

    }

    public static void main(String[] args) {

        int N = args.length;
        In[] streams = new In[N];
        for (int i = 0; i < N; i++) {
            streams[i] = new In(args[i]);
        }
        merge(streams);
    }
}
