package com.castle.sense;

import com.castle.creature.MonsterWolf;
import com.castle.creature.MonsterWolfSet;
import com.castle.creature.Person;
import com.castle.ui.Ui;
import com.castle.utils.Utils;
import com.castle.weapon.WeaponKnife;
import com.castle.weapon.WeaponSword;

import java.util.Scanner;

/**
 * @description:
 * @author: dell
 * @date: Created in 2020/4/28 21:06
 * @version: 1.0
 * @modified By:
 */
public class Sense {

    //设置场景、生物等
    private Person person = new Person("201902202", "小丁", 300,
            new WeaponSword("pw1", "倚天剑", -50));

    private MonsterWolf wolf1 = new MonsterWolf("wolf1", "狼1", 80,
            new WeaponKnife("mw1", "大刀1", -30));
    private MonsterWolf wolf2 = new MonsterWolf("wolf2", "狼2", 120,
            new WeaponKnife("mw2", "大刀2", -20));
    private MonsterWolf wolf3 = new MonsterWolf("wolf3", "狼3", 100,
            new WeaponKnife("mw3", "大刀3", -25));

    private MonsterWolfSet monsterWolfSet = new MonsterWolfSet();
    private Scanner in = new Scanner(System.in);
    private Utils utils = new Utils();

    private Ui ui = new Ui();

    //初始化
    public void initSense() {
        initPerson();
        initMonser();
    }

    public void initPerson() {
        //该生物在创建时已传参
    }

    public void initMonser() {
        //该生物在创建时已传参,只将其放入集合
        monsterWolfSet.getMonsterWolves().add(wolf1);
        monsterWolfSet.getMonsterWolves().add(wolf2);
        monsterWolfSet.getMonsterWolves().add(wolf3);
    }

    //胜利判断
//    public boolean judgeSuccess() {
//        boolean flagPersonSuccess = false;
//        if (this.getPerson().getHpValue() <= 0) {
//            flagPersonSuccess = false;
//        } else
//        return true;
//    }

    //游戏玩法
    public void play() {

        //显示当前状态
        ui.displayStatus(this);
        //进入循环
        while (true) {
            //提示用户输入指令
            ui.displayCmdMsg();
            //用户输入指令
            String command = in.nextLine();
            //split分割单元
            String[] cmdLineItems = command.split(" ");
            //判断命令内容，做出相应交互
            if (cmdLineItems[0].equals("bye")) {
                ui.displayBye();
                System.exit(0);
            } else if (cmdLineItems[0].equals("help")) {
                ui.displayHelpMsg();
                continue;
            } else if (cmdLineItems[0].equals("chop")) {
                //人使用当前武器对目标造成伤害
                this.getPerson().useArticle(getPerson().getCurrentWeapon(),
                        this.getMonsterWolfSet().get(cmdLineItems[1]));
                //提示伤害信息
                ui.displayDamageMsg(this.getPerson(),
                        this.monsterWolfSet.get(cmdLineItems[1]));
            } else {
                ui.displayErrorCmdMsg();
                continue;
            }
            //妖怪进行随机判断攻击
            for (MonsterWolf item:this.monsterWolfSet.getMonsterWolves()
                 ) {
                if (1 == this.utils.randomMonsterChop(0, 2)) {
                    //怪物对人造成伤害
                    item.useArticle(item.getCurrentWeapon(), this.getPerson());
                    //提示造成伤害信息
                    ui.displayDamageMsg(item, this.getPerson());
                }
            }
            //显示当前状态
            ui.displayStatus(this);
        }
    }

    //构造函数及get，set方法
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public MonsterWolfSet getMonsterWolfSet() {
        return monsterWolfSet;
    }

    public void setMonsterWolfSet(MonsterWolfSet monsterWolfSet) {
        this.monsterWolfSet = monsterWolfSet;
    }

}
