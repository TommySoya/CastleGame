package com.castle.scene;

import com.castle.creature.MonsterDuke;
import com.castle.creature.MonsterWolf;
import com.castle.creature.Person;
import com.castle.set.MonsterDukeSet;
import com.castle.set.MonsterWolfSet;
import com.castle.ui.CastleUi;
import com.castle.ui.Ui;
import com.castle.utils.Utils;
import com.castle.weapon.WeaponKnife;

import javax.swing.plaf.DesktopIconUI;

/**
 * @description:
 * @author: dell
 * @date: Created in 2020/4/28 21:06
 * @version: 1.0
 * @modified By:
 */
public class SceneCastle extends Scene implements PlotMethod {

    CastleUi ui = CastleUi.getUi();

    public SceneCastle() {
        super.monsterSet = MonsterWolfSet.getMonsters();
        super.theArray = MonsterDukeSet.getMonsters().getMonsterDuke();
    }

    //设置场景、生物等
    private MonsterDuke duke = new MonsterDuke("duke", "公爵", 9999,
            new WeaponKnife("dukeSword", "公爵之剑", -100), "undercurrent");

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
        theArray.add(duke);
    }

    @Override
    public void promptMessage(String id) {
        if (Person.getPerson().getWeaponSet().isPresence(id) || duke.getStatus().equals("weak")) {
            System.out.println(Person.getPerson().getCurrentWeapon().getDescription() +
                    "似乎有反应了！");
        } else {
            System.out.println("父……他果然还是毫无破绽……");
        }
    }

    public void updateStatus() {
        int status = utils.randomMonsterChop(0, 10);
        int statusWeak = utils.randomMonsterChop(0, 25);
        if (statusWeak != 9) {
            switch (status) {
                case 3:
                    duke.setStatus("undercurrent"); // 暗流：该状态的公爵接近无敌
                    break;
                case 4:
                    duke.setStatus("crime"); // 天罪：似乎使用天罪可以制裁他
                    break;
                case 5:
                    duke.setStatus("ling"); // 雁翎：似乎使用雁翎可以制裁他
                    break;
                case 6:
                    duke.setStatus("shadow"); // 承影：似乎使用承影可以制裁他
                    break;
            }
        } else {
            duke.setStatus("weak"); // 公爵虚弱了，趁机击杀他！
            System.out.println("公爵虚弱了，趁机击杀他！");
        }
        promptMessage(duke.getStatus());
    }

    public void dukeLines() {
        int choice = utils.randomMonsterChop(0, 3);
        switch (choice) {
            case 0:
                System.out.println("公爵：不要做无谓的挣扎了！");
                break;
            case 1:
                System.out.println("公爵：孩子，你还不明白么？");
                break;
            case 2:
                System.out.println("公爵：真真假假，假假真真，又有谁能真的看透呢？");
                break;
        }

    }

    @Override // 重写公爵的攻击方法
    public void attackPerson(String personState) {
        // 更新公爵的状态
        updateStatus();

        if (Utils.randomMonsterChop(0, 10) == 1) {
            // 恢复生命
            System.out.println("公爵释放黑色能量包裹自身，似乎恢复了全部力量！");
            duke.setHpValue(duke.getMaxHp());
        } else {
            // 攻击
            if (personState.equals("defence")) {
                dukeLines(); // 公爵的台词（交互）
                System.out.println("公爵的攻击被你躲避了！");
            } else {
                // 怪物对人造成伤害
                duke.useArticle(duke.getCurrentWeapon(), this.getPerson());
                // 提示造成伤害信息
                System.out.println("好强的力量！我该怎么办？(器说过，要听从它的指引）");
                ui.displayDamageMsg(duke, this.getPerson());
            }
        }
    }

    @Override // 重写人的攻击方法
    public void attackMonster(String target) {
        if ((duke.getStatus().equals(person.getCurrentWeapon().getId())) ||
                (duke.getStatus().equals("weak"))) {
            if (Utils.randomMonsterChop(0, 3) == 1) {
                duke.setHpValue(0);
                System.out.println(Person.getPerson().getCurrentWeapon().getDescription() +
                        "与你产生了共鸣，器的力量全部倾泻在公爵身上，公爵被重创！");
            } else {
                // 运气不咋地，没有触发必杀
                // 人对妖怪造成伤害
                this.getPerson().useArticle(getPerson().getCurrentWeapon(),
                        this.getMonsterSet().get(theArray, target));
                // 提示伤害信息
                ui.displayDamageMsg(this.getPerson(),
                        this.monsterSet.get(theArray, target));
            }
        } else {
            // 人对妖怪造成伤害
            duke.setHpValue(duke.getHpValue() - 10);
            // 提示伤害信息
            System.out.println(getPerson().getDescription() + "对公爵造成了10点伤害");
            System.out.println("呵呵，皮肉之伤，轮到我了！");
        }
    }

    // 总体
    public void plot() {

        boolean decision;
        // 最终决战--抉择
        ui.introCastle();
        // 小机制判断
        if (this.choice().equals("y")) {
            decision = true;
        } else {
            decision = false;
        }
        ui.enterCastle();
        System.out.println("\n准备好了么？（按下回车键继续）");
        in.nextLine(); // 输入任意值继续

        // 最终之战！
        initSense();
        play();

        // 大结局
        if (decision) {
            ui.exitCastleFir();
        } else {
            ui.exitCastleSec();
        }

    }

}
