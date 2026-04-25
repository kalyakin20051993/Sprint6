import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.MainPage;
import pages.OrderFormPage;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Sprint6Tests {
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

    @Test
    public void firstAccordionItemTextIsCorrect() {
        String actualText = objMainPage.getTextFromAccordionFirstItem();
        String expectedText = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
        assertEquals(expectedText, actualText, "Текст не совпадает");
    }

    @Test
    public void secondAccordionItemTextIsCorrect() {
        String actualText = objMainPage.getTextFromAccordionSecondItem();
        String expectedText = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями," +
                " можете просто сделать несколько заказов — один за другим.";
        assertEquals(expectedText, actualText, "Текст не совпадает");
    }

    @Test
    public void thirdAccordionItemTextIsCorrect() {
        String actualText = objMainPage.getTextFromAccordionThirdItem();
        String expectedText = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня." +
                " Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру." +
                " Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
        assertEquals(expectedText, actualText, "Текст не совпадает");
    }

    @Test
    public void fourthAccordionItemTextIsCorrect() {
        String actualText = objMainPage.getTextFromAccordionFourthItem();
        String expectedText = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
        assertEquals(expectedText, actualText, "Текст не совпадает");
    }

    @Test
    public void fifthAccordionItemTextIsCorrect() {
        String actualText = objMainPage.getTextFromAccordionFifthItem();
        String expectedText = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку" +
                " по красивому номеру 1010.";
        assertEquals(expectedText, actualText, "Текст не совпадает");
    }

    @Test
    public void sixthAccordionItemTextIsCorrect() {
        String actualText = objMainPage.getTextFromAccordionSixthItem();
        String expectedText = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток —" +
                " даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
        assertEquals(expectedText, actualText, "Текст не совпадает");
    }

    @Test
    public void seventhAccordionItemTextIsCorrect() {
        String actualText = objMainPage.getTextFromAccordionSeventhItem();
        String expectedText = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим." +
                " Все же свои.";
        assertEquals(expectedText, actualText, "Текст не совпадает");
    }

    @Test
    public void eighthAccordionItemTextIsCorrect() {
        String actualText = objMainPage.getTextFromAccordionEighthItem();
        String expectedText = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";
        assertEquals(expectedText, actualText, "Текст не совпадает");
    }

    @ParameterizedTest
    @CsvSource({
            "Андрей, Калякин, Москва Кремль 1, 2, +79777064253, 25, 1",
            "Иван, Петров, Санкт-Петербург Невский 10, 70, +79001234567, 27, 2"
    })
    public void takeOrderFromUpperButton(String firstName, String lastName, String address, int metroStation, String phone, int date, int rentalDays) {
        objMainPage.clickOnUpperOrderButton();
        objOrderFormPage.takeOrder(firstName, lastName, address, metroStation, phone, date, rentalDays);
    }

    @ParameterizedTest
    @CsvSource({
            "Елена, Сидорова, Казань Баумана 5, 13, +79876543210, 29, 3",
            "Алексей, Смирнов, Новосибирск Красный проспект 15, 2, +79123456789, 25, 7"
    })
    public void takeOrderFromLowerButton(String firstName, String lastName, String address, int metroStation, String phone, int date, int rentalDays) {
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