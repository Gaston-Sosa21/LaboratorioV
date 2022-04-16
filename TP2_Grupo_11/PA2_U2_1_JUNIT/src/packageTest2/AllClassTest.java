package packageTest2;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import frgp.utn.edu.ar.main.MatrizAdyacencia;

//Configurar desde Run As -> Run configuration -> Test Runner "JUnit4" apply y Ok.
@RunWith(JUnitPlatform.class)

@SelectClasses({ MatrizAdyacencia.class })

public class AllClassTest {

}
