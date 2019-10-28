package com.oreilly.headfirst.design.combined.djview;

/**
 * @author dongyl
 * @version 1.0
 * @title
 * @description
 * @company 好未来-爱智康
 * @created 2019/10/25 12:27
 * @changeRecord
 */
public class DuckSimulator {
    public static void main(String[] args) {

        DuckSimulator simulator = new DuckSimulator();
        AbstractDuckFactory duckFactory = new CountingDuckFactory();
        simulator.simulate(duckFactory);
    }

    private void simulate(AbstractDuckFactory duckFactory) {
        Quackable mallardDuck = duckFactory.createMallardDuck();
        Quackable redheadDuck = duckFactory.createRedheadDuck();
        Quackable duckCall = duckFactory.createDuckCallDuck();
        Quackable rubberDuck = duckFactory.createRubberDuck();
        Quackable goose = new QuackCounter(new GooseAdapter(new Goose()));

        System.out.println("Duck simulator with abstract factory");
        Flock flocks = new Flock();
        flocks.add(mallardDuck);
        flocks.add(redheadDuck);
        flocks.add(duckCall);
        flocks.add(rubberDuck);
        Flock flockOfMallards = new Flock();

        Quackable millardOne = duckFactory.createDuckCallDuck();
        Quackable millardTwo = duckFactory.createDuckCallDuck();
        Quackable millardThree = duckFactory.createDuckCallDuck();
        Quackable millardFour = duckFactory.createDuckCallDuck();
        flockOfMallards.add(millardOne);
        flockOfMallards.add(millardTwo);
        flockOfMallards.add(millardThree);
        flockOfMallards.add(millardFour);
        flocks.add(flockOfMallards);


        simulate(flocks);
        simulate(flockOfMallards);
//        simulate(mallardDuck);
//        simulate(redheadDuck);
//        simulate(duckCall);
//        simulate(rubberDuck);
//        simulate(goose);
        System.out.println("The ducks quacked" +QuackCounter.getQuacks() +"times");
    }

    private void simulate() {
        Quackable mallardDuck = new QuackCounter(new MallardDuck());
        Quackable redheadDuck = new QuackCounter(new RedheadDuck());
        Quackable duckCall = new QuackCounter(new DuckCall());
        Quackable rubberDuck = new QuackCounter(new RubberDuck());
        Quackable goose = new QuackCounter(new GooseAdapter(new Goose()));

        System.out.println("Duck simulator");
        simulate(mallardDuck);
        simulate(redheadDuck);
        simulate(duckCall);
        simulate(rubberDuck);
        simulate(goose);
        System.out.println("The ducks quacked" +QuackCounter.getQuacks() +"times");
    }

    void simulate(Quackable duck) {
        duck.quack();
    }
}
