/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 *
 * @author Alex
 */
public class CellRenderer implements ListCellRenderer{

    @Override
    public Component getListCellRendererComponent(JList jlist, Object e, int i, boolean isSelected, boolean hasFocus) {
        JLabel lb = new JLabel(e.toString());
        
        lb.setOpaque(true);
        if(e.isFile())
        {
            lb.setForeground(Color.red.brighter());
        }
        else if(e.isDirectory()) 
        {
            lb.setForeground(Color.green.darker().darker());
        }
        else
        {
            lb.setForeground(Color.black);
        }
        
        if(isSelected)
        {
            lb.setBackground(Color.gray);
        }
        
        return lb;
    }
    
}
