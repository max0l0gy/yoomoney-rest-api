package ru.maxology.payments.yoomoney.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class RestResponse<T> {
    private String status;
    T data;
}
