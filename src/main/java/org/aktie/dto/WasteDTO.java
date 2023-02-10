package org.aktie.dto;

import java.math.BigDecimal;

import org.aktie.entities.enums.EnumWasteType;

public class WasteDTO {
    
    private Integer id;

    private Integer sizeLimit;

    private EnumWasteType wasteType;

    private BigDecimal amount;

    private Integer wasteQuantity;

    private BigDecimal tonMonth;

    private boolean payTo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSizeLimit() {
        return sizeLimit;
    }

    public void setSizeLimit(Integer sizeLimit) {
        this.sizeLimit = sizeLimit;
    }

    public EnumWasteType getWasteType() {
        return wasteType;
    }

    public void setWasteType(EnumWasteType wasteType) {
        this.wasteType = wasteType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public boolean isPayTo() {
        return payTo;
    }

    public void setPayTo(boolean payTo) {
        this.payTo = payTo;
    }

    public Integer getWasteQuantity() {
        return wasteQuantity;
    }

    public void setWasteQuantity(Integer wasteQuantity) {
        this.wasteQuantity = wasteQuantity;
    }

    public BigDecimal getTonMonth() {
        return tonMonth;
    }

    public void setTonMonth(BigDecimal tonMonth) {
        this.tonMonth = tonMonth;
    }

}
