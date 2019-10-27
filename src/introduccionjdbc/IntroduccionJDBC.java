package introduccionjdbc;

import java.sql.*;

public class IntroduccionJDBC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/sga?useSSL=false&serverTimezone=UTC";
        //Cargamos el driver de mysql
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Creamos el objeto conexion
            Connection conexion = (Connection) DriverManager.getConnection(url,"root", "admin");
            //Creamos un onjeto Statement
            Statement instruccion = conexion.createStatement();
            //Creamos el query
            String sql = "select id_persona, nombre, apellido from persona";
            ResultSet result = instruccion.executeQuery(sql);
            while (result.next()){
                System.out.println("Id:" + result.getInt(1));
                //System.out.println(" ");
                System.out.println("Nombre:" + result.getString(2));
                
                System.out.println("Apellido:" + result.getString(3));
                System.out.println(" ");
            }
            //Cerrar cada uno de los objetos utilizados
            result.close();
            instruccion.close();
            conexion.close();
        }catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
            
        }
    }
    
}
