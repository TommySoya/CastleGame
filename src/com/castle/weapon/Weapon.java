package com.castle.weapon;

import com.castle.creature.Creature;

/**
 * @description:
 * @author: dell
 * @date: Created in 2020/4/28 20:48
 * @version:
 * @modified By:
 */
public abstract class Weapon {

    //武器的属性
    private String id;
    private String description;
    private int damagePoints;

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

    public int getDamagePoints() {
        return damagePoints;
    }

    public void setDamagePoints(int damagePoints) {
        this.damagePoints = damagePoints;
    }

    public Weapon(String id, String description, int damagePoints) {
        this.id = id;
        this.description = description;
        this.damagePoints = damagePoints;
    }

    public Weapon(String id, String description) {
        this.id = id;
        this.description = description;
    }

    public Weapon() {
    }

    //使用方法
    public abstract void useArticle(Creature enemyCreature);

}
