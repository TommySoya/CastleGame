package com.castle.ui;

import com.castle.creature.Creature;
import com.castle.scene.Scene;

/**
 * @description:
 * @author: dell
 * @date: Created in 2020/4/28 22:07
 * @version: 1.0
 * @modified By:
 */
public class Ui {

    // 构造函数私有化
    private Ui() {
    };

    // 静态内部类实现了单例模式
    private static class UiHolder {
        private static Ui ui = new Ui();
    }

    // 返回单例
    public static Ui getUi() {
        return UiHolder.ui;
    }

    // 生物状态信息
    public void displayStatus(Scene scene) {
        System.out.println("---------------------------------------------");
        System.out.println(scene.getPerson().getDescription() +
                ":" + scene.getPerson().getHpValue());
        for (Creature item: scene.getTheArray()
             ) {
            System.out.print(item.getId() + "(" + item.getDescription()
            + "):" + item.getHpValue() + "; ");
        }
        System.out.println("\n---------------------------------------------");
    }

    // 帮助信息
    public void displayHelpMsg() {
        System.out.println("---------------------------------------------");
        System.out.println("--3 command:chop(chop wolf1)  bye  help--");
    }

    // 提示输入指令
    public void displayCmdMsg() {
        System.out.println("Please decide your decision making\n(Input 'help' to get help):");
    }

    // 提示错误界面
    public void displayErrorCmdMsg() {
        System.out.println("---------------------------------------------");
        System.out.println("The command is invalid！Please input a valid command.");
    }

    // 受击提示界面
    public void displayDamageMsg(Creature attackCreature, Creature targetCreate) {
        System.out.println(attackCreature.getDescription() +
                "对" + targetCreate.getDescription() + "造成了"
                + (-attackCreature.getCurrentWeapon().getDamagePoints())
                + "伤害");
    }

    // 生物死亡提示界面
    public void displayRemoveCreature(String description) {
        System.out.println(description + "is dead");
    }

    // 结束界面(胜利)
    public void displayVictory() {
        System.out.println("Victory!!");
    }

    // 结束界面(失败)
    public void displayDefeat() {
        System.out.println("Defeat!!");
    }

    // 结束界面
    public void displayBye() {
        System.out.println("Bye!");
    }


    // 剧情
    public void intro() {
        System.out.println("独白：\n…………这是哪儿…………\n" +
        "…………我是谁…………\n");
        System.out.println("神秘的声音：\n勇敢的骑…士啊，神指…引你来(不知哪里传来孩童的谈论：选t……)到这里。开始…你的冒险吧……\n");
        System.out.println("(周围一片黑漆漆，你更加困惑了)那儿好像有道光……");
        System.out.println("------------------------------------------------------------------------------\n" +
                "是时候做出选择了：你要过去看一下吗？（y/n)");
    }

    public void introWolfForest() {
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("这里好像是一片森林？\n等等，那是……\n" +
                "一团黑影：\n“啊嗷~~~~~~~~~~~~！”\n" +
                "（震惊）那是狼……群！");
        System.out.println("------------------------------------------------------------------------------\n" +
                "你突然发现在你的的身旁有一把生锈的铁剑，不知道还能不能用\n逃跑……我该去哪里呢？\n" +
                "骑士……难道这就是我的宿命？我到底是谁？\n" +
                "（迟疑间，狼群已经迫近）来不及了，必须做出决定了！是前进还是退却？（y/n)");
    }

    public void exitWolfForest() {
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("（奋力奔跑）不知过了多久，不知去向何方，亦不知我是谁。生于无知，亦在迷惑中离去……");
    }

}
