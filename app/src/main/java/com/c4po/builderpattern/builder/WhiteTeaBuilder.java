package com.c4po.builderpattern.builder;

import com.c4po.builderpattern.models.TeaModel;
import com.c4po.builderpattern.models.WhiteTeaModel;

import java.util.ArrayList;

/**
 * function
 * @author Lisa
 * @date 2018/9/18
 */

public class WhiteTeaBuilder extends AbstractTeaBuilder  {

    WhiteTeaModel whiteTeaModel = new WhiteTeaModel();

    @Override
    public void setSequence(ArrayList<String> sequence) {
        this.whiteTeaModel.setSequence(sequence);
    }

    @Override
    public TeaModel getTeaModel() {
        return this.whiteTeaModel;
    }
}
