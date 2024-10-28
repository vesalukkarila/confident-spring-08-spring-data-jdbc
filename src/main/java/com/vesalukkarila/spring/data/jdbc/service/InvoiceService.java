package com.vesalukkarila.spring.data.jdbc.service;

import com.vesalukkarila.spring.data.jdbc.model.Invoice;
import com.vesalukkarila.spring.data.jdbc.repository.InvoiceRepository;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.UUID;

@Component
public class InvoiceService {

    private InvoiceRepository invoiceRepository;
    private final String cdnUrl;

    public InvoiceService(InvoiceRepository invoiceRepository, @Value("${cdn.url}") String cdnUrl) {
        this.invoiceRepository = invoiceRepository;
        this.cdnUrl = cdnUrl;
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("Printout from invoicesService's postconstruct");
    }

    @PreDestroy
    public void shutdown() {
        System.out.println("Printout from invoiceService's predestroy");
    }

    @Transactional
    public Iterable<Invoice> findAll() {
        return invoiceRepository.findAll();
    }

    @Transactional
    public Invoice create(String userId, Integer amount) {
        String generatedPdfUrl = cdnUrl + "/images/default/sample.pdf";

        Invoice invoice = new Invoice();
        invoice.setPdfUrl(generatedPdfUrl);
        invoice.setAmount(amount);
        invoice.setUserId(userId);
        return invoiceRepository.save(invoice);
    }

}
