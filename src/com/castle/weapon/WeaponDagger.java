package com.castle.weapon;

import com.castle.creature.Creature;

/**
 * @description:
 * @author: dell
 * @date: Created in 2020/4/28 21:00
 * @version: 1.0
 * @modified By:
 */
public class WeaponDagger extends Weapon {

    //构造函数


    public WeaponDagger(String id, String description, int damagePoints) {
        super(id, description, damagePoints);
    }

    @Override
    public void useArticle(Creature enemyCreature) {
        if (enemyCreature.getHpValue() + this.getDamagePoints() > 0) {
            enemyCreature.setHpValue(enemyCreature.getHpValue() + this.getDamagePoints());
        } else {
            enemyCreature.setHpValue(0);
        }
    }

}
