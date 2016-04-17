import java.sql.*;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

public class DBC {
    
    public static String currentContact="";
    

    
    public static Connection ConnectDB() 
    {
        //Register the JDBC Driver
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            System.out.println(e);
        }
        
        //Open a Connection
        try{
            Connection Con=DriverManager.getConnection("jdbc:mysql://localhost/contacts","root","");
            return Con;
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
       return null;
    } // End of ConnectDB
    
    
    public static void DisconnectDB(Connection Con)
    {
        try {
            Con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    } // End of DisconnectDB
    
    public static void ExecuteSQL(Connection Con,String SQL)
    {
        Statement S;
        try {
            S = Con.createStatement();
            int R = S.executeUpdate(SQL);
        } catch (Exception e) {
            System.out.println(e);
        }
        
    } //End of ExecuteSQL
    public static ResultSet getTable(Connection Con,String SQL)
    {
        Statement S;
        try {
            S = Con.createStatement();
            ResultSet R = S.executeQuery(SQL);
            return R;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    } //End of getTable
    public static void firstRun()
    {
        Connection con = DBC.ConnectDB();
        String sql="create table if not exists people (name varchar(50),mobile varchar(50),phone varchar(50),email varchar(100),address varchar(500),note varchar(500))";
        DBC.ExecuteSQL(con, sql);
        
        DBC.DisconnectDB(con);
    }
}
