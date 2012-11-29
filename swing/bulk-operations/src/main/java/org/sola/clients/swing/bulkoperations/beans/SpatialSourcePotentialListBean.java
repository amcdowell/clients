/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sola.clients.swing.bulkoperations.beans;

import java.util.Set;
import org.jdesktop.observablecollections.ObservableList;
import org.reflections.Reflections;
import org.sola.clients.beans.AbstractBindingBean;
import org.sola.clients.beans.AbstractListBean;
import org.sola.clients.beans.controls.SolaObservableList;
import org.sola.common.logging.LogUtility;

/**
 *
 * @author Elton Manoku
 */
public class SpatialSourcePotentialListBean extends AbstractListBean{

    public static final String SELECTED_BEAN_PROPERTY = "selectedSpatialSourceBean";

    @Override
    protected SolaObservableList initializeBeanList() {
        SolaObservableList<SpatialSourceBean> list =
                new SolaObservableList<SpatialSourceBean>();
        String namespaceToScan = SpatialSourceBean.class.getPackage().getName();
        Reflections reflections = new Reflections(namespaceToScan);
        Set<Class<? extends SpatialSourceBean>> subTypes =
                reflections.getSubTypesOf(SpatialSourceBean.class);
        try {
            for (Class<? extends SpatialSourceBean> foundClass : subTypes) {
                list.add(foundClass.newInstance());
            }
        } catch (InstantiationException ex) {
            LogUtility.log("Error initializing SpatialSourcePotentialListBean", ex);
        } catch (IllegalAccessException ex) {
            LogUtility.log("Error initializing SpatialSourcePotentialListBean", ex);
        }
        return list;
    }

    public SpatialSourceBean getSelectedSpatialSourceBean() {
        return (SpatialSourceBean)super.getSelectedBean();
    }
    
    public void setSelectedSpatialSourceBean(AbstractBindingBean newValue) {
        AbstractBindingBean old = getSelectedBean();
        super.setSelectedBean((AbstractBindingBean)newValue);
        propertySupport.firePropertyChange(SELECTED_BEAN_PROPERTY, old, newValue);
    }
}
