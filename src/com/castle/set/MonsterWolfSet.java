package com.castle.set;

import com.castle.creature.MonsterWolf;

import java.util.ArrayList;

/**
 * @description:
 * @author: dell
 * @date: Created in 2020/4/28 21:11
 * @version: 1.0
 * @modified By:
 */
public class MonsterWolfSet {

    //狼集合
    private ArrayList<MonsterWolf> monsterWolves = new ArrayList<>();

    //构造函数及get、set方法
    public MonsterWolfSet(ArrayList<MonsterWolf> monsterWolves) {
        this.monsterWolves = monsterWolves;
    }

    public ArrayList<MonsterWolf> getMonsterWolves() {
        return monsterWolves;
    }

    public void setMonsterWolves(ArrayList<MonsterWolf> monsterWolves) {
        this.monsterWolves = monsterWolves;
    }

    public MonsterWolfSet() {
    }

    //CURD
    //根据id（String）查找对应的MonsterWolf对象
    public MonsterWolf get(String id) {
        MonsterWolf monsterWolf = null;
        for (MonsterWolf item:monsterWolves
             ) {
            if (id.equals(item.getId())) {
                monsterWolf = item;
                break;
            }
        }
        return monsterWolf;
    }

}
