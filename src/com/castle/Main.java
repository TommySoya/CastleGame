package com.castle;

import com.castle.creature.Person;
import com.castle.scene.Scene;
import com.castle.scene.SceneBranchRoad;
import com.castle.scene.SceneCrocodileSwamp;
import com.castle.scene.SceneWolfForest;
import com.castle.ui.Ui;
import com.castle.weapon.WeaponDagger;
import com.castle.weapon.WeaponSword;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // 创建一些对象(工具人）
        Ui ui = new Ui();
        Scanner in = new Scanner(System.in);
        Scene initScene = new Scene();

        // 正片开始
        ui.intro();

        // 场景一--<森林>
        SceneWolfForest sceneWolfForest = new SceneWolfForest();
        sceneWolfForest.plot();


        // 场景二--<沼泽>
        SceneCrocodileSwamp sceneCrocodileSwamp = new SceneCrocodileSwamp();
        sceneCrocodileSwamp.plot();


        // 场景三--<歧路>
        SceneBranchRoad sceneBranchRoad = new SceneBranchRoad();
        sceneBranchRoad.plot();

        // 场景四--<城堡>

    }
}
