package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controller.PersonController;

public class PersonDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField tfdName;
	private JTextField tfdAddress;
	private JTextField tfdPhone;
	private PersonController personController;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			PersonDialog dialog = new PersonDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public PersonDialog() {
		initialize();
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel northPanel = new JPanel();
			FlowLayout flowLayout = (FlowLayout) northPanel.getLayout();
			flowLayout.setAlignment(FlowLayout.LEFT);
			contentPanel.add(northPanel, BorderLayout.NORTH);
			{
				JLabel lblPersonData = new JLabel("Person data:");
				lblPersonData.setFont(new Font("Tahoma", Font.PLAIN, 16));
				northPanel.add(lblPersonData);
			}
		}
		{
			JPanel centerPanel = new JPanel();
			contentPanel.add(centerPanel, BorderLayout.CENTER);
			GridBagLayout gbl_centerPanel = new GridBagLayout();
			gbl_centerPanel.columnWidths = new int[]{0, 0, 0, 0};
			gbl_centerPanel.rowHeights = new int[]{0, 0, 0, 0, 0};
			gbl_centerPanel.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
			gbl_centerPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			centerPanel.setLayout(gbl_centerPanel);
			{
				JLabel lblName = new JLabel("Name");
				lblName.setHorizontalAlignment(SwingConstants.LEFT);
				GridBagConstraints gbc_lblName = new GridBagConstraints();
				gbc_lblName.insets = new Insets(0, 0, 5, 5);
				gbc_lblName.gridx = 1;
				gbc_lblName.gridy = 1;
				centerPanel.add(lblName, gbc_lblName);
			}
			{
				tfdName = new JTextField();
				GridBagConstraints gbc_tfdName = new GridBagConstraints();
				gbc_tfdName.insets = new Insets(0, 0, 5, 0);
				gbc_tfdName.fill = GridBagConstraints.HORIZONTAL;
				gbc_tfdName.gridx = 2;
				gbc_tfdName.gridy = 1;
				centerPanel.add(tfdName, gbc_tfdName);
				tfdName.setColumns(10);
			}
			{
				JLabel lblAddress = new JLabel("Address");
				lblAddress.setHorizontalAlignment(SwingConstants.LEFT);
				GridBagConstraints gbc_lblAddress = new GridBagConstraints();
				gbc_lblAddress.insets = new Insets(0, 0, 5, 5);
				gbc_lblAddress.gridx = 1;
				gbc_lblAddress.gridy = 2;
				centerPanel.add(lblAddress, gbc_lblAddress);
			}
			{
				tfdAddress = new JTextField();
				GridBagConstraints gbc_tfdAddress = new GridBagConstraints();
				gbc_tfdAddress.insets = new Insets(0, 0, 5, 0);
				gbc_tfdAddress.fill = GridBagConstraints.HORIZONTAL;
				gbc_tfdAddress.gridx = 2;
				gbc_tfdAddress.gridy = 2;
				centerPanel.add(tfdAddress, gbc_tfdAddress);
				tfdAddress.setColumns(10);
			}
			{
				JLabel lblPhone = new JLabel("Phone");
				lblPhone.setHorizontalAlignment(SwingConstants.LEFT);
				GridBagConstraints gbc_lblPhone = new GridBagConstraints();
				gbc_lblPhone.insets = new Insets(0, 0, 0, 5);
				gbc_lblPhone.gridx = 1;
				gbc_lblPhone.gridy = 3;
				centerPanel.add(lblPhone, gbc_lblPhone);
			}
			{
				tfdPhone = new JTextField();
				GridBagConstraints gbc_tfdPhone = new GridBagConstraints();
				gbc_tfdPhone.fill = GridBagConstraints.HORIZONTAL;
				gbc_tfdPhone.gridx = 2;
				gbc_tfdPhone.gridy = 3;
				centerPanel.add(tfdPhone, gbc_tfdPhone);
				tfdPhone.setColumns(10);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton addButton = new JButton("Add");
				addButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						addPersonClicked();
					}
				});
				buttonPane.add(addButton);
				getRootPane().setDefaultButton(addButton);
			}
			{
				JButton closeButton = new JButton("Close");
				closeButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						closeButtonClicked();
					}
				});
				closeButton.setActionCommand("Cancel");
				buttonPane.add(closeButton);
			}
		}
	}

	private void closeButtonClicked() {
		dispose();
		setVisible(false);
		
	}

	private void initialize() {
		personController = new PersonController();
		
	}

	private void addPersonClicked() {
		String name = tfdName.getText();
		String address = tfdAddress.getText();
		String phone = tfdPhone.getText();
		personController.addPerson(name, address, phone);
		tfdName.setText("");
		tfdAddress.setText("");
		tfdPhone.setText("");
	}

}
