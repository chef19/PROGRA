/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbs_project.gui.impl;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import dbs_project.structures.Queue;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;

/**
 *
 * @author Kevin Matamoros
 */
public class interfaz extends javax.swing.JFrame {
modificando_tabla modifica=null;
DefaultTableModel modelo = new DefaultTableModel(); 
Queue Datos =null;
    /**
     * Creates new form interfaz
     */
    public interfaz() {
        initComponents();
        modifica = new modificando_tabla();
        /**modelo.addColumn("Name");
        modelo.addColumn("Street");
        modelo.addColumn("Number Street");
        modelo.addColumn("City");
        this.tabla.setModel(modelo);
        **/
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        btn_idTabla = new javax.swing.JButton();
        text_idTabla = new javax.swing.JTextField();
        btn_borrarTabla = new javax.swing.JButton();
        btn_visualizarMetadatos = new javax.swing.JButton();
        btn_nuevaColumna = new javax.swing.JButton();
        btn_nuevaFila = new javax.swing.JButton();
        btn_eliminarColumna = new javax.swing.JButton();
        btn_eliminarFila = new javax.swing.JButton();
        text_nombreColumna = new javax.swing.JTextField();
        btn_intCelda = new javax.swing.JButton();
        btn_intColumna = new javax.swing.JButton();
        valor = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Dato", "Dato", "Dato ", "Dato"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabla);

        btn_idTabla.setText("ID TABLA:");

        btn_borrarTabla.setText("BORRAR TABLA");
        btn_borrarTabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_borrarTablaActionPerformed(evt);
            }
        });

        btn_visualizarMetadatos.setText("VISUALIZAR METADATOS");

        btn_nuevaColumna.setText("NUEVA COLUMNA");
        btn_nuevaColumna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nuevaColumnaActionPerformed(evt);
            }
        });

        btn_nuevaFila.setText("NUEVA FILA");
        btn_nuevaFila.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nuevaFilaActionPerformed(evt);
            }
        });

        btn_eliminarColumna.setText("ELIMINAR COLUMNA");
        btn_eliminarColumna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarColumnaActionPerformed(evt);
            }
        });

        btn_eliminarFila.setText("ELIMINAR FILA");
        btn_eliminarFila.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarFilaActionPerformed(evt);
            }
        });

        btn_intCelda.setText("CELDA");
        btn_intCelda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_intCeldaActionPerformed(evt);
            }
        });

        btn_intColumna.setText("COLUMNA");
        btn_intColumna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_intColumnaActionPerformed(evt);
            }
        });

        valor.setText("VALOR");
        valor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                valorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_idTabla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_borrarTabla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_visualizarMetadatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(text_idTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 528, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_nuevaColumna, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_nuevaFila, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_eliminarColumna, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_eliminarFila, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(218, 218, 218)
                                .addComponent(btn_intCelda)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_intColumna)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(valor))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(text_nombreColumna, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_idTabla)
                            .addComponent(text_idTabla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btn_borrarTabla)
                        .addGap(18, 18, 18)
                        .addComponent(btn_visualizarMetadatos))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(132, 132, 132)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_nuevaColumna)
                    .addComponent(text_nombreColumna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btn_nuevaFila)
                .addGap(18, 18, 18)
                .addComponent(btn_eliminarColumna)
                .addGap(18, 18, 18)
                .addComponent(btn_eliminarFila)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_intCelda)
                    .addComponent(btn_intColumna)
                    .addComponent(valor))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_nuevaColumnaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nuevaColumnaActionPerformed
        // TODO add your handling code here:
        TableColumn col = new TableColumn(modelo.getColumnCount());
        Object nombre = text_nombreColumna.getText();
        System.out.println(nombre);
        //modelo.addColumn(nombre);
        col.setHeaderValue(nombre);
        tabla.addColumn(col);
    }//GEN-LAST:event_btn_nuevaColumnaActionPerformed

    private void btn_intCeldaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_intCeldaActionPerformed
        // TODO add your handling code here:
        modifica.mostrar_celdaelegida(tabla);
    }//GEN-LAST:event_btn_intCeldaActionPerformed

    private void btn_intColumnaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_intColumnaActionPerformed
        // TODO add your handling code here:
        modifica.mostrar_columnaelegida(tabla);
    }//GEN-LAST:event_btn_intColumnaActionPerformed

    private void valorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_valorActionPerformed
        // TODO add your handling code here:
        modifica.mostrar_valorcelda(tabla);
    }//GEN-LAST:event_valorActionPerformed

    private void btn_borrarTablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_borrarTablaActionPerformed
        // TODO add your handling code here:
        modifica.eliminar_tabla(tabla);
    }//GEN-LAST:event_btn_borrarTablaActionPerformed

    private void btn_eliminarColumnaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarColumnaActionPerformed
        // TODO add your handling code here:
        //hhhhhhhhh
        //jjjj
        int tem=tabla.getSelectedColumn();
        if (tem!=-1){
            tabla.removeColumn(tabla.getColumnModel().getColumn(tem));
        }
        else{
            JOptionPane.showMessageDialog(tabla, "No selecciono ninguna columna o no existen columnas!");
        }
        //nnkllllj
        //modifica.mostrar_columnaelegida(tabla);   
        /**
        System.out.println(tem);
        if (tem!=-1){
            modelo.columnRemoved
        (tabla.getColumnModel().getColumn(tem));
        }
        else{
            JOptionPane.showMessageDialog(tabla, "No selecciono ninguna columna o no existen columnas!");
        }
        **/
        //TableColumn column = tabla.getColumnModel().getColumn(tem);//me da la columna
    }//GEN-LAST:event_btn_eliminarColumnaActionPerformed

    private void btn_eliminarFilaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarFilaActionPerformed
        // TODO add your handling code here:
        modelo.removeRow(tabla.getSelectedRow());
    }//GEN-LAST:event_btn_eliminarFilaActionPerformed

    private void btn_nuevaFilaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nuevaFilaActionPerformed
        // TODO add your handling code here:
        String [] agrega={""};
        modelo.addRow(agrega);
    }//GEN-LAST:event_btn_nuevaFilaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new interfaz().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_borrarTabla;
    private javax.swing.JButton btn_eliminarColumna;
    private javax.swing.JButton btn_eliminarFila;
    private javax.swing.JButton btn_idTabla;
    private javax.swing.JButton btn_intCelda;
    private javax.swing.JButton btn_intColumna;
    private javax.swing.JButton btn_nuevaColumna;
    private javax.swing.JButton btn_nuevaFila;
    private javax.swing.JButton btn_visualizarMetadatos;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField text_idTabla;
    private javax.swing.JTextField text_nombreColumna;
    private javax.swing.JButton valor;
    // End of variables declaration//GEN-END:variables

    private void tablaaddColumn(TableColumn tableColumn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
