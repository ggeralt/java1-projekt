package hr.algebra.view.model;

import hr.algebra.model.User;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class UserTableModel extends AbstractTableModel {
    private static final String[] COLUMN_NAMES = {"IDUser", "Username", "Password", "Role"};
    
    private List<User> users;

    public UserTableModel(List<User> users) {
        this.users = users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return users.size();
    }

    @Override
    public int getColumnCount() {
        return User.class.getDeclaredFields().length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return users.get(rowIndex).getId();
            case 1:
                return users.get(rowIndex).getUsername();
            case 2:
                return users.get(rowIndex).getPassword();
            case 3:
                return users.get(rowIndex).getRole();
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