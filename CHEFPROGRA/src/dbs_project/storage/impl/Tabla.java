/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbs_project.storage.impl;

import dbs_project.exceptions.ColumnAlreadyExistsException;
import dbs_project.exceptions.NoSuchColumnException;
import dbs_project.exceptions.NoSuchRowException;
import dbs_project.exceptions.SchemaMismatchException;
import dbs_project.storage.Column;
import dbs_project.storage.ColumnCursor;
import dbs_project.storage.Row;
import dbs_project.storage.RowCursor;
import dbs_project.storage.Table;
import dbs_project.storage.TableMetaData;
import dbs_project.storage.Type;
import dbs_project.structures.DataStructure;
import org.apache.commons.collections.primitives.IntIterator;

/**
 *
 * @author Kevin Matamoros
 */
public class Tabla implements Table{
    static ListaEnlazada Fil;
    CursorColumna ColumnaCursor;
    static ListaEnlazada Columnas;
    FilaCursor FilCursor;
    
    public Row Fila;
        
    
    public Tabla(){
        Fil = new ListaEnlazada();
    }
    public Tabla(Row fila){

        this.Fila=fila;
        
        
        
    }
    @Override
    public void renameColumn(int columnId, String newColumnName) throws ColumnAlreadyExistsException, NoSuchColumnException {
        
    }

    @Override
    public int createColumn(String columnName, Type columnType) throws ColumnAlreadyExistsException {
        ListaEnlazada Lista = new ListaEnlazada();
        Columna Columna = new Columna(Lista, columnName, columnType);
        return(Columna.Datos.getId());
    }

    @Override
    public int addRow(Row row) throws SchemaMismatchException {
        Fil.append(row);
        return row.getMetaData().getId();
    }

