package com.example.seakretmessenger;

class ImageReciever {
    private static final ImageReciever ourInstance = new ImageReciever();

    private ImageReciever() {
    }

    static ImageReciever getInstance() {
        return ourInstance;
    }
}
