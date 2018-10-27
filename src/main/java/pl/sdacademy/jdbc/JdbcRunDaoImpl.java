package pl.sdacademy.jdbc;

import pl.sdacademy.main.Member;
import pl.sdacademy.main.Run;
import pl.sdacademy.dao.RunDao;
import pl.sdacademy.database.jdbc.utils.JdbcUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcRunDaoImpl implements RunDao {
    public JdbcRunDaoImpl() throws SQLException {
    }

    public void save(Run run) throws SQLException {
        Connection connection = JdbcUtils.getInstance().getConnection();

        PreparedStatement statement = connection
                .prepareStatement("insert into runs " +
                        "(id, name, place, start_time, start_date, members_limit) values (?, ?, ?, ?, ?, ?)");

        java.sql.Date sqlStartDate = new Date(run.getStartDate().getTime());
        java.sql.Date sqlStartTime = new Date(run.getStartTime().getTime());

        statement.setLong(1, run.getId());
        statement.setString(2, run.getName());
        statement.setString(3, run.getPlace());
        statement.setDate(4, sqlStartDate);
        statement.setDate(5, sqlStartTime);
        statement.setInt(6, run.getMembersLimit());

        statement.executeUpdate();
    }

    public Run findById(Long id) throws SQLException {
        Run run = new Run();
        Connection connection = JdbcUtils.getInstance().getConnection();
        PreparedStatement statement = connection
                .prepareStatement("select * from runs where ID=?");

        statement.setLong(1, id);
        ResultSet result = statement.executeQuery();
if (result.next()) {
    run.setId(result.getLong("id"));
    run.setName(result.getString("name"));
    run.setPlace(result.getString("place"));
    run.setStartDate(result.getDate("start_date"));
    run.setStartTime(result.getTime("start_time"));
    run.setMembersLimit(result.getInt("members_limit"));
}

        return run;
    }

    public List<Run> findAll() throws SQLException {

        Connection connection = JdbcUtils.getInstance().getConnection();
        PreparedStatement statement = connection
                .prepareStatement("select * from runs");

        ResultSet result = statement.executeQuery();

        List<Run> lista = new ArrayList<Run>();
        while(result.next()){
            Run run = new Run();
            run.setId(result.getLong("id"));
            run.setName(result.getString("name"));
            run.setPlace(result.getString("place"));
            run.setStartDate(result.getDate("start_date"));
            run.setStartTime(result.getTime("start_time"));
            run.setMembersLimit(result.getInt("members_limit"));
            lista.add(run);
        }
        return lista;
    }

    private List<Member> getMembersList (Long runId) throws SQLException{


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

    public void update(Run run) throws SQLException {
        Connection connection = JdbcUtils.getInstance().getConnection();
        PreparedStatement statement = connection
                .prepareStatement("update runs set name=?, place=?, start_time=?, start_date=?, members_limit=? where id=?");

        java.sql.Date sqlStartDate = new Date(run.getStartDate().getTime());
        java.sql.Date sqlStartTime = new Date(run.getStartTime().getTime());

        statement.setString(1, run.getName());
        statement.setString(2, run.getPlace());
        statement.setDate(3, sqlStartDate);
        statement.setDate(4, sqlStartTime);
        statement.setInt(5, run.getMembersLimit());
        statement.setLong(6, run.getId());

        statement.executeUpdate();

    }

    public void delete(Long id) throws SQLException {

        Connection connection = JdbcUtils.getInstance().getConnection();

        PreparedStatement statement = connection
                .prepareStatement("Delete from runs where id=?");

        statement.setLong(1, id);
        statement.executeUpdate();

    }
}
