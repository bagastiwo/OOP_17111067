package oop_17111067;

import java.sql.*;

public class Koneksi {
    String url, user, pass, db;
    
    
    Koneksi(){
        db="db_17111067";
        url="jdbc:mysql://localhost:3306/" + db;
        //url="jdbc:mysql://localhost/db_17111067?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        user="root";
        pass="";
    }
    
    public Connection getConnection(){
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pass);
            System.out.println("bisa");
        }
        catch (ClassNotFoundException e) {
            System.out.println("Driver not found \n"+e+"\n");
        }
        catch (SQLException e){
            System.out.println("Gagal Koneksi");
            System.out.println(e);
        }
        return con;
    }
    public static void main(String[] args) {
        Koneksi n = new Koneksi();
        n.getConnection();
    }
}


