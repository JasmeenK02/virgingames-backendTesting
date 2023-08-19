package com.virgingames.steps;


import com.virgingames.constants.EndPoints;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class VirginGamesSteps {

    @Step("Get all data")
    public ValidatableResponse getData() {
        return SerenityRest.given()
                .when()
                .get(EndPoints.GET_ALL_DATA)
                .then().log().all();
    }
    }

