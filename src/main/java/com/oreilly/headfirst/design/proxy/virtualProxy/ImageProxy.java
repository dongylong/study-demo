package com.oreilly.headfirst.design.proxy.virtualProxy;

import org.springframework.util.ObjectUtils;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

/**
 * @author dongyl
 * @version 1.0
 * @title
 * @description
 * @company 好未来-爱智康
 * @created 2019/10/22 09:50
 * @changeRecord
 */
public class ImageProxy implements Icon {
    ImageIcon imageIcon;
    URL imageUrl;
    Thread retrievalThread;
    boolean retrieving = false;

    public ImageProxy(URL imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        if (ObjectUtils.isEmpty(imageIcon)) {
            g.drawString("loading cd cover please wait", x + 300, y + 190);
            if (!retrieving) {
                retrieving = true;
                retrievalThread = new Thread(
                        () -> {
                            try {
                                imageIcon = new ImageIcon(imageUrl, "CD cover");
                                c.repaint();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                );
                retrievalThread.start();
            }
        } else {
            imageIcon.paintIcon(c, g, x, y);
        }
    }

    @Override
    public int getIconWidth() {
        if (ObjectUtils.isEmpty(imageIcon)) {
            return 800;
        }
        return imageIcon.getIconWidth();
    }

    @Override
    public int getIconHeight() {
        if (ObjectUtils.isEmpty(imageIcon)) {
            return 600;
        }
        return imageIcon.getIconHeight();
    }
}
