package net.troja.eve.uudif;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;

import net.troja.eve.uudif.general.GeneralData;
import net.troja.eve.uudif.raw.RawData;

import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class ParsingTest {
    private ObjectMapper mapper = new ObjectMapper();
    
    @Before
    public void init() {
	mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
	mapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
	mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX"));
    }

    @Test
    public void testOrderParsing() throws IOException {
	String file = readFile("src/test/resources/orders.txt");
	GeneralData data = mapper.readValue(file, RawData.class);
	String json = mapper.writeValueAsString(data);
	assertEquals(file.length(), json.length());
    }

    @Test
    public void testHistoryParsing() throws IOException {
	String file = readFile("src/test/resources/history.txt");
	GeneralData data = mapper.readValue(file, RawData.class);
	String json = mapper.writeValueAsString(data);
	assertEquals(file.length(), json.length());
    }
    
    private String readFile(String file) throws FileNotFoundException, IOException {
	BufferedReader reader = new BufferedReader(new FileReader(file));
	String line;
	StringBuilder builder = new StringBuilder();
	while((line = reader.readLine()) != null) {
	    builder.append(line);
	}
	reader.close();
	return builder.toString();
    }
}
