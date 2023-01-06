package hr.algebra.dal.sql;

import hr.algebra.dal.Repository;
import hr.algebra.model.Article;
import hr.algebra.model.Category;
import hr.algebra.model.User;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.sql.DataSource;

public class SQLRepository implements Repository {
    private static final String ID_CATEGORY = "IDCategory";
    private static final String NAME = "Name";
    
    private static final String ID_USER = "IDUser";
    private static final String USERNAME = "Username";
    private static final String PASSWORD = "Password";
    private static final String ROLE_ID = "RoleID";
    
    private static final String ID_ARTICLE = "IDArticle";
    private static final String TITLE = "Title";
    private static final String LINK = "Link";
    private static final String DESCRIPTION = "Description";
    private static final String PICTURE_PATH = "PicturePath";
    private static final String PUBLISHED_DATE = "PublishedDate";
    private static final String CATEGORY_ID = "CategoryID";

    private static final String CREATE_CATEGORY = "{ CALL createCategory (?,?) }";
    private static final String UPDATE_CATEGORY = "{ CALL updateCategory (?,?) }";
    private static final String DELETE_CATEGORY = "{ CALL deleteCategory (?) }";
    private static final String DELETE_ALL_CATEGORIES = "{ CALL deleteAllCategories }";
    private static final String SELECT_CATEGORY_BY_ID = "{ CALL selectCategoryByID (?) }";
    private static final String SELECT_CATEGORY_BY_NAME = "{ CALL selectCategoryByName (?) }";
    private static final String SELECT_CATEGORIES = "{ CALL selectCategories }";
    
    private static final String CREATE_USER = "{ CALL createUser (?,?,?,?) }";
    private static final String UPDATE_USER = "{ CALL updateUser (?,?,?,?) }";
    private static final String DELETE_USER_BY_ID = "{ CALL deleteUserByID (?) }";
    private static final String DELETE_USER_BY_USERNAME = "{ CALL deleteUserByUsername (?) }";
    private static final String SELECT_USER_BY_ID = "{ CALL selectUserByID (?) }";
    private static final String SELECT_USER_BY_USERNAME = "{ CALL selectUserByUsername (?) }";
    private static final String SELECT_USERS = "{ CALL selectUsers }";
    private static final String CHECK_IF_USER_EXISTS = "{ CALL checkIfUserExists (?,?) }";
    
    private static final String CREATE_ARTICLE = "{ CALL createArticle (?,?,?,?,?,?) }";
    private static final String UPDATE_ARTICLE = "{ CALL updateArticle (?,?,?,?,?,?) }";
    private static final String DELETE_ARTICLE = "{ CALL deleteArticle (?) }";
    private static final String DELETE_ALL_ARTICLES = "{ CALL deleteAllArticles }";
    private static final String SELECT_ARTICLE = "{ CALL selectArticle (?) }";
    private static final String SELECT_ARTICLES = "{ CALL selectArticles }";

