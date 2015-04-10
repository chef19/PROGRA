/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbs_project.storage.impl;

import dbs_project.storage.ColumnMetaData;
import dbs_project.storage.TableMetaData;
import java.util.Map;

/**
 *
 * @author max
 */
public class TablaMetaData implements TableMetaData{

    public int ID;
    public String Name;
    
    public TablaMetaData(int ID, String Name){
        this.ID = ID;
        this.Name = Name;
    }
    
    @Override
    public Map<String, ColumnMetaData> getTableSchema() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getRowCount() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getId() {
        return ID;
    }

    @Override
    public String getName() {
        return Name;
    }
    
}
