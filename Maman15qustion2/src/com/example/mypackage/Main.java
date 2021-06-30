package com.example.mypackage;

import javax.swing.*;

 /* This is just the main for testing the classes. */

public class Main {

    public static void main(String[] args) {

        int numOfPhilosophers = 5;
        Sticks sticks = new Sticks(numOfPhilosophers);

        Philosopher[] philosophers = new Philosopher[numOfPhilosophers];
        for (int i = 0; i < numOfPhilosophers; i++) {
            philosophers[i] = new Philosopher(i,numOfPhilosophers,sticks);
            philosophers[i].start();
        }
        DiningPanel diningPanel = new DiningPanel(philosophers);
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.add(diningPanel);
        window.setSize(400,400);
        window.setVisible(true);

    }
}
