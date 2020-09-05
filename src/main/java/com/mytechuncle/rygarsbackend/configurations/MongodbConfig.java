package com.mytechuncle.rygarsbackend.configurations;

import com.mytechuncle.rygarsbackend.configurations.converters.CalendarReader;
import com.mytechuncle.rygarsbackend.configurations.converters.CalendarWriter;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions.MongoConverterConfigurationAdapter;

@Configuration
public class MongodbConfig extends AbstractMongoClientConfiguration {


    @Override
    protected String getDatabaseName() {
        return "test";
    }

    @Override
    protected void configureConverters(MongoConverterConfigurationAdapter adapter) {
        adapter.registerConverter(new CalendarReader());
        adapter.registerConverter(new CalendarWriter());
    }
}
