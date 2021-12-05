package com.research.spring.validation;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.Validator;

@RestController
@RequestMapping("/model")
@Validated
@RequiredArgsConstructor
public class ModelController {

    private final ModelRepository modelRepository;

    @PostMapping
    ResponseEntity<Void> createModel(
            @Valid @RequestBody final Model model
    ) {
        modelRepository.saveModel(model);

        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteModel(
            @PathVariable final int id
    ) {
        modelRepository.deleteModel(id);

        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }
}
