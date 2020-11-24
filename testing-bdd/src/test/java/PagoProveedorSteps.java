import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PagoProveedorSteps {
    @Given("el cliente quiere realizar el pago respectivo por el servicio daodo")
    public void elClienteQuiereRealizarElPagoRespectivoPorElServicioDaodo() {
        webDriver.get("http://localhost:8080/backend_exp/login");
        // Login: Sign in
        webDriver.findElement(By.id("username")).sendKeys("dani");
        webDriver.findElement(By.id("password")).sendKeys("1234");
        webDriver.findElement(By.xpath("/html/body/div/form/button")).click();
        webDriver.get("http://localhost:8080/backend_exp/historial");
        webDriver.findElement(By.xpath("/html/body/div/form/button/service/1")).click();

    }

    @When("le de click a la parte superior y seleccione su perfil")
    public void leDeClickALaParteSuperiorYSeleccioneSuPerfil() {
        webDriver.findElement(By.xpath("/html/body/div/form/button/supplier")).click();
    }

    @And("aparecerá un botón que diga {string}")
    public void apareceráUnBotónQueDiga(String arg0) {
        String expected = "Realizar pago";
        Assertions.assertEquals(expected, arg0);
    }

    @Then("al darle click a ese botón, tendrá que darle click al servicio que desee pagar")
    public void alDarleClickAEseBotónTendráQueDarleClickAlServicioQueDeseePagar() {
        webDriver.findElement(By.xpath("/html/body/div/form/button/pay")).click();
    }

    @Given("el cliente se encuentre en el servicio a pagar")
    public void elClienteSeEncuentreEnElServicioAPagar() {
        Assetion.AssertEquals("http://localhost:8080/backend_exp/pay", driver.getCurrentUrl());
    }

    @When("le de click al botón {string}")
    public void leDeClickAlBotón(String arg0) {
        webDriver.findElement(By.linktext(arg0)).click();
    }

    @Then("le aparecerá el siguiente mensaje {string}")
    public void leApareceráElSiguienteMensaje(String arg0) {
        String expected = "Ingrese sus datos";
        Assertions.assertEquals(expected, arg0);
    }

    @Given("el cliente se encuentre realizando el pago respectivo")
    public void elClienteSeEncuentreRealizandoElPagoRespectivo() {
        webDriver.findElement(By.id("N-propietarios")).sendKeys("Daniel Martinez Martinez");
        webDriver.findElement(By.id("T-Tarjeta")).sendKeys("visa");
        webDriver.findElement(By.id("F-expiracion")).sendKeys("02/24");
        webDriver.findElement(By.id("C-seguridad")).sendKeys("303");

    }

    @When("oricese el pago")
    public void oriceseElPago() {
        webDriver.findElement(By.xpath("/html/body/div/form/button2")).click();
    }

    @Then("se le mandará la boleta de pago a su correo electrónico")
    public void seLeMandaráLaBoletaDePagoASuCorreoElectrónico() {
        Assetion.AssertEquals("http://localhost:8080/backend_exp/", driver.getCurrentUrl());
    }
}
