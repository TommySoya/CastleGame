package com.castle;

import com.castle.sense.Sense;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Sense sense = new Sense();
        sense.initSense();
        sense.play();
    }
}
