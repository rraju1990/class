package com.arima.classengine.core;
import java.io.InputStream;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.print.CancelablePrintJob;

import org.omg.PortableInterceptor.INACTIVE;

import com.arima.classengine.classifier.CJ48Classifier;
import com.arima.classengine.filter.CFilter;
import com.mysql.jdbc.Blob;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import weka.classifiers.Classifier;
import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.functions.LinearRegression;
import weka.classifiers.functions.MultilayerPerceptron;
import weka.classifiers.trees.J48;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import weka.experiment.InstanceQuery;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.ReplaceMissingValues;

public class CFinal {
	
	public static void main(String[] args) throws Exception {
		
		Instances train = CFilter.retrieveDatasetFromDatabase("select * from ol_model", "root", "");
//		System.out.println(train);
		CAnalyzer.getModel(train);
		//getModel(train) will return a best model among other models to this train set
//		Classifier model = CAnalyzer.getModel(train);
		
	}
	
	public static String getAttributeLables(int bins, boolean isLetter){
       
		String lables;
        if(isLetter){
        	
        switch (bins) {
            case 2:  lables = "1,2";
                     break;
            case 3:  lables = "1,2,3";
                     break;
            case 4:  lables = "1,2,3,4";
                     break;
            case 5:  lables = "1,2,3,4,5";
                     break;
            default: lables = "1,2,3,4,5";
                     break;
        }
        }
        else{
        	
            switch (bins) {
            case 2:  lables = "F,A";
                     break;
            case 3:  lables = "F,S,A";
                     break;
            case 4:  lables = "F,S,C,A";
                     break;
            case 5:  lables = "F,S,C,B,A";
                     break;
            default: lables = "F,S,C,B,A";
                     break;
        }
        	
        }
        
        return lables;
	}

	public static Instances handleMissingValues(Instances data) throws Exception{

		System.out.println("Handling missing values");
		ReplaceMissingValues rmv = new ReplaceMissingValues();
		rmv.setInputFormat(data);
		data = Filter.useFilter(data, rmv);
		System.out.println("Number of instances in dataset : " + data.numInstances());

		return data;
	}
	
	public static Instances renameAttributes(Instances train, int bins){
		
		switch (bins) {

		case 2:  		
			for (int j = 0; j < train.numAttributes(); j++) {
				train.renameAttributeValue(j, 0, "F");
				train.renameAttributeValue(j, 1, "S");
			}
			break;

		case 3:              		
			for (int j = 0; j < train.numAttributes(); j++) {
				train.renameAttributeValue(j, 0, "F");
				train.renameAttributeValue(j, 1, "S");
				train.renameAttributeValue(j, 2, "C");
			}
			break;

		case 4:              		
			for (int j = 0; j < train.numAttributes(); j++) {
				train.renameAttributeValue(j, 0, "F");
				train.renameAttributeValue(j, 1, "S");
				train.renameAttributeValue(j, 2, "C");
				train.renameAttributeValue(j, 3, "B");
			}
			break;

		case 5:              		
			for (int j = 0; j < train.numAttributes(); j++) {
				train.renameAttributeValue(j, 0, "F");
				train.renameAttributeValue(j, 1, "S");
				train.renameAttributeValue(j, 2, "C");
				train.renameAttributeValue(j, 3, "B");
				train.renameAttributeValue(j, 4, "A");
			}
			break;

		default:             		
			for (int j = 0; j < train.numAttributes(); j++) {
				train.renameAttributeValue(j, 0, "F");
				train.renameAttributeValue(j, 1, "S");
				train.renameAttributeValue(j, 2, "C");
				train.renameAttributeValue(j, 3, "B");
				train.renameAttributeValue(j, 4, "A");
			}
			break;
		}
		
		return train;
	}
	
	public static Instances changeAttributeNominalRange(Instances train, String labels) throws Exception{
		
		for (int i = 0; i < train.numAttributes(); i++) {
			train = CFilter.changeAttributeNominalValues(train, i+1, labels);
		}
		
		return train;
	}
}