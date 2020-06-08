package com.castle.set;

import com.castle.creature.Creature;
import com.castle.creature.MonsterWolf;

import java.util.ArrayList;

/**
 * @description:
 * @author: Yongliang Ding
 * @date: Created in 2020/6/7 - 9:13
 * @version: 1.0
 * @modified By:
 */
public class CreatureSet {

    public CreatureSet() {}

    private ArrayList<Creature> monsters;
    public ArrayList<Creature> getMonsters() {
        return monsters;
    }

    //CURD
    // 添加生物
    public void create(ArrayList<Creature> creatures, Creature creature) {
        creatures.add(creature);
    }

    // 根据id（String）查找对应的MonsterWolf对象
    public Creature get(ArrayList<Creature> creatures, String id) {
        Creature creature = null;
        for (Creature item:creatures
        ) {
            if (id.equals(item.getId())) {
                creature = item;
                break;
            }
        }
        return creature;
    }

    // 根据id删除对应生物
    public boolean delete(ArrayList<Creature> creatures, String id) {
        boolean flag = false;
        for (Creature item:creatures
        ) {
            if (id.equals(item.getId())) {
                creatures.remove(item);
                flag = true;
                break;
            }
        }
        return flag;
    }

    // 暂不涉及
//    public void modify(ArrayList<Creature> creatures, String id) {
//        boolean flag = false;
//        for (Creature item:creatures
//        ) {
//            if (id.equals(item.getId())) {
//                item.setThings
//                flag = true;
//                break;
//            }
//        }
//    }
}
