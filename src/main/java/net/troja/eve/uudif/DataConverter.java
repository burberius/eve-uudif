package net.troja.eve.uudif;

import java.text.SimpleDateFormat;
import java.util.List;

import net.troja.eve.uudif.raw.RawData;
import net.troja.eve.uudif.raw.RawRowset;
import net.troja.eve.uudif.specific.GenericData;
import net.troja.eve.uudif.specific.GenericRowset;
import net.troja.eve.uudif.specific.HistoryData;
import net.troja.eve.uudif.specific.HistoryRow;
import net.troja.eve.uudif.specific.OrderData;
import net.troja.eve.uudif.specific.OrderRow;

public class DataConverter {
    private static final String TYPE_ORDER = "orders";
    public static final String DATETIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ssXXX";

    private final SimpleDateFormat dateFormat;

    public DataConverter() {
	dateFormat = new SimpleDateFormat(DATETIME_FORMAT);
    }

    public GenericData<?> convert(final RawData data) {
	GenericData<?> retData;

	if (TYPE_ORDER.equals(data.getResultType())) {
	    final OrderData orderData = new OrderData(data);

	    convertOrderRowset(orderData, data);

	    retData = orderData;
	} else {
	    final HistoryData historyData = new HistoryData(data);

	    convertOrderRowset(historyData, data);

	    retData = historyData;
	}

	retData.setGeneratorName(data.getGenerator().getName());
	retData.setGeneratorVersion(data.getGenerator().getVersion());

	return retData;
    }

    private void convertOrderRowset(final OrderData orderData,
	    final RawData data) {
	for (final RawRowset rowset : data.getRowsets()) {
	    final GenericRowset<OrderRow> genericRowset = new GenericRowset<OrderRow>();
	    genericRowset.setGeneratedAt(rowset.getGeneratedAt());
	    genericRowset.setRegionID(rowset.getRegionID());
	    genericRowset.setTypeID(rowset.getTypeID());
	    for (final List<String> row : rowset.getRows()) {
		genericRowset.add(createOrderRow(row, data.getColumns()));
	    }
	    orderData.addRowset(genericRowset);
	}
    }

    private OrderRow createOrderRow(final List<String> data,
	    final List<String> columns) {
	final OrderRow row = new OrderRow();
	for (int pos = 0; pos < columns.size(); pos++) {
	    try {
		switch (columns.get(pos)) {
		case "price":
		    row.setPrice(Double.parseDouble(data.get(pos)));
		    break;
		case "volRemaining":
		    row.setVolRemaining(Integer.parseInt(data.get(pos)));
		    break;
		case "range":
		    row.setRange(Integer.parseInt(data.get(pos)));
		    break;
		case "orderID":
		    row.setOrderId(Long.parseLong(data.get(pos)));
		    break;
		case "volEntered":
		    row.setVolEntered(Integer.parseInt(data.get(pos)));
		    break;
		case "minVolume":
		    row.setMinVolume(Integer.parseInt(data.get(pos)));
		    break;
		case "bid":
		    row.setBid(Boolean.parseBoolean(data.get(pos)));
		    break;
		case "issueDate":
		    row.setIssueDate(dateFormat.parse(data.get(pos)));
		    break;
		case "duration":
		    row.setDuration(Integer.parseInt(data.get(pos)));
		    break;
		case "stationID":
		    row.setStationId(Long.parseLong(data.get(pos)));
		    break;
		case "solarSystemID":
		    row.setSolarSystemId(Long.parseLong(data.get(pos)));
		    break;
		default:
		    break;
		}
	    } catch (final Exception e) {
		// We ignore parse exceptions
	    }
	}
	return row;
    }

    private void convertOrderRowset(final HistoryData historyData, final RawData data) {
	for (final RawRowset rowset : data.getRowsets()) {
	    final GenericRowset<HistoryRow> genericRowset = new GenericRowset<HistoryRow>();
	    genericRowset.setGeneratedAt(rowset.getGeneratedAt());
	    genericRowset.setRegionID(rowset.getRegionID());
	    genericRowset.setTypeID(rowset.getTypeID());
	    for (final List<String> row : rowset.getRows()) {
		genericRowset.add(createHistoryRow(row, data.getColumns()));
	    }
	    historyData.addRowset(genericRowset);
	}
    }

    private HistoryRow createHistoryRow(final List<String> data, final List<String> columns) {
	final HistoryRow row = new HistoryRow();
	for (int pos = 0; pos < columns.size(); pos++) {
	    try {
		switch (columns.get(pos)) {
		case "orders":
		    row.setOrders(Integer.parseInt(data.get(pos)));
		    break;
		case "quantity":
		    row.setQuantity(Integer.parseInt(data.get(pos)));
		    break;
		case "low":
		    row.setLow(Double.parseDouble(data.get(pos)));
		    break;
		case "high":
		    row.setHigh(Double.parseDouble(data.get(pos)));
		    break;
		case "average":
		    row.setAverage(Double.parseDouble(data.get(pos)));
		    break;
		case "date":
		    row.setDate(dateFormat.parse(data.get(pos)));
		    break;
		default:
		    break;
		}
	    } catch (final Exception e) {
		// We ignore parse exceptions
	    }
	}
	return row;
    }
}
