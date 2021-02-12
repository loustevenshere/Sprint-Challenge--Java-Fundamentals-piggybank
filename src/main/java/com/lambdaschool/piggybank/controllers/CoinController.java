package com.lambdaschool.piggybank.controllers;

import com.lambdaschool.piggybank.models.Coin;
import com.lambdaschool.piggybank.repositories.CoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CoinController {

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
}
