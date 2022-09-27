package ru.netology.tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import ru.netology.data.*;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ApiTests {

    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    void setup() {
        open("http://localhost:8080");
    }

    public String buyOperationPath = "/api/v1/pay";
    public String creditOperationPath = "/api/v1/credit";

    @Test
    void shouldSuccessfulBuy() {
        RestHelper.sendRequest(DataHelper.approvedCardFormData(), buyOperationPath);
        assertEquals("APPROVED", DataHelper.getBuyingOperationStatus());
    }

    @Test
    void shouldSuccessfulDeclineBuyingOperation(){
        RestHelper.sendRequest(DataHelper.declinedCardFormData(), buyOperationPath);
        assertEquals("DECLINED", DataHelper.getBuyingOperationStatus());
    }

    @Test
    void shouldSendErrorForUnknownCard_BuyingForm(){
        RestHelper.sendBadRequest(DataHelper.unknownCardFormData(), buyOperationPath);
    }
    @Test
    void shouldSendErrorForSingleCharacterCardNumber_BuyingForm(){
        RestHelper.sendBadRequest(DataHelper.oneCharacterCardNumberFormData(), buyOperationPath);
    }
    @Test
    void shouldSendErrorForWrongFormatCardMonth_BuyingForm(){
        RestHelper.sendBadRequest(DataHelper.wrongCardMonthFormData(), buyOperationPath);
    }
    @Test
    void shouldSendErrorForWrongFormatCardYear_BuyingForm(){
        RestHelper.sendBadRequest(DataHelper.wrongCardYearFormData(), buyOperationPath);
    }
    @Test
    void shouldSendErrorForExpiredCardYear_BuyingForm(){
        RestHelper.sendBadRequest(DataHelper.expiredCardYearFormData(), buyOperationPath);
    }
    @Test
    void shouldSendErrorForWrongFormatCardHolder_BuyingForm(){
        RestHelper.sendBadRequest(DataHelper.wrongCardHolderFormData(), buyOperationPath);
    }
    @Test
    void shouldSendErrorForCyrillicCardHolder_BuyingForm(){
        RestHelper.sendBadRequest(DataHelper.cyrillicCardHolderFormData(), buyOperationPath);
    }
    @Test
    void shouldSendErrorForNumbersCardHolder_BuyingForm(){
        RestHelper.sendBadRequest(DataHelper.numbersCardHolderFormData(), buyOperationPath);
    }
    @Test
    void shouldSendErrorForOneCharacterCardHolder_BuyingForm(){
        RestHelper.sendBadRequest(DataHelper.oneCharacterCardHolderFormData(), buyOperationPath);
    }
    @Test
    void shouldSendErrorForSpecSymbolsCardHolder_BuyingForm(){
        RestHelper.sendBadRequest(DataHelper.specSymbolsCardHolderFormData(), buyOperationPath);
    }
    @Test
    void shouldSendErrorForOneCharacterCardCode_BuyingForm(){
        RestHelper.sendBadRequest(DataHelper.oneCharacterCardCodeFormData(), buyOperationPath);
    }
    @Test
    void shouldSendErrorForEmptyCardNumber_BuyingForm(){
        RestHelper.sendBadRequest(DataHelper.emptyCardNumberFormData(), buyOperationPath);
    }
    @Test
    void shouldSendErrorForEmptyCardMonth_BuyingForm(){
        RestHelper.sendBadRequest(DataHelper.emptyCardMonthFormData(), buyOperationPath);
    }
    @Test
    void shouldSendErrorForEmptyCardYear_BuyingForm(){
        RestHelper.sendBadRequest(DataHelper.emptyCardYearFormData(), buyOperationPath);
    }
    @Test
    void shouldSendErrorForEmptyCardHolder_BuyingForm(){
        RestHelper.sendBadRequest(DataHelper.emptyCardHolderFormData(), buyOperationPath);
    }
    @Test
    void shouldSendErrorForEmptyCardCode_BuyingForm(){
        RestHelper.sendBadRequest(DataHelper.emptyCardCodeFormData(), buyOperationPath);
    }
    @Test
    void shouldSendErrorForDoubleZeroMonth_BuyingForm(){
        RestHelper.sendBadRequest(DataHelper.doubleZeroMonthFormData(), buyOperationPath);
    }
    @Test
    void shouldSendErrorForDoubleZeroYear_BuyingForm(){
        RestHelper.sendBadRequest(DataHelper.doubleZeroYearFormData(), buyOperationPath);
    }

    @Test
    void shouldSuccessfulBuyThroughCredit() {
        RestHelper.sendRequest(DataHelper.approvedCardFormData(), creditOperationPath);
        assertEquals("APPROVED", DataHelper.getCreditOperationStatus());
    }

    @Test
    void shouldSuccessfulDeclineCreditOperation(){
        RestHelper.sendRequest(DataHelper.declinedCardFormData(), creditOperationPath);
        assertEquals("DECLINED", DataHelper.getCreditOperationStatus());
    }
    @Test
    void shouldSendErrorForUnknownCard_CreditForm(){
        RestHelper.sendBadRequest(DataHelper.unknownCardFormData(), creditOperationPath);
    }
    @Test
    void shouldSendErrorForSingleCharacterCardNumber_CreditForm(){
        RestHelper.sendBadRequest(DataHelper.oneCharacterCardNumberFormData(), creditOperationPath);
    }
    @Test
    void shouldSendErrorForWrongFormatCardMonth_CreditForm(){
        RestHelper.sendBadRequest(DataHelper.wrongCardMonthFormData(), creditOperationPath);
    }
    @Test
    void shouldSendErrorForWrongFormatCardYear_CreditForm(){
        RestHelper.sendBadRequest(DataHelper.wrongCardYearFormData(), creditOperationPath);
    }
    @Test
    void shouldSendErrorForExpiredCardYear_CreditForm(){
        RestHelper.sendBadRequest(DataHelper.expiredCardYearFormData(), creditOperationPath);
    }
    @Test
    void shouldSendErrorForWrongFormatCardHolder_CreditForm(){
        RestHelper.sendBadRequest(DataHelper.wrongCardHolderFormData(), creditOperationPath);
    }
    @Test
    void shouldSendErrorForCyrillicCardHolder_CreditForm(){
        RestHelper.sendBadRequest(DataHelper.cyrillicCardHolderFormData(), creditOperationPath);
    }
    @Test
    void shouldSendErrorForNumbersCardHolder_CreditForm(){
        RestHelper.sendBadRequest(DataHelper.numbersCardHolderFormData(), creditOperationPath);
    }
    @Test
    void shouldSendErrorForOneCharacterCardHolder_CreditForm(){
        RestHelper.sendBadRequest(DataHelper.oneCharacterCardHolderFormData(), creditOperationPath);
    }
    @Test
    void shouldSendErrorForSpecSymbolsCardHolder_CreditForm(){
        RestHelper.sendBadRequest(DataHelper.specSymbolsCardHolderFormData(), creditOperationPath);
    }
    @Test
    void shouldSendErrorForOneCharacterCardCode_CreditForm(){
        RestHelper.sendBadRequest(DataHelper.oneCharacterCardCodeFormData(), creditOperationPath);
    }
    @Test
    void shouldSendErrorForEmptyCardNumber_CreditForm(){
        RestHelper.sendBadRequest(DataHelper.emptyCardNumberFormData(), creditOperationPath);
    }
    @Test
    void shouldSendErrorForEmptyCardMonth_CreditForm(){
        RestHelper.sendBadRequest(DataHelper.emptyCardMonthFormData(), creditOperationPath);
    }
    @Test
    void shouldSendErrorForEmptyCardYear_CreditForm(){
        RestHelper.sendBadRequest(DataHelper.emptyCardYearFormData(), creditOperationPath);
    }
    @Test
    void shouldSendErrorForEmptyCardHolder_CreditForm(){
        RestHelper.sendBadRequest(DataHelper.emptyCardHolderFormData(), creditOperationPath);
    }
    @Test
    void shouldSendErrorForEmptyCardCode_CreditForm(){
        RestHelper.sendBadRequest(DataHelper.emptyCardCodeFormData(), creditOperationPath);
    }
    @Test
    void shouldSendErrorForDoubleZeroMonth_CreditForm(){
        RestHelper.sendBadRequest(DataHelper.doubleZeroMonthFormData(), creditOperationPath);
    }
    @Test
    void shouldSendErrorForDoubleZeroYear_CreditForm(){
        RestHelper.sendBadRequest(DataHelper.doubleZeroYearFormData(), creditOperationPath);
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
        DataHelper.cleanData();
    }
}
