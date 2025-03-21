import java.awt.*;
import javax.swing.*;

public class AddTimetablePage extends JFrame {

    public AddTimetablePage() {
        setTitle("Add New Timetable");
        setSize(600, 450);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));
        setLocationRelativeTo(null); // Center the window

        // 🔹 Main Panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        mainPanel.setBackground(new Color(240, 240, 240));

        // 🔹 Title Bar
        JPanel titleBar = new JPanel(new BorderLayout());
        titleBar.setBackground(new Color(50, 100, 200)); // Blue header
        JLabel titleLabel = new JLabel("Add New Timetable", SwingConstants.LEFT);
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        titleBar.add(titleLabel, BorderLayout.WEST);
        titleBar.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

        JButton doneButton = new JButton("Done");
doneButton.setBackground(new Color(0, 128, 128)); // Teal color
doneButton.setForeground(Color.WHITE);
doneButton.addActionListener(e -> {
    new TimetablePage(); // Open TimetablePage
    dispose(); // Close AddTimetablePage
});


        // 🔹 Timetable Details Section
        JPanel detailsPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        detailsPanel.setBackground(mainPanel.getBackground());
        detailsPanel.setBorder(BorderFactory.createTitledBorder("Timetable Details"));

        detailsPanel.add(new JLabel("Timetable Name *"));
        JTextField nameField = new JTextField();
        detailsPanel.add(nameField);

        detailsPanel.add(new JLabel("Semester *"));
        JTextField semesterField = new JTextField();
        detailsPanel.add(semesterField);

        detailsPanel.add(new JLabel("Department *"));
        JTextField departmentField = new JTextField();
        detailsPanel.add(departmentField);

        // 🔹 Timetable Hours Section
        JPanel hoursPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        hoursPanel.setBackground(mainPanel.getBackground());
        hoursPanel.setBorder(BorderFactory.createTitledBorder("Timetable Hours"));

        hoursPanel.add(new JLabel("Total Lectures"));
        JTextField lecturesField = new JTextField();
        hoursPanel.add(lecturesField);

        hoursPanel.add(new JLabel("Total Labs"));
        JTextField labsField = new JTextField();
        hoursPanel.add(labsField);

        hoursPanel.add(new JLabel("Total Tutorials"));
        JTextField tutorialsField = new JTextField();
        hoursPanel.add(tutorialsField);

        // 🔹 Course Assignments Section
        JPanel assignmentsPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        assignmentsPanel.setBackground(mainPanel.getBackground());
        assignmentsPanel.setBorder(BorderFactory.createTitledBorder("Course Assignments"));

        assignmentsPanel.add(new JLabel("Assigned Course"));
        JTextField courseField = new JTextField();
        assignmentsPanel.add(courseField);

        assignmentsPanel.add(new JLabel("Instructor"));
        JTextField instructorField = new JTextField();
        assignmentsPanel.add(instructorField);

        // 🔹 Save & Cancel Buttons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton saveButton = new JButton("Save");
        saveButton.setBackground(new Color(50, 100, 200)); // Blue Save Button
        saveButton.setForeground(Color.WHITE);
        JButton cancelButton = new JButton("Cancel");

        buttonPanel.add(saveButton);
        buttonPanel.add(cancelButton);

        // 🔹 Adding components to main panel
        mainPanel.add(detailsPanel);
        mainPanel.add(hoursPanel);
        mainPanel.add(assignmentsPanel);
        mainPanel.add(buttonPanel);

        // 🔹 Final Layout
        add(titleBar, BorderLayout.NORTH);
        add(mainPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AddTimetablePage());
    }
}
