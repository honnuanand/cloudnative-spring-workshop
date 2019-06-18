package io.pivotal;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.GetMapping;
import io.pivotal.domain.*;


@FeignClient(name = "${feign-target}", fallbackFactory = CityClientFallbackFactory.class)
public interface CityClient {

    @GetMapping(value="/cities", consumes="application/hal+json")
    Resources<City> getCities();
}