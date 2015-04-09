/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbs_project.storage.impl;

import dbs_project.structures.DataStructure;
import dbs_project.structures.LinearList;

/**
 *
 * @author Kevin Matamoros
 */
public class ListaDobleEnlazada<T> implements LinearList<T> {

    public NodoD head;
    public NodoD current;
    public NodoD tail;
    public int position;
    public int size;
    
    public ListaDobleEnlazada(){
        head=null;
        current=null;
        tail=null;
        size=0;
        position=-1;
    }
    @Override
    public void insert(T element) {
        NodoD NuevoNodo = new NodoD(element, current.getNext());
        if (size==0){
            current=NuevoNodo;
            tail=NuevoNodo;
            head=NuevoNodo;
        }
        NodoD temp=current;
        current.setNext(NuevoNodo);
        current.setAfter(temp);
        if(current==tail){
            tail=tail.getNext();
        }
        size++;    
    }

    @Override
    public void append(T element) {
        NodoD NuevoNodo = new NodoD(element);
	if (size == 0){
            tail=NuevoNodo;
            head=NuevoNodo;
            current=NuevoNodo;
            size++;
            position++;
            return;
	}
        tail.setNext(NuevoNodo);
        tail=tail.getNext();
        size++;    
    }

    @Override
    public void remove() {
        if (size==0){
            System.out.println("Lista vacía");
            return;
        }
        NodoD temporal = current;
	previous();
	if (temporal == tail) {
            current.setNext(null);
            current = tail; 
            this.position--;
            this.size--;
            return;
	}	
        current.setNext(temporal.getNext());
	this.size--;
    }

    @Override
    public T getElement() {
        return (T) current.getElemento();
    }

    @Override
    public boolean next() {
        if (current == tail) {
            return false;
        }
        current = current.getNext();
        position++;
        return true;
    }

    @Override
    public boolean previous() {
        if (current == head) {
            return false;
	}
	current=current.getAfter();
        position--;
        return true;
    }

    @Override
    public int getPosition() {
        return position;
    }

    @Override
    public void goToStart() {
        position=-1;
        current=head;
    }

    @Override
    public void goToEnd() {
        current=tail;
        position=size-1;
    }

    @Override
    public void goToPos(int pos) throws IndexOutOfBoundsException {
        if (pos > position) {
            while (pos > position) {
                this.next();
            }
        } 
        else if (pos < position) {
            while (pos < position) {
                previous();
            }
        }
    }

    @Override
    public int getPositionOfElement(T element) {
        NodoD temporal = head;
        int position= -1;
        while (temporal != null) {
            if (temporal.getElemento() != null && temporal.getElemento().equals(element)){
                return position;
            }
            temporal = temporal.getNext();
            position++;
        }
        return -1;
    }

    @Override
    public DataStructure getType() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        this.head = this.tail = this.current = new NodoD();
        this.position = -1;
        this.size = 0;    
    }

    @Override
    public boolean isEmpty() {
        if (size == 0){
            return true;
        }
        return false;
    }
    
}
