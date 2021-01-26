package com.patterns.builder;

import org.junit.Assert;
import org.junit.Test;

public class PizzaTestSuite {

    @Test
    public void testPizzaNew() {

        //Given
        Pizza pizza = new Pizza.PizzaBuilder()
                .ingredient("Onion")
                .ingredient("Ham")
                .sauce("Spicy")
                .ingredient("Olives")
                .bottom("Thin")
                .ingredient("Mushrooms")
                .build();
        System.out.println(pizza);

        //When
        int howManyIngredients = pizza.getIngredients().size();


        //Then
        Assert.assertEquals(4, howManyIngredients);


    }
}
