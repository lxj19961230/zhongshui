package com.ruoyi.common.enums.zs;

/**
 * 币种
 *
 *
 */
public enum CurrencyType {

    REN_MIN_BI("RMB","人民币"),
    DOLLAR("USD","美元"),
    YEN("JPY","日元"),
    HONG_KONG_DOLLAR("HKD","港币"),
    EURO("EUR","欧元"),
    POUND("GBP","英镑"),
    OTHER("OTHER","其他")
    ;
    private String abbreviation;

    private String description;

    CurrencyType(String abbreviation, String description){
        this.abbreviation = abbreviation;
        this.description = description;
    }

    public static CurrencyType valueOfAbbreviation(String abbreviation){
        for(CurrencyType currency : CurrencyType.values()){
            if(currency.abbreviation.equals(abbreviation)){
                return currency;
            }
        }
        throw new IllegalArgumentException(abbreviation + " is not in Currency Type.");
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
