package com.lambdaschool.piggybank.controllers;

import com.lambdaschool.piggybank.models.Coin;
import com.lambdaschool.piggybank.repositories.CoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CoinController {
    private static void CheckCoins(List<Coin> coinList, CheckCoin tester)
    {
        for (Coin c: coinList )
        {
            // if c.getQuantity > 1
            if (tester.test(c))
            {
                System.out.println(c.getQuantity() + " " + c.getNameplural());
            }
            else {
                System.out.println(c.getQuantity() + " " + c.getName());
            }
        }

    }



    @Autowired
    CoinRepository coinrepos;

    // http://localhost:2019/coins
    @GetMapping(value = "/coins", produces = {"application/json"})
    public ResponseEntity<?> listAllCoins()
    {
        List<Coin> coinList = new ArrayList<>();
        coinrepos.findAll().iterator().forEachRemaining(coinList::add);

        return new ResponseEntity<>(coinList, HttpStatus.OK);
    }

    // http://localhost:2019/total
    @GetMapping(value = "/total", produces = {"application/json"})
    public ResponseEntity<?> coinTotal()
    {
        List<Coin> coinList = new ArrayList<>();
        coinrepos.findAll().iterator().forEachRemaining(coinList::add);

        double total = 0;
        for (Coin c : coinList)
        {
            total += c.getValue() * c.getQuantity();
        }

        // Call check coins and give conditional statement in lambda expression
        CheckCoins(coinList, c -> c.getQuantity() > 1);

        System.out.println("The piggy bank holds " + total);
        return new ResponseEntity<>(total, HttpStatus.OK);
    }

    // http://localhost:2019/money/{amount}
    @GetMapping(value = "/money/{amount}", produces = {"application/json"})
    public ResponseEntity<?> subtractCoins(@PathVariable double amount)
    {
        List<Coin> coinList = new ArrayList<>();
        coinrepos.findAll().iterator().forEachRemaining(coinList::add);

        double total = 0;
        for (Coin c : coinList)
        {
            total += c.getValue() * c.getQuantity();
        }
        // Checking to make sure theres enough money in the bank to subtract
        if(total > amount) {
            total -= amount;
        }
        else {
            System.out.println("Money is not available");
        }

        System.out.println("The old total: 7.3 " +  "The new total: " + total + " The amount subtracted: " + amount);
        return new ResponseEntity<>(total, HttpStatus.OK);

    }




}
