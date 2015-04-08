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
import org.apache.commons.collections.primitives.IntIterator;

/**
 *
 * @author Kevin Matamoros
 */
public class FilaCursor implements RowCursor{
    public  Fila fila;
    public ListaEnlazada Filas;
    
    
    public FilaCursor(ListaEnlazada Filas){
        this.fila=null;
        this.Filas=Filas;
        
    }
    @Override
    public RowMetaData getMetaData() {
        fila=(Fila) Filas.current.getElemento();
        return fila.getMetaData();
    }

    @Override
    public int getInteger(int index) throws IndexOutOfBoundsException, ClassCastException {
         fila=(Fila) Filas.current.getElemento();
         return (int) fila.getInteger(index);
    }

    @Override
    public boolean getBoolean(int index) throws IndexOutOfBoundsException, ClassCastException {
        fila=(Fila) Filas.current.getElemento();
        return (boolean) fila.getBoolean(index);
    }

    @Override
    public double getDouble(int index) throws IndexOutOfBoundsException, ClassCastException {
        fila=(Fila) Filas.current.getElemento();
        return (double) fila.getDouble(index);
    }

    @Override
    public Date getDate(int index) throws IndexOutOfBoundsException, ClassCastException {
        fila=(Fila) Filas.current.getElemento();
        return (Date) fila.getDate(index);
    }

    @Override
    public String getString(int index) throws IndexOutOfBoundsException {
        fila=(Fila) Filas.current.getElemento();
        return (String) fila.getString(index);
    }

    @Override
    public Object getObject(int index) throws IndexOutOfBoundsException {
        fila=(Fila) Filas.current.getElemento();
        return (Object) fila.getObject(index);
    }

    @Override
    public boolean isNull(int index) throws IndexOutOfBoundsException {
        fila=(Fila) Filas.current.getElemento();
        if(fila.isNull(index)){
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
     return Filas.next();
    }

    @Override
    public int getCursorPosition() {
        return Filas.getPosition();
    }

    @Override
    public void close() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DataStructure getType() {
        return DataStructure.LINKEDLIST;
    }
    public static void main(String[] args) {
        // TODO code application logic here
    ListaEnlazada asdf= new ListaEnlazada();
    asdf.append(1);
    asdf.append(2);
    asdf.append(3);
    asdf.append(4);
    asdf.append("Hola");
    FilaCursor F = new FilaCursor(asdf);
    System.out.println(F.getString(4));
    System.out.println(F.getCursorPosition());
    
    }
    
    
}