    @Override
    public IntIterator addRows(RowCursor rows) throws SchemaMismatchException {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int addColumn(Column column) throws SchemaMismatchException, ColumnAlreadyExistsException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IntIterator addColumns(ColumnCursor columns) throws SchemaMismatchException, ColumnAlreadyExistsException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteRow(int rowID) throws NoSuchRowException {
        int i=0;
        while(i<Fil.size()){
            Fila temp=(Fila) Fil.current.getElemento();
            if(temp.getMetaData().getId()==rowID){
                Fil.remove();
                Fil.goToStart();
            }
            Fil.next();
        }
        
        
        /**FilCursor = new FilaCursor(Fil);
        Fil.current.
        for(int i=0;FilCursor.getMetaData().getId()==rowID;i++){
            if(i==FilCursor.Filas.size()){
                return;
            }
            FilCursor.next();
        }
        int temp;
        temp= (int) FilCursor.Filas.getPosition();    
        Fil.goToPos(temp);
        Fil.remove();
        FilCursor = new FilaCursor(Fil);**/
    }

    @Override
    public void deleteRows(IntIterator rowIDs) throws NoSuchRowException {
        while(rowIDs.hasNext()==true){
            Fil.remove();
            rowIDs.next();
        }
    }

    @Override
    public void dropColumn(int columnId) throws NoSuchColumnException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void dropColumns(IntIterator columnIds) throws NoSuchColumnException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Column getColumn(int columnId) throws NoSuchColumnException {
        ColumnaCursor = new CursorColumna(Columnas);
        Columna Columna;
        int i=0;
        while(i<=ColumnaCursor.Columnas.size()){
            Columna= (Columna) ColumnaCursor.Columnas.current.getElemento();
            if (Columna.getMetaData().getId()==columnId){
                return Columna;
            }
            else{
                ColumnaCursor.next();
                i++;
            }
        }
        return null;
    }

    @Override
    public ColumnCursor getColumns(DataStructure type, IntIterator columnIds) throws NoSuchColumnException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public RowCursor getRows(DataStructure type, IntIterator rowIds) throws NoSuchRowException {
        FilCursor = new FilaCursor(Fil);
        return FilCursor;
    }

    @Override
    public Row getRow(int rowId) throws NoSuchRowException {
        FilCursor = new FilaCursor(Fil);
        for(int i=0;FilCursor.getMetaData().getId()==rowId;i++){
            if(i==FilCursor.Filas.size()){
                return null;
            }
            FilCursor.next();
        }
        return (Row) FilCursor.Filas.current.getElemento();
    }

    @Override
    public void updateRow(int rowID,Row newRow) throws SchemaMismatchException, NoSuchRowException {
        Fil.goToPos(rowID);
        
    }
    @Override
    public void updateRows(IntIterator rowIDs, RowCursor newRows) throws SchemaMismatchException, NoSuchRowException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateColumns(IntIterator columnIDs, ColumnCursor updateColumns) throws SchemaMismatchException, NoSuchColumnException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateColumn(int columnId, Column updateColumn) throws SchemaMismatchException, NoSuchColumnException {
        ColumnaCursor = new CursorColumna(Columnas);
        Columna Columna;
        int i=0;
        while(i<=ColumnaCursor.Columnas.size()){
            Columna= (Columna) ColumnaCursor.Columnas.current.getElemento();
            if (Columna.getMetaData().getId()==columnId){
                ColumnaCursor.Columnas.current.setElemento(updateColumn);
                return;
            }
            else{
                ColumnaCursor.next();
                i++;
            }
        }
    }

    @Override
    public TableMetaData getTableMetaData() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public RowCursor getRows(DataStructure type) {
        if(type==DataStructure.DOUBLYLINKEDLIST){
            return null;
        }
        if(type==DataStructure.LINKEDLIST){
            return null;
        }
        if(type==DataStructure.QUEUE){
            return null;
        }
        if(type==DataStructure.STACK){
            return null;
        }
        return null;
    }

    @Override
    public ColumnCursor getColumns(DataStructure type) {
        if(type==DataStructure.DOUBLYLINKEDLIST){
            return null;
        }
        if(type==DataStructure.LINKEDLIST){
            return null;
        }
        if(type==DataStructure.QUEUE){
            return null;
        }
        if(type==DataStructure.STACK){
            return null;
        }
        return null;
    }
    public static void main(String[] args) throws SchemaMismatchException, NoSuchRowException {
        // TODO code application logic here
    ListaEnlazada Lista1= new ListaEnlazada();
    ListaEnlazada Lista2= new ListaEnlazada();
    ListaEnlazada Lista3= new ListaEnlazada();
    ListaEnlazada Lista4= new ListaEnlazada();
    ListaEnlazada FilasD= new ListaEnlazada();
    //*********************
    Lista1.append(1);
    Lista1.append(2);
    //*********************
    Lista2.append(3);
    Lista2.append(4);
    Lista2.append(5);
    Lista2.append(6);
    //*********************
    Lista3.append(7);
    //*********************
    Lista4.append(8);
    Lista4.append(9);
    Lista4.append(10);
    //*********************
    Tabla tabla=new Tabla();
    //*********************
    Fila Fila1 =new Fila(Lista1);
    Fila Fila2 =new Fila(Lista2);
    Fila Fila3 =new Fila(Lista3);
    Fila Fila4 =new Fila(Lista4);
    FilasD.append(Fila1);
    FilasD.append(Fila2);
    FilasD.append(Fila3);
    FilasD.append(Fila4);
    //*********************
    System.out.println("Añade Fila3");
    System.out.println(tabla.addRow(Fila3));
    
    System.out.println("Añade Fila1");
    System.out.println(tabla.addRow(Fila1));
    
    System.out.println("Añade Fila2");
    System.out.println(tabla.addRow(Fila2));
    
    System.out.println("Añade Fila4");
    System.out.println(tabla.addRow(Fila4));
    //*********************
    System.out.println("Cantidad de Filas");
    System.out.println(Fil.size());
    //*********************
    FilaCursor Cursor = new FilaCursor(Fil);
    System.out.println("Posicion Cursor");
    System.out.println(Cursor.getCursorPosition());
    System.out.println(Cursor.getMetaData().getId());
    System.out.println("Posicion "+ Cursor.Filas.getPosition());
    System.out.println("Posicion Fil"+ Fil.getPosition());
    
    Cursor.next();
    System.out.println("Posicion "+ Cursor.Filas.getPosition());
    System.out.println("Posicion Fil"+ Fil.getPosition());
    System.out.println(Cursor.Filas.current.getElemento());
    System.out.println("Busq ID2  "+tabla.getRow(1));
    //*********************
    System.out.println("Eliminar");
    tabla.deleteRow(3);
    System.out.println(Fil.size());
    
    //*********************
    }
}
 