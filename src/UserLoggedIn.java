import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class UserLoggedIn extends JFrame {

    Database d = new Database();

    private JLabel schoolInfo = new JLabel("Välkommen till Nackademin!");
    private JTextArea infoField = new JTextArea("Info......");
    private JButton courseSearch = new JButton("Sök efter kurser");
    private JButton teacherSearch = new JButton("Sök efter lärare");
    private JButton studentSearch = new JButton("Sök efter elever");
    private JTextField searchField = new JTextField("Sök här");
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

        centerPanel.add(infoField, BorderLayout.NORTH);
        centerPanel.add(searchField, BorderLayout.SOUTH);

        infoField.setEditable(false);


        add(bottomPanel);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        courseSearch.addActionListener(e->{
            if (!searchField.getText().isEmpty()) {
                Course course = d.searchCourse(searchField.getText());
                if (course == null)
                    infoField.setText("Kursen finns inte");
                else infoField.setText(course.toString());
            }
            searchField.setText("Sök här");
        });

        studentSearch.addActionListener(e->{
            if (!searchField.getText().isEmpty()) {
                Person student = d.searchStudent(searchField.getText());
                if (student == null)
                infoField.setText("Eleven finns inte");
                else infoField.setText(student.toString());
            }
            searchField.setText("Sök här");
        });

        teacherSearch.addActionListener(e->{

            if (!searchField.getText().isEmpty()) {
                Person teacher = d.searchTeacher(searchField.getText());
                if (teacher == null)
                infoField.setText("Läraren finns inte");
                else infoField.setText(teacher.toString());
            }
            searchField.setText("Sök här");
        });

        searchField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if (searchField.getText().equals("Sök här")){
                    searchField.setText("");
                }
            }
        });
    }
}