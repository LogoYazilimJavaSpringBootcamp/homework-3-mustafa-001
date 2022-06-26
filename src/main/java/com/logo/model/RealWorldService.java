package com.logo.model;

import com.logo.model.enums.ServiceType;
import com.logo.model.enums.UnitType;
import lombok.*;

import java.math.BigDecimal;
import java.util.Currency;

@Data
public class RealWorldService extends ProductOrService {
    private String serviceCode;
}
