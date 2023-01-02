package hr.algebra.dal;

import hr.algebra.dal.sql.SQLRepository;

public class RepositoryFactory {
    private RepositoryFactory() {}
    
    public static Repository getRepository() throws Exception {
        return new SQLRepository();
    }
}