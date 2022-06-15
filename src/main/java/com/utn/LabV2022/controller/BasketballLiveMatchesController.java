package com.utn.LabV2022.controller;

import com.utn.LabV2022.domain.MatchData;
import com.utn.LabV2022.exceptions.ErrorBody;
import com.utn.LabV2022.exceptions.NotLiveMatchesException;
import com.utn.LabV2022.service.BasketballLiveMatchesService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/basketball")
public class BasketballLiveMatchesController {

    private final BasketballLiveMatchesService basketballLiveMatchesService;

    @Autowired
    public BasketballLiveMatchesController(BasketballLiveMatchesService basketballLiveMatchesService) {
        this.basketballLiveMatchesService = basketballLiveMatchesService;
    }

    @CircuitBreaker(name = "CBBasketballLiveMatches", fallbackMethod = "FBgetLiveMatches")
    @GetMapping(path = "matches/live")
    public ResponseEntity<List<MatchData>> getLiveMatches()
            throws IOException, InterruptedException, NotLiveMatchesException {
        List<MatchData> liveMatches = basketballLiveMatchesService.getLiveMatchsData();
        return ResponseEntity
                .status(liveMatches.size() != 0 ? HttpStatus.OK : HttpStatus.NO_CONTENT)
                .body(liveMatches);

    }

    private ResponseEntity<List<MatchData>> FBgetLiveMatches(RuntimeException e) {
        return new ResponseEntity(ErrorBody.builder()
                .message("Mientras reestablecemos el servicio de Basket, puede buscar datos de otros deportes!")
                .build(),
                HttpStatus.OK);
    }


}
