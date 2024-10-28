package com.vesalukkarila.spring.data.jdbc.web;

import com.vesalukkarila.spring.data.jdbc.dto.InvoiceDto;
import com.vesalukkarila.spring.data.jdbc.model.Invoice;
import com.vesalukkarila.spring.data.jdbc.service.InvoiceService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InvoiceController {
    private final InvoiceService invoiceService;

    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @GetMapping("/invoices")
    public Iterable<Invoice> findAll() {
        return invoiceService.findAll();
    }

    @PostMapping("/invoices")
    public Invoice create(@RequestBody @Valid InvoiceDto invoiceDto) {
        return invoiceService.create(invoiceDto.getUserId(), invoiceDto.getAmount());
    }

    @GetMapping("/invoices/user/{userId}")
    public Iterable<Invoice> findByUserId (@PathVariable("userId") String userId){
        return invoiceService.findByUserId(userId);
    }
}
