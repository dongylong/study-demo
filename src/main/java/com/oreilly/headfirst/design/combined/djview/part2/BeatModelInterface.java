package com.oreilly.headfirst.design.combined.djview.part2;

/**
 * @author dongyl
 * @version 1.0
 * @title
 * @description
 * @company 好未来-爱智康
 * @created 2019/10/28 09:51
 * @changeRecord
 */
public interface BeatModelInterface {
    void initialize();
    void on();
    void off();
    void setBPM(int bpm);
    int getBPM();
    void registerObserver(BeatObserver o );
    void removeObserver(BeatObserver o );
    void registerObserver(BPMObserver o );
    void removeObserver(BPMObserver o );

}
