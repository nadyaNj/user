package com.home.user.services.common.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * User: Vazgen Danielyan
 * Company: SFL LLC
 * Date: 9/16/14
 * Time: 4:47 PM
 */
@Converter(autoApply = true)
public class PersistentLocalDateTimeConverter implements AttributeConverter<LocalDateTime, Timestamp> {

    @Override
    public Timestamp convertToDatabaseColumn(LocalDateTime value) {
        return value == null ? null : Timestamp.valueOf(value);
    }

    @Override
    public LocalDateTime convertToEntityAttribute(Timestamp value) {
        return value == null ? null : value.toLocalDateTime();
    }
}