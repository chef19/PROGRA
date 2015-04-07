/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbs_project.storage.impl;

/**
 *
 * @author Kevin Matamoros
 */
public class ListaDeListasEnlazadas {
    public Nodo head;
    public Nodo current;
    public Nodo tail;
    public int position;
    public int size;
    
    public ListaDeListasEnlazadas(){
        head=null;
        current=null;
        tail=null;
        size=0;
        position=-1;
    }
    
    public void append(ListaEnlazada element) {
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


    public Object getElement() {
        return current.getElemento();
    }


    public boolean next() {
        if (current == tail) {
            return false;
        }
        current = current.getNext();
        position++;
        return true;
    }


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


    public int getPosition() {
        return position;
    }
    
    public int size() {
        return size;
    }
    
    
    
    
    
    
    
    }
    
    
