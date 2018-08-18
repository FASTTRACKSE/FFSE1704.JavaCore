/**
 * Quản lý máy ATM tại Thành Phố Đà Nẵng
 * @author: Phan Phạm Quang Dai
 * Date: 24/07/2018
 */
package fasttrackse.quanlymayatm.giaodich.ui;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

/**
 * @author QuangDai
 *
 */
public class BaoCaoTinhTrangRutTienKhachHangUI extends JPanel {
	JLabel JLabelMaKH = new JLabel("Mã Khách Hàng: ");
	
	JTextField MaKH = new JTextField(20);
			
	JComboBox Quan = new JComboBox<>(), Phuong = new JComboBox<>();
	
	JPanel pnMain = new JPanel();
				
	JButton CapNhapButton = new JButton("Cập Nhập");
	
	DefaultTableModel DSGDKhachhangtable = new DefaultTableModel();
	JTable tableDSGDKhachHang;
	
	public BaoCaoTinhTrangRutTienKhachHangUI () {
		// Phần hiển thị thông tin máy
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.X_AXIS));
		// Phần danh sách máy trong JPanel Thông Tin
		pnMain.setBorder(BorderFactory.createRaisedBevelBorder());	
		pnMain.setLayout(new GridBagLayout());
		// add Label vào pnDSMay
		addItem(pnMain, JLabelMaKH, 0, 0, 1, 1, GridBagConstraints.WEST);
		// add ComboBox vào pnDSMay
		addItem(pnMain, MaKH, 1, 0, 1, 1, GridBagConstraints.WEST);
		// JTable danh sách khách hàng
		DSGDKhachhangtable.addColumn("Mã Máy");
		DSGDKhachhangtable.addColumn("Mã Giao Dịch");
		DSGDKhachhangtable.addColumn("Mã Thẻ");
		DSGDKhachhangtable.addColumn("Thời Gian");
		DSGDKhachhangtable.addColumn("Số Tiền");
		//this.getTable();
		tableDSGDKhachHang = new JTable(DSGDKhachhangtable);
		JScrollPane pnDanhSachGDKhachHang = new JScrollPane(tableDSGDKhachHang);

		addItem(pnMain, pnDanhSachGDKhachHang, 0, 2, 2, 1, GridBagConstraints.WEST);
		// Tạo đường viền bao danh sách khach hang
		Border borderDSGD = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitleDSGD = BorderFactory.createTitledBorder(borderDSGD, "Danh Sách Giao Dich");
		pnMain.setBorder(borderTitleDSGD);				
		//
		this.add(pnMain);
	}
	
	private void addItem(JPanel p, JComponent c, int x, int y, int width, int height, int align) {
	    GridBagConstraints gc = new GridBagConstraints();
	    gc.gridx = x;
	    gc.gridy = y;
	    gc.gridwidth = width;
	    gc.gridheight = height;
	    gc.insets = new Insets(5,30, 10, 10);
	    gc.anchor = align;
	    gc.fill = GridBagConstraints.NONE;
	    p.add(c, gc);
	}
}
