/*
Copyright (C) 2018  Rafael de Araújo Paim
See MainView.java for the full license notice
*/
package br.com.ia.rna.implementation.arff;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 *
 * @author Rafael
 */
public class ARFFPath {
    
    public static final String PROP_FILEPATH = "filePath"; //Static constant for filePath attribute
    public static final String PROP_ARFFPATH = "arffPath"; //Static constant for arffPath attribute
    
    
    private String filePath; //Stores the path of the image
    private String arffPath; //Stores the path of the generated ARFF File

    
    //================Getters & Setters=============

    public String getArffPath() {
        return arffPath;
    }

    public void setArffPath(String arffPath) {
        String oldArffPath = this.arffPath;
        this.arffPath = arffPath;
        propertyChangeSupport.firePropertyChange(PROP_ARFFPATH, oldArffPath, arffPath);
    }
 
    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        String oldFilePath = this.filePath;
        this.filePath = filePath;
        propertyChangeSupport.firePropertyChange(PROP_FILEPATH, oldFilePath, filePath);
    }
    
    //This makes property modification compatibility possible
    
    private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }

}
