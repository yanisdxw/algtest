package com.dxw.design.factory.factorymethod;

/**
 * Created by geely
 */
public class FEVideo extends Video{
    @Override
    public void produce() {
        System.out.println("录制FE课程视频");
    }
}
