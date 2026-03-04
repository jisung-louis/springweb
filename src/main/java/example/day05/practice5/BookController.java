package example.day05.practice5;

import example.day05.mvc.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    BookService bookService;

    @PostMapping
    public boolean addBook(@RequestBody BookDto bookDto){
        return bookService.addBook(bookDto);
    }

    @GetMapping
    public List<BookDto> findAllBooks(){
        return bookService.findAllBooks();
    }

    @PutMapping
    public boolean updateBook(@RequestBody BookDto bookDto){
        return bookService.updateBook(bookDto);
    }

    @DeleteMapping
    public boolean deleteBook(@RequestParam Long id){
        return bookService.deleteBook(id);
    }
}
