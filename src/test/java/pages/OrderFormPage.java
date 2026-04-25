package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderFormPage {
    private WebDriver driver;
    // Поле "Имя"
    private By name = By.xpath(".//input[@placeholder='* Имя']");
    // Поле "Фамилия"
    private By lastName = By.xpath(".//input[@placeholder='* Фамилия']");
    // Поле "Адрес: куда привезти"
    private By address = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    // Поле "Станция метро"
    private By metroStation = By.xpath(".//input[@placeholder='* Станция метро']");
    // Станция метро "Черкизовская"
    private By stationValue2 = By.xpath(".//ul[@class='select-search__options']/li[2]/button");
    // Станция метро "Парк культуры"
    private By stationValue13 = By.xpath(".//ul[@class='select-search__options']/li[13]/button");
    // Станция метро "Багратионовская"
    private By stationValue70 = By.xpath(".//ul[@class='select-search__options']/li[70]/button");
    // Поле "Телефон: на него позвонит курьер"
    private By phone = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    // Кнопка "Далее"
    private By buttonNext = By.cssSelector(".Button_Button__ra12g.Button_Middle__1CSJM");
    // Поле "Когда привезти самокат"
    private By deliveryDate = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    // 25 апреля в календаре
    private By april25Date = By.cssSelector(".react-datepicker__day--025");
    // 27 апреля в календаре
    private By april27Date = By.cssSelector(".react-datepicker__day--027");
    // 29 апреля в календаре
    private By april29Date = By.cssSelector(".react-datepicker__day--029");
    // Поле "Срок аренды"
    private By rentalPeriod = By.cssSelector(".Dropdown-control");
    // Значение выпадающего списка срока аренды "Сутки"
    private By dayRental = By.xpath(".//div[@class='Dropdown-menu']/div[text()='сутки']");
    // Значение выпадающего списка срока аренды "Двое суток"
    private By twoDaysRental = By.xpath(".//div[@class='Dropdown-menu']/div[text()='двое суток']");
    // Значение выпадающего списка срока аренды "Семеро суток"
    private By sevenDaysRental = By.xpath(".//div[@class='Dropdown-menu']/div[text()='семеро суток']");
    // Поле "Цвет самоката"
    private By colour = By.xpath(".//div[@text()='Цвет самоката']");
    // Поле "Комментарий для курьера"
    private By comment = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    // Кнопка "Заказать"
    private By buttonOrder = By.xpath(".//div[@class='Order_Content__bmtHS']/div/button[text()='Заказать']");
    // Кнопка "Да"
    private By buttonYes = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Да']");
    // Окно успешного заказа
    private By successModal = By.xpath(".//div[contains(text(), 'Заказ оформлен')]");

    public OrderFormPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setName(String customerName) {
        driver.findElement(name).sendKeys(customerName);
    }

    public void setLastName(String customerLastName) {
        driver.findElement(lastName).sendKeys(customerLastName);
    }

    public void setAddress(String customerAddress) {
        driver.findElement(address).sendKeys(customerAddress);
    }

    public void clickOnMetroStation() {
        driver.findElement(metroStation).click();
    }

    public void clickOnStationValue2() {
        driver.findElement(stationValue2).click();
    }

    public void clickOnStationValue13() {
        driver.findElement(stationValue13).click();
    }

    public void clickOnStationValue70() {
        driver.findElement(stationValue70).click();
    }

    public void setPhone(String customerPhone) {
        driver.findElement(phone).sendKeys(customerPhone);
    }

    public void clickButtonNext() {
        driver.findElement(buttonNext).click();
    }

    public void clickOnDeliveryDate() {
        driver.findElement(deliveryDate).click();
    }

    public void clickOn25April() {
        driver.findElement(april25Date).click();
    }

    public void clickOn27April() {
        driver.findElement(april27Date).click();
    }

    public void clickOn29April() {
        driver.findElement(april29Date).click();
    }

    public void clickOnRentalPeriod() {
        driver.findElement(rentalPeriod).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.className("Dropdown-menu")
        ));
    }

    public void clickOnOneDayRental() {
        driver.findElement(dayRental).click();
    }

    public void clickOnTwoDaysRental() {
        driver.findElement(twoDaysRental).click();
    }

    public void clickOnSevenDaysRental() {
        driver.findElement(sevenDaysRental).click();
    }

    public void clickOnButtonOrder() {
        driver.findElement(buttonOrder).click();
    }

    public void clickOnButtonYes() {
        driver.findElement(buttonYes).click();
    }

    public void selectMetroStation(int value) {
        clickOnMetroStation();
        if(value == 2) {
            clickOnStationValue2();
        } else if (value == 70) {
            clickOnStationValue70();
        } else {
            clickOnStationValue13();
        }
    }

    public void selectDeliveryDate(int day) {
        clickOnDeliveryDate();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.className("react-datepicker")
        ));

        if(day == 25) {
            clickOn25April();
        } else if(day == 27) {
            clickOn27April();
        } else {
            clickOn29April();
        }

        driver.findElement(deliveryDate).sendKeys(Keys.ESCAPE);
    }

    public void selectDaysRental(int rentalDays) {
        clickOnRentalPeriod();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("Dropdown-menu")));

        if(rentalDays == 1) {
            clickOnOneDayRental();
        } else if(rentalDays == 2) {
            clickOnTwoDaysRental();
        } else {
            clickOnSevenDaysRental();
        }
    }

    public void verifyOrderSuccess() {
        new WebDriverWait(driver, Duration.ofSeconds(1))
                .until(ExpectedConditions.visibilityOfElementLocated(successModal));
    }

    public void takeOrder(String customerName, String customerLastName, String customerAddress, int value,
                          String customerPhone, int day, int rentalDays) {
        setName(customerName);
        setLastName(customerLastName);
        setAddress(customerAddress);
        selectMetroStation(value);
        setPhone(customerPhone);
        clickButtonNext();
        selectDeliveryDate(day);
        selectDaysRental(rentalDays);
        clickOnButtonOrder();
        clickOnButtonYes();
        verifyOrderSuccess();
    }


}
