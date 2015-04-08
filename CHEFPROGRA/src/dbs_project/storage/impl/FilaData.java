/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbs_project.storage.impl;

import dbs_project.storage.ColumnMetaData;
import dbs_project.storage.RowMetaData;

/**
 *
 * @author Kevin Matamoros
 */
public class FilaData implements RowMetaData{
    
    public ListaEnlazada tabla;
    public int ID;
    
    
    public FilaData(int ID,ListaEnlazada tabla){
        this.ID=ID;
        this.tabla=tabla;
    }

    @Override
    public int getColumnCount() {
        return tabla.size;
    }

    @Override
    public ColumnMetaData getColumnMetaData(int positionInTheRow) throws IndexOutOfBoundsException {
        tabla.goToPos(positionInTheRow);
        return (ColumnMetaData) tabla.getElement();
    }

    @Override
    public int getId() {
        return ID;
    }
    
}
