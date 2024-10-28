package com.vesalukkarila.spring.data.jdbc.web;

import com.vesalukkarila.spring.data.jdbc.dto.InvoiceDto;
import com.vesalukkarila.spring.data.jdbc.model.Invoice;
import com.vesalukkarila.spring.data.jdbc.service.InvoiceService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class InvoiceController {
    private final InvoiceService invoiceService;

    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @GetMapping("/invoices")
    public List<Invoice> findAll() {
        return invoiceService.findAll();
    }

    @PostMapping("/invoices")
    public Invoice create(@RequestBody @Valid InvoiceDto invoiceDto) {
        return invoiceService.create(invoiceDto.getUserId(), invoiceDto.getAmount());
    }
}
