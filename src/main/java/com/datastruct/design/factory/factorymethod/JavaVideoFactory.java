package com.datastruct.design.factory.factorymethod;

/**
 * Created by geely
 */
public class JavaVideoFactory extends VideoFactory {
    @Override
    public Video getVideo() {
        return new JavaVideo();
    }
}
