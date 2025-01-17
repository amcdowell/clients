/**
 * ******************************************************************************************
 * Copyright (C) 2014 - Food and Agriculture Organization of the United Nations (FAO).
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted provided that the following conditions are met:
 *
 *    1. Redistributions of source code must retain the above copyright notice,this list
 *       of conditions and the following disclaimer.
 *    2. Redistributions in binary form must reproduce the above copyright notice,this list
 *       of conditions and the following disclaimer in the documentation and/or other
 *       materials provided with the distribution.
 *    3. Neither the name of FAO nor the names of its contributors may be used to endorse or
 *       promote products derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY
 * EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT
 * SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,PROCUREMENT
 * OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
 * HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT,STRICT LIABILITY,OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE,
 * EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 * *********************************************************************************************
 */
package org.sola.clients.swing.ui.cadastre;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import org.sola.clients.beans.address.AddressBean;
import org.sola.clients.beans.cadastre.CadastreObjectBean;
import org.sola.clients.swing.ui.address.AddressDialog;
import org.sola.clients.swing.common.utils.FormattersFactory;
import org.sola.clients.swing.ui.renderers.SimpleComboBoxRenderer;
import org.sola.common.WindowUtility;

/**
 * Parcel panel to create and manage parcel objects
 */
public class ParcelPanel extends javax.swing.JPanel {

    private CadastreObjectBean createCadastreBean(){
        if(cadastreObjectBean1==null){
            cadastreObjectBean1 = new CadastreObjectBean();
        }
        return cadastreObjectBean1;
    }
    
    public ParcelPanel() {
        this(null);
    }
    
    public ParcelPanel(CadastreObjectBean cadastreObject) {
        cadastreObjectBean1 = cadastreObject;
        initComponents();
        postInit();
    }
    
