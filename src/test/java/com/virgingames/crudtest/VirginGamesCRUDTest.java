package com.virgingames.crudtest;

import com.virgingames.steps.VirginGamesSteps;
import com.virgingames.testbase.TestBase;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import java.util.HashMap;
import static org.hamcrest.Matchers.hasValue;

@RunWith(SerenityRunner.class)
public class VirginGamesCRUDTest extends TestBase {
    static ValidatableResponse response;
    @Steps
    VirginGamesSteps virginGamesSteps;

    @Title("Getting all the data.")
    @Test
    public void test001() {
        response = virginGamesSteps.getData();
        response.log().all().statusCode(200);
    }

    @Title("Getting the currency.")
    @Test
    public void test002() {
        response = virginGamesSteps.getData();
        HashMap<String,Object> currencyList = response.extract().path("data.pots[0]");
        Assert.assertThat(currencyList,hasValue("GBP"));

    }
}