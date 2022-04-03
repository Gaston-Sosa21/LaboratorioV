package dominio3;

public class Principal {

	public static void main(String[] args) {

		Evento[] TipoEvento = new Evento[8];
		TipoEvento[0]=new Recital("Recital1", TipoEntradaRecital.General, GeneroRecital.Heavy_metal,"Metallica","Pantera", 120);
		TipoEvento[1]=new Recital("Recital2", TipoEntradaRecital.VIP, GeneroRecital.Reggaeton,"Lgante", "Cazzu", "Duki", 180);
		TipoEvento[2]=new Infantil("Infantil1", TiposEntradaInfantil.Mayor8 , true, 120);
		TipoEvento[3]=new Infantil("Infantil2",TiposEntradaInfantil.Menor8 , false, 90);
		TipoEvento[4]=new Deporte("Deporte1",TiposEntradaDeporte.Futbol, true, 90);
		TipoEvento[5]=new Deporte("Deporte2",TiposEntradaDeporte.Hockey, false, 60);
		TipoEvento[6]=new Deporte("Deporte3",TiposEntradaDeporte.Rugby, true, 70);
		TipoEvento[7]=new Teatro("Teatro", "General",GenerosTeatro.Comedia, "Chris Rock", "Will Smith", 120);
		
		String[] Fechas = new String[8];
		Fechas[0]="22/03/2022";
		Fechas[1]="16/04/2022";
		Fechas[2]="20/05/2022";
		Fechas[3]="02/06/2022";
		Fechas[4]="22/06/2022";
		Fechas[5]="13/07/2022";
		Fechas[6]="14/07/2022";
		Fechas[7]="06/08/2022";
		
		Entrada[] Ticket = new Entrada[8];
		
		for(int i=0;i<8;i++) {
			Ticket[i] = new Entrada(Fechas[i].toString(),TipoEvento[i]);
			System.out.println(Ticket[i].toString());
		}	
		
	}
}
