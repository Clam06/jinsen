package jinshen.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import jinshen.bean.treeprice;
import jinshen.bean.treesalary;

public interface treepriceDao {
	public int addtprice(treeprice c);
	public List<treeprice> findTprice(String sql);
	public treeprice findTreeprice(String sql);
	public boolean updateTprice(treeprice c) throws SQLException;
	
	/*
	 * public List<catUseCar> findCUCBY(int userid);
	 * 
	 * public HashMap<String,catUse> findcar(String sql);
	 */
	public List<treesalary> findtreeSalary();//木材销售货款结算单
	public treesalary printtreeSalary(double countid,double codeid);
	
} 
