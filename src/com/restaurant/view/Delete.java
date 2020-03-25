package com.restaurant.view;

import org.jvnet.substance.SubstanceLookAndFeel;
import org.jvnet.substance.skin.DustCoffeeSkin;
import org.jvnet.substance.skin.SubstanceDustCoffeeLookAndFeel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Delete extends JFrame {

    Connection coon = null;
    PreparedStatement st;
    public static final String driver = "com.mysql.jdbc.Driver";
    public static final String url = "jdbc:mysql://localhost:3306/mydb";
    public static final String user = "root";
    public static final String password = "1492949670";
    String sql = "delete from menu where 菜名 = ?";
    private JPanel contentPane;
    private JTextField textField;
    /**
     * Create the frame.
     */
    public Delete() {
        Toolkit kit=Toolkit.getDefaultToolkit();
        Image img=kit.getImage("E:\\Java\\Idea\\myproject\\image\\鼠标2.jpg");
        Cursor mouse=kit.createCustomCursor(img, new Point(1,1), "stick");
        this.setCursor(mouse);
        try {
            UIManager.setLookAndFeel(new SubstanceDustCoffeeLookAndFeel());
            JFrame.setDefaultLookAndFeelDecorated(true);
            SubstanceLookAndFeel.setSkin(new DustCoffeeSkin());
        } catch (Exception e) {
            e.printStackTrace();
        }
        setTitle("删除菜品");
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        int width = Toolkit.getDefaultToolkit().getScreenSize().width;
        int height = Toolkit.getDefaultToolkit().getScreenSize().height;
        int windowsWedth = 450;
        int windowsHeight = 240;
        setBounds((width-windowsWedth)/2,(height-windowsHeight)/2,windowsWedth,windowsHeight);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.setBackground(SystemColor.activeCaption);

        JLabel lblNewLabel = new JLabel("请输入要删除的菜品");
        lblNewLabel.setFont(new Font("楷体", Font.BOLD, 16));
        lblNewLabel.setBounds(34, 61, 178, 33);
        contentPane.add(lblNewLabel);

        textField = new JTextField();
        textField.setBounds(250, 61, 115, 26);
        contentPane.add(textField);
        textField.setColumns(10);

        JButton btnNewButton = new JButton("确认");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                String name = textField.getText();
                try {
                    Class.forName(driver);
                    coon = DriverManager.getConnection(url,user,password);
                    st = coon.prepareStatement(sql);
                    st.setString(1, name);
                    st.execute();
                    JOptionPane.showMessageDialog(null,"删除成功！","提示",1);
                    textField.setText(" ");
                }catch(ClassNotFoundException e) {
                    e.printStackTrace();
                }catch (SQLException e) {
                    e.printStackTrace();
                }
                if (null != coon) {
                    try {
                        coon.close();
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null,"关闭数据库失败！","提示",1);
                        e.printStackTrace();
                    }
                }
            }

        });
        btnNewButton.setFont(new Font("楷体", Font.BOLD, 16));
        btnNewButton.setBounds(64, 151, 93, 23);
        contentPane.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("重置");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textField.setText(" ");
            }
        });
        btnNewButton_1.setFont(new Font("楷体", Font.BOLD, 16));
        btnNewButton_1.setBounds(272, 151, 93, 23);
        contentPane.add(btnNewButton_1);
    }
}
