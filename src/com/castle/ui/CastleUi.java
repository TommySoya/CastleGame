package com.castle.ui;

import com.castle.creature.Person;

/**
 * @description:
 * @author: dell
 * @date: Created in 2020/4/28 22:07
 * @version: 1.0
 * @modified By:
 */
public class CastleUi extends Ui {

    // 构造函数私有化
    private CastleUi() {
    };

    // 静态内部类实现了单例模式
    private static class UiHolder {
        private static CastleUi ui = new CastleUi();
    }

    // 返回单例
    public static CastleUi getUi() {
        return UiHolder.ui;
    }

    // 剧情

    public void introCastle() {
        System.out.println("---------------------------------------------");
        System.out.println("（你低头向着城堡走去，得知身世的你不知如何面对这座城堡）" +
                "砰！\n" +
                "（抬头）已经……到了吗（发现大门就在面前）");
        System.out.println("\n难道这座城堡会移动？（y）\n" +
                "我已经走了这么久了么？（n）");
    }

    public void enterCastle() {
        System.out.println("---------------------------------------------");
        System.out.println("（身后传来狼嚎）看来只能面对了……" +
                "\n（城堡大门忽地缓缓敞开，似乎感应到了你的到来）\n" +
                "\n公爵：来吧孩子，不必多说了" + Person.getPerson().getCurrentWeapon().getDescription() +
                "的指引……呵呵" +
                "\n上来吧，让我看看你成长到什么地步了");
    }

    public void exitCastle() {
        System.out.println("---------------------------------------------");
        System.out.println("我：一切都结束了么");
        System.out.println("公爵之魂：无数的孩子来此，他们都成为了下一个公爵啊！！！" +
                "\n难道你还不明白，这虚假的世界，只剩下反复轮回了吗？");
        System.out.println("========完=========");
    }

}
