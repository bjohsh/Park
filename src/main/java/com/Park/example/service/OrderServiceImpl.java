package com.Park.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Park.example.domain.Order;
import com.Park.example.mapper.OrderMapper;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired OrderMapper ordermapper;

	@Override
	public void orderinsert(Order order) {
		ordermapper.orderinsert(order);
	}
	
	@Override
	public List <Order> orderList() {
		return ordermapper.orderList();
	}
	
	@Override
	public List <Order> orderMonth() {
		return ordermapper.orderMonth();
	}
	
	@Override
	public List <Order> orderWeekly() {
		return ordermapper.orderWeekly();
	}
}
