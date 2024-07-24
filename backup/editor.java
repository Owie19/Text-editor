// Java Program to create a text editor using java
import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.awt.event.*;
import javax.swing.plaf.metal.*;
import javax.swing.text.*;
class editor extends JFrame implements ActionListener{
    // Text component
    JTextArea t;
     
    // Frame
    JFrame f;
 
    // Constructor
    editor()
    {
        // Create a frame
        f = new JFrame("editor");
 
        try {
            // Set metal look and feel
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
 
            // Set theme to ocean
            MetalLookAndFeel.setCurrentTheme(new OceanTheme());
        }
        catch (Exception e) {
        }
 
        // Text component
        t = new JTextArea();
 
        // Create a menubar
        JMenuBar mb = new JMenuBar();
 
        // Create amenu for menu
        JMenu m1 = new JMenu("File");
 
        // Create menu items
        JMenuItem mi1 = new JMenuItem("New");
        JMenuItem mi2 = new JMenuItem("Open");
        JMenuItem mi3 = new JMenuItem("Save");
        JMenuItem mi9 = new JMenuItem("Print");
 
        // Add action listener
        mi1.addActionListener(this);
        mi2.addActionListener(this);
        mi3.addActionListener(this);
        mi9.addActionListener(this);
 
        m1.add(mi1);
        m1.add(mi2);
        m1.add(mi3);
        m1.add(mi9);
 
        // Create amenu for menu
        JMenu m2 = new JMenu("Edit");
 
        // Create menu items
        JMenuItem mi4 = new JMenuItem("cut");
        JMenuItem mi5 = new JMenuItem("copy");
        JMenuItem mi6 = new JMenuItem("paste");
 
        // Add action listener
        mi4.addActionListener(this);
        mi5.addActionListener(this);
        mi6.addActionListener(this);
 
        m2.add(mi4);
        m2.add(mi5);
        m2.add(mi6);
 
        JMenuItem mc = new JMenuItem("close");
 
        mc.addActionListener(this);
 
        mb.add(m1);
        mb.add(m2);
        mb.add(mc);
 
        f.setJMenuBar(mb);
        f.add(t);
        f.setSize(500, 500);
        f.show();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
 
}
