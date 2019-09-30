package com.oreilly.headfirst.design.chp8;

import org.springframework.util.ObjectUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author dongyl
 * @version 1.0
 * @title
 * @description
 * @company 好未来-爱智康
 * @created 2019-09-30 11:09
 * @changeRecord
 */
public class CoffeeWithHook extends CaffeineBeverageWithHook {
    @Override
    void brew() {
        System.out.println("Dripping Coffee through filter");
    }

    @Override
    void pourInCup() {

    }

    @Override
    void addCondiments() {
        System.out.println("Adding Sugar and milk");
    }

    @Override
    boolean customerWantsCondiments() {
        String answer = getUserInput();
        if (answer.toLowerCase().startsWith("y")) {
            return true;
        }
        return false;
    }

    private String getUserInput() {
        String answer = null;
        System.out.println("would you like milk and sugar in your coffee? (y/n)");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            answer = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("IO error trying to read your answer");
        }
        if (ObjectUtils.isEmpty(answer)) {
            return "no";
        }
        return answer;
    }
}
