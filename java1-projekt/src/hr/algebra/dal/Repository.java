package hr.algebra.dal;

import hr.algebra.model.Article;
import hr.algebra.model.User;
import java.util.List;
import java.util.Optional;

public interface Repository {
    int checkIfUserExists(String username) throws Exception;
    int createUser(String username, String password, int role) throws Exception;
    void deleteUserByID(int id) throws Exception;
    void deleteUserByUsername(String username) throws Exception;
    Optional<User> selectUserByID(int id) throws Exception;
    Optional<User> selectUserByUsername(String username) throws Exception;
    List<User> selectUsers() throws Exception;
    
    int createArticle(Article article) throws Exception;
    void createArticles(List<Article> articles) throws Exception;    
    void updateArticle(int id, Article data) throws Exception;
    void deleteArticle(int id) throws Exception;
    void deleteAllArticles() throws Exception;
    Optional<Article> selectArticle(int id) throws Exception;
    List<Article> selectArticles() throws Exception;
}