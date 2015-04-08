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
    
    public ListaEnlazada Fila;
    
    
    public FilaData(ListaEnlazada fila){
        this.Fila=fila;
    }

    @Override
    public int getColumnCount() {
        return Fila.size();
    }

    @Override
    public ColumnMetaData getColumnMetaData(int positionInTheRow) throws IndexOutOfBoundsException {
        
        return (ColumnMetaData) Fila.getElement();
    }

    @Override
    public int getId() {
        return Fila.getPosition();
    }
    
}
