package io.github.andyswe.elva.data;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

class StandardSerializer extends StdSerializer<Measurement> {


    protected StandardSerializer(Class<Measurement> t) {
        super(t);
    }

    @Override
    public void serialize(Measurement value, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonGenerationException {


    }
}