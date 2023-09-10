package com.anonymity.topictalks.repositories;

import com.anonymity.topictalks.entities.message.Participant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IParticipantRepository extends JpaRepository<Participant, Long> {
}
