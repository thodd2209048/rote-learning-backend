package com.example.demo.features.quote;

import com.example.demo.features.quote.dto.AddQuoteDto;
import com.example.demo.features.quote.dto.UpdateQuoteDto;
import com.example.demo.features.quote.reponse.QuoteResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/quotes")
public class QuoteController {
    private final QuoteService service;

    @Autowired
    public QuoteController(QuoteService service) {
        this.service = service;
    }

    @GetMapping({"","/"})
    public Page<QuoteResponse> listQuote(Pageable pageable){
        return service.listQuote(pageable);
    }

    @GetMapping("/random")
    public QuoteResponse getQuoteRandomly(){
        return service.getQuoteRandomly();
    }

    @PostMapping({"/",""})
    public QuoteResponse addQuote(@RequestBody AddQuoteDto addQuoteDto){
        return service.addQuote(addQuoteDto);
    }

    @PutMapping("/{id}")
    public QuoteResponse updateQuote(
            @PathVariable Long id,
            @RequestBody UpdateQuoteDto updateQuoteDto
            ){
        return service.updateQuote(id, updateQuoteDto);
    }
}
