package spring.BankomatSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.BankomatSystem.entity.Card;

import java.util.Optional;

public interface CardRepository extends JpaRepository<Card,Integer> {
    boolean existsByNumber(String number);
    Optional<Card> getCardByNumber(String number);
}
