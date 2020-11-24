import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ContactarProveedorSteps {
    @Given("el cliente quiere contactar al proveedor")
    public void elClienteQuiereContactarAlProveedor() {
        webDriver.get("http://localhost:8080/backend_exp/login");
        // Login: Sign in
        webDriver.findElement(By.id("username")).sendKeys("username");
        webDriver.findElement(By.id("password")).sendKeys("password");
        webDriver.findElement(By.xpath("/html/body/div/form/button")).click();
    }

    @When("haya encontrado el servicio que requiere en el filtro de búsqueda")
    public void hayaEncontradoElServicioQueRequiereEnElFiltroDeBúsqueda() {
        Assertions.assertEquals(webDriver.findElement(By.id("service")), "Limpieza de casa");
    }

    @Then("deberá hacer click en el servicio")
    public void deberáHacerClickEnElServicio() {
        webDriver.findElement(By.xpath("/html/body/div/form/button")).click();
    }

    @And("lo dirigirá a una vista para que pueda contactar al proveedor")
    public void loDirigiráAUnaVistaParaQuePuedaContactarAlProveedor() {
        webDriver.findElement(By.xpath("/html/body/div/form/button_contact")).click();
    }
}
