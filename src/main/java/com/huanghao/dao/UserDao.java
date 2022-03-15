package com.huanghao.dao;

import com.huanghao.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserDao implements IUserDao{
    @Override
    public boolean saveUser(Connection con, User user) throws SQLException {
        //insert ... into usertable
        String sql="insert id,username,password,email,sex,birth from usertable";
        PreparedStatement st=con.prepareStatement(sql);
        int count= st.executeUpdate(sql);
        System.out.println("成功");
        if (count==1)
            System.out.println("增加成功");
        else
            System.out.println("增加失败");
        return true;
    }

    @Override
    public int deleteUser(Connection con, User user) throws SQLException {
        //delete ... where id=?
        String sql="delete from usertable where username=?";
        PreparedStatement st=con.prepareStatement(sql);
        int count = st.executeUpdate();
        if (count == 1) {
            System.out.println("删除成功");
        } else {
            System.out.println("删除失败");
        }

        return count;
    }

    @Override
    public int updateUser(Connection con, User user) throws SQLException {
        //update...where id=?
        String sql="update from usertable set password '"+user.getPassword()+"' where username=?";
        PreparedStatement st=con.prepareStatement(sql);
        int count = st.executeUpdate();
        if (count == 1) {
            System.out.println("删除成功");
        } else {
            System.out.println("删除失败");
        }

        return count;
    }

    @Override
    public User findById(Connection con, Integer id) throws SQLException {
        //select...where id=?
        String sql="select from usertable where id=?";
        PreparedStatement st=con.prepareStatement(sql);
        ResultSet rs=st.executeQuery();
        User user=null;
        if (rs.next()){
            user=new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setSex(rs.getString("sex"));
            user.setBirth(rs.getString("birth"));
        }

        return user;
    }

    @Override
    public User findByUsernamePassword(Connection con, String username, String password) throws SQLException {
        //select...where username=? and password=?
        String sql="select id,username,password,email,sex,birth from usertable where username=? and password=?";
        PreparedStatement st=con.prepareStatement(sql);
        st.setString(1,username);
        st.setString(2,password);
        ResultSet rs=st.executeQuery();
        User user=null;
        if (rs.next()){
            user=new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setSex(rs.getString("sex"));
            user.setBirth(rs.getString("birth"));
        }

        return user;
    }

    @Override
    public List<User> findByUsername(Connection con, String username) throws SQLException {
        String sql="select id,username,password,email,sex,birth from usertable where username=?";
        PreparedStatement st=con.prepareStatement(sql);
        st.setString(1,username);
        ResultSet rs=st.executeQuery();
        List<User> u=new ArrayList<>();
        User user=new User();
        if (rs.next()){
            user=new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setSex(rs.getString("sex"));
            user.setBirth(rs.getString("birth"));
        }
        u.add(user);

        return u;
    }

    @Override
    public List<User> findByPassword(Connection con, String password) throws SQLException {
        String sql="select id,username,password,email,sex,birth from usertable where password=?";
        PreparedStatement st=con.prepareStatement(sql);
        st.setString(1,password);
        ResultSet rs=st.executeQuery();
        List<User> u=new ArrayList<>();
        User user=new User();
        if (rs.next()){
            user=new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setSex(rs.getString("sex"));
            user.setBirth(rs.getString("birth"));
        }
        u.add(user);
        return u;
    }

    @Override
    public List<User> findByEmail(Connection con, String email) throws SQLException {
        String sql="select id,username,password,email,sex,birth from usertable where email=?";
        PreparedStatement st=con.prepareStatement(sql);
        st.setString(1,email);
        ResultSet rs=st.executeQuery();
        List<User> u=new ArrayList<>();
        User user=new User();
        if (rs.next()){
            user=new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setSex(rs.getString("sex"));
            user.setBirth(rs.getString("birth"));
        }
        u.add(user);
        return u;
    }

    @Override
    public List<User> findByGender(Connection con, String sex) throws SQLException {
        String sql="select id,username,password,email,sex,birth from usertable where sex=?";
        PreparedStatement st=con.prepareStatement(sql);
        st.setString(1,sex);
        ResultSet rs=st.executeQuery();
        List<User> u=new ArrayList<>();
        User user=new User();
        if (rs.next()){
            user=new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setSex(rs.getString("sex"));
            user.setBirth(rs.getString("birth"));
        }
        u.add(user);
        return u;
    }

    @Override
    public List<User> findByBirthdate(Connection con, String birth) throws SQLException {
        String sql="select id,username,password,email,sex,birth from usertable where birth=?";
        PreparedStatement st=con.prepareStatement(sql);
        st.setString(1,birth);
        ResultSet rs=st.executeQuery();
        List<User> u=new ArrayList<>();
        User user=new User();
        if (rs.next()){
            user=new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setSex(rs.getString("sex"));
            user.setBirth(rs.getString("birth"));
        }
        u.add(user);
        return u;
    }

    @Override
    public List<User> findAllUser(Connection con) throws SQLException {
        String sql="select id,username,password,email,sex,birth from usertable";
        PreparedStatement st=con.prepareStatement(sql);
        ResultSet rs=st.executeQuery();
        List<User> u=new ArrayList<>();
        User user=new User();
        if (rs.next()){
            user=new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setSex(rs.getString("sex"));
            user.setBirth(rs.getString("birth"));
        }
        u.add(user);
        return u;
    }
}
