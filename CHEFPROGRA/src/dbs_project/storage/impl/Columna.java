/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbs_project.storage.impl;

import dbs_project.storage.Column;
import dbs_project.storage.ColumnMetaData;
import dbs_project.structures.DataStructure;
import dbs_project.structures.LinearDataStructure;
import java.util.Date;

/**
 *
 * @author max
 */
public class Columna <T> implements Column{
    public ListaEnlazada Columna;

    public Columna(){
        Columna = new ListaEnlazada();    
    }
    
    public void añadir(T Elemento){
        Columna.append(Elemento);
    }
    
    public void cambiar(int posicion,T Elemento){
        Columna.goToPos(posicion);
        Columna.current.setElemento(Elemento);
    }
    
    public ColumnMetaData getMetaData() {
        int i=0;
        Columna.goToStart();
        if (Columna.size==0){
            return null;
        }
        while (i<Columna.size){
            System.out.println(Columna.getElement());
            Columna.next();
            i++;
        }
    }

    @Override
    public int getInteger(int index) throws IndexOutOfBoundsException, ClassCastException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean getBoolean(int index) throws IndexOutOfBoundsException, ClassCastException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double getDouble(int index) throws IndexOutOfBoundsException, ClassCastException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Date getDate(int index) throws IndexOutOfBoundsException, ClassCastException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getString(int index) throws IndexOutOfBoundsException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getObject(int index) throws IndexOutOfBoundsException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isNull(int index) throws IndexOutOfBoundsException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public LinearDataStructure<?> asLinearDataStructure(DataStructure type) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
