package ru.netology.tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import ru.netology.data.DataHelper;
import ru.netology.pages.*;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PositiveTests {
    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    void setup() {
        open("http://localhost:8080");
    }

    MainPage mainPage = new MainPage();

    @Test
    @DisplayName("Should be successful operation for buying ticket")
    void shouldBeSuccessfulOperationForBuyingTicket() {
        mainPage.buyTicket();
        BuyPage buyPage = new BuyPage();
        buyPage.buyThroughCard(DataHelper.approvedCardFormData());
        buyPage.successNotification();
        assertEquals("APPROVED", DataHelper.getBuyingOperationStatus());
    }

    @Test
    @DisplayName("Should be successful operation for buying ticket through credit")
    void shouldBeSuccessfulOperationForBuyingTicketThroughCredit() {
        mainPage.buyTicketTroughCredit();
        CreditPage creditPage = new CreditPage();
        creditPage.buyThroughCredit(DataHelper.approvedCardFormData());
        creditPage.successNotification();
        assertEquals("APPROVED", DataHelper.getCreditOperationStatus());
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
        DataHelper.cleanData();
    }
}
