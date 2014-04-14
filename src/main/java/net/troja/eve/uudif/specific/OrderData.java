package net.troja.eve.uudif.specific;

import java.util.ArrayList;

import net.troja.eve.uudif.general.GeneralData;


public class OrderData extends GenericData<OrderRow> {
    public OrderData() {
	super();
	setRowsets(new ArrayList<GenericRowset<OrderRow>>());
    }

    public OrderData(final GeneralData copy) {
	super(copy);
	setRowsets(new ArrayList<GenericRowset<OrderRow>>());
    }

    @Override
    public String toString() {
	return "OrderData [generatorName=" + getGeneratorName()
		+ ", generatorVersion=" + getGeneratorVersion()
		+ ", rowsets=" + getRowsets() + ", version="
		+ getVersion() + ", uploadKeys=" + getUploadKeys()
		+ ", columns=" + getColumns() + ", currentTime="
		+ getCurrentTime() + "]";
    }


}
