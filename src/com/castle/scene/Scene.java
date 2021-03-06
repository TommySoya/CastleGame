package com.castle.scene;

import com.castle.creature.Creature;
import com.castle.creature.Person;
import com.castle.set.CreatureSet;
import com.castle.set.MonsterWolfSet;
import com.castle.ui.Ui;
import com.castle.utils.Utils;
import com.castle.weapon.Weapon;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @description:
 * @author: dell
 * @date: Created in 2020/4/28 21:06
 * @version: 1.0
 * @modified By:
 */
public class Scene {

    //设置场景、生物等
    protected Person person = Person.getPerson();
    protected CreatureSet monsterSet;
    protected final Scanner in = new Scanner(System.in);
    protected final Utils utils = Utils.getUtils();
    protected Ui ui = new Ui();
    protected ArrayList<Creature> theArray;


    //初始化
    public void initSense() {
        initPerson();
        initMonster();
    }

    public void initPerson() {
        //该生物在创建时已传参
    }

    public void initMonster() {
        //该生物在创建时已传参,只将其放入集合
    }


    // 命令判断
    public String choice() {
        String choice;
        do {
            choice = in.nextLine();
            if (choice.equals("y") || choice.equals("Y")) {
                break;
            } else if (choice.equals("n") || choice.equals("N")) {
                break;
            } else {
                System.out.println("请输入正确的指令！");
            }
        } while (true);
        return choice.toLowerCase();
    }

    // 判断攻击目标是否存在
    public boolean isPresence(String id) {
        boolean flag = false;
        for (Creature item:theArray
             ) {
            if (id.equals(item.getId())) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    // 人的回合--攻击
    public void attackMonster(String target) {
        // 人对妖怪造成伤害
        this.getPerson().useArticle(getPerson().getCurrentWeapon(),
                this.getMonsterSet().get(theArray, target));
        //提示伤害信息
        ui.displayDamageMsg(this.getPerson(),
                this.monsterSet.get(theArray, target));
    }

    // 战斗前的交互区域（提示信息，待重写）
    public void promptMessage(String id) {

    }

    // 妖怪的回合--攻击
    public void attackPerson(String personState) {
        for (Creature item:theArray
        ) {
            if (personState.equals("defence")) {
                if (1 == Utils.randomMonsterChop(0, 2)) {
                    //怪物对人造成伤害
                    System.out.println(item.getDescription() + "发动了攻击，但被躲避了！");
                }
            } else {
                if (1 == Utils.randomMonsterChop(0, 2)) {
                    //怪物对人造成伤害
                    item.useArticle(item.getCurrentWeapon(), this.getPerson());
                    //提示造成伤害信息
                    ui.displayDamageMsg(item, this.getPerson());
                }
            }
        }
    }

    // 判断是否死亡
    public void checkIsDead(String target) {
        if (this.getMonsterSet().get(theArray, target).getHpValue() <= 0) {
            boolean flag = false;
            String enemyName = this.getMonsterSet().get(theArray, target).getDescription();
            flag = this.getMonsterSet().delete(theArray, this.getMonsterSet().get(theArray, target).getId());
            if (flag) {
                ui.displayRemoveCreature(enemyName);
            }
        }
    }

    // 胜利判断
    public boolean judgeSuccess(CreatureSet monsterSet) {
        boolean flagPersonSuccess = false;
        if (theArray.size() == 0) {
            flagPersonSuccess = true;
        }
        return flagPersonSuccess;
    }

    //游戏玩法
    public void play() {

        //显示当前状态
        ui.displayBegin();
        ui.displayStatus(this);
        //进入循环
        while (true) {
            //提示用户输入指令
            ui.displayCmdMsg();
            //用户输入指令
            String command = in.nextLine();
            //split分割单元
            String[] cmdLineItems = command.split(" ");

            //判断命令内容，做出相应交互
            if (cmdLineItems[0].equals("bye")) {
                ui.displayBye();
                System.exit(0);
            } else if (cmdLineItems[0].equals("switch")) {
                if (cmdLineItems.length == 2) {
                    // 判断武器是否存在
                    if (getPerson().getWeaponSet().isPresence(cmdLineItems[1])) {
                        getPerson().setCurrentWeapon(getPerson().getWeaponSet().select(cmdLineItems[1]));
                        System.out.println("--------------------\n切换成功");
                        ui.displayPersonStatus();
                    } else {
                        System.out.print("该武器不存在，请输入正确的武器id\n" +
                                "你现在拥有：");
                        for (Weapon item:getPerson().getWeaponSet().getWeapons()
                        ) {
                            System.out.print(item.getDescription() + ":<" + item.getId() + "> ");
                        }
                        System.out.println();
                    }
                } else {
                    System.out.println("输入指令错误！请输入要切换的武器（e.g. switch targetWeapon)");
                }
                continue;
            } else if (cmdLineItems[0].equals("help")) {
                ui.displayHelpMsg();
                continue;
            } else if (cmdLineItems[0].equals("chop") || cmdLineItems[0].equals("defence")) {
                if (cmdLineItems.length == 2) {
                    // 判断攻击目标是否有效
                    if (isPresence(cmdLineItems[1])) {
                        // 人攻击
                        this.attackMonster(cmdLineItems[1]);
                        // 判断攻击目标是否死亡
                        this.checkIsDead(cmdLineItems[1]);
                    } else {
                        monsterSet.outputId(theArray);
                        continue;
                    }
                } else if (cmdLineItems[0].equals("defence")) {
                    System.out.println(person.getDescription() + "进入了防御姿态！(生命值得到了少量恢复)");
                    Person.getPerson().setHpValue((int) (Person.getPerson().getHpValue() * 1.1));
                } else {
                    System.out.println("输入指令错误！请输入要攻击的目标（e.g. switch targetCreature)");
                    continue;
                }
            } else {
                ui.displayErrorCmdMsg();
                continue;
            }

            // 判断是否胜利
            if (judgeSuccess(this.getMonsterSet())) {
                ui.displayVictory();
                break;
            }

            //妖怪进行随机判断攻击
            this.attackPerson(cmdLineItems[0]);

            // 判断是否失败
            if (getPerson().getHpValue() <= 0) {
                ui.displayRemoveCreature(getPerson().getDescription());
                ui.displayDefeat();
                break;
            }

            //显示当前状态
            ui.displayStatus(this);
        }
    }

    //构造函数及get，set方法
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public CreatureSet getMonsterSet() {
        return monsterSet;
    }

    public void setMonsterSet(MonsterWolfSet monsterWolfSet) {
        this.monsterSet = monsterWolfSet;
    }

    public ArrayList<Creature> getTheArray() {
        return theArray;
    }

    public void setTheArray(ArrayList<Creature> theArray) {
        this.theArray = theArray;
    }
}
