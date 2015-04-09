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
 *@author Kevin Matamoros
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
        return fila.isNull(index);
        
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
    ListaEnlazada Lista1= new ListaEnlazada();
    ListaEnlazada Lista2= new ListaEnlazada();
    ListaEnlazada Lista3= new ListaEnlazada();
    
    Lista1.append(1);
    Lista1.append(2);
    
    Lista2.append(3);
    Lista2.append(4);
    Lista2.append(5);
    Lista2.append(6);
    
    Lista3.append(6);
    
    Fila Fila1=new Fila(Lista1);
    Fila Fila2=new Fila(Lista2);
    Fila Fila3=new Fila(Lista3);
    
    ListaEnlazada Filas= new ListaEnlazada();
    Filas.append(Fila1);
    Filas.append(Fila2);
    Filas.append(Fila3);
    
    FilaCursor Cursor = new FilaCursor(Filas);
    
    
    System.out.println("Posicion: "+Cursor.getCursorPosition());
    System.out.println("Valor: "+Cursor.getInteger(1));
    System.out.println("Columnas de Fila: "+Cursor.getMetaData().getColumnCount());
    System.out.println("ID Fila: "+Cursor.getMetaData().getId());
    System.out.println("");
    
    Cursor.next();
    System.out.println("Posicion: "+Cursor.getCursorPosition());
    System.out.println("Valor: "+Cursor.getInteger(1));
    System.out.println("Columnas de Fila: "+Cursor.getMetaData().getColumnCount());
    System.out.println("ID Fila: "+Cursor.getMetaData().getId());
    System.out.println("");
    
    Cursor.next();
    System.out.println("Posicion: "+Cursor.getCursorPosition());
    System.out.println("Valor: "+Cursor.getInteger(0));
    System.out.println("Columnas de Fila: "+Cursor.getMetaData().getColumnCount());
    System.out.println("ID Fila: "+Cursor.getMetaData().getId());
    

    }
    
    
}
