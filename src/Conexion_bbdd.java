import java.sql.*;

public class Conexion_bbdd {
    private String db = "empleados_departamentos";
    private String login = "root";
    private String pwd = "";
    private String url = "jdbc:mysql://localhost/" + db + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private Connection conexion;

    public Conexion_bbdd(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(url, login, pwd);
            System.out.println("Conexion establecida");
        } catch (ClassNotFoundException a){
            System.out.println("Driver JDBC no encontrado");
            a.printStackTrace();
        } catch (SQLException a){
            System.out.println("Error al conectar con la base de datos");
            a.printStackTrace();
        }
    }

    public void Terminar_conexion(){
        try {
            conexion.close();

        }catch (SQLException a){
            a.printStackTrace();
        }
    }
    public static void main (String [] args){
        Conexion_bbdd prueba = new Conexion_bbdd();
        prueba.Terminar_conexion();
    }
}
