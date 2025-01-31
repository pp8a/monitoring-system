package com.example.monitorsensors.dto;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SensorDTO {
    @NotBlank(message = "Name is required")
    @Size(min = 3, max = 30, message = "Name must be between 3 and 30 characters")
    private String name;

    @NotBlank(message = "Model is required")
    @Size(max = 15, message = "Model must not exceed 15 characters")
    private String model;

    @NotNull(message = "Type is required")
    private Integer type;  // ID 

    private Integer unit;  // ID 

    @NotNull(message = "Range from is required")
    @Min(-1000) @Max(1000)
    private Integer rangeFrom;

    @NotNull(message = "Range to is required")
    @Min(-1000) @Max(1000)
    private Integer rangeTo;

    @AssertTrue(message = "Range from must be less than range to")
    public boolean isRangeValid() {
        return rangeFrom != null && rangeTo != null && rangeFrom < rangeTo;
    }

    @Size(max = 40, message = "Location must not exceed 40 characters")
    private String location;

    @Size(max = 200, message = "Description must not exceed 200 characters")
    private String description;
}
