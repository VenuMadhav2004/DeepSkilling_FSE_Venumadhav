package com.cognizant.controller;

import com.cognizant.model.Loan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/loans")
public class LoanController {

    // Temporary in-memory storage
    private Map<String, Loan> loans = new HashMap<>();

    // GET loan by loanNumber
    @GetMapping("/{loanNumber}")
    public ResponseEntity<?> getLoan(@PathVariable String loanNumber) {
        Loan loan = loans.get(loanNumber);
        if (loan != null) {
            return ResponseEntity.ok(loan);
        } else {
            return ResponseEntity.status(404).body("Loan not found");
        }
    }

    // POST to create new loan
    @PostMapping
    public ResponseEntity<String> createLoan(@RequestBody Loan loan) {
        loans.put(loan.getLoanNumber(), loan);
        return ResponseEntity.ok("Loan created with loan number: " + loan.getLoanNumber());
    }
}
