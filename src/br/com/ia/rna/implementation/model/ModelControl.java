/*
Copyright (C) 2018  Rafael de Araújo Paim
See MainView.java for the full license notice
*/
package br.com.ia.rna.implementation.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import weka.classifiers.functions.MultilayerPerceptron;

/**
 *
 * @author Rafael
 */
public class ModelControl {
    
    public static final String PROP_MODEL = "mlp";
    public static final String PROP_MODELPATH = "modelPath";
    
    private MultilayerPerceptron model; //Stores the classifier, only MultilayerPerceptron can be used in this implementation
    //This attribute stores the path of the classifier model 
    private String modelPath;

    
    //============Getters & Setters===============
    public String getModelPath() {
        return modelPath;
    }
    
    public void setModelPath(String modelPath){
        String oldModelPath = this.modelPath;
        this.modelPath = modelPath;
        propertyChangeSupport.firePropertyChange(PROP_MODELPATH, oldModelPath, modelPath);
    }

    public MultilayerPerceptron getModel() {
        return model;
    }

    public void setModel(MultilayerPerceptron model) {
        MultilayerPerceptron oldMlp = this.model;
        this.model = model;
        propertyChangeSupport.firePropertyChange(PROP_MODEL, oldMlp, model);
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
