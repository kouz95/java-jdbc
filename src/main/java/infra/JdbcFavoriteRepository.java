package infra;

import domain.model.Favorite;
import domain.model.FavoriteRepository;

import java.sql.Connection;

public class JdbcFavoriteRepository implements FavoriteRepository {
    private final Connection connection;

    public JdbcFavoriteRepository(Connection connection) {
        this.connection = connection;
    }


    @Override
    public void save(Favorite favorite) {

    }
}
