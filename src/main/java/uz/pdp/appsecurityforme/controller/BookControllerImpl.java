package uz.pdp.appsecurityforme.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.appsecurityforme.dto.BookDTO;
import uz.pdp.appsecurityforme.payload.ApiResult;
import uz.pdp.appsecurityforme.service.BookService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BookControllerImpl implements BookController {

    private final BookService bookService;

    @Override
    public HttpEntity<ApiResult<List<BookDTO>>> getAll() {
        return null;
    }

    @Override
    public HttpEntity<ApiResult<BookDTO>> getById(Long id) {
        return null;
    }

    @Override
    public HttpEntity<ApiResult<BookDTO>> create(BookDTO bookDTO) {
        return null;
    }

    @Override
    public HttpEntity<ApiResult<BookDTO>> update(Long id, BookDTO bookDTO) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void deleteAll() {

    }
}
