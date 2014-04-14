package net.troja.eve.uudif.specific;

import java.util.ArrayList;

import net.troja.eve.uudif.general.GeneralData;


public class HistoryData extends GenericData<HistoryRow> {
    public HistoryData() {
	super();
	setRowsets(new ArrayList<GenericRowset<HistoryRow>>());
    }

    public HistoryData(final GeneralData copy) {
	super(copy);
	setRowsets(new ArrayList<GenericRowset<HistoryRow>>());
    }

    @Override
    public String toString() {
	return "HistoryData [generatorName=" + getGeneratorName()
		+ ", generatorVersion=" + getGeneratorVersion()
		+ ", rowsets=" + getRowsets() + ", version="
		+ getVersion() + ", uploadKeys=" + getUploadKeys()
		+ ", columns()=" + getColumns() + ", currentTime="
		+ getCurrentTime() + "]";
    }
}
