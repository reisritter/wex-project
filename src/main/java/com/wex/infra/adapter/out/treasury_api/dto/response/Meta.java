package com.wex.infra.adapter.out.treasury_api.dto.response;

import lombok.Data;

@Data
public class Meta {

    private long count;

    private Label labels;
    private Label dataTypes;
    private Label dataFormats;
    private long total_count;
    private long total_pages;

}
