package com.company.utils;

public class Accountant {

    public static float substractRentTax(float x){
        if (x<868000){
            return x;
        }
        else if(x>868000&&x<1000000){
            return (float) (x-(x*0.10));
        }
        else{
            return x;
        }

    }
}
