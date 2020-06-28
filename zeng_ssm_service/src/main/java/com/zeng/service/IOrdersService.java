package com.zeng.service;

import com.zeng.domain.Orders;

import java.util.List;

public interface IOrdersService {
    List<Orders> findAll(int page,int size) throws Exception;

    Orders findById(String ordersId);
}
