package com.restaurant.view;

import com.restaurant.user.User;
import org.jvnet.substance.SubstanceLookAndFeel;
import org.jvnet.substance.skin.DustCoffeeSkin;
import org.jvnet.substance.skin.SubstanceDustCoffeeLookAndFeel;

import java.awt.*;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;
import java.awt.event.*;

class Menu extends JFrame{
    private JPanel jp1;
    private JTextField jt1,jt2,jt3;
    private JLabel jlb1,jlb2,jlb3,jlb4;
    private FileChooser fc;
    private JButton jb1,jb2,jb3;
    private String name,description,price,imagepath;
    private Insert insertList;

    public Menu(){
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

        //初始化按钮

        jp1 = new JPanel();
        jp1.setBackground(SystemColor.activeCaption);
        jp1.setBorder(new EmptyBorder(5,5,5,5));
        setContentPane(jp1);			//
        jp1.setLayout(null);

        jlb1 = new JLabel("菜名");
        jlb1.setFont(new Font("楷体",Font.PLAIN,18));
        jlb1.setBackground(SystemColor.activeCaption);
        jlb1.setBounds(65,42,47,32);
        jp1.add(jlb1);

        jlb2 = new JLabel("单价");
        jlb2.setFont(new Font("楷体",Font.PLAIN,18));
        jlb2.setBackground(SystemColor.activeCaption);
        jlb2.setBounds(65,92,54,32);
        jp1.add(jlb2);

        jlb3 = new JLabel("简介");
        jlb3.setFont(new Font("楷体",Font.PLAIN,18));
        jlb3.setBackground(SystemColor.activeCaption);
        jlb3.setBounds(65,142,47,37);
        jp1.add(jlb3);

        jlb4 = new JLabel("图片");
        jlb4.setFont(new Font("楷体",Font.PLAIN,18));
        jlb4.setBackground(SystemColor.activeCaption);
        jlb4.setBounds(65,192,47,32);
        jp1.add(jlb4);

        jt1 = new JTextField();
        jt1.setBounds(127,42,227,32);
        jt1.setColumns(20);
        jp1.add(jt1);

        jt2 = new JTextField();
        jt2.setBounds(127,92,227,32);
        jt2.setColumns(20);
        jp1.add(jt2);

        jt3 = new JTextField();
        jt3.setBounds(127,142,227,32);
        jt3.setColumns(20);
        jp1.add(jt3);

        jb1 = new JButton("文件选取");
        jb1.setFont(new Font("楷体",Font.BOLD,16));
        jb1.setBounds(127, 192,	227, 32);
        jb1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                FileChooser fc = new FileChooser();
            }
        });
        jp1.add(jb1);

        jb2 = new JButton("录入");
        jb2.setFont(new Font("楷体",Font.BOLD,16));
        jb2.setBounds(100, 270,	95, 25);
        jb2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                name = jt1.getText();
                price = jt2.getText();
                description = jt3.getText();
                imagepath = FileChooser.path;
                insertList = new Insert(name,price,description,imagepath);
                if(insertList!=null)
                {
                    JOptionPane.showMessageDialog(null,"成功录入！","消息！",1);
                } else {
                    JOptionPane.showMessageDialog(null,"录入失败，请重新输入！","提示",1);
                }
                jt1.setText("");
                jt2.setText("");
                jt3.setText("");
            }
        });
        jp1.add(jb2);

        jb3 = new JButton("重置");
        jb3.setFont(new Font("楷体",Font.BOLD,16));
        jb3.setBounds(300, 270,	95, 25);
        jb3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                jt1.setText("");
                jt2.setText("");
                jt3.setText("");
            }
        });
        jp1.add(jb3);

        //设置窗口和显示位置
        setVisible(true);
        setTitle("录入菜品");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        int width = Toolkit.getDefaultToolkit().getScreenSize().width;
        int height = Toolkit.getDefaultToolkit().getScreenSize().height;
        int windowsWedth = 500;
        int windowsHeight = 460;
        setBounds((width-windowsWedth)/2,(height-windowsHeight)/2,windowsWedth,windowsHeight);
    }
}