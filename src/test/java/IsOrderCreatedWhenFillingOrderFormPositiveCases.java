import Page_object.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.concurrent.TimeUnit;

@RunWith(Parameterized.class)
public class IsOrderCreatedWhenFillingOrderFormPositiveCases extends BaseTest {

   private final String buttonType;
   private final String name;
   private final String secondName;
   private final String address;
   private final String metroStation;
   private final String phoneNumber;
   private final String date;
   private final String duration;
   private final String color;
   private final String comment;

   public IsOrderCreatedWhenFillingOrderFormPositiveCases(String buttonType, String name, String secondName, String address, String metroStation, String phoneNumber, String date, String duration, String color, String comment) {
       this.buttonType = buttonType;
       this.name = name;
       this.secondName = secondName;
       this.address = address;
       this.metroStation = metroStation;
       this.phoneNumber = phoneNumber;
       this.date = date;
       this.duration = duration;
       this.color = color;
       this.comment = comment;
   }

   @Parameterized.Parameters
    public static Object[][] getParameters() {
       return new Object[][] {
               {
                "header",
                "Райан",
                "Гослинг",
                "ул. Гастелло, дом 10",
                "Сокольники",
                "88005553535",
                "13.07.2024",
                "сутки",
                "black",
                "Привет, курьер!"
               },
               {
                "body",
                "Киану",
                "Ривз",
                "ул. Преображенский Вал, 25к1",
                "Преображенская площадь",
                "88005553535",
                "26.07.2024",
                "двое суток",
                "black",
                ""
               },
       };
   }

   @Test
    public void IsOrderCreatedWhenFillingOrderForm() {

       driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);

       IndexPage objIndexPage = new IndexPage(driver);
       CustomerDetailsPage objCustomerDetailsPage = new CustomerDetailsPage(driver);
       RentDetailsPage objRentDetailsPage = new RentDetailsPage(driver);

       objIndexPage.clickOrderButton(buttonType);
       objCustomerDetailsPage.fillCustomerDetailsForm(
               name,
               secondName,
               address,
               metroStation,
               phoneNumber);
       objCustomerDetailsPage.clickNextButton();
       objRentDetailsPage.checkDateFieldIsActive();
       objRentDetailsPage.fillRentDetailsForm(
               date,
               duration,
               color,
               comment);
       objRentDetailsPage.clickOrderButton();
       objRentDetailsPage.clickConfirmationYesButton();
       objRentDetailsPage.isOrderCreatedHeaderVisible();
   }

}
