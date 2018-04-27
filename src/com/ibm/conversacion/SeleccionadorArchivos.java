package com.ibm.conversacion;

import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SeleccionadorArchivos extends JFrame implements ActionListener
{
	private static final long serialVersionUID = 1L;
	private JFrame jframe;
	private JPanel jpanel;
	private GroupLayout grouplayout;
	
	private JLabel jlabel;
	private JLabel jlabel2;
	private JTextField jtextfield;
	private JButton jbuttonBuscar;
	private JButton jbuttonEnviar;
	private JFileChooser jfilechooser;
	
	private Cursor handCursor;
	private Cursor textCursor;
	
	File[] file;
	File file2 = new File("Respuesta.csv");  
	
	CreadorCSV creadorcsv;
	
	SeleccionadorArchivos() throws Exception
	{
		jframe = new JFrame();
		jpanel = new JPanel();
		grouplayout = new GroupLayout(jpanel);
		
		jlabel = new JLabel("Presione 'SHIFT' + Click para seleccionar multiples archivos");
		jlabel2 = new JLabel("Archivo Generado!");
		jtextfield = new JTextField(30);
		jbuttonBuscar = new JButton("Buscar...");
		jbuttonEnviar = new JButton("Enviar");
		jfilechooser = new JFileChooser();
		
		
		handCursor = new Cursor(Cursor.HAND_CURSOR);
		textCursor = new Cursor(Cursor.TEXT_CURSOR);
		
		jfilechooser.setCurrentDirectory(new File("."));
		
		creadorcsv = new CreadorCSV();
		
		jbuttonBuscar.setCursor(handCursor);
		jbuttonEnviar.setCursor(handCursor);
		jlabel.setCursor(textCursor);
		jlabel2.setCursor(textCursor);
		jtextfield.setCursor(textCursor);
		
		jbuttonBuscar.addActionListener(this);
		jbuttonEnviar.addActionListener(this);
		
		add(jpanel);
		
		jtextfield.setEnabled(false);
		jlabel2.setVisible(false);
		
		grouplayout.setHorizontalGroup(grouplayout.createSequentialGroup()
				.addComponent(jlabel)
				.addComponent(jtextfield)
				.addComponent(jbuttonBuscar)
				.addComponent(jbuttonEnviar)
				.addComponent(jlabel2));
	}
	
	public void actionPerformed(ActionEvent e) 
	{		
		if(e.getSource() == jbuttonBuscar)
		{
			if (file2.exists()) 
			{
			    file2.delete(); 
			    System.out.println("Archivo borrado!");
			}
			
			jfilechooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
			jfilechooser.setMultiSelectionEnabled(true);
			jfilechooser.showOpenDialog(SeleccionadorArchivos.this);
			file = jfilechooser.getSelectedFiles();
			jtextfield.setText(file[0].toString());
			jlabel2.setVisible(false);
		}

		if(e.getSource() == jbuttonEnviar)
		{
			if(file == null)
			{
				JOptionPane.showMessageDialog(jframe, "Seleccionar archivo.", "No se pudo enviar", JOptionPane.ERROR_MESSAGE);
			}
			else
			{
				for(int i = 0; i < file.length; i++)
				{
					creadorcsv.EscritorCSV(file[i].toString());
					System.out.println(file[i].toString());
				}
				jlabel2.setVisible(true);
				jtextfield.setText("");
			}
		}
	}
}