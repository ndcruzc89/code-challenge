package co.segurocanguro.nelsoncruz.codechallenge.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class HousesResponseDto {
    private String url;
    private String name;
    private String region;
    private CharacterResponseDto currentLord; 
}
