/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busca_pareja;


import java.sql.*;
import javax.swing.JOptionPane;

public class DB_Login {

    public String bd = "gimnasio";
    private static final String DRIVER_CLASS="com.mysql.jdbc.Driver";
    private static final String URL="jdbc:mysql://localhost/buscapareja";
    private static final String USER="root";
    private static final String PASS="";
    public String login = "root";
    public String password = "";
    private static Driver driver =null;
    public String url = "jdbc:mysql://localhost/buscapareja";

    public Connection conexion(){
        Connection conect = null;
      try {
             
           //Cargamos el Driver MySQL
           Class.forName("com.mysql.jdbc.Driver");
           conect = DriverManager.getConnection("jdbc:mysql://localhost/buscapareja","root","");
          // JOptionPane.showMessageDialog(null, "conectado");
           //Cargamos el Driver Access
           //Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
           //Conectar en red base 
           //String strConect = "jdbc:odbc:Driver=Microsoft Access Driver (*.mdb);DBQ=//servidor/bd_cw/cw.mdb";
           //Conectar Localmente
           //String strConect = "jdbc:odbc:Driver=Microsoft Access Driver (*.mdb);DBQ=D:/cwnetbeans/cw.mdb";
          //conect = DriverManager.getConnection(strConect,"",""); 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error "+e);
        }
        return conect;
     
       
    }
    

    public static synchronized Connection getConexion() throws SQLException{
    try{
        Class driverClass = Class.forName(DRIVER_CLASS);
        driver = (Driver)driverClass.newInstance();
        DriverManager.registerDriver(driver);    
    }catch(Exception ex){
        ex.printStackTrace();
    } 
    
    return DriverManager.getConnection(URL, USER, PASS);
}
    
   
}

