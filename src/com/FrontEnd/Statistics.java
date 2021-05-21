package com.FrontEnd;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import com.dao.StatisticsDAOImpl;

import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;

public class Statistics extends JFrame {

	private JPanel contentPane;
	private JTextField lec;
	private JTextField group;
	private JTextField subject;
	private JPanel panel_chart;
	private JButton btn_chart;
	ChartFrame chartfrm;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Statistics frame = new Statistics();
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
	public Statistics() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 883, 745);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel_chart = new JPanel();
		panel_chart.setBounds(63, 262, 549, 409);

		panel_chart.setLayout(null);
		
		JPanel showChart = new JPanel();
		showChart.setBounds(10, 37, 529, 303);
		panel_chart.add(showChart);
		showChart.setLayout(new BorderLayout(0, 0));
		
		StatisticsDAOImpl object = new StatisticsDAOImpl();
		JTextPane count1 = new JTextPane();
		count1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		count1.setText(String.valueOf(object.registeredCount("employee_details")));
		count1.setBounds(107, 87, 118, 100);
		contentPane.add(count1);
		
		
		JTextPane count3 = new JTextPane();
		count3.setFont(new Font("Tahoma", Font.PLAIN, 30));
		count3.setText(String.valueOf(object.registeredCount("subject_details")));
		count3.setBounds(524, 87, 110, 100);
		contentPane.add(count3);
		
		JTextPane count4 = new JTextPane();
		count4.setFont(new Font("Tahoma", Font.PLAIN, 30));
		count4.setText(String.valueOf(object.registeredCount("location")));
		count4.setBounds(739, 87, 93, 100);
		contentPane.add(count4);
		

		JTextPane count2 = new JTextPane();
		count2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		count2.setText("5");
		count2.setBounds(317, 87, 99, 100);
		contentPane.add(count2);
		
		JLabel lblNewLabel = new JLabel("Lecture");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(641, 403, 74, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Group");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(633, 512, 45, 19);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Subject");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(633, 589, 57, 29);
		contentPane.add(lblNewLabel_2);
		
		lec = new JTextField();
		lec.setText(object.latestRecord("employee_details"));
		lec.setBounds(725, 402, 134, 19);
		contentPane.add(lec);
		lec.setColumns(10);
		
		group = new JTextField();
		group.setBounds(736, 514, 96, 19);
		contentPane.add(group);
		group.setColumns(10);
		
		subject = new JTextField();
		subject.setBounds(708, 586, 151, 19);
		subject.setText(object.latestRecord("subject_details"));
		contentPane.add(subject);
		subject.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Register Lecture");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(130, 219, 110, 13);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Register Student");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(339, 221, 118, 13);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Register Subject");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(541, 219, 119, 13);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Register Location");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_6.setBounds(739, 219, 120, 13);
		contentPane.add(lblNewLabel_6);
		
		
		contentPane.add(panel_chart);
		
		JButton btn_chart = new JButton("Chart\r\n");
		btn_chart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DefaultCategoryDataset data = new DefaultCategoryDataset() ;
				StatisticsDAOImpl stat = new StatisticsDAOImpl();
		
				int lecHallCount = stat.getRoom("LectureHall");
				int labCount = stat.getRoom("Laboraltory");
				data.setValue( lecHallCount , "Locations", "Lecture Hall");
			data.setValue( labCount, "Locations", "Lab");
				//data.setValue( 120, "Locations", "Lab");
	
				JFreeChart jcharts = ChartFactory.createBarChart3D("", "Location", "Frequency", data ,PlotOrientation.VERTICAL,true,true,false);
	
				CategoryPlot plot = jcharts.getCategoryPlot();
				plot.setRangeGridlinePaint(Color.BLACK);
		
				chartfrm = new ChartFrame("student record" , jcharts,true);
				
				ChartPanel chartpanel = new ChartPanel(jcharts);

				showChart.removeAll();
				showChart.add(chartpanel);
				showChart.updateUI();
			}
		});
		btn_chart.setBounds(26, 364, 85, 21);
		panel_chart.add(btn_chart);
		

		
	}
}
