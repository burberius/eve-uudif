package net.troja.eve.uudif.raw;

import java.util.ArrayList;
import java.util.List;

import net.troja.eve.uudif.general.GeneralData;

public class RawData extends GeneralData {

    private String resultType;
    private Generator generator;
    private List<RawRowset> rowsets;

    public RawData() {
	super();
	generator = new Generator();
	rowsets = new ArrayList<RawRowset>();
    }

    public String getResultType() {
	return resultType;
    }

    public void setResultType(final String resultType) {
	this.resultType = resultType;
    }

    public Generator getGenerator() {
	return generator;
    }

    public void setGenerator(final Generator generator) {
	this.generator = generator;
    }

    public List<RawRowset> getRowsets() {
	return rowsets;
    }

    public void setRowsets(final List<RawRowset> rowsets) {
	this.rowsets = rowsets;
    }

    @Override
    public String toString() {
	return "RawData [resultType=" + resultType + ", generator=" + generator
		+ ", rowsets=" + rowsets + ", version=" + getVersion()
		+ ", uploadKeys=" + getUploadKeys() + ", columns="
		+ getColumns() + ", currentTime=" + getCurrentTime() + "]";
    }
}
