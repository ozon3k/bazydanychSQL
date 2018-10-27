package pl.sdacademy.Providers;

import pl.sdacademy.dao.MemberDao;
import pl.sdacademy.dao.RunDao;
import pl.sdacademy.jdbc.JdbcMemberDaoImpl;
import pl.sdacademy.jdbc.JdbcRunDaoImpl;

public class DaoProvider {
    private static final DaoProvider instance = new DaoProvider();
     private RunDao rundao;
     private MemberDao memberDao;

     private DaoProvider(){
         rundao = new JdbcRunDaoImpl();
         memberDao = new JdbcMemberDaoImpl();

     }

    public static DaoProvider getInstance() {
        return instance;
    }

    public RunDao getRundao() {
        return rundao;
    }

    public MemberDao getMemberDao() {
        return memberDao;
    }
}
