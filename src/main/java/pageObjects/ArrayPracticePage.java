package pageObjects;


import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Objects;


import org.apache.logging.log4j.core.util.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import factory.LoggerFactory;
import pageObjects.TryEditorPage.Result;
import utils.ConfigReader;



public class ArrayPracticePage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By arrayInPythonTopicLink = By.xpath("//a[normalize-space()='Arrays in Python']");
    private By practiceQuestionsTopicLink = By.xpath("//a[normalize-space()='Practice Questions']");
    private By practiceQuestionsLinks = By.xpath("//a[@class='list-group-item']");
    private By btnRun = By.xpath("//button[normalize-space()='Run']");
    private By codeEditor = By.xpath("//div[@class='CodeMirror-scroll']");
    private By txtOutput = By.xpath("//pre[@id='output']");
    private By practiceQuestionsinArray=By.xpath("//a[contains(text(),'Practice Questions')]");
    private By searchArrayLink = By.xpath("//a[normalize-space(text())='Search the array']");
    //private By enterPythontextArea=By.xpath( "//textarea[@id='editor']") ;
    private By arrayTopicsLinks=By.xpath("//a[normalize-space()='Arrays in Python']");
    // Constructor
    public ArrayPracticePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }
    public boolean isPracticeQuestionLinkDisplayed(String expectedTopic) {

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(practiceQuestionsLinks));

        List<WebElement> links = driver.findElements(practiceQuestionsLinks);

        for (WebElement link : links) {
            String actualText = link.getText().trim();
            if (actualText.equalsIgnoreCase(expectedTopic.trim())) {
                return true;
            }
        }
        return false;
    }

    public void clickPracticeQuestionsTopicLink() {
        wait.until(ExpectedConditions.elementToBeClickable(practiceQuestionsTopicLink)).click();
    }

    public void clickArrayTopicLink(String arrayTopicLink) {
        By linkPath = By.xpath("//a[text() = '" + arrayTopicLink + "']");
        driver.findElement(linkPath).click();
        // wait.until(ExpectedConditions.elementToBeClickable(arrayTopicsLinks)).click();

    }

    public void clickSearchTheArray() {
        driver.getCurrentUrl().contains("array/practice");
        //   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        //  WebElement element = wait.until(ExpectedConditions.elementToBeClickable(searchArrayLink));
        driver.findElement(searchArrayLink).click();
    }

    public void clickPracticeQuestions() {
        //driver.findElement(practiceQuestionsinArray).click();
        try {
            //WebElement link = wait.until(ExpectedConditions.elementToBeClickable(practiceQuestionsinArray));
            WebElement link = wait.until(ExpectedConditions.elementToBeClickable(practiceQuestionsLinks));
            // Scroll into view just in case
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", link);
            link.click();
        } catch (TimeoutException e) {
            throw new NoSuchElementException("Practice Questions link not found or not clickable.");
        }
    }

    public void clearCodeInTextEditorBox() {
        driver.findElement(codeEditor).sendKeys(Keys.CONTROL , "a");
//	 enterPythontextArea.sendKeys(Keys.CONTROL + "x");
        driver.findElement(codeEditor).sendKeys(Keys.DELETE);
//	 enterPythontextArea.clear();
    }

    public void arrayPracticeQuestion(String s) {
    }

    public void clickRun() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        WebElement runBtn = wait.until(ExpectedConditions.elementToBeClickable(btnRun));
        runBtn.click();
        //driver.findElement(btnRun).click();
    }

    public String getActualResult() {
        return driver.findElement(txtOutput).getText();
    }
    /*
        public void clickPracticeQuestionArray() throws IOException {
            ConfigReader.loadProperties();
            String URL= ConfigReader.getPracticeUrl();
            driver.get(URL);
        }
    */
    public boolean isRunButtonVisible() {
        // return driver.findElement(btnRun).isDisplayed();
        WebElement button = wait.until(ExpectedConditions.visibilityOfElementLocated(btnRun));
        boolean visible = button.isDisplayed();
        return visible;

    }
    public void clickPracticeQuestionsFromTopics() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            WebElement practiceLink = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//a[normalize-space()='Practice Questions']")));
            practiceLink.click();
        } catch (TimeoutException e) {
            System.out.println("Practice Questions link not found or not clickable");
        }
        //driver.findElement(practiceQuestionsTopicLink).click();
    }

    public void clickPracticeQuestionByName(String questionName) {
        By questionLink =  By.xpath("//a[contains(text(),'" + questionName + "')]");
        //By questionLink = By.xpath("//a[contains(normalize-space(),'" + questionName + "')]");

        WebElement link = wait.until(
                ExpectedConditions.elementToBeClickable(questionLink));
        link.click();
    }

    public void clearEditorText() {
        WebElement editor = wait.until(
                ExpectedConditions.visibilityOfElementLocated(codeEditor));

        editor.click();

        Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL)
                .sendKeys("a")
                .keyUp(Keys.CONTROL)
                .sendKeys(Keys.DELETE)
                .perform();
    }
    public void clearEditorText1() {
        // Wait for the editor container (div) to exist
        wait.until(ExpectedConditions.presenceOfElementLocated(codeEditor));

        // Clear editor using JS (works for Ace editor)
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("ace.edit('editor').setValue('');");
    }

    public void enterCodeInEditor1(String code) {

        WebElement editor = driver.findElement(codeEditor);
        // Click to focus first
        editor.click();
        // Clear by sending Ctrl+A + Delete
        editor.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        editor.sendKeys(Keys.DELETE);
        // Now type code
        editor.sendKeys(code);
    }
    public void enterCodeInEditor(String code) {
        WebElement editor = wait.until(
                ExpectedConditions.visibilityOfElementLocated(codeEditor));

        editor.click();
        editor.sendKeys(code);
    }

    public String getEditorText() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return (String) js.executeScript("return ace.edit('editor').getValue();");
    }

    public void clickRunButton() {
        driver.findElement(By.xpath("//button[normalize-space()='Run']")).click();
    }

    public String getOutputText() {
        return driver.findElement(By.id("output")).getText(); // replace with actual output locator
    }

    public void clickArrayTopicLink1() {
        wait.until(ExpectedConditions.elementToBeClickable(arrayInPythonTopicLink)).click();
    }

    public void clickArraysInPythonLink() {
        driver.findElement(arrayInPythonTopicLink).click();
    }

    public void clickPracticeQuestionsFromArraysInPython() {
        clickArraysInPythonLink();
        driver.findElement(practiceQuestionsTopicLink).click();

    }

    public void navigateToArrayPractice() {
        driver.navigate().to("https://dsportalapp.herokuapp.com/array/practice");
    }



    public String getPrintMessage() {
        try {
            return driver.findElement(txtOutput).getText();
        } catch (Exception e) {
            LoggerFactory.getLogger().error(e.getMessage());
            return "";
        }
    }

    public record Result(boolean isAlertWindowVisible, String alertWindowMessage) {
    }

    public Result getAlertWindowVisibilityAndAlertText() {
        try {
            wait = new WebDriverWait(driver, Duration.ofSeconds(30));

            if (wait.until(ExpectedConditions.alertIsPresent()) == null) {
                LoggerFactory.getLogger().info("Alert windows is not visible");
                return new Result(false, "");
            } else {
                Alert alert = driver.switchTo().alert();
                String alertMessage = alert.getText();
                alert.accept();
                LoggerFactory.getLogger().info("Alert was present and accepted");
                return new Result(true, alertMessage);
            }
        } catch (Exception ex) {
            LoggerFactory.getLogger().error(ex.getStackTrace());
            return new Result(false, null);
        }
    }

    public boolean isAlertWindowVisible() {
        try {
            wait = new WebDriverWait(driver, Duration.ofSeconds(30));

            if (wait.until(ExpectedConditions.alertIsPresent()) == null) {
                LoggerFactory.getLogger().info("Alert windows is not visible");
                return false;
            } else {
                Alert alert = driver.switchTo().alert();
                alert.accept();
                LoggerFactory.getLogger().info("Alert was present and accepted");
                return true;
            }
        } catch (Exception ex) {
            LoggerFactory.getLogger().error(ex.getStackTrace());
            return false;
        }
    }

    public String getAlertWindowMessage() {
        try {
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            if (wait.until(ExpectedConditions.alertIsPresent()) == null) {
                LoggerFactory.getLogger().info("Alert windows is not present");
                return "";
            } else {
                Alert alert = driver.switchTo().alert();
                String alertText = alert.getText();
                alert.accept();
                LoggerFactory.getLogger().info("Alert is present and accepted");
                return alertText;
            }
        } catch (Exception ex) {
            LoggerFactory.getLogger().error(ex.getStackTrace());
            return null;
        }
    }

    public void enterDataIntoEditor(String inputData) {
        WebElement txtDsCode = driver.findElement(codeEditor);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Actions act = new Actions(driver);
        act.moveToElement(txtDsCode).click();
        js.executeScript("document.querySelector('.CodeMirror').CodeMirror.setValue('');");
        js.executeScript("document.querySelector('.CodeMirror').CodeMirror.setValue(arguments[0]);", inputData);
    }

    public String getArrayPracticePageURL() {
        return driver.getCurrentUrl();
    }
}


