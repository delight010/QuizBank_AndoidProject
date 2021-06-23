package com.aosproject.project_team6.Bean;

public class StudentMyPage {
    private String sid;
    private String sname;
    private String ssignupdate;
    private String sdeletedate;
    private String supdatedate;
    private String sdivision;

    public StudentMyPage(String sid, String sdivision) {
        this.sid = sid;
        this.sdivision = sdivision;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getSdivision() {
        return sdivision;
    }

    public void setSdivision(String sdivision) {
        this.sdivision = sdivision;
    }
}
