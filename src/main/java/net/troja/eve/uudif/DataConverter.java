package net.troja.eve.uudif;

import net.troja.eve.uudif.raw.RawData;
import net.troja.eve.uudif.specific.GenericData;
import net.troja.eve.uudif.specific.HistoryData;
import net.troja.eve.uudif.specific.OrderData;

public class DataConverter {
    private static final String TYPE_ORDER = "order";
    
    public DataConverter() {
    }
    
    public GenericData<?> convert(RawData data) {
	GenericData<?> retData;
	
	if(TYPE_ORDER.equals(data.getResultType())) {
	    OrderData orderData = new OrderData(data);
	    
	    retData = orderData;
	} else {
	    HistoryData historyData = new HistoryData(data);
	    
	    retData = historyData;
	}
	
	retData.setGeneratorName(data.getGenerator().getName());
	retData.setGeneratorVersion(data.getGenerator().getVersion());
	return retData;
    }
}
