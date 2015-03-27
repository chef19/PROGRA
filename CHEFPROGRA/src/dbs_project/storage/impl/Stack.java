/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbs_project.storage.impl;

/**
 *
 * @author ricardo
 */
public class Stack <R>{
    public Nodo top;
    public int size;
    
    public Stack(){
        this.top=null;
        this.size=0;
    }
    
    public void push(R elemento){
        top=new Nodo(elemento,top);
        size++;
        System.out.println(elemento);
    }
    
    public R pop(){
        if(top==null || size==0){
            System.out.println("Pila vacia");
        }
        Object retornar =top.getElemento();
        top=top.getNext();
        size--;
        System.out.println(retornar);
        return (R) retornar;
    }
    
    public R getTop(){
        if(size==0){
            System.out.println("Pila vacia");
            return null;
        }
        else{
            System.out.println(top.getElemento());
            return (R) top.getElemento();
        }
    }
    
    public int getSize(){
        System.out.println(size);
        return size;
    }
    
    public boolean isEmpty(){
        if(top==null && size==0){
            System.out.println(true);
            return true;
        }
        else{
            System.out.println(false);
            return false;
        }
    }
    
    public void clear(){
        top=null;
        size=0;
    }
    
    public String toString(){
        String result = "Stack";
        Nodo temp = top;
        while(temp != null){
            result+= "\n" + temp.getElemento();
            temp = temp.getNext();
        }
        System.out.println(result);
        return result;
    }

    
    public static void main(String args[]){
        Stack a=new Stack();
        a.push(1);
        a.push(2);
        a.push(3);
        a.push(4);
        a.push(5);
        a.toString();
        a.pop();
        a.toString();
        a.getTop();
    }
}
