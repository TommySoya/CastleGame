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
public class MonsterCrocodileSet extends CreatureSet {

    //鳄鱼集合
    private ArrayList<Creature> monsterCrocodiles = new ArrayList<>();

    //构造函数及get、set方法
    private MonsterCrocodileSet(ArrayList<Creature> monsterCrocodiles) {
        super();
        this.monsterCrocodiles = monsterCrocodiles;
    }

    private MonsterCrocodileSet() {
        super();
    }

    // 静态内部类
    private static class MonsterWolfSetHolder {
        private static MonsterCrocodileSet monsterCrocodileSet = new MonsterCrocodileSet();
    }

    public static MonsterCrocodileSet getMonsters() {
        return MonsterWolfSetHolder.monsterCrocodileSet;
    }

    public void setMonsterCrocodiles(ArrayList<Creature> monsterWolves) {
        this.monsterCrocodiles = monsterWolves;
    }

    public ArrayList<Creature> getMonsterCrocodiles() {
        return monsterCrocodiles;
    }
}
