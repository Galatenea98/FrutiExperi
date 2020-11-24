import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CrearPerfilSteps {
    public static WebDriver webDriver;
    public CrearPerfilSteps() {
        webDriver = MyWebDriver.getWebDriver();
    }

    @Given("el usuario quiere buscar servicios")
    public void elUsuarioQuiereBuscarServicios() {
    }

    @When("ingrese a la aplicación")
    public void ingreseALaAplicación() {
        webDriver.get("http://localhost:8080/backend_exp/login");
    }

    @Then("debe registrarse como cliente y rellenar los datos requeridos")
    public void debeRegistrarseComoClienteYRellenarLosDatosRequeridos() {
        webDriver.get("http://localhost:8080/backend_exp/register");
        webDriver.findElement(By.id("nombres")).sendKeys("Daniel");
        webDriver.findElement(By.id("apellidos")).sendKeys("Martinez Martinez");
        webDriver.findElement(By.id("numeroDocumento")).sendKeys("12345678");
        webDriver.findElement(By.id("celular")).sendKeys("123456789");
        webDriver.findElement(By.id("direccion")).sendKeys("Jr. Lima 767");
        webDriver.findElement(By.id("correo")).sendKeys("daniel.martinez@gmail.com");
        WebElement linkRegisterClient = webDriver.findElement(By.name("link-registerclient"));
        linkRegisterClient.click();
        webDriver.findElement(By.xpath("/html/body/main/section/div/div[2]/form/button")).submit();
    }

    @Given("el usuario quiere publicar servicios")
    public void elUsuarioQuierePublicarServicios() {
    }

    @When("ingrese a la aplicación y ingrese")
    public void ingreseALaAplicaciónYIngrese() {
        // Login: Sign in
        webDriver.findElement(By.id("username")).sendKeys("dani");
        webDriver.findElement(By.id("password")).sendKeys("1234");
        webDriver.findElement(By.xpath("/html/body/div/form/button")).click();
    }

    @Then("debe registrarse como proveedor y rellenar los datos requeridos")
    public void debeRegistrarseComoProveedorYRellenarLosDatosRequeridos() {
        webDriver.get("http://localhost:8080/backend_exp/register");
        webDriver.findElement(By.id("nombres")).sendKeys("Daniel");
        webDriver.findElement(By.id("apellidos")).sendKeys("Martinez Martinez");
        webDriver.findElement(By.id("numeroDocumento")).sendKeys("12345678");
        webDriver.findElement(By.id("celular")).sendKeys("123456789");
        webDriver.findElement(By.id("direccion")).sendKeys("Jr. Lima 767");
        webDriver.findElement(By.id("correo")).sendKeys("daniel.martinez@gmail.com");
        WebElement linkRegisterSupplier = webDriver.findElement(By.name("link-registersupplier"));
        linkRegisterSupplier.click();
        webDriver.findElement(By.xpath("/html/body/main/section/div/div[2]/form/button")).submit();
    }

    @Given("el usuario ha registrado los datos requeridos")
    public void elUsuarioHaRegistradoLosDatosRequeridos() {
        webDriver.get("http://localhost:8080/backend_exp/register");
        webDriver.findElement(By.id("nombres")).sendKeys("Daniel");
        webDriver.findElement(By.id("apellidos")).sendKeys("Martinez Martinez");
        webDriver.findElement(By.id("numeroDocumento")).sendKeys("12345678");
        webDriver.findElement(By.id("celular")).sendKeys("celular");
        webDriver.findElement(By.id("direccion")).sendKeys("Jr. Lima 767");
        webDriver.findElement(By.id("correo")).sendKeys("daniel.martinez@gmail.com");
        WebElement linkRegisterClient = webDriver.findElement(By.name("link-registerclient"));
        linkRegisterClient.click();
        webDriver.findElement(By.xpath("/html/body/main/section/div/div[2]/form/button")).submit();

    }

    @When("le seleccione la opción registrarse sis su datos no son correctos")
    public void leSeleccioneLaOpciónRegistrarseSisSuDatosNoSonCorrectos() {
        Assertion.IsTrue( driver.findElement(By.Id("Error")).isEnabled())
    }

    @Then("se motrará el siguiente mensaje {string}")
    public void seMotraráElSiguienteMensaje(String arg0) {
        String expected = "Introduzca datos validos";
        Assertions.assertEquals(expected, arg0);
    }
}
