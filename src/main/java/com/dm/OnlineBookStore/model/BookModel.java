package com.dm.OnlineBookStore.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookModel {

    private Long id;
    private String name;
    private String description;
    private String author;
    private String type;
    private double price;
    private String isbn;
    //@Min(value = 0, message = "Price should be positive value.")
    //@Min(value = 0, message = "Total Count should be positive value.")



}
