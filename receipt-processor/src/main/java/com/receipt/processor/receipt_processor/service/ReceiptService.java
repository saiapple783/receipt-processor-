package com.receipt.processor.receipt_processor.service;

import com.receipt.processor.receipt_processor.model.Item;
import com.receipt.processor.receipt_processor.model.Receipt;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class ReceiptService {
    private final Map<String, Receipt> receiptStorage = new HashMap<>();


    public Map<String, String> processReceipt(Receipt receipt) {
        String id = UUID.randomUUID().toString();
        receiptStorage.put(id,receipt);
        return Map.of("id",id);
    }

    public Map<String, Object> getPoints(String id) {
        Receipt receipt= receiptStorage.get(id);
        if(receipt==null){
            return Map.of("Error","Receipt not found");
        }
        return Map.of("points",calculatePoints(receipt));
    }

    private int calculatePoints(Receipt receipt) {
        int points = receipt.getRetailer().replaceAll("[^a-zA-Z0-9]","").length();
        System.out.println(points);
        double total = Double.parseDouble(receipt.getTotal());
        if(total%1==0){
            points+=50;
        }
        if(total%0.25==0){
            points+=25;
        }

        points += (receipt.getItems().size() / 2) * 5;

        for(Item item : receipt.getItems() ){
            String shrtDescription = item.getShortDescription().trim();
            if(shrtDescription.length()%3==0){
                double price = Double.parseDouble(item.getPrice());
                points+=Math.ceil(price * 0.2);
            }
        }

        LocalDate purchaseDate = LocalDate.parse(receipt.getPurchaseDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        if (purchaseDate.getDayOfMonth() % 2 != 0){
            points+=6;
        }

        LocalTime purchaseTime = LocalTime.parse(receipt.getPurchaseTime(), DateTimeFormatter.ofPattern("HH:mm"));
        if(purchaseTime.isAfter(LocalTime.of(14, 0)) && purchaseTime.isBefore(LocalTime.of(16, 0))){
            points+=10;
        }
        return points;


    }
}
