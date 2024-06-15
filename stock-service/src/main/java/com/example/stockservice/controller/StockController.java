package com.example.stockservice.controller;

import com.example.stockservice.model.Stock;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/stocks")
public class StockController {

    @GetMapping("/{stockId}")
    public Stock getStock(@PathVariable String stockId) {
        // 返回库存信息
        return new Stock(stockId, "productId", 100);
    }

    @PostMapping
    public Stock createStock(@RequestBody Stock stock) {
        // 创建库存记录
        return stock;
    }

    @PutMapping("/{stockId}")
    public Stock updateStock(@PathVariable String stockId, @RequestBody Stock stock) {
        // 更新库存记录
        return stock;
    }
}
