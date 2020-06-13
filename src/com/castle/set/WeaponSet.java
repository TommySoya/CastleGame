package com.castle.set;

import com.castle.weapon.Weapon;

import java.util.ArrayList;

/**
 * @description:
 * @author: dell
 * @date: Created in 2020/5/16 20:28
 * @version: 1.0
 * @modified By:
 */
public class WeaponSet {

    //创建ArrayList集合,存储武器对象
    private final ArrayList<Weapon> weapons = new ArrayList<>();

    //CURD 记录

    //create new weapon
    public void insert(Weapon weapon) {
        weapons.add(weapon);
    }

    //search by id
    public Weapon select(String id) {
        Weapon goalWeapon = null;
        for (Weapon item : weapons
        ) {
            if (item.equals(id)) {
                goalWeapon = item;
                break;
            }
        }
        return goalWeapon;
    }

    public boolean isPresence(String id) {
        boolean goalWeapon = false;
        for (Weapon item : weapons
        ) {
            if (item.equals(id)) {
                goalWeapon = true;
                break;
            }
        }
        return goalWeapon;
    }

    //delete by id
    public void delete(String id) {
        if (select(id) != null) {
            weapons.remove(select(id));
            System.out.println("Delete successfully");
        } else {
            System.out.println("Can't find the weapon");
        }
    }

    //update damagePoint by id
    public void update(String id, int damagePoints) {
        if (select(id) != null) {
            select(id).setDamagePoints(damagePoints);
            System.out.println("Update successfully");
        } else {
            System.out.println("Can't find the weapon");
        }
    }

    // get and set
    public ArrayList<Weapon> getWeapons() {
        return weapons;
    }
}
