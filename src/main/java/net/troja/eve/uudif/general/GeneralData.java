package net.troja.eve.uudif.general;

import java.util.Date;
import java.util.List;

public abstract class GeneralData {
    private String version;
    private List<UploadKey> uploadKeys;
    private List<String> columns;
    protected Date currentTime;

    public GeneralData() {
	super();
    }

    public GeneralData(GeneralData copy) {
	version = copy.getVersion();
	uploadKeys = copy.getUploadKeys();
	columns = copy.getColumns();
	currentTime = copy.getCurrentTime();
    }
    
    public String getVersion() {
	return version;
    }

    public void setVersion(String version) {
	this.version = version;
    }

    public List<UploadKey> getUploadKeys() {
	return uploadKeys;
    }

    public void setUploadKeys(List<UploadKey> uploadKeys) {
	this.uploadKeys = uploadKeys;
    }

    public List<String> getColumns() {
	return columns;
    }

    public void setColumns(List<String> columns) {
	this.columns = columns;
    }

    @Override
    public String toString() {
	return "GeneralData [version=" + version + ", uploadKeys=" + uploadKeys
		+ ", columns=" + columns + "]";
    }

    public Date getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(Date currentTime) {
        this.currentTime = currentTime;
    }


}
