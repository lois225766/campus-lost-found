package com.campus.lostfound.repository;
import com.campus.lostfound.model.*; import org.springframework.data.jpa.repository.*; import java.util.*;
public interface ItemRepository extends JpaRepository<Item,Long> { List<Item> findAllByOrderBySubmittedAtDesc(); List<Item> findByReporterOrderBySubmittedAtDesc(User reporter); }
