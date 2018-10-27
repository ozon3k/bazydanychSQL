package pl.sdacademy.dao;

import pl.sdacademy.main.Member;

import java.sql.SQLException;
import java.util.List;

public interface MemberDao {
    void save(Member run) throws SQLException;
    Member findById(Long id) throws SQLException;
    List<Member> findAll() throws SQLException;
    void update(Member member) throws SQLException;
    void delete(Long id) throws SQLException;
}
