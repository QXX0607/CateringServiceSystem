package com.restaurant.view;

import java.io.File;
import javax.swing.*;

class FileChooser extends JFrame  {
    JFileChooser jfc;
    public static String path;
    public static String name;
    public FileChooser() {
        jfc = new JFileChooser();
        jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        jfc.showDialog(new JLabel(), "选择");
        File file = jfc.getSelectedFile();
        path = file.getAbsolutePath();
//        name = file.getName();
    }
}