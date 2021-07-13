package com.dm.nabidm.orm.repository;

import com.dm.nabidm.orm.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MemberRepository extends JpaRepository<Member, Integer>, JpaSpecificationExecutor<Member> {

    Member findMemberByName(String name);

}
