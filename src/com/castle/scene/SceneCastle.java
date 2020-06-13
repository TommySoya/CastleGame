package com.castle.scene;

import com.castle.creature.MonsterDuke;
import com.castle.creature.MonsterWolf;
import com.castle.set.MonsterDukeSet;
import com.castle.set.MonsterWolfSet;
import com.castle.weapon.WeaponKnife;

/**
 * @description:
 * @author: dell
 * @date: Created in 2020/4/28 21:06
 * @version: 1.0
 * @modified By:
 */
public class SceneCastle extends Scene implements PlotMethod {

    public SceneCastle() {
        super.monsterSet = MonsterWolfSet.getMonsters();
        super.theArray = MonsterDukeSet.getMonsters().getMonsterDuke();
    }

    //设置场景、生物等
    private final MonsterDuke duke = new MonsterDuke("duke", "公爵", 9999,
            new WeaponKnife("dukeSword", "公爵之剑", -100));


    // 初始化
    public void initSense() {
        initPerson();
        initMonser();
    }

    public void initPerson() {
        //该生物在创建时已传参
    }

    public void initMonser() {
        //该生物在创建时已传参,只将其放入集合
        theArray.add(duke);
    }

    // 总体
    public void plot() {

    }

}
