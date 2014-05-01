package net.troja.eve.uudif;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import net.troja.eve.uudif.general.UploadKey;
import net.troja.eve.uudif.raw.Generator;
import net.troja.eve.uudif.raw.RawData;
import net.troja.eve.uudif.raw.RawRowset;
import net.troja.eve.uudif.specific.GenericData;
import net.troja.eve.uudif.specific.GenericRowset;
import net.troja.eve.uudif.specific.HistoryData;
import net.troja.eve.uudif.specific.HistoryRow;
import net.troja.eve.uudif.specific.OrderData;
import net.troja.eve.uudif.specific.OrderRow;

import org.junit.Before;
import org.junit.Test;

public class DataConverterTest {
    private static final String FIELD_GENERATOR_NAME = "genName";
    private static final String FIELD_GENERATOR_VERSION = "genVersion";
    private static final String FIELD_KEY = "key";
    private static final String FIELD_NAME = "name";
    private static final String FIELD_VERSION = "1.0";
    private static final Integer FIELD_REGION = 1312312;
    private static final Integer FIELD_TYPEID = 39;
    private static final String[] COLUMNS_ORDER = { "price", "volRemaining", "range", "orderID", "volEntered",
	"minVolume", "bid", "issueDate", "duration", "stationID", "solarSystemID" };
    private static final String[] COLUMNS_HISTORY = { "date", "orders", "quantity", "low", "high", "average" };
    private static final String[] DATA_HISTORY = { "2014-04-10T00:00:00+00:00", "2", "2", "5000000.0", "5000000.0",
    "5000000.0" };
    private static final String[] DATA_ORDER = { "2000000.0", "1", "32767", "3509028371", "1", "1", "false",
	"2014-04-04T21:15:12+00:00", "7", "60003760", "30000142" };
    private static final long TEST_DATE = 265113432334l;

    private DataConverter classToTest;
    private RawData orderData;
    private RawData historyData;
    private SimpleDateFormat dateFormat;

    @Before
    public void init() {
	classToTest = new DataConverter();

	dateFormat = new SimpleDateFormat(DataConverter.DATETIME_FORMAT);

	final UploadKey key = new UploadKey(FIELD_NAME, FIELD_KEY);
	final List<UploadKey> keys = new ArrayList<UploadKey>();
	keys.add(key);

	createOrderData(keys);
	createHistoryData(keys);
    }

    @Test
    public void testCommonConversion() {
	final GenericData<?> data = classToTest.convert(orderData);
	assertThat(data.getGeneratorName(), is(FIELD_GENERATOR_NAME));
	assertThat(data.getGeneratorVersion(), is(FIELD_GENERATOR_VERSION));
	assertThat(data.getCurrentTime().getTime(), is(TEST_DATE));
	assertThat(data.getVersion(), is(FIELD_VERSION));
	assertThat(data.getUploadKeys().size(), is(1));
	final UploadKey uploadKey = data.getUploadKeys().get(0);
	assertThat(uploadKey.getKey(), is(FIELD_KEY));
	assertThat(uploadKey.getName(), is(FIELD_NAME));
	final List<String> columns = data.getColumns();
	assertThat(columns.size(), is(COLUMNS_ORDER.length));
	assertThat(columns.get(0), is(COLUMNS_ORDER[0]));
    }

    private void createOrderData(final List<UploadKey> keys) {
	orderData = new RawData();
	orderData.setUploadKeys(keys);
	orderData.setColumns(Arrays.asList(COLUMNS_ORDER));
	orderData.setResultType("orders");
	orderData.setVersion(FIELD_VERSION);
	orderData.setGenerator(new Generator(FIELD_GENERATOR_NAME, FIELD_GENERATOR_VERSION));
	orderData.setCurrentTime(new Date(TEST_DATE));
	final List<RawRowset> orderRowsets = new ArrayList<RawRowset>();
	final RawRowset rowsetOrder = new RawRowset();
	rowsetOrder.setGeneratedAt(new Date(TEST_DATE));
	rowsetOrder.setRegionID(FIELD_REGION);
	rowsetOrder.setTypeID(FIELD_TYPEID);
	final List<List<String>> orderRows = new ArrayList<List<String>>();
	orderRows.add(Arrays.asList(DATA_ORDER));
	rowsetOrder.setRows(orderRows);
	orderRowsets.add(rowsetOrder);
	orderData.setRowsets(orderRowsets);
    }

