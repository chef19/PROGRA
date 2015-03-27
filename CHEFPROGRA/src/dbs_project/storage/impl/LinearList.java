package dbs_project.storage.impl;

public class LinearList implements LinearList{
    private Nodo head;
    private Nodo current;
    private Nodo tail;
    private int position;
    private int size;
    
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
    }
    public LinearList(){
        head=null;
        current=null;
        tail=null;
        size=0;
        position=-1;
    }
    
    public void insert(Object elemento){
        Nodo NuevoNodo = new Nodo(elemento, current.getNext());
        current.setNext(NuevoNodo);
        if(current==tail){
            tail=tail.getNext();
        }
        size++;
    }
    
    public void append(Object elemento){
        Nodo NuevoNodo = new Nodo(elemento);
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
    
    public void remove(){
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
    
    public Object getElement(){
        return current.getElemento();
    }
    
    public void next(){
        if (current == tail) {
            System.out.println("Ya esta en el ultimo elemento de la lista");
            return;
        }
        current = current.getNext();
        position++;
    }
    
    public void previous(){
        if (current == head) {
            System.out.println("Ya esta en el primer elemento de la lista");
            return;
	}
	Nodo temporal = head;
	position = -1;
	while (temporal.getNext() != current) {
            temporal = temporal.getNext();
            position++;
	}
	current = temporal;
    }
    
    public int getPosition(){
        return position;
    }
    
    public void goToStart(){
        position=-1;
        current=head;
    }
    
    public void goToEnd(){
        current=tail;
        position=size-1;
    }
    
    public void goToPos(int pos) {
        if (pos > position) {
                while (pos > position) {
                        this.next();
                }
        } else if (pos < position) {
                while (pos < position) {
                        previous();
                }
        }
    }
    
    public int getPositionOfElement(Object element) {
        Nodo temporal = head;
        int position = -1;
        while (temporal != null) {
            if (temporal.getElemento() != null && temporal.getElemento().equals(element)){
                return position;
            }
            temporal = temporal.getNext();
            position++;
        }
        return -1;
    }
    
    public static void main(String[] args) {
		System.out.println("**** LikedList");
		System.out.println("**** Agregando elementos....");
		LinearList lista = new LinearList();
		lista.append(9);
                System.out.println("añade 9");
		lista.append(11);
		System.out.println("añade 11");
		lista.append(13);
		System.out.println("añade 13");
                lista.goToStart();
		System.out.println(lista.getPosition());
		System.out.println(lista.getElement());
                lista.insert(8);
		System.out.println("añade 8");
                lista.insert(10);
		System.out.println("añade 10");
                lista.next();
                System.out.println(lista.getPosition());
		System.out.println(lista.getElement());               
    }
}
