package com.castle;

import com.castle.creature.Person;
import com.castle.scene.*;
import com.castle.ui.Ui;
import com.castle.weapon.WeaponDagger;
import com.castle.weapon.WeaponSword;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // 创建对象
        Ui ui = new Ui();
        Scanner in = new Scanner(System.in);
        SceneWolfForest sceneWolfForest = new SceneWolfForest();
        SceneCrocodileSwamp sceneCrocodileSwamp = new SceneCrocodileSwamp();
        SceneBranchRoad sceneBranchRoad = new SceneBranchRoad();
        SceneCastle sceneCastle = new SceneCastle();

        // 正片开始
        ui.intro();

        // 场景一--<森林>
        sceneWolfForest.plot();

        // 场景二--<沼泽>
        sceneCrocodileSwamp.plot();

        // 场景三--<歧路>
        sceneBranchRoad.plot();

        // 场景四--<城堡>
        sceneCastle.plot();

    }
}
