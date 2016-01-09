package nl.hu.fnt.gsos.wsconsumer;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.FlowLayout;

import javax.swing.JTextField;
import javax.swing.JButton;

import nl.hu.fnt.gsos.wsinterface.MorseService;
import nl.hu.fnt.gsos.wsinterface.MorseServiceDecodeRequest;
import nl.hu.fnt.gsos.wsinterface.MorseServiceEncodeRequest;
import nl.hu.fnt.gsos.wsinterface.MorseServiceFaultMessage;
import nl.hu.fnt.gsos.wsinterface.MorseServiceHeader;
import nl.hu.fnt.gsos.wsinterface.MorseServiceResponse;
import nl.hu.fnt.gsos.wsinterface.WSInterface;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MorseCodeGUI extends JFrame {
	
	
	MorseService morseService = new MorseService();
	WSInterface portInterface = morseService.getWSPort();
	MorseServiceHeader header = new MorseServiceHeader();
	
	private JPanel contentPane;
	private JTextField encodeValue;
	private JTextField seperatorValue;
	private JTextField encodedResult;
	private JTextField decodeValue;
	private JTextField decodedValue;
	private JTextField zipCodeValue;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MorseCodeGUI frame = new MorseCodeGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MorseCodeGUI() {
		setTitle("MorseCodeGUI");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 518, 384);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel encodeValuelab = new JLabel("Please enter encode value");
		encodeValuelab.setBounds(10, 55, 270, 36);
		contentPane.add(encodeValuelab);
		
		encodeValue = new JTextField();
		encodeValue.setBounds(190, 62, 206, 20);
		contentPane.add(encodeValue);
		encodeValue.setColumns(10);
		
		JLabel seperatorLab = new JLabel("Please enter seperator value");
		seperatorLab.setBounds(10, 211, 170, 14);
		contentPane.add(seperatorLab);
		
		seperatorValue = new JTextField();
		seperatorValue.setBounds(190, 208, 32, 20);
		contentPane.add(seperatorValue);
		seperatorValue.setColumns(10);
		
		JLabel lblEncodedResult = new JLabel("Encoded result");
		lblEncodedResult.setBounds(10, 132, 190, 14);
		contentPane.add(lblEncodedResult);
		
		encodedResult = new JTextField();
		encodedResult.setEditable(false);
		encodedResult.setBounds(190, 129, 216, 20);
		contentPane.add(encodedResult);
		encodedResult.setColumns(10);
		
		JButton encodeButton = new JButton("Encode");
		encodeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					header.setPostCode(zipCodeValue.getText());
					MorseServiceEncodeRequest request = new MorseServiceEncodeRequest();
					//request.setSetSeperator("k");
					request.setMorseCodeSequence(encodeValue.getText());
					MorseServiceResponse resp = portInterface.encodeMorseCode(header, request);
					encodedResult.setText(resp.getMorseCodeResult());
				} catch (MorseServiceFaultMessage ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
				}
				
				
			}
		});
		encodeButton.setBounds(190, 95, 89, 23);
		contentPane.add(encodeButton);
		
		JLabel decodeValuelab = new JLabel("Please enter decode value");
		decodeValuelab.setBounds(10, 157, 190, 32);
		contentPane.add(decodeValuelab);
		
		decodeValue = new JTextField();
		decodeValue.setColumns(10);
		decodeValue.setBounds(190, 165, 216, 20);
		contentPane.add(decodeValue);
		
		JLabel DecodedResultlab = new JLabel("Decoded result");
		DecodedResultlab.setBounds(10, 276, 170, 17);
		contentPane.add(DecodedResultlab);
		
		decodedValue = new JTextField();
		decodedValue.setBounds(190, 273, 216, 20);
		contentPane.add(decodedValue);
		decodedValue.setColumns(10);
		
		JButton decodeButton = new JButton("Decode");
		decodeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					header.setPostCode(zipCodeValue.getText());
					
					MorseServiceDecodeRequest request = new MorseServiceDecodeRequest();
					request.setSeparator(seperatorValue.getText());
					request.setMorseCodeSequence(decodeValue.getText());
					MorseServiceResponse resp = portInterface.decodeMorseCode(header, request);
				    decodedValue.setText(resp.getMorseCodeResult());
					
				} catch (MorseServiceFaultMessage ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());

				}
			}
		});
		decodeButton.setBounds(190, 239, 89, 23);
		contentPane.add(decodeButton);
		
		JLabel zipCodeLabel = new JLabel("Please enter zipcode");
		zipCodeLabel.setBounds(10, 30, 130, 14);
		contentPane.add(zipCodeLabel);
		
		zipCodeValue = new JTextField();
		zipCodeValue.setBounds(190, 27, 112, 20);
		contentPane.add(zipCodeValue);
		zipCodeValue.setColumns(10);
	}
}
