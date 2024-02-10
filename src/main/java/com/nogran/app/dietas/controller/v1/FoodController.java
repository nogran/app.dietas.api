package com.nogran.app.dietas.controller.v1;

import com.nogran.app.dietas.model.Food;
import com.nogran.app.dietas.service.FoodService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = FoodController.PATH, produces = MediaType.APPLICATION_JSON_VALUE)
public class FoodController {
  private final FoodService service;

  public static final String PATH = "/v1/food";

  @GetMapping
  public List<Food> findAll() {
    log.info("findAll food");
    return service.findAll();
  }
}
