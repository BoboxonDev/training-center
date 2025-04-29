package com.example.training.price;

import com.example.training.group.dto.GroupResponse;
import com.example.training.price.dto.PriceRequest;
import com.example.training.price.dto.PriceResponse;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class PriceServiceImpl implements PriceService{

    private final PriceRepository priceRepository;
    private final PriceMapper priceMapper;
    public PriceServiceImpl(PriceRepository priceRepository, PriceMapper priceMapper) {
        this.priceRepository = priceRepository;
        this.priceMapper = priceMapper;
    }

    @Override
    public void create(PriceRequest request) {

        var price = priceMapper.toEntity(request);
        price.setCreatedAt(LocalDateTime.now());
        price.setUpdatedAt(LocalDateTime.now());
        priceRepository.save(price);
    }

    @Override
    public List<PriceResponse> getAll() {
        var prices = priceRepository.findAllByDeletedAtIsNull();
        List<PriceResponse> list = new ArrayList<>();

        prices.forEach(price -> {
            var dto = priceMapper.toDto(price);

            dto.setGroupId(price.getGroup().getId());
            var p = new GroupResponse();
            p.setId(price.getGroup().getId());
            p.setGroupName(price.getGroup().getGroupName());
            dto.setGroupResponse(p);

            list.add(dto);
        });
        return list;
    }

    @Override
    public PriceResponse getById(Long id) {
        var entity = priceRepository.findById(id).orElseThrow();
        var dto = priceMapper.toDto(entity);
        return dto;
    }

    @Override
    public void updatePrice(PriceRequest id) {

    }

    @Override
    public PriceResponse updatePrice(Long id, PriceRequest request) {
        var entity = priceRepository.findById(id).orElseThrow();
        entity.setAmount(request.getAmount());

        var updateEntity = priceRepository.save(entity);

        var dto = priceMapper.toDto(updateEntity);
        return dto;
    }

    @Override
    public PriceResponse deletePriceById(Long id) {
        var entity = priceRepository.findById(id).orElseThrow();
        entity.setDeletedAt(LocalDateTime.now());
        var dto = priceMapper.toDto(entity);
        priceRepository.save(entity);
        return dto;
    }
}
