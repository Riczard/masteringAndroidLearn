package com.kuklinski.masteringandroid.samples;

public class MySingleton {

    private static MySingleton sInstance;

    public static MySingleton getInstance() {
        if(sInstance == null) {
            sInstance = new MySingleton();
        }

        return sInstance;
    }
}
