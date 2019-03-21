package com.example.seakretmessenger;

class TextSender {
    private static final TextSender ourInstance = new TextSender();

    private TextSender() {
    }

    static TextSender getInstance() {
        return ourInstance;
    }
}
