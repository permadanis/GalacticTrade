/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prospacegalactictrade;

import javax.swing.JFrame;

/**
 *
 * @author YTR
 */
public class ProspaceGalacticTrade {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        JFrame frame = new JFrame();
        MainPanel panel = new MainPanel();
        frame.setContentPane(panel);
        frame.setSize(panel.getPreferredSize());
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    
}
