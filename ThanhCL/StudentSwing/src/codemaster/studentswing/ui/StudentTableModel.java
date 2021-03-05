package codemaster.studentswing.ui;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import codemaster.studentswing.business.Student;
import codemaster.studentswing.database.StudentDB;

@SuppressWarnings("serial")
public class StudentTableModel extends AbstractTableModel {
    private List<Student> students;
    private final String[] COLUMN_NAMES = { "Code", "Description", "Price" };
 
    public StudentTableModel() {
        try {
        	students = StudentDB.getAll();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    @Override
    public int getRowCount() {
        return students.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMN_NAMES.length;
    }
    
    @Override
    public String getColumnName(int columnIndex) {
        return COLUMN_NAMES[columnIndex];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return students.get(rowIndex).getId();
            case 1:
                return students.get(rowIndex).getFirstName() + " " + students.get(rowIndex).getLastName();
            case 2:
                return students.get(rowIndex).getAge();
            default:
                return null;
        }
    }   
    
    Student getStudent(int rowIndex) {
        return students.get(rowIndex);
    }
    
    void databaseUpdated() {
        try {
        	students = StudentDB.getAll();
            fireTableDataChanged();
        } catch (Exception e) {
            System.out.println(e);
        }        
    }    
}