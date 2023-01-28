package co.segurocanguro.nelsoncruz.codechallenge.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CharacterRequestDto {
    private String url;
    private String name;
    private String gender;
}
