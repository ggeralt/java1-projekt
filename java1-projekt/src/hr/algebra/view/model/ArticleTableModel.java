package hr.algebra.view.model;

import hr.algebra.dal.Repository;
import hr.algebra.dal.RepositoryFactory;
import hr.algebra.model.Article;
import hr.algebra.model.Category;
import hr.algebra.utils.MessageUtils;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

public class ArticleTableModel extends AbstractTableModel {
    private static final String[] COLUMN_NAMES = {"ID", "Category", "Title", "Link", "Description", "Picture path", "Published date"};
    
    private List<Article> articles;
    private Repository repository;

    public ArticleTableModel(List<Article> articles) {
        try {
            initRepository();
        } catch (Exception ex) {
            Logger.getLogger(ArticleTableModel.class.getName()).log(Level.SEVERE, null, ex);
            MessageUtils.showErrorMessage("Database Init Error", "Cannot initiate the database.");
            System.exit(1);
        }
        
        this.articles = articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return articles.size();
    }

    @Override
    public int getColumnCount() {
        return Article.class.getDeclaredFields().length - 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return articles.get(rowIndex).getId();
            case 1:
            {
                try {
                    Optional<Category> optCategory = repository.selectCategoryByID(articles.get(rowIndex).getCategoryId());
                    
                    if (optCategory.isPresent()) {
                        return optCategory.get().getName();
                    }
                    
                    return "N/A";
                } catch (Exception ex) {
                    Logger.getLogger(ArticleTableModel.class.getName()).log(Level.SEVERE, null, ex);
                    MessageUtils.showErrorMessage("Get Category Name Error", "Cannot get category names.");
                    System.exit(1);
                }
            }
            case 2:
                return articles.get(rowIndex).getTitle();
            case 3:
                return articles.get(rowIndex).getLink();
            case 4:
                return articles.get(rowIndex).getDescription();
            case 5:
                return articles.get(rowIndex).getPicturePath();
            case 6:
                return articles.get(rowIndex).getPublishedDate().format(Article.DATE_FORMATTER);
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
    
    private void initRepository() throws Exception {
        repository = RepositoryFactory.getRepository();
    }
}