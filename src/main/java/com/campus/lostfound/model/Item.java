package com.campus.lostfound.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "item_type")
public abstract class Item {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    @Column(nullable=false) private String itemName;
    @Enumerated(EnumType.STRING) private Category category;
    private LocalDate eventDate;
    private String location;
    private String photoPath;
    @Column(length=2000) private String privateDescription;
    @ManyToOne(optional=false) private User reporter;
    private LocalDateTime submittedAt;
    @Enumerated(EnumType.STRING) private ReportStatus status = ReportStatus.OPEN;

    protected Item() {}
    protected Item(String itemName, Category category, LocalDate eventDate, String location, String privateDescription, User reporter) {
        this.itemName=itemName; this.category=category; this.eventDate=eventDate; this.location=location; this.privateDescription=privateDescription; this.reporter=reporter; this.submittedAt=LocalDateTime.now();
    }
    public abstract String getReportType();
    public abstract String getActionLabel();
    public boolean matchesKeyword(String keyword) { return keyword == null || keyword.isBlank() || itemName.toLowerCase().contains(keyword.toLowerCase()) || (privateDescription != null && privateDescription.toLowerCase().contains(keyword.toLowerCase())); }
    public Long getId(){return id;} public String getItemName(){return itemName;} public void setItemName(String v){itemName=v;} public Category getCategory(){return category;} public void setCategory(Category v){category=v;} public LocalDate getEventDate(){return eventDate;} public void setEventDate(LocalDate v){eventDate=v;} public String getLocation(){return location;} public void setLocation(String v){location=v;} public String getPhotoPath(){return photoPath;} public void setPhotoPath(String v){photoPath=v;} public String getPrivateDescription(){return privateDescription;} public void setPrivateDescription(String v){privateDescription=v;} public User getReporter(){return reporter;} public void setReporter(User v){reporter=v;} public LocalDateTime getSubmittedAt(){return submittedAt;} public void setSubmittedAt(LocalDateTime v){submittedAt=v;} public ReportStatus getStatus(){return status;} public void setStatus(ReportStatus v){status=v;}
}
