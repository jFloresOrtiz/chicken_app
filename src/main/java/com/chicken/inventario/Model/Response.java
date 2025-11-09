package com.chicken.inventario.Model;

import lombok.Data;

@Data
public class Response<T> {
    public T data;
}
