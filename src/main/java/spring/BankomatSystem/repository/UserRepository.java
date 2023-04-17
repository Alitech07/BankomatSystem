package spring.BankomatSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.BankomatSystem.entity.User;

public interface UserRepository extends JpaRepository<User,Integer> {
    boolean existsByEmail(String email);
}
