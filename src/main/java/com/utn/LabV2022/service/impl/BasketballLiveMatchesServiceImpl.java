package com.utn.LabV2022.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.utn.LabV2022.domain.MatchData;
import com.utn.LabV2022.exceptions.NotLiveMatchesException;
import com.utn.LabV2022.service.BasketballLiveMatchesService;
import com.utn.LabV2022.utils.BasketballLiveMatchesAPIResponse;
import com.utn.LabV2022.utils.JsonBodyHandler;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.awt.desktop.SystemSleepEvent;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Timer;

@Service
public class BasketballLiveMatchesServiceImpl implements BasketballLiveMatchesService {
    @Override
    public List<MatchData> getLiveMatchsData()
            throws IOException, InterruptedException, NotLiveMatchesException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://sports-live-scores.p.rapidapi.com/basketball/live"))
                .header("X-RapidAPI-Key", "ae9c85b3camshac78462742b46e3p124a48jsncd3573d90d8b")
                .header("X-RapidAPI-Host", "sports-live-scores.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
//        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
//        System.out.println(response.body());

        HttpResponse<BasketballLiveMatchesAPIResponse> response = HttpClient.newHttpClient().send(request, new JsonBodyHandler<>(BasketballLiveMatchesAPIResponse.class));

        ObjectMapper mapper = new ObjectMapper();
        List<MatchData> liveMatchesList = mapper.readValue(JsonBodyHandler.convertFromObjectToJson(response.body().getMatches()), new TypeReference<List<MatchData>>(){});

        ///// ---> For test the exception /////
//        liveMatchesList = Collections.emptyList();

        ///// ---> For test the resilience /////
//        Timer timer = new Timer();
//        timer.wait(50000);

        if (liveMatchesList.isEmpty())
            throw new NotLiveMatchesException();
        else return liveMatchesList;
    }
}
