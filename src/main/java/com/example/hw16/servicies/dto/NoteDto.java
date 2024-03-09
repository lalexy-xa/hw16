package com.example.hw16.servicies.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class NoteDto {
    private UUID id = null;
    private String title;
    private String content;
}
