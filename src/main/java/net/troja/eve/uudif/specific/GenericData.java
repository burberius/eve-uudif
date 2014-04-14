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

    public GenericData(final GeneralData copy) {
	super(copy);
    }

    public String getGeneratorName() {
	return generatorName;
    }

    public void setGeneratorName(final String generatorName) {
	this.generatorName = generatorName;
    }

    public String getGeneratorVersion() {
	return generatorVersion;
    }

    public void setGeneratorVersion(final String generatorVersion) {
	this.generatorVersion = generatorVersion;
    }

    public List<GenericRowset<T>> getRowsets() {
	return rowsets;
    }

    public void setRowsets(final List<GenericRowset<T>> rowsets) {
	this.rowsets = rowsets;
    }

    public void addRowset(final GenericRowset<T> rowset) {
	rowsets.add(rowset);
    }

    @Override
    public String toString() {
	return "GenericData [generatorName=" + generatorName
		+ ", generatorVersion=" + generatorVersion + ", rowsets="
		+ rowsets + "]";
    }
}