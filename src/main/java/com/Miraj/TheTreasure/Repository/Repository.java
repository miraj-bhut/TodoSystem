package com.Miraj.TheTreasure.Repository;

import com.Miraj.TheTreasure.Model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Repository extends JpaRepository<Task, Integer> {

}
