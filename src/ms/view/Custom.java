package ms.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;

public class Custom extends JFrame {

	private JPanel contentPane;
	private JTextField jt_height;
	private JTextField jt_width;
	private JTextField jt_mines;
	
	public Custom() {
		setTitle("Custom");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 284, 151);
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(3, 3, 15, 15));
		
		JLabel lb_height = new JLabel("Height:");
		contentPane.add(lb_height);
		
		jt_height = new JTextField();
		contentPane.add(jt_height);
		jt_height.setColumns(10);
		
		JButton bt_OK = new JButton("OK");
		
		bt_OK.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int h = Integer.valueOf(jt_height.getText());
				int w = Integer.valueOf(jt_width.getText());
				int m = Integer.valueOf(jt_mines.getText());
				if(h>=6 && w>=6 && m>=3) {
					setVisible(false);
					new MSDisplay(w, h, m);
				}else {
					JOptionPane.showMessageDialog(null,
			                "Xin vui lòng nhập chiều cao\n"
			                + " và chiều dài lớn hơn 5 (>5)\n"
			                + "  số mìn lớn hơn 2 (>2)",
			                "Error",
			                JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		contentPane.add(bt_OK);
		
		JLabel lb_width = new JLabel("Width:");
		contentPane.add(lb_width);
		
		jt_width = new JTextField();
		contentPane.add(jt_width);
		jt_width.setColumns(10);
		
		JButton bt_cancel = new JButton("Cancel");
		bt_cancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new MSDisplay(9, 9, 10);
				dispose();
			}
		});
		contentPane.add(bt_cancel);
		
		JLabel jl_mines = new JLabel("Mines:");
		contentPane.add(jl_mines);
		
		jt_mines = new JTextField();
		contentPane.add(jt_mines);
		jt_mines.setColumns(10);
		
		JLabel NULL = new JLabel("");
		contentPane.add(NULL);
		setVisible(true);
	}

}
