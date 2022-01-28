package com.remo.associationsapi.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DataListItemDto {
    private String id;
    private String symbol;
    private String name;
    private Double overall;
}
