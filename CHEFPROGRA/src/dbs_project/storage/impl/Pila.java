/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbs_project.storage.impl;

import dbs_project.structures.DataStructure;
import dbs_project.structures.Stack;

/**
 *
 * @author max
 */
public class Pila<T> implements Stack<T>{
    public Nodo top;
    public int size;
    
    public Pila(){
        this.top=null;
        this.size=0;
    }
    
    @Override
    public void push(T element) {
        top=new Nodo(element,top);
        size++;
        System.out.println(element);
    }

    @Override
    public T pop() {
        if(top==null || size==0){
            System.out.println("Pila vacia");
        }
        Object retornar =top.getElemento();
        top=top.getNext();
        size--;
        System.out.println(retornar);
        return (T) retornar;    
    }

    @Override
    public T top() {
        if(size==0){
            System.out.println("Pila vacia");
            return null;
        }
        else{
            System.out.println(top.getElemento());
            return (T) top.getElemento();
        }    
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        top=null;
        size=0;
    }

    @Override
    public DataStructure getType() {
        return DataStructure.STACK;
    }

    @Override
    public boolean isEmpty() {
        if(top==null && size==0){
            System.out.println(true);
            return true;
        }
        else{
            System.out.println(false);
            return false;
        }
    } 
}
