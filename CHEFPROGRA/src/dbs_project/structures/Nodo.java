/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbs_project.structures;

/**
 *
 * @author kevin
 */
public class Nodo {
    public Object element;
    public Nodo next;
    
    public Nodo(){
        this.element=null;
        this.next=null;
    }
    public Nodo(Object element){
        this.element=element;
        this.next=null;
    }
    public Nodo(Object element,Nodo next){
        this.element=element;
        this.next=next;
    }
    public Nodo getNext(){
        return next;
    }
    public Object getElemento(){
        return element;
    }
    public void setElemento(Object element){
        this.element=element;
    }
    public void setNext(Nodo next){
        this.next=next;
    }
    
    public static void main (String[] args){
        Nodo a=new Nodo(12);
        Nodo s=new Nodo(14);
        Nodo d=new Nodo(15);
        System.out.println(a.getElemento());
        a.setElemento(13);
        System.out.println(a.getElemento());
        a.setNext(s);
        System.out.println(s.getElemento()); 
        s.setNext(d);
        System.out.println(d.getElemento()); 
        System.out.println(d.getNext()); 
    }
    
}
