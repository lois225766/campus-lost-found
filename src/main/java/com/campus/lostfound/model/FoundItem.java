package com.campus.lostfound.model;
import jakarta.persistence.DiscriminatorValue; import jakarta.persistence.Entity; import java.time.LocalDate;
@Entity @DiscriminatorValue("FOUND")
public class FoundItem extends Item {
    protected FoundItem() {} public FoundItem(String n, Category c, LocalDate d, String l, String p, User r){super(n,c,d,l,p,r);}
    @Override public String getReportType(){return "FOUND";} @Override public String getActionLabel(){return "This may be mine";}
}
