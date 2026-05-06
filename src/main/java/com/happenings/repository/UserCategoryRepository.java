package com.happenings.repository;

import com.happenings.entity.UserCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserCategoryRepository extends JpaRepository<UserCategory, Integer> {
    List<UserCategory> findByUser_Id(Integer userId);
}
