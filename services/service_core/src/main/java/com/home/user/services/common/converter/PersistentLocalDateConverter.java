package com.home.user.services.common.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.sql.Date;
import java.time.LocalDate;

/**
 * User: Vazgen Danielyan
 * Company: SFL LLC
 * Date: 9/16/14
 * Time: 4:45 PM
 */
@Converter(autoApply = true)
public class PersistentLocalDateConverter implements AttributeConverter<LocalDate, Date> {

    @Override
    public Date convertToDatabaseColumn(final LocalDate value) {
        return value == null ? null : Date.valueOf(value);
    }

    @Override
    public LocalDate convertToEntityAttribute(final Date value) {
        return value == null ? null : value.toLocalDate();
    }
}