    @Test
    public void testOrderConversion() throws IllegalAccessException, IllegalArgumentException,
    InvocationTargetException, ParseException {
	final GenericData<?> data = classToTest.convert(orderData);
	assertThat(data, instanceOf(OrderData.class));
	final OrderData order = (OrderData) data;
	final List<GenericRowset<OrderRow>> rowsets = order.getRowsets();
	assertThat(rowsets.size(), is(1));
	final GenericRowset<OrderRow> genericRowset = rowsets.get(0);
	assertThat(genericRowset.getRegionID(), is(FIELD_REGION));
	assertThat(genericRowset.getTypeID(), is(FIELD_TYPEID));
	assertThat(genericRowset.getGeneratedAt().getTime(), is(TEST_DATE));
	assertThat(genericRowset.getRows().size(), is(1));
	final OrderRow orderRow = genericRowset.getRows().get(0);
	checkFieldsAgainstArray(orderRow, COLUMNS_ORDER, DATA_ORDER);
    }

    private void createHistoryData(final List<UploadKey> keys) {
	historyData = new RawData();
	historyData.setResultType("history");
	historyData.setUploadKeys(keys);
	historyData.setColumns(Arrays.asList(COLUMNS_HISTORY));
	historyData.setVersion(FIELD_VERSION);
	historyData.setGenerator(new Generator(FIELD_GENERATOR_NAME, FIELD_GENERATOR_VERSION));
	historyData.setCurrentTime(new Date(TEST_DATE));
	final List<RawRowset> historyRowsets = new ArrayList<RawRowset>();
	final RawRowset rowsetHistory = new RawRowset();
	rowsetHistory.setGeneratedAt(new Date(TEST_DATE));
	rowsetHistory.setRegionID(FIELD_REGION);
	rowsetHistory.setTypeID(FIELD_TYPEID);
	final List<List<String>> historyRows = new ArrayList<List<String>>();
	historyRows.add(Arrays.asList(DATA_HISTORY));
	rowsetHistory.setRows(historyRows);
	historyRowsets.add(rowsetHistory);
	historyData.setRowsets(historyRowsets);
    }

    @Test
    public void testHistoryConversion() throws IllegalAccessException, IllegalArgumentException,
    InvocationTargetException, ParseException {
	final GenericData<?> data = classToTest.convert(historyData);
	assertThat(data, instanceOf(HistoryData.class));
	final HistoryData history = (HistoryData) data;
	final List<GenericRowset<HistoryRow>> rowsets = history.getRowsets();
	assertThat(rowsets.size(), is(1));
	final GenericRowset<HistoryRow> genericRowset = rowsets.get(0);
	assertThat(genericRowset.getRegionID(), is(FIELD_REGION));
	assertThat(genericRowset.getTypeID(), is(FIELD_TYPEID));
	assertThat(genericRowset.getGeneratedAt().getTime(), is(TEST_DATE));
	assertThat(genericRowset.getRows().size(), is(1));
	final HistoryRow historyRow = genericRowset.getRows().get(0);
	checkFieldsAgainstArray(historyRow, COLUMNS_HISTORY, DATA_HISTORY);
    }

    private void checkFieldsAgainstArray(final Object row, final String[] columns, final String[] data)
	    throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, ParseException {
	final Method[] methods = row.getClass().getMethods();
	for (int pos = 0; pos < columns.length; pos++) {
	    for (final Method meth : methods) {
		if (meth.getName().startsWith("get")
			&& meth.getName().toLowerCase().endsWith(columns[pos].toLowerCase())) {
		    final Object result = meth.invoke(row);
		    if (result instanceof Date) {
			final long time = dateFormat.parse(data[pos]).getTime();
			assertThat(((Date) result).getTime(), is(time));
		    } else {
			assertThat(result.toString(), is(data[pos]));
		    }
		}
	    }
	}
    }
}
