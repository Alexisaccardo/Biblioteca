import java.sql.*;
import java.util.Scanner;

public class Prestamos {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("***BIENVENIDOS A LA BIBLIOTECA MUNICIPAL***");

        System.out.println("Ingrese tu documento de identidad: ");
        String Cedula = scanner.nextLine();

        String Tipo = Select_One(Cedula);

        if (Tipo.equals("Bibliotecario")){

            System.out.println("Deseas registar o editar un libro?: ");
            String respuesta = scanner.nextLine();

            if (respuesta.equals("registrar")){

                System.out.println("Ingrese el nombre del libro: ");
                String nombre = scanner.nextLine();

                System.out.println("Ingrese el autor del libro: ");
                String autor = scanner.nextLine();

                System.out.println("Ingrese la disponibilidad del libro: ");
                String disponibilidad = scanner.nextLine();

                Libros libros = new Libros(nombre,autor,disponibilidad,"");

                Insert(libros); //


            }if (respuesta.equals("editar")){

                System.out.println("Ingrese el nombre del libro: ");
                String nombre = scanner.nextLine();

                System.out.println("Ingrese la disponibilidad del libro: ");
                String disponibilidad = scanner.nextLine();


                Editar2(nombre, disponibilidad);
            }

        }else{
            Select();

            System.out.println("¿Deseas prestar un libro? :");
            String respuesta = scanner.nextLine();


            while (respuesta.equals("si")){

                System.out.print("Ingresa nombre del libro: ");
                String Libros = scanner.nextLine();

                System.out.print("Ingrese su usuario: ");
                String Usuarios = scanner.nextLine();

                String driver2 = "com.mysql.cj.jdbc.Driver";
                String url2 = "jdbc:mysql://localhost:3306/prestamoslibros";
                String username2 = "root";
                String pass2 = "";

                Editar(Libros, Usuarios);

                System.out.println("Deseas prestar otro libro?: ");
                respuesta = scanner.nextLine();

            }
        }

    }

    private static void Editar2(String nombre, String disponibilidad) throws SQLException, ClassNotFoundException {

        String driver2 = "com.mysql.cj.jdbc.Driver";
        String url2 = "jdbc:mysql://localhost:3306/prestamoslibros";
        String username2 = "root";
        String pass2 = "";

        Class.forName(driver2);
        Connection connection2 = DriverManager.getConnection(url2, username2, pass2);

        Statement statement2 = connection2.createStatement();

        String consulta = "UPDATE libros SET Prestamos = ? WHERE Libros = ?";
        PreparedStatement preparedStatement = connection2.prepareStatement(consulta);
        preparedStatement.setString(1, disponibilidad);
        preparedStatement.setString(2, nombre);

        int filasActualizadas = preparedStatement.executeUpdate();
        if (filasActualizadas > 0) {
            System.out.println("Producto actualizado exitosamente");
        } else {
            System.out.println("No se encontró el registro para actualizar");
        }

        preparedStatement.close();
        connection2.close();
    }


    private static void Insert(Libros libros) {
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/prestamoslibros";
        String username = "root";
        String password = "";

        try {
            Class.forName(driver);
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM libros");


            // Sentencia INSERT
            String sql = "INSERT INTO libros (Libros, Autores, Prestamos, Usuarios) VALUES (?, ?, ?, ?)";

            // Preparar la sentencia
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, libros.getLibros());
            preparedStatement.setString(2, libros.getAutores());
            preparedStatement.setString(3, libros.getPrestamos());
            preparedStatement.setString(4, libros.getUsuarios());

            // Ejecutar la sentencia
            int filasAfectadas = preparedStatement.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("libro agregado exitosamente.");
            } else {
                System.out.println("No se pudo agregar el libro.");
            }

            preparedStatement.close();
            connection.close();
            statement.close();
            resultSet.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static String Select_One(String cedula) throws SQLException, ClassNotFoundException {
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/prestamoslibros";
        String username = "root";
        String password = "";
        Class.forName(driver);
        Connection connection = DriverManager.getConnection(url, username, password);

        String consultaSQL = "SELECT * FROM usuarios WHERE Cedula = ?";

        PreparedStatement statement = connection.prepareStatement(consultaSQL);
        statement.setString(1, cedula); // Establecer el valor del parámetro

        // Ejecutar la consulta
        ResultSet resultSet = statement.executeQuery();

        // Procesar el resultado si existe
        if (resultSet.next()) {
            String Tipo = resultSet.getString("Tipo");
            String Cedula = resultSet.getString("Cedula");
            String Nombre = resultSet.getString("Nombre");
           ;

            System.out.println("Bienvenido: " + Nombre + " Cedula: "+ Cedula);

            return Tipo;

        } else {
            System.out.println("No se encontró un registro con el codigo especificado.");
        }

        // Cerrar recursos
        resultSet.close();
        statement.close();
        connection.close();

        return "";
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
    }public static void Editar(String Libros, String Usuarios) throws ClassNotFoundException, SQLException {
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

