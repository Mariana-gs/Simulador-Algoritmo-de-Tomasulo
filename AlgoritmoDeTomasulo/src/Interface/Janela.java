package Interface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

public class Janela {

	private JFrame janela;
	private JTable table1;
	private JTable table2;
	private JTable table3;
	private static Simulador simulador;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		simulador = new Simulador();
		
		try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            System.err.println(ex);
        }
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Janela window = new Janela();
					window.janela.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Janela() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		janela = new JFrame();
		janela.setTitle("simulador - Algoritmo de Tomasulo");
		janela.getContentPane().setBackground(new Color(255, 255, 255));
		janela.setIconImage(Toolkit.getDefaultToolkit().getImage(Janela.class.getResource("/Icones/2292038.png")));
		janela.setBounds(25, 25, 900, 665);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel1 = new JPanel();
		panel1.setBackground(new Color(134, 134, 255));
		
		JScrollPane scrollPane1 = new JScrollPane();
		
		JPanel panel2 = new JPanel();
		panel2.setLayout(null);
		panel2.setBackground(new Color(134, 134, 255));
		
		JLabel lblReservationtionStatus = new JLabel("Reservationtion status");
		lblReservationtionStatus.setForeground(new Color(255, 255, 255));
		lblReservationtionStatus.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblReservationtionStatus.setBounds(376, 10, 140, 20);
		panel2.add(lblReservationtionStatus);
		
		JScrollPane scrollPane2 = new JScrollPane();
		
		JPanel panel3 = new JPanel();
		panel3.setLayout(null);
		panel3.setBackground(new Color(134, 134, 255));
		
		JLabel lblNewLabel_1_1 = new JLabel("Register status");
		lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(396, 10, 93, 20);
		panel3.add(lblNewLabel_1_1);
		
		JScrollPane scrollPane3 = new JScrollPane();
		
		JButton buttonFile = new JButton("Open file");
		buttonFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser arquivo = new JFileChooser();
				FileNameExtensionFilter filtro = new FileNameExtensionFilter("Apenas arquivos .txt", "txt");
				arquivo.setAcceptAllFileFilterUsed(false);
				arquivo.addChoosableFileFilter(filtro);
				
				int valor = arquivo.showOpenDialog(null);
				
				if (valor == JFileChooser.APPROVE_OPTION) {
					File arquivoSelecionado = arquivo.getSelectedFile();
					simulador.path = arquivoSelecionado.getAbsolutePath();
					simulador.inicializarSimulador();
					
					table1.setModel(new DefaultTableModel(
		        			new Object[][] { 
		        				{simulador.carregarTabela1[1].getInstruction().getOpCode(), simulador.carregarTabela1[1].getIssue(), simulador.carregarTabela1[1].getExecute(), simulador.carregarTabela1[1].getWriteResult()},
		        				{simulador.carregarTabela1[1].getInstruction().getOpCode(), simulador.carregarTabela1[1].getIssue(),  simulador.carregarTabela1[1].getExecute(), simulador.carregarTabela1[1].getWriteResult()},
		        				{simulador.carregarTabela1[2].getInstruction().getOpCode(), simulador.carregarTabela1[2].getIssue(),  simulador.carregarTabela1[2].getExecute(), simulador.carregarTabela1[2].getWriteResult()},
		        				{simulador.carregarTabela1[3].getInstruction().getOpCode(), simulador.carregarTabela1[3].getIssue(),  simulador.carregarTabela1[3].getExecute(), simulador.carregarTabela1[3].getWriteResult()},
		        				{simulador.carregarTabela1[4].getInstruction().getOpCode(), simulador.carregarTabela1[4].getIssue(),  simulador.carregarTabela1[4].getExecute(), simulador.carregarTabela1[4].getWriteResult()},
		        				{simulador.carregarTabela1[5].getInstruction().getOpCode(), simulador.carregarTabela1[5].getIssue(),  simulador.carregarTabela1[5].getExecute(), simulador.carregarTabela1[5].getWriteResult()},
		        				null,
		        				null,
		        				null,
		        				null,
		        			},
		        			new String[] {
		        				"Instruction", "Issue", "Execute", "Write result"
		        			}
		        		));
					
					table2.setModel(new DefaultTableModel(
		        			new Object[][] {
		        				{simulador.load[0].getName(), simulador.load[0].getBussy(), simulador.load[0].getOp(), simulador.load[0].getVj(), simulador.load[0].getVk(), simulador.load[0].getQj(), simulador.load[0].getQk(), simulador.load[0].getA()},
		        				{simulador.load[1].getName(), simulador.load[1].getBussy(), simulador.load[1].getOp(), simulador.load[1].getVj(), simulador.load[1].getVk(), simulador.load[1].getQj(), simulador.load[1].getQk(), simulador.load[1].getA()},
		        				{simulador.add[0].getName(), simulador.add[0].getBussy(), simulador.add[0].getOp(), simulador.add[0].getVj(), simulador.add[0].getVk(), simulador.add[0].getQj(), simulador.add[0].getQk(), simulador.add[0].getA()},
		        				{simulador.add[1].getName(), simulador.add[1].getBussy(), simulador.add[1].getOp(), simulador.add[1].getVj(), simulador.add[1].getVk(), simulador.add[1].getQj(), simulador.add[1].getQk(), simulador.add[1].getA()},
		        				{simulador.add[2].getName(), simulador.add[2].getBussy(), simulador.add[2].getOp(), simulador.add[2].getVj(), simulador.add[2].getVk(), simulador.add[2].getQj(), simulador.add[2].getQk(), simulador.add[2].getA()},
		        				{simulador.mult[0].getName(), simulador.mult[0].getBussy(), simulador.mult[0].getOp(), simulador.mult[0].getVj(), simulador.mult[0].getVk(), simulador.mult[0].getQj(), simulador.mult[0].getQk(), simulador.mult[0].getA()},
		        				{simulador.mult[1].getName(), simulador.mult[1].getBussy(), simulador.mult[1].getOp(), simulador.mult[1].getVj(), simulador.mult[1].getVk(), simulador.mult[1].getQj(), simulador.mult[1].getQk(), simulador.mult[1].getA()},
		        				null,
		        				null,
		        				null,
		        			},
		        			new String[] {
		        				"Name", "Bussy", "Op", "Vj", "Vk", "Qj", "Qk", "A"
		        			}
		        		));
					
					table3.setModel(new DefaultTableModel(
		        			new Object[][] { 
		        				{simulador.registradores.getF0(), simulador.registradores.getF4(), simulador.registradores.getF6(), simulador.registradores.getF8(), 
		        					simulador.registradores.getF10(), simulador.registradores.getF12(), simulador.registradores.getF14(), simulador.registradores.getF16()},
		        			},
		        			new String[] {
		        				"Field", "F0", "F2", "F4", "F6", "F8", "F10", "F12", "F14", "F16"
		        			}
		        		));
				}
			}
		});
		
		JButton buttonNext = new JButton("Next");
		buttonNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atualizarTabela1();
			}
		});
		
		JButton buttonFinish = new JButton("Finish");
		buttonFinish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GroupLayout groupLayout = new GroupLayout(janela.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(buttonFile)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(buttonNext)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(buttonFinish))
						.addComponent(panel1, GroupLayout.DEFAULT_SIZE, 866, Short.MAX_VALUE)
						.addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 866, Short.MAX_VALUE)
						.addComponent(panel2, GroupLayout.DEFAULT_SIZE, 866, Short.MAX_VALUE)
						.addComponent(scrollPane2, GroupLayout.DEFAULT_SIZE, 866, Short.MAX_VALUE)
						.addComponent(panel3, GroupLayout.DEFAULT_SIZE, 866, Short.MAX_VALUE)
						.addComponent(scrollPane3, GroupLayout.DEFAULT_SIZE, 866, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel1, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel2, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel3, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane3, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
					.addGap(20)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(buttonFile, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(buttonNext, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
							.addComponent(buttonFinish, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		table3 = new JTable();
		table3.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		table3.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"Field", "F0", "F2", "F4", "F6", "F8", "F10", "F12", "F14", "F16"
			}
		));
		scrollPane3.setViewportView(table3);
		
		table2 = new JTable();
		table2.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		table2.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
			},
			new String[] {
				"Name", "Bussy", "Op", "Vj", "Vk", "Qj", "Qk", "A"
			}
		));
		scrollPane2.setViewportView(table2);
		
		table1 = new JTable();
		table1.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		table1.setModel(new DefaultTableModel(
			new Object[][] {
				{"", null, null, null},
				{"", null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"Instruction", "Issue", "Execute", "Write result"
			}
		));
		scrollPane1.setViewportView(table1);
		panel1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Instruction status");
		lblNewLabel.setBounds(386, 10, 124, 20);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		panel1.add(lblNewLabel);
		janela.getContentPane().setLayout(groupLayout);
	}
	
	public void atualizarTabela1() {
		for(int i = 0; i < simulador.carregarTabela1.length; i++) {
			table1.setValueAt("", i, 1);
		}
	}
}
