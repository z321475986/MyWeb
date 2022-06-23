package com.tainan.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tainan.myweb.Suggestion;
import com.tainan.myweb.SuggestionRepository;

@RestController
@RequestMapping("/api/v1")
public class SuggestionController {
	@Autowired
    private SuggestionRepository suggestionrepository;
	@PostMapping("/suggestion")
    public Suggestion createSuggestion(@Valid @RequestBody Suggestion suggestion) {
		System.out.println(suggestion);
        return suggestionrepository.save(suggestion);
    }
}

