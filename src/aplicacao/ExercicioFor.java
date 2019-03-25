package aplicacao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.List;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;

public class ExercicioFor extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExercicioFor frame = new ExercicioFor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ExercicioFor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 542, 288);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("In\u00EDcio");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(12, 13, 56, 16);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Fim");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(12, 63, 56, 16);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Passo");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(12, 120, 56, 16);
		contentPane.add(lblNewLabel_2);

		JLabel lblInicio = new JLabel("0");
		lblInicio.setHorizontalAlignment(SwingConstants.CENTER);
		lblInicio.setBounds(278, 13, 56, 16);
		contentPane.add(lblInicio);

		JLabel lblFim = new JLabel("6");
		lblFim.setHorizontalAlignment(SwingConstants.CENTER);
		lblFim.setBounds(278, 63, 56, 16);
		contentPane.add(lblFim);

		JLabel lblPasso = new JLabel("1");
		lblPasso.setHorizontalAlignment(SwingConstants.CENTER);
		lblPasso.setBounds(278, 120, 56, 16);
		contentPane.add(lblPasso);

		JSlider sliInicio = new JSlider();
		sliInicio.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				int i = sliInicio.getValue();
				lblInicio.setText(Integer.toString(i));
			}
		});
		sliInicio.setValue(0);
		sliInicio.setMaximum(5);
		sliInicio.setBounds(80, 10, 200, 26);
		contentPane.add(sliInicio);

		JSlider sliFim = new JSlider();
		sliFim.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				int f = sliFim.getValue();
				lblFim.setText(Integer.toString(f));
			}
		});
		sliFim.setMinimum(6);
		sliFim.setMaximum(50);
		sliFim.setValue(6);
		sliFim.setBounds(80, 60, 200, 26);
		contentPane.add(sliFim);

		JSlider sliPasso = new JSlider();
		sliPasso.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				int p = sliPasso.getValue();
				lblPasso.setText(Integer.toString(p));
			}
		});
		sliPasso.setMinimum(1);
		sliPasso.setMaximum(5);
		sliPasso.setValue(1);
		sliPasso.setBounds(80, 117, 200, 26);
		contentPane.add(sliPasso);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(393, 13, 97, 179);
		contentPane.add(scrollPane);

		JList lstCont = new JList();
		scrollPane.setViewportView(lstCont);
		lstCont.setValueIsAdjusting(true);
		lstCont.setVisibleRowCount(0);
		lstCont.setToolTipText("");
		lstCont.setBorder(new LineBorder(new Color(0, 0, 0)));
		lstCont.setBackground(Color.WHITE);
		lstCont.setModel(new AbstractListModel() {
			String[] values = new String[] {};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});

		JButton btnContar = new JButton("Contar");
		btnContar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = sliInicio.getValue();
				int f = sliFim.getValue();
				int p = sliPasso.getValue();

				DefaultListModel lista = new DefaultListModel();
				
				for (int c = i; c <= f; c += p) {
					lista.addElement(c);
				}
				lstCont.setModel(lista);
			}
		});
		btnContar.setBounds(126, 167, 97, 25);
		contentPane.add(btnContar);

	}
}
