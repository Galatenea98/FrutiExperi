import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ComprarMembresiaSteps {
    @Given("el cliente quiere publicar sus servicios")
    public void elClienteQuierePublicarSusServicios() {
        webDriver.get("http://localhost:8080/backend_exp");
    }

    @When("se registre")
    public void seRegistre() {
        webDriver.get("http://localhost:8080/backend_exp/login");
        // Login: Sign in
        webDriver.findElement(By.id("username")).sendKeys("username");
        webDriver.findElement(By.id("password")).sendKeys("password");
        webDriver.findElement(By.xpath("/html/body/div/form/button")).click();
    }

    @Then("deberá pagar la membresía del aplicativo")
    public void deberáPagarLaMembresíaDelAplicativo() {
        webDriver.get("http://localhost:8080/backend_exp/perfil");
        webDriver.findElement(By.xpath("/html/body/div/form/button")).click();
        webDriver.findElement(By.id("N-propietarios")).sendKeys("Daniel Martinez Martinez");
        webDriver.findElement(By.id("T-Tarjeta")).sendKeys("visa");
        webDriver.findElement(By.id("F-expiracion")).sendKeys("02/24");
        webDriver.findElement(By.id("C-seguridad")).sendKeys("303");
        webDriver.findElement(By.xpath("/html/body/div/form/button2")).click();
    }
}