    @Override
    public int createArticle(Article article) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(CREATE_ARTICLE)) {

            stmt.setString("@" + TITLE, article.getTitle());
            stmt.setString("@" + LINK, article.getLink());
            stmt.setString("@" + DESCRIPTION, article.getDescription());
            stmt.setString("@" + PICTURE_PATH, article.getPicturePath());
            stmt.setString("@" + PUBLISHED_DATE, article.getPublishedDate().format(Article.DATE_FORMATTER));
            stmt.setInt("@" + CATEGORY_ID, article.getCategoryId());
            stmt.registerOutParameter("@" + ID_ARTICLE, Types.INTEGER);

            stmt.executeUpdate();
            
            return stmt.getInt("@" + ID_ARTICLE);
        }
    }

    @Override
    public void createArticles(List<Article> articles) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(CREATE_ARTICLE)) {

            for (Article article : articles) {
                stmt.setString("@" + TITLE, article.getTitle());
                stmt.setString("@" + LINK, article.getLink());
                stmt.setString("@" + DESCRIPTION, article.getDescription());
                stmt.setString("@" + PICTURE_PATH, article.getPicturePath());
                stmt.setString("@" + PUBLISHED_DATE, article.getPublishedDate().format(Article.DATE_FORMATTER));
                stmt.setInt("@" + CATEGORY_ID, article.getCategoryId());
                stmt.registerOutParameter("@" + ID_ARTICLE, Types.INTEGER);

                stmt.executeUpdate();
            }
        }
    }

    @Override
    public void updateArticle(int id, Article data) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(UPDATE_ARTICLE)) {

            stmt.setString("@" + TITLE, data.getTitle());
            stmt.setString("@" + LINK, data.getLink());
            stmt.setString("@" + DESCRIPTION, data.getDescription());
            stmt.setString("@" + PICTURE_PATH, data.getPicturePath());
            stmt.setString("@" + PUBLISHED_DATE, data.getPublishedDate().format(Article.DATE_FORMATTER));
            stmt.setInt("@" + CATEGORY_ID, data.getCategoryId());
            stmt.setInt("@" + ID_ARTICLE, id);

            stmt.executeUpdate();
        }
    }

    @Override
    public void deleteArticle(int id) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(DELETE_ARTICLE)) {

            stmt.setInt("@" + ID_ARTICLE, id);

            stmt.executeUpdate();
        }
    }

    @Override
    public void deleteAllArticles() throws Exception {
        simpleDatabaseCall(DELETE_ALL_ARTICLES);
    }
    
    @Override
    public Optional<Article> selectArticle(int id) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(SELECT_ARTICLE)) {

            stmt.setInt("@" + ID_ARTICLE, id);
            try (ResultSet rs = stmt.executeQuery()) {

                if (rs.next()) {
                    return Optional.of(new Article(
                            rs.getInt(ID_ARTICLE),
                            rs.getString(TITLE),
                            rs.getString(LINK),
                            rs.getString(DESCRIPTION),
                            rs.getString(PICTURE_PATH),
                            LocalDateTime.parse(rs.getString(PUBLISHED_DATE), Article.DATE_FORMATTER),
                            rs.getInt(CATEGORY_ID))
                    );
                }
            }
        }
        
        return Optional.empty();
    }

    @Override
    public List<Article> selectArticles() throws Exception {
        List<Article> articles = new ArrayList<>();
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(SELECT_ARTICLES);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {                
                articles.add(new Article(
                        rs.getInt(ID_ARTICLE),
                        rs.getString(TITLE),
                        rs.getString(LINK),
                        rs.getString(DESCRIPTION),
                        rs.getString(PICTURE_PATH),
                        LocalDateTime.parse(rs.getString(PUBLISHED_DATE), Article.DATE_FORMATTER),
                        rs.getInt(CATEGORY_ID))
                );
            }
        }
        
        return articles;
    }

    @Override
    public int createUser(String username, String password, int role) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(CREATE_USER)) {
            stmt.setString(1, username);
            stmt.setString(2, password);
            stmt.setInt(3, role);
            stmt.registerOutParameter(4, Types.INTEGER);
            stmt.executeUpdate();
            
            return stmt.getInt(4);
        }
    }

    @Override
    public void updateUser(int id, User data) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(UPDATE_USER)) {

            stmt.setString("@" + USERNAME, data.getUsername());
            stmt.setString("@" + PASSWORD, data.getPassword());
            stmt.setInt("@" + ROLE_ID, data.getRoleID());
            stmt.setInt("@" + ID_USER, id);

            stmt.executeUpdate();
        }
    }
    
    @Override
    public void deleteUserByID(int id) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(DELETE_USER_BY_ID)) {

            stmt.setInt("@" + ID_USER, id);
            
            stmt.executeUpdate();
        }
    }
    
    @Override
    public void deleteUserByUsername(String username) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(DELETE_USER_BY_USERNAME)) {

            stmt.setString("@" + USERNAME, username);
            
            stmt.executeUpdate();
        }
    }
    
    @Override
    public Optional<User> selectUserByID(int id) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(SELECT_USER_BY_ID)) {

            stmt.setInt("@" + ID_USER, id);
            
            try (ResultSet rs = stmt.executeQuery()) {

                if (rs.next()) {
                    return Optional.of(new User(
                            rs.getInt(ID_USER),
                            rs.getString(USERNAME),
                            rs.getString(PASSWORD),
                            rs.getInt(ROLE_ID)
                    ));
                }
            }
        }
        
        return Optional.empty();
    }
    
    @Override
    public Optional<User> selectUserByUsername(String username) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(SELECT_USER_BY_USERNAME)) {

            stmt.setString("@" + USERNAME, username);
            
            try (ResultSet rs = stmt.executeQuery()) {

                if (rs.next()) {
                    return Optional.of(new User(
                            rs.getInt(ID_USER),
                            rs.getString(USERNAME),
                            rs.getString(PASSWORD),
                            rs.getInt(ROLE_ID)
                    ));
                }
            }
        }
        
        return Optional.empty();
    }
    
    @Override
    public List<User> selectUsers() throws Exception {
        List<User> users = new ArrayList<>();
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(SELECT_USERS);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                users.add(new User(
                        rs.getInt(ID_USER),
                        rs.getString(USERNAME),
                        rs.getString(PASSWORD),
                        rs.getInt(ROLE_ID)
                ));
            }
        }
        
        return users;
    }
    
    @Override
    public int checkIfUserExists(String username) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(CHECK_IF_USER_EXISTS)) {
            stmt.setString(1, username);
            stmt.registerOutParameter(2, Types.INTEGER);
            stmt.executeUpdate();
            
            return stmt.getInt(2);
        }
    }

    @Override
    public int createCategory(String name) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(CREATE_CATEGORY)) {
            stmt.setString(1, name);
            stmt.registerOutParameter(2, Types.INTEGER);
            stmt.executeUpdate();
            
            return stmt.getInt(2);
        }
    }

    @Override
    public void updateCategory(int id, Category data) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(UPDATE_CATEGORY)) {

            stmt.setString("@" + NAME, data.getName());
            stmt.setInt("@" + ID_CATEGORY, id);

            stmt.executeUpdate();
        }
    }

    @Override
    public void deleteCategory(int id) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(DELETE_CATEGORY)) {

            stmt.setInt("@" + ID_CATEGORY, id);

            stmt.executeUpdate();
        }
    }

    @Override
    public void deleteAllCategories() throws Exception {
        simpleDatabaseCall(DELETE_ALL_CATEGORIES);
    }

    @Override
    public Optional<Category> selectCategoryByID(int id) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(SELECT_CATEGORY_BY_ID)) {

            stmt.setInt("@" + ID_CATEGORY, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(new Category(
                            rs.getInt(ID_CATEGORY),
                            rs.getString(NAME))
                    );
                }
            }
        }
        
        return Optional.empty();
    }

    @Override
    public Optional<Category> selectCategoryByName(String name) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(SELECT_CATEGORY_BY_NAME)) {

            stmt.setString("@" + NAME, name);
            
            try (ResultSet rs = stmt.executeQuery()) {

                if (rs.next()) {
                    return Optional.of(new Category(
                            rs.getInt(ID_CATEGORY),
                            rs.getString(NAME)
                    ));
                }
            }
        }
        
        return Optional.empty();
    }
    
    @Override
    public List<Category> selectCategories() throws Exception {
        List<Category> categories = new ArrayList<>();
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(SELECT_CATEGORIES);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                categories.add(new Category(
                        rs.getInt(ID_CATEGORY),
                        rs.getString(NAME))
                );
            }
        }
        
        return categories;
    }
    
    private void simpleDatabaseCall(String procedureCall) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(procedureCall)) {

            stmt.executeUpdate();
        }
    }
}