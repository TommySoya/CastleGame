package com.castle.creature;

import com.castle.set.WeaponSet;
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

    private int maxHp = 300; // 血量最大值上限

    // 武器集合
    private WeaponSet weaponSet = new WeaponSet();

    // 构造函数
    private Person(String id, String description, int hpValue, Weapon currentWeapon) {
        super(id, description, hpValue, currentWeapon);
        this.getWeaponSet().getWeapons().add(this.getCurrentWeapon());
    }

    private static class PersonHolder {
        private static Person person = new Person("My", "未知", 300,
                new WeaponSword("pw1", "破旧的铁剑", -50));
    }

    public static Person getPerson() {
        return PersonHolder.person;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public WeaponSet getWeaponSet() {
        return weaponSet;
    }

    public void setWeaponSet(WeaponSet weaponSet) {
        this.weaponSet = weaponSet;
    }

    @Override
    public void useArticle(Weapon weapon, Creature targetCreature) {
        weapon.useArticle(targetCreature);
    }

}
