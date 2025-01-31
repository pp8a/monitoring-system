package com.example.sensorstatistics.enums;

import java.util.Arrays;

public enum SensorType {
	PRESSURE(1),
    VOLTAGE(2),
    TEMPERATURE(3),
    HUMIDITY(4);

    private final int code;

    SensorType(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static SensorType fromCode(int code) {
        return Arrays.stream(SensorType.values())
                .filter(t -> t.code == code)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unknown sensor type code: " + code)); 
    }

}
