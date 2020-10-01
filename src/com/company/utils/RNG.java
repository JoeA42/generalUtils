package com.company.utils;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class RNG {

    Random random = new Random();

    public ArrayList<String> shuffle(ArrayList<String> list){
        ArrayList<String> shuffledList = new ArrayList<>();
        while (list.size()!=0){
            String current = list.get(random.nextInt(list.size()));
            list.remove(current);
            shuffledList.add(current);
        }
        return shuffledList;
    }
}

