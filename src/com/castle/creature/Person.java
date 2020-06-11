package com.castle.creature;

import com.castle.weapon.Weapon;
import com.castle.weapon.WeaponSword;

/**
 * @description:
 * @author: dell
 * @date: Created in 2020/4/28 20:49
 * @version:1.0
 * @modified By:
 */
public class Person extends Creature {

    //构造函数
    private Person(String id, String description, int hpValue, Weapon currentWeapon) {
        super(id, description, hpValue, currentWeapon);
    }

    private static class PersonHolder {
        private static Person person = new Person("201902202", "未知", 300,
                new WeaponSword("pw1", "破旧的铁剑", -50));
    }

    public static Person getPerson() {
        return PersonHolder.person;
    }

    @Override
    public void useArticle(Weapon weapon, Creature targetCreature) {
        weapon.useArticle(targetCreature);
    }

}
