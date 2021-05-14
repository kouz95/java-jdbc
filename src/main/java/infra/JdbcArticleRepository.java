package infra;

import domain.model.Article;
import domain.model.ArticleRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

public class JdbcArticleRepository implements ArticleRepository {

    private final Connection connection;

    public JdbcArticleRepository(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void save(Article article) {
        String query = "INSERT INTO article VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setLong(1, article.getId());
            preparedStatement.setString(2, article.getCategory());
            preparedStatement.setString(3, article.getContents());
            preparedStatement.setInt(4, article.getPrice());
            preparedStatement.setLong(5, article.getMemberId());
            preparedStatement.setTimestamp(6, Timestamp.valueOf(article.getCreatedTime()));
            preparedStatement.setTimestamp(7, Timestamp.valueOf(article.getModifiedTime()));

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }
}
