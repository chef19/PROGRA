/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbs_project.gui.impl;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Kevin Matamoros
 */
public class modificando_tabla {
    
    
    public void recibe_tabla(JTable tabla){
    
    }
    public void mostrar_celdaelegida(JTable tabla){
        int i = tabla.getSelectedRow();
        System.out.println("Fila: "+i);
        if (i==-1){
            JOptionPane.showMessageDialog(tabla, "No ha seleccionado ninguna celda");
        }
    } 
    public void mostrar_columnaelegida(JTable tabla){
        int i = tabla.getSelectedColumn();
        System.out.println("Columna: "+i);
        if (i==-1){
            JOptionPane.showMessageDialog(tabla, "No ha seleccionado ninguna celda");
        }
    }
    public void mostrar_valorcelda(JTable tabla){
            String celda = (String) tabla.getValueAt(tabla.getSelectedRow(),tabla.getSelectedColumn());
            System.out.println("El valor de la celda es: "+celda);
            
    }
    public void eliminar_tabla(JTable tabla){
        tabla.setModel(new DefaultTableModel());
    }
}
