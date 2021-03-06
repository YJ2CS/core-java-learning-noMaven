package splitPane;

import java.awt.*;
import javax.swing.*;

/**
 * This program demonstrates the split pane component organizer.
 *
 * @author Cay Horstmann
 * @version 1.05 2018-05-01
 */
public class SplitPaneTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(() ->
        {
            var frame = new SplitPaneFrame();
            frame.setTitle("SplitPaneTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
