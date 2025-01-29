package com.daw.singletonjdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Isaac Cordero García
 */
public class UsuarioManager {

    private static UsuarioManager instance;

    //Constructor
    private UsuarioManager() {

    }

    //Método para verificar si existe ya una instancia y crearla en caso de que no
    public static synchronized UsuarioManager getInstance() {
        if (instance == null) {
            instance = new UsuarioManager();
        } else {
            System.out.println("Instancia ya creada anteriormente");
        }
        return instance;
    }

    //Método para establecer la conexión con la BD
    private Connection conexionBD() {
        String url = "jdbc:mysql://localhost:3306/singletonjdbc";
        String usuario = "root";
        String contraseña = "";
        Connection conexion = null;

        try {
            //Cargar el driver de MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Establecer la conexión
            conexion = DriverManager.getConnection(url, usuario, contraseña);
            System.out.println("¡Conexión exitosa!");
        } catch (ClassNotFoundException e) {
            System.err.println("Error: No se encontró el driver JDBC.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Error: No se pudo conectar a la base de datos.");
            e.printStackTrace();
        }
        return conexion;
    }

    //Método para crear una lista con todos los usuarios recuperados de la BD
    public List<Usuario> obtenerUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM usuarios";
        try (Connection conexion = conexionBD(); Statement stmt = conexion.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            //Procesar los resultados
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String email = rs.getString("email");

                //Creamos un objeto usuario para guardar los datos y lo añadimos a la lista
                usuarios.add(new Usuario(id, nombre, email));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuarios;
    }
}
