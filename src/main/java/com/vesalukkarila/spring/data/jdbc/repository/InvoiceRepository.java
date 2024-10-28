package com.vesalukkarila.spring.data.jdbc.repository;

import com.vesalukkarila.spring.data.jdbc.model.Invoice;
import org.springframework.data.repository.CrudRepository;

public interface InvoiceRepository extends CrudRepository<Invoice, String> {


}
