package com.wex.infra.adapter.out.treasury_api.dto.response;

import lombok.Data;

import java.util.List;

@Data
public class ResponseAPI {

    private List<ResponseExchangeRate> data;
    private Meta meta;
    private Link links;
}
