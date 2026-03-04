package example.day05.practice5;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    // 도서 등록
    public boolean addBook(BookDto bookDto){
        BookEntity bookEntity = new BookEntity();
        bookEntity.setName(bookDto.getName());
        bookEntity.setAuthor(bookDto.getAuthor());
        bookEntity.setPublisher(bookDto.getPublisher());

        BookEntity save = bookRepository.save(bookEntity);
        return save.getId() >= 1;
    }

    // 도서 전체 조회
    public List<BookDto> findAllBooks(){
        List<BookEntity> bookEntities = bookRepository.findAll();
        List<BookDto> bookDtoList = new ArrayList<>();
        bookEntities.forEach(book -> {
            BookDto bookDto = new BookDto();
            bookDto.setId(book.getId());
            bookDto.setName(book.getName());
            bookDto.setAuthor(book.getAuthor());
            bookDto.setPublisher(book.getPublisher());
            bookDtoList.add(bookDto);
        });
        return bookDtoList;
    }

    // 특정 도서 수정
    public boolean updateBook(BookDto bookDto){
        Optional<BookEntity> optional = bookRepository.findById(bookDto.getId());
        if(optional.isPresent()){
            BookEntity bookEntity = optional.get();
            bookEntity.setName(bookDto.getName());
            bookEntity.setAuthor(bookDto.getAuthor());
            bookEntity.setPublisher(bookDto.getPublisher());
            return true;
        }
        return false;
    }

    // 특정 도서 삭제
    public boolean deleteBook(Long bookId){
        bookRepository.deleteById(bookId);
        return bookRepository.findById(bookId).isEmpty(); // 비어있으면 성공, 안비어있으면 실패
    }

}
