package uz.pdp.appsecurityforme.controller;

import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.appsecurityforme.dto.BookDTO;
import uz.pdp.appsecurityforme.payload.ApiResult;

import java.util.List;


@RequestMapping(BookController.BASE_PATH)
public interface BookController {

    String BASE_PATH = "/api/book";

    @GetMapping("/list")
    HttpEntity<ApiResult<List<BookDTO>>> getAll();

    @GetMapping("/{id}")
    HttpEntity<ApiResult<BookDTO>> getById(@PathVariable Long id);

    @PostMapping("/create")
    HttpEntity<ApiResult<BookDTO>> create(@RequestBody BookDTO bookDTO);

    @PutMapping("update/{id}")
    HttpEntity<ApiResult<BookDTO>> update(@PathVariable Long id, @RequestBody BookDTO bookDTO);

    @DeleteMapping("/{id}")
    void deleteById(@PathVariable Long id);

    @DeleteMapping("/deleteAllBook")
    void deleteAll();


}
