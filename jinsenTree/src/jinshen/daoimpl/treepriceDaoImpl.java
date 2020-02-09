package jinshen.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jinshen.bean.order;
import jinshen.bean.treeprice;
import jinshen.bean.treesalary;
import jinshen.dao.treepriceDao;
import jinshen.db.DBcon;

public class treepriceDaoImpl implements treepriceDao{
	private DBcon dbc=new DBcon();
	Connection connection = null;
    PreparedStatement pStatement = null;
	
	@Override
	public int addtprice(treeprice c) {
		String sql="insert into treeprice values(?,?,?,?)";
		int res=0;
		try {
			res=dbc.doUpdate(sql, new Object[] {c.getTname(),c.getTreeradius(),c.getPrice(),c.getSesson()});
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbc.close();
		}
		return res;
	}

	@Override
	public List<treeprice> findTprice(String sql) {
		List<treeprice> addrList=new ArrayList<treeprice>();
		try {
			ResultSet rs=dbc.doQuery(sql, new Object[] {});
			while(rs.next()) {
				treeprice addr=new treeprice();
				addr.setTname(rs.getString(1));
				addr.setTreeradius(rs.getDouble(2));
				addr.setPrice(rs.getDouble(3));
				addr.setSesson(rs.getDouble(4));
				addrList.add(addr);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbc.close();
		}
		return addrList;
	}

	@Override
	public treeprice findTreeprice(String sql) {
		treeprice addr=new treeprice();
		try {
			ResultSet rs=dbc.doQuery(sql, new Object[] {});
			if(rs.next()) {
				addr.setTname(rs.getString(1));
				addr.setTreeradius(rs.getDouble(2));
				addr.setPrice(rs.getDouble(3));
				addr.setSesson(rs.getDouble(4));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbc.close();
		}
		return addr;
	}

	@Override
	public boolean updateTprice(treeprice c) throws SQLException {
		int res=0;
		try {
			String sqll="update treeprice set treeradius=?,price=?,sesson=? where tname=?";
			res=dbc.doUpdate(sqll, new Object[] {c.getTreeradius(),c.getPrice(),c.getSesson(),c.getTname()});
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbc.close();
		}
		if(res>0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	//木材销售货款结算单
	@Override
	public List<treesalary> findtreeSalary()
	{
		String sql = "SELECT codepage.codeid,checkNum,cutNum,shipping,shipplace,finbuyer,getperson,countid,treetype,tlong,tradius,num,tvolume,unitprice,totalnum from codepage JOIN tree on codepage.codeid=tree.codeid";
		ResultSet rs = null;
		List<treesalary> ts= new ArrayList<treesalary>();
		try {
    		connection = DBcon.getConnection();
    		pStatement = connection.prepareStatement(sql);
    		rs = pStatement.executeQuery();
    		while (rs.next()) {
    			treesalary s=new treesalary();
    			s.setCodeid(rs.getDouble(1));
    			s.setChecknum(rs.getDouble(2));
    			s.setCutnum(rs.getDouble(3));
    			s.setShipping(rs.getString(4));
    			s.setShipplace(rs.getString(5));
    			s.setFinbuyer(rs.getString(6));
    			s.setGetperson(rs.getString(7));
    			s.setCountid(rs.getDouble(8));
    			s.setTreetype(rs.getString(9));
    			s.setTlong(rs.getDouble(10));
    			s.setTradius(rs.getDouble(11));
    			s.setNum(rs.getDouble(12));
    			s.setTvolume(rs.getDouble(13));
    			s.setUnitprice(rs.getDouble(14));
    			s.setTotalnum(rs.getDouble(15));
    			ts.add(s);
    		}
    		return ts;
    	}catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
        	DBcon.closeResultSet(rs);
        	DBcon.closePreparedStatement(pStatement);
        	DBcon.closeConnection(connection);	
       }
    }
	@Override
	public treesalary printtreeSalary(double countid,double codeid)
	{
		String sql = "SELECT codepage.codeid,checkNum,cutNum,shipping,shipplace,finbuyer,getperson,countid,treetype,tlong,tradius,num,tvolume,unitprice,totalnum from codepage JOIN tree on codepage.codeid=tree.codeid";
		ResultSet rs = null;
		treesalary d= new treesalary();
		try {
    		connection = DBcon.getConnection();
    		pStatement = connection.prepareStatement(sql);
    		rs = pStatement.executeQuery();
    		while (rs.next()) {
    			d.setCodeid(rs.getDouble(1));
    			d.setChecknum(rs.getDouble(2));
    			//System.out.println("...." +rs.getDouble(2) + "...");
    			d.setCutnum(rs.getDouble(3));
    			d.setShipping(rs.getString(4));
    			d.setShipplace(rs.getString(5));
    			d.setFinbuyer(rs.getString(6));
    			d.setGetperson(rs.getString(7));
    			System.out.println("...." +rs.getString(7) + "...");
    			d.setCountid(rs.getDouble(8));
    			d.setTreetype(rs.getString(9));
    			d.setTlong(rs.getDouble(10));
    			d.setTradius(rs.getDouble(11));
    			d.setNum(rs.getDouble(12));
    			d.setTvolume(rs.getDouble(13));
    			d.setUnitprice(rs.getDouble(14));
    			d.setTotalnum(rs.getDouble(15));
    		}
    		return d;
	}catch (Exception e) {
        e.printStackTrace();
        return null;
    } finally {
    	DBcon.closeResultSet(rs);
    	DBcon.closePreparedStatement(pStatement);
    	DBcon.closeConnection(connection);	
   }
}
	
}
