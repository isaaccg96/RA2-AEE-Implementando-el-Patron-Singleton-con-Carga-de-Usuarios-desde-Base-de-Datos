
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
        UsuarioManager prueba;
        List<Usuario> lista1, lista2;
      
        prueba = UsuarioManager.getInstance();
        lista1 = prueba.obtenerUsuarios();
        for (Usuario usuario : lista1) {
            System.out.println(usuario);
        }
        
        UsuarioManager.getInstance();
        lista2 = lista1;
        for (Usuario usuario : lista2) {
            System.out.println(usuario);
        }
       
    }
}
