package com.restaurant.view;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

class Read extends JFrame  {

    //定义一些控件
    private JTable jt;
    private JScrollPane jsp;
    private JPanel jp1;
    //定义操作数据库需要的变量
    PreparedStatement ps = null;
    Connection ct = null;
    ResultSet rs = null;
    //连接数据库
    public static final String driver = "com.mysql.jdbc.Driver";
    public static final String url = "jdbc:mysql://localhost:3306/mydb";
    public static final String user = "root";
    public static final String password = "1492949670";
    //rowData用来存放行数据
    //columnNames存放列名
    Vector rowData,columnNames;

    //构造函数
    public Read()
    {
        Toolkit kit=Toolkit.getDefaultToolkit();
        Image img=kit.getImage("E:\\Java\\Idea\\myproject\\image\\鼠标2.jpg");
        Cursor mouse=kit.createCustomCursor(img, new Point(1,1), "stick");
        this.setCursor(mouse);
        //中间
        columnNames = new Vector();
        //设置列名
        columnNames.add("菜名");
        columnNames.add("价格");
        columnNames.add("简介");
        columnNames.add("图片路径");

        rowData = new Vector();
        try {
            Class.forName( driver );
            ct = DriverManager.getConnection( url,user,password );
            ps = ct.prepareStatement("select 菜名,价格,简介,图片路径 from menu");
            rs=ps.executeQuery();
            while(rs.next())
            {
                //rowData可以存放多行
                Vector hang = new Vector();
                hang.add(rs.getString(1));
                hang.add(rs.getString(2));
                hang.add(rs.getString(3));
                hang.add(rs.getString(4));
                //加入到rowData
                rowData.add(hang);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            //关闭
            try {
                if (rs!= null) rs.close();
                if(ps!=null) ps.close();
                if(ct!=null) ct.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
        //初始化JTable
        jt = new JTable(rowData,columnNames);
        jt.setBackground(new java.awt.Color(198, 226, 255));
        //初始化jsp JScrollPane
        jsp = new JScrollPane(jt);
        jp1 = new JPanel();
        jp1.add(jsp);
        jp1.setBackground(SystemColor.activeCaption);
        add(jp1);
        setVisible(true);
        setTitle("获取全部菜品信息");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        int width = Toolkit.getDefaultToolkit().getScreenSize().width;
        int height = Toolkit.getDefaultToolkit().getScreenSize().height;
        int windowsWedth = 500;
        int windowsHeight = 460;
        setBounds((width-windowsWedth)/2,(height-windowsHeight)/2,windowsWedth,windowsHeight);
    }

}