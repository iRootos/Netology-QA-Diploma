package ru.netology.tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import ru.netology.data.DataHelper;
import ru.netology.pages.*;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class NegativeTests {

    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    void setup() {
        open("http://localhost:8080");
    }

    MainPage mainPage = new MainPage();

    private final String subMessageWrongData = "Неверный формат";
    private final String subMessageWrongDate = "Неверно указан срок действия карты";
    private final String subMessageEmptyData = "Поле обязательно для заполнения";
    private final String subMessageExpiredDate = "Истёк срок действия карты";

    @Test
    @DisplayName("Buying form | Should decline buying operation with writing in DB")
    void shouldDeclineBuyingOperationWithWritingInDB() {
        mainPage.buyTicket();
        BuyPage buyPage = new BuyPage();
        buyPage.buyThroughCard(DataHelper.declinedCardFormData());
        buyPage.successNotification();
        assertEquals("DECLINED", DataHelper.getBuyingOperationStatus());
    }

    @Test
    @DisplayName("Buying form | Should decline buying operation for unknown card without writing in DB")
    void shouldDeclineBuyingOperationForUnknownCardWithoutWritingInDB() {
        mainPage.buyTicket();
        BuyPage buyPage = new BuyPage();
        buyPage.buyThroughCard(DataHelper.unknownCardFormData());
        buyPage.errorNotification();
    }

    @Test
    @DisplayName("Buying form | Should be message about wrong data in card number field. Single character data")
    void shouldBeErrorMessage_1_BuyingForm() {
        mainPage.buyTicket();
        BuyPage buyPage = new BuyPage();
        buyPage.buyThroughCard(DataHelper.oneCharacterCardNumberFormData());
        buyPage.cardNumberFieldSubMessage(subMessageWrongData);
    }
    @Test
    @DisplayName("Buying form | Should be message about wrong data in card month field. Wrong format data")
    void shouldBeErrorMessage_2_BuyingForm() {
        mainPage.buyTicket();
        BuyPage buyPage = new BuyPage();
        buyPage.buyThroughCard(DataHelper.wrongCardMonthFormData());
        buyPage.cardMonthFieldSubMessage(subMessageWrongDate);
    }

    @Test
    @DisplayName("Buying form | Should be message about wrong data in card year field. Wrong format data")
    void shouldBeErrorMessage_3_BuyingForm() {
        mainPage.buyTicket();
        BuyPage buyPage = new BuyPage();
        buyPage.buyThroughCard(DataHelper.wrongCardYearFormData());
        buyPage.cardYearFieldSubMessage(subMessageWrongDate);
    }

    @Test
    @DisplayName("Buying form | Should be message about wrong data in card year field. Expired year data")
    void shouldBeErrorMessage_4_BuyingForm() {
        mainPage.buyTicket();
        BuyPage buyPage = new BuyPage();
        buyPage.buyThroughCard(DataHelper.expiredCardYearFormData());
        buyPage.cardYearFieldSubMessage(subMessageExpiredDate);
    }

    @Test
    @DisplayName("Buying form | Should be message about wrong data in card holder field. One word data")
    void shouldBeErrorMessage_5_BuyingForm() {
        mainPage.buyTicket();
        BuyPage buyPage = new BuyPage();
        buyPage.buyThroughCard(DataHelper.wrongCardHolderFormData());
        buyPage.cardHolderFieldSubMessage(subMessageWrongData);
    }

    @Test
    @DisplayName("Buying form | Should be message about wrong data in card holder field. Cyrillic words data")
    void shouldBeErrorMessage_6_BuyingForm() {
        mainPage.buyTicket();
        BuyPage buyPage = new BuyPage();
        buyPage.buyThroughCard(DataHelper.cyrillicCardHolderFormData());
        buyPage.cardHolderFieldSubMessage(subMessageWrongData);
    }

    @Test
    @DisplayName("Buying form | Should be message about wrong data in card holder field. Numbers data")
    void shouldBeErrorMessage_7_BuyingForm() {
        mainPage.buyTicket();
        BuyPage buyPage = new BuyPage();
        buyPage.buyThroughCard(DataHelper.numbersCardHolderFormData());
        buyPage.cardHolderFieldSubMessage(subMessageWrongData);
    }

    @Test
    @DisplayName("Buying form | Should be message about wrong data in card holder field. One character data")
    void shouldBeErrorMessage_8_BuyingForm() {
        mainPage.buyTicket();
        BuyPage buyPage = new BuyPage();
        buyPage.buyThroughCard(DataHelper.oneCharacterCardHolderFormData());
        buyPage.cardHolderFieldSubMessage(subMessageWrongData);
    }

    @Test
    @DisplayName("Buying form | Should be message about wrong data in card holder field. Spec symbols data")
    void shouldBeErrorMessage_9_BuyingForm() {
        mainPage.buyTicket();
        BuyPage buyPage = new BuyPage();
        buyPage.buyThroughCard(DataHelper.specSymbolsCardHolderFormData());
        buyPage.cardHolderFieldSubMessage(subMessageWrongData);
    }

    @Test
    @DisplayName("Buying form | Should be message about wrong data in card code field. One character data")
    void shouldBeErrorMessage_10_BuyingForm() {
        mainPage.buyTicket();
        BuyPage buyPage = new BuyPage();
        buyPage.buyThroughCard(DataHelper.oneCharacterCardCodeFormData());
        buyPage.cardCodeFieldSubMessage(subMessageWrongData);
    }
    @Test
    @DisplayName("Buying form | Should be message about wrong data in card number field. Empty data")
    void shouldBeErrorMessage_11_BuyingForm() {
        mainPage.buyTicket();
        BuyPage buyPage = new BuyPage();
        buyPage.buyThroughCard(DataHelper.emptyCardNumberFormData());
        buyPage.cardNumberFieldSubMessage(subMessageEmptyData);
    }
    @Test
    @DisplayName("Buying form | Should be message about wrong data in card month field. Empty data")
    void shouldBeErrorMessage_12_BuyingForm() {
        mainPage.buyTicket();
        BuyPage buyPage = new BuyPage();
        buyPage.buyThroughCard(DataHelper.emptyCardMonthFormData());
        buyPage.cardMonthFieldSubMessage(subMessageEmptyData);
    }

    @Test
    @DisplayName("Buying form | Should be message about wrong data in card year field. Empty data")
    void shouldBeErrorMessage_13_BuyingForm() {
        mainPage.buyTicket();
        BuyPage buyPage = new BuyPage();
        buyPage.buyThroughCard(DataHelper.emptyCardYearFormData());
        buyPage.cardYearFieldSubMessage(subMessageEmptyData);
    }

    @Test
    @DisplayName("Buying form | Should be message about wrong data in card holder field. Empty data")
    void shouldBeErrorMessage_14_BuyingForm() {
        mainPage.buyTicket();
        BuyPage buyPage = new BuyPage();
        buyPage.buyThroughCard(DataHelper.emptyCardHolderFormData());
        buyPage.cardHolderFieldSubMessage(subMessageEmptyData);
    }

    @Test
    @DisplayName("Buying form | Should be message about wrong data in card code field. Empty data")
    void shouldBeErrorMessage_15_BuyingForm() {
        mainPage.buyTicket();
        BuyPage buyPage = new BuyPage();
        buyPage.buyThroughCard(DataHelper.emptyCardCodeFormData());
        buyPage.cardCodeFieldSubMessage(subMessageEmptyData);
    }

    @Test
    @DisplayName("Buying form | Should be message about wrong data in card month field. Double zero")
    void shouldBeErrorMessage_16_BuyingForm() {
        mainPage.buyTicket();
        BuyPage buyPage = new BuyPage();
        buyPage.buyThroughCard(DataHelper.doubleZeroMonthFormData());
        buyPage.cardCodeFieldSubMessage(subMessageWrongData);
    }

    @Test
    @DisplayName("Buying form | Should be message about wrong data in card month field. Double zero")
    void shouldBeErrorMessage_17_BuyingForm() {
        mainPage.buyTicket();
        BuyPage buyPage = new BuyPage();
        buyPage.buyThroughCard(DataHelper.doubleZeroYearFormData());
        buyPage.cardCodeFieldSubMessage(subMessageWrongData);
    }

    @Test
    @DisplayName("Credit form | Should decline credit operation with writing in DB")
    void shouldDeclineCreditOperationWithWritingInDB() {
        mainPage.buyTicketTroughCredit();
        CreditPage creditPage = new CreditPage();
        creditPage.buyThroughCredit(DataHelper.declinedCardFormData());
        creditPage.successNotification();
        assertEquals("DECLINED", DataHelper.getCreditOperationStatus());
    }

    @Test
    @DisplayName("Credit form | Should decline credit operation for unknown card without writing in DB")
    void shouldDeclineCreditOperationForUnknownCardWithoutWritingInDB() {
        mainPage.buyTicketTroughCredit();
        CreditPage creditPage = new CreditPage();
        creditPage.buyThroughCredit(DataHelper.unknownCardFormData());
        creditPage.errorNotification();
    }

    @Test
    @DisplayName("Credit form | Should be message about wrong data in card number field. Single character data")
    void shouldBeErrorMessage_1_CreditForm() {
        mainPage.buyTicketTroughCredit();
        CreditPage creditPage = new CreditPage();
        creditPage.buyThroughCredit(DataHelper.oneCharacterCardNumberFormData());
        creditPage.cardNumberFieldSubMessage(subMessageWrongData);
    }
    @Test
    @DisplayName("Credit form | Should be message about wrong data in card month field. Wrong format data")
    void shouldBeErrorMessage_2_CreditForm() {
        mainPage.buyTicketTroughCredit();
        CreditPage creditPage = new CreditPage();
        creditPage.buyThroughCredit(DataHelper.wrongCardMonthFormData());
        creditPage.cardMonthFieldSubMessage(subMessageWrongDate);
    }

    @Test
    @DisplayName("Credit form | Should be message about wrong data in card year field. Wrong format data")
    void shouldBeErrorMessage_3_CreditForm() {
        mainPage.buyTicketTroughCredit();
        CreditPage creditPage = new CreditPage();
        creditPage.buyThroughCredit(DataHelper.wrongCardYearFormData());
        creditPage.cardYearFieldSubMessage(subMessageWrongDate);
    }

    @Test
    @DisplayName("Credit form | Should be message about wrong data in card year field. Expired year data")
    void shouldBeErrorMessage_4_CreditForm() {
        mainPage.buyTicketTroughCredit();
        CreditPage creditPage = new CreditPage();
        creditPage.buyThroughCredit(DataHelper.expiredCardYearFormData());
        creditPage.cardYearFieldSubMessage(subMessageExpiredDate);
    }

    @Test
    @DisplayName("Credit form | Should be message about wrong data in card holder field. One word data")
    void shouldBeErrorMessage_5_CreditForm() {
        mainPage.buyTicketTroughCredit();
        CreditPage creditPage = new CreditPage();
        creditPage.buyThroughCredit(DataHelper.wrongCardHolderFormData());
        creditPage.cardHolderFieldSubMessage(subMessageWrongData);
    }

    @Test
    @DisplayName("Credit form | Should be message about wrong data in card holder field. Cyrillic words data")
    void shouldBeErrorMessage_6_CreditForm() {
        mainPage.buyTicketTroughCredit();
        CreditPage creditPage = new CreditPage();
        creditPage.buyThroughCredit(DataHelper.cyrillicCardHolderFormData());
        creditPage.cardHolderFieldSubMessage(subMessageWrongData);
    }

    @Test
    @DisplayName("Credit form | Should be message about wrong data in card holder field. Numbers data")
    void shouldBeErrorMessage_7_CreditForm() {
        mainPage.buyTicketTroughCredit();
        CreditPage creditPage = new CreditPage();
        creditPage.buyThroughCredit(DataHelper.numbersCardHolderFormData());
        creditPage.cardHolderFieldSubMessage(subMessageWrongData);
    }

    @Test
    @DisplayName("Credit form | Should be message about wrong data in card holder field. One character data")
    void shouldBeErrorMessage_8_CreditForm() {
        mainPage.buyTicketTroughCredit();
        CreditPage creditPage = new CreditPage();
        creditPage.buyThroughCredit(DataHelper.oneCharacterCardHolderFormData());
        creditPage.cardHolderFieldSubMessage(subMessageWrongData);
    }

    @Test
    @DisplayName("Credit form | Should be message about wrong data in card holder field. Spec symbols data")
    void shouldBeErrorMessage_9_CreditForm() {
        mainPage.buyTicketTroughCredit();
        CreditPage creditPage = new CreditPage();
        creditPage.buyThroughCredit(DataHelper.specSymbolsCardHolderFormData());
        creditPage.cardHolderFieldSubMessage(subMessageWrongData);
    }

    @Test
    @DisplayName("Credit form | Should be message about wrong data in card code field. One character data")
    void shouldBeErrorMessage_10_CreditForm() {
        mainPage.buyTicketTroughCredit();
        CreditPage creditPage = new CreditPage();
        creditPage.buyThroughCredit(DataHelper.oneCharacterCardCodeFormData());
        creditPage.cardCodeFieldSubMessage(subMessageWrongData);
    }
    @Test
    @DisplayName("Credit form | Should be message about wrong data in card number field. Empty data")
    void shouldBeErrorMessage_11_CreditForm() {
        mainPage.buyTicketTroughCredit();
        CreditPage creditPage = new CreditPage();
        creditPage.buyThroughCredit(DataHelper.emptyCardNumberFormData());
        creditPage.cardNumberFieldSubMessage(subMessageEmptyData);
    }
    @Test
    @DisplayName("Credit form | Should be message about wrong data in card month field. Empty data")
    void shouldBeErrorMessage_12_CreditForm() {
        mainPage.buyTicketTroughCredit();
        CreditPage creditPage = new CreditPage();
        creditPage.buyThroughCredit(DataHelper.emptyCardMonthFormData());
        creditPage.cardMonthFieldSubMessage(subMessageEmptyData);
    }

    @Test
    @DisplayName("Credit form | Should be message about wrong data in card year field. Empty data")
    void shouldBeErrorMessage_13_CreditForm() {
        mainPage.buyTicketTroughCredit();
        CreditPage creditPage = new CreditPage();
        creditPage.buyThroughCredit(DataHelper.emptyCardYearFormData());
        creditPage.cardYearFieldSubMessage(subMessageEmptyData);
    }

    @Test
    @DisplayName("Credit form | Should be message about wrong data in card holder field. Empty data")
    void shouldBeErrorMessage_14_CreditForm() {
        mainPage.buyTicketTroughCredit();
        CreditPage creditPage = new CreditPage();
        creditPage.buyThroughCredit(DataHelper.emptyCardHolderFormData());
        creditPage.cardHolderFieldSubMessage(subMessageEmptyData);
    }

    @Test
    @DisplayName("Credit form | Should be message about wrong data in card code field. Empty data")
    void shouldBeErrorMessage_15_CreditForm() {
        mainPage.buyTicketTroughCredit();
        CreditPage creditPage = new CreditPage();
        creditPage.buyThroughCredit(DataHelper.emptyCardCodeFormData());
        creditPage.cardCodeFieldSubMessage(subMessageEmptyData);
    }

    @Test
    @DisplayName("Credit form | Should be message about wrong data in card month field. Double zero")
    void shouldBeErrorMessage_16_CreditForm() {
        mainPage.buyTicket();
        CreditPage creditPage = new CreditPage();
        creditPage.buyThroughCredit(DataHelper.doubleZeroMonthFormData());
        creditPage.cardCodeFieldSubMessage(subMessageWrongData);
    }

    @Test
    @DisplayName("Credit form | Should be message about wrong data in card month field. Double zero")
    void shouldBeErrorMessage_17_CreditForm() {
        mainPage.buyTicketTroughCredit();
        CreditPage creditPage = new CreditPage();
        creditPage.buyThroughCredit(DataHelper.doubleZeroYearFormData());
        creditPage.cardCodeFieldSubMessage(subMessageWrongData);
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
        DataHelper.cleanData();
    }
}
