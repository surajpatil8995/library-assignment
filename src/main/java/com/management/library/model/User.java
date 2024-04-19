package com.management.library.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class User {
    int userId;
    String name;
    List<String> borrowedBooks;
}
