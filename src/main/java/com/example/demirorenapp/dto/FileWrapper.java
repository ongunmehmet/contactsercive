package com.example.demirorenapp.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class FileWrapper {
    private List<ContactDto> contacts;
}
