package manager;

import java.sql.*;
import java.util.ArrayList;

public class SqlDAO {
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;

    public SqlDAO(){
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    public boolean DBFindName(String name){
        try{
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","c##test_01","test_01");
            String sql = "select * from test_01 where name = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1,name);
            rs = ps.executeQuery();
            if(rs.next()){
                return true;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }
    public int insertDB(String name, int lng, int mth, int sp){
        try{
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","c##test_01","test_01");
            String sql = "insert into test_01 values(?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setInt(2, lng);
            ps.setInt(3, mth);
            ps.setInt(4, sp);
            int res = ps.executeUpdate();
            return res;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return -1;
    }

    public ArrayList<Format> list(){
        try{
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","c##test_01","test_01");
            String sql = "select * from test_01";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            ArrayList<Format> list = new ArrayList<>();
            while(rs.next()){
                String name = rs.getString("name");
                int lng = rs.getInt("lng");
                int mth = rs.getInt("mth");
                int sp = rs.getInt("sp");
                Format f = new Format(name,lng,mth,sp);
                list.add(f);
            }
            return list;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public Format FindDB(String name){
        try{
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","c##test_01","test_01");
            String sql = "select * from test_01 where name = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1,name);
            rs = ps.executeQuery();
            Format f = new Format();
            while(rs.next()){
                String findName = rs.getString("name");
                int lng = rs.getInt("lng");
                int mth = rs.getInt("mth");
                int sp = rs.getInt("sp");
                f.setName(name);
                f.setLng(lng);
                f.setMth(mth);
                f.setSp(sp);
                f.setAvg();
            }
            return f;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    public int deleteDB(String name){
        try{
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","c##test_01","test_01");
            String sql = "delete from test_01 where name = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, name);
            int res = ps.executeUpdate();
            return res;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return -1;
    }

    public int modifyDB(String name, int lng, int mth, int sp){
        try{
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","c##test_01","test_01");
            String sql = "update test_01 set lng = ?, mth = ?, sp = ? where name = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, lng);
            ps.setInt(2, mth);
            ps.setInt(3, sp);
            ps.setString(4, name);
            int res = ps.executeUpdate();
            return res;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return -1;
    }
}
