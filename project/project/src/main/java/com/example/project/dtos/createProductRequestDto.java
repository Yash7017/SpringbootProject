package com.example.project.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class createProductRequestDto {
    private String title;
    private String image;
    private String Description;
    private String category;
    private double price;
}
