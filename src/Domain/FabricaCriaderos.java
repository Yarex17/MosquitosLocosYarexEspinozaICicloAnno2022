package Domain;

import Domain.Criadero.Balde;
import Domain.Criadero.Canoa;
import Domain.Criadero.Chatarra;
import Domain.Criadero.Criadero;
import Domain.Criadero.Florero;
import Domain.Criadero.Llanta;
import Domain.Criadero.PlatoMaceta;

public class FabricaCriaderos {
private FabricaCriaderos() {
	// TODO Auto-generated constructor stub
}
public static Criadero crearCriaderoInterno(int e) {
switch (e) {
case 1:
	return new Balde();
case 2:
	return new Florero();
case 3:
	return new PlatoMaceta();
	
default:
	return null;
			}	
}

public static Criadero crearCriaderoExterno(int e) {
switch (e) {
case 1:
	return new Llanta();
case 2:
	return new Canoa();
case 3:
	return new Chatarra();
	
default:
	return null;
			}	
}
}
