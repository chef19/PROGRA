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
    public ListaEnlazada fila;
    public int ID;
    public IntIterator elementos;
    
    
    public FilaCursor(int ID,ListaEnlazada Fila){
        this.ID=ID;
        this.fila=Fila;
        this.elementos=elementos;
        
    }
    @Override
    public RowMetaData getMetaData() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getInteger(int index) throws IndexOutOfBoundsException, ClassCastException {
         fila.goToPos(index);
         return (int) fila.getElement();
    }

    @Override
    public boolean getBoolean(int index) throws IndexOutOfBoundsException, ClassCastException {
        fila.goToPos(index);
        return (boolean) fila.getElement();
    }

    @Override
    public double getDouble(int index) throws IndexOutOfBoundsException, ClassCastException {
        fila.goToPos(index);
        return (double) fila.getElement();
    }

    @Override
    public Date getDate(int index) throws IndexOutOfBoundsException, ClassCastException {
        fila.goToPos(index);
        return (Date) fila.getElement();
    }

    @Override
    public String getString(int index) throws IndexOutOfBoundsException {
        fila.goToPos(index);
        return (String) fila.getElement();
    }

    @Override
    public Object getObject(int index) throws IndexOutOfBoundsException {
        fila.goToPos(index);
        return (Object) fila.getElement();
    }

    @Override
    public boolean isNull(int index) throws IndexOutOfBoundsException {
        fila.goToPos(index);
        if(fila.getElement()==null){
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
        return elementos.hasNext();
    }

    @Override
    public int getCursorPosition() {
        return this.ID;
    }

    @Override
    public void close() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DataStructure getType() {
        return DataStructure.DOUBLYLINKEDLIST;
    }
    public static void main(String[] args) {
        // TODO code application logic here
    ListaEnlazada asdf= new ListaEnlazada();
    asdf.append(1);
    asdf.append(2);
    asdf.append(3);
    asdf.append(4);
    asdf.append(5);
    FilaCursor F = new FilaCursor(2,asdf);
    System.out.println(F.getInteger(3));
    }
    
    
}
