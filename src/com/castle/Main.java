package com.castle;

import com.castle.creature.Person;
import com.castle.scene.Scene;
import com.castle.scene.SceneWolfForest;
import com.castle.ui.Ui;

import java.util.Scanner;

public class Main {



    public static void main(String[] args) {

        // 创建一些对象(工具人）
        Ui ui = Ui.getUi();
        Scanner in = new Scanner(System.in);
        Scene initScene = new Scene();

        // 正片开始
        boolean passKey = true; // 用于控制当前关卡的结束
        String choice; // 用于记录你的每一步选择
        ui.intro();


        // 场景一
        // 战斗前夕的介绍--剧情介绍<狼群出现>
        choice = initScene.choice();
        switch (choice) {
            case "y":
                ui.introWolfForest();
                break;
            case "n":
                ui.exitWolfForest();
                System.exit(0);
                break;
        }

        // 战斗--<狼群的猛攻>
        choice = initScene.choice();
        switch (choice) {
            case "y":
                SceneWolfForest senseWolfForest = new SceneWolfForest();
                senseWolfForest.initSense();
                senseWolfForest.play();
                break;
            case "n":
                ui.exitWolfForest();
                System.exit(0);
                break;
        }

        // 场景过渡--死亡判断<下一幕剧情的触发及彩蛋>


        // 场景二

    }
}
