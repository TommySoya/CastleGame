package com.castle.ui;

import com.castle.creature.Creature;
import com.castle.creature.Person;
import com.castle.scene.Scene;

/**
 * @description:
 * @author: dell
 * @date: Created in 2020/4/28 22:07
 * @version: 1.0
 * @modified By:
 */
public class CrocodileSwampUi extends Ui {

    // 构造函数私有化
    private CrocodileSwampUi() {
    };

    // 静态内部类实现了单例模式
    private static class UiHolder {
        private static CrocodileSwampUi ui = new CrocodileSwampUi();
    }

    // 返回单例
    public static CrocodileSwampUi getUi() {
        return UiHolder.ui;
    }

    // 剧情
    public void introCrocodileSwampFir() {
        System.out.println("-------------------------------------------------------------------------------------------");
        System.out.println("（深夜）似乎越走越累……我难道迷路了吗？" +
                "哎呦！（好像踢到了什么东西）");
        System.out.println("有点好奇，要不要看一下是什么呢？（y/n)");
    }

    public void exitCrocodileSwampToBye() {
        System.out.println("---------------------------------------------");
        System.out.println("（你没有理睬脚下的一切）前进，前进，在沼泽中迷失……");
    }

    public void introCrocodileSwampSec() {
        System.out.println("---------------------------------------------");
        System.out.println("但是……这里……（这里是一片沼泽！）\n" +
                "（突然被痛击）啊——！\n" +
                "是巨鳄！");
        System.out.println("只能拼死一搏了！");
    }

    public void exitCrocodileSwamp() {
        System.out.println("---------------------------------------------");
        System.out.println("(原本虚弱的身体迅速恢复)奇怪，明明差点死掉，却并没有感到疼痛呢\n" +
                "难道是回光返照？我还能活下来么？");
    }

}
