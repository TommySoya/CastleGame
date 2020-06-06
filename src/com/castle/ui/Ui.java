package com.castle.ui;

import com.castle.creature.Creature;
import com.castle.creature.MonsterWolf;
import com.castle.sense.Sense;

/**
 * @description:
 * @author: dell
 * @date: Created in 2020/4/28 22:07
 * @version: 1.0
 * @modified By:
 */
public class Ui {

    //生物状态信息
    public void displayStatus(Sense sense) {
        System.out.println("---------------------------------------------");
        System.out.println(sense.getPerson().getDescription() +
                ":" + sense.getPerson().getHpValue());
        for (MonsterWolf item:sense.getMonsterWolfSet().getMonsterWolves()
             ) {
            System.out.print(item.getId() + "(" + item.getDescription()
            + "):" + item.getHpValue() + "; ");
        }
        System.out.println("\n---------------------------------------------");
    }

    //帮助信息
    public void displayHelpMsg() {
        System.out.println("---------------------------------------------");
        System.out.println("--3 command:chop(chop wolf1)  bye  help--");
    }

    //提示输入指令
    public void displayCmdMsg() {
        System.out.println("Please decide your decision making\n(Input 'help' to get help):");
    }

    //提示错误界面
    public void displayErrorCmdMsg() {
        System.out.println("---------------------------------------------");
        System.out.println("The command is invalid！Please input a valid command.");
    }

    //受击提示界面
    public void displayDamageMsg(Creature attackCreature, Creature targetCreate) {
        System.out.println(attackCreature.getDescription() +
                "对" + targetCreate.getDescription() + "造成了"
                + (-attackCreature.getCurrentWeapon().getDamagePoints())
                + "伤害");
    }

    //生物死亡提示界面
    public void displayRemoveCreature(String description) {
        System.out.println(description + "is dead");
    }

    //结束界面(胜利)
    public void displayVictory() {
        System.out.println("Victory!!");
    }

    //结束界面(失败)
    public void displayDefeat() {
        System.out.println("Defeat!!");
    }

    //结束界面
    public void displayBye() {
        System.out.println("Bye!");
    }

}
