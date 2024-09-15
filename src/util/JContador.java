package util;

import javax.swing.JLabel;

import java.awt.Font;

public class JContador extends JLabel{
	private int numero;
	
	public JContador(int contador) {
		numero = contador;
		llenarComponentes();
	}
	
	private void llenarComponentes(){
		setFont(new Font("Roboto Black", Font.BOLD, 19));
		this.setText(String.valueOf(numero));
	}
	
	public void actualizarContador(int num){
		this.setText(String.valueOf(num));
	}

}
