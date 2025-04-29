package com.example.training.price;


import com.example.training.price.dto.PriceRequest;
import com.example.training.price.dto.PriceResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/price")
public class PriceController {

    private final PriceService priceService;

    public PriceController(PriceService priceService) {
        this.priceService = priceService;
    }

    @PostMapping
    ResponseEntity<Void> createPice(@RequestBody PriceRequest request){
        priceService.create(request);
        return null;
    }

    @GetMapping
    ResponseEntity<List<PriceResponse>> getAllPrice() {return ResponseEntity.ok(priceService.getAll());}

    @GetMapping("{id}")
    ResponseEntity<PriceResponse> getById(@PathVariable Long id) {return ResponseEntity.ok(priceService.getById(id));}

    @PutMapping("{id}")
    ResponseEntity<Void> update(@RequestBody PriceRequest request, @PathVariable Long id){
        priceService.updatePrice(id, request);
        return null;
    }

    @DeleteMapping("{id}")
    ResponseEntity<Void> delete(@PathVariable Long id) {
        priceService.deletePriceById(id);
        return null;
    }
}
