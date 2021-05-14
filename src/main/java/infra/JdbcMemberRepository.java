package infra;

import domain.model.Member;
import domain.model.MemberRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

public class JdbcMemberRepository implements MemberRepository {
    private final Connection connection;

    public JdbcMemberRepository(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void save(Member member) {
        String query = "INSERT INTO member VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setLong(1, member.getId());
            preparedStatement.setString(2, member.getAvatar());
            preparedStatement.setString(3, member.getNickname());
            preparedStatement.setString(4, member.getPassword());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
