package com.bootcamp.be_java_hisp_w25_g14.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductDto {

     @NotNull(message = "The field cannot be empty")
     Integer product_id;

     @NotBlank(message = "The field cannot be empty")
     @Max(value = 40, message = "the name is too long, 40 characters max")
     String product_name;

     @NotBlank(message = "The field cannot be empty")
     @Max(value = 15, message = "the type is too long, 15 characters max")
     String type;

     @NotBlank(message = "The field cannot be empty")
     @Max(value = 25, message = "the brand is too long, 25 characters max")
     String brand;

     @NotBlank(message = "The field cannot be empty")
     @Max(value = 15, message = "the color is too long, 15 characters max")
     String color;

     @NotBlank(message = "The field cannot be empty")
     @Max(value = 80, message = "the notes is too long, 80 characters max")
     String notes;


}
