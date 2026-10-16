package com.campus.lostfound.repository; import com.campus.lostfound.model.*; import org.springframework.data.jpa.repository.JpaRepository; import java.util.*;
public interface HandoverRepository extends JpaRepository<Handover,Long>{List<Handover> findByRequesterOrRecipientOrderByScheduledAtDesc(User a,User b);}
