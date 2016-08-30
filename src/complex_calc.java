/**
 * Created by vladislav on 30.12.2015.
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class complex_calc implements ActionListener {
    JTextField Atable,Btable;
    JLabel plus,j;
    double A, B;
    String operation;

    complex_calc() {
        JFrame mainframe = new JFrame("Complex calc");
        mainframe.setLayout(new FlowLayout());
        mainframe.setSize(240, 200);
        mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Atable= new JTextField(8);
        Btable= new JTextField(8);

        JButton btnplus = new JButton("+");
        JButton btnminus = new JButton("-");
        JButton btnres = new JButton("=");
        JButton btnclear = new JButton("clear");
        JButton btnmulti = new JButton("*");
        JButton btndiv = new JButton("/");

        plus = new JLabel("+");
        j = new JLabel("i");

        btnplus.addActionListener(this);
        btnminus.addActionListener(this);
        btnres.addActionListener(this);
        btnmulti.addActionListener(this);
        btndiv.addActionListener(this);
        btnclear.addActionListener(this);


        mainframe.add(Atable);
        mainframe.add(plus);
        mainframe.add(Btable);
        mainframe.add(j);

        mainframe.add(btnplus);
        mainframe.add(btnminus);
        mainframe.add(btnmulti);
        mainframe.add(btndiv);


        mainframe.add(btnclear);
        mainframe.add(btnres);


        mainframe.setVisible(true);


    }

    public void clearData() {
        Atable.setText("");
        Btable.setText("");
        operation = "";
        A = 0;
        B = 0;
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            if (ae.getActionCommand().equals("+")) {
                A = Double.parseDouble(Atable.getText());
                B = Double.parseDouble(Btable.getText());
                operation = "add";
                Atable.setText("");
                Btable.setText("");
            }
            if (ae.getActionCommand().equals("=")) {
                if (operation == "add") {
                    A += Double.parseDouble(Atable.getText());
                    B += Double.parseDouble(Btable.getText());
                    Atable.setText("" + A);
                    Btable.setText("" + B);
                }
                if (operation == "del") {
                    A -= Double.parseDouble(Atable.getText());
                    B -= Double.parseDouble(Btable.getText());
                    Atable.setText("" + A);
                    Btable.setText("" + B);
                }
                if (operation == "multi") {
                    double a = A;
                    A =A*Double.parseDouble(Atable.getText())-B*Double.parseDouble(Btable.getText());
                    B =a*Double.parseDouble(Btable.getText())+B*Double.parseDouble(Atable.getText());
                    Atable.setText(""+ A);
                    Btable.setText(""+ B);
                }
                if (operation == "div") {
                    double a = A;
                    A =(A*Double.parseDouble(Atable.getText())+B*Double.parseDouble(Btable.getText()))/(Math.pow(Double.parseDouble(Atable.getText()),2)+Math.pow(Double.parseDouble(Btable.getText()),2));
                    B =(B*Double.parseDouble(Atable.getText())-a*Double.parseDouble(Btable.getText()))/(Math.pow(Double.parseDouble(Atable.getText()),2)+Math.pow(Double.parseDouble(Btable.getText()),2));
                    Atable.setText(""+ A);
                    Btable.setText(""+ B);
                }

            }
            if (ae.getActionCommand().equals("-")) {
                A = Double.parseDouble(Atable.getText());
                B = Double.parseDouble(Btable.getText());
                operation = "del";
                Atable.setText("");
                Btable.setText("");
            }
            if (ae.getActionCommand().equals("*")) {
                A =Double.parseDouble(Atable.getText());
                B =Double.parseDouble(Btable.getText());
                operation = "multi";
                Atable.setText("");
                Btable.setText("");
            }
            if (ae.getActionCommand().equals("/")) {
                A =Double.parseDouble(Atable.getText());
                B =Double.parseDouble(Btable.getText());
                operation = "div";
                Atable.setText("");
                Btable.setText("");
            }




            if (ae.getActionCommand().equals("clear")) {
                clearData();
            }


        }catch (Exception exc) {JOptionPane.showMessageDialog(null, "ENTER RIGHT VALUE");
            clearData(); }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new complex_calc();

            }
        });
    }


}
