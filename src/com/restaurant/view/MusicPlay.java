package com.restaurant.view;

import javafx.scene.media.AudioClip;
import java.io.File;

public class MusicPlay implements  Runnable{

    @Override
    public void run() {
        AudioClip ac;
        ac = new AudioClip(new File("./music/SHAUN – Way Back Home.mp3").toURI().toString());
        ac.play();   //开始播放
        ac.setCycleCount(1000);  //设置循环次数
    }

}
