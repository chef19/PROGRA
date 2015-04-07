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
    public Tabla(){}
    
    @Override
    public void renameColumn(int columnId, String newColumnName) throws ColumnAlreadyExistsException, NoSuchColumnException {

    }

    @Override
    public int createColumn(String columnName, Type columnType) throws ColumnAlreadyExistsException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int addRow(Row row) throws SchemaMismatchException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteRows(IntIterator rowIDs) throws NoSuchRowException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateRow(int rowID, Row newRow) throws SchemaMismatchException, NoSuchRowException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ColumnCursor getColumns(DataStructure type) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
