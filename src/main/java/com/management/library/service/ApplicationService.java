package com.management.library.service;

import com.management.library.model.Book;
import com.management.library.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public interface ApplicationService {
    record RequestDto(String action, List<Integer> bookIds){}

    @GetMapping("/books")
    List<Book> getBooks();

    @PostMapping("/books")
    Map<Integer, String> process(@RequestBody RequestDto dto);

    @GetMapping("/user")
    User getUserDetails();
}
