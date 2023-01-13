package hr.algebra.view.model;

import hr.algebra.model.Category;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class CategoryTableModel extends AbstractTableModel {
    private static final String[] COLUMN_NAMES = {"ID", "Name"};
    
    private List<Category> categories;

    public CategoryTableModel(List<Category> categories) {
        this.categories = categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
        fireTableDataChanged();
    }
    
    @Override
    public int getRowCount() {
        return categories.size();
    }

    @Override
    public int getColumnCount() {
        return Category.class.getDeclaredFields().length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return categories.get(rowIndex).getId();
            case 1:
                return categories.get(rowIndex).getName();
            default:
                throw new RuntimeException("No such column");
        }
    }

    @Override
    public String getColumnName(int column) {
        return COLUMN_NAMES[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch(columnIndex) {
            case 0:
                return Integer.class;
        }
        
        return super.getColumnClass(columnIndex); 
    }
}