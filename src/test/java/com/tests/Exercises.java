package com.tests;

import com.beust.jcommander.Parameter;
import com.driver.Driver;
import com.pages.LandingPage;
import com.pages.PrivacyPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class Exercises {

    Logger log = Logger.getLogger("Trivago");
    Driver driver;
    PrivacyPage privacyPage;
    LandingPage landingPage;

    @BeforeSuite
    public void setUpDriver() throws MalformedURLException {
        driver = new Driver();
    }

    @Test
    public void acceptPrivacy() {
        log.info("Accept Privacy");
        privacyPage = new PrivacyPage(driver.getDriver());
        landingPage = new LandingPage(driver.getDriver());
        String body = "Creemos que mereces la mejor experiencia posible cuando usas trivago. Por ello, nosotros y los sitios web de nuestros socios externos compartimos y recopilamos datos, y usamos cookies y otras tecnologías para funcionamiento del sitio, seguimiento, análisis y publicidad personalizada dentro y fuera de trivago. Si estás de acuerdo, confirma tu consentimiento haciendo clic en “Aceptar todo” o personaliza tus preferencias en la configuración de privacidad de tus datos. ";
        String title = "Privacidad de datos";
        String textBody = "";
        for (int i=1; i<privacyPage.body.size();i++){
            textBody = textBody + privacyPage.body.get(i).getText() + " ";
        }
        String textTitle = privacyPage.title.getText();
        Assert.assertEquals(textTitle,title);
        Assert.assertEquals(textBody,body);
        privacyPage.btnAccept.click();
        Assert.assertTrue(landingPage.btnSearch.isDisplayed());
    }
/*
    @Test
    @Parameters({"city","month"})
    public void searchHotel(String city, String month) {
        landingPage.txtSearch.click();
        landingPage.txtEditSearch.sendKeys(city);
        for(int i=0;i<landingPage.cities.size();i++){
            if(landingPage.cities.get(i).getText().contains(city)){
                landingPage.cities.get(i).click();
                break;
            }
        }
        Assert.assertTrue(landingPage.titleCalendar.isDisplayed());
        String text ="";
        for(int i=0;i<landingPage.days.size();i++){
            if(landingPage.days.get(i).getText().equals("1")){
                landingPage.days.get(i).click();
            }
            if(landingPage.days.get(i).getText().equals("5")){
                landingPage.days.get(i).click();
                break;
            }
        }
        Assert.assertTrue(landingPage.btnConfirmDate.isEnabled());
        landingPage.btnConfirmDate.click();
        Assert.assertEquals(city,landingPage.cityReady.getText());
        Assert.assertEquals(month,landingPage.dateReady.getText());
    }*/

    @Test
    @Parameters({"busqueda","sorprendete","favoritos","configuracion"})
    public void menu(String busqueda, String sorprendete, String favoritos, String configuracion) {
        String options="";
        for(int i=0;i<landingPage.menu.size();i++){
            options = options + landingPage.menu.get(i).getText();
        }
        Assert.assertTrue(options.contains(busqueda));
        Assert.assertTrue(options.contains(sorprendete));
        Assert.assertTrue(options.contains(favoritos));
        Assert.assertTrue(options.contains(configuracion));
    }

    @AfterSuite
    public void close(){
        driver.getDriver().quit();
    }
}
