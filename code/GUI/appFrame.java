package GUI;

import compress_decompress.compressor;
import compress_decompress.decompressor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class appFrame extends JFrame implements ActionListener {
    JButton compress, decompress;

    // Constructor
    appFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // set layout for button
        setLayout(new GridLayout(2,1));

        // Initialize the button's with name
        compress = new JButton("Select Text File to Compress");
        decompress = new JButton("Select Gzip File to Decompress");

        // set button size
//        compress.setBounds(20, 100, 200, 30);
//        decompress.setBounds(250,100,200,30);

        // Action
        compress.addActionListener(this);
        decompress.addActionListener(this);

        // Add the buttons to the Frame
        this.add(compress);
        this.add(decompress);

        // Set Frame Dimension and Color
        this.setTitle("Compressor & Decompressor (v1.0)");
        this.setBounds(500,220,350,300);
        this.getContentPane().setBackground(Color.GRAY);
        this.setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent event) {
        if(event.getSource() == compress){
            JFileChooser fileChooser = new JFileChooser("C:");
            int response = fileChooser.showSaveDialog(null);

            if(response == JFileChooser.APPROVE_OPTION){
                // get the path of the file
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.println(file);

                try{
                    compressor.method(file);
                }
                catch (Exception fileNotFoundException){
                    JOptionPane.showConfirmDialog(null, fileNotFoundException.toString()) ;
                }
            }
        }

        if(event.getSource() == decompress){
            JFileChooser fileChooser = new JFileChooser("C:");
            int response = fileChooser.showSaveDialog(null);

            if(response == JFileChooser.APPROVE_OPTION){
                // get the path of the file
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.println(file);

                try{
                    decompressor.method(file);
                }
                catch (Exception fileNotFoundException){
                    JOptionPane.showConfirmDialog(null, fileNotFoundException.toString()) ;
                }
            }
        }
    }
}
