package io.pivotal;

import feign.hystrix.FallbackFactory;
import io.pivotal.domain.City;
import lombok.extern.slf4j.Slf4j;
import org.springframework.hateoas.Resources;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Slf4j
@Component
class CityClientFallbackFactory implements FallbackFactory<CityClient> {

    @Override
    public CityClient create(final Throwable t) {
        return new CityClient() {
            @Override
            public Resources<City> getCities() {
                log.info("Fallback triggered by {} due to {}", t.getClass().getName(), t.getMessage());
                return new Resources<City>(Collections.emptyList());
            }
        };
    }
}