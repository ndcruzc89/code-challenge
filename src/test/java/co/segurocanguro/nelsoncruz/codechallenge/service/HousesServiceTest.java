package co.segurocanguro.nelsoncruz.codechallenge.service;

import co.segurocanguro.nelsoncruz.codechallenge.client.HousesClient;
import co.segurocanguro.nelsoncruz.codechallenge.dto.CharacterRequestDto;
import co.segurocanguro.nelsoncruz.codechallenge.dto.CharacterResponseDto;
import co.segurocanguro.nelsoncruz.codechallenge.dto.HouseRequestDto;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.lenient;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class HousesServiceTest {

    @Mock
    private HousesClient housesClient;

    @InjectMocks
    private HousesServiceImpl housesServiceImpl;

    private List< HouseRequestDto> housesExpected;

    private CharacterRequestDto characterAllyrionExpected;

    @BeforeEach
    void setUp() throws IOException {
        System.out.println("Iniciar todos los test");
        housesExpected = new ArrayList<>();
        housesExpected.add(HouseRequestDto.builder().url("https://www.anapioficeandfire.com/api/houses/1")
                .name("House Algood").region("The Westerlands").currentLord("").build());
        housesExpected.add(HouseRequestDto.builder().url("https://www.anapioficeandfire.com/api/houses/2")
                .name("House Allyrion of Godsgrace").region("Dorne")
                .currentLord("https://www.anapioficeandfire.com/api/characters/298").build());
        housesExpected.add(HouseRequestDto.builder().url("https://www.anapioficeandfire.com/api/houses/3")
                .name("House Amber").region("The North").currentLord("").build());
        housesExpected.add(HouseRequestDto.builder().url("https://www.anapioficeandfire.com/api/houses/4")
                .name("House Ambrose").region("The Reach")
                .currentLord("https://www.anapioficeandfire.com/api/characters/141").build());
        housesExpected.add(HouseRequestDto.builder().url("https://www.anapioficeandfire.com/api/houses/5")
                .name("House Appleton of Appleton").region("The Reach").currentLord("").build());
        housesExpected.add(HouseRequestDto.builder().url("https://www.anapioficeandfire.com/api/houses/6")
                .name("House Arryn of Gulltown").region("The Vale").currentLord("").build());
        housesExpected.add(HouseRequestDto.builder().url("https://www.anapioficeandfire.com/api/houses/7")
                .name("House Arryn of the Eyrie").region("The Vale")
                .currentLord("https://www.anapioficeandfire.com/api/characters/894").build());
        housesExpected.add(HouseRequestDto.builder().url("https://www.anapioficeandfire.com/api/houses/8")
                .name("House Ashford of Ashford").region("The Reach").currentLord("").build());
        housesExpected.add(HouseRequestDto.builder().url("https://www.anapioficeandfire.com/api/houses/9")
                .name("House Ashwood").region("The North").currentLord("").build());
        housesExpected.add(HouseRequestDto.builder().url("https://www.anapioficeandfire.com/api/houses/10")
                .name("House Baelish of Harrenhal").region("The Riverlands")
                .currentLord("https://www.anapioficeandfire.com/api/characters/823").build());

        characterAllyrionExpected = CharacterRequestDto.builder()
                .url("https://www.anapioficeandfire.com/api/characters/298")
                .name("Delonne Allyrion").gender("Female").build();
    }

    @DisplayName("Test for Houses")
    @Test
    void getAllHouses() throws IOException {

        lenient().when(housesClient.getHouses()).thenReturn(housesExpected);

    }

    @DisplayName("Test for Character")
    @Test
    void getCharacter() {
        HouseRequestDto houseAlgood = housesExpected.get(0);
        HouseRequestDto houseAllyrion = housesExpected.get(1);

        CharacterResponseDto characterAlgoodResponse = housesServiceImpl.getCharacter(houseAlgood);
        assertThat(characterAlgoodResponse).isNull();

        lenient().when(housesClient.getCharacters(298)).thenReturn(characterAllyrionExpected);

        CharacterResponseDto characterAllyrionResponse = housesServiceImpl.getCharacter(houseAllyrion);
        assertThat(characterAllyrionResponse).isNotNull();
        Assertions.assertEquals(characterAllyrionExpected.getUrl(), characterAllyrionResponse.getUrl());
        Assertions.assertEquals(characterAllyrionExpected.getName(), characterAllyrionResponse.getName());
        Assertions.assertEquals(characterAllyrionExpected.getGender(), characterAllyrionResponse.getGender());
    }
}
