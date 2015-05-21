package com.home.user.web.facade.util;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.GenericConverter;
import org.springframework.stereotype.Service;

import javax.annotation.Nonnull;
import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@Service("universalConverter")
public class UniversalConverterImpl implements UniversalConverter {

    @Autowired(required = false)
    private Mapper mapper;

    @PostConstruct
    public void verifyMapperPresence() {
        if (mapper == null) {
            mapper = new DozerBeanMapper();
        }
    }


    /**
     * {@inheritDoc}
     */
    @Nonnull
    @Override
    public <T> List<T> convertList(@Nonnull final List<?> items, @Nonnull final Class<T> clazz) {

        final List<T> convertedItems = new ArrayList<T>(items.size());

        for (Object item : items) {
            convertedItems.add(mapper.map(item, clazz));
        }

        return convertedItems;
    }


    /**
     * {@inheritDoc}
     */
    @Nonnull
    @Override
    public <T> T convert(@Nonnull final Object o, @Nonnull final Class<T> clazz) {
        return mapper.map(o, clazz);
    }


    /**
     * {@inheritDoc}
     */
    public Set<ConvertiblePair> getConvertibleTypes() {
        return Collections.singleton(new GenericConverter.ConvertiblePair(Object.class, Object.class));
    }


    /**
     * {@inheritDoc}
     */
    public Object convert(final Object aSource, final TypeDescriptor aSourceType, final TypeDescriptor aTargetType) {
        return mapper.map(aSource, aTargetType.getType());
    }
}
