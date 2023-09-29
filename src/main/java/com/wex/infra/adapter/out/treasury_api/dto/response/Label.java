package com.wex.infra.adapter.out.treasury_api.dto.response;

import lombok.Data;

@Data
public class Label {
    private String country;
    private String currency;
    private String effectiveDate;
    private String rate;
}
