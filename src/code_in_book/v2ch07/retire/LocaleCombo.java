package retire;

import java.text.*;
import java.util.*;

import javax.swing.*;
import javax.swing.event.*;

/**
 * This combo box lets a user pick a locale. The locales are displayed in the locale of the
 * combo box, and sorted according to the collator of the display locale.
 *
 * @author Cay Horstmann
 * @version 1.01 2018-05-06
 */
public class LocaleCombo extends JComboBox<Locale> {
    private int selected;
    private final Locale[] locales;
    private ListCellRenderer<Locale> renderer;
    
    /**
     * Constructs a locale combo that displays an immutable collection of locales.
     *
     * @param locales the locales to display in this combo box
     */
    public LocaleCombo(Locale[] locales) {
        this.locales = locales.clone();
        sort();
        setSelectedItem(getLocale());
    }
    
    @Override
    public void setLocale(Locale newValue) {
        super.setLocale(newValue);
        sort();
    }
    
    private void sort() {
        Locale loc = getLocale();
        Collator collator = Collator.getInstance(loc);
        Comparator<Locale> comp =
                (a, b) -> collator.compare(a.getDisplayName(loc), b.getDisplayName(loc));
        Arrays.sort(locales, comp);
        setModel(new ComboBoxModel<Locale>() {
            @Override
            public Locale getElementAt(int i) {
                return locales[i];
            }
            
            @Override
            public int getSize() {
                return locales.length;
            }
            
            @Override
            public void addListDataListener(ListDataListener l) {
            }
            
            @Override
            public void removeListDataListener(ListDataListener l) {
            }
            
            @Override
            public Locale getSelectedItem() {
                return selected >= 0 ? locales[selected] : null;
            }
            
            @Override
            public void setSelectedItem(Object anItem) {
                if (anItem == null) {
                    selected = -1;
                } else {
                    selected = Arrays.binarySearch(locales, (Locale) anItem, comp);
                }
            }
            
        });
        setSelectedItem(selected);
    }
    
    @Override
    public ListCellRenderer<Locale> getRenderer() {
        if (renderer == null) {
            @SuppressWarnings("unchecked") var originalRenderer
                    = (ListCellRenderer<Object>) super.getRenderer();
            if (originalRenderer == null) {
                return null;
            }
            renderer = (list, value, index, isSelected, cellHasFocus) ->
                    originalRenderer.getListCellRendererComponent(list,
                            value.getDisplayName(getLocale()), index, isSelected, cellHasFocus);
        }
        return renderer;
    }
    
    @Override
    public void setRenderer(ListCellRenderer<? super Locale> newValue) {
        renderer = null;
        super.setRenderer(newValue);
    }
}
