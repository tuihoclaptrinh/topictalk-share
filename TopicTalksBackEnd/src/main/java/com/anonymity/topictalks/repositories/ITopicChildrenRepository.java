package com.anonymity.topictalks.repositories;

import com.anonymity.topictalks.entities.topic.TopicChildren;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITopicChildrenRepository extends JpaRepository<TopicChildren, Long> {
}
