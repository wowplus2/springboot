package com.springboot.myjurnal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.springboot.myjurnal.domain.Journal;


public interface JournalRepository extends JpaRepository<Journal, Long> 
{
	//
}
