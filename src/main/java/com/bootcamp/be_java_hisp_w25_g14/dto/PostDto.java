package com.bootcamp.be_java_hisp_w25_g14.dto;


import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.*;


//@Data
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PostDto {

    Integer post_id;

    @NotNull(message = "The field user_id cannot be empty")
    @Min(value = 1,message = "the user_id cannot be 0 or negative")
    Integer user_id;

    @NotEmpty(message = "The field date cannot be empty")
    @NotBlank
    @Pattern(regexp = "(0[1-9]|[12][0-9]|3[01])-(0[1-9]|1[1,2])-(19|20)\\d{2}$", message = "the correct date format is dd-MM-YYYY")
    //@Pattern(regexp = "([0-2][0-9]|(3)[0-1])(\\-)(((0)[0-9])|((1)[0-2]))(\\-)\\d{4}$",message = "fail")
    String date;

    @NotNull(message = "The field  product cannot be empty")
    ProductDto product;

    @NotNull(message = "The field  category cannot be empty")
    Integer category;

    @NotNull(message = "The field price cannot be empty")
    @Max(value = 10000000,message = "the price cannot be more than 10.000.000")
    Double price;

}
