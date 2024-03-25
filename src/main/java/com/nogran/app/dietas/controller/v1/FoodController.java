package com.nogran.app.dietas.controller.v1;

import com.nogran.app.dietas.dto.request.CreateFoodRequestDTO;
import com.nogran.app.dietas.dto.response.FoodResponseDTO;
import com.nogran.app.dietas.mapper.FoodMapper;
import com.nogran.app.dietas.service.FoodService;
import jakarta.validation.Valid;

import java.util.List;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = FoodController.PATH, produces = MediaType.APPLICATION_JSON_VALUE)
public class FoodController {

    private final FoodService service;
    private final FoodMapper mapper;

    public static final String PATH = "/v1/food";

    @GetMapping
    public ResponseEntity<List<FoodResponseDTO>> findAll() {
        log.info("findAll food");
        return ResponseEntity.ok(mapper.toResponse(service.findAll()));
    }

    @GetMapping("/{name}")
    public ResponseEntity<List<FoodResponseDTO>> findByNameStartsWithIgnoreCase(@PathVariable String name) {
        log.info("findByNameStartsWithIgnoreCase[{}]", name);
        return ResponseEntity.ok(mapper.toResponse(service.findByNameStartsWithIgnoreCase(name)));
    }

    @PostMapping
    public ResponseEntity<FoodResponseDTO> create(
            @Valid @RequestBody CreateFoodRequestDTO requestDTO) {
        log.info("create food[{}]", requestDTO);
        return ResponseEntity.ok(
                mapper.toResponse(service.create(mapper.createRequestToDomain(requestDTO))));
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<Void> delete(@PathVariable String name) {
        log.info("delete food[{}]", name);
        service.delete(name);
        return ResponseEntity.noContent().build();
    }
}
