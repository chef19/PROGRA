/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbs_project.storage.impl;

import com.sun.org.apache.bcel.internal.generic.Type;
import dbs_project.storage.Column;
import dbs_project.storage.ColumnMetaData;
import dbs_project.structures.DataStructure;
import dbs_project.structures.LinearDataStructure;
import java.util.Date;

/**
 *
 * @author max
 */
public class Columna implements Column{
    public ListaEnlazada Columna;
    public ColumnData Datos;
    
    public Columna(ListaEnlazada Columna){
        this.Columna = Columna;
        Datos=new ColumnData(Columna);
    }
    
    public ColumnMetaData getMetaData() {
        return Datos;
    }

    @Override
    public int getInteger(int index) throws IndexOutOfBoundsException, ClassCastException {
        Columna.goToPos(index);
        return (int) Columna.getElement();
    }

    @Override
    public boolean getBoolean(int index) throws IndexOutOfBoundsException, ClassCastException {
        Columna.goToPos(index);
        return (boolean) Columna.getElement();    
    }

    @Override
    public double getDouble(int index) throws IndexOutOfBoundsException, ClassCastException {
        Columna.goToPos(index);
        return (double) Columna.getElement();
    }

    @Override
    public Date getDate(int index) throws IndexOutOfBoundsException, ClassCastException {
        Columna.goToPos(index);
        if(Columna.getElement()==null){
            return null;
        }
        return (Date) Columna.getElement();
    }

    @Override
    public String getString(int index) throws IndexOutOfBoundsException {
        Columna.goToPos(index);
        if(Columna.getElement()==null){
            return null;
        }
        return (String) Columna.getElement();
    }

    @Override
    public Object getObject(int index) throws IndexOutOfBoundsException {
        Columna.goToPos(index);
        if(Columna.getElement()==null){
            return null;
        }
        return Columna.getElement();
    }

    @Override
    public boolean isNull(int index) throws IndexOutOfBoundsException {
        Columna.goToPos(index);
        if(Columna.getElement()==null){
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
