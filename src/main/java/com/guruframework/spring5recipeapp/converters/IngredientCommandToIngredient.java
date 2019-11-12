package com.guruframework.spring5recipeapp.converters;

import com.guruframework.spring5recipeapp.commands.IngredientCommand;
import com.guruframework.spring5recipeapp.domain.Ingredient;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class IngredientCommandToIngredient implements Converter<IngredientCommand, Ingredient> {

    private final UnitOfMesureCommandToUnitOfMesure uomConvert;

    public IngredientCommandToIngredient(UnitOfMesureCommandToUnitOfMesure uomConvert) {
        this.uomConvert = uomConvert;
    }

    @Nullable
    @Override
    public Ingredient convert(IngredientCommand source) {
        if (source == null) {
            return null;
        }

        final Ingredient ingredient = new Ingredient();
        ingredient.setId(source.getId());
        ingredient.setAmount(source.getAmount());
        ingredient.setDescription(source.getDescription());
        ingredient.setUom(uomConvert.convert(source.getUom()));
        return ingredient;
    }
}