import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Frame{
    JMenu menu;
    JMenuItem about;
    public Frame() {
        JFrame f= new JFrame("KodNet - Networking");
        JMenuBar mb=new JMenuBar();
        menu=new JMenu("Menu");
        about=new JMenuItem("About");
        about.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new About();
            }
        });
        menu.add(about);
        mb.add(menu);
        mb.add(menu);
        f.setJMenuBar(mb);


        JLabel website = new JLabel("Enter website: ");
        website.setBounds(95,20,150,50);
        JTextField textField = new JTextField();
        textField.setBounds(50,60,200,25);
        JButton button = new JButton("Show IP");
        button.setBounds(50,90,200,30);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String website = textField.getText();
                try {
                    InetAddress inetAddress = InetAddress.getByName(website);
                    String ip = inetAddress.getHostAddress();
                    JOptionPane.showMessageDialog(null,ip);
                    textField.setText("");
                }catch (UnknownHostException e){
                    JOptionPane.showMessageDialog(null, e.toString());
                }
            }
        });
        f.add(website);
        f.add(textField);
        f.add(button);


        f.setSize(300,300);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setResizable(false);
    }
}