package com.happenings.repository;

import com.happenings.entity.UserCategory;
import com.happenings.entity.UserCategoryId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserCategoryRepository extends JpaRepository<UserCategory, UserCategoryId> {
  List<UserCategory> findByUserId(Integer userId);
}
