package com.castle.sense;

import com.castle.creature.Creature;
import com.castle.creature.MonsterWolf;
import com.castle.creature.Person;
import com.castle.set.MonsterWolfSet;
import com.castle.ui.Ui;
import com.castle.utils.Utils;
import com.castle.weapon.WeaponKnife;
import com.castle.weapon.WeaponSword;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @description:
 * @author: dell
 * @date: Created in 2020/4/28 21:06
 * @version: 1.0
 * @modified By:
 */
public class SenseWolfForest extends Sense {

    //设置场景、生物等
    private final MonsterWolf wolf1 = new MonsterWolf("wolf1", "狼1", 80,
            new WeaponKnife("mw1", "大刀1", -30));
    private final MonsterWolf wolf2 = new MonsterWolf("wolf2", "狼2", 120,
            new WeaponKnife("mw2", "大刀2", -20));
    private final MonsterWolf wolf3 = new MonsterWolf("wolf3", "狼3", 100,
            new WeaponKnife("mw3", "大刀3", -25));

    private MonsterWolfSet monsterWolfSet = new MonsterWolfSet();
    private ArrayList<Creature> theArray = this.getMonsterSet().getMonsters();

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
        monsterWolfSet.getMonsters().add(wolf1);
        monsterWolfSet.getMonsters().add(wolf2);
        monsterWolfSet.getMonsters().add(wolf3);
    }

    // 人的回合--攻击
    public void attackMonster(String target) {
        // 人对妖怪造成伤害
        this.getPerson().useArticle(getPerson().getCurrentWeapon(),
                this.getMonsterSet().get(theArray, target));
        //提示伤害信息
        ui.displayDamageMsg(this.getPerson(),
                this.monsterWolfSet.get(theArray, target));
    }

    // 妖怪的回合--攻击
    public void attackPerson() {
        for (Creature item:theArray
        ) {
            if (1 == Utils.randomMonsterChop(0, 2)) {
                //怪物对人造成伤害
                item.useArticle(item.getCurrentWeapon(), this.getPerson());
                //提示造成伤害信息
                ui.displayDamageMsg(item, this.getPerson());
            }
        }
    }

    // 判断是否死亡
    public void checkIsDead(String target) {
        if (this.getMonsterSet().get(theArray, target).getHpValue() <= 0) {
            boolean flag = false;
            String enemyName = this.getMonsterSet().get(theArray, target).getDescription();
            flag = this.getMonsterSet().delete(theArray, this.getMonsterSet().get(theArray, target).getId());
            if (flag) {
                ui.displayRemoveCreature(enemyName);
            }
        }
    }

    // 胜利判断
    public boolean judgeSuccess(MonsterWolfSet monsterWolfSet) {
        boolean flagPersonSuccess = false;
        if (monsterWolfSet.getMonsters().size() == 0) {
            flagPersonSuccess = true;
        }
        return flagPersonSuccess;
    }

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
                // 人攻击
                this.attackMonster(cmdLineItems[1]);
                // 判断攻击目标是否死亡
                this.checkIsDead(cmdLineItems[1]);
            } else {
                ui.displayErrorCmdMsg();
                continue;
            }

            // 判断是否胜利
            if (judgeSuccess(this.getMonsterSet())) {
                ui.displayVictory();
                break;
            }

            //妖怪进行随机判断攻击
            this.attackPerson();

            // 判断是否失败
            if (getPerson().getHpValue() <= 0) {
                ui.displayRemoveCreature(getPerson().getDescription());
                ui.displayDefeat();
                break;
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

    @Override
    public MonsterWolfSet getMonsterSet() {
        return monsterWolfSet;
    }

    public void setMonsterWolfSet(MonsterWolfSet monsterWolfSet) {
        this.monsterWolfSet = monsterWolfSet;
    }

}
