package com.noriental.alg.chp10;

/**
 * @author dongyl
 * @date 18:37 12/27/17
 * @project message-svr
 */
public class DataItem {
    public long dData;

    public DataItem(long dData) {
        this.dData = dData;
    }

    public void displayItem() {
        System.out.print(" / " + dData);
    }
}
