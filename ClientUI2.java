package cn.hstc.wwq.client.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class ClientUI2 extends JFrame {

	private JLabel banner = new JLabel("XXX�ļ�����ϵͳ", JLabel.CENTER);
	private JLabel welcomeword = new JLabel("��ӭʹ��XX�ļ�����ϵͳ", JLabel.CENTER);
	private JButton upfilebutton = new JButton("�ϴ��ļ�");
	private JButton checkfilebutton = new JButton("�鿴�ļ�");

	private JLabel successupload = new JLabel("�ϴ��ɹ�!!!", JLabel.CENTER);
	private JLabel failupload = new JLabel("�ϴ�ʧ��!!!", JLabel.CENTER);

	private JLabel successchange = new JLabel("�޸ĳɹ�!!!", JLabel.CENTER);
	private JLabel failchange = new JLabel("�޸�ʧ��!!!", JLabel.CENTER);

	private JLabel successdelete = new JLabel("ɾ���ɹ�!!!", JLabel.CENTER);
	private JLabel faildelete = new JLabel("ɾ��ʧ��!!!", JLabel.CENTER);

	private JPanel containsAll = new JPanel(); // ����Ĳ���,����banner,���,�ұߵĿ�Ƭ����
	private JPanel leftoperation = new JPanel(); // ��ߵĲ�������
	private JPanel cardPanel = new JPanel(); // ��Ƭ���ֵ�����,װ��5������

	private Border lineBorder = new LineBorder(Color.BLACK, 1);// ���ñ߿�

	private CardLayout card = new CardLayout();

	private static final String DISPLAYWELCOME = "welcome"; // ��Ƭ�����ı�־
	private static final String UPFILE = "upfile";
	private static final String FileList = "filelist";
	private static final String CHANGEFILE = "changefile";
	private static final String SUCCESSUPLOAD = "successupload";
	private static final String FAILUPLOAD = "failupload";
	private static final String SUCCESSCHANGE = "successchange";
	private static final String FAILCHANGE = "failchange";
	private static final String SUCCESSDELETE = "successdelete";
	private static final String FAILDELETE = "faildelete";

	private String filepath = "";

	// �ļ��ϴ���Ҫ�����
	private JLabel userNameLabel = new JLabel("�ϴ��û�");
	private JTextField userNameInput = new JTextField(10);
	private JLabel bank = new JLabel("      ");
	private JButton uploadButton = new JButton("�ϴ��ļ�");
	private JLabel descriptionLabel = new JLabel("�ļ�����");
	private JTextArea descriptionjtext = new JTextArea(8, 30);
	private JButton submitButton = new JButton("�ύ");

	public ClientUI2() {

		// ����������ʽ
		banner.setFont(new Font("Dialog", 1, 50));
		welcomeword.setFont(new Font("Dialog", 1, 30));
		successupload.setFont(new Font("Dialog", 1, 50));
		failupload.setFont(new Font("Dialog", 1, 50));

		successchange.setFont(new Font("Dialog", 1, 50));
		failchange.setFont(new Font("Dialog", 1, 50));

		successdelete.setFont(new Font("Dialog", 1, 50));
		faildelete.setFont(new Font("Dialog", 1, 50));

		// ���ñ߿�
		leftoperation.setBorder(lineBorder);
		cardPanel.setBorder(lineBorder);
		banner.setBorder(new TitledBorder("by_wwq"));

		// ����ߵ�����������ʽ
		leftoperation.setPreferredSize(new Dimension(100, 450));
		leftoperation.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 40));
		upfilebutton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		checkfilebutton.setCursor(Cursor
				.getPredefinedCursor(Cursor.HAND_CURSOR));
		// ����߼������
		leftoperation.add(upfilebutton);
		leftoperation.add(checkfilebutton);

		// �ļ��ϴ�ҳ��
		JPanel upfilejpanel = new JPanel();
		JPanel p_file = new JPanel(new FlowLayout(FlowLayout.LEFT, 80, 50));
		p_file.setPreferredSize(new Dimension(600, 400));
		uploadButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		submitButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		p_file.add(userNameLabel);
		p_file.add(userNameInput);
		p_file.add(uploadButton);
		p_file.add(bank);
		p_file.add(descriptionLabel);
		p_file.add(descriptionjtext);
		p_file.add(submitButton);
		upfilejpanel.add(p_file);

		// �޸��ļ���Ϣ
		// JPanel changefilejpanel = new JPanel();
		// changefilejpanel.add(p_file);

		// ����Ƭ����������ʽ
		cardPanel.setLayout(card);
		cardPanel.setPreferredSize(new Dimension(630, 450));

		// ����Ƭ�����������
		cardPanel.add(this.DISPLAYWELCOME, welcomeword);
		cardPanel.add(this.UPFILE, upfilejpanel);
		cardPanel.add(this.SUCCESSUPLOAD, successupload);
		cardPanel.add(this.FAILUPLOAD, failupload);
		// cardPanel.add(this.FileList, );
		// cardPanel.add(this.CHANGEFILE, );
		cardPanel.add(this.SUCCESSCHANGE, successchange);
		cardPanel.add(this.FAILCHANGE, failchange);
		cardPanel.add(this.SUCCESSDELETE, successdelete);
		cardPanel.add(this.FAILDELETE, faildelete);

		// �������������Ĳ���,���Ҽ���ͷ��,�󲿺���������
		containsAll.setLayout(new BorderLayout());
		containsAll.add(banner, BorderLayout.NORTH);
		containsAll.add(leftoperation, BorderLayout.WEST);
		containsAll.add(cardPanel, BorderLayout.EAST);

		// ע�������
		upfilebutton.addActionListener(new ClickListener());
		uploadButton.addActionListener(new ClickListener());
		submitButton.addActionListener(new ClickListener());

		this.add(containsAll);
		this.setTitle("�ļ��ϴ������");
		this.setSize(750, 610);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);

	}

	// public JPanel createWordPage(JLabel wordlabel) {
	// JPanel displaypage = new JPanel();
	// displaypage.add(wordlabel);
	// return displaypage;
	// }

	public static void main(String[] args) {
		ClientUI2 ui = new ClientUI2();
	}

	class ClickListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == upfilebutton) {
				card.show(cardPanel, ClientUI2.UPFILE);
			}
			if (e.getSource() == uploadButton) {
				System.out.println("���ﴦ���ļ��ϴ�");

				JFileChooser fc = new JFileChooser();
				fc.setDialogTitle("��ѡ��Ҫ�ϴ����ļ�...");
				fc.setApproveButtonText("ȷ��");
				fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
				if (JFileChooser.APPROVE_OPTION == fc.showOpenDialog(cardPanel)) {
					filepath = fc.getSelectedFile().getPath();
					System.out.println(filepath);
				}
			}
			if (e.getSource() == submitButton) {
				try {
				String username = userNameInput.getText().trim();
				String description = descriptionjtext.getText();

				System.out.println(username);
				System.out.println(description);
				System.out.println(filepath);
				
				String url = "http://127.0.0.1:8080/fileoperation/servlet/UpfileServlet";
				httpfileupload(filepath, username, description, url);
				card.show(cardPanel, ClientUI2.SUCCESSUPLOAD);
				
				
				} catch(Exception ex) {
					ex.printStackTrace();
					card.show(cardPanel, ClientUI2.FAILUPLOAD);
					throw new RuntimeException(ex);
				}
			}
			if(e.getSource() == checkfilebutton) {
				
			}
			

		}
	}

	public void httpfileupload(String filepath, String username, String description, String url) {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		try {
			HttpPost httppost = new HttpPost(url);
			FileBody file = new FileBody(new File(filepath));

			HttpEntity reqEntity = MultipartEntityBuilder
					.create()
					.addPart("file", file)
					.addPart("username",new StringBody(username, Charset.forName("UTF-8")))
					.addPart("description",new StringBody(description, Charset.forName("UTF-8")))
					.build();

			httppost.setEntity(reqEntity);

			System.out
					.println("executing request " + httppost.getRequestLine());
			CloseableHttpResponse response = httpclient.execute(httppost);
			try {
				System.out.println("----------------------------------------");
				System.out.println(response.getStatusLine());
				HttpEntity resEntity = response.getEntity();
				if (resEntity != null) {
					System.out.println("Response content length: "
							+ resEntity.getContentLength());
				}
				EntityUtils.consume(resEntity);
			} finally {
				response.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		finally {
			try {
				httpclient.close();
			} catch (IOException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
	}

}
