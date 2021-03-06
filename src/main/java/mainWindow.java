/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;

/**
 *
 * @author Iga
 */
public class mainWindow extends javax.swing.JFrame implements ActionListener {

    // LISTA MIAST
    List<City> cityList = new ArrayList<>();

    DefaultListModel listModel;

    public mainWindow() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addCityButton = new javax.swing.JButton();
        deleteCityButton = new javax.swing.JButton();
        hourCalculationButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        temperaturePanel = new javax.swing.JTextArea();
        author = new javax.swing.JLabel();
        addCityLabel = new javax.swing.JLabel();
        cityNameTextField = new javax.swing.JTextField();
        errorLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        cityText = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        cityCB = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        addCityButton.setText("Dodaj");
        addCityButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCityButtonActionPerformed(evt);
            }
        });

        deleteCityButton.setText("Usuń");
        deleteCityButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteCityButtonActionPerformed(evt);
            }
        });

        hourCalculationButton.setText("Godziny");
        hourCalculationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hourCalculationButtonActionPerformed(evt);
            }
        });

        temperaturePanel.setColumns(20);
        temperaturePanel.setRows(5);
        jScrollPane2.setViewportView(temperaturePanel);

        author.setText("Iga Boryczka");

        addCityLabel.setText("Dodaj miasto:");

        cityNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cityNameTextFieldActionPerformed(evt);
            }
        });

        cityText.setColumns(20);
        cityText.setRows(5);
        jScrollPane1.setViewportView(cityText);

        jLabel1.setText("Wybierz miasto:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(author))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(addCityButton, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(34, 34, 34)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(hourCalculationButton)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(addCityLabel)
                                        .addGap(18, 18, 18)
                                        .addComponent(errorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(cityNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(36, 36, 36)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(cityCB, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(deleteCityButton, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 30, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addCityLabel)
                    .addComponent(errorLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cityNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cityCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addCityButton)
                    .addComponent(deleteCityButton)
                    .addComponent(hourCalculationButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(author)
                .addGap(5, 5, 5))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addCityButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCityButtonActionPerformed

        String cityToDownload = this.cityNameTextField.getText();
        City cityToReturn = new City();

        Map<String, double[]> dataMap = new HashMap<>();
        DataRetriever[] dr = new DataRetriever[2];
        dr[0] = new DataRetrieverWunderground();
        dr[1] = new DataRetrieverForecastIO();
        // pobranie parametrów miasta
        cityToReturn = dr[0].getCity(cityToDownload);

        List<Map<String, double[]>> dataList = new ArrayList<>();
        for (int i = 0; i < dr.length; i++) {
            dataList.add(dr[i].getData(cityToReturn));
        }

        DataEditor de = new DataEditor();
        cityToReturn.temperatureData = de.mergeData(dataList);
        cityToReturn.meanTemperature = de.calculateMeanDaily(cityToReturn.temperatureData);

        cityList.add(cityToReturn);

        //ustawienie listingu - miasta
        String text = "";
        String textTemp = "";
        for (int i = 0; i < cityList.size(); i++) {
            //nazwy miast
            text += cityList.get(i).name + '\n';
            //tamperatura
            Map<String, Double> tempData = cityList.get(i).meanTemperature;
            //iteracja po mapie, dodanie wartości
            Set<String> keySet = tempData.keySet();
            String key;
            Iterator<String> it = keySet.iterator();
            while (it.hasNext()) {
                key = it.next();
                textTemp += key + ": " + tempData.get(key) + "   |   ";
            }
            textTemp += '\n';
        }
        this.cityText.setText(text);
        this.temperaturePanel.setText(textTemp);

        this.cityCB.addItem(cityToDownload);
        
        DataSaver ds = new DataSaver();
        try {
            ds.saveData(this.cityList);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(mainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_addCityButtonActionPerformed

    private void hourCalculationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hourCalculationButtonActionPerformed
        // TODO add your handling code here:

        HourTemperature hourlyWindow = new HourTemperature(this.cityList);
        hourlyWindow.setResizable(false);
        hourlyWindow.setVisible(true);

    }//GEN-LAST:event_hourCalculationButtonActionPerformed

    private void cityNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cityNameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cityNameTextFieldActionPerformed

    private void deleteCityButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteCityButtonActionPerformed

        Object toDelete = this.cityCB.getSelectedItem();
        String cityToDelete = (String) toDelete;
        int index;
        // usun miasto z listy
        for (int i = 0; i < this.cityList.size(); i++) {
            if (this.cityList.get(i).name == cityToDelete) {
                index = i;
                this.cityList.remove(index);
            }
        }

        // redraws
        String text = "";
        String textTemp = "";
        for (int i = 0; i < cityList.size(); i++) {
            //nazwy miast
            text += cityList.get(i).name + '\n';
            //tamperatura
            Map<String, Double> tempData = cityList.get(i).meanTemperature;
            //iteracja po mapie, dodanie wartości
            Set<String> keySet = tempData.keySet();
            String key;
            Iterator<String> it = keySet.iterator();
            while (it.hasNext()) {
                key = it.next();
                textTemp += key + ": " + tempData.get(key) + "   |   ";
            }
            textTemp += '\n';
        }
        this.cityText.setText(text);
        this.temperaturePanel.setText(textTemp);
        
        this.cityCB.removeItem(toDelete);
    }//GEN-LAST:event_deleteCityButtonActionPerformed

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
            java.util.logging.Logger.getLogger(mainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mainWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addCityButton;
    private javax.swing.JLabel addCityLabel;
    private javax.swing.JLabel author;
    private javax.swing.JComboBox<String> cityCB;
    private javax.swing.JTextField cityNameTextField;
    private javax.swing.JTextArea cityText;
    private javax.swing.JButton deleteCityButton;
    private javax.swing.JLabel errorLabel;
    private javax.swing.JButton hourCalculationButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea temperaturePanel;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Object source = e.getSource();

        // Dodaj miastio
        if (source == this.addCityButton) {

        }

        // Usuń miasto
        if (source == this.deleteCityButton) {

        }
    }
}
