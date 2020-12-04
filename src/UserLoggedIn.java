import javax.swing.*;
import java.awt.*;

public class UserLoggedIn extends JFrame{

    private JLabel schoolInfo = new JLabel("Välkommen till Nackademin!");
    private JTextArea infoField = new JTextArea("Info......");
    private JButton courseSearch = new JButton("Sök efter kurser");
    private JButton teacherSearch = new JButton("Sök efter lärare");
    private JButton studentSearch = new JButton("Sök efter elever");
    private JButton clearTextArea = new JButton("Rensa sökfält");
    private JTextField searchField = new JTextField("Skriv här");
    private JPanel bottomPanel = new JPanel();
    private JPanel northPanel = new JPanel();
    private JPanel southPanel = new JPanel();
    private JPanel centerPanel = new JPanel();


    public UserLoggedIn(){

        bottomPanel.setLayout(new BorderLayout());
        northPanel.setLayout(new BorderLayout());
        southPanel.setLayout(new GridLayout(2, 2));
        centerPanel.setLayout(new BorderLayout());

        bottomPanel.add(northPanel, BorderLayout.NORTH);
        bottomPanel.add(southPanel, BorderLayout.SOUTH);
        bottomPanel.add(centerPanel, BorderLayout.CENTER);

        northPanel.add(schoolInfo, BorderLayout.NORTH);

        southPanel.add(teacherSearch);
        southPanel.add(studentSearch);
        southPanel.add(courseSearch);
        southPanel.add(clearTextArea);

        centerPanel.add(infoField, BorderLayout.NORTH);
        centerPanel.add(searchField, BorderLayout.SOUTH);

        infoField.setEditable(false);


        add(bottomPanel);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}