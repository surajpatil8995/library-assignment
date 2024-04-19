package com.management.library.service;

import com.management.library.model.Book;
import com.management.library.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ApplicationServiceImpl implements ApplicationService {

    User user;
    List<Book> books;

    public ApplicationServiceImpl( @Autowired @Qualifier("getUser") User user, @Autowired List<Book> books) {
        this.user = user;
        this.books = books;
    }

    @Override
    public List<Book> getBooks() {
        return books;
    }

    @Override
    public Map<Integer, String> process(RequestDto dto) {

        var bookIds = dto.bookIds();
        var action = dto.action();

        var responseMap = new HashMap<Integer, String>();

        bookIds.forEach(id -> responseMap.put(id, processBook(action, id)));

        return responseMap;
    }

    @Override
    public User getUserDetails() {
        return user;
    }

    private String processBook(String action, int bookId) {
        var optionalBook = books.stream().filter(b -> b.getId() == bookId).findFirst();

        if(optionalBook.isEmpty())
            return "Book not found";

        var book = optionalBook.get();

        if(action.equalsIgnoreCase("borrow"))
        {
            if(book.getCopies() == 0 )
                return "No copies available";

            if(user.getBorrowedBooks().contains(book.getName()))
                return "Already Borrowed";

            if(user.getBorrowedBooks().size() == 2)
                return "Limit Reached. You cannot borrow more than 2 books.";

            book.setCopies(book.getCopies() - 1);
            user.getBorrowedBooks().add(book.getName());
            return "Borrowed Successfully";
        }

        if(action.equalsIgnoreCase("return")) {

            if(!user.getBorrowedBooks().contains(book.getName()))
                return "Book not found in borrowed list";

            book.setCopies(book.getCopies() + 1);
            user.getBorrowedBooks().remove(book.getName());
            return "Returned Successfully";
        }

        return "Incorrect Action passed";
    }
}
