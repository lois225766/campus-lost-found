package com.campus.lostfound.model;
import jakarta.persistence.*; import java.util.*;
@Entity @Table(name="users")
public class User {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @Column(unique=true,nullable=false) private String username; @Column(nullable=false) private String password; @Column(nullable=false) private String name; private String semester; private String phone; @Enumerated(EnumType.STRING) private Role role;
 public enum Role { STUDENT, ADMIN }
 protected User(){} public User(String u,String p,String n,String s,String ph,Role r){username=u;password=p;name=n;semester=s;phone=ph;role=r;}
 public Long getId(){return id;} public String getUsername(){return username;} public String getPassword(){return password;} public String getName(){return name;} public String getSemester(){return semester;} public String getPhone(){return phone;} public Role getRole(){return role;}
}
