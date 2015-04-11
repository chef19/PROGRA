/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbs_project.storage.impl;

import dbs_project.storage.ColumnMetaData;
import dbs_project.storage.TableMetaData;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author max
 */
public class TablaMetaData implements TableMetaData{

    public int ID;
    public String Name;
    public Tabla Data;
    Map<String, ColumnMetaData> map;
    
    public TablaMetaData(int ID, String Name){
        map = new HashMap<String,ColumnMetaData>();
        this.ID = ID;
        this.Name = Name;
    }
    public void InsertMap(ColumnData ColumnaInfo){
        map.put(Name, ColumnaInfo);
    }
    
    @Override
    public Map<String, ColumnMetaData> getTableSchema() {
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry e = (Map.Entry)it.next();
            System.out.println(e.getKey() + " " + e.getValue());
        }
        return null;
    }

    @Override
    public int getRowCount() {
        return Data.FilCursor.Filas.size();
    }

    @Override
    public int getId() {
        return ID;
    }

    @Override
    public String getName() {
        return Name;
    }
    
    public static void main(String[] args) {
        HashMap datos = new HashMap();
 
        // Añadimos datos a nuestro hashMap
        datos.put("Nombre","David");
        datos.put("Apellido1","Otero");
        datos.put("Apellido2","Gutiérrez");

        // Recorremos el hashMap y mostramos por pantalla el par valor y clave
        Iterator it = datos.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry e = (Map.Entry)it.next();
            System.out.println(e.getKey() + " " + e.getValue());
        }
    }
    
}
