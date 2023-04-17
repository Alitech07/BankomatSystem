package spring.BankomatSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.BankomatSystem.entity.Bank;
import spring.BankomatSystem.entity.Card;
import spring.BankomatSystem.payload.ApiResponse;
import spring.BankomatSystem.payload.CardDto;
import spring.BankomatSystem.repository.CardRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CardService {
    @Autowired
    CardRepository cardRepository;

    public List<Card> getCardsService(){
        return cardRepository.findAll();
    }

    public Card getCardService(Integer id){
        Optional<Card> optionalCard = cardRepository.findById(id);
        return optionalCard.orElse(null);
    }
    public ApiResponse addCardService(CardDto cardDto){
        boolean existsed = cardRepository.existsByNumber(cardDto.getNumber());
        if (existsed) return new ApiResponse("Bunday raqamli karta mavjud.",false);

        Card card = new Card();
        card.setNumber(cardDto.getNumber());
        card.setFullName(cardDto.getFullName());
        card.setCVV(cardDto.getCVV());
        card.setPassword(cardDto.getPassword());

        Bank bank = new Bank();
        bank.setName(cardDto.getBank().getName());
        bank.setAddress(cardDto.getBank().getAddress());
        card.setBank(bank);
        card.setCardType(cardDto.getCardType());
        cardRepository.save(card);
        return new ApiResponse("Karta saqlandi.",true);
    }

    public ApiResponse deleteCardService(Integer id){
        Optional<Card> optionalCard = cardRepository.findById(id);
        if (!optionalCard.isPresent()) return new ApiResponse("Bunday karta mavjud emas.",false);
        cardRepository.deleteById(id);
        return new ApiResponse("Carta o'chirildi.",true);
    }

    public ApiResponse chekCard(String number,String code){
        Optional<Card> optionalCard = cardRepository.getCardByNumber(number);
        if (!optionalCard.isPresent()) return new ApiResponse("Bunday carta mavjud emas.",false);
        Card card = optionalCard.get();
        if (!card.getPassword().equals(code)) return new ApiResponse("Parol xato 3 martada xato terilsa bloklanadi.",false);
        return new ApiResponse("Tizimga hush kelibsiz.",true,card);
    }
}
