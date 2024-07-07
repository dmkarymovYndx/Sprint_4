package ru.yandex.praktikum.pageobject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CustomerDetailsPage {

    private WebDriver driver;

    // Поле "Имя"
    private By nameField = new By.ByXPath("//input[@placeholder='* Имя']");

    // Поле "Фамилия"
    private By secondNameField = new By.ByXPath(".//input[@placeholder='* Фамилия']");

    // Поле "Адрес"
    private By addressField = new By.ByXPath(".//input[@placeholder='* Адрес: куда привезти заказ']");

    // Поле "Станция метро"
    private By metroStationField = new By.ByXPath(".//div[@class='select-search__value']/input");

    // Поле "Телефон"
    private By phoneNumberField = new By.ByXPath(".//input[@placeholder='* Телефон: на него позвонит курьер']");

    // Кнопка "Далее"
    private By nextButton = new By.ByXPath(".//button[text()='Далее']");

    // Конструктор
    public CustomerDetailsPage(WebDriver driver) {
        this.driver = driver;
    }

    // Заполнение поля "Имя"
    public void enterName(String name) {
        driver.findElement(nameField).sendKeys(name);
    }

    // Заполнение поля "Фамилия"
    public void enterSecondName(String secondName) {
        driver.findElement(secondNameField).sendKeys(secondName);
    }

    // Заполнение поля "Адрес"
    public void enterAddress(String address) {
        driver.findElement(addressField).sendKeys(address);
    }

    // Заполнение поля "Станция метро"
    public void selectMetroStation(String metroStation) {
        driver.findElement(metroStationField).click();
        driver.findElement(By.xpath(".//div[text()='" + metroStation + "']")).click();
        System.out.println(driver.findElement(metroStationField).getAttribute("value"));
    }

    // Заполнение поля "Телефон"
    public void enterPhoneNumber(String phoneNumber) {
        driver.findElement(phoneNumberField).sendKeys(phoneNumber);
    }

    // Заполнение формы "Для кого самокат" целиком
    public void fillCustomerDetailsForm(String name, String secondName, String address, String metroStation, String phoneNumber) {
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(secondNameField).sendKeys(secondName);
        driver.findElement(addressField).sendKeys(address);
        driver.findElement(metroStationField).click();
        driver.findElement(By.xpath(".//div[text()='" + metroStation + "']")).click();
        driver.findElement(phoneNumberField).sendKeys(phoneNumber);
    }

    // Клик по кнопке "Далее"
    public void clickNextButton() {
        driver.findElement(nextButton).click();
    }

}
