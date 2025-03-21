import java.awt.*;
import javax.swing.*;

public class TimetablePage extends JFrame {

    public TimetablePage() {
        setTitle("Create Timetable");
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));
        setLocationRelativeTo(null); // Center window

        // 🔹 Set the whole background to a darker teal
        Color darkTeal = new Color(0, 96, 128); // Dark Teal
        Color lightTeal = new Color(160, 210, 220); // Light Teal
        getContentPane().setBackground(darkTeal);

        // 🔹 Sidebar (Courses List)
        JPanel sidebar = new JPanel();
        sidebar.setLayout(new BoxLayout(sidebar, BoxLayout.Y_AXIS));
        sidebar.setPreferredSize(new Dimension(250, getHeight()));
        sidebar.setBackground(new Color(230, 230, 230)); // Light Gray for contrast
        sidebar.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel sidebarTitle = new JLabel("Courses");
        sidebarTitle.setFont(new Font("Arial", Font.BOLD, 18));
        sidebarTitle.setAlignmentX(Component.LEFT_ALIGNMENT);
        sidebar.add(sidebarTitle);

        // 🔹 Updated Course List
        String[] courses = {
            "CE F342: WATER & WASTEWATER TREAT",
            "CE F321: ENGINEERING HYDROLOGY",
            "CE F343: DESIGN OF STEEL STRUCTURES",
            "CS F211: DATA STRUCTURES & ALGO",
            "CS F212: DATABASE MANAGEMENT SYSTEMS",
            "EE F215: MICROPROCESSORS & INTERFACING",
            "ME F241: KINEMATICS OF MACHINES",
            "ME F242: THERMODYNAMICS"
        };

        for (String course : courses) {
            JButton courseButton = new JButton(course);
            courseButton.setAlignmentX(Component.LEFT_ALIGNMENT);
            sidebar.add(courseButton);
        }

        // 🔹 Timetable Grid
        JPanel timetableGrid = new JPanel(new GridLayout(7, 8, 5, 5)); // 7 days, 8 time slots
        timetableGrid.setBackground(darkTeal);
        timetableGrid.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        String[] times = { "8-9", "9-10", "10-11", "11-12", "12-1", "1-2", "2-3", "3-4" };
        String[] days = { "M", "T", "W", "Th", "F", "S" };

        // Add header row (Time slots)
        timetableGrid.add(new JLabel(""));
        for (String time : times) {
            JLabel timeLabel = new JLabel(time, SwingConstants.CENTER);
            timeLabel.setBorder(BorderFactory.createLineBorder(Color.WHITE));
            timeLabel.setOpaque(true);
            timeLabel.setBackground(new Color(0, 140, 170)); // Slightly darker teal for headers
            timeLabel.setForeground(Color.WHITE);
            timetableGrid.add(timeLabel);
        }

        // Add time slots with empty buttons
        for (String day : days) {
            JLabel dayLabel = new JLabel(day, SwingConstants.CENTER);
            dayLabel.setBorder(BorderFactory.createLineBorder(Color.WHITE));
            dayLabel.setOpaque(true);
            dayLabel.setBackground(new Color(0, 140, 170)); // Same as headers
            dayLabel.setForeground(Color.WHITE);
            timetableGrid.add(dayLabel);
            for (int j = 0; j < times.length; j++) {
                JButton slot = new JButton(" ");
                slot.setBorder(BorderFactory.createLineBorder(Color.WHITE));
                slot.setBackground(lightTeal); // Light Teal for time slots
                timetableGrid.add(slot);
            }
        }

        // 🔹 Publish Button
        JButton publishButton = new JButton("Publish");
        publishButton.setBackground(Color.BLACK);
        publishButton.setForeground(Color.WHITE);
        publishButton.setFocusPainted(false);
        publishButton.setFont(new Font("Arial", Font.BOLD, 16));

        // 🔹 Main Layout
        add(sidebar, BorderLayout.WEST);
        add(timetableGrid, BorderLayout.CENTER);
        add(publishButton, BorderLayout.SOUTH);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TimetablePage());
    }
}
