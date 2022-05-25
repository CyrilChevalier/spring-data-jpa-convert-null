package com.example.attributeconverterdemo;

import com.example.attributeconverterdemo.domain.MyEntity;
import com.example.attributeconverterdemo.repo.MyEntityRepo;
import org.assertj.core.api.junit.jupiter.InjectSoftAssertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
class AttributeConverterDemoApplicationTests {

    @Autowired
    private MyEntityRepo                myRepo;

    @Test
    void contextLoads() {
        myRepo.save(MyEntity.builder().name("TEST").date(LocalDate.now()).build());
        myRepo.save(MyEntity.builder().name("Null").date(null).build());
        List<MyEntity> dates = myRepo.findByDate(LocalDate.now());
        dates = myRepo.findByDate(null);
    }

}
