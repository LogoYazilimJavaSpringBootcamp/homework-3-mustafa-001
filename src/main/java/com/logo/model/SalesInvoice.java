package com.logo.model;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;
import java.util.Optional;

@Data
@NoArgsConstructor
public class SalesInvoice {
    private long id;
    private Customer customer;
    private Address address;
    private Optional<Address> shipmentAdress;
    private LocalDateTime invoiceDate;
    private LocalDateTime deliveryDate;
    private LocalDate paymentDate;
    private String documentNumber;
    private Currency currency;
    private List<ProductOrServiceAmountPair> products = new ArrayList<>();
    private BigDecimal discountRate;
}

