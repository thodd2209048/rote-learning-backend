package com.example.demo.features.quote;

import com.example.demo.exception.ObjectNotFoundException;
import com.example.demo.features.quote.dto.AddQuoteDto;
import com.example.demo.features.quote.dto.UpdateQuoteDto;
import com.example.demo.features.quote.reponse.QuoteResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class QuoteService {
    private final QuoteRepository repository;
    private final QuoteMapper mapper;

    @Autowired
    public QuoteService(QuoteRepository repository,
                        QuoteMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Page<QuoteResponse> listQuote(Pageable pageable) {
        return repository.findAll(pageable).map(mapper::toQuoteResponse);
    }

    public QuoteResponse getQuoteRandomly() {
        Long size = repository.count();
        if(size==0) return null;
        Random random = new Random(System.currentTimeMillis());
        Long randomId = random.nextLong(size) + 1;
        return mapper.toQuoteResponse(this.getQuote(randomId));
    }

    public QuoteResponse addQuote(AddQuoteDto addQuoteDto) {
        Quote quote = mapper.fromAddQuoteDto(addQuoteDto);
        repository.save(quote);
        return mapper.toQuoteResponse(quote);
    }

    public QuoteResponse updateQuote(Long id, UpdateQuoteDto updateQuoteDto) {
        Quote quote = this.getQuote(id);
        mapper.fromUpdateQuoteDto(updateQuoteDto, quote);

        repository.save(quote);

        return mapper.toQuoteResponse(quote);
    }

    private Quote getQuote(Long id){
       return repository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Quote with id: "+ id + " does not exist." ));
    }
}
