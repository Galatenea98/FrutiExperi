import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CalificarServiciosSteps {

    public static WebDriver webDriver;

    public CalificarServiciosSteps() {
        webDriver = MyWebDriver.getWebDriver();
    }

    @Given("el cliente quiere calificar un servicio")
    public void elClienteQuiereCalificarUnServicio() {
        webDriver.get("http://localhost:8080/backend_exp/login");
        // Login: Sign in
        webDriver.findElement(By.id("username")).sendKeys("dani");
        webDriver.findElement(By.id("password")).sendKeys("1234");
        webDriver.findElement(By.xpath("/html/body/div/form/button")).click();
    }

    @When("haya terminado el proveedor con su trabajo")
    public void hayaTerminadoElProveedorConSuTrabajo() {
        webDriver.get("http://localhost:8080/backend_exp/historial");
        webDriver.findElement(By.xpath("/html/body/div/form/button/service/1")).click();
        webDriver.findElement(By.xpath("/html/body/div/form/button/supplier")).click();

    }

    @Then("deberá ingresar al perfil del proveedor")
    public void deberáIngresarAlPerfilDelProveedor() {
        webDriver.findElement(By.xpath("/html/body/div/form/button")).click();

    }

    @And("en la sección de {string} se encuentran estrellas en color blanco")
    public void enLaSecciónDeSeEncuentranEstrellasEnColorBlanco(String arg0) {
        String expected = "Introduzca una calificación";
        Assertions.assertEquals(expected, arg0);
    }

    @And("debe hacer click en las estrellas donde {int} estrellas de color amarillo es Excelente")
    public void debeHacerClickEnLasEstrellasDondeEstrellasDeColorAmarilloEsExcelente(int arg0) {
        webDriver.findElement(By.xpath("/html/body/div/form/button/stars")).click();
    }

    @Given("el cliente ya ha calificado un servicio")
    public void elClienteYaHaCalificadoUnServicio() {
        Assetion.AssertEquals("http://localhost:8080/backend_exp/service/qualify", driver.getCurrentUrl());
    }

    @When("el proveedor termino su trabajo")
    public void elProveedorTerminoSuTrabajo() {
        Assetion.AssertEquals("http://localhost:8080/backend_exp/historial", driver.getCurrentUrl());
    }

    @Then("deberá revisar el perfil del proveeedor donde solo se va a mostrar un promedio de todas las calificaciones")
    public void deberáRevisarElPerfilDelProveeedorDondeSoloSeVaAMostrarUnPromedioDeTodasLasCalificaciones() {
        webDriver.get("http://localhost:8080/backend_exp/supplier/profile", driver.getCurrentUrl());
    }

    @Given("el cliente ha calificado el servicio de un proveedor")
    public void elClienteHaCalificadoElServicioDeUnProveedor() {
        Assetion.AssertEquals("http://localhost:8080/backend_exp/supplier/profile", driver.getCurrentUrl());
    }

    @When("ingrese al perfil de dicho proveedor")
    public void ingreseAlPerfilDeDichoProveedor() {
        webDriver.get("http://localhost:8080/backend_exp/supplier/profile", driver.getCurrentUrl());
    }

    @Then("se le mostrará solo el promedio de todas las calificaciones")
    public void seLeMostraráSoloElPromedioDeTodasLasCalificaciones() {
        Assetion.AssertEquals("5", webDriver.findElement(By.id("promedio")).value());

    }
}