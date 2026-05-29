package com.eglobal.api_gateway.util;

import java.util.function.UnaryOperator;

import static com.eglobal.api_gateway.util.Constants.*;

public class ValidationUtils {

    private ValidationUtils(){}

    public static final UnaryOperator<String> directionValidator = ValidationUtils.regexValidator(DIRECTION, MSG_DIRECTION_ERROR);

    public static final UnaryOperator<String> sortFieldValidator = ValidationUtils.regexValidator(SORT, MSG_SORT_ERROR);

    public static final UnaryOperator<Integer> pageSizeValidator = ValidationUtils.rangeValidator(1, 100, MSG_PAGE_SIZE_ERROR);

    public static UnaryOperator<String> regexValidator(String regex, String message) {
        return value -> {
            if (value == null || !value.matches(regex)) {
                throw new IllegalArgumentException(message);
            }
            return value;
        };
    }

    public static UnaryOperator<Integer> rangeValidator(int min, int max, String message) {
        return value -> {
            if (value == null || value < min || value > max) {
                throw new IllegalArgumentException(message);
            }
            return value;
        };
    }

}
