package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controller.PersonController;
import model.Person;
import javax.swing.JTable;

public class PersonWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfdPhone;
	private PersonController personController;
	private JTable tblPerson;
	private PersonTableModel personTableModel;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PersonWindow frame = new PersonWindow();
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
	public PersonWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel southPanel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) southPanel.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		contentPane.add(southPanel, BorderLayout.SOUTH);
		
		JButton btnAddPerson = new JButton("Add Person");
		btnAddPerson.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				launchAddPersonWindow();
			}
		});
		btnAddPerson.setHorizontalAlignment(SwingConstants.RIGHT);
		southPanel.add(btnAddPerson);
		
		JPanel northPanel = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) northPanel.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		contentPane.add(northPanel, BorderLayout.NORTH);
		
		tfdPhone = new JTextField();
		northPanel.add(tfdPhone);
		tfdPhone.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchPersonClicked();
			}
		});
		northPanel.add(btnSearch);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		tblPerson = new JTable();
		scrollPane.setViewportView(tblPerson);
		
		initialize();
	}
	
	private void initialize() {
		personController = new PersonController();
		
	}

	private void searchPersonClicked() {
		String phone = tfdPhone.getText();
		Person person = personController.findPersonByPhone(phone);
		displayPerson(person);
		
	}

	private void launchAddPersonWindow() {
		// TODO Auto-generated method stub
		PersonDialog dialog = new PersonDialog();
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.setVisible(true);
		
	}
	
	private void displayPerson(Person person) {
		personTableModel = new PersonTableModel(person);
		tblPerson.setModel(personTableModel);

	}

}
