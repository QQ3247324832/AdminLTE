package com.example.demo.Dao;



import com.example.demo.Entity.User;
import com.example.demo.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author xinYing
 * @date 2019/7/4 21:22
 */
public class UserDao {
    /**
     * 获取所有数据
     */
    public static List<User> getUserAll(){
        Connection connection = null;
        try {
            connection = DBUtil.getConnection();
            List<User> list =  new ArrayList<>();
            String sql = "select id,account,password,username,state,url,registerDate from user ";
            Statement ps = connection.createStatement();
            ResultSet resultSet = ps.executeQuery(sql);
            while(resultSet.next()){
                Integer id = resultSet.getInt("id");
                long account = resultSet.getLong("account");
                String password = resultSet.getString("password");
                String username = resultSet.getString("username");
                Integer state = resultSet.getInt("state");
                String url = resultSet.getString("url");
                Date registerDate = resultSet.getDate("registerDate");
                list.add(new User(id,account,password,username,state,url,registerDate));
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }finally{
            DBUtil.close(connection);
        }
    }
    /**
     * 删除
     */
    public static int deleteId(int id){
        String sql = "delete from user where id=?";
        try(Connection conn = DBUtil.getConnection()){
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            int len = ps.executeUpdate();
            return len;
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
    /**
     * 新增
     */
    public static  int insertUser(User user ){
        String sql = "insert into user values(null,?,?,?,0,'mr.png',now())";
        try(Connection conn = DBUtil.getConnection()){
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setLong(1,user.getAccount());
            ps.setString(2,user.getPassword());
            ps.setString(3,user.getUsername());
           return ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
            throw new RuntimeException();
        }

    }
}
