package com.utn.LabV2022.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class MatchData {

    @JsonProperty("League")
    private String league;

    @JsonProperty("Home Team")
    private String homeTeam;

    @JsonProperty("Home Score")
    private Integer homeScore;

    @JsonProperty("Away Team")
    private String awayTeam;

    @JsonProperty("Away Score")
    private Integer awayScore;

    @JsonProperty("Status")
    private String status;


    /*
    "League":"International Friendly Games, Women"
    "Home Team":"Serbia"
    "Away Team":"Poland"
    "Home Score":31
    "Away Score":45
    "Status":"Pause"
    */

    /*
    XXX "Away Score":45
    XXX "Away Team":"Poland"
    XXX "Home Score":31
    XXX "Home Team":"Serbia"
    "Initial Away Odd":NULL
    "Initial Home Odd":NULL
    XXX "League":"International Friendly Games, Women"
    "League ID":1927
    "Live Away Odd":NULL
    "Live Home Odd":NULL
    "Match ID":"10365420"
    "Period 1 Away":23
    "Period 1 Home":18
    "Period 2 Away":22
    "Period 2 Home":13
    "Period 3 Away":"None"
    "Period 3 Home":"None"
    XXX "Status":"Pause"
    */
}
