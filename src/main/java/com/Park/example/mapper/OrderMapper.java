package com.Park.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.Park.example.domain.Order;

@Mapper
public interface OrderMapper {

	public void orderinsert(Order order);

	public Order orderCompleted(int o_idx);

	public List<Order> orderList();

	public List<Order> orderMonth();
	
	public List<Order> orderWeekly();
}
