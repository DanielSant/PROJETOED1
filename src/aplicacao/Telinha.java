package aplicacao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import arquivo.ManipularArquivo;
import estruturacao.BubbleSort;
import estruturacao.Ligacao;
import estruturacao.ListaDupEncad;
import estruturacao.ShellSort;
import filmes.Filmes;

import java.io.File;
import java.io.IOException;

import javax.swing.JTextField;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JToolBar;
import java.awt.event.MouseMotionAdapter;

public class Telinha extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField pesquisa;
	private static File file = new File("D-IMDB delimitador barra t.txt");
	private static long fim;
	private static long fimShell;
	private static long fimBolha;
	private static BubbleSort bubbleordena = new BubbleSort();
	private static ListaDupEncad listaDesordenada = new ListaDupEncad();
	private static ManipularArquivo arq = new ManipularArquivo();
	private static Ligacao auxConcha[] = new Ligacao[listaDesordenada.getTotalFilmes()];
	private static ShellSort shellOrdena = new ShellSort();

	public static void aplication()
	{
		Filmes vetorDesordenado[] = new Filmes[5000];
		try
		{
			long inicio = System.currentTimeMillis();
			listaDesordenada = arq.carregarFilmes(file);
			fim = System.currentTimeMillis() - inicio;
			// -----------------------------------------
			long inicio2 = System.currentTimeMillis();
			arq.carregarFilmes(file, vetorDesordenado);
			long fim2 = System.currentTimeMillis() - inicio2;
			// ----------------------------------------------
			System.out.println("Tempo de carregar os filmes com vetor em milisegundos: " + fim2);
		} catch (IOException e)
		{
			System.out.println(e.toString());
		}

		// TempoShell----------------------------------------------------------
		long inicio = System.currentTimeMillis();
		shellOrdena.shellSort(auxConcha);
		fimShell = System.currentTimeMillis() - inicio;
		// ----------------------------------------------------------
		
		Ligacao auxBolha[] = new Ligacao[listaDesordenada.getTotalFilmes()];
		Ligacao atual2 = listaDesordenada.getPrimeiro();
		int i2 = 0;
		while (atual2 != null && i2 < listaDesordenada.getTotalFilmes())
		{
			auxBolha[i2] = atual2;
			atual2 = atual2.proximo;
			i2++;
		}
		// TempoBolha----------------------------------------------------------
		long inicio1 = System.currentTimeMillis();
		bubbleordena.bubbleSort(auxBolha);
		fimBolha = System.currentTimeMillis() - inicio1;
		// ----------------------------------------------------------
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					aplication();
					Telinha frame = new Telinha();
					frame.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Telinha()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1400, 780);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblNewLabel = new JLabel("BubbleSort");
		lblNewLabel.setForeground(new Color(51, 51, 153));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));

		JLabel lblNewLabel_1 = new JLabel("ShellSort");
		lblNewLabel_1.setForeground(new Color(51, 51, 153));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblNewLabel_2 = new JLabel("Load Arquivo");
		lblNewLabel_2.setForeground(new Color(51, 51, 153));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 30));

		JTextPane pnBubble = new JTextPane();
		pnBubble.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				pnBubble.setText("Comparações:\n" + bubbleordena.getComparacoes() + "\nTrocas:\n" + bubbleordena.getTrocas() + "\nTempo:\n" + fimBolha + " milisegundos");
			}
		});
		pnBubble.setFont(new Font("Times New Roman", Font.BOLD, 25));
		pnBubble.setBackground(UIManager.getColor("Button.shadow"));
		pnBubble.setEditable(false);

		JLabel lblNewLabel_3 = new JLabel("Estrutura de Dados I");
		lblNewLabel_3.setForeground(new Color(102, 0, 204));
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 60));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblPesquisarFilmes = new JLabel("Pesquisar Filmes");
		lblPesquisarFilmes.setFont(new Font("Times New Roman", Font.BOLD, 30));

		JLabel lblSequencial = new JLabel("Sequencial");
		lblSequencial.setHorizontalAlignment(SwingConstants.CENTER);
		lblSequencial.setForeground(new Color(51, 51, 153));
		lblSequencial.setFont(new Font("Times New Roman", Font.BOLD, 30));

		JLabel lblBinria = new JLabel("Bin\u00E1ria");
		lblBinria.setHorizontalAlignment(SwingConstants.CENTER);
		lblBinria.setForeground(new Color(51, 51, 153));
		lblBinria.setFont(new Font("Times New Roman", Font.BOLD, 30));

		JLabel lblNewLabel_4 = new JLabel("T\u00EDtulo:");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);

		pesquisa = new JTextField();
		pesquisa.setFont(new Font("Times New Roman", Font.BOLD, 20));
		pesquisa.setColumns(10);

		JButton btnPesquisa = new JButton("Pesquisar");
		btnPesquisa.setFont(new Font("Times New Roman", Font.BOLD, 20));

		JTextPane pnSequen = new JTextPane();
		pnSequen.setBackground(UIManager.getColor("Button.shadow"));
		pnSequen.setEditable(false);

		JTextPane pnBin = new JTextPane();
		pnBin.setBackground(UIManager.getColor("Button.shadow"));
		pnBin.setEditable(false);

		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);

		JScrollPane jscrollPane = new JScrollPane();

		JTextArea pnListarFilmes = new JTextArea();
		pnListarFilmes.setEditable(false);
		pnListarFilmes.setFont(new Font("Times New Roman", Font.BOLD, 20));
		jscrollPane.setViewportView(pnListarFilmes);

		JTextPane pnArquivo = new JTextPane();
		pnArquivo.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				pnArquivo.setText("Tempo de carregamento:\n" + fim + " milisegundos");
				pnListarFilmes.setText(listaDesordenada.pnListarFilmesOrdem());
			}
		});
		pnArquivo.setBackground(UIManager.getColor("Button.shadow"));
		pnArquivo.setForeground(new Color(0, 0, 0));
		pnArquivo.setFont(new Font("Times New Roman", Font.BOLD, 30));
		pnArquivo.setEditable(false);

		JTextPane pnShell = new JTextPane();
		pnShell.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				pnShell.setText(
						"Comparações:\n" + shellOrdena.getComparacoes() + "\nTrocas:\n" + shellOrdena.getTrocas());
				pnListarFilmes.setText("Para funcionar");
			}
		});
		pnShell.setFont(new Font("Times New Roman", Font.BOLD, 30));
		pnShell.setBackground(UIManager.getColor("Button.shadow"));
		pnShell.setEditable(false);

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_contentPane.createSequentialGroup().addGap(108)
														.addComponent(lblNewLabel_3, GroupLayout.DEFAULT_SIZE, 537,
																Short.MAX_VALUE)
														.addGap(233))
												.addGroup(gl_contentPane
														.createSequentialGroup().addGap(376).addComponent(lblNewLabel_5)
														.addGap(502))
												.addGroup(
														gl_contentPane.createSequentialGroup().addGap(41)
																.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE,
																		GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																.addGap(85)
																.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE,
																		146, Short.MAX_VALUE)
																.addGap(116)
																.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE,
																		116, Short.MAX_VALUE)
																.addGap(197))
												.addGroup(gl_contentPane.createSequentialGroup().addGap(12)
														.addComponent(pnArquivo, GroupLayout.DEFAULT_SIZE, 235,
																Short.MAX_VALUE)
														.addGap(12)
														.addComponent(pnBubble, GroupLayout.DEFAULT_SIZE, 235,
																Short.MAX_VALUE)
														.addGap(12)
														.addComponent(pnShell, GroupLayout.DEFAULT_SIZE, 235,
																Short.MAX_VALUE)
														.addGap(137)))
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_contentPane.createSequentialGroup().addGap(21)
														.addComponent(lblPesquisarFilmes, GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addGap(246))
												.addGroup(gl_contentPane.createSequentialGroup().addGap(21)
														.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 57,
																GroupLayout.PREFERRED_SIZE)
														.addGap(5)
														.addComponent(pesquisa, GroupLayout.DEFAULT_SIZE, 264,
																Short.MAX_VALUE)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(btnPesquisa, GroupLayout.PREFERRED_SIZE, 128,
																GroupLayout.PREFERRED_SIZE))
												.addGroup(gl_contentPane.createSequentialGroup().addGap(51)
														.addComponent(lblSequencial, GroupLayout.DEFAULT_SIZE, 135,
																Short.MAX_VALUE)
														.addGap(133)
														.addComponent(lblBinria, GroupLayout.DEFAULT_SIZE, 93,
																Short.MAX_VALUE)
														.addGap(70))
												.addGroup(gl_contentPane.createSequentialGroup()
														.addComponent(pnSequen, GroupLayout.DEFAULT_SIZE, 236,
																Short.MAX_VALUE)
														.addGap(12).addComponent(pnBin, GroupLayout.DEFAULT_SIZE, 234,
																Short.MAX_VALUE))))
								.addGroup(gl_contentPane.createSequentialGroup().addContainerGap()
										.addComponent(jscrollPane, GroupLayout.DEFAULT_SIZE, 1348, Short.MAX_VALUE)
										.addGap(0)))
						.addContainerGap()));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup().addGap(11)
								.addComponent(lblNewLabel_3, GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE).addGap(41)
								.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
								.addGap(3)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
										.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
										.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE))
								.addGap(11)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(pnArquivo, GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
										.addComponent(pnBubble, GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
										.addComponent(pnShell, GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE))
								.addGap(3))
						.addGroup(gl_contentPane.createSequentialGroup().addContainerGap()
								.addComponent(lblPesquisarFilmes, GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
								.addGap(3)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup().addGap(5)
												.addComponent(lblNewLabel_4))
										.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
												.addComponent(pesquisa, GroupLayout.PREFERRED_SIZE, 35,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(btnPesquisa, GroupLayout.PREFERRED_SIZE, 35,
														GroupLayout.PREFERRED_SIZE)))
								.addGap(22)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblSequencial, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(lblBinria, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE))
								.addGap(11)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(pnSequen, GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
										.addComponent(pnBin, GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE))))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(jscrollPane, GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE).addContainerGap()));
		contentPane.setLayout(gl_contentPane);
	}
}
