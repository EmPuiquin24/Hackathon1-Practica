package com.qhapaq.hackthon1_pb.company.infrastructure;

import com.qhapaq.hackthon1_pb.company.domain.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {

}
