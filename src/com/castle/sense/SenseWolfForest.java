package com.castle.sense;

import com.castle.creature.Creature;
import com.castle.creature.MonsterWolf;
import com.castle.creature.Person;
import com.castle.set.CreatureSet;
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

    public SenseWolfForest() {
        super.monsterSet = MonsterWolfSet.getMonsters();
        super.theArray = MonsterWolfSet.getMonsters().getMonsterWolves();
    }

    //设置场景、生物等
    private final MonsterWolf wolf1 = new MonsterWolf("wolf1", "狼1", 80,
            new WeaponKnife("mw1", "大刀1", -30));
    private final MonsterWolf wolf2 = new MonsterWolf("wolf2", "狼2", 120,
            new WeaponKnife("mw2", "大刀2", -20));
    private final MonsterWolf wolf3 = new MonsterWolf("wolf3", "狼3", 100,
            new WeaponKnife("mw3", "大刀3", -25));


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
        theArray.add(wolf1);
        theArray.add(wolf2);
        theArray.add(wolf3);
    }

}
