package pl.sdacademy.main;

import pl.sdacademy.Providers.DaoProvider;
import pl.sdacademy.dao.MemberDao;
import pl.sdacademy.dao.RunDao;
import pl.sdacademy.database.jdbc.utils.JdbcUtils;
import pl.sdacademy.jdbc.JdbcRunDaoImpl;

import java.sql.*;
import java.util.Properties;
import java.util.UUID;

import static java.lang.Math.random;

public class Main {

    public static void main(String[] args) throws SQLException {

       // RunDao runDao = new JdbcRunDaoImpl();

       // System.out.println(runDao.findById(3l));
        //System.out.println(runDao.findAll());




//        String connectionString = "jdbc:mysql://localhost:3306/baza_testowa";
//        String dbPassword = "password";
//        String dbUser = "pawel";
//        String connectionOptions = "?serverTimezone=UTC&useSSL=false&createDatabaseIfNotExist=true&allowPublicKeyRetrieval=true";
//
//        Properties prop = new Properties();
//        prop.put("password", dbPassword);
//        prop.put("user", dbUser);
//
//
//        Connection connection = DriverManager.getConnection(connectionString+connectionOptions, prop);

        //insertRun(2,"Bieg2", "kraków", new java.util.Date(), new java.util.Date(), 34);
//deleteRun(2);
        //insertRandomIntoRuns();
        //deleteAllTheRuns();
        //updateRun(3,"Bieg2", "kraków", new java.util.Date(), new java.util.Date(), 34);

       RunDao rundao = DaoProvider.getInstance().getRundao();
        MemberDao memberDao = DaoProvider.getInstance().getMemberDao();

//        long memberid = 1;
//        for(int i= 10; i<40;  i++) {
//            Run run = new Run();
//            run.setId((long) i);
//            run.setName(UUID.randomUUID().toString());
//            run.setStartDate(new java.util.Date());
//            run.setStartTime(new java.util.Date());
//            run.setMembersLimit(100);
//            rundao.save(run);
//            for(int j=0;j<10;j++){
//                Member member = new Member();
//                member.setId(memberid++);
//                member.setName(UUID.randomUUID().toString());
//                member.setRunId(Math.toIntExact(run.getId()));
//                member.setStartNumber(j+69);
//
//                memberDao.save(member);
//
//            }
//        }




    }

    private static void insertRun(Integer id, String name, String place, java.util.Date startDate, java.util.Date startTime, Integer membersLimit) throws SQLException {
        Connection connection = JdbcUtils.getInstance().getConnection();

        PreparedStatement statement = connection
                .prepareStatement("insert into runs " +
                        "(id, name, place, start_time, start_date, members_limit) values (?, ?, ?, ?, ?, ?)");

        java.sql.Date sqlStartDate = new Date(startDate.getTime());
        java.sql.Date sqlStartTime = new Date(startTime.getTime());

        statement.setInt(1, id);
        statement.setString(2, name);
        statement.setString(3, place);
        statement.setDate(4, sqlStartDate);
        statement.setDate(5, sqlStartTime);
        statement.setInt(6, membersLimit);

        statement.executeUpdate();
    }

    private static void deleteRun(Integer id) throws SQLException {
        Connection connection = JdbcUtils.getInstance().getConnection();

        PreparedStatement statement = connection
                .prepareStatement("Delete from runs where id=?");

        statement.setInt(1, id);
        statement.executeUpdate();
    }

    private static void insertRandomIntoRuns() throws SQLException {

        //UUID.randomUUID().toString()

        Connection connection = JdbcUtils.getInstance().getConnection();

        String name = UUID.randomUUID().toString();
        for (int i = 0; i <= 10; i++) {
            PreparedStatement statement = connection
                    .prepareStatement("insert into runs " +
                            "(id, NAME) values (?, ?)");

            statement.setInt(1, (int) (Math.random() * 100));
            statement.setString(2, name);
            statement.executeUpdate();
        }
    }


    private static void deleteAllTheRuns() throws SQLException {
        Connection connection = JdbcUtils.getInstance().getConnection();

        PreparedStatement statement = connection
                .prepareStatement("Delete from runs");


        statement.executeUpdate();
    }

    private static void updateRun(Integer id,
                                  String name,
                                  String place,
                                  java.util.Date startDate,
                                  java.util.Date startTime,
                                  Integer membersLimit)
            throws SQLException {

        Connection connection = JdbcUtils.getInstance().getConnection();
        PreparedStatement statement = connection
                .prepareStatement("update runs set name=?, place=?, start_time=?, start_date=?, members_limit=? where id=?");

        java.sql.Date sqlStartDate = new Date(startDate.getTime());
        java.sql.Date sqlStartTime = new Date(startTime.getTime());

        statement.setString(1, name);
        statement.setString(2, place);
        statement.setDate(3, sqlStartDate);
        statement.setDate(4, sqlStartTime);
        statement.setInt(5, membersLimit);
        statement.setInt(6, id);

        statement.executeUpdate();

    }
}
