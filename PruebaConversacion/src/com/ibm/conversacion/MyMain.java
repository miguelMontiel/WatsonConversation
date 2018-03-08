package com.ibm.conversacion;

import javax.swing.JFrame;

public class MyMain 
{
	public static void main(String[] args) throws Exception 
	{
		SeleccionadorArchivos seleccionadorarchivos = new SeleccionadorArchivos();

		seleccionadorarchivos.setTitle("Enviar archivos CSV a Watson");
		seleccionadorarchivos.setSize(450, 125);
		seleccionadorarchivos.setVisible(true);
		seleccionadorarchivos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}