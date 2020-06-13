package com.castle.scene;

import com.castle.creature.MonsterWolf;
import com.castle.creature.Person;
import com.castle.set.MonsterWolfSet;
import com.castle.utils.Utils;
import com.castle.weapon.Weapon;
import com.castle.weapon.WeaponDagger;
import com.castle.weapon.WeaponKnife;
import com.castle.weapon.WeaponSword;
import jdk.jshell.execution.Util;

import java.util.Scanner;

/**
 * @description:
 * @author: dell
 * @date: Created in 2020/4/28 21:06
 * @version: 1.0
 * @modified By:
 */
public class SceneBranchRoad extends Scene {

    // 特殊场景——歧路

    public SceneBranchRoad() {
    }

    //初始化
    public void initSense() {
    }

    @Override
    // <歧路--猜数游戏>
    public void play() {

        Scanner in = new Scanner(System.in);
        // 产生随机数
        int truValue = Utils.getUtils().randomMonsterChop(0, 100);
        // 计数，用于触发其他机制
        int counts = 0;
        int targetCounts = Utils.getUtils().randomMonsterChop(1, 5);

        // 猜大小游戏
        System.out.println("（神秘的声音）既然选择了，那么不要后悔哦，咯咯咯~" +
                "\n猜猜看吧（输入一个整数）：");
        while (true) {
            // 获取猜测值
            counts ++;
            int guessValue = Integer.parseInt(in.nextLine());
            if (guessValue == truValue) {
                System.out.println("（咯咯咯……）猜对了哦，看看奖励吧" +
                        "\n----------------\n");
                break;
            } else if (truValue > guessValue) {
                System.out.println("（咯咯咯……）大胆一点嘛，扭扭捏捏的像什么样子" +
                        "\n----------------\n" +
                        "再试试吧（输入一个整数）：");
            } else if (truValue < guessValue) {
                System.out.println("（咯咯咯……）这么浮躁？凡事要踏实一点喔" +
                        "\n----------------\n" +
                        "再试试吧（输入一个整数）：");
            }

            // 若没有猜对，诅咒降临
            Person.getPerson().setHpValue(Person.getPerson().getHpValue() - (int)(Math.pow(2,counts)));
            ui.displayPersonStatus();
            if (counts == 1) {
                System.out.println("糟糕，我在流血！");
            }

            // 故障触发机制
            if (counts == targetCounts) {
                System.out.println("(滋啦……) @!!%^#&#" +
                        "#@!# <" +
                        truValue / 10 +
                        "……> $@!%%!#@$(&^");
                targetCounts += Utils.getUtils().randomMonsterChop(1, 6);
            }
        }
    }

    // 得到宝箱内容
    public Weapon reward () {
        Weapon weapon = null;
        int ranNum = Utils.randomMonsterChop(0, 3);
        switch (ranNum) {
            case 0:
                weapon = new WeaponKnife("crime", "天罪", -30);
                break;
            case 1:
                weapon = new WeaponDagger("ling", "雁翎", -30);
                break;
            case 2:
                weapon = new WeaponSword("shadow", "承影", -30);
                break;
        }
        return weapon;
    }

    // 判断是否要得到宝箱
    public void isGetWeapon() {
        Weapon weapon = reward();
        System.out.println("<武器名称> " + weapon.getDescription());
        System.out.println("我要拿起它么？（y/n）");
        if (this.choice().equals("y")) {
            Person.getPerson().setCurrentWeapon(weapon);
            Person.getPerson().getWeaponSet().getWeapons().add(weapon);
            ui.displayPersonStatus();
        } else {
            System.out.println("（怀疑地）难道这又是陷阱？");
        }
    }

    // 总体
    public void plot() {
        // 场景介绍
        ui.introBranchRoad();
        // 场景触发
        switch (this.choice()) {
            case "y":
                initSense();
                play();
                isGetWeapon();
                break;
            case "n":
                ui.exit();
        }
        // 场景收尾
        ui.exitBranchRoad();
    }

}

