package uz.pdp.appsecurityforme.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.appsecurityforme.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {


}
