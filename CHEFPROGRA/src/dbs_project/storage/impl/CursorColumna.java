/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbs_project.storage.impl;

import dbs_project.storage.ColumnCursor;
import dbs_project.storage.impl.Columna;
import dbs_project.storage.ColumnMetaData;
import dbs_project.structures.DataStructure;
import dbs_project.structures.LinearDataStructure;
import java.util.Date;

/**
 *
 * @author max
 */
public class CursorColumna implements ColumnCursor{

    public ListaEnlazada Columnas;
    public ListaEnlazada ColumnasFinal;
    public Columna Columna;
    
    public CursorColumna(ListaEnlazada Columnas){
        this.Columnas = Columnas;
        this.Columna=null;
        this.ColumnasFinal = new ListaEnlazada();
    }
    
    @Override
    public ColumnMetaData getMetaData() {
        Columna=(Columna) Columnas.current.getElemento();
        return Columna.getMetaData();
    }

    @Override
    public Integer getInteger(int index) throws IndexOutOfBoundsException, ClassCastException {
        Columna=(Columna) Columnas.current.getElemento();
        return Columna.getInteger(index);
    }

    @Override
    public Boolean getBoolean(int index) throws IndexOutOfBoundsException, ClassCastException {
        Columna=(Columna) Columnas.current.getElemento();
        return Columna.getBoolean(index);
    }

    @Override
    public Double getDouble(int index) throws IndexOutOfBoundsException, ClassCastException {
        Columna=(Columna) Columnas.current.getElemento();
        return Columna.getDouble(index);
    }

    @Override
    public Date getDate(int index) throws IndexOutOfBoundsException, ClassCastException {
        Columna=(Columna) Columnas.current.getElemento();
        return Columna.getDate(index);
    }

    @Override
    public String getString(int index) throws IndexOutOfBoundsException {
        Columna=(Columna) Columnas.current.getElemento();
        return Columna.getString(index);
    }

    @Override
    public Object getObject(int index) throws IndexOutOfBoundsException {
        Columna=(Columna) Columnas.current.getElemento();
        return Columna.getObject(index);
    }

    @Override
    public boolean isNull(int index) throws IndexOutOfBoundsException {
        Columna=(Columna) Columnas.current.getElemento();
        return Columna.isNull(index);
    }

    @Override
    public LinearDataStructure<?> asLinearDataStructure(DataStructure type) {
        Columna=(Columna) Columnas.current.getElemento();
        return Columna.asLinearDataStructure(type);
    }

    @Override
    public boolean next() {
        return Columnas.next();
    }

    @Override
    public int getCursorPosition() {
        return Columnas.position;
    }

    @Override
    public void close() {
        ColumnasFinal.append(Columnas.current.getElemento());
        Columnas = ColumnasFinal;
    }

    @Override
    public DataStructure getType() {
        return DataStructure.LINKEDLIST;
    }
    
}
