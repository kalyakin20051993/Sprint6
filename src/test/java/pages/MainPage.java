package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.List;

public class MainPage {
    private WebDriver driver;
    // Верхняя кнопка "Заказать"
    private By upperOrderButton = By.xpath(".//div[@class='Header_Nav__AGCXC']/button[@class='Button_Button__ra12g']");
    // Нижняя кнопка "Заказать"
    private By lowerOrderButton = By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button[text()='Заказать']");
    // Кнопка принять куки
    private By acceptCookie = By.id("rcc-confirm-button");
    // Выпадающий список "Вопросы о важном"
    // Вопрос "Сколько это стоит? И как оплачивать?"
    private By accordionFirstItem = By.id("accordion__heading-0");
    // Ответ на "Сколько это стоит? И как оплачивать?"
    private By accordionFirstItemAnswer = By.xpath(".//div[@id='accordion__panel-0']/p");
    // Вопрос "Хочу сразу несколько самокатов! Так можно?"
    private By accordionSecondItem = By.id("accordion__heading-1");
    // Ответ на "Хочу сразу несколько самокатов! Так можно?"
    private By accordionSecondItemAnswer = By.xpath(".//div[@id='accordion__panel-1']/p");
    // Вопрос "Как рассчитывается время аренды?"
    private By accordionThirdItem = By.id("accordion__heading-2");
    // Ответ на "Как рассчитывается время аренды?"
    private By accordionThirdItemAnswer = By.xpath(".//div[@id='accordion__panel-2']/p");
    // Вопрос "Можно ли заказать самокат прямо на сегодня?"
    private By accordionFourthItem = By.id("accordion__heading-3");
    // Ответ на "Можно ли заказать самокат прямо на сегодня?"
    private By accordionFourthItemAnswer = By.xpath(".//div[@id='accordion__panel-3']/p");
    // Вопрос "Можно ли продлить заказ или вернуть самокат раньше?"
    private By accordionFifthItem = By.id("accordion__heading-4");
    // Ответ на "Можно ли продлить заказ или вернуть самокат раньше?"
    private By accordionFifthItemAnswer = By.xpath(".//div[@id='accordion__panel-4']/p");
    // Вопрос "Вы привозите зарядку вместе с самокатом?"
    private By accordionSixthItem = By.id("accordion__heading-5");
    // Ответ на "Вы привозите зарядку вместе с самокатом?"
    private By accordionSixthItemAnswer = By.xpath(".//div[@id='accordion__panel-5']/p");
    // Вопрос "Можно ли отменить заказ?"
    private By accordionSeventhItem = By.id("accordion__heading-6");
    // Ответ на  "Можно ли отменить заказ?"
    private By accordionSeventhItemAnswer = By.xpath(".//div[@id='accordion__panel-6']/p");
    // Вопрос "Я жизу за МКАДом, привезёте?"
    private By accordionEighthItem = By.id("accordion__heading-7");
    // Ответ на "Я жизу за МКАДом, привезёте?"
    private By accordionEighthItemAnswer = By.xpath(".//div[@id='accordion__panel-7']/p");

    private List<By> questions = List.of(
            accordionFirstItem,
            accordionSecondItem,
            accordionThirdItem,
            accordionFourthItem,
            accordionFifthItem,
            accordionSixthItem,
            accordionSeventhItem,
            accordionEighthItem
    );

    private List<By> answers = List.of(
            accordionFirstItemAnswer,
            accordionSecondItemAnswer,
            accordionThirdItemAnswer,
            accordionFourthItemAnswer,
            accordionFifthItemAnswer,
            accordionSixthItemAnswer,
            accordionSeventhItemAnswer,
            accordionEighthItemAnswer
    );

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    // Нажать верхнюю кнопку "Заказать"
    public void clickOnUpperOrderButton() {
        driver.findElement(upperOrderButton).click();
    }

    // Нажать нижнюю кнопку "Заказать"
    public void clickOnLowerOrderButton() {
        driver.findElement(lowerOrderButton).click();
    }

    public void clickOnAcceptCookie() {
        driver.findElement(acceptCookie).click();
    }

    public String getAccordionTextByIndex(int index) {
        driver.findElement(questions.get(index)).click();
        return driver.findElement(answers.get(index)).getText();
    }
}