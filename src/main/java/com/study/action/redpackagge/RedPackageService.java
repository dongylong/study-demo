package com.study.action.redpackagge;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author dongyl
 * @version 1.0
 * @title
 * @description
 * @company 好未来-爱智康
 * @created 2020/7/30 13:51
 * @changeRecord
 */
public class RedPackageService {

    public static List<Integer> divideRedPackage(Integer totalAmount, Integer totalPeopleNum) {
        List<Integer> amountList = new ArrayList<Integer>();
        Integer restAmount = totalAmount;

        Integer restPeopleNum = totalPeopleNum;
        Random random = new Random();
        for (int i = 0; i < totalPeopleNum - 1; i++) {
            //
            int amount = random.nextInt(restAmount / restPeopleNum * 2 - 1) + 1;
            restAmount -= amount;
            restPeopleNum--;
            amountList.add(amount);
        }
        amountList.add(restAmount);
        return amountList;
    }

    public static void main(String[] args) {
        List<Integer> amountList = divideRedPackage(1000, 10);
        System.out.println(amountList.toString());
    }
}
