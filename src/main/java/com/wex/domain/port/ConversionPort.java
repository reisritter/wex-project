package com.wex.domain.port;

import com.wex.domain.model.ConvertedAmount;

public interface ConversionPort {
    ConvertedAmount get(Long id);
    ConvertedAmount getByCountry(Long id,String name);
}
