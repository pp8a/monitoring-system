package com.example.monitorsensors;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;


@SpringBootTest
class MonitorSensorsApplicationTests {
    @Autowired
    private ApplicationContext applicationContext;

    /**
     * Test to ensure the application context loads successfully.
     */
    @Test
    void contextLoads() {
        assertThat(applicationContext).isNotNull();
    }
}
