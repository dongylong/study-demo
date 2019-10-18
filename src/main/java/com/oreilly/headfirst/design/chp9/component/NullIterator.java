package com.oreilly.headfirst.design.chp9.component;

import java.util.Iterator;
import java.util.function.Consumer;

/**
 * @author dongyl
 * @version 1.0
 * @title
 * @description
 * @company 好未来-爱智康
 * @created 2019/10/18 09:01
 * @changeRecord
 */
public class NullIterator implements Iterator {
    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Object next() {
        return null;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();

    }

    @Override
    public void forEachRemaining(Consumer action) {

    }
}
