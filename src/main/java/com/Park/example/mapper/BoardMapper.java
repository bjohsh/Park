package com.Park.example.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.Park.example.domain.Board;
import java.util.List;
@Mapper
public interface BoardMapper {

	public void boardinsert(Board board);

	public List<Board> productPage();

	public void productEdit(Board board);

	public Board productDetail(int b_idx);

	public void productDelete(int b_idx);

	public List<Board> productMenu1(int p_idx);
	
}


