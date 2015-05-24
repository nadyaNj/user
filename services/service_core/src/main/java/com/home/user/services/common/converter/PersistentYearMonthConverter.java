package com.home.user.services.common.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.sql.Date;
import java.time.YearMonth;

/**
 * User: Vazgen Danielyan
 * Company: SFL LLC
 * Date: 9/16/14
 * Time: 4:47 PM
 */
@Converter(autoApply = true)
public class PersistentYearMonthConverter implements AttributeConverter<YearMonth, Date> {

    @Override
    public Date convertToDatabaseColumn(YearMonth value) {
        return value == null ? null : Date.valueOf(value.atDay(1));
    }

    @Override
    public YearMonth convertToEntityAttribute(Date value) {
        return value == null ? null : YearMonth.from(value.toLocalDate());
    }
}