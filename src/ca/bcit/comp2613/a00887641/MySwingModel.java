package ca.bcit.comp2613.a00887641;

import javax.swing.table.DefaultTableModel;

public class MySwingModel extends DefaultTableModel {
	
	 @Override
	    public boolean isCellEditable(int row, int column) {
	       //all cells false
	       return false;
	    }
	
}
