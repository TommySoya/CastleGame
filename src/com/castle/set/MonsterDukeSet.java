package com.castle.set;

import com.castle.creature.Creature;

import java.util.ArrayList;

/**
 * @description:
 * @author: dell
 * @date: Created in 2020/4/28 21:11
 * @version: 1.0
 * @modified By:
 */
public class MonsterDukeSet extends CreatureSet {

    //狼集合
    private ArrayList<Creature> monsterDuke = new ArrayList<>();

    //构造函数及get、set方法
    private MonsterDukeSet(ArrayList<Creature> monsterDuke) {
        super();
        this.monsterDuke = monsterDuke;
    }

    private MonsterDukeSet() {
        super();
    }

    // 静态内部类
    private static class MonsterDukeSetHolder {
        private static MonsterDukeSet monsterDukeSet = new MonsterDukeSet();
    }

    public static MonsterDukeSet getMonsters() {
        return MonsterDukeSetHolder.monsterDukeSet;
    }

    public void setMonsterDuke(ArrayList<Creature> monsterDuke) {
        this.monsterDuke = monsterDuke;
    }

    public ArrayList<Creature> getMonsterDuke() {
        return monsterDuke;
    }
}
