package uz.pdp.appsecurityforme.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.appsecurityforme.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {


    Optional<User> findByEmail(String email);
    Optional<User> findById(Long id);


}
