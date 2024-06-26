package Fechas;

import java.time.LocalDateTime;

public class Mes {
	
private String mes;
	
	public Mes(){
		obtenerMes();
	}

	public void obtenerMes(){
		LocalDateTime hoy = LocalDateTime.now();
		String mes = hoy.getMonth().name();
		if (mes == "JANUARY"){
			setMes("Enero");
		}
		else if(mes == "FEBRUARY"){
			setMes("Febrero");
		}
		else if(mes == "MARCH"){
			setMes("Marzo");
		}
		else if(mes == "APRIL"){
			setMes("Abril");
		}
		else if(mes == "MAY"){
			setMes("Mayo");
		}
		else if(mes == "JUNE"){
			setMes("Junio");
		}
		else if(mes == "JULE"){
			setMes("Julio");
		}
		else if(mes == "AUGUST"){
			setMes("Agosto");
		}
		else if(mes == "SEPTEMBER"){
			setMes("Septiembre");
		}
		else if(mes == "OCTOBER"){
			setMes("Octubre");
		}
		else if(mes == "NOVEMBER"){
			setMes("Noviembre");
		}
		else{
			setMes("Diciembre");
		}
	}

	public String getMes() {
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}

}
