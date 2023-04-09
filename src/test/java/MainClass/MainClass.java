package MainClass;


import org.testng.annotations.*;

import TestingFunctions.Functions;

import static TestingFunctions.Functions.*;

public class MainClass {

    Functions supportFunctions = new Functions ();

    @BeforeClass
    public  void setup()  {
        supportFunctions.driverSetup(url);
    }

    @AfterClass
    public void closeTest()  {

        driver.quit();

    }







}





