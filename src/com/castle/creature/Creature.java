package com.castle.creature;

import com.castle.set.WeaponSet;
import com.castle.weapon.Weapon;

/**
 * @description:
 * @author: dell
 * @date: Created in 2020/4/28 20:43
 * @version: 1.0
 * @modified By:
 */
public abstract class Creature {

    //生物的属性
    private String id;
    private String description;
    private int hpValue;
    private Weapon currentWeapon;

    //定义武器集合
    private WeaponSet weaponSet;

    //抽象类构造抽象方法
    public abstract void useArticle(Weapon weapon, Creature targetCreature);

    //构造函数及get，set方法
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getHpValue() {
        return hpValue;
    }

    public void setHpValue(int hpValue) {
        this.hpValue = hpValue;
    }

    public Weapon getCurrentWeapon() {
        return currentWeapon;
    }

    public void setCurrentWeapon(Weapon currentWeapon) {
        this.currentWeapon = currentWeapon;
    }

    public Creature() {
    }

    public Creature(String id, String description) {
        this.id = id;
        this.description = description;
    }

    public Creature(String id, String description, int hpValue) {
        this.id = id;
        this.description = description;
        this.hpValue = hpValue;
    }

    public Creature(String id, String description, int hpValue, Weapon currentWeapon) {
        this.id = id;
        this.description = description;
        this.hpValue = hpValue;
        this.currentWeapon = currentWeapon;
    }

}
