package com.amit.rest.examples.pojo;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;
 
public class DateSerializer extends JsonSerializer<Date>{
 
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
     
	@Override
	public void serialize(Date date, JsonGenerator generator, SerializerProvider provider)
			throws IOException, JsonProcessingException {
		String formattedDate = dateFormat.format(date);
        generator.writeString(formattedDate);		
	}
     
     
}