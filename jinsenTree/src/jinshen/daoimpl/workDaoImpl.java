package jinshen.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jinshen.bean.order;
import jinshen.bean.treeLaowu;
import jinshen.bean.work;
import jinshen.bean.worktree;
import jinshen.dao.workDao;
import jinshen.db.DBcon;

public class workDaoImpl implements workDao {

	private DBcon dbc=new DBcon();
	Connection connection = null;
    PreparedStatement pStatement = null;
	@Override
	public int addWork(work cp) {
		String sql="insert into work values(?,?,?,?)";
		int res=0;
		try {
			res=dbc.doUpdate(sql, new Object[] {});
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbc.close();
		}
		return res;
	}
	
	@Override
	public int addWork(String sql)
	{
		int res=0;
		try {
			res=dbc.doUpdate(sql, new Object[] {});
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbc.close();
		}
		return res;
	}

	@Override
	public int updateWork(work cp) {
		int res=0;
		try {
			String sql="update order set shipping=?,shipplace=?,finbuyer=? where countid=?";
			res=dbc.doUpdate(sql, new Object[] {});
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbc.close();
		}
		return res;
	}

	@Override
	public List<work> findWork(String sql) {
		List<order> addrList=new ArrayList<order>();
		try {
			ResultSet rs=dbc.doQuery(sql, new Object[] {});
			while(rs.next()) {
				order addr=new order();
				addr.setCountid(rs.getDouble(1));
				addrList.add(addr);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbc.close();
		}
		return null;
	}

	@Override
	public int delWork(String sql) {
		int res=0;
		try {
			res=dbc.doUpdate(sql, new Object[] {});
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbc.close();
		}
		return res;
	}

	@Override
	public int findMaxid(String sql) {
		int num=0;
		try {
			ResultSet rs=dbc.doQuery(sql,new Object[]{});
			if(rs.next()) {
				num=rs.getInt(1);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return num;
	}
	
	@Override
	public work findWorkSingle(String sql)
	{
		work addr=new work();
		try {
			ResultSet rs=dbc.doQuery(sql, new Object[] {});
			if(rs.next()) {
				addr.setWorkid(rs.getDouble(1));
				addr.setCheckNum(rs.getDouble(2));
				addr.setCutNum(rs.getDouble(3));
				addr.setForperson(rs.getString(4));
				addr.setManageUnit(rs.getString(5));
			}
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			dbc.close();
		}
		return addr;
	}
	
	@Override
	public List<work> findWorkList(String sql)
	{
		List<work> work=new ArrayList<work>();
		try {
			ResultSet rs=dbc.doQuery(sql, new Object[] {});
			while(rs.next()) {
				work addr=new work();
				addr.setWorkid(rs.getDouble(1));
				addr.setCheckNum(rs.getDouble(2));
				addr.setCutNum(rs.getDouble(3));
				addr.setForperson(rs.getString(4));
				addr.setManageUnit(rs.getString(5));
				work.add(addr);
			}
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			dbc.close();
		}
		return work;
	}
	
	@Override
	public int update(String sql)
	{
		int res=0;
		try {
			res=dbc.doUpdate(sql, new Object[] {});
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbc.close();
		}
		return res;
	}
	
	@Override
	public List<worktree> findworktree(String sql)
	{
		List<worktree> work=new ArrayList<worktree>();
		try {
			ResultSet rs=dbc.doQuery(sql, new Object[] {});
			while(rs.next()){
				worktree w=new worktree();
				w.setType(rs.getString(1));
				w.setTvolume(rs.getDouble(2));
				w.setUnitprice(rs.getDouble(3));
				w.setPrice(rs.getDouble(4));
				work.add(w);	
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbc.close();
		}
		return work;
	}
	
	@Override
	public double findcount(String sql)
	{
		double res=0;
		try {
			ResultSet rs=dbc.doQuery(sql, new Object[] {});
			res=rs.getDouble(1);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbc.close();
		}
		return res;
	}
	//木材劳务结算单
	@Override
	public List<treeLaowu> findLaowu()
	{
		String sql = "SELECT endtime,codepage.codeid,workid,checkNum,cutNum,shipping,shipplace,finbuyer,getperson,forperson,countid,manageUnit,treetype,tlong,tradius,num,tvolume,unitprice,totalnum from codepage JOIN tree on codepage.codeid=tree.codeid";
		ResultSet rs = null;
		List<treeLaowu> ts= new ArrayList<treeLaowu>();
		try {
    		connection = DBcon.getConnection();
    		pStatement = connection.prepareStatement(sql);
    		rs = pStatement.executeQuery();
    		while (rs.next()) {
    			treeLaowu s=new treeLaowu();
    			s.setEndtime(rs.getDate(1));
    			//System.out.println("...." + rs.getDate(1) + "...");
    			s.setCodeid(rs.getDouble(2));
    			s.setWorkid(rs.getDouble(3));
    			s.setChecknum(rs.getDouble(4));
    			s.setCutnum(rs.getDouble(5));
    			s.setShipping(rs.getString(6));
    			s.setShipplace(rs.getString(7));
    			s.setFinbuyer(rs.getString(8));
    			s.setGetperson(rs.getString(9));
    			s.setForperson(rs.getString(10));
    			s.setCountid(rs.getDouble(11));
    			s.setManageUnit(rs.getString(12));
    			s.setTreetype(rs.getString(13));
    			s.setTlong(rs.getDouble(14));
    			s.setTradius(rs.getDouble(15));
    			s.setNum(rs.getDouble(16));
    			s.setTvolume(rs.getDouble(17));
    			s.setUnitprice(rs.getDouble(18));
    			s.setTotalnum(rs.getDouble(19));
    			/*s.setYear(rs.getDouble(1));
    			s.setMonth(rs.getDouble(2));
    			s.setDay(rs.getDouble(3));;
    			s.setCodeid(rs.getDouble(4));
    			s.setWorkid(rs.getDouble(5));
    			s.setChecknum(rs.getDouble(6));
    			s.setCutnum(rs.getDouble(7));
    			s.setShipping(rs.getString(8));
    			s.setShipplace(rs.getString(9));
    			s.setFinbuyer(rs.getString(10));
    			s.setGetperson(rs.getString(11));
    			s.setForperson(rs.getString(12));
    			s.setCountid(rs.getDouble(13));
    			s.setManageUnit(rs.getString(14));
    			s.setTreetype(rs.getString(15));
    			s.setTlong(rs.getDouble(16));
    			s.setTradius(rs.getDouble(17));
    			s.setNum(rs.getDouble(18));
    			s.setTvolume(rs.getDouble(19));
    			s.setUnitprice(rs.getDouble(20));
    			s.setTotalnum(rs.getDouble(21));*/
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
	public treeLaowu printLaowu(double workid,double codeid)
	{
		String sql = "SELECT endtime,codepage.codeid,workid,checkNum,cutNum,shipping,shipplace,finbuyer,getperson,forperson,countid,manageUnit,treetype,tlong,tradius,num,tvolume,unitprice,totalnum from codepage JOIN tree on codepage.codeid=tree.codeid";
		ResultSet rs = null;
		treeLaowu d= new treeLaowu();
		try {
    		connection = DBcon.getConnection();
    		pStatement = connection.prepareStatement(sql);
    		rs = pStatement.executeQuery();
    		while (rs.next()) {
    			d.setEndtime(rs.getDate(1));
    			d.setCodeid(rs.getDouble(2));
    			d.setWorkid(rs.getDouble(3));
    			d.setChecknum(rs.getDouble(4));
    			d.setCutnum(rs.getDouble(5));
    			d.setShipping(rs.getString(6));
    			d.setShipplace(rs.getString(7));
    			d.setFinbuyer(rs.getString(8));
    			d.setGetperson(rs.getString(9));
    			d.setForperson(rs.getString(10));
    			d.setCountid(rs.getDouble(11));
    			d.setManageUnit(rs.getString(12));
    			d.setTreetype(rs.getString(13));
    			d.setTlong(rs.getDouble(14));
    			d.setTradius(rs.getDouble(15));
    			d.setNum(rs.getDouble(16));
    			d.setTvolume(rs.getDouble(17));
    			d.setUnitprice(rs.getDouble(18));
    			d.setTotalnum(rs.getDouble(19));
    			/*d.setYear(rs.getDouble(1));
    			d.setMonth(rs.getDouble(2));
    			d.setDay(rs.getDouble(3));;
    			d.setCodeid(rs.getDouble(4));
    			d.setWorkid(rs.getDouble(5));
    			d.setChecknum(rs.getDouble(6));
    			d.setCutnum(rs.getDouble(7));
    			d.setShipping(rs.getString(8));
    			d.setShipplace(rs.getString(9));
    			d.setFinbuyer(rs.getString(10));
    			d.setGetperson(rs.getString(11));
    			d.setForperson(rs.getString(12));
    			d.setCountid(rs.getDouble(13));
    			d.setManageUnit(rs.getString(14));
    			d.setTreetype(rs.getString(15));
    			d.setTlong(rs.getDouble(16));
    			d.setTradius(rs.getDouble(17));
    			d.setNum(rs.getDouble(18));
    			d.setTvolume(rs.getDouble(19));
    			d.setUnitprice(rs.getDouble(20));
    			d.setTotalnum(rs.getDouble(21));*/
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
