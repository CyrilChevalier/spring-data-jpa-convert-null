package com.example.attributeconverterdemo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * <p>
 *                  Demo entity with converter
 * </p>
 *
 * @author Ccr
 * @since 1.22.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "my_entity")
public class MyEntity implements Serializable {

    // Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "my_entity_generator")
    @SequenceGenerator(name = "my_entity_generator", sequenceName = "my_entity_seq", schema = "public", allocationSize = 1)
    private Long id;

    @Column
    private String name;

    @Column
    @Convert(converter = MyConverter.class)
    private LocalDate date;
}
