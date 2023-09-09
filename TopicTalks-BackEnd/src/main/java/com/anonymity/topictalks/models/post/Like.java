package com.anonymity.topictalks.models.post;

import com.anonymity.topictalks.models.audit.DateAudit;
import com.anonymity.topictalks.models.user.User;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "`like`")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class Like extends DateAudit {

    @EmbeddedId
    private LikeKey id = new LikeKey();

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private User userInfo;

    @ManyToOne
    @MapsId("postId")
    @JoinColumn(name = "post_id")
    private Post postInfo;

}
