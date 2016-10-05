package org.haritha.learning.jdbc.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.haritha.learning.dto.ItemMaster;
import org.haritha.learning.jdbc.dao.JdbcItemMasterDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
@Component
public class JdbcItemMasterDaoImpl implements JdbcItemMasterDao {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	public DataSource getDataSource() {
		return dataSource;
	}
    @Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate=new JdbcTemplate(dataSource);
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<ItemMaster> list() {
		String sql="select * from itemsmaster order by item_code";
		List<ItemMaster> list=jdbcTemplate.query(sql, new ItemMasterMapper());
		return list;
	}

	@Override
	public int add(ItemMaster item) {
			System.out.println("In Dao "+item.getItem_code());
		System.out.println(item.getItem_name());
			String sql="INSERT INTO itemsmaster(item_code,item_name,price,quantity) VALUES(nextval('hibernate_sequence'),?,?,?)";
			int result=jdbcTemplate.update(sql, new Object[]{item.getItem_name(),item.getPrice(),item.getQuantity()});
			return result;
		
	}
	
	public void insertEmployee(){
		String sql="insert into employee(id,name) values(1,'haritha')";
		jdbcTemplate.execute(sql);
	}

	@Override
	public int update(ItemMaster Item) {
		String sql = "UPDATE itemsmaster SET item_name=?, price=?, quantity=? WHERE item_code=?";
		return jdbcTemplate.update(sql, new Object[]{Item.getItem_name(),Item.getPrice(),Item.getQuantity(),Item.getItem_code()});
	}

	@Override
	public ItemMaster getItem(long id) {
		String sql = "SELECT * FROM itemsmaster WHERE item_code=?";
	    ItemMaster itemMaster= jdbcTemplate.queryForObject(sql, new Object[]{id},new ItemMasterMapper());
	    return itemMaster;
	}

	@Override
	public int delete(long id) {
		 String sql = "DELETE FROM itemsmaster WHERE item_code=?";
		    return jdbcTemplate.update(sql, id);
		
	}

	@Override
	public List<String> getDropdownlist() {
		String sql="select item_name from itemsmaster order by item_name";
		List<String> list=jdbcTemplate.queryForList(sql,String.class);;
		return list;
	}

	@Override
	public List<ItemMaster> getlistforsearch(String itemname) {
		String sql="select * from itemsmaster where item_name=?";
		return jdbcTemplate.query(sql,new Object[]{itemname},new ItemMasterMapper());
	}
	
	private static final class ItemMasterMapper implements RowMapper<ItemMaster>{

		@Override
		public ItemMaster mapRow(ResultSet resultSet, int rowNum) throws SQLException {
			ItemMaster itemMaster=new ItemMaster();
			itemMaster.setItem_code(resultSet.getLong("item_code"));
			itemMaster.setItem_name(resultSet.getString("item_name"));
			itemMaster.setPrice(resultSet.getDouble("price"));
			itemMaster.setQuantity(resultSet.getInt("quantity"));
			
			return itemMaster;
		}
		
	}

}
