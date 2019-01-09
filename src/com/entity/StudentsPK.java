package com.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class StudentsPK  implements Serializable {

    @Column(length = 18)
    private String id; // 身份证号码
    @Column(length = 8)
    private String sid; // 学号

    public StudentsPK(){

    }

    public StudentsPK(String id, String sid) {
        this.id = id;
        this.sid = sid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentsPK that = (StudentsPK) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(sid, that.sid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sid);
    }
}
