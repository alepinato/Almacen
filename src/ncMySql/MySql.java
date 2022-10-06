
package ncMySql;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;



public class MySql {
   
    private static final String db = "almacen";
    private static final String user ="root";
    private static final String pass ="";
    private static final String url="jdbc:mysql://localhost:3306/"+db;
    private static Connection con;
    
    public static Connection getConection(){
        try{
            
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pass);
        }catch(ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null,"Conexión no establecida: "+ e);
        }
        return con;
    }
    public void cerrarBD() throws SQLException{
        if(!con.isClosed())
            con.close();
    }
}
