package pl.sdacademy.jdbc;

import pl.sdacademy.dao.MemberDao;
import pl.sdacademy.database.jdbc.utils.JdbcUtils;
import pl.sdacademy.main.Member;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcMemberDaoImpl implements MemberDao {
    public void save(Member member) throws SQLException {
        Connection connection = JdbcUtils.getInstance().getConnection();

        PreparedStatement statement = connection
                .prepareStatement("insert into members " +
                        "(id, name, LAST_NAME, START_NUMBER, RUN_ID) values (?, ?, ?, ?, ?)");


        statement.setLong(1, member.getId());
        statement.setString(2, member.getName());
        statement.setString(3, member.getLastName());
        statement.setLong(4, member.getStartNumber());
        statement.setLong(5, member.getRunId());

        statement.executeUpdate();

    }

    public Member findById(Long id) throws SQLException {
        Member member = new Member();
        Connection connection = JdbcUtils.getInstance().getConnection();
        PreparedStatement statement = connection
                .prepareStatement("select * from members where ID=?");

        statement.setLong(1, id);
        ResultSet result = statement.executeQuery();
        if (result.next()) {
            member.setId(result.getLong("id"));
            member.setName(result.getString("name"));
            member.setLastName(result.getString("last_name"));
            member.setStartNumber((int) result.getLong("start_number"));
            member.setRunId((int) result.getLong("run_id"));

        }
        return member;
    }

    public List<Member> findAll() throws SQLException {

        Connection connection = JdbcUtils.getInstance().getConnection();
        PreparedStatement statement = connection
                .prepareStatement("select * from members");

        ResultSet result = statement.executeQuery();

        List<Member> lista = new ArrayList<Member>();
        while(result.next()){
            Member member = new Member();
            member.setId(result.getLong("id"));
            member.setName(result.getString("name"));
            member.setLastName(result.getString("last_name"));
            member.setStartNumber((int) result.getLong("start_number"));
            member.setRunId((int) result.getLong("run_id"));
            lista.add(member);
        }
        return lista;

    }

    public void update(Member member) throws SQLException {
        Connection connection = JdbcUtils.getInstance().getConnection();
        PreparedStatement statement = connection
                .prepareStatement("update members set name=?, LAST_NAME=?, START_NUMBER=?, RUN_ID where id=?");




        statement.setString(1, member.getName());
        statement.setString(2, member.getLastName());
        statement.setLong(3, member.getStartNumber());
        statement.setLong(4, member.getRunId());
        statement.setLong(5, member.getId());


        statement.executeUpdate();

    }

    public void delete(Long id) throws SQLException {
        Connection connection = JdbcUtils.getInstance().getConnection();

        PreparedStatement statement = connection
                .prepareStatement("Delete from members where id=?");

        statement.setLong(1, id);
        statement.executeUpdate();

    }
}
