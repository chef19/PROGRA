/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbs_project.storage.impl;

import dbs_project.storage.RowCursor;
import dbs_project.storage.RowMetaData;
import dbs_project.structures.DataStructure;
import dbs_project.structures.LinearDataStructure;
import java.util.Date;

/**
 *
 * @author Kevin Matamoros
 */
public class FilaCursor implements RowCursor{
    public ListaEnlazada tabla;
    public int posicion;
    
    
    public FilaCursor(int posicion,ListaEnlazada Tabla){
        this.posicion=posicion;
        this.tabla=Tabla;
        
    }
    @Override
    public RowMetaData getMetaData() {

        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getInteger(int index) throws IndexOutOfBoundsException, ClassCastException {
         tabla.goToPos(index);
         return (int) tabla.getElement();
    }

    @Override
    public boolean getBoolean(int index) throws IndexOutOfBoundsException, ClassCastException {
        tabla.goToPos(index);
        return (boolean) tabla.getElement();
    }

    @Override
    public double getDouble(int index) throws IndexOutOfBoundsException, ClassCastException {
        tabla.goToPos(index);
        return (double) tabla.getElement();
    }

    @Override
    public Date getDate(int index) throws IndexOutOfBoundsException, ClassCastException {
        tabla.goToPos(index);
        return (Date) tabla.getElement();
    }

    @Override
    public String getString(int index) throws IndexOutOfBoundsException {
        tabla.goToPos(index);
        return (String) tabla.getElement();
    }

    @Override
    public Object getObject(int index) throws IndexOutOfBoundsException {
        tabla.goToPos(index);
        return (Object) tabla.getElement();
    }

    @Override
    public boolean isNull(int index) throws IndexOutOfBoundsException {
        tabla.goToPos(index);
        if(tabla.getElement()==null){
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

    @Override
    public boolean next() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getCursorPosition() {
        return this.posicion;
    }

    @Override
    public void close() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DataStructure getType() {
        return DataStructure.DOUBLYLINKEDLIST;
    }
    
}
