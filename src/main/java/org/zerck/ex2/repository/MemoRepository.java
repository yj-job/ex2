package org.zerck.ex2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zerck.ex2.entity.Memo;

public interface MemoRepository extends JpaRepository<Memo,Long> {
}
