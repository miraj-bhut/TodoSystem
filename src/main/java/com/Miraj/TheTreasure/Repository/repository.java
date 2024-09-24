package com.Miraj.TheTreasure.Repository;

import com.Miraj.TheTreasure.Model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface repository extends JpaRepository<Task, Integer> {

}
