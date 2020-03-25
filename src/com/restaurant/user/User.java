package com.restaurant.user;

import org.jvnet.substance.SubstanceLookAndFeel;
import org.jvnet.substance.skin.*;


import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.sql.*;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.Vector;

public class User extends JFrame {
    public static final String driver = "com.mysql.jdbc.Driver";
    public static final String url = "jdbc:mysql://localhost:3306/mydb";
    public static final String user = "root";
    public static final String password = "1492949670";
    private Connection coon = null;


    PreparedStatement st;
    String sql = "insert into menu values(?,?,?)";
    public static String[] cai = new String[100];
    public static int jiage[] = new int[100];
    public static int num =1;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        cai[0] = "cai";
        jiage[0] = 0;
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Toolkit kit=Toolkit.getDefaultToolkit();
                    Image img=kit.getImage("E:\\Java\\Idea\\myproject\\image\\鼠标1.jpg");
                    Cursor mouse=kit.createCustomCursor(img, new Point(1,1), "stick");
                    //之前这三句没有注释掉，但运行突然不好使了，于是选择注释掉该部分
//                    UIManager.setLookAndFeel(new SubstanceDustCoffeeLookAndFeel());
//                    JFrame.setDefaultLookAndFeelDecorated(true);
//                    SubstanceLookAndFeel.setSkin(new DustCoffeeSkin());
                    User frame = new User();
                    frame.setVisible(true);
                    frame.setCursor(mouse);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public User() {

        setTitle("菜单");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        int width = Toolkit.getDefaultToolkit().getScreenSize().width;
        int height = Toolkit.getDefaultToolkit().getScreenSize().height;
        getContentPane().setBackground(SystemColor.activeCaption);
        setBounds(0, 0, width, height);
        getContentPane().setLayout(null);

        String sql = "select * from menu";
        try {
            Class.forName(driver);
            coon = DriverManager.getConnection(url, user, password);
            if (!coon.isClosed()) {
                System.out.println("连接数据库");
            }
            Statement stmt = coon.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

//            JPanel panel_8 = new JPanel();
//            panel_8.setBounds(30, 10, width - 50, height - 150);
//            .add(panel_8);

            JScrollPane js_d = new JScrollPane();
            js_d.setBounds(200, 10, width- 450, height-150);
            getContentPane().add(js_d);

            JTextArea textArea = new JTextArea();
            textArea.setSize(width-50, 9999);
            js_d.setRowHeaderView(textArea);

            js_d.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            js_d.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

            JPanel panel_7 = new JPanel();
            panel_7.setBounds(30, 10, 0, 0);
            panel_7.setBackground(SystemColor.activeCaption);
//            getContentPane().add(panel_7);
            js_d.setViewportView(panel_7);
            panel_7.setLayout(new GridLayout(0, 5, 10, 50));

            JButton jb = new JButton("购物车");
            jb.setIcon(new ImageIcon("E:\\Java\\Idea\\myproject\\image\\shopping55x55.png"));
            jb.setBounds(width - 100, height - 90, 55, 55);
            jb.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setExtendedState(ICONIFIED);
                    prestentation(cai, jiage);
                }
            });
            getContentPane().add(jb);

            JButton jb1 = new JButton("Magma");
            jb1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    try {
                        UIManager.setLookAndFeel(new SubstanceMagmaLookAndFeel());             //红色
                        JFrame.setDefaultLookAndFeelDecorated(true);
                        SubstanceLookAndFeel.setSkin(new MagmaSkin());
                    } catch (UnsupportedLookAndFeelException e) {
                        e.printStackTrace();
                    }

                }
            });
            jb1.setBounds(100, height-80, 100, 38);
            jb1.setFont(new Font("楷体", Font.BOLD, 16));
            getContentPane().add(jb1);

            JButton jb2 = new JButton("EmeraldDusk");
            jb2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    try {
                        UIManager.setLookAndFeel(new SubstanceEmeraldDuskLookAndFeel());            //绿色
                        JFrame.setDefaultLookAndFeelDecorated(true);
                        SubstanceLookAndFeel.setSkin(new EmeraldDuskSkin());
                    } catch (UnsupportedLookAndFeelException e) {
                        e.printStackTrace();
                    }
                }
            });
            jb2.setBounds(230, height-80, 130, 38);
            jb2.setFont(new Font("楷体", Font.BOLD, 16));
            getContentPane().add(jb2);

            JButton jb3 = new JButton("Moderate");
            jb3.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    try {
                        UIManager.setLookAndFeel(new SubstanceModerateLookAndFeel());             //蓝色
                        JFrame.setDefaultLookAndFeelDecorated(true);
                        SubstanceLookAndFeel.setSkin(new ModerateSkin());
                    } catch (UnsupportedLookAndFeelException e) {
                        e.printStackTrace();
                    }
                }
            });
            jb3.setBounds(390, height-80, 100, 38);
            jb3.setFont(new Font("楷体", Font.BOLD, 16));
            getContentPane().add(jb3);

            JButton jb4 = new JButton("Twilight");
            jb4.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    try {
                        UIManager.setLookAndFeel(new SubstanceTwilightLookAndFeel());             //黑色
                        JFrame.setDefaultLookAndFeelDecorated(true);
                        SubstanceLookAndFeel.setSkin(new TwilightSkin());
                    } catch (UnsupportedLookAndFeelException e) {
                        e.printStackTrace();
                    }
                }
            });
            jb4.setBounds(520, height-80, 100, 38);
            jb4.setFont(new Font("楷体", Font.BOLD, 16));
            getContentPane().add(jb4);

            JButton jb5 = new JButton("Autumn");
            jb5.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    try {
                        UIManager.setLookAndFeel(new SubstanceAutumnLookAndFeel());             //黑色
                        JFrame.setDefaultLookAndFeelDecorated(true);
                        SubstanceLookAndFeel.setSkin(new AutumnSkin());
                    } catch (UnsupportedLookAndFeelException e) {
                        e.printStackTrace();
                    }
                }
            });
            jb5.setBounds(650, height-80, 100, 38);
            jb5.setFont(new Font("楷体", Font.BOLD, 16));
            getContentPane().add(jb5);

            JButton jb6 = new JButton("MistAqua");
            jb6.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    try {
                        UIManager.setLookAndFeel(new SubstanceMistAquaLookAndFeel());             //黑色
                        JFrame.setDefaultLookAndFeelDecorated(true);
                        SubstanceLookAndFeel.setSkin(new MistAquaSkin());
                    } catch (UnsupportedLookAndFeelException e) {
                        e.printStackTrace();
                    }
                }
            });
            jb6.setBounds(780, height-80, 110, 38);
            jb6.setFont(new Font("楷体", Font.BOLD, 16));
            getContentPane().add(jb6);

            JButton jb7 = new JButton("DustCoffee");
            jb7.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    try {
                        UIManager.setLookAndFeel(new SubstanceDustCoffeeLookAndFeel());             //黑色
                        JFrame.setDefaultLookAndFeelDecorated(true);
                        SubstanceLookAndFeel.setSkin(new DustCoffeeSkin());
                    } catch (UnsupportedLookAndFeelException e) {
                        e.printStackTrace();
                    }
                }
            });
            jb7.setBounds(920, height-80, 150, 38);
            jb7.setFont(new Font("楷体", Font.BOLD, 16));
            getContentPane().add(jb7);
            while (rs.next()) {

                String name = rs.getString(1);
                String price = rs.getString(2);
                String descrption = rs.getString(3);
                String iconstring = rs.getString(4);
                changeSize(150, 150, iconstring);

                JPanel panel = new JPanel();
//                panel.setPreferredSize(new Dimension(150, 150));
                panel.setSize(300,400);
                panel_7.add(panel);
                panel.setLayout(new GridLayout(2, 0, 0, 0));
                JPanel panel_1 = new JPanel();
                panel_1.setPreferredSize(new Dimension(150, 150));
                panel.add(panel_1);

                JLabel lblNewLabel = new JLabel(" ");
                lblNewLabel.setIcon(new ImageIcon(iconstring));
                panel_1.add(lblNewLabel);

                JPanel panel_2 = new JPanel();
                panel_2.setPreferredSize(new Dimension(150, 80));
                panel.add(panel_2);
                panel_2.setLayout(new GridLayout(2, 0, 0, 0));

                JButton btnNewButton = new JButton(name + " " + price + "元");
                btnNewButton.setFont(new Font("楷体", Font.BOLD, 14));
                panel_2.add(btnNewButton);
                btnNewButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        JOptionPane.showMessageDialog(null, descrption, "简介", 1);
                    }
                });

                JPanel panel_3 = new JPanel();
                panel_2.add(panel_3);
                panel_3.setLayout(new GridLayout(1, 0, 0, 0));

                JButton btnNewButton_2 = new JButton("+");
                btnNewButton_2.setFont(new Font("楷体", Font.BOLD, 16));
                btnNewButton_2.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        jiage[0]++;
                        cai[jiage[0]] = name;
                        System.out.println( cai[jiage[0]]);
                        jiage[jiage[0]] = Integer.parseInt(price);
                    }
                });

                //测试代码
