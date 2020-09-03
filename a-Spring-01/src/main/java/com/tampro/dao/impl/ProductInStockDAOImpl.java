package com.tampro.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tampro.dao.ProductInStockDAO;
import com.tampro.entity.ProductsInStock;

@Repository
@Transactional(rollbackFor = Exception.class)
public class ProductInStockDAOImpl extends BaseDAOImpl<ProductsInStock> implements ProductInStockDAO<ProductsInStock>  {

}
