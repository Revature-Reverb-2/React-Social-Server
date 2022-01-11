package com.revature.likes;

import com.revature.posts.Post;
import com.revature.users.User;
import lombok.*;

import javax.persistence.*;
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "likesTable")
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "post_id", referencedColumnName = "post_id")
    private Post post;

    @ManyToOne
    @JoinColumn(name = "liker_id", referencedColumnName = "user_id")
    private User user;

}
