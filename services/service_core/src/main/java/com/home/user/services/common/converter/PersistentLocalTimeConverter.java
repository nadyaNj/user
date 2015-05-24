package com.home.user.services.common.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.sql.Time;
import java.time.LocalTime;

/**
 * User: Vazgen Danielyan
 * Company: SFL LLC
 * Date: 9/16/14
 * Time: 7:29 PM
 */
@Converter(autoApply = true)
public class PersistentLocalTimeConverter implements AttributeConverter<LocalTime, Time> {

    @Override
    public Time convertToDatabaseColumn(LocalTime attribute) {
        return attribute == null ? null : Time.valueOf(attribute);
    }

    @Override
    public LocalTime convertToEntityAttribute(Time dbData) {
        return dbData == null ? null : dbData.toLocalTime();
    }
}
