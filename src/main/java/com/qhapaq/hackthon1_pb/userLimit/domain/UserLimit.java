package com.qhapaq.hackthon1_pb.userLimit.domain;

import com.qhapaq.hackthon1_pb.restriction.domain.Restriction;
import com.qhapaq.hackthon1_pb.user.domain.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserLimit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "user_id"
    )
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "restriction_id"
    )
    private Restriction restriction;

    private Long tokenLimit;

    private Integer requestLimit;

    private Long tokenUsed;

    private Integer requestMade;
}
