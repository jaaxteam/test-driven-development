package com.jaax.testdrivendevelopment.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Local {
    private Long id;
    private String name;
    private String floor;
}
