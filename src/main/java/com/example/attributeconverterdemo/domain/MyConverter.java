package com.example.attributeconverterdemo.domain;

import liquibase.pro.packaged.N;

import javax.persistence.AttributeConverter;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * <p>
 *                  Attribute Converter for converting Long --> LocalDate
 * </p>
 *
 * @author Ccr
 * @since 1.22.0
 */
public class MyConverter implements AttributeConverter<LocalDate, Long> {

    // --------------------------------------------- AttributeConverter -------------------------------------------------------
    /**
     * Converts the value stored in the entity attribute into the
     * data representation to be stored in the database.
     *
     * @param attribute the entity attribute value to be converted
     * @return the converted data to be stored in the database
     * column
     */
    @Override
    public Long convertToDatabaseColumn(LocalDate attribute) {
        return attribute !=null ? attribute.atStartOfDay(ZoneOffset.UTC).toInstant().toEpochMilli() : 0L;
    }

    /**
     * Converts the data stored in the database column into the
     * value to be stored in the entity attribute.
     * Note that it is the responsibility of the converter writer to
     * specify the correct <code>dbData</code> type for the corresponding
     * column for use by the JDBC driver: i.e., persistence providers are
     * not expected to do such type conversion.
     *
     * @param dbData the data from the database column to be
     *               converted
     * @return the converted value to be stored in the entity
     * attribute
     */
    @Override
    public LocalDate convertToEntityAttribute(Long dbData) {
        return dbData!=null && dbData!=0 ? Instant.ofEpochMilli(dbData).atZone(ZoneOffset.UTC).toLocalDate() : null;
    }
}
