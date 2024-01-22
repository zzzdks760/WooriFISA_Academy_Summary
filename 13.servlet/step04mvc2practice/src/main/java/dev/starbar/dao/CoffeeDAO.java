package dev.starbar.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dev.starbar.model.Coffee;
import dev.starbar.util.DBUtil;

public class CoffeeDAO {
	public List<Coffee> findAll() {
		final String selectQuery = "SELECT * FROM coffee";
		List<Coffee> coffees = new ArrayList<>();

		try (Connection con = DBUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(selectQuery);
				ResultSet rs = pstmt.executeQuery();) {

			while (rs.next()) {
				final int id = rs.getInt("id");
				final String name = rs.getString("name");
				final String size = rs.getString("size");
				final int price = rs.getInt("price");

				coffees.add(new Coffee(id, name, size, price));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return coffees;
	}
}
