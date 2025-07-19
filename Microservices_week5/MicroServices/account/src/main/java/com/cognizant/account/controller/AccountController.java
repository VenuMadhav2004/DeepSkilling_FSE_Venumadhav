package com.cognizant.account.controller;

import com.cognizant.model.Account;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    // Temporary in-memory storage
    private Map<String, Account> accounts = new HashMap<>();

    // GET by account number
    @GetMapping("/{number}")
    public ResponseEntity<?> getAccount(@PathVariable String number) {
        Account account = accounts.get(number);
        if (account != null) {
            return ResponseEntity.ok(account);
        } else {
            return ResponseEntity.status(404).body("Account not found");
        }
    }

    // POST to create new account
    @PostMapping
    public ResponseEntity<String> createAccount(@RequestBody Account account) {
        accounts.put(account.getNumber(), account);
        return ResponseEntity.ok("Account created: " + account.getName());
    }
}
