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
public class Pila implements Stack{
    public Nodo top;
    public int size;
    
    public Pila(){
        this.top=null;
        this.size=0;
    }
    
    @Override
    public void push(Object element) {
        top=new Nodo(element,top);
        size++;
        System.out.println(element);
    }

    @Override
    public Object pop() {
        if(top==null || size==0){
            System.out.println("Pila vacia");
        }
        Object retornar =top.getElemento();
        top=top.getNext();
        size--;
        System.out.println(retornar);
        return retornar;    
    }

    @Override
    public Object top() {
        if(size==0){
            System.out.println("Pila vacia");
            return null;
        }
        else{
            System.out.println(top.getElemento());
            return top.getElemento();
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
