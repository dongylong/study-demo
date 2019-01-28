package com.oreilly.headfirst.design.chp7.adapter.adapter;

import com.oreilly.headfirst.design.chp7.adapter.bean.Duck;
import com.oreilly.headfirst.design.chp7.adapter.bean.Turkey;

/**
 * @author dongyl
 * @date 12:43 1/27/19
 * @project study-demo
 */
//implements 想要转换的类型接口
public class TurkeyAdapter implements Duck {

    Turkey turkey;

    // 获取适配器对象引用
    public TurkeyAdapter(Turkey turkey) {
        this.turkey = turkey;
    }

    //实现接口中所有方法
    @Override
    public void quack() {
        turkey.gobble();
    }

    @Override
    public void fly() {
        for (int i = 0; i < 5; i++) {
            turkey.fly();
        }
    }
}
