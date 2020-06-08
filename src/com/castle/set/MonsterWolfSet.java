package com.castle.set;

import com.castle.creature.Creature;
import com.castle.creature.MonsterWolf;
import com.castle.ui.Ui;

import java.util.ArrayList;
import java.util.IdentityHashMap;

/**
 * @description:
 * @author: dell
 * @date: Created in 2020/4/28 21:11
 * @version: 1.0
 * @modified By:
 */
public class MonsterWolfSet extends CreatureSet {

    //狼集合
    private ArrayList<Creature> monsterWolves = new ArrayList<>();

    //构造函数及get、set方法
    private MonsterWolfSet(ArrayList<Creature> monsterWolves) {
        super();
        this.monsterWolves = monsterWolves;
    }

    private MonsterWolfSet() {
        super();
    }

    // 静态内部类
    private static class MonsterWolfSetHolder {
        private static MonsterWolfSet monsterWolfSet = new MonsterWolfSet();
    }

    public static MonsterWolfSet getMonsters() {
        return MonsterWolfSetHolder.monsterWolfSet;
    }

    public void setMonsterWolves(ArrayList<Creature> monsterWolves) {
        this.monsterWolves = monsterWolves;
    }

    public ArrayList<Creature> getMonsterWolves() {
        return monsterWolves;
    }
}
