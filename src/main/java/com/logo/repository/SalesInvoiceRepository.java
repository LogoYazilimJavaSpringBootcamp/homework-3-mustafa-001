package com.logo.repository;

import com.logo.model.SalesInvoice;
import com.logo.model.StockTransaction;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class SalesInvoiceRepository {
   private static final List<SalesInvoice> salesInvoiceList = new ArrayList<>();
   private static int nextId = 0;

   public SalesInvoice save(SalesInvoice salesInvoice){
       salesInvoice.setId(nextId);
       nextId +=1;
      if (salesInvoice.getProducts() == null){
          salesInvoice.setProducts(new ArrayList<>());
      }
       salesInvoiceList.add(salesInvoice);
       return salesInvoice;
   }
   public Optional<SalesInvoice> findById(int id){
        return salesInvoiceList.stream().filter(it -> it.getId() == id).findFirst();
    }

    public List<SalesInvoice> getAll() {
        return salesInvoiceList;
    }

    public void  delete(SalesInvoice salesInvoice){
        salesInvoiceList.remove(salesInvoice);
    }

    public Optional<SalesInvoice> findByDocumentNumber(String documentNumber) {
       return salesInvoiceList.stream().filter(it -> it.getDocumentNumber().equals(documentNumber)).findFirst();
    }
}

