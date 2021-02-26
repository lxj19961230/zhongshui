package com.ruoyi.common.enums.zs;

/**
 * 逻辑删除
 *
 */
public enum LogicalDeletion {
    YES(1),//表示逻辑删除了
    NO(0)//表示有效，没有被删除
    ;
    private int value;

    LogicalDeletion(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
