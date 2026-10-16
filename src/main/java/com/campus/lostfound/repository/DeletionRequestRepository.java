package com.campus.lostfound.repository; import com.campus.lostfound.model.*; import org.springframework.data.jpa.repository.JpaRepository; import java.util.*;
public interface DeletionRequestRepository extends JpaRepository<DeletionRequest,Long>{List<DeletionRequest> findByRequesterOrderByRequestedAtDesc(User u);}
