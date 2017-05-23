package cn.itcast.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.itcast.dao.CustomerDao;
import cn.itcast.domain.Customer;
import cn.itcast.exception.DaoException;
import cn.itcast.utils.JdbcUtils;

public class CustomerDaoImpl implements CustomerDao {

    public void add(Customer customer) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "insert into customer(id,name,gender,birthday,cellphone,email,preference,type,description) values(?,?,?,?,?,?,?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, customer.getId());
            ps.setString(2, customer.getName());
            ps.setString(3, customer.getGender());
            ps.setDate(4, new java.sql.Date(customer.getBirthday().getTime()));
            ps.setString(5, customer.getCellphone());
            ps.setString(6, customer.getEmail());
            ps.setString(7, customer.getPreference());
            ps.setString(8, customer.getType());
            ps.setString(9, customer.getDescription());
            ps.executeUpdate();
        } catch (Exception e) {
            throw new DaoException(e);
        } finally {
            JdbcUtils.release(conn, ps, rs);
        }
    }

    public void update(Customer customer) {   //id
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "update customer set name=?,gender=?,birthday=?,cellphone=?,email=?,preference=?,type=?,description=?  where id=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, customer.getName());
            ps.setString(2, customer.getGender());
            ps.setDate(3, new java.sql.Date(customer.getBirthday().getTime()));
            ps.setString(4, customer.getCellphone());
            ps.setString(5, customer.getEmail());
            ps.setString(6, customer.getPreference());
            ps.setString(7, customer.getType());
            ps.setString(8, customer.getDescription());
            ps.setString(9, customer.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            throw new DaoException(e);
        } finally {
            JdbcUtils.release(conn, ps, rs);
        }
    }

    public void delete(String id) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "delete from customer where id=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            throw new DaoException(e);
        } finally {
            JdbcUtils.release(conn, ps, rs);
        }
    }

    public Customer find(String id) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "select * from customer where id=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                Customer customer = new Customer();
                customer.setBirthday(rs.getDate("birthday"));
                customer.setCellphone(rs.getString("cellphone"));
                customer.setDescription(rs.getString("description"));
                customer.setEmail(rs.getString("email"));
                customer.setGender(rs.getString("gender"));
                customer.setId(rs.getString("id"));
                customer.setName(rs.getString("name"));
                customer.setPreference(rs.getString("preference"));
                customer.setType(rs.getString("type"));
                return customer;
            }
            return null;
        } catch (Exception e) {
            throw new DaoException(e);
        } finally {
            JdbcUtils.release(conn, ps, rs);
        }
    }


    public List<Customer> getAll() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "select * from customer";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            List list = new ArrayList();
            while (rs.next()) {
                Customer customer = new Customer();
                customer.setBirthday(rs.getDate("birthday"));
                customer.setCellphone(rs.getString("cellphone"));
                customer.setDescription(rs.getString("description"));
                customer.setEmail(rs.getString("email"));
                customer.setGender(rs.getString("gender"));
                customer.setId(rs.getString("id"));
                customer.setName(rs.getString("name"));
                customer.setPreference(rs.getString("preference"));
                customer.setType(rs.getString("type"));
                list.add(customer);
            }
            return list;
        } catch (Exception e) {
            throw new DaoException(e);
        } finally {
            JdbcUtils.release(conn, ps, rs);
        }
    }
}
