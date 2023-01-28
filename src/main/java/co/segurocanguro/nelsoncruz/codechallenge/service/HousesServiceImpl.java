package co.segurocanguro.nelsoncruz.codechallenge.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import co.segurocanguro.nelsoncruz.codechallenge.client.HousesClient;
import co.segurocanguro.nelsoncruz.codechallenge.dto.CharacterRequestDto;
import co.segurocanguro.nelsoncruz.codechallenge.dto.CharacterResponseDto;
import co.segurocanguro.nelsoncruz.codechallenge.dto.HouseRequestDto;
import co.segurocanguro.nelsoncruz.codechallenge.dto.HousesResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.Cacheable;

@AllArgsConstructor
@Service
public class HousesServiceImpl implements HousesService {

        private HousesClient housesClient;
        private static final String characterUrl = "https://www.anapioficeandfire.com/api/characters/";

        @Cacheable("houses")
        @Override
        public List<HousesResponseDto> getAllHouses() {

                return housesClient.getHouses().stream()
                                .map(house -> HousesResponseDto.builder().url(house.getUrl()).name(house.getName())
                                                .region(house.getRegion())
                                                .currentLord(getCharacter(house))
                                                .build())
                                .collect(Collectors.toList());
                
        }

        @Cacheable("character")
        @Override
        public CharacterResponseDto getCharacter(HouseRequestDto house) {

                if (house.getCurrentLord().isEmpty()) {
                        return null;
                }

                CharacterRequestDto character = housesClient.getCharacters(
                                Integer.parseInt(house.getCurrentLord().replace(characterUrl, "")));

                return CharacterResponseDto.builder().url(character.getUrl()).name(character.getName())
                                .gender(character.getGender()).build();

        }

}
