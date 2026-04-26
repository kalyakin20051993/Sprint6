import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.MainPage;
import pages.OrderFormPage;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class Sprint6OrderTests {
    private WebDriver driver;
    MainPage objMainPage;
    OrderFormPage objOrderFormPage;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        objMainPage = new MainPage(driver);
        objOrderFormPage = new OrderFormPage(driver);
        driver.get("https://qa-scooter.education-services.ru/");
        objMainPage.clickOnAcceptCookie();
    }

    @ParameterizedTest
    @CsvSource({
            "Андрей, Калякин, Москва Кремль 1, 2, +79777064253, 25, 1",
            "Иван, Петров, Санкт-Петербург Невский 10, 70, +79001234567, 27, 2"
    })
    public void takeOrderFromUpperButton(String firstName, String lastName, String address, int metroStation,
                                         String phone, int date, int rentalDays) {
        objMainPage.clickOnUpperOrderButton();
        objOrderFormPage.takeOrder(firstName, lastName, address, metroStation, phone, date, rentalDays);
    }

    @ParameterizedTest
    @CsvSource({
            "Елена, Сидорова, Казань Баумана 5, 13, +79876543210, 29, 3",
            "Алексей, Смирнов, Новосибирск Красный проспект 15, 2, +79123456789, 25, 7"
    })
    public void takeOrderFromLowerButton(String firstName, String lastName, String address, int metroStation,
                                         String phone, int date, int rentalDays) {
        objMainPage.clickOnLowerOrderButton();
        objOrderFormPage.takeOrder(firstName, lastName, address, metroStation, phone, date, rentalDays);
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}