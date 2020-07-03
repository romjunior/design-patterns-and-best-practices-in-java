package com.exemplo.structural.adapter;

public class Mp4Player implements AdvancedMediaPlayer{
    @Override
    public void playVlc(String fileName) {
        //teste
    }

    @Override
    public void playMp4(String fileName) {
        System.out.println("Playing mp4 file. name: " + fileName);
    }
}
