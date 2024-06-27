package principal;

import java.awt.EventQueue;

import Fechas.Dia;
import UI.IniciarSesion;
import UI.InicioUsuario;

public class Main {

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Empleadora e = Empleadora.getInstancia();
					Usuario admin = new Usuario("04052180488", "admin", "admin", 'M', "ya tu sabe", "55065148", "Superior", "Informatico", 3, 20);
					Empresa emp1 = new Empresa("complejo", "Boyeros", "76836414", "Alimenticio", "complejo1");
					e.agUsuario(admin);
					e.agEmpresa(emp1);
					IniciarSesion frame = new IniciarSesion();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
