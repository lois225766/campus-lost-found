package com.campus.lostfound.model;
import jakarta.persistence.*; import java.time.LocalDateTime;
@Entity public class DeletionRequest { @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id; @ManyToOne(optional=false) private Item item; @ManyToOne(optional=false) private User requester; private String reason; private LocalDateTime requestedAt=LocalDateTime.now(); private String decision="PENDING";
 protected DeletionRequest(){} public DeletionRequest(Item i,User u,String r){item=i;requester=u;reason=r;} public Long getId(){return id;} public Item getItem(){return item;} public User getRequester(){return requester;} public String getReason(){return reason;} public LocalDateTime getRequestedAt(){return requestedAt;} public String getDecision(){return decision;} public void setDecision(String d){decision=d;}
}
