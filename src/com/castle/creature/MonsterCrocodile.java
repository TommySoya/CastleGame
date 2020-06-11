package com.castle.creature;

import com.castle.weapon.Weapon;

/**
 * @description:
 * @author: dell
 * @date: Created in 2020/4/28 20:49
 * @version: 1.0
 * @modified By:
 */
public class MonsterCrocodile extends Creature {

    //构造函数


    public MonsterCrocodile(String id, String description, int hpValue, Weapon currentWeapon) {
        super(id, description, hpValue, currentWeapon);
    }

    @Override
    public void useArticle(Weapon weapon, Creature targetCreature) {
        weapon.useArticle(targetCreature);
    }

}
