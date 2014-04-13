package net.troja.eve.uudif.specific;

import java.util.List;

import net.troja.eve.uudif.general.GeneralData;

public abstract class GenericData<T> extends GeneralData {

    private String generatorName;
    private String generatorVersion;
    private List<GenericRowset<T>> rowsets;

    public GenericData() {
	super();
    }

    public GenericData(GeneralData copy) {
	super(copy);
    }

    public String getGeneratorName() {
	return generatorName;
    }

    public void setGeneratorName(String generatorName) {
	this.generatorName = generatorName;
    }

    public String getGeneratorVersion() {
	return generatorVersion;
    }

    public void setGeneratorVersion(String generatorVersion) {
	this.generatorVersion = generatorVersion;
    }

    public List<GenericRowset<T>> getRowsets() {
	return rowsets;
    }

    public void setRowsets(List<GenericRowset<T>> rowsets) {
	this.rowsets = rowsets;
    }

    @Override
    public String toString() {
	return "GenericData [generatorName=" + generatorName
		+ ", generatorVersion=" + generatorVersion + ", rowsets="
		+ rowsets + "]";
    }

}