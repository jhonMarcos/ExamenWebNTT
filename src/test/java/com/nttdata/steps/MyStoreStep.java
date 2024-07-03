package com.nttdata.steps;

import com.nttdata.page.MyStorePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class MyStoreStep {

    WebDriver driver;

    MyStorePage page;

    public MyStoreStep(WebDriver driver) {
        this.driver = driver;
        page = new MyStorePage(driver);
    }

    public void navegarA(String url){
        driver.get(url);
    }

    public void clicBotonInicioIniciarSesion() throws InterruptedException {
        page.clicInicioIniciarSesion();
    }

    public void ingresarUsuario (String username)throws InterruptedException{
        page.ingresarUsername(username);
    }

    public void ingresarClave (String clave)throws InterruptedException{
        page.ingresarPassword(clave);
    }

    public void clicBotonIniciarSesion() throws InterruptedException {
        page.clicIniciarSesion();
    }

    public void validarAutenticacionUsuario()throws InterruptedException{
        page.validarAutenticacionUsuario();
        System.out.println("El usuario fue validado correctamente");
    }

    public void clicCategoriaClothes()throws InterruptedException{
        page.clicEtiquetaClothes();
    }

    public void clicSubcategoriaMen()throws InterruptedException{
        page.clicSubcategoriaMen();
    }

    public void clicEtiquetaProduct ()throws InterruptedException{
        page.clicEtiquetaProducto();

    }

    public void botonAgreganProduct(int cantidad)throws InterruptedException{
        page.cambiarCantidadProducto(cantidad);
    }

    public void botonAgregarCarrito()throws InterruptedException{
        page.clicbotonAgregarCarrito();
    }

    public void validarProductoAgregadoPopup ()throws InterruptedException{
        Assertions.assertTrue(page.validarProductoAgregadoCarrito(), "El producto no se añadió correctamente al carrito.");
        System.out.println("El producto fue agregado correctamente");
    }

    public void validarSubTotalTotal ()throws InterruptedException{
        Assertions.assertTrue(page.validarCalculoMontoTotal(), "El cálculo del monto total es incorrecto.");
        System.out.println("Valido en el popup que el monto total sea calculado correctamente");
    }

    public void botonFinalizarCompra()throws InterruptedException{
        page.clicbotonFinalizarCompra();
    }

    public void validarTituloCarrito ()throws InterruptedException{
        Assertions.assertTrue(page.validarTituloCarrito(),"El titulo es incorrecto");
        System.out.println("Valido el titulo de carrito correctamente");
    }

    public void validarSubTotalTotalCarrito ()throws InterruptedException{
        Assertions.assertTrue(page.validarCalculoMontoTotalCarrito(), "El cálculo del monto total es incorrecto.");
        System.out.println("Valido que el monto total sea corecto");
    }


}
