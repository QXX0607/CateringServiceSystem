package com.restaurant.view;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import org.jvnet.substance.SubstanceLookAndFeel;
import org.jvnet.substance.skin.DustCoffeeSkin;
import org.jvnet.substance.skin.SubstanceDustCoffeeLookAndFeel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class mainPage extends JFrame implements Runnable{

    private JButton jb1,jb2,jb3,jb4;
    public static final String driver = "com.mysql.jdbc.Driver";
    public static final String url = "jdbc:mysql://localhost:3306/mydb";
    public static final String user = "root";
    public static final String password = "1492949670";

    Connection  coon=null;
    @Override
    public void run() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                JOptionPane.showMessageDialog(null,"After this dialog is closed,program will be terinated!");
                System.exit(0);
            }
        });
          try{
//              UIManager.setLookAndFeel(new SubstanceDustCoffeeLookAndFeel());
//              JFrame.setDefaultLookAndFeelDecorated(true);
//              SubstanceLookAndFeel.setSkin(new DustCoffeeSkin());
                for(UIManager.LookAndFeelInfo info:UIManager.getInstalledLookAndFeels()){
                    if("Windows".equals(info.getName()))
                    {
                        UIManager.setLookAndFeel(info.getClassName());
                        break;
                    }
                    System.out.println(info.getName());
                }
            }catch(Exception e)
            {
                e.printStackTrace();
            }

            //初始化以及设置按钮
        jb1 = new JButton("设置菜品");
        jb2 = new JButton("获取数据库信息");
        jb3 = new JButton("销售分析");
        jb4 = new JButton("删除菜品");
        jb1.setFont(new Font("楷体",Font.BOLD,16));
        jb2.setFont(new Font("楷体",Font.BOLD,16));
        jb3.setFont(new Font("楷体",Font.BOLD,16));
        jb4.setFont(new Font("楷体",Font.BOLD,16));
        //设置鼠标图标
        Toolkit kit=Toolkit.getDefaultToolkit();
        Image img=kit.getImage("E:\\Java\\Idea\\myproject\\image\\鼠标2.jpg");
        Cursor mouse=kit.createCustomCursor(img, new Point(1,1), "stick");
        this.setCursor(mouse);
        //设置布局管理器
        setVisible(true);
        setLayout(new GridLayout(4,0,8,18));
//        setAlwaysOnTop(!isAlwaysOnTop());
        //设置窗体位置和大小
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("管理界面");
        int width = Toolkit.getDefaultToolkit().getScreenSize().width;
        int height = Toolkit.getDefaultToolkit().getScreenSize().height;
        int windowsWedth = 400;
        int windowsHeight = 300;
        setBounds((width-windowsWedth)/2,(height-windowsHeight)/2,windowsWedth,windowsHeight);

        //添加事件监听
        jb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setExtendedState(ICONIFIED);
                Menu sm = new Menu();
            }
        });
        jb2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setExtendedState(ICONIFIED);
                Read read = new Read();
            }
        });
        jb3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setExtendedState(ICONIFIED);
                int[] price = {0,0,0,0,0,0,0,0,0,0,0,0,0};
                String[] nianyue={"2018-12","2019-01","2019-02","2019-03","2019-04","2019-05","2019-06","2019-07","2019-08","2019-09","2019-10","2019-11","2019-12"};
                String sql="select * from orderrecord";//查询usrInfo表中的信息
                try{
//          加载驱动程序
                    Class.forName(driver);
                    coon=(Connection) DriverManager.getConnection(url,user,password);
                    if(!coon.isClosed()){
                        System.out.println("成功连接数据库！");
                    }
                }catch (Exception e1){
                    e1.printStackTrace();
                }
                try{
                    Statement stmt=(Statement)coon.createStatement();
                    ResultSet rs= stmt.executeQuery(sql);//得到的是结果的集合
                    while(rs.next()){
                        String timeorder = (rs.getString(4)).substring(0,7);
                        String moneyorder = rs.getString(3);
                        int money = Integer.parseInt(moneyorder);
                        System.out.println(timeorder+"  "+money);
                        int i;
                        for (i=1;i<=12;i++){
                            if (timeorder.equals(nianyue[i]))
                                price[i]+=money;
                            System.out.println(price[i]);
                        }

                    }
                    stmt.close();
                }catch(Exception e2){
                    e2.printStackTrace();
                }
                try{
                    coon.close();
                }catch(Exception e4){
                    e4.printStackTrace();
                }
//                for(int i=1;i<=6;i++){
//                    System.out.println(price[i]+"  "+nianyue[i]);
//                }
                JFrame frame=new JFrame("销售数据统计图");
                frame.add(new BarChart(price,nianyue).getChartPanel());

                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                int width = Toolkit.getDefaultToolkit().getScreenSize().width;
                int height = Toolkit.getDefaultToolkit().getScreenSize().height;
                int windowsWedth = 1200;
                int windowsHeight = 540;
                frame.setBounds((width-windowsWedth)/2,(height-windowsHeight)/2,windowsWedth,windowsHeight);
                frame.setVisible(true);
            }
        });
        jb4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setExtendedState(ICONIFIED);
                Delete de = new Delete();
            }
        });

        //添加控件
        add(jb1);
        add(jb4);
        add(jb2);
        add(jb3);
    }
}