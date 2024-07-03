package com.nttdata.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MyStorePage {

    private WebDriver driver;

    private By botonInicioIniciarSesion = By.xpath("//span[contains(text(),'Iniciar sesión')]");

    private By barraUsername = By.xpath("//input[@id='field-email']");

    private By barraPassword = By.xpath("//input[@id='field-password']");

    private By botonIniciarSesion = By.xpath("//button[@id='submit-login']");

    private By validarAutenticacionUsuario = By.xpath("//span[contains(text(),'Jhon Sebasthian Enrique Marcos Soto')]");

    private By etiquetaCategoriaClothes = By.xpath("//header/div[2]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[1]/a[1]");

    private By botonSubcategoriaMen = By.xpath("//body/main[1]/section[1]/div[1]/div[1]/div[2]/section[1]/div[2]/ul[1]/li[1]/div[1]/a[1]/picture[1]/img[1]");

    private By etiquetaProducto = By.xpath("//a[contains(text(),'Hummingbird printed t-shirt')]");

    private By barraAgregarProducto = By.xpath("//input[@id='quantity_wanted']");

    private By botonAgregarCarrito = By.xpath("//i[contains(text(),'\uE547')]");

    private By validarProductoAgregadoCarrito= By.xpath("//h4[@id='myModalLabel']");

    private By subtotalElementValidar = By.xpath("//body/div[@id='blockcart-modal']/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/p[2]/span[2]");

    private By totalElementValidar = By.xpath("//body/div[@id='blockcart-modal']/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/p[4]/span[2]");

    private By botonFinalizarCompra = By.xpath("//body/div[@id='blockcart-modal']/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/a[1]");

    private By validarTituloCarrito = By.xpath("//h1[contains(text(),'Carrito')]");

    private By validarCarritoSubtotal = By.xpath("//body/main[1]/section[1]/div[1]/div[1]/div[1]/section[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/span[2]");

    private By validarCarritoTotal = By.xpath("//body/main[1]/section[1]/div[1]/div[1]/div[1]/section[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[2]/span[2]");

    private WebDriverWait wait;

    public MyStorePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clicInicioIniciarSesion() throws InterruptedException{
        wait.until(ExpectedConditions.elementToBeClickable(botonInicioIniciarSesion));
        WebElement botonInicioSesion = driver.findElement(botonInicioIniciarSesion);
        botonInicioSesion.click();

    }

    public void ingresarUsername(String texto) throws InterruptedException{
        wait.until(ExpectedConditions.visibilityOfElementLocated(barraUsername));
        WebElement bUsername = driver.findElement(barraUsername);
        bUsername.sendKeys(texto);
    }

    public void ingresarPassword(String texto)throws InterruptedException{
        wait.until(ExpectedConditions.visibilityOfElementLocated(barraPassword));
        WebElement bPassword = driver.findElement(barraPassword);
        bPassword.sendKeys(texto);

    }

    public void clicIniciarSesion() throws InterruptedException{
        wait.until(ExpectedConditions.elementToBeClickable(botonIniciarSesion));
        WebElement botoniniciarSesion = driver.findElement(botonIniciarSesion);
        botoniniciarSesion.click();

    }

    public boolean validarAutenticacionUsuario() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(validarAutenticacionUsuario));
        WebElement nombreUsuario = driver.findElement(validarAutenticacionUsuario);
        return nombreUsuario.getText().equals("Jhon Sebasthian Enrique Marcos Soto");
    }

    public void clicEtiquetaClothes ()throws InterruptedException{
        wait.until(ExpectedConditions.elementToBeClickable(etiquetaCategoriaClothes));
        WebElement etiquetaClothes = driver.findElement(etiquetaCategoriaClothes);
        etiquetaClothes.click();
    }

    public void clicSubcategoriaMen ()throws InterruptedException{
        wait.until(ExpectedConditions.elementToBeClickable(botonSubcategoriaMen));
        WebElement subMen = driver.findElement(botonSubcategoriaMen);
        subMen.click();

    }

    public void clicEtiquetaProducto()throws InterruptedException{
        wait.until(ExpectedConditions.elementToBeClickable(etiquetaProducto));
        WebElement etiquetaProd = driver.findElement(etiquetaProducto);
        etiquetaProd.click();

    }

    public void cambiarCantidadProducto(int cantidad) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(barraAgregarProducto));
        WebElement cantidadProducto = driver.findElement(barraAgregarProducto);
        cantidadProducto.click();
        cantidadProducto.clear();
        cantidadProducto.sendKeys(Keys.BACK_SPACE);
        cantidadProducto.sendKeys(String.valueOf(cantidad));

    }

    public void clicbotonAgregarCarrito()throws InterruptedException{
        wait.until(ExpectedConditions.elementToBeClickable(botonAgregarCarrito));
        WebElement clicbotonCarrito = driver.findElement(botonAgregarCarrito);
        clicbotonCarrito.click();


    }

    public boolean validarProductoAgregadoCarrito() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(validarProductoAgregadoCarrito));
        WebElement mensajeCarrito = driver.findElement(validarProductoAgregadoCarrito);
        return mensajeCarrito.getText().contains("Producto añadido correctamente a su carrito de compra");

    }

    public boolean validarCalculoMontoTotal() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(subtotalElementValidar));
        WebElement subtotalWebElement = driver.findElement(subtotalElementValidar);
        WebElement totalWebElement = driver.findElement(totalElementValidar);

        String subtotalTexto = subtotalWebElement.getText().replace("S/ ", "").replace(" PEN", "").replace(",", "");
        String totalTexto = totalWebElement.getText().replace("S/ ", "").replace(" PEN", "").replace(",", "");

        double subtotal = Double.parseDouble(subtotalTexto);
        double total = Double.parseDouble(totalTexto);

        return total == subtotal;
    }

    public void clicbotonFinalizarCompra()throws InterruptedException{
        wait.until(ExpectedConditions.elementToBeClickable(botonFinalizarCompra));
        WebElement clicbotonFinalizar = driver.findElement(botonFinalizarCompra);
        clicbotonFinalizar.click();
    }

    public boolean validarTituloCarrito() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(validarTituloCarrito));
        WebElement tituloCarrito = driver.findElement(validarTituloCarrito);
        return tituloCarrito.getText().equals("CARRITO");
    }

    public boolean validarCalculoMontoTotalCarrito() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(validarCarritoSubtotal));
        WebElement subtotalWebElement = driver.findElement(validarCarritoSubtotal);
        WebElement totalWebElement = driver.findElement(validarCarritoTotal);

        String subtotalTexto = subtotalWebElement.getText().replace("S/ ", "").replace(" PEN", "").replace(",", "");
        String totalTexto = totalWebElement.getText().replace("S/ ", "").replace(" PEN", "").replace(",", "");

        double subtotal = Double.parseDouble(subtotalTexto);
        double total = Double.parseDouble(totalTexto);

        return total == subtotal;
    }

}
