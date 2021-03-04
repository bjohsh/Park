package com.Park.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Park.example.domain.Board;
import com.Park.example.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired BoardMapper boardmapper;
	
	
	public void boardinsert(Board board) {
		boardmapper.boardinsert(board);
	}
	
	public List <Board> productPage() {
		return boardmapper.productPage();
	}

	public void productEdit(Board board) {
		boardmapper.productEdit(board);
	}
	public Board productDetail(int b_idx) {
		return boardmapper.productDetail(b_idx);
	}
	public void productDelete(int b_idx) {
		boardmapper.productDelete(b_idx);
	}
	public List<Board> productMenu1() {
		return boardmapper.productMenu1();
	}
	public List<Board> productMenu2() {
		return boardmapper.productMenu2();
	}
	public List<Board> productMenu3() {
		return boardmapper.productMenu3();
	}
	public List<Board> productMenu4() {
		return boardmapper.productMenu4();
	}
}
