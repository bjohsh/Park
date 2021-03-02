package com.Park.example.service;

import java.util.List;

import com.Park.example.domain.Order;

public interface OrderService {

	public void orderinsert(Order order);

	public List<Order> orderList();

	public List<Order> orderMonth();

	public List<Order> orderWeekly();

}
