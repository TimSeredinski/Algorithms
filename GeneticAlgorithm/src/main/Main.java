package main;

import genetic.Genetic;

public class Main {
    public static void main(String[] args) {
        int mass[]={2,2,2,1,1,0,1,1,1,0,0,1,1,0,0,0,0,1,0,0,1,1,1,1,0,-8};
        Genetic gen = new Genetic(mass);
        System.out.println(gen.solve());
    }
}
