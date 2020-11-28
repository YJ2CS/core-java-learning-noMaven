package progressMonitorInputStream;

import java.awt.*;
import javax.swing.*;

/**
 * A program to test a progress monitor input stream.
 *
 * @author Cay Horstmann
 * @version 1.07 2018-05-01
 */
public class ProgressMonitorInputStreamTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(() ->
        {
            var frame = new TextFrame();
            frame.setTitle("ProgressMonitorInputStreamTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
