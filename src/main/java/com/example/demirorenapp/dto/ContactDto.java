package com.example.demirorenapp.dto;

import lombok.Data;
import lombok.ToString;

import java.util.List;
@Data
@ToString
public class ContactDto {
    private String name;
    private String lastName;
    private String phone;
}
