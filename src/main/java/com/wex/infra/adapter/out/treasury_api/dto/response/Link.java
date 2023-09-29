package com.wex.infra.adapter.out.treasury_api.dto.response;

import lombok.Data;

@Data
public class Link {
    private String self;
    private String first;
    private String prev;
    private String next;
    private String last;

}
