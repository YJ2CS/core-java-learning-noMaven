package longList;

import java.awt.*;

import javax.swing.*;

/**
 * This frame contains a long word list and a label that shows a sentence made up from the chosen
 * word.
 */
public class LongListFrame extends JFrame {
    private final JList<String> wordList;
    private final JLabel label;
    private final String prefix = "The quick brown ";
    private final String suffix = " jumps over the lazy dog.";
    
    public LongListFrame() {
        wordList = new JList<String>(new WordListModel(3));
        wordList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        wordList.setPrototypeCellValue("www");
        JScrollPane scrollPane = new JScrollPane(wordList);
        
        var p = new JPanel();
        p.add(scrollPane);
        wordList.addListSelectionListener(event -> setSubject(wordList.getSelectedValue()));
        
        Container contentPane = getContentPane();
        contentPane.add(p, BorderLayout.NORTH);
        label = new JLabel(prefix + suffix);
        contentPane.add(label, BorderLayout.CENTER);
        setSubject("fox");
        pack();
    }
    
    /**
     * Sets the subject in the label.
     *
     * @param word the new subject that jumps over the lazy dog
     */
    public void setSubject(String word) {
        var text = new StringBuilder(prefix);
        text.append(word);
        text.append(suffix);
        label.setText(text.toString());
    }
}
