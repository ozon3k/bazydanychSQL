package pl.sdacademy.main;

import pl.sdacademy.database.jdbc.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Run {
    private Long id;
    private String name;
    private String place;
    private Date startDate;
    private Date startTime;
    private Integer membersLimit;
    private List<Member> membersList = new ArrayList();

    public void setMembersList(List<Member> membersList) {
        this.membersList = membersList;
    }

    public List<Member> getMembersList() {
        return membersList;
    }

    public Run() {
    }

    @Override
    public String toString() {
        return "Run{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", place='" + place + '\'' +
                ", startDate=" + startDate +
                ", startTime=" + startTime +
                ", membersLimit=" + membersLimit +
                ", membersList=" + membersList +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Integer getMembersLimit() {
        return membersLimit;
    }

    public void setMembersLimit(Integer membersLimit) {
        this.membersLimit = membersLimit;
    }
}
