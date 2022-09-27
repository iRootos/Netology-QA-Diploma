package ru.netology.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage {

    private SelenideElement buyButton = $x("//*[contains(text(),'Купить')]");
    private SelenideElement creditButton = $x("//*[contains(text(),'Купить в кредит')]");

    public BuyPage buyTicket() {
        buyButton.click();
        return new BuyPage();
    }

    public CreditPage buyTicketTroughCredit() {
        creditButton.click();
        return new CreditPage();
    }
}
