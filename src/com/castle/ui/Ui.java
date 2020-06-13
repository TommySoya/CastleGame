package com.castle.ui;

import com.castle.creature.Creature;
import com.castle.creature.Person;
import com.castle.scene.Scene;

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
        System.out.println(scene.getPerson().getId() + "(" + scene.getPerson().getDescription()
                + "):" +
                " <HP> " + scene.getPerson().getHpValue());
        for (Creature item: scene.getTheArray()
             ) {
            System.out.print(item.getId() + "(" + item.getDescription()
            + "): <HP> " + item.getHpValue() + "; ");
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
        System.out.println("--你可以选择如下操作:<攻击>chop(例如：chop wolf1)  <离开>bye  <帮助>help--");
    }

    // 提示输入指令
    public void displayCmdMsg() {
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

    public void introBranchRoad() {
        System.out.println("-------------------------------------------------------------------------------------------");
        System.out.println("眼前恍惚了一下？" +
                "\n（神秘的声音）嘿嘿，小伙子，我们来玩个游戏吧。这有张写着数字的纸片，" +
                "\n你要是猜对了，我就送给你一把上好的武器！不过如果猜错了……");
        System.out.println("有点好奇，赌一把么？（y/n)");
    }

    public void exitBranchRoad() {
        System.out.println("（身体越陷越深）不行，要赶快离开这里了！" +
                "（突然发现）前面似乎有座城堡");
    }

    public void exitBranchRoadToBye() {
        System.out.println("---------------------------------------------");
        System.out.println("（你没有理睬脚下的一切）前进，前进，在沼泽中迷失……");
    }

    public void exit() {
        System.out.println("---------------------------------------------");
        System.out.println("（倒在血泊中）就这样……结束了么……");
    }

}
