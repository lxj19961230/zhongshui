package com.ruoyi.common.enums.zs;


/**
 * 文档记录的状态
 *
 * new------->done
 *       ---->failed---->abandoned
 *
 * 记录先进行创建，新建完之后进行业务审计，如果通过审查，就进行存档；
 *                          如果审查不通过，记录就设置失效；
 *                   已经设置为失效的记录，如果文档序列号被其它新建记录拿走，则更改为撤档；
 */
public enum RecordState {
    NEW("新建",1),
    DONE("存档",33),
    FAILED("失效",555),
    ABANDONED("撤档",7777)
    ;
    private String state;
    private Integer code;

    RecordState(String state, Integer code){
        this.state = state;
        this.code = code;
    }

    public static RecordState valueOf(Integer code){
        if(null == code){
            throw new IllegalArgumentException("Record State's code is null.");
        }
        for(RecordState state : RecordState.values()){
            if(state.code.equals(code)){
                return state;
            }
        }
        throw new IllegalArgumentException(code + " is not in Record State.");
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
