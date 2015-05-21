package com.home.user.web.facade.util;

import org.springframework.core.convert.converter.GenericConverter;

import javax.annotation.Nonnull;
import java.util.List;


/**
 *
 *
 */
public interface UniversalConverter extends GenericConverter {

    @Nonnull
    <T> List<T> convertList(@Nonnull final List<?> items, @Nonnull final Class<T> clazz);


    @Nonnull
    <T> T convert(@Nonnull final Object o, @Nonnull final Class<T> clazz);
}
