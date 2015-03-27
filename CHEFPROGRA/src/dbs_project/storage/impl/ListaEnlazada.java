/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbs_project.storage.impl;

import dbs_project.storage.impl.Nodo;
import dbs_project.structures.DataStructure;
import dbs_project.structures.LinearList;

/**
 *
 * @author max
 */
public class ListaEnlazada implements LinearList {
    private Nodo head;
    private Nodo current;
    private Nodo tail;
    private int position;
    private int size;
    
    public ListaEnlazada(){
        head=null;
        current=null;
        tail=null;
        size=0;
        position=-1;
    }
    
    public void insert(Object element) {
        Nodo NuevoNodo = new Nodo(element, current.getNext());
        if (size==0){
            current=NuevoNodo;
            tail=NuevoNodo;
            head=NuevoNodo;
        }
        current.setNext(NuevoNodo);
        if(current==tail){
            tail=tail.getNext();
        }
        size++;    
    }

    @Override
    public void append(Object element) {
        Nodo NuevoNodo = new Nodo(element);
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
        Nodo temporal = current;
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
    public Object getElement() {
        return current.getElemento();
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
	Nodo temporal = head;
	position = -1;
	while (temporal.getNext() != current) {
            temporal = temporal.getNext();
            position++;
	}
	current = temporal;
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
    public int getPositionOfElement(Object element) {
        Nodo temporal = head;
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
        this.head = this.tail = this.current = new Nodo();
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
