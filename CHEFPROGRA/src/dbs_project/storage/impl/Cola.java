/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbs_project.storage.impl;

import dbs_project.structures.DataStructure;
import dbs_project.structures.Queue;

/**
 *
 * @author Kevin Matamoros
 */
public class Cola implements Queue{

    public Nodo front;
    public Nodo rear;
    public Nodo current;
    public int size;
    public int pos;
    
    public Cola(){
        front = new Nodo();
        current=front;
        rear = current;
        size=0;        
    }
    
    @Override
    public void enqueue(Object element) {
        if (size==0){
            Nodo newN = new Nodo(element);
            front.setNext(newN);
            System.out.println(newN.getElemento());
            rear=newN;
            size++;
        }
    }

    @Override
    public Object dequeue() {
         if (size==0){
            System.out.println("Cola se encuentra vacia");
        }
        else{      
            System.out.println(front.getElemento());
            front=front.getNext();
            size--;
        }
        return  front.getElemento();
    }

    @Override
    public Object first() {
        if(front.getElemento()==null){
            System.out.println(front.getNext().getElemento());
        }
        else{
            System.out.println(front.getElemento());
        }
        return front.getElemento();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        front = new Nodo();
        current=front;
        rear = current;
        size=0;
    }

    @Override
    public DataStructure getType() {
        return DataStructure.QUEUE;
    }

    @Override
    public boolean isEmpty() {
        if(size==0){
            return true;
        }
        else{
            return false;
        }
    }
    
}
