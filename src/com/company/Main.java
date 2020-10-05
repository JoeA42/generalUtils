package com.company;

import com.company.math.DiscMath.Set;
import com.company.math.DiscMath.SetOperations;
import com.company.utils.RNG;

public class Main {

    private static RNG rng = new RNG();

    public static void main(String[] args) {

//        ArrayList<String> movieList = new ArrayList<String>();
//        movieList.add("pincesa y el sapo");
//        movieList.add("your name");
//        movieList.add("madmax fury road");
//        movieList.add("otra pelicula");
//
//        System.out.println(movieList.get(0));
//        System.out.println(movieList.get(1));;
//        System.out.println(movieList.get(2));;
//        System.out.println(movieList.get(3));;
//
//        ArrayList<String> shuffledMovieList = new ArrayList<>();
//        shuffledMovieList = rng.shuffle(movieList);
//
//        System.out.println(shuffledMovieList.get(0));
//        System.out.println(shuffledMovieList.get(1));
//        System.out.println(shuffledMovieList.get(2));
//        System.out.println(shuffledMovieList.get(3));

        Set A = new Set("A");
        A.add("0");
        A.add("2");
        A.add("8");
        A.print();


        Set B = new Set("B");
        B.add("2");
        B.add("8");
        B.add("9");
        B.print();

        Set C = new Set("C");
        C.add("0");
        C.add("4");
        C.add("8");
        C.add("9");
        C.add("7");

        C.print();

        Set U = new Set("Universe");
        U.add("0");
        U.add("2");
        U.add("4");
        U.add("6");
        U.add("8");
        U.add("9");

        SetOperations.powerSet(C).print();

    }
}
