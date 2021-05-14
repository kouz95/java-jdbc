import domain.model.*;
import infra.ConnectionFactory;
import infra.JdbcArticleRepository;
import infra.JdbcFavoriteRepository;
import infra.JdbcMemberRepository;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.stream.LongStream;

public class Application {

    private static final int FIXTURE_COUNT = 100_000;
    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
        Connection connection = ConnectionFactory.create();

        MemberRepository memberRepository = new JdbcMemberRepository(connection);
        ArticleRepository articleRepository = new JdbcArticleRepository(connection);
        FavoriteRepository favoriteRepository = new JdbcFavoriteRepository(connection);

        LongStream.rangeClosed(1, FIXTURE_COUNT)
                .mapToObj(l -> new Member(l, "avatar-" + l, "nickname", "password-" + l))
                .forEach(memberRepository::save);

        LongStream.rangeClosed(1, FIXTURE_COUNT)
                .mapToObj(l -> new Article(l, "category", "contents-" + l, 10_000, (long) (RANDOM.nextInt(FIXTURE_COUNT) + 1), LocalDateTime.now(), LocalDateTime.now()))
                .forEach(articleRepository::save);

        LongStream.rangeClosed(1, FIXTURE_COUNT)
                .mapToObj(l -> new Favorite(l, (long) RANDOM.nextInt(FIXTURE_COUNT) + 1, (long) RANDOM.nextInt(FIXTURE_COUNT) + 1))
                .forEach(favoriteRepository::save);

        try {
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
