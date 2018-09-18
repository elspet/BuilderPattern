package com.c4po.builderpattern.director;

import com.c4po.builderpattern.AppConfigs;
import com.c4po.builderpattern.builder.BlackTeaBuilder;
import com.c4po.builderpattern.builder.WhiteTeaBuilder;
import com.c4po.builderpattern.models.BlackTeaModel;
import com.c4po.builderpattern.models.WhiteTeaModel;

import java.util.ArrayList;

/**
 * function
 * @author Lisa
 * @date 2018/9/18
 */

public class TeaMakeDirector   {

    private ArrayList<String> sequence = new ArrayList<>();
    private WhiteTeaBuilder whiteTeaBuilder = new WhiteTeaBuilder();
    private BlackTeaBuilder blackTeaBuilder = new BlackTeaBuilder();

    public WhiteTeaModel makeWhiteTea(){
        this.sequence.clear();
        this.sequence.add(AppConfigs.BAKING);
        this.sequence.add(AppConfigs.DETERIORATION);
        this.sequence.add(AppConfigs.DRY);
        this.sequence.add(AppConfigs.SAVE);
        this.whiteTeaBuilder.setSequence(this.sequence);
        return (WhiteTeaModel) this.whiteTeaBuilder.getTeaModel();
    }

    public BlackTeaModel makeBlackTea(){
        this.sequence.clear();
        this.sequence.add(AppConfigs.BAKING);
        this.sequence.add(AppConfigs.DETERIORATION);
        this.sequence.add(AppConfigs.ROLLING);
        this.sequence.add(AppConfigs.FERMENTATION);
        this.sequence.add(AppConfigs.DRY);
        this.blackTeaBuilder.setSequence(this.sequence);
        return (BlackTeaModel) this.blackTeaBuilder.getTeaModel();
    }

}
