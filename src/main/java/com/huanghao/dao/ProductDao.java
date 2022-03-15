package com.huanghao.dao;

import com.huanghao.model.Product;
import com.huanghao.model.User;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDao implements  IProductDao{
    @Override
    public int save(Product product, Connection con) throws SQLException {
        int n = 0;
        String sql = "insert into product(ProductName,ProductDescription,Picture,price,CategoryID) values(?,?,?,?,?)";
        PreparedStatement pt = con.prepareStatement(sql);
        pt.setString(1, product.getProductName());
        pt.setString(2, product.getProductDescription());
        if(product.getPicture()!=null) {
            //for sql server
            pt.setBinaryStream(3, product.getPicture());
            //for mysql
            //   pt.setBlob(3, product.getPicture());
        }
        pt.setDouble(4, product.getPrice());
        pt.setInt(5, product.getCategoryId());
        n = pt.executeUpdate();
        if (n > 0) {
            return n;
        }
        return 0;
    }//end save

    @Override
    public int delete(Integer productId, Connection con) throws SQLException {
        String sql="delete from usertable where username=?";
        PreparedStatement pt=con.prepareStatement(sql);
        int count = pt.executeUpdate();
        if (count == 1) {
            System.out.println("删除成功");
        } else {
            System.out.println("删除失败");
        }

        return count;
    }

    @Override
    public int update(Product instance, Connection con) throws SQLException {
        String sql="update Product set ProductName='"+instance.getProductName()+"', Productdescription= '"+instance.getProductDescription()+"', Picture='"+instance.getPicture()+"', Price='"+instance.getPrice()+"' where id='"+instance.getProductId()+"'";
        System.out.println(sql);
        PreparedStatement st=con.prepareStatement(sql);

        int count = st.executeUpdate();
        if (count == 1) {
            System.out.println("成功");
        } else {
            System.out.println("失败");
        }
        return count;
    }

    @Override
    public Product findById(Integer productId, Connection con) throws SQLException {
        String sql="select from Product where id=?";
        PreparedStatement st=con.prepareStatement(sql);
        ResultSet rs=st.executeQuery();
         Product product=null;
        if (rs.next()){
            product=new Product();
            product.setProductId(rs.getInt("ProductId"));
            product.setProductName(rs.getString("ProductName"));
            product.setProductDescription(rs.getString("ProductDescription"));
            product.setPicture(rs.getBinaryStream("Picture"));
            product.setPrice(rs.getInt("Price"));
        }

        return product;
    }

    @Override
    public List<Product> findByCategoryId(int categoryId, Connection con) throws SQLException {
        String sql="select from Product where CategoryId=?";
        PreparedStatement st=con.prepareStatement(sql);
        ResultSet rs=st.executeQuery();
        List<Product> p=new ArrayList<>();
        Product product=null;
        if (rs.next()){
            product=new Product();
            product.setProductId(rs.getInt("ProductId"));
            product.setProductName(rs.getString("ProductName"));
            product.setProductDescription(rs.getString("ProductDescription"));
            product.setPicture(rs.getBinaryStream("Picture"));
            product.setPrice(rs.getInt("Price"));
            p.add(product);
        }


        return p;
    }

    @Override
    public List<Product> findByPrice(double minPrice, double maxPrice, Connection con) throws SQLException {
        String sql="select from Product where Price=?";
        PreparedStatement st=con.prepareStatement(sql);
        ResultSet rs=st.executeQuery();
        List<Product> p=new ArrayList<>();
        Product product=new Product();
        if (rs.next()){
            product=new Product();
            product.setProductId(rs.getInt("ProductId"));
            product.setProductName(rs.getString("ProductName"));
            product.setProductDescription(rs.getString("ProductDescription"));
            product.setPicture(rs.getBinaryStream("Picture"));
            product.setPrice(rs.getInt("Price"));
            p.add(product);
        }


        return p;
    }

    @Override
    public List<Product> findAll(Connection con) throws SQLException {
        String sql="select ProductId,ProductName,ProductDescription,Picture,Price from Product";
        PreparedStatement st=con.prepareStatement(sql);
        ResultSet rs=st.executeQuery();
        List<Product> p=new ArrayList<>();
        Product product=new Product();
        if (rs.next()){
            product=new Product();
            product.setProductId(rs.getInt("ProductId"));
            product.setProductName(rs.getString("ProductName"));
            product.setProductDescription(rs.getString("ProductDescription"));
            product.setPicture(rs.getBinaryStream("Picture"));
            product.setPrice(rs.getInt("Price"));
            p.add(product);
        }

        return p;
    }

    @Override
    public List<Product> findByProductName(String productName, Connection con) throws SQLException {
        String sql="select ProductId,ProductName,ProductDescription,Picture,Price from Product where=?";
        PreparedStatement st=con.prepareStatement(sql);
        ResultSet rs=st.executeQuery();
        List<Product> p=new ArrayList<>();
        Product product=new Product();
        if (rs.next()){
            product=new Product();
            product.setProductId(rs.getInt("ProductId"));
            product.setProductName(rs.getString("ProductName"));
            product.setProductDescription(rs.getString("ProductDescription"));
            product.setPicture(rs.getBinaryStream("Picture"));
            product.setPrice(rs.getInt("Price"));
            p.add(product);
        }

        return p;
    }

    @Override
    public List<Product> getPicture(Integer productId, Connection con) throws SQLException {
        String sql="select Picture from Product where=?";
        PreparedStatement st=con.prepareStatement(sql);
        ResultSet rs=st.executeQuery();
        List<Product> p=new ArrayList<>();
        Product product=new Product();
        if (rs.next()){
            product=new Product();
            product.setPicture(rs.getBinaryStream("Picture"));
            p.add(product);
        }

        return p;
    }
}
