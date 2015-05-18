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
	
	private JLabel banner = new JLabel("XXX�ļ�����ϵͳ", JLabel.CENTER);
	private JLabel welcomeword = new JLabel("��ӭʹ��XX�ļ�����ϵͳ", JLabel.CENTER);
	private JButton upfilebutton = new JButton("�ϴ��ļ�");
	private JButton checkfilebutton = new JButton("�鿴�ļ�");
	
	private JPanel containsAll = new JPanel(); //����Ĳ���,����banner,���,�ұߵĿ�Ƭ����
	private JPanel leftoperation = new JPanel(); //��ߵĲ�������
	private JPanel cardPanel = new JPanel();  //��Ƭ���ֵ�����,װ��5������
	
	private Border lineBorder = new LineBorder(Color.BLACK, 1);//���ñ߿�
	
	private final String DISPLAYWELCOME = "welcome";  //��Ƭ�����ı�־
	
	public ClientUI2() {
		
		//����������ʽ
		banner.setFont(new Font("Dialog", 1, 50));
		welcomeword.setFont(new Font("Dialog", 1, 30));
		
		
		//���ñ߿�
		leftoperation.setBorder(lineBorder);
		cardPanel.setBorder(lineBorder);
		banner.setBorder(new TitledBorder("by_wwq"));
		
		//����ߵ�����������ʽ
		leftoperation.setPreferredSize(new Dimension(100,450));
		leftoperation.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 40));
		upfilebutton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		checkfilebutton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		//����߼������
		leftoperation.add(upfilebutton);
		leftoperation.add(checkfilebutton);
		
		//����Ƭ����������ʽ
		cardPanel.setLayout(new CardLayout());
		cardPanel.setPreferredSize(new Dimension(630,450));
		
		//����Ƭ�����������
		cardPanel.add(DISPLAYWELCOME,welcomeword); 
		
		
		//�������������Ĳ���,���Ҽ���ͷ��,�󲿺���������
		containsAll.setLayout(new BorderLayout());
		containsAll.add(banner, BorderLayout.NORTH);
		containsAll.add(leftoperation, BorderLayout.WEST);
		containsAll.add(cardPanel, BorderLayout.EAST);
		
		
		
		
		this.add(containsAll);
		this.setTitle("�ļ��ϴ������");
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
