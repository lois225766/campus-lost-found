package com.campus.lostfound.model;
import jakarta.persistence.DiscriminatorValue; import jakarta.persistence.Entity; import java.time.LocalDate;
@Entity @DiscriminatorValue("LOST")
public class LostItem extends Item {
    protected LostItem() {} public LostItem(String n, Category c, LocalDate d, String l, String p, User r){super(n,c,d,l,p,r);}
    @Override public String getReportType(){return "LOST";} @Override public String getActionLabel(){return "I found this";}
}
