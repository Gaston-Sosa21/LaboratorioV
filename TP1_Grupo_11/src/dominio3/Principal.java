package dominio3;

public class Principal {

	public static void main(String[] args) {
		
		Evento recital1 =  new Recital("Recital1", TipoEntradaRecital.General, GeneroRecital.Heavy_metal,"Metallica","Pantera", 120);
		Evento recital2 =  new Recital("Recital2", TipoEntradaRecital.VIP, GeneroRecital.Reggaeton,"Lgante", "Cazzu", "Duki", 180);
		
		Evento infantil1 =  new Infantil("Infantil1", TiposEntradaInfantil.Mayor8 , true, 120);
		Evento infantil2 =  new Infantil("Infantil2",TiposEntradaInfantil.Menor8 , false, 90);
		
		
		Evento deporte1 =  new Deporte("Deporte1",TiposEntradaDeporte.Futbol, true, 90);
		Evento deporte2 =  new Deporte("Deporte2",TiposEntradaDeporte.Hockey, false, 60);
		Evento deporte3 =  new Deporte("Deporte3",TiposEntradaDeporte.Rugby, true, 70);
		
		Evento teatro =  new Teatro("Teatro", "General",GenerosTeatro.Comedia, "Di Caprio", "Will Smith", 120);
		
		Entrada entrada1 = new Entrada("22/03/2022", recital1);
		System.out.println(entrada1.toString());
		
		Entrada entrada2 = new Entrada("22/04/2022", recital2);
		System.out.println(entrada2.toString());
		
		Entrada entrada3 = new Entrada( "22/05/2022", infantil1);
		System.out.println(entrada3.toString());
		
		Entrada entrada4 = new Entrada( "22/06/2022",infantil2);
		System.out.println(entrada4.toString());
		
		Entrada entrada5 = new Entrada("22/07/2022", deporte1);
		System.out.println(entrada5.toString());
		
		Entrada entrada6 = new Entrada("22/08/2022",deporte2);
		System.out.println(entrada6.toString());
		
		Entrada entrada7 = new Entrada("22/09/2022",deporte3);
		System.out.println(entrada7.toString());
		
		Entrada entrada8 = new Entrada("22/10/2022", teatro);
		System.out.println(entrada8.toString());
		


		
		
		
		
	}
}
