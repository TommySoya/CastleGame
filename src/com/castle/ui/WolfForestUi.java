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
public class WolfForestUi {

    // 构造函数私有化
    private WolfForestUi() {
    };

    // 静态内部类实现了单例模式
    private static class UiHolder {
        private static WolfForestUi ui = new WolfForestUi();
    }

    // 返回单例
    public static WolfForestUi getUi() {
        return UiHolder.ui;
    }

    // 剧情
    public void intro() {
        System.out.println("独白：\n…………这是哪儿…………\n" +
        "…………我是谁…………\n");
        System.out.println("神秘的声音：\n勇敢的骑…士啊，神指…引你来(不知哪里传来孩童的谈论：选t……)到这里。开始…你的冒险吧……\n");
        System.out.println("(周围一片黑漆漆，你更加困惑了)那儿好像有道光……");
        System.out.println("---------------------------------------------\n" +
                "是时候做出选择了：你要过去看一下吗？（y/n)");
    }

    public void introWolfForest() {
        System.out.println("---------------------------------------------");
        System.out.println("这里好像是一片森林？\n等等，那是……\n" +
                "一团黑影：\n“啊嗷~~~~~~~~~~~~！”\n" +
                "（震惊）那是狼……群！");
        System.out.println("---------------------------------------------\n" +
                "你突然发现在你的的身旁有一把生锈的铁剑，不知道还能不能用\n逃跑……我该去哪里呢？\n" +
                "骑士……难道这就是我的宿命？我到底是谁？\n" +
                "（迟疑间，狼群已经迫近）来不及了，必须做出决定了！是前进还是退却？（y/n)");
    }

    public void exitWolfForestToBye() {
        System.out.println("---------------------------------------------");
        System.out.println("（奋力奔跑）不知过了多久，不知去向何方，亦不知我是谁。生于无知，亦在迷惑中离去……");
    }

    public void exitWolfForest() {
        System.out.println("---------------------------------------------");
        System.out.println("（呼...松了口气）好险，应该安全了吧，赶快休息一下\n…………生命值恢复了10%");
        // 此处为场景衔接的彩蛋
        Person.getPerson().setHpValue(Person.getPerson().getHpValue() + Person.getPerson().getMaxHp() / 10);
        Ui.getUi().displayPersonStatus();
        System.out.println("---------------------------------------------");
        System.out.println("（远山传来一声狼嚎，头有点痛）似乎又有狼群靠近，该离开了！");
    }

}
