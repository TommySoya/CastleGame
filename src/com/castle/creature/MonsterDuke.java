package com.castle.creature;

import com.castle.weapon.Weapon;

/**
 * @description:
 * @author: dell
 * @date: Created in 2020/4/28 20:49
 * @version: 1.0
 * @modified By:
 */
public class MonsterDuke extends Creature {

    //构造函数


    public MonsterDuke(String id, String description, int hpValue, Weapon currentWeapon) {
        super(id, description, hpValue, currentWeapon);
        super.setMaxHp(hpValue);
    }

    public MonsterDuke(String id, String description, int hpValue, Weapon currentWeapon, String status) {
        super(id, description, hpValue, currentWeapon, status);
        super.setMaxHp(hpValue);
    }

    @Override
    public void useArticle(Weapon weapon, Creature targetCreature) {
        weapon.useArticle(targetCreature);
    }

}
