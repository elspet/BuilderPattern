package com.c4po.builderpattern.models;

/**
 * 红茶
 *
 * @author Lisa
 * @date 2018/9/18
 */

public class BlackTeaModel extends TeaModel {

    @Override
    public void baking() {
        System.out.println("红茶：采摘");
    }

    @Override
    public void deterioration() {
        System.out.println("红茶：萎调");
    }

    @Override
    public void rolling() {
        System.out.println("红茶：揉捻");
    }

    @Override
    public void dry() {
        System.out.println("红茶：烘干");
    }

    @Override
    public void fermentation() {
        System.out.println("红茶：发酵");
    }

    @Override
    public void save() {
        System.out.println("红茶：保存");
    }
}
