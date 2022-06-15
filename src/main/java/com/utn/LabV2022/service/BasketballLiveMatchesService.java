package com.utn.LabV2022.service;

import com.utn.LabV2022.domain.MatchData;
import com.utn.LabV2022.exceptions.NotLiveMatchesException;
import org.springframework.web.client.HttpClientErrorException;

import java.io.IOException;
import java.util.List;

public interface BasketballLiveMatchesService {

    List<MatchData> getLiveMatchsData ()
            throws IOException, InterruptedException, NotLiveMatchesException;

}
