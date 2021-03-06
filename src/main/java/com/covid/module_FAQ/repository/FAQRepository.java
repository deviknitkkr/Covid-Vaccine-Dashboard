package com.covid.module_FAQ.repository;

import com.covid.module_FAQ.entity.FAQ;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FAQRepository extends JpaRepository<FAQ, String> {

}
