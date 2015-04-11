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
    ListaEnlazada ListaNames;
    ListaEnlazada ListaMetaDatas;
    static ListaEnlazada Columnas;
    FilaCursor FilCursor;
    
    public Row Fila;
        
    
    public Tabla(){
        Fil = new ListaEnlazada();
        Columnas = new ListaEnlazada();
        ColumnaCursor = new CursorColumna(Columnas);
        ListaNames = new ListaEnlazada();
        ListaMetaDatas = new ListaEnlazada();
    }
    public Tabla(Row fila){

        this.Fila=fila;
        
        
        
    }
    @Override
    public void renameColumn(int columnId, String newColumnName) throws ColumnAlreadyExistsException, NoSuchColumnException {
        ColumnaCursor = new CursorColumna(Columnas);
        Columna Columna;
        Columna NuevaColumna;
        int i=0;
        while(i<=ColumnaCursor.Columnas.size()){
            Columna= (Columna) ColumnaCursor.Columnas.current.getElemento();
            if (Columna.getMetaData().getId()==columnId){
                NuevaColumna = new Columna(Columna.Columna, newColumnName, 
                        Columna.getMetaData().getType(), Columna.getMetaData().getId());
                ColumnaCursor.Columnas.current.setElemento(NuevaColumna);
                return;
            }
            else{
                ColumnaCursor.next();
                i++;
            }
        }
    }

    @Override
    public int createColumn(String columnName, Type columnType) throws ColumnAlreadyExistsException {
        ListaEnlazada Lista = new ListaEnlazada();
        Columna Columna = new Columna(Lista, columnName, columnType);
        ColumnaCursor.Columnas.append(Columna);
        ListaNames.append(columnName);
        ListaMetaDatas.append(Columna.getMetaData());
        return(Columna.getMetaData().getId());
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
        Columnas.append(column);
        ListaNames.append(column.getMetaData().getName());
        ListaMetaDatas.append(column.getMetaData());
        return(column.getMetaData().getId());
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
        ColumnaCursor = new CursorColumna(Columnas);
        Columna Columna;
        int i=0;
        while(i<=ColumnaCursor.Columnas.size()){
            Columna= (Columna) ColumnaCursor.Columnas.current.getElemento();
            if (Columna.getMetaData().getId()==columnId){
                ListaNames.goToPos(i);
                ListaMetaDatas.goToPos(i);
                ListaNames.remove();
                ListaMetaDatas.remove();
                ColumnaCursor.Columnas.remove();
                return;
            }
            else{
                ColumnaCursor.next();
                i++;
            }
        }
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
                ColumnaCursor.Columnas.goToPos(i-1);
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
            ColumnaCursor.Columnas.goToPos(i-1);
            Columna= (Columna) ColumnaCursor.Columnas.current.getElemento();
            if (Columna.getMetaData().getId()==columnId){
                ListaNames.goToPos(i);
                ListaNames.current.setElemento(updateColumn.getMetaData().getName());
                ColumnaCursor.Columnas.current.setElemento(updateColumn);
                ListaMetaDatas.goToPos(i);
                ListaMetaDatas.current.setElemento(updateColumn.getMetaData());
                return;
            }
            else{
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
    public static void main(String[] args) throws SchemaMismatchException, NoSuchRowException, ColumnAlreadyExistsException, NoSuchColumnException {
        // TODO code application logic here
        Tabla Tabla = new Tabla();
        ListaEnlazada Lista1= new ListaEnlazada();
        ListaEnlazada Lista2= new ListaEnlazada();
        ListaEnlazada Lista3= new ListaEnlazada();
        ListaEnlazada Lista4= new ListaEnlazada();
        //*********************
        Lista1.append(1);
        Lista1.append(2);
        Lista1.append(3);
        //*********************
        Lista2.append(4);
        Lista2.append(5);
        Lista2.append(6);
        //*********************
        Lista3.append(7);
        Lista3.append(8);
        Lista3.append(9);
        //*********************
        Lista4.append(10);
        Lista4.append(11);
        Lista4.append(12);
        //*********************
        Columna Columna1 =new Columna(Lista1, "1 a 3", Type.INTEGER);
        Columna Columna2 =new Columna(Lista2, "4 a 6", Type.INTEGER);
        Columna Columna3 =new Columna(Lista3, "7 a 9", Type.INTEGER);
        Columna Columna4 =new Columna(Lista4, "10 a 12", Type.INTEGER);
        //*********************
        System.out.println("se añade Columna 1 a 3");
        System.out.println(Tabla.addColumn(Columna1));
        
        System.out.println("se añade Columna 4 a 6");
        System.out.println(Tabla.addColumn(Columna2));
        
        System.out.println("se añade Columna 10 a 12");
        System.out.println(Tabla.addColumn(Columna4));
        
        System.out.println("se añade Columna 7 a 9");
        System.out.println(Tabla.addColumn(Columna3));
        //*********************
        /**
        System.out.println("se cambia el nombre de la Columna '7 a 9' a '9 a 7'");
        System.out.println(Tabla.getColumn(3).getMetaData().getName());
        Tabla.renameColumn(2, "9 a 7");
        System.out.println("ya se cambio");
        System.out.println(Tabla.getColumn(3).getMetaData().getName());
        **/
        System.out.println("********************************");
        CursorColumna Cursor = new CursorColumna(Columnas);
        System.out.println(Cursor.getMetaData().getName());
        System.out.println(Cursor.next());
        System.out.println(Cursor.getMetaData().getName());
        System.out.println(Cursor.next());
        System.out.println(Cursor.getMetaData().getName());
        System.out.println(Cursor.next());
        System.out.println(Cursor.getMetaData().getName());
        System.out.println("********************************");
        //*********************
        System.out.println("Se busca Columna '1 a 3'");
        System.out.println(Tabla.getColumn(0).getMetaData().getName());
        System.out.println("Se busca Columna '10 a 12'");
        System.out.println(Tabla.getColumn(3).getMetaData().getName());
        System.out.println("********************************");
        //*********************
        System.out.println("Se elimina '10 a 12'");
        Tabla.dropColumn(3);
        System.out.println(Tabla.Columnas.size());
        System.out.println("********************************");
        //*********************
        System.out.println("Se actualiza '1 a 3' con los valores 13,14,15");
        ListaEnlazada ListaNueva= new ListaEnlazada();
        ListaNueva.append(13);
        ListaNueva.append(14);
        ListaNueva.append(15);
        Columna ColumnaNueva = new Columna(ListaNueva, "13 a 15", Type.INTEGER, 1);
        Tabla.updateColumn(1, ColumnaNueva);
        System.out.println(Tabla.getColumn(1).getMetaData().getName());
    /**ListaEnlazada Lista1= new ListaEnlazada();
    ListaEnlazada Lista2= new ListaEnlazada();
    ListaEnlazada Lista3= new ListaEnlazada();
    ListaEnlazada Lista4= new ListaEnlazada();
    ListaEnlazada ColumnasD= new ListaEnlazada();
    //*********************
    Lista1.append(1);
    Lista1.append(2);
    Lista1.append(3);
    //*********************
    Lista2.append(4);
    Lista2.append(5);
    Lista2.append(6);
    //*********************
    Lista3.append(7);
    Lista3.append(8);
    Lista3.append(9);
    //*********************
    Lista4.append(10);
    Lista4.append(11);
    Lista4.append(12);
    //*********************
    Tabla tabla=new Tabla();
    //*********************
    Columna Columna1 =new Columna(Lista1, "1 a 3", Type.INTEGER);
    Columna Columna2 =new Columna(Lista2, "4 a 6", Type.INTEGER);
    Columna Columna3 =new Columna(Lista3, "7 a 9", Type.INTEGER);
    Columna Columna4 =new Columna(Lista4, "10 a 12", Type.INTEGER);
    ColumnasD.append(Columna1);
    ColumnasD.append(Columna2);
    ColumnasD.append(Columna3);
    ColumnasD.append(Columna4);
    //*********************
    System.out.println("Añade Columna3");
    System.out.println(tabla.addRow(Columna3));
    
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
    
    
    Cursor.next();
    System.out.println(Cursor.Filas.current.getElemento());
    System.out.println("Busq ID2  "+tabla.getRow(1));
    //*********************
    **/
    }
}
 