    private void postInit(){
        cadastreObjectBean1.addPropertyChangeListener(new PropertyChangeListener() {

            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if(evt.getPropertyName().equals(CadastreObjectBean.SELECTED_ADDRESS_PROPERTY)){
                    customizeAddressButtons();
                }
            }
        });
        this.jPanel2.setVisible(false);
        this.jPanel3.setVisible(false);
        customizeAddressButtons();
    }
 
    private void customizeAddressButtons(){
        boolean enabled = cadastreObjectBean1.getSelectedAddress()!=null;
        btnEdit1.setEnabled(enabled);
        btnRemove1.setEnabled(enabled);
        menuAdd1.setEnabled(enabled);
        menuRemove1.setEnabled(enabled);
    }
    
    public CadastreObjectBean getCadastreObject(){
        return cadastreObjectBean1;
    }
    
    private void addAddress(){
        AddressDialog form = new AddressDialog(null, null, true);
        WindowUtility.centerForm(form);
        form.addPropertyChangeListener(new PropertyChangeListener() {

            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if(evt.getPropertyName().equals(AddressDialog.ADDRESS_SAVED)){
                    cadastreObjectBean1.addAddress((AddressBean)evt.getNewValue());
                }
            }
        });
        form.setVisible(true);
    }
    
    private void editAddress(){
        if(cadastreObjectBean1.getSelectedAddress()==null){
            return;
        }
        
        AddressDialog form = new AddressDialog(
                (AddressBean)cadastreObjectBean1.getSelectedAddress().copy(), 
                null, true);
        WindowUtility.centerForm(form);
        form.addPropertyChangeListener(new PropertyChangeListener() {

            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if(evt.getPropertyName().equals(AddressDialog.ADDRESS_SAVED)){
                    cadastreObjectBean1.getSelectedAddress().copyFromObject((AddressBean)evt.getNewValue());
                }
            }
        });
        form.setVisible(true);
    }
    
    private void removeAddress(){
        cadastreObjectBean1.removeSelectedAddress();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        cadastreObjectBean1 = createCadastreBean();
        cadastreObjectTypeListBean1 = new org.sola.clients.beans.referencedata.CadastreObjectTypeListBean();
        landUseTypeListBean1 = new org.sola.clients.beans.referencedata.LandUseTypeListBean();
        popUpAddresses = new javax.swing.JPopupMenu();
        menuAdd1 = new org.sola.clients.swing.common.menuitems.MenuAdd();
        menuEdit1 = new org.sola.clients.swing.common.menuitems.MenuEdit();
        menuRemove1 = new org.sola.clients.swing.common.menuitems.MenuRemove();
        lgaTypeListBean1 = new org.sola.clients.beans.referencedata.LgaTypeListBean();
        zoneTypeListBean1 = new org.sola.clients.beans.referencedata.ZoneTypeListBean();
        jPanel1 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtPlot = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txtParcelSurveyRef = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtBlock = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        cbxParcelEstateType = new javax.swing.JComboBox();
        jPanel7 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtArea = new javax.swing.JFormattedTextField();
        jPanel6 = new javax.swing.JPanel();
        labLandUse = new javax.swing.JLabel();
        cbxLandUse = new javax.swing.JComboBox();
        jPanel11 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jPanel13 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        txtParcelFirstPart = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtParcelLastPart = new javax.swing.JTextField();
        jPanel12 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        btnAdd1 = new org.sola.clients.swing.common.buttons.BtnAdd();
        btnEdit1 = new org.sola.clients.swing.common.buttons.BtnEdit();
        btnRemove1 = new org.sola.clients.swing.common.buttons.BtnRemove();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableWithDefaultStyles1 = new org.sola.clients.swing.common.controls.JTableWithDefaultStyles();
        groupPanel1 = new org.sola.clients.swing.ui.GroupPanel();

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("org/sola/clients/swing/ui/cadastre/Bundle"); // NOI18N
        popUpAddresses.setName(bundle.getString("ParcelPanel.popUpAddresses.name")); // NOI18N

        menuAdd1.setName(bundle.getString("ParcelPanel.menuAdd1.name")); // NOI18N
        menuAdd1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAdd1ActionPerformed(evt);
            }
        });
        popUpAddresses.add(menuAdd1);

        menuEdit1.setName(bundle.getString("ParcelPanel.menuEdit1.name")); // NOI18N
        menuEdit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEdit1ActionPerformed(evt);
            }
        });
        popUpAddresses.add(menuEdit1);

        menuRemove1.setName(bundle.getString("ParcelPanel.menuRemove1.name")); // NOI18N
        menuRemove1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuRemove1ActionPerformed(evt);
            }
        });
        popUpAddresses.add(menuRemove1);

        setName("Form"); // NOI18N

        jPanel1.setName(bundle.getString("ParcelPanel.jPanel1.name")); // NOI18N
        jPanel1.setLayout(new java.awt.GridLayout(3, 3, 15, 15));

        jPanel9.setName("jPanel9"); // NOI18N

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/common/red_asterisk.gif"))); // NOI18N
        jLabel3.setText(bundle.getString("ParcelPanel.jLabel3.text")); // NOI18N
        jLabel3.setName("jLabel3"); // NOI18N

        txtPlot.setText(bundle.getString("ParcelPanel.txtPlot.text")); // NOI18N
        txtPlot.setName("txtPlot"); // NOI18N

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, cadastreObjectBean1, org.jdesktop.beansbinding.ELProperty.create("${plotNum}"), txtPlot, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        org.jdesktop.layout.GroupLayout jPanel9Layout = new org.jdesktop.layout.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(txtPlot)
            .add(jLabel3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel9Layout.createSequentialGroup()
                .add(jLabel3)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(txtPlot, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(0, 18, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel9);

        jPanel5.setName(bundle.getString("ParcelPanel.jPanel5.name")); // NOI18N

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/common/red_asterisk.gif"))); // NOI18N
        jLabel9.setText(bundle.getString("ParcelPanel.jLabel9.text")); // NOI18N
        jLabel9.setName("jLabel9"); // NOI18N

        txtParcelSurveyRef.setName("txtParcelSurveyRef"); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, cadastreObjectBean1, org.jdesktop.beansbinding.ELProperty.create("${sourceReference}"), txtParcelSurveyRef, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        org.jdesktop.layout.GroupLayout jPanel5Layout = new org.jdesktop.layout.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(txtParcelSurveyRef)
            .add(jLabel9, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel5Layout.createSequentialGroup()
                .add(jLabel9)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(txtParcelSurveyRef, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(jPanel5);

        jPanel8.setName("jPanel8"); // NOI18N

        jLabel2.setText(bundle.getString("ParcelPanel.jLabel2.text")); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N

        txtBlock.setName("txtBlock"); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, cadastreObjectBean1, org.jdesktop.beansbinding.ELProperty.create("${block}"), txtBlock, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        org.jdesktop.layout.GroupLayout jPanel8Layout = new org.jdesktop.layout.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(txtBlock, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
            .add(jLabel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel8Layout.createSequentialGroup()
                .add(jLabel2)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(txtBlock, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(0, 18, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel8);

        jPanel4.setName(bundle.getString("ParcelPanel.jPanel4.name")); // NOI18N

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/common/red_asterisk.gif"))); // NOI18N
        jLabel10.setText(bundle.getString("ParcelPanel.jLabel10.text")); // NOI18N
        jLabel10.setName("jLabel10"); // NOI18N

        cbxParcelEstateType.setName("cbxParcelEstateType"); // NOI18N
        cbxParcelEstateType.setRenderer(new SimpleComboBoxRenderer("getDisplayValue"));

        org.jdesktop.beansbinding.ELProperty eLProperty = org.jdesktop.beansbinding.ELProperty.create("${cadastreObjectTypeList}");
        org.jdesktop.swingbinding.JComboBoxBinding jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, cadastreObjectTypeListBean1, eLProperty, cbxParcelEstateType);
        bindingGroup.addBinding(jComboBoxBinding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, cadastreObjectBean1, org.jdesktop.beansbinding.ELProperty.create("${cadastreObjectType}"), cbxParcelEstateType, org.jdesktop.beansbinding.BeanProperty.create("selectedItem"));
        bindingGroup.addBinding(binding);

        org.jdesktop.layout.GroupLayout jPanel4Layout = new org.jdesktop.layout.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel4Layout.createSequentialGroup()
                .add(jLabel10)
                .add(0, 88, Short.MAX_VALUE))
            .add(cbxParcelEstateType, 0, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel4Layout.createSequentialGroup()
                .add(jLabel10)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(cbxParcelEstateType, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(0, 0, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel4);

        jPanel7.setName(bundle.getString("ParcelPanel.jPanel7.name")); // NOI18N

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/common/red_asterisk.gif"))); // NOI18N
        jLabel1.setText(bundle.getString("ParcelPanel.jLabel1.text")); // NOI18N
        jLabel1.setName(bundle.getString("ParcelPanel.jLabel1.name")); // NOI18N

        txtArea.setFormatterFactory(FormattersFactory.getInstance().getDecimalFormatterFactory());
        txtArea.setText(bundle.getString("ParcelPanel.txtArea.text")); // NOI18N
        txtArea.setName(bundle.getString("ParcelPanel.txtArea.name")); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, cadastreObjectBean1, org.jdesktop.beansbinding.ELProperty.create("${officialAreaSize}"), txtArea, org.jdesktop.beansbinding.BeanProperty.create("value"));
        bindingGroup.addBinding(binding);

        org.jdesktop.layout.GroupLayout jPanel7Layout = new org.jdesktop.layout.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel7Layout.createSequentialGroup()
                .add(jLabel1)
                .addContainerGap(64, Short.MAX_VALUE))
            .add(txtArea)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel7Layout.createSequentialGroup()
                .add(jLabel1)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(txtArea, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(jPanel7);

        jPanel6.setName(bundle.getString("ParcelPanel.jPanel6.name")); // NOI18N

        labLandUse.setText(bundle.getString("ParcelPanel.labLandUse.text")); // NOI18N
        labLandUse.setName(bundle.getString("ParcelPanel.labLandUse.name")); // NOI18N

        cbxLandUse.setName(bundle.getString("ParcelPanel.cbxLandUse.name")); // NOI18N

        eLProperty = org.jdesktop.beansbinding.ELProperty.create("${landUseTypeList}");
        jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, landUseTypeListBean1, eLProperty, cbxLandUse);
        bindingGroup.addBinding(jComboBoxBinding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, cadastreObjectBean1, org.jdesktop.beansbinding.ELProperty.create("${landUseType}"), cbxLandUse, org.jdesktop.beansbinding.BeanProperty.create("selectedItem"));
        bindingGroup.addBinding(binding);

        org.jdesktop.layout.GroupLayout jPanel6Layout = new org.jdesktop.layout.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel6Layout.createSequentialGroup()
                .add(labLandUse)
                .add(0, 82, Short.MAX_VALUE))
            .add(cbxLandUse, 0, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel6Layout.createSequentialGroup()
                .add(labLandUse)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(cbxLandUse, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(0, 0, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel6);

        jPanel11.setName("jPanel11"); // NOI18N

        jLabel4.setText(bundle.getString("ParcelPanel.jLabel4.text")); // NOI18N
        jLabel4.setName("jLabel4"); // NOI18N

        jComboBox1.setName("jComboBox1"); // NOI18N

        eLProperty = org.jdesktop.beansbinding.ELProperty.create("${lgaTypeList}");
        jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, lgaTypeListBean1, eLProperty, jComboBox1);
        bindingGroup.addBinding(jComboBoxBinding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, lgaTypeListBean1, org.jdesktop.beansbinding.ELProperty.create("${selectedLgaType}"), jComboBox1, org.jdesktop.beansbinding.BeanProperty.create("selectedItem"));
        bindingGroup.addBinding(binding);

        org.jdesktop.layout.GroupLayout jPanel11Layout = new org.jdesktop.layout.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel11Layout.createSequentialGroup()
                .add(jLabel4)
                .add(0, 0, Short.MAX_VALUE))
            .add(jComboBox1, 0, 126, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel11Layout.createSequentialGroup()
                .add(jLabel4)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jComboBox1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(0, 18, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel11);

        jPanel13.setName("jPanel13"); // NOI18N

        jLabel6.setText(bundle.getString("ParcelPanel.jLabel6.text")); // NOI18N
        jLabel6.setName("jLabel6"); // NOI18N

        jTextField3.setName("jTextField3"); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, cadastreObjectBean1, org.jdesktop.beansbinding.ELProperty.create("${intellMapSheet}"), jTextField3, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        org.jdesktop.layout.GroupLayout jPanel13Layout = new org.jdesktop.layout.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel13Layout.createSequentialGroup()
                .add(jLabel6)
                .add(0, 59, Short.MAX_VALUE))
            .add(jTextField3)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel13Layout.createSequentialGroup()
                .add(jLabel6)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jTextField3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(0, 18, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel13);

        jPanel2.setName(bundle.getString("ParcelPanel.jPanel2.name")); // NOI18N

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/common/red_asterisk.gif"))); // NOI18N
        jLabel17.setText(bundle.getString("ParcelPanel.jLabel17.text")); // NOI18N
        jLabel17.setName("jLabel17"); // NOI18N

        txtParcelFirstPart.setEditable(false);
        txtParcelFirstPart.setName("txtParcelFirstPart"); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, cadastreObjectBean1, org.jdesktop.beansbinding.ELProperty.create("${nameFirstpart}"), txtParcelFirstPart, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .add(jLabel17)
                .add(0, 68, Short.MAX_VALUE))
            .add(txtParcelFirstPart)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .add(jLabel17)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(txtParcelFirstPart, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(0, 0, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2);

        jPanel3.setName(bundle.getString("ParcelPanel.jPanel3.name")); // NOI18N

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/common/red_asterisk.gif"))); // NOI18N
        jLabel7.setText(bundle.getString("ParcelPanel.jLabel7.text")); // NOI18N
        jLabel7.setName("jLabel7"); // NOI18N

        txtParcelLastPart.setEditable(false);
        txtParcelLastPart.setName("txtParcelLastPart"); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, cadastreObjectBean1, org.jdesktop.beansbinding.ELProperty.create("${nameLastpart}"), txtParcelLastPart, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        org.jdesktop.layout.GroupLayout jPanel3Layout = new org.jdesktop.layout.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel3Layout.createSequentialGroup()
                .add(jLabel7)
                .add(0, 69, Short.MAX_VALUE))
            .add(txtParcelLastPart)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel3Layout.createSequentialGroup()
                .add(jLabel7)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(txtParcelLastPart, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(0, 0, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3);

        jPanel12.setName("jPanel12"); // NOI18N

        org.jdesktop.layout.GroupLayout jPanel12Layout = new org.jdesktop.layout.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 126, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 58, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel12);

        jPanel14.setName("jPanel14"); // NOI18N

        org.jdesktop.layout.GroupLayout jPanel14Layout = new org.jdesktop.layout.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 126, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 58, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel14);

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);
        jToolBar1.setName(bundle.getString("ParcelPanel.jToolBar1.name")); // NOI18N

        btnAdd1.setName(bundle.getString("ParcelPanel.btnAdd1.name")); // NOI18N
        btnAdd1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdd1ActionPerformed(evt);
            }
        });
        jToolBar1.add(btnAdd1);

        btnEdit1.setName(bundle.getString("ParcelPanel.btnEdit1.name")); // NOI18N
        btnEdit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEdit1ActionPerformed(evt);
            }
        });
        jToolBar1.add(btnEdit1);

        btnRemove1.setName(bundle.getString("ParcelPanel.btnRemove1.name")); // NOI18N
        btnRemove1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemove1ActionPerformed(evt);
            }
        });
        jToolBar1.add(btnRemove1);

        jScrollPane1.setName(bundle.getString("ParcelPanel.jScrollPane1.name")); // NOI18N

        jTableWithDefaultStyles1.setName(bundle.getString("ParcelPanel.jTableWithDefaultStyles1.name")); // NOI18N

        eLProperty = org.jdesktop.beansbinding.ELProperty.create("${addressFilteredList}");
        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, cadastreObjectBean1, eLProperty, jTableWithDefaultStyles1);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${description}"));
        columnBinding.setColumnName("Description");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, cadastreObjectBean1, org.jdesktop.beansbinding.ELProperty.create("${selectedAddress}"), jTableWithDefaultStyles1, org.jdesktop.beansbinding.BeanProperty.create("selectedElement"));
        bindingGroup.addBinding(binding);

        jScrollPane1.setViewportView(jTableWithDefaultStyles1);
        if (jTableWithDefaultStyles1.getColumnModel().getColumnCount() > 0) {
            jTableWithDefaultStyles1.getColumnModel().getColumn(0).setHeaderValue(bundle.getString("ParcelPanel.jTableWithDefaultStyles1.columnModel.title0_1")); // NOI18N
            jTableWithDefaultStyles1.getColumnModel().getColumn(0).setCellRenderer(new org.sola.clients.swing.ui.renderers.TableCellTextAreaRenderer());
        }

        groupPanel1.setName(bundle.getString("ParcelPanel.groupPanel1.name")); // NOI18N
        groupPanel1.setTitleText(bundle.getString("ParcelPanel.groupPanel1.titleText")); // NOI18N

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .add(jToolBar1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .add(groupPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 205, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(groupPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jToolBar1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 25, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE))
        );

        bindingGroup.bind();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAdd1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdd1ActionPerformed
        addAddress();
    }//GEN-LAST:event_btnAdd1ActionPerformed

    private void btnEdit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEdit1ActionPerformed
        editAddress();
    }//GEN-LAST:event_btnEdit1ActionPerformed

    private void btnRemove1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemove1ActionPerformed
        removeAddress();
    }//GEN-LAST:event_btnRemove1ActionPerformed

    private void menuAdd1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAdd1ActionPerformed
        addAddress();
    }//GEN-LAST:event_menuAdd1ActionPerformed

    private void menuEdit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEdit1ActionPerformed
        editAddress();
    }//GEN-LAST:event_menuEdit1ActionPerformed

    private void menuRemove1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuRemove1ActionPerformed
        removeAddress();
    }//GEN-LAST:event_menuRemove1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.sola.clients.swing.common.buttons.BtnAdd btnAdd1;
    private org.sola.clients.swing.common.buttons.BtnEdit btnEdit1;
    private org.sola.clients.swing.common.buttons.BtnRemove btnRemove1;
    private org.sola.clients.beans.cadastre.CadastreObjectBean cadastreObjectBean1;
    private org.sola.clients.beans.referencedata.CadastreObjectTypeListBean cadastreObjectTypeListBean1;
    private javax.swing.JComboBox cbxLandUse;
    private javax.swing.JComboBox cbxParcelEstateType;
    private org.sola.clients.swing.ui.GroupPanel groupPanel1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private org.sola.clients.swing.common.controls.JTableWithDefaultStyles jTableWithDefaultStyles1;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel labLandUse;
    private org.sola.clients.beans.referencedata.LandUseTypeListBean landUseTypeListBean1;
    private org.sola.clients.beans.referencedata.LgaTypeListBean lgaTypeListBean1;
    private org.sola.clients.swing.common.menuitems.MenuAdd menuAdd1;
    private org.sola.clients.swing.common.menuitems.MenuEdit menuEdit1;
    private org.sola.clients.swing.common.menuitems.MenuRemove menuRemove1;
    private javax.swing.JPopupMenu popUpAddresses;
    private javax.swing.JFormattedTextField txtArea;
    public javax.swing.JTextField txtBlock;
    private javax.swing.JTextField txtParcelFirstPart;
    private javax.swing.JTextField txtParcelLastPart;
    public javax.swing.JTextField txtParcelSurveyRef;
    public javax.swing.JTextField txtPlot;
    private org.sola.clients.beans.referencedata.ZoneTypeListBean zoneTypeListBean1;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
