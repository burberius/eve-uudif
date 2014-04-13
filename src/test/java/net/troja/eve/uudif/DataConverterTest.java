package net.troja.eve.uudif;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.troja.eve.uudif.general.UploadKey;
import net.troja.eve.uudif.raw.Generator;
import net.troja.eve.uudif.raw.RawData;
import net.troja.eve.uudif.specific.GenericData;
import net.troja.eve.uudif.specific.HistoryData;
import net.troja.eve.uudif.specific.OrderData;

import org.junit.Before;
import org.junit.Test;

public class DataConverterTest {
    private static final String FIELD_GENERATOR_NAME = "genName";
    private static final String FIELD_GENERATOR_VERSION = "genVersion";
    private static final String FIELD_KEY = "key";
    private static final String FIELD_NAME = "name";
    private static final String COLUMN_1 = "col1";
    private static final String COLUMN_2 = "col2";
    private static final long TEST_DATE = 265113432334l;
    
    private DataConverter classToTest;
    private RawData orderData;
    private RawData historyData;
    
    @Before
    public void init() {
	classToTest = new DataConverter();

	UploadKey key = new UploadKey(FIELD_NAME, FIELD_KEY);
	List<UploadKey> keys = new ArrayList<UploadKey>();
	keys.add(key);
	
	List<String> columns = new ArrayList<String>();
	columns.add(COLUMN_1);
	columns.add(COLUMN_2);
	
	orderData = new RawData();
	orderData.setUploadKeys(keys);
	orderData.setColumns(columns);
	orderData.setResultType("order");
	orderData.setGenerator(new Generator(FIELD_GENERATOR_NAME, FIELD_GENERATOR_VERSION));
	orderData.setCurrentTime(new Date(TEST_DATE));
	
	historyData = new RawData();
	historyData.setResultType("history");
    }
    
    @Test
    public void testCommonConversion() {
	GenericData<?> data = classToTest.convert(orderData);
	
	assertThat(data.getGeneratorName(), is(FIELD_GENERATOR_NAME));
	assertThat(data.getGeneratorVersion(), is(FIELD_GENERATOR_VERSION));
	assertThat(data.getCurrentTime().getTime(), is(TEST_DATE));
	assertThat(data.getUploadKeys().size(), is(1));
	UploadKey uploadKey = data.getUploadKeys().get(0);
	assertThat(uploadKey.getKey(), is(FIELD_KEY));
	assertThat(uploadKey.getName(), is(FIELD_NAME));
	List<String> columns = data.getColumns();
	assertThat(columns.size(), is(2));
    }
    
    @Test
    public void testOrderConversion() {
	GenericData<?> data = classToTest.convert(orderData);
	assertThat(data, instanceOf(OrderData.class));
	
    }

    @Test
    public void testHistoryConversion() {
	GenericData<?> data = classToTest.convert(historyData);
	assertThat(data, instanceOf(HistoryData.class));
    }
}
