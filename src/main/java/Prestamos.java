import java.sql.*;
import java.util.Scanner;

public class Prestamos {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("***BIENVENIDOS A LA BIBLIOTECA MUNICIPAL***");

        Select();

        System.out.println("¿Deseas prestar un libro? :");
        String respuesta = scanner.nextLine();

        while (respuesta.equals("si")){

            System.out.print("Ingresa nombre del libro: ");
            String Libros = scanner.nextLine();

            System.out.println("Deseas prestar este libro?: ");
            String Prestamos = scanner.nextLine();

            System.out.print("Ingrese su usuario: ");
            String Usuarios = scanner.nextLine();

            String driver2 = "com.mysql.cj.jdbc.Driver";
            String url2 = "jdbc:mysql://localhost:3306/prestamoslibros";
            String username2 = "root";
            String pass2 = "";

            Editar(Libros, Prestamos, Usuarios);

        }

    }
    private static void Select() throws ClassNotFoundException, SQLException {
        String driver2 = "com.mysql.cj.jdbc.Driver";
        String url2 = "jdbc:mysql://localhost:3306/prestamoslibros";
        String username2 = "root";
        String pass2 = "";

        Class.forName(driver2);
        Connection connection2 = DriverManager.getConnection(url2, username2, pass2);

        Statement statement2 = connection2.createStatement();

        String consultaSQL = "SELECT * FROM libros WHERE Prestamos = ?";

        PreparedStatement statement = connection2.prepareStatement(consultaSQL);
        statement.setString(1, "Disponible"); // Establecer el valor del parámetro

        // Ejecutar la consulta
        ResultSet resultSet2 = statement.executeQuery();

        while(resultSet2.next()){
            String Libros = resultSet2.getString("Libros");
            String Autores = resultSet2.getString("Autores");
            String Prestamos  = resultSet2.getString("Prestamos");
            String Usuarios = resultSet2.getString("Usuarios");
            
            System.out.println(" Este es el libro: " + Libros +  " Autor: " + Autores + " Estado: " + Prestamos );
        }
    }public static void Editar(String Libros, String Prestamos, String Usuarios) throws ClassNotFoundException, SQLException {
        String driver2 = "com.mysql.cj.jdbc.Driver";
        String url2 = "jdbc:mysql://localhost:3306/prestamoslibros";
        String username2 = "root";
        String pass2 = "";

        Class.forName(driver2);
        Connection connection2 = DriverManager.getConnection(url2, username2, pass2);

        Statement statement2 = connection2.createStatement();
        String consulta = "UPDATE libros SET Prestamos = ?, Usuarios = ? WHERE Libros = ?";
        PreparedStatement preparedStatement = connection2.prepareStatement(consulta);
        preparedStatement.setString(1, "no disponible");
        preparedStatement.setString(2, Usuarios);
        preparedStatement.setString(3, Libros);

        int filasActualizadas = preparedStatement.executeUpdate();
        if (filasActualizadas > 0) {
            System.out.println("libro prestado exitosamente");
        } else {
            System.out.println("No se encontró el libro para prestar");
        }

        preparedStatement.close();
        connection2.close();
    }

    }

