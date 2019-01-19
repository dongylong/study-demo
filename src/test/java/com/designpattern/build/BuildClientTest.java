package com.designpattern.build;

import java.util.ArrayList;

/**
 * @author dongyl
 * @date 20:03 1/9/19
 * @project study-demo
 */
public class BuildClientTest {
    public static void main(String[] args) {
        BenzModel benzModel = new BenzModel();
        ArrayList<String> sequence = new ArrayList<>();
        sequence.add(CarStateEnum.CAR_ENGINE_BOOM.getCode());
        sequence.add(CarStateEnum.CAR_START.getCode());
        benzModel.setSequence(sequence);
        benzModel.run();
    }
}
