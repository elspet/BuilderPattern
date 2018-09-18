package com.c4po.builderpattern;

import com.c4po.builderpattern.director.TeaMakeDirector;

/**
 * 客户提需求，两份红茶，三份白茶
 * @author Lisa
 * @date 2018/9/18
 */

public class Client   {

    public static void main(String[] args){
        int blackNum = 2;
        int whiteNum = 3;
        TeaMakeDirector teaMaker = new TeaMakeDirector();

        for (int i=0;i<blackNum;i++){
            System.out.println("-----制作红茶-----");
            teaMaker.makeBlackTea().make();
        }
        System.out.println("-------------------------");
        for (int i=0;i<whiteNum;i++){
            System.out.println("-----制作白茶-----");
            teaMaker.makeWhiteTea().make();
        }
    }
}
