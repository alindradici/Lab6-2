/**
 * Created by alin on 4/19/2016.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class gui extends JFrame {

    private JList list;
    private JButton adauga;
    private JButton afiseaza;
    private JButton modifica;
    private JButton cauta;
    private Person [] listaPersoane = new Person [10];
    private String [] title = new String[10];
    private int index=0;


    public gui (){
        super("AgendaTelefonica");
        setLayout(new FlowLayout());
        list = new JList();
        list.setVisibleRowCount(6);
        list.setBackground(Color.WHITE);
        list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        list.setFixedCellHeight(30);
        list.setFixedCellWidth(100);
        add(new JScrollPane(list));

        adauga = new JButton("Adauga Contact");
        add(adauga);
        adauga.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            String num = JOptionPane.showInputDialog(null,"adauga nume");
            String tel = JOptionPane.showInputDialog(null,"adauga numar");
                Person p = new Person(num,tel);
                listaPersoane[index]=p;
                title[index] = listaPersoane[index].getName();
                list.setListData(title);
                index++;

            }
        });

        afiseaza = new JButton("Afiseaza contacte: ");
        add(afiseaza);
        afiseaza.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null,listaPersoane[list.getSelectedIndex()].getName()+"\n"+listaPersoane[list.getSelectedIndex()].getNumber());
            }
        });

        modifica = new JButton ("Modifica contactul");
        add(modifica);
        modifica.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            String nou = JOptionPane.showInputDialog(null,"introdu nume nou :");
            String nrNou = JOptionPane.showInputDialog(null,"introdu numar nou :");
            listaPersoane[list.getSelectedIndex()] = new Person(nou,nrNou);
                title[list.getSelectedIndex()]=listaPersoane[list.getSelectedIndex()].getName();

            }
        });

        cauta = new JButton("Cauta contact :");
        add(cauta);
        cauta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            String nume = JOptionPane.showInputDialog(null,"nume contact :");
            for(int i=0;i<title.length;i++){

                if(nume.equals(title[i])) {
                 JOptionPane.showMessageDialog(null,title[i] + " pozitia " + ++i); return;
                }
            }JOptionPane.showMessageDialog(null,"negasit");
            }
        });


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(250,400);
        setVisible(true);

    }
}
