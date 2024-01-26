package dev.starbar.dao;

import java.util.List;

import dev.starbar.model.Coffee;

public class CoffeeDAO {
	
	/**
	 * 전체 커피 메뉴 조회
	 */
	public List<Coffee> findAll() {
		return null;
	}
	
	/**
	 * 커피 메뉴 등록
	 */
	public boolean save(String name, String size, int price) {
		return false;
	}
	
	/**
	 * 커피 메뉴 수정
	 */
	public boolean update(int id, String name, String size, int price) {
		return false;
	}
	
	/**
	 * 커피 메뉴 제거
	 */
	public boolean deleteById(int id) {
		return false;
	}
	
}