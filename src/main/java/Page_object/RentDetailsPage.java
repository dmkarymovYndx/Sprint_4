package Page_object;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RentDetailsPage {

    private WebDriver driver;

    // Поле "Когда привезти"
    private By dateField = new By.ByXPath(".//input[@placeholder='* Когда привезти самокат']");

    // Кнопка выбора в поле "Срок аренды"
    private By durationField = new By.ByClassName("Dropdown-arrow");

    // Поле "Комментарий для курьера"
    private By commentFied = new By.ByXPath(".//input[@placeholder='Комментарий для курьера']");

    // Кнопка "Заказать"
    private By orderButton = new By.ByXPath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать']");

    // Кнопка "Да" во всплывающем окне "Хотите оформить заказ?"
    private By confirmationYesButton = new By.ByXPath(".//button[text()='Да']");

    // Заголовок во всплывающем окне "Заказ оформлен"
    private By orderCreatedHeader = new By.ByXPath(".//div[text()='Заказ оформлен']");

    // Конструктор
    public RentDetailsPage(WebDriver driver) {
        this.driver = driver;
    }

    // Проверка того, что поле "Когда привезти" активно
    public void checkDateFieldIsActive() {
        Assert.assertTrue(driver.findElement(dateField).isEnabled());
    }

    // Ввод даты в поле "Когда привезти"
    public void enterDate(String date) {
        driver.findElement(dateField).sendKeys(date);
    }

    // Выбор срока аренды
    public void chooseDuration(String duration) {
        driver.findElement(durationField).click();
        driver.findElement(By.xpath(".//div[text()='" + duration + "']")).click();
    }

    // Выбор цвета самоката
    public void chooseColor(String color) {
        driver.findElement(By.xpath(".//label[@class='Checkbox_Label__3wxSf']/input[@id='" + color + "']")).click();
    }

    // Заполнение поля "Комментарий для курьера"
    public void enterComment(String comment) {
        driver.findElement(commentFied).sendKeys(comment);
    }

    // Клик по кнопке "Заказать"
    public void clickOrderButton() {
        driver.findElement(orderButton).click();
    }

    // Клик по кнопке "Да" в окне "Хотите оформить заказ?"
    public void clickConfirmationYesButton() {
        driver.findElement(confirmationYesButton).click();
    }

    // Заполнение формы "Про аренду" целиком
    public void fillRentDetailsForm(String date, String duration, String color, String comment) {
        driver.findElement(dateField).sendKeys(date);
        driver.findElement(durationField).click();
        driver.findElement(By.xpath(".//div[text()='" + duration + "']")).click();
        driver.findElement(By.xpath(".//label[@class='Checkbox_Label__3wxSf']/input[@id='" + color + "']")).click();
        driver.findElement(commentFied).sendKeys(comment);
    }

    // Проверка того, что отображается окно "Заказ оформлен"
    public void isOrderCreatedHeaderVisible() {
        Assert.assertTrue(driver.findElement(orderCreatedHeader).isDisplayed());
    }

}
