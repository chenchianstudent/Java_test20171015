package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;
public class MainFrame2 extends JFrame {
    Random rnd=new Random();
    private JTextField jtf= new JTextField();
    private Container cp;
    private JPanel jpn=new JPanel(new GridLayout(3,3));
    private JButton jbtns[]=new JButton[9];
    private String jbtns2[]= { "7","8","4","5","6","1","2","3","0"};
    private String[] number=new String[jbtns2.length];
    public  MainFrame mframe=new MainFrame();

    public MainFrame2(MainFrame mf){
        mframe=mf;
        init();
    }
    private void init(){
        this.setBounds(100,100,400,600);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                mframe.setVisible(true);
            }
        });
        cp=this.getContentPane();
        cp.setLayout(new BorderLayout(5,5));
        cp.add(jtf,BorderLayout.NORTH);
        cp.add(jpn,BorderLayout.CENTER);
        jtf.setEditable(false);
        for (int i = 0; i < 9; i++) {
            int p=rnd.nextInt(9);
            jbtns[i] = new JButton(jbtns2[p]);
            number[i]=jbtns2[p];
            System.out.println("更正前"+i+"="+number[i]);
            System.out.println(p);
            for (int j = 0; j < i; j++) {
                while(number[i]==number[j]) {
                    p=rnd.nextInt(9);
                    number[i]=jbtns2[p];
                    jbtns[i]=new JButton(jbtns2[p]);
                    System.out.println("更正後"+i+"="+number[i]);
                    j=0;
                }

            }

        }
        for (int i = 0; i < 9; i++) {
            jpn.add(jbtns[i]);
        }
        for(int i=0;i<9;i++){
            jbtns[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton tempButton= (JButton) e.getSource();
                    jtf.setText(jtf.getText()+tempButton.getText());
                }
            });
        }
    }
}