package com.c4po.builderpattern.models;

import com.c4po.builderpattern.AppConfigs;

import java.util.ArrayList;

/**
 * function
 *
 * @author Lisa
 */

public abstract class TeaModel {


    /**
     * 采摘
     */
    public abstract void baking();

    /**
     * 萎调
     */
    public abstract void deterioration();

    /**
     * 揉捻
     */
    public abstract void rolling();

    /**
     * 烘干
     */
    public abstract void dry();

    /**
     * 发酵
     */
    public abstract void fermentation();

    /**
     * 保存
     */
    public abstract void save();

    private ArrayList<String> sequence = new ArrayList<>();

    final public void setSequence(ArrayList<String> sequence) {
        this.sequence = sequence;
    }

    final public void make() {
        for (int i = 0; i < sequence.size(); i++) {
            String action = this.sequence.get(i);
            switch (action) {
                case AppConfigs.BAKING:
                    this.baking();
                    break;
                case AppConfigs.DETERIORATION:
                    this.deterioration();
                    break;
                case AppConfigs.DRY:
                    this.dry();
                    break;
                case AppConfigs.FERMENTATION:
                    this.fermentation();
                    break;
                case AppConfigs.ROLLING:
                    this.rolling();
                    break;
                case AppConfigs.SAVE:
                    this.save();
                    break;
                default:
                    System.out.println("未知操作");
                    break;
            }
        }
    }
}
