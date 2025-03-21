import java.awt.*;
import javax.swing.*;

public class TimeTableDashboard extends JFrame {

    public TimeTableDashboard() {
        setTitle("Time Table Builder");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // Set the entire background to blue
        getContentPane().setBackground(new Color(70, 130, 180)); // Steel Blue color

        // Top Panel (Navigation Bar)
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(new Color(30, 144, 255)); // Dodger Blue
        topPanel.setPreferredSize(new Dimension(800, 50));

        JLabel title = new JLabel("  Timetable");
        title.setFont(new Font("Arial", Font.BOLD, 20));
        title.setForeground(Color.WHITE);

        // Create Timetable Button
        JButton createTimetable = new JButton("+ Create Timetable");
        createTimetable.setBackground(new Color(34, 139, 34)); // Green background
        createTimetable.setForeground(Color.BLACK); // Black text
        createTimetable.setFocusPainted(false);
        createTimetable.setFont(new Font("Arial", Font.BOLD, 14));

        // Add action listener to open the Timetable Page when clicked
        createTimetable.addActionListener(e -> openAddTimetablePage());

        JPanel rightNav = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        rightNav.setBackground(new Color(30, 144, 255)); // Match top panel
        rightNav.add(createTimetable);

        topPanel.add(title, BorderLayout.WEST);
        topPanel.add(rightNav, BorderLayout.EAST);

        // Timetable Cards Panel - 4 Timetables in Grid Layout (2x2)
        JPanel timetablePanel = new JPanel(new GridLayout(2, 2, 20, 20));
        timetablePanel.setOpaque(false); // Transparent panel to show the blue background
        timetablePanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Creating 4 Timetable Cards
        for (int i = 1; i <= 4; i++) {
            timetablePanel.add(createTimetableCard("Timetable " + i));
        }

        // Main Layout
        add(topPanel, BorderLayout.NORTH);
        add(timetablePanel, BorderLayout.CENTER);

        setVisible(true);
    }

    private JPanel createTimetableCard(String title) {
        JPanel card = new JPanel();
        card.setLayout(new BorderLayout());
        card.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        card.setPreferredSize(new Dimension(300, 150));
        card.setBackground(new Color(173, 216, 230)); // Light Blue

        JLabel titleLabel = new JLabel(title, SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 14));
        titleLabel.setForeground(Color.BLACK);

        JLabel detailsLabel = new JLabel("Year 2024-25 | Discipline | Semester", SwingConstants.CENTER);
        detailsLabel.setOpaque(true);
        detailsLabel.setBackground(Color.BLACK);
        detailsLabel.setForeground(Color.WHITE);

        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        bottomPanel.setBackground(new Color(173, 216, 230)); // Match card background
        JButton editButton = new JButton("✏️");
        JButton deleteButton = new JButton("🗑");

        bottomPanel.add(editButton);
        bottomPanel.add(deleteButton);

        card.add(titleLabel, BorderLayout.NORTH);
        card.add(detailsLabel, BorderLayout.CENTER);
        card.add(bottomPanel, BorderLayout.SOUTH);

        return card;
    }

    // Open Timetable Page
    private void openAddTimetablePage() {
        new AddTimetablePage(); // Assuming you have a TimetablePage class
        dispose(); // Close the current dashboard
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TimeTableDashboard());
    }
}
