/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbs_project.storage.impl;

import dbs_project.storage.ColumnMetaData;
import dbs_project.storage.Table;
import dbs_project.storage.Type;

/**
 *
 * @author Kevin Matamoros
 */
public class ColumnData implements ColumnMetaData{
    public ListaEnlazada Columna;
    public String Name;
    public Type DataType;
    public Tabla Tabla;
    public int ID;
    public FilaCursor Cursor;
    
    public ColumnData(ListaEnlazada Columna, int ID, String Name, Tabla Tabla){
        this.Columna = Columna;
        this.ID = ID;
        this.Name = Name;
        this.Tabla = Tabla;
    }
    
    public ColumnData(ListaEnlazada Columna, int ID, String Name, Type DataType){
        this.Columna = Columna;
        this.ID = ID;
        this.Name = Name;
        this.DataType = DataType;
    }
    
    public ColumnData(ListaEnlazada Columna, int ID, String Name, FilaCursor Cursor){
        this.Columna = Columna;
        this.ID = ID;
        this.Name = Name;
        this.Cursor = Cursor;
    }
    
    @Override
    public int getRowCount() {     
        return Columna.size();
    }

    @Override
    public Table getSourceTable() {
        return Tabla;
    }

    @Override
    public String getLabel() {
        return Tabla.getTableMetaData().getName()+"."+Name;
    }

    @Override
    public Type getType() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getRowId(int positionInColumn) throws IndexOutOfBoundsException {
        int i;
        for(i=0;i==positionInColumn;i++){
            Cursor.next();
        }
        return Cursor.getMetaData().getId();
    }

    @Override
    public int getId() {
        return ID;
    }

    @Override
    public String getName() {
        return Name;
    }
}
