package co.segurocanguro.nelsoncruz.codechallenge.service;

import java.util.List;

import org.springframework.stereotype.Service;

import co.segurocanguro.nelsoncruz.codechallenge.dto.CharacterResponseDto;
import co.segurocanguro.nelsoncruz.codechallenge.dto.HouseRequestDto;
import co.segurocanguro.nelsoncruz.codechallenge.dto.HousesResponseDto;

@Service
public interface HousesService {

    List<HousesResponseDto> getAllHouses();

    CharacterResponseDto getCharacter(HouseRequestDto houseRequestDto);

}
