
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.daw.singletonjdbc;

import java.util.List;

/**
 *
 * @author Isaac Cordero García
 */
public class Main {
    public static void main(String[] args) {
      
        UsuarioManager usuarioManager = UsuarioManager.getInstance();
        List<Usuario> usuarios = usuarioManager.obtenerUsuarios();
        for (Usuario usuario : usuarios) {
            System.out.println(usuario);
        }
       
    }
}
