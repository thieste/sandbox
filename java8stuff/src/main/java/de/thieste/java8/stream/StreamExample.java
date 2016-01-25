package de.thieste.java8.stream;

import java.util.Arrays;

/**
 * Created by thieste on 20.12.15.
 */
public class StreamExample {


    public static void main(String[] args){
        new StreamExample().test();
    }


    public void test(){

        final String[] attrs = {"EAN:1214124","HAN:fghjklö"};


        System.out.println(Arrays.stream(attrs).peek(System.out ::println).count());



    }



}
