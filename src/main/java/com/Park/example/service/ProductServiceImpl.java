package com.Park.example.service;

import com.Park.example.domain.Product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Park.example.domain.Product;
import com.Park.example.mapper.ProductMapper;

@Service
public class ProductServiceImpl  implements ProductService {

	@Autowired ProductMapper productmapper;
	
	public List <Product> productCategory() {
		return productmapper.productCategory();
	}

}

