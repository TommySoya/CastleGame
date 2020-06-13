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
public class BranchRoadUi {

    // 构造函数私有化
    private BranchRoadUi() {
    };

    // 静态内部类实现了单例模式
    private static class UiHolder {
        private static BranchRoadUi ui = new BranchRoadUi();
    }

    // 返回单例
    public static BranchRoadUi getUi() {
        return UiHolder.ui;
    }

    public void introBranchRoad() {
        System.out.println("-------------------------------------------------------------------------------------------");
        System.out.println("（深夜）似乎越走越累……我难道迷路了吗？" +
                "哎呦！（好像踢到了什么东西）");
        System.out.println("有点好奇，要不要看一下是什么呢？（y/n)");
    }

    public void exitBranchRoad() {
        System.out.println("（身体越陷越深）不行，要赶快离开这里了！" +
                "（突然发现）前面似乎有座城堡");
    }

}
