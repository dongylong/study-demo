package com.oreilly.headfirst.design.proxy.virtualProxy;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Enumeration;
import java.util.Hashtable;

/**
 * @author dongyl
 * @version 1.0
 * @title
 * @description
 * @company 好未来-爱智康
 * @created 2019/10/22 10:01
 * @changeRecord
 */
public class ImageProxyTestDriver {
    ImageComponent imageComponent;
    JFrame frame = new JFrame("CD Cover Viewer");
    JMenuBar menuBar;
    JMenu menu;
    Hashtable cds = new Hashtable();
    public static void main(String[] args) {
        try {
            ImageProxyTestDriver testDriver = new ImageProxyTestDriver();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public ImageProxyTestDriver() throws MalformedURLException {
        cds.put("1","htp://xxx.jpg");
        cds.put("1","htp://xxx.jpg");
        cds.put("1","htp://xxx.jpg");
        URL initialURL = new URL((String) cds.get("Selected Ambient Works.Vol.2"));
        menuBar = new JMenuBar();
        menu = new JMenu("Favorite CDs");
        menuBar.add(menu);
        frame.setJMenuBar(menuBar);
        for(Enumeration e = cds.keys();e.hasMoreElements();){
            String name = (String) e.nextElement();
            JMenuItem menuItem = new JMenuItem(name);
            menu.add(menuItem);
            menuItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    imageComponent.setIcon(new ImageProxy(getCDUrl(actionEvent.getActionCommand())));
                    frame.repaint();
                }
            });
        }
        Icon icon = new ImageProxy(initialURL);
        imageComponent = new ImageComponent(icon);
        frame.getContentPane().add(imageComponent);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,600);
        frame.setVisible(true);
    }
    URL getCDUrl(String name){
        try {
            return new URL((String) cds.get(name));
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
