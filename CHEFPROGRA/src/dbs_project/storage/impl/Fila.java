/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbs_project.storage.impl;

import dbs_project.storage.Row;
import dbs_project.storage.RowMetaData;
import dbs_project.structures.DataStructure;
import dbs_project.structures.LinearDataStructure;
import java.util.Date;

/**
 *
 * @author Kevin Matamoros
 */
public class Fila implements Row {
    public ListaEnlazada Fila;
    public static int ID=0;
    public FilaData Datos;

    public Fila(ListaEnlazada Fila){
        this.Fila = Fila;    
        Datos= new FilaData(Fila,ID);
        ID++;
    }

    
    @Override
    public RowMetaData getMetaData() {
      return Datos;
    }

    @Override
    public Integer getInteger(int index) throws IndexOutOfBoundsException, ClassCastException {
        Fila.goToPos(index);
        if (Fila.getElement()==null){
            return null;
        }
        return (int) Fila.getElement();
        
    }

    @Override
    public Boolean getBoolean(int index) throws IndexOutOfBoundsException, ClassCastException {
        Fila.goToPos(index);
        if (Fila.getElement()==null){
            return null;
        }
        return (boolean) Fila.getElement();
    }

    @Override
    public Double getDouble(int index) throws IndexOutOfBoundsException, ClassCastException {
        Fila.goToPos(index);
        if (Fila.getElement()==null){
            return null;
        }
        return (double) Fila.getElement();
    }

    @Override
    public Date getDate(int index) throws IndexOutOfBoundsException, ClassCastException {
        Fila.goToPos(index);
        return (Date) Fila.getElement();
    }

    @Override
    public String getString(int index) throws IndexOutOfBoundsException {
        Fila.goToPos(index);
        return (String) Fila.getElement();
    }

    @Override
    public Object getObject(int index) throws IndexOutOfBoundsException {
        Fila.goToPos(index);
        return (Object) Fila.getElement();
    }

    @Override
    public boolean isNull(int index) throws IndexOutOfBoundsException {
        Fila.goToPos(index);
        if(Fila.getElement()==null){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public LinearDataStructure<?> asLinearDataStructure(DataStructure type) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
}
