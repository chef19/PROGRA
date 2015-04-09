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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        Fil.goToPos(rowID);
        Fil.remove();
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ColumnCursor getColumns(DataStructure type, IntIterator columnIds) throws NoSuchColumnException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public RowCursor getRows(DataStructure type, IntIterator rowIds) throws NoSuchRowException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Row getRow(int rowId) throws NoSuchRowException {
        Fil.goToPos(rowId);
        return (Fila) Fil.getElement();
    }

    @Override
    public void updateRow(int rowID, Row newRow) throws SchemaMismatchException, NoSuchRowException {
        if(rowID>Fil.size()){
            
        }
        
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TableMetaData getTableMetaData() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public RowCursor getRows(DataStructure type) {
        //return Fila
        return null;
    }

    @Override
    public ColumnCursor getColumns(DataStructure type) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public static void main(String[] args) throws SchemaMismatchException, NoSuchRowException {
        // TODO code application logic here
    ListaEnlazada Lista1= new ListaEnlazada();
    ListaEnlazada Lista2= new ListaEnlazada();
    ListaEnlazada Lista3= new ListaEnlazada();
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
    Tabla tabla=new Tabla();
    //*********************
    Fila Fila1 =new Fila(Lista1);
    Fila Fila2 =new Fila(Lista2);
    Fila Fila3 =new Fila(Lista3);
    //*********************
    System.out.println("Añade Fila3");
    System.out.println(tabla.addRow(Fila3));
    
    System.out.println("Añade Fila1");
    System.out.println(tabla.addRow(Fila1));
    
    System.out.println("Añade Fila2");
    System.out.println(tabla.addRow(Fila2));
    //*********************
    System.out.println("Cantidad de Filas");
    System.out.println(Fil.size());
    //*********************
    System.out.println("ObtenerFila");
    System.out.println(tabla.getRow(0));
    
    }
}
