package com.castle.scene;

import com.castle.creature.MonsterWolf;
import com.castle.creature.Person;
import com.castle.set.MonsterCrocodileSet;
import com.castle.set.MonsterWolfSet;
import com.castle.ui.BranchRoadUi;
import com.castle.ui.CrocodileSwampUi;
import com.castle.ui.WolfForestUi;
import com.castle.weapon.WeaponDagger;
import com.castle.weapon.WeaponFangs;
import com.castle.weapon.WeaponKnife;

/**
 * @description:
 * @author: dell
 * @date: Created in 2020/4/28 21:06
 * @version: 1.0
 * @modified By:
 */
public class SceneCrocodileSwamp extends Scene implements PlotMethod {

    CrocodileSwampUi ui = CrocodileSwampUi.getUi();

    public SceneCrocodileSwamp() {
        super.monsterSet = MonsterCrocodileSet.getMonsters();
        super.theArray = MonsterCrocodileSet.getMonsters().getMonsterCrocodiles();
    }

    //设置场景、生物等
    private final MonsterWolf wolf1 = new MonsterWolf("crocodile", "巨鳄", 300,
            new WeaponFangs("tooth", "獠牙", -100));


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

    // 彩蛋
    public void easterEggs() {
        System.out.println("是一把武器……（为什么这么熟悉）" +
                "\n要捡起它吗？（y/n）");
        if (this.choice().equals("y")) {
            Person.getPerson().setCurrentWeapon(new WeaponDagger("bs", "静谧之刃", -100));
            ui.displayPersonStatus();
        }
    }

    // 总体
    public void plot() {
        ui.introCrocodileSwampFir();
        // 开始前--<彩蛋之捡起武器>
        if (this.choice().equals("y")) {
            System.out.println("是一把武器……（为什么这么熟悉）");
            Person.getPerson().setCurrentWeapon(new WeaponDagger("quiet", "静谧之刃", -100));
            ui.displayPersonStatus();
            // 战斗--<巨鳄突袭>
            ui.introCrocodileSwampSec();
            SceneCrocodileSwamp sceneCrocodileSwamp = new SceneCrocodileSwamp();
            sceneCrocodileSwamp.initSense();
            sceneCrocodileSwamp.play();
        } else {
            ui.exitCrocodileSwampToBye();
            System.exit(0);
        }

        // 场景过渡--死亡判断<下一幕剧情的触发及彩蛋>
        if (this.getPerson().getHpValue() <= 0) {
            ui.exit();
            System.exit(0);
        } else {
            Person.getPerson().setMaxHp(500);
            Person.getPerson().setHpValue(Person.getPerson().getMaxHp());
            ui.exitCrocodileSwamp();
            ui.displayPersonStatus();
        }
    }

}
