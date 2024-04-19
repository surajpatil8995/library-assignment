package com.management.library.model;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Book {
    int id;
    String name;
    String author;
    String genre;
    int publicationYear;
    double price;
    int copies;
}
