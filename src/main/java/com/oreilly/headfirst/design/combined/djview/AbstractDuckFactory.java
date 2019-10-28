package com.oreilly.headfirst.design.combined.djview;

/**
 * @author dongyl
 * @version 1.0
 * @title
 * @description
 * @company 好未来-爱智康
 * @created 2019/10/25 12:38
 * @changeRecord
 */
public abstract class AbstractDuckFactory {
    public abstract Quackable createMallardDuck();
    public abstract Quackable createRedheadDuck();
    public abstract Quackable createDuckCallDuck();
    public abstract Quackable createRubberDuck();
}
