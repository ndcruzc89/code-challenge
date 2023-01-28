package co.segurocanguro.nelsoncruz.codechallenge.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import co.segurocanguro.nelsoncruz.codechallenge.dto.CharacterRequestDto;
import co.segurocanguro.nelsoncruz.codechallenge.dto.HouseRequestDto;

@FeignClient(name = "house-service", url = "https://www.anapioficeandfire.com/api")
public interface HousesClient {

    @GetMapping("/houses")
    List<HouseRequestDto> getHouses();

    @GetMapping("/characters/{id}")
    CharacterRequestDto getCharacters(@PathVariable("id") Integer id);

}
