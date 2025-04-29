package com.example.training.price;

import com.example.training.price.dto.PriceRequest;
import com.example.training.price.dto.PriceResponse;

import java.util.List;

public interface PriceService {

    void create(PriceRequest request);

    List<PriceResponse> getAll();

    PriceResponse getById(Long id);

    void updatePrice(PriceRequest id);

    PriceResponse updatePrice(Long id, PriceRequest request);

    PriceResponse deletePriceById(Long id);

}