//                System.out.println(cai[1]);

                panel_3.add(btnNewButton_2);

                JButton btnNewButton_3 = new JButton("-");
                btnNewButton_3.setFont(new Font("楷体", Font.BOLD, 16));
                btnNewButton_3.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        int i;
                        for (i = 1; i <= jiage[0]; i++) {
                            if (cai[i] == name) {
                                int j;
                                for (j = i; j < jiage[0]; j++) {
                                    cai[j] = cai[j + 1];
                                    jiage[j] = jiage[j + 1];
                                }
                                jiage[jiage[0]] = 0;
                                cai[jiage[0]] = "";
                                jiage[0]--;
                                break;
                            }
                        }
                    }
                });
                panel_3.add(btnNewButton_3);

            }
            stmt.close();
            if (null != coon) {
                try {
                    coon.close();
                    System.out.println("关闭连接");
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "关闭数据库失败", "提示", 1);
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //图片大小裁剪
    public boolean changeSize(int newWidth, int newHeight, String path) {
        BufferedInputStream in = null;
        try {
            in = new BufferedInputStream(new FileInputStream(path));
            //字节流转图片对象
            Image bi = ImageIO.read(in);
            //构建图片流
            BufferedImage tag = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_RGB);
            //绘制改变尺寸后的图
            tag.getGraphics().drawImage(bi, 0, 0, newWidth, newHeight, null);
            //输出流
            BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(path));
            try {
                ImageIO.write(tag, "jpg", out);
            } catch (IOException e) {
                e.printStackTrace();
            }
            in.close();
            out.close();
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    //点击购物车Jb后出订单，同时将订单信息传入数据库
    public void prestentation(String[] cai, int[] jiage) {
        JTable jt;
        JScrollPane jsp;
        JPanel jp1,jp2;
        JButton jb1;
        JTextField jt1;
        JLabel jl1;
        JFrame h = new JFrame();
        //rowData用来存放行数据
        //columnNames存放列名
        Vector rowData, columnNames;
        //中间
        columnNames = new Vector();
        //设置列名
        columnNames.add("菜名");
        columnNames.add("价格");

        for (int i=0;i<=jiage[0];i++)
        {
            System.out.println(cai[i]+"   "+jiage[i]);
        }
        rowData = new Vector();

        for (int i = 1; i <= jiage[0]; i++) {
            Vector hang = new Vector();
            hang.add(cai[i]);
            hang.add(jiage[i]);
            rowData.add(hang);
        }

        jt = new JTable(rowData, columnNames);
        jt.setBackground(new java.awt.Color(198, 226, 255));

        jsp = new JScrollPane(jt);
        jsp.setBounds(0,0,480,500);

        jp1 = new JPanel();
        jp1.add(jsp);

        jp2 = new JPanel();
        jp2.setLayout(new GridLayout(0,2,0,20));
        jt1 = new JTextField();
        jt1.setBounds(80,530,160,38);

        jl1 = new JLabel("订单号");
        jl1.setFont(new Font("楷体", Font.BOLD, 16));
        jl1.setBounds(10, 530, 54, 38);
        jp2.add(jl1);
        jp2.add(jt1);
        jp1.add(jp2);

        jb1 = new JButton("提交订单");
        jb1.setFont(new Font("楷体", Font.BOLD, 16));
        jb1.setBounds(200,570,100,50);
        jb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cnt = jt1.getText();
                senddata(cai,jiage,cnt);
                JOptionPane.showMessageDialog(null, "订单提交成功", "提示", 1);
            }
        });
        jp1.add(jb1);
        jp1.setBackground(SystemColor.activeCaption);

        h.add(jp1);
        h.setVisible(true);
        h.setTitle("订单详情");
        h.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        int width = Toolkit.getDefaultToolkit().getScreenSize().width;
        int height = Toolkit.getDefaultToolkit().getScreenSize().height;
        int windowsWedth = 500;
        int windowsHeight = 590;
        h.setBounds((width - windowsWedth) / 2, (height - windowsHeight) / 2, windowsWedth, windowsHeight);

    }

    //传入信息到数据库orderrecord中
    public void senddata(String[] cai, int[] jiage,String cnt) {
        String sq = "insert into orderrecord values(?,?,?,?)";
        String str1 = " ";
        String str2,str3;
        int sum = 0;
        for(int i=1;i<=jiage[0];i++) {
            str1 = str1+cai[i]+"  ";
            sum+=jiage[i];
        }
        str2 = String.valueOf(sum);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        str3 = df.format(System.currentTimeMillis());
        System.out.println();
        System.out.println(str1);
        System.out.println(str2);
        System.out.println(str3);

        try {
            Class.forName(driver);
            coon = DriverManager.getConnection(url, user, password);
            if (!coon.isClosed()) {
                System.out.println("成功连接数据库");
            }
            st = coon.prepareStatement(sq);
            st.setString(1,cnt);
            st.setString(2, str1);
            st.setString(3, str2);
            st.setString(4,str3);
            st.executeUpdate();
            st.close();
            if (null != coon) {
                try {
                    coon.close();
                    System.out.println("关闭连接");
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "关闭数据库失败", "提示", 1);
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
