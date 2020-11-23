import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FiltrarServicioSolicitadoSteps {
    @Given("el cliente quiere buscar un servicio que sea popular")
    public void elClienteQuiereBuscarUnServicioQueSeaPopular() {
        webDriver.get("http://localhost:8080/backend_exp/login");
        // Login: Sign in
        webDriver.findElement(By.id("username")).sendKeys("dani");
        webDriver.findElement(By.id("password")).sendKeys("1234");
        webDriver.findElement(By.xpath("/html/body/div/form/button")).click();
    }

    @When("busque un servicio")
    public void busqueUnServicio() {
        WebElement linkService = webDriver.findElement(By.name("link-service"));
        linkService.click();
    }

    @Then("deberá elegir la opción de filtrar los servicios por popularidad en el aplicativo")
    public void deberáElegirLaOpciónDeFiltrarLosServiciosPorPopularidadEnElAplicativo() {
        webDriver.findElement(By.xpath("/html/body/div/form/button/filter")).click();
    }

    @Given("el cliente ha filtrado servicios por popularidad")
    public void elClienteHaFiltradoServiciosPorPopularidad() {
        webDriver.findElement(By.xpath("/html/body/div/form/radiobutton/popularity")).click();
    }

    @When("ingresa a la opción")
    public void ingresaALaOpción() {
        Assetion.AssertEquals("http://localhost:8080/backend_exp/service/popularity", driver.getCurrentUrl());
    }

    @Then("se muestra un página con todos los servicios en el aplicativo")
    public void seMuestraUnPáginaConTodosLosServiciosEnElAplicativo() {
        webDriver.get("http://localhost:8080/backend_exp/service/popularity");
    }

    @Given("el cliente visualiza los servicios de acuerdo a la popularidad del proveedor")
    public void elClienteVisualizaLosServiciosDeAcuerdoALaPopularidadDelProveedor() {
        Assetion.AssertEquals("http://localhost:8080/backend_exp/service/popularity", driver.getCurrentUrl());
    }

    @When("seleccine un servicio")
    public void seleccineUnServicio() {
        webDriver.findElement(By.xpath("/html/body/div/form/button")).click();
    }

    @Then("podrá gestionar la solicitud del servicio")
    public void podráGestionarLaSolicitudDelServicio() {
        Assetion.AssertEquals("http://localhost:8080/backend_exp/service/1", driver.getCurrentUrl());
    }
}
