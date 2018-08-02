package snippet;

public class Snippet {
	JPanel pnBorder=new JPanel();
	pnBorder.setLayout(new BorderLayout());
	JPanel pnNorth=new JPanel();
	pnNorth.setBackground(Color.RED);
	pnBorder.add(pnNorth,BorderLayout.NORTH);
	JPanel pnSouth=new JPanel();
	pnSouth.setBackground(Color.RED);
	pnBorder.add(pnSouth,BorderLayout.SOUTH);
	JPanel pnWest=new JPanel();
	pnWest.setBackground(Color.BLUE);
	pnBorder.add(pnWest,BorderLayout.WEST);
	JPanel pnEast=new JPanel();
	pnEast.setBackground(Color.BLUE);
	pnBorder.add(pnEast,BorderLayout.EAST);
	JPanel pnCenter=new JPanel();
	pnCenter.setBackground(Color.YELLOW);
	pnBorder.add(pnCenter,BorderLayout.CENTER);
	
}

