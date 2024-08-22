package gui;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Person;

public class PersonTableModel extends AbstractTableModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Person> data;
	private static final String[] COL_NAMES = {"Name", "Address", "Phone"};
	
	public PersonTableModel(Person person) {
		data = new ArrayList<>();
		data.add(person);
	}

	@Override
	public String getColumnName(int column) {
		return COL_NAMES[column];
	}

	@Override
	public int getRowCount() {
		return data.size();
	}
	
	

	@Override
	public int getColumnCount() {
		return COL_NAMES.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Person person = data.get(rowIndex);
		String res = "";
		switch (columnIndex) {
		case 0:
			res = person.getName();
			break;
		case 1:
			res = person.getAddress();
			break;
		case 2: 
			res = person.getPhone();
			break;
		default:
			res = "UNKOWN";
		}
		return res;
	}

}
