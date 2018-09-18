package com.c4po.builderpattern.builder;

import com.c4po.builderpattern.models.BlackTeaModel;
import com.c4po.builderpattern.models.TeaModel;

import java.util.ArrayList;

/**
 * function
 * @author Lisa
 * @date 2018/9/18
 */

public class BlackTeaBuilder extends AbstractTeaBuilder   {

    BlackTeaModel blackTeaModel = new BlackTeaModel();

    @Override
    public void setSequence(ArrayList<String> sequence) {
        this.blackTeaModel.setSequence(sequence);
    }

    @Override
    public TeaModel getTeaModel() {
        return this.blackTeaModel;
    }
}
