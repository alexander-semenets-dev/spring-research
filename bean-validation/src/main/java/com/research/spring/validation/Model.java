package com.research.spring.validation;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class Model {

    private Integer id;
    private String field1;
    private String field2;

}