package com.oreilly.headfirst.design.proxy.virtualProxy;

import lombok.Data;

import javax.swing.*;
import java.awt.*;

/**
 * @author dongyl
 * @version 1.0
 * @title
 * @description
 * @company 好未来-爱智康
 * @created 2019/10/22 10:01
 * @changeRecord
 */
@Data
public class ImageComponent extends JComponent {
    Icon icon;

    public ImageComponent(Icon icon) {
        this.icon = icon;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int w = icon.getIconWidth();
        int h = icon.getIconHeight();
        int x = (800 - w) / 2;
        int y = (600 - h) / 2;
        icon.paintIcon(this, g, x, y);
    }
}
