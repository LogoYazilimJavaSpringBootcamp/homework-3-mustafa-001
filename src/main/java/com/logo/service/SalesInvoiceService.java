package com.logo.service;

import com.logo.model.SalesInvoice;
import com.logo.repository.SalesInvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalesInvoiceService {
    @Autowired
    private SalesInvoiceRepository salesInvoiceRepository;

    public SalesInvoice create(SalesInvoice request) {
        return salesInvoiceRepository.save(request);
    }

    public List<SalesInvoice> getAllTransactions() {
        return salesInvoiceRepository.getAll();
    }

    public Optional<SalesInvoice> getSalesInvoiceByDocumentNumber(String documentNumber) {
        return salesInvoiceRepository.findByDocumentNumber(documentNumber);
    }

    public Optional<SalesInvoice> getSalesInvoiceById(int id) {
        return salesInvoiceRepository.findById(id);
    }

    public SalesInvoice update(int id, SalesInvoice salesInvoice) {
        System.out.println("Updating salesInvoice: " + id + "  to " + salesInvoice.toString());
        var oldInvoiceOpt = salesInvoiceRepository.findById(id);
        if (oldInvoiceOpt.isEmpty()) {
            throw new IllegalArgumentException();
        }
        var oldInvoice = oldInvoiceOpt.get();
        if (salesInvoice.getDocumentNumber() != null) oldInvoice.setDocumentNumber(salesInvoice.getDocumentNumber());
        if (salesInvoice.getInvoiceDate() != null) oldInvoice.setInvoiceDate(salesInvoice.getInvoiceDate());
        if (salesInvoice.getAddress() != null) oldInvoice.setAddress(salesInvoice.getAddress());
        if (salesInvoice.getCustomer() != null) oldInvoice.setCustomer(salesInvoice.getCustomer());
        if (salesInvoice.getCurrency() != null) oldInvoice.setCurrency(salesInvoice.getCurrency());
        if (salesInvoice.getDeliveryDate() != null) oldInvoice.setDeliveryDate(salesInvoice.getDeliveryDate());
        if (salesInvoice.getPaymentDate() != null) oldInvoice.setPaymentDate(salesInvoice.getPaymentDate());
        if (salesInvoice.getDiscountRate() != null) oldInvoice.setDiscountRate(salesInvoice.getDiscountRate());
        if (salesInvoice.getShipmentAdress().isPresent()) oldInvoice.setShipmentAdress(salesInvoice.getShipmentAdress());
        return oldInvoice;
    }

    public void delete(int id) {
        System.out.println("Deleting salesInvoice: " + id);
        var invoiceOpt = salesInvoiceRepository.findById(id);
        if (invoiceOpt.isEmpty()) {
            throw new IllegalArgumentException();
        }
        salesInvoiceRepository.delete(invoiceOpt.get());
    }

}
