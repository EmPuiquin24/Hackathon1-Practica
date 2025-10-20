package com.qhapaq.hackthon1_pb.company.domain;

import com.qhapaq.hackthon1_pb.user.domain.User;
import com.qhapaq.hackthon1_pb.restriction.domain.Restriction;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "companies")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = true, length = 100)
    private String name;

    @Column(nullable = true, unique = true, length = 11)
    private String ruc;

    @Column(nullable = true)
    private LocalDate joinDate;

    @Column(nullable = true)
    private boolean active;

    @OneToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "admin_id")
    private User admin;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<User> users;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Restriction> restrictions;
}
