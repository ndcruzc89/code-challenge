package co.segurocanguro.nelsoncruz.codechallenge.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.segurocanguro.nelsoncruz.codechallenge.dto.HousesResponseDto;
import co.segurocanguro.nelsoncruz.codechallenge.service.HousesService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/houses")
public class HousesController {

    private HousesService housesService;

    @GetMapping
    public ResponseEntity<List<HousesResponseDto>> ListAllHouses() {
        var response = housesService.getAllHouses();
        return ResponseEntity.ok(response);
    }
}
