package com.castle.ui;

import com.castle.creature.Creature;
import com.castle.creature.Person;
import com.castle.scene.Scene;
import com.castle.weapon.Weapon;

import javax.sound.midi.Soundbank;

/**
 * @description:
 * @author: dell
 * @date: Created in 2020/4/28 22:07
 * @version: 1.0
 * @modified By:
 */
public class Ui {

    // 构造函数私有化
    public Ui() {
    };

    // 生物状态信息
    public void displayStatus(Scene scene) {
        System.out.println("---------------------------------------------");
        System.out.println(scene.getPerson().getId() + "(" + scene.getPerson().getDescription()
                + "):" +
                " <HP> " + scene.getPerson().getHpValue() +
                "  <Status> " + scene.getPerson().getStatus());
        for (Creature item: scene.getTheArray()
             ) {
            System.out.print(item.getId() + "(" + item.getDescription()
            + "): <HP> " + item.getHpValue() + "  <Status> " + item.getStatus() + "; ");
        }
        System.out.println("\n---------------------------------------------");
    }

    // 人物详细信息
    public void displayPersonStatus() {
        System.out.println("---------------------------------------------");
        System.out.println(Person.getPerson().getId() + "(" + Person.getPerson().getDescription()
                + "):\t" +
                "生命值：" + Person.getPerson().getHpValue() +
                "\n武器(" + Person.getPerson().getCurrentWeapon().getDescription() + ")： 攻击力： " +
                (-Person.getPerson().getCurrentWeapon().getDamagePoints()));
    }

    // 帮助信息
    public void displayHelpMsg() {
        System.out.println("---------------------------------------------");
        System.out.println("--你可以选择如下操作:<攻击>chop(例如：chop wolf1)  <防御>defence  <离开>bye  <帮助>help--");
    }

    // 提示输入指令
    public void displayCmdMsg() {
        System.out.println("---------------------------------------------");
        System.out.println("你可以：[攻击<chop>  切换武器<switch>  防御<defence>  结束游戏<bye>  查看帮助信息<help>]");
        System.out.println("请选择你的操作\n(输入\"help\"查看帮助信息):");
    }

    // 提示错误界面
    public void displayErrorCmdMsg() {
        System.out.println("---------------------------------------------");
        System.out.println("输入的命令无效，请重新输入（输入help查看有效的指令）：");
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
        System.out.println("<" + description + " 被击杀>");
    }

    // 战斗开始
    public void displayBegin() {
        System.out.println("\n\n========<战斗开始>========");
    }

    // 结束界面(胜利)
    public void displayVictory() {
        System.out.println("========<胜利>========");
    }

    // 结束界面(失败)
    public void displayDefeat() {
        System.out.println("========<失败>========");
    }

    // 结束界面
    public void displayBye() {
        System.out.println("感谢您的使用，再见!");
    }

    // 剧情--游戏介绍
    public void intro() {
        System.out.println("独白：\n…………这是哪儿…………\n" +
                "…………我是谁…………\n");
        System.out.println("神秘的声音：\n勇敢的骑…士啊，神指…引你来(不知哪里传来孩童的谈论：选t……)到这里。开始…你的冒险吧……\n");
        System.out.println("(周围一片黑漆漆，你更加困惑了)那儿好像有道光……");
        System.out.println("---------------------------------------------\n" +
                "是时候做出选择了：你要过去看一下吗？（y/n)");
    }

    // 剧情--结束游戏
    public void exit() {
        System.out.println("---------------------------------------------");
        System.out.println("（倒在血泊中）就这样……结束了么……");
    }

}
