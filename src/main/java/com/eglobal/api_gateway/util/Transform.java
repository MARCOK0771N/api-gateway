package com.eglobal.api_gateway.util;

import com.eglobal.api_gateway.enums.SaleEnum;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.Optional;

public class Transform {

    private Transform(){}

    public static Pageable toPageable(Integer page, Integer size, String sort, String direction){
        String sortBy = Optional.ofNullable(sort).map(ValidationUtils.sortFieldValidator).map(SaleEnum::valueOf).map(SaleEnum::getFieldName).orElse(SaleEnum.ID.getFieldName());
        Sort.Direction sortDirection = Optional.ofNullable(direction).map(ValidationUtils.directionValidator).map(Sort.Direction::fromString).orElse(Sort.Direction.ASC);
        Optional.ofNullable(size).ifPresent(ValidationUtils.pageSizeValidator::apply);
        return PageRequest.of(Optional.ofNullable(page).orElse(0), Optional.ofNullable(size).orElse(10),  Sort.by(sortDirection, sortBy));
    }
}
