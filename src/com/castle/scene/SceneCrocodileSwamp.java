package com.castle.scene;

import com.castle.creature.MonsterWolf;
import com.castle.set.MonsterCrocodileSet;
import com.castle.set.MonsterWolfSet;
import com.castle.weapon.WeaponFangs;
import com.castle.weapon.WeaponKnife;

/**
 * @description:
 * @author: dell
 * @date: Created in 2020/4/28 21:06
 * @version: 1.0
 * @modified By:
 */
public class SceneCrocodileSwamp extends Scene {

    public SceneCrocodileSwamp() {
        super.monsterSet = MonsterCrocodileSet.getMonsters();
        super.theArray = MonsterCrocodileSet.getMonsters().getMonsterCrocodiles();
    }

    //设置场景、生物等
    private final MonsterWolf wolf1 = new MonsterWolf("crocodile", "巨鳄", 300,
            new WeaponFangs("ly1", "獠牙", -100));


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
    }

}
