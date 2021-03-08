package com.Park.example.service;

import java.util.List;

import com.Park.example.domain.Board;
import com.Park.example.domain.Product;

public interface BoardService {

	public void boardinsert(Board board);

	public List<Board> productPage();

	public void productEdit(Board board);

	public Board productDetail(int b_idx);

	public void productDelete(int b_idx);

	public List<Board> productMenu1(int p_idx);


	}

