package com.company.adapter;

import com.company.models.Plant;

import javax.swing.*;
import java.awt.*;

public class PlantAdapter extends DefaultListCellRenderer implements ListCellRenderer<Object> {
    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        Plant p = (Plant) value;
        setText(p.getJenis());
        setIcon(p.createImageIcon("../" + p.getImagePath(), ""));
        setHorizontalTextPosition(JLabel.CENTER);
        setVerticalTextPosition(JLabel.BOTTOM);
        setEnabled(true);
        setFont(list.getFont());

        if(isSelected) {
            setBackground(list.getSelectionBackground());
            setForeground(list.getSelectionForeground());
        } else {
            setBackground(list.getBackground());
            setForeground(list.getForeground());
        }

        return this;
    }
}
