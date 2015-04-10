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
    
    public ListaEnlazada Fila=null;
    public Fila FilaRealizada=null;
    public int ID;
    public int NuevoI;
    
    
    public FilaData(ListaEnlazada Fila,int ID){
        this.ID=ID;
        this.Fila=Fila;
    }
    public FilaData(Fila Fila,int ID){
        FilaRealizada=Fila;
        this.NuevoI=ID;
    }

    @Override
    public int getColumnCount() {
        if(Fila==null){
            return FilaRealizada.Fila.size();
        }
        else{
            return Fila.size();
        }
    }

    @Override
    public ColumnMetaData getColumnMetaData(int positionInTheRow) throws IndexOutOfBoundsException {
        
        return (ColumnMetaData) Fila.getElement();
    }

    @Override
    public int getId() {
            return ID;
    }
    
}
