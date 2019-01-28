import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FullDB {
    public static void main(String[] args) {
        FullDB connection = new FullDB();
        connection.createConnection();
    }

    //Create a method to connect to database
    void createConnection(){
        try{
            //Connect to Database
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connect = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/GroceryList","root","");

            //Create a sql statement
            Statement query = connect.createStatement();

            //Insert/Uodate data to Database
            query.executeUpdate("INSERT INTO list" + "(name)" + "VALUES('orange'), ('melons')," +
                    "('hotdogs'), ('buns')");

            //Execute a select all statement
            ResultSet rs = query.executeQuery("SELECT * FROM list");
            System.out.println("Grocery List");
            while (rs.next()){
                String table = rs.getString("name");
                System.out.println(table);
            }

//            System.out.println("Connected to Database");
        }

        catch (ClassNotFoundException ex){
            Logger.getLogger(FullDB.class.getName()).log(Level.SEVERE,null,ex);
        }

        catch(SQLException ex){
            Logger.getLogger(FullDB.class.getName()).log(Level.SEVERE,null,ex);
            ex.printStackTrace();
        }
    }

}

