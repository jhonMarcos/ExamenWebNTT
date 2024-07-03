package com.nttdata.stepsdefinitions;

import com.nttdata.steps.MyStoreStep;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyStoreStepDef {

    private MyStoreStep myStore;
    private WebDriver driver;
    private Scenario scenario;
    @Before(order = 0)
    public void setUp(){
        //Se ejecutará Automáticamente
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Before(order = 1)
    public void setScenario(Scenario scenario){
        this.scenario = scenario;
    }

    @After
    public void quitDriver(){
        driver.quit();
    }

    @Given("estoy en la pagina de la tienda")
    public void estoyEnLaPaginaDeLaTienda() throws InterruptedException {
        myStore = new MyStoreStep(driver);
        myStore.navegarA("https://qalab.bensg.com/store");
        myStore.clicBotonInicioIniciarSesion();
        screenShot();
    }

    @And("me logueo con mi usuario {string} y clave {string}")
    public void meLogueoConMiUsuarioYClave(String usuario, String clave) throws InterruptedException {
        myStore.ingresarUsuario(usuario);
        myStore.ingresarClave(clave);
        myStore.clicBotonIniciarSesion();
        myStore.validarAutenticacionUsuario();
        screenShot();
    }

    @When("navego a la categoria Clothes y subcategoria Men")
    public void navegoALaCategoriaClothesYSubcategoriaMen() throws InterruptedException{
        myStore.clicCategoriaClothes();
        myStore.clicSubcategoriaMen();
        screenShot();
    }

    @And("agrego {int} unidades del primer producto del carrito")
    public void agregoUnidadesDelPrimerProductoDelCarrito(int cantidad)throws InterruptedException {
        myStore.clicEtiquetaProduct();
        myStore.botonAgreganProduct(cantidad);
        myStore.botonAgregarCarrito();
        screenShot();
    }

    @Then("valido en el popup la confirmacion del producto agregado")
    public void validoEnElPopupLaConfirmacionDelProductoAgregado() throws InterruptedException{
        myStore.validarProductoAgregadoPopup();
        screenShot();
    }

    @And("valido en el popup que el monto total sea calculado correctamente")
    public void validoEnElPopupQueElMontoTotalSeaCalculadoCorrectamente() throws InterruptedException{
        myStore.validarSubTotalTotal();
        screenShot();
    }

    @When("finalizo la compra")
    public void finalizoLaCompra() throws InterruptedException{
        myStore.botonFinalizarCompra();
        screenShot();
    }

    @Then("valido el titulo de la pagina del carrito")
    public void validoElTituloDeLaPaginaDelCarrito()  throws InterruptedException{
        myStore.validarTituloCarrito();
        screenShot();
    }

    @And("vuelvo a validar el calculo de precios en el carrito")
    public void vuelvoAValidarElCalculoDePreciosEnElCarrito() throws InterruptedException{
        myStore.validarSubTotalTotalCarrito();
        screenShot();
    }

    public void screenShot(){
        byte[] evidencia = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        this.scenario.attach(evidencia, "image/png", "evidencias");
    }

}
