package com.receipt.processor.receipt_processor.controller;


import com.receipt.processor.receipt_processor.model.Receipt;
import com.receipt.processor.receipt_processor.service.ReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/receipts")
public class ReceiptController {

    @Autowired
    private ReceiptService receiptService;

    @PostMapping("/process")
    public Map<String, String> processReceipt(@RequestBody Receipt receipt){
        return receiptService.processReceipt(receipt);
    }

    @GetMapping("/{id}/points")
    public Map<String, Object> pointsCalc(@PathVariable String id){
        return receiptService.getPoints(id);
    }
}
