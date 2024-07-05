package Page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

public class IndexPage {

    private WebDriver driver;

    // URL страницы
    public static final String URL = "https://qa-scooter.praktikum-services.ru/";

    // Кнопка "Заказать" в заголовке страницы
    private By orderButtonHeader = new By.ByClassName("Button_Button__ra12g");

    // Кнопка "Заказать" под разделом "Как это работает"
    private By orderButtonMiddle = new By.ByXPath(".//div[@class='Home_FinishButton__1_cWm']/button");

    // Конструктор
    public IndexPage(WebDriver driver) {
        this.driver = driver;
    }

    // Клик по кнопке "Заказать"
    // Принимает строку в качестве агрумента
    // Если строка - "header", клик по кнопке в заголовке, в остальных случаях - по кнопке под разделом "Как это работает"
    public void clickOrderButton(String buttonType) {
        By orderButton = (buttonType.equals("header") ? orderButtonHeader : orderButtonMiddle);
        WebElement scrollToOrderButton = driver.findElement(orderButton);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", scrollToOrderButton);
        driver.findElement(orderButton).click();
    }

    // Клик по N элементу в списке вопросов
    public void clickQuestionListElement(int index) {
        By questionListElement = new By.ByXPath(".//div[@id='accordion__heading-" + index + "']");
        WebElement scrollToListElement = driver.findElement(questionListElement);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", scrollToListElement);
        driver.findElement(questionListElement).click();
    }

    // Получение текста ответа N элемента
    public String getAnswerElement(int index) {
        By answerElement = new By.ByXPath(".//div[@id='accordion__panel-" + index + "']/p");
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(answerElement));
        return driver.findElement(answerElement).getText();
    }

}
