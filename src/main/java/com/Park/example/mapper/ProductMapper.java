package com.Park.example.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import com.Park.example.domain.Product;

@Mapper
public interface ProductMapper {

	public List<Product> productCategory();
	}
	


