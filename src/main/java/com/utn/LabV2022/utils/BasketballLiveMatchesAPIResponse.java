package com.utn.LabV2022.utils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BasketballLiveMatchesAPIResponse {
    private List<Object> matches;
}
