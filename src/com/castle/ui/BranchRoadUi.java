package com.castle.ui;

import com.castle.creature.Creature;
import com.castle.creature.Person;
import com.castle.scene.Scene;
import com.castle.weapon.Weapon;

/**
 * @description:
 * @author: dell
 * @date: Created in 2020/4/28 22:07
 * @version: 1.0
 * @modified By:
 */
public class BranchRoadUi extends Ui {

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
        System.out.println("眼前恍惚了一下？" +
                "\n（神秘的声音）嘿嘿，小伙子，我们来玩个游戏吧。这有张写着数字的纸片，" +
                "\n你要是猜对了，我就送给你一把上好的武器！不过如果猜错了……");
        System.out.println("有点好奇，赌一把么？（y/n)");
    }

    public void exitBranchRoad() {
        System.out.println("---------------------------------------------");
        System.out.println("（身体越陷越深）不行，要赶快离开这里了！" +
                "（突然发现）前面似乎有座城堡");
    }

    public void exitBranchRoadToContinue() {
        System.out.println("---------------------------------------------");
        System.out.println("你拒绝了这场赌注,这或许是理智的选择了，但这真的正确么？");
    }

    public void truchIdent(Weapon weapon) {
        System.out.println("---------------------------------------------");
        System.out.println("(" + weapon.getDescription() +
                "似乎有着不寻常的悸动)" +
                "\n    <脑海中逐渐浮现>" +
                "\n      是你么，少爷……" +
                "\n公爵已经不再是从前那个公爵了" +
                "\n    一切都破碎了……" +
                "\n  少爷没事，我就放心了" +
                "\n也或许只有你能制服他了吧……" +
                "\n器,将予你最后的洗礼。最终之战，愿少爷能找到破绽，战胜公……那个恶魔吧");
    }

}
