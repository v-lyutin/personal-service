package com.dev.internal.personal.team.repository;

import com.dev.internal.personal.department.model.Department;
import com.dev.internal.personal.team.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;
import java.util.UUID;

@Repository
public interface TeamRepository extends JpaRepository<Team, UUID> {
    Set<Team> findAllByDepartment(Department department);
}
