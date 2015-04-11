/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbs_project.storage.impl;

import dbs_project.storage.Type;
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
    public Type DataType;
    public static int ID;
    
    public Columna(ListaEnlazada Columna, String Name, Type DataType){
        this.Columna = Columna;
        Datos=new ColumnData(Columna, this.ID, Name, DataType);
        this.ID++;
    }
    
    public Columna(ListaEnlazada Columna, String Name, Type DataType, int ID){
        this.Columna = Columna;
        Datos=new ColumnData(Columna, ID, Name, DataType);
    }
    
    public ColumnMetaData getMetaData() {
        return Datos;
    }

    @Override
    public Integer getInteger(int index) throws IndexOutOfBoundsException, ClassCastException {
        Columna.goToPos(index);
        if (Columna.getElement()==null){
            return null;
        }
        return (int) Columna.getElement();
    }

    @Override
    public Boolean getBoolean(int index) throws IndexOutOfBoundsException, ClassCastException {
        Columna.goToPos(index);
        if (Columna.getElement()==null){
            return null;
        }
        return (boolean) Columna.getElement();    
    }

    @Override
    public Double getDouble(int index) throws IndexOutOfBoundsException, ClassCastException {
        Columna.goToPos(index);
        if (Columna.getElement()==null){
            return null;
        }
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
        Pila NuevaPila= new Pila();
        Cola NuevaCola= new Cola();
        ListaDobleEnlazada NuevaLista= new ListaDobleEnlazada();
        int i=0;
        if (type==DataStructure.STACK){
            while(i>Columna.size){
                NuevaPila.push(Columna.current);
                Columna.next();
                i++;
            }
            return NuevaPila;
        }
        else if (type==DataStructure.QUEUE){
            while(i>Columna.size){
                NuevaCola.enqueue(Columna.current);
                Columna.next();
                i++;
            }
            return NuevaCola;
        }
        else if (type==DataStructure.LINKEDLIST){
            return Columna;
        }
        else if (type==DataStructure.DOUBLYLINKEDLIST){
            while(i>Columna.size){
                NuevaLista.append(Columna.current);
                Columna.next();
                i++;
            }
            return NuevaLista;
        }
        return null;
    }
}
