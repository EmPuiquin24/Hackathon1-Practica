package com.qhapaq.hackthon1_pb.company.domain;

import com.qhapaq.hackthon1_pb.company.infrastructure.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CompanyService {
    private final CompanyRepository companyRepository;


}
