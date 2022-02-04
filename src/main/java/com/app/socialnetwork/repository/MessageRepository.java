package com.app.socialnetwork.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.socialnetwork.entity.Message;
@Repository
public interface MessageRepository extends JpaRepository<Message, Integer> {
	@Modifying
	@Query(value="Update Message s set s.messageDescription = :description  where s.messageId = :id")
	public int updateMessage(@Param("description") String messageDescription, @Param("id") int messageId);

}
