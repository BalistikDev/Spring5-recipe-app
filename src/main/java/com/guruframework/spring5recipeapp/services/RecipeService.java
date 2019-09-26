package com.guruframework.spring5recipeapp.services;

import com.guruframework.spring5recipeapp.domain.Recipe;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface RecipeService {
    Set<Recipe> RecipeList();
    Recipe findById(Long l);
}
