package com.castle;

import com.castle.scene.SceneWolfForest;
import com.castle.ui.Ui;

import java.util.Scanner;

public class Main {



    public static void main(String[] args) {

        // 创建一些对象
        Ui ui = Ui.getUi();
        Scanner in = new Scanner(System.in);

        // 正片开始
        ui.intro();
        boolean passKey = true; // 用于控制当前关卡的结束
        String choice; // 用于记录你的每一步选择
        do {
            // 场景一
            choice = in.nextLine();
            if (choice.equals("y") || choice.equals("Y")) {
                // 战斗前夕的介绍
                ui.introWolfForest();
                // 战斗场景开关
                do {
                    choice = in.nextLine();
                    if (choice.equals("y") || choice.equals("Y")) {
                        SceneWolfForest senseWolfForest = new SceneWolfForest();
                        senseWolfForest.initSense();
                        senseWolfForest.play();

                        // 判断胜利者

                    } else if (choice.equals("n") || choice.equals("N")) {
                        ui.exitWolfForest();
                        System.exit(0);
                    } else {
                        System.out.println("请输入正确的指令！");
                    }
                } while (passKey);

            } else if (choice.equals("n") || choice.equals("N")) {
                ui.exitWolfForest();
                System.exit(0);
            } else {
                System.out.println("请输入正确的指令！");
            }
        } while (passKey);

    }
}
