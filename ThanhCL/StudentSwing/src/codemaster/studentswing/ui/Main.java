package codemaster.studentswing.ui;

import codemaster.studentswing.database.StudentDB;

public class Main {

    @SuppressWarnings("unused")
	public static void main(String[] args) {
    	StudentDB.init();
    	
        StudentManagerFrame frame = new StudentManagerFrame();
    }
}