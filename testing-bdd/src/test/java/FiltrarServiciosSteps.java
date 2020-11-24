import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FiltrarServiciosSteps {
    @Given("el cliente quiere encontrar un proveedor")
    public void elClienteQuiereEncontrarUnProveedor() {
        webDriver.get("http://localhost:8080/backend_exp/login");
        // Login: Sign in
        webDriver.findElement(By.id("username")).sendKeys("dani");
        webDriver.findElement(By.id("password")).sendKeys("1234");
        webDriver.findElement(By.xpath("/html/body/div/form/button")).click();
    }

    @When("busque un servicio determinado")
    public void busqueUnServicioDeterminado() {
        webDriver.get("http://localhost:8080/backend_exp/service");
    }

    @Then("deberá elegir la opción de filtrar servicios por tipo de servicio en el buscador del aplicativo")
    public void deberáElegirLaOpciónDeFiltrarServiciosPorTipoDeServicioEnElBuscadorDelAplicativo() {
        webDriver.findElement(By.xpath("/html/body/div/form/dropdown/tipo_servicio")).click();
    }

    @Given("el cliente ha filtrado por tipo de servicio")
    public void elClienteHaFiltradoPorTipoDeServicio() {
        webDriver.get("http://localhost:8080/backend_exp/login");
        // Login: Sign in
        webDriver.findElement(By.id("username")).sendKeys("dani");
        webDriver.findElement(By.id("password")).sendKeys("1234");
        webDriver.findElement(By.xpath("/html/body/div/form/button")).click();
        webDriver.get("http://localhost:8080/backend_exp/service");

    }

    @When("Ingresa el servicio que desea buscar")
    public void IngresaElServicioQueDeseaBuscar() {
        webDriver.findElement(By.xpath("/html/body/div/form/radiobutton/tipo_servicio")).click();
        webDriver.findElement(By.xpath("/html/body/div/form/button")).click();
    }

    @Then("se muestran una página con el servicio buscado por el cliente y sus diferentes proveedores")
    public void seMuestranUnaPáginaConElServicioBuscadoPorElClienteYSusDiferentesProveedores() {
        Assetion.AssertEquals("http://localhost:8080/backend_exp/service/tipo", driver.getCurrentUrl());
    }


}
