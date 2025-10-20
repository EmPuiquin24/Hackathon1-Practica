package com.qhapaq.hackthon1_pb.restriction.repository;

import com.qhapaq.hackthon1_pb.restriction.domain.Restriction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RestrictionRepository extends JpaRepository<Restriction, Long> {

    List<Restriction> findByCompanyId(Long companyId);

}
