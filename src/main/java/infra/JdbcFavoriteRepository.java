package infra;

import domain.model.Favorite;
import domain.model.FavoriteRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcFavoriteRepository implements FavoriteRepository {
    private final Connection connection;

    public JdbcFavoriteRepository(Connection connection) {
        this.connection = connection;
    }


    @Override
    public void save(Favorite favorite) {
        String query = "INSERT INTO favorite VALUES (?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setLong(1, favorite.getId());
            preparedStatement.setLong(2, favorite.getMemberId());
            preparedStatement.setLong(3, favorite.getArticleId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
