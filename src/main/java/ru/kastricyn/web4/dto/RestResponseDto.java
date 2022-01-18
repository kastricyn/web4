package ru.kastricyn.web4.dto;

import java.io.Serializable;


public class RestResponseDto<T extends Serializable> implements Serializable {
    private boolean isOk = false; //удачно ли завершился запрос и составлен ответ, false если ошибка
    private T value;

    public RestResponseDto(boolean isOk) {
        if (isOk)
            throw new IllegalArgumentException("if isOk==null, use constructor with both arguments");
    }


    public RestResponseDto(boolean isOk, T value) {
        if (isOk && value == null)
            throw new NullPointerException("if isOk==true, second argument haven't be null");
        this.value = value;
        this.isOk = isOk;
    }
}
