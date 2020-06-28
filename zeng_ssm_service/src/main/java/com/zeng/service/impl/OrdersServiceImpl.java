package com.zeng.service.impl;

import com.github.pagehelper.PageHelper;
import com.zeng.dao.IOrdersDao;
import com.zeng.dao.IProductDao;
import com.zeng.domain.Orders;
import com.zeng.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrdersServiceImpl implements IOrdersService {
    @Autowired
    private IOrdersDao ordersDao;

    public List<Orders> findAll(int page,int size) throws Exception {
        PageHelper.startPage(page,size);
        return ordersDao.findAll();
    }

    public Orders findById(String ordersId) {
        return ordersDao.findById(ordersId);
    }
}
