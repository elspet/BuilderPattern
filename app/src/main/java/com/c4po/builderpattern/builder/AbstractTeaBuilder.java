package com.c4po.builderpattern.builder;

import com.c4po.builderpattern.models.TeaModel;

import java.util.ArrayList;

/**
 * function
 * @author Lisa
 * @date 2018/9/18
 */

public abstract class AbstractTeaBuilder   {

    /**
     * 设置序列号
     * @param sequence
     */
    public abstract void setSequence(ArrayList<String> sequence);

    /**
     * 获取茶叶
     * @return
     */
    public abstract TeaModel getTeaModel();
}
