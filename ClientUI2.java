package cn.hstc.wwq.client.view;


import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class ClientUI2 extends JFrame {
	
	private JLabel banner = new JLabel("XXX文件管理系统", JLabel.CENTER);
	private JLabel welcomeword = new JLabel("欢迎使用XX文件管理系统", JLabel.CENTER);
	private JButton upfilebutton = new JButton("上传文件");
	private JButton checkfilebutton = new JButton("查看文件");
	
	private JPanel containsAll = new JPanel(); //总体的布局,包括banner,左边,右边的卡片布局
	private JPanel leftoperation = new JPanel(); //左边的操作布局
	private JPanel cardPanel = new JPanel();  //卡片布局的容器,装入5个界面
	
	private Border lineBorder = new LineBorder(Color.BLACK, 1);//设置边框
	
	private final String DISPLAYWELCOME = "welcome";  //卡片容器的标志
	
	public ClientUI2() {
		
		//设置字体样式
		banner.setFont(new Font("Dialog", 1, 50));
		welcomeword.setFont(new Font("Dialog", 1, 30));
		
		
		//设置边框
		leftoperation.setBorder(lineBorder);
		cardPanel.setBorder(lineBorder);
		banner.setBorder(new TitledBorder("by_wwq"));
		
		//给左边的内容设置样式
		leftoperation.setPreferredSize(new Dimension(100,450));
		leftoperation.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 40));
		upfilebutton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		checkfilebutton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		//给左边加入组件
		leftoperation.add(upfilebutton);
		leftoperation.add(checkfilebutton);
		
		//给卡片容器设置样式
		cardPanel.setLayout(new CardLayout());
		cardPanel.setPreferredSize(new Dimension(630,450));
		
		//往卡片容器加入组件
		cardPanel.add(DISPLAYWELCOME,welcomeword); 
		
		
		//设置总体容器的布局,并且加入头部,左部和主体内容
		containsAll.setLayout(new BorderLayout());
		containsAll.add(banner, BorderLayout.NORTH);
		containsAll.add(leftoperation, BorderLayout.WEST);
		containsAll.add(cardPanel, BorderLayout.EAST);
		
		
		
		
		this.add(containsAll);
		this.setTitle("文件上传与管理");
		this.setSize(750, 610);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}
	
	public JPanel createWordPage(JLabel wordlabel) {
		JPanel displaypage = new JPanel();
		displaypage.add(wordlabel);
		return displaypage;
	}
	
	
	
	
	public static void main(String[] args) {
		ClientUI2 ui = new ClientUI2();
	}
	
}
