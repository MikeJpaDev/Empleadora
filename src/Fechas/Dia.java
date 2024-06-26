package Fechas;

import java.time.LocalDateTime;

public class Dia {
	
	private String diaEs;
	
	public Dia(){
		obtenerDia();
	}

	public void obtenerDia(){
		LocalDateTime hoy = LocalDateTime.now();
		String dia = hoy.getDayOfWeek().name();
		if (dia == "SATURDAY"){
			setDiaEs("S�bado");
		}
		else if(dia == "MONDAY"){
			setDiaEs("Lunes");
		}
		else if(dia == "TUESDAY"){
			setDiaEs("Martes");
		}
		else if(dia == "WEDNESDAY"){
			setDiaEs("Mi�rcoles");
		}
		else if(dia == "THURSDAY"){
			setDiaEs("Jueves");
		}
		else if(dia == "FRIDAY"){
			setDiaEs("Viernes");
		}
		else{
			setDiaEs("Domingo");
		}
	}

	public String getDiaEs() {
		return diaEs;
	}

	public void setDiaEs(String diaEs) {
		this.diaEs = diaEs;
	}

}
