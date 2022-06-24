package com.logo.model;

import com.logo.model.enums.UnitType;

import java.math.BigDecimal;
import java.util.Currency;

public class RealWorldService {
    private long id;
    private String code;
    private String name;
    private UnitType unitType;
    //KDV(Katma Değer Vergisi)/VAT(Value Added Tax)
    private BigDecimal vatRate;
    private Currency currency;
    //without VAT
    private BigDecimal salesPrice;
    //without VAT
    private BigDecimal purchasePrice;
    //tevkifat
    private BigDecimal withholdingRatePercent;
    private boolean isActive;
    //ÖTV, ÖİV or similar other taxes.
    private BigDecimal CESSRate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UnitType getUnitType() {
        return unitType;
    }

    public void setUnitType(UnitType unitType) {
        this.unitType = unitType;
    }

    public BigDecimal getVatRate() {
        return vatRate;
    }

    public void setVatRate(BigDecimal vatRate) {
        this.vatRate = vatRate;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public BigDecimal getSalesPrice() {
        return salesPrice;
    }

    public void setSalesPrice(BigDecimal salesPrice) {
        this.salesPrice = salesPrice;
    }

    public BigDecimal getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(BigDecimal purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public BigDecimal getWithholdingRatePercent() {
        return withholdingRatePercent;
    }

    public void setWithholdingRatePercent(BigDecimal withholdingRatePercent) {
        this.withholdingRatePercent = withholdingRatePercent;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public BigDecimal getCESSRate() {
        return CESSRate;
    }

    public void setCESSRate(BigDecimal CESSRate) {
        this.CESSRate = CESSRate;
    }
}
