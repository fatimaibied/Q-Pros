package TestCases;

import MainClass.MainClass;
import TestingFunctions.Functions;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;


import static TestingFunctions.Functions.*;

public class subscribePage extends MainClass {
    Functions supportFunctions = new Functions();
    String[] countryList = {"KSA", "Kuwait", "Bahrain"};
    String[] countryListAr = {"السعودية", "الكويت", "البحرين"};

    @Test (priority =0)// checking the currency all countries
    public void countryCurrency() {
        language ="EN";
        for (int i = 0; i < countryList.length; i++) {
            supportFunctions.changeCountry(countryList[i]);
            String country = driver.findElement(By.xpath("//span[@id='country-name']")).getAttribute("innerHTML").trim();
            Assert.assertEquals(country, countryList[i]);

            String[] currency = {};
            String[] plan = {"lite", "classic", "premium"};
            for (int j = 0; j < 3; j++) {

                currency = driver.findElement(By.xpath("//*[@id='currency-" + plan[j] + "']/i")).getAttribute("innerHTML").trim().split("/");

                System.out.println(currency[0]);
                Assert.assertEquals(currency[0], supportFunctions.countryCurrency(countryList[i]));
            }
        }

    }

    @Test (priority =1) //checking the price and currency in type details page for all countries
    public void typeDetails(){

        for (int i = 0; i < countryList.length; i++) {
            supportFunctions.changeCountry(countryList[i]);
            String country = driver.findElement(By.xpath("//span[@id='country-name']")).getAttribute("innerHTML").trim();
            Assert.assertEquals(country, countryList[i]);


            String [] price =new String[3];
            float planPrice;
            String[] plan = {"lite", "classic", "premium"};
            String []actualPlan ={};

            for (int j = 0; j < 3; j++) {

                price[j]= driver.findElement(By.xpath("//*[@id='currency-" + plan[j] + "']/b")).getAttribute("innerHTML").trim();

                System.out.println(price[j]);

                driver.findElement(By.xpath("//a[@id='"+plan[j]+"-selection']")).click();

              actualPlan=  driver.findElement(By.xpath("//span[@id='order-tier-name']")).getAttribute("innerHTML").trim().split(":");

                Assert.assertEquals(actualPlan[1].toLowerCase().trim(),plan[j]);
                planPrice=Float.parseFloat( driver.findElement(By.xpath("//*[@id=\"order-tier-price\"]/b")).getText());

                Assert.assertEquals( planPrice ,Float.parseFloat(price[j]));
                driver.findElement(By.xpath("//*[@id=\"header\"]/div/strong/a")).click();


        }

    }}


@Test (priority =2) //Testing prices in arabic
    public void arabicCurrency(){
    language ="AR";
        driver.findElement(By.xpath("//a[@id='translation-btn']")).click();
    for (int i = 0; i < countryListAr.length; i++) {
        supportFunctions.changeCountry(countryListAr[i]);
        String country = driver.findElement(By.xpath("//span[@id='country-name']")).getAttribute("innerHTML").trim();
        Assert.assertEquals(country, countryListAr[i]);

        String[] currency = {};
        String[] plan = {"لايت", "الأساسية", "بريميوم"};
        for (int j = 0; j < 3; j++) {

            currency = driver.findElement(By.xpath("//*[@id='currency-" + plan[j] + "']/i")).getAttribute("innerHTML").trim().split("/");

            System.out.println(currency[0]);
            Assert.assertEquals(currency[0], supportFunctions.countryCurrency(countryListAr[i]));
        }
    }
}
}


