package com.castle.utils;

/**
 * @description:
 * @author: dell
 * @date: Created in 2020/4/28 22:06
 * @version: 1.0
 * @modified By:
 */
public class Utils {

    // 以下三步实现单例
    private Utils() {};

    private static class UtilsHolder {
        private static Utils utils = new Utils();
    }

    public static Utils getUtils() {
        return UtilsHolder.utils;
    }

    //产生[min, max)之间的随机整数
    //min:0  max:2  -> 0不砍1砍
    public static int randomMonsterChop(int min, int max) {
        return (int) (Math.random()*(max - min) + min);
    }

}
