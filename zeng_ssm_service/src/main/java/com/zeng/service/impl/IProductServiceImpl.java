package com.zeng.service.impl;

import com.zeng.service.IProductService;
import com.zeng.dao.IProductDao;
import com.zeng.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class IProductServiceImpl implements IProductService {
    @Autowired
    private IProductDao productDao;

    public List<Product> findAll() throws Exception {
        return productDao.findAll();
    }

    public void save(Product product) {
        productDao.save(product);
    }
}
