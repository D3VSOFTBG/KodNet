import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class About {
    public About(){
        JFrame f= new JFrame();
        JDialog d = new JDialog(f, "About", true);
        d.setLayout(new FlowLayout());
        JLabel developer;
        developer = new JLabel("Developer: Tarak Mustafa (D3VBG)");
        d.add(developer);
        String url = "https://kodbulgaria.com";
        JLabel hyperlink = new JLabel(url);
        hyperlink.setForeground(Color.BLUE.darker());
        hyperlink.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        hyperlink.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try{
                    Desktop.getDesktop().browse(new URI(url));
                } catch (URISyntaxException | IOException exception) {
                    exception.printStackTrace();
                }
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                hyperlink.setText("<html><a href='#'>"+url+"</a></html>");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                hyperlink.setText(url);
            }
        });
        d.add(hyperlink);
        d.setSize(300,150);
        d.setVisible(true);
    }
}