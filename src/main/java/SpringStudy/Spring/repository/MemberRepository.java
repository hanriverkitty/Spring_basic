package SpringStudy.Spring.repository;

import SpringStudy.Spring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findMyName(String name);
    List<Member> findAll();
}
