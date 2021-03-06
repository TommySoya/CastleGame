package com.castle.scene;

import com.castle.creature.MonsterWolf;
import com.castle.set.MonsterWolfSet;
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
public class SceneWolfForest extends Scene implements PlotMethod {

    WolfForestUi ui = WolfForestUi.getUi();

    public SceneWolfForest() {
        super.monsterSet = MonsterWolfSet.getMonsters();
        super.theArray = MonsterWolfSet.getMonsters().getMonsterWolves();
    }

    //设置场景、生物等
    private final MonsterWolf wolf1 = new MonsterWolf("rageWolf", "狂暴狼", 80,
            new WeaponFangs("mw1", "獠牙", -30));
    private final MonsterWolf wolf2 = new MonsterWolf("wolverine", "金刚狼", 120,
            new WeaponKnife("mw2", "大刀", -20));
    private final MonsterWolf wolf3 = new MonsterWolf("swiftWolf", "敏捷狼", 100,
            new WeaponDagger("mw3", "匕首", -25));


    // 初始化
    public void initSense() {
        initPerson();
        initMonster();
    }

    public void initPerson() {
        //该生物在创建时已传参
    }

    public void initMonster() {
        //该生物在创建时已传参,只将其放入集合
        theArray.add(wolf1);
        theArray.add(wolf2);
        theArray.add(wolf3);
    }

    public void plot() {
        // 战斗前夕的介绍--剧情介绍<狼群出现>
        String choice = this.choice();
        switch (choice) {
            case "y":
                ui.introWolfForest();
                break;
            case "n":
                ui.exitWolfForestToBye();
                System.exit(0);
                break;
        }

        // 战斗--<狼群的猛攻>
        choice = this.choice();
        switch (choice) {
            case "y":
                SceneWolfForest senseWolfForest = new SceneWolfForest();
                senseWolfForest.initSense();
                senseWolfForest.play();
                break;
            case "n":
                ui.exitWolfForestToBye();
                System.exit(0);
                break;
        }

        // 场景过渡--死亡判断<下一幕剧情的触发及彩蛋>
        if (this.getPerson().getHpValue() <= 0) {
            ui.exit();
            System.exit(0);
        } else {
            ui.exitWolfForest();
        }
    }

}
