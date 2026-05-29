package com.eglobal.api_gateway.util;

public class Constants {

    private Constants() {}

    public static final String MSG_PAGE_SIZE_ERROR = "size must be between 1 and 100";
    public static final String DIRECTION = "ASC|DESC";
    public static final String MSG_DIRECTION_ERROR = "Invalid sort direction. Allowed values: ASC or DESC.";
    public static final String SORT = "ID|REFERENCE|OPERATION|AMOUNT|CLIENT|STATUS";
    public static final String MSG_SORT_ERROR = "Invalid sort field. Allowed values: ID, REFERENCE, OPERATION, AMOUNT, CLIENT, STATUS.";
    public static final String MSG_ERROR_FEIGN = "Error de conexión con el servicio externo";
    public static final String ERROR = "error";


}
