package com.research.spring.validation;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class ModelRepository {

    final Map<Integer, Model> modelById = new HashMap<>();

    public void saveModel(final Model model) {
        modelById.put(model.getId(), model);
    }

    public void deleteModel(final int modelId) {
        modelById.remove(modelId);
    }

}
