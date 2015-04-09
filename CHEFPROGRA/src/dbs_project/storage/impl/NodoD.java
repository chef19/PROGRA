/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbs_project.storage.impl;

/**
 *
 * @author kevin
 */
public class NodoD<T> {
    public T element;
    public NodoD next;
    public NodoD after;
    
    public NodoD(){
        this.element=null;
        this.next=null;
    }
    public NodoD(T element){
        this.element=element;
        this.next=null;
    }
    public NodoD(NodoD after,T element){
        this.element=element;
        this.after=after;
    }
    public NodoD(T element,NodoD next){
        this.element=element;
        this.next=next;
    }
    public NodoD getNext(){
        return next;
    }
    public NodoD getAfter(){
        return after;
    }
    public T getElemento(){
        return element;
    }
    public void setElemento(T element){
        this.element=element;
    }
    public void setAfter(NodoD after){
        this.after=after;
    }
    public void setNext(NodoD next){
        this.next=next;
    }
    
}
