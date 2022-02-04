package com.app.socialnetwork.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.socialnetwork.entity.Permission;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, Integer> {

	@Modifying
	@Query(value="Update Permission s set s.permissionTitle = :title  where s.permissionId = :id")
	public int updatePermission(@Param("title") String permissionTitle, @Param("id") int permissionId);

}
