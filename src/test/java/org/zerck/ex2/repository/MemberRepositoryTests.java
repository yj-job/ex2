package org.zerck.ex2.repository;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerck.ex2.entity.Memo;

import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
public class MemberRepositoryTests {

    @Autowired
    MemoRepository memoRepository;

    @Test
    public void  testClass(){
        //1.
        System.out.println("@::    "+ memoRepository.getClass().getName());
    }

    // jpa Insert 예제
    @Test
    public void testInsertDummies() {
        IntStream.rangeClosed(1,100).forEach(i ->{
            Memo memo = Memo.builder().memoText("Sample..." +i).build();
            memoRepository.save(memo);
        });
    }

    // 조회 findById 방식
    @Test
    public void testSelect() {
        Long mno =100L;
          // 데이터베이스에 존재하는 Mno
        Optional<Memo> result = memoRepository.findById(mno);
        System.out.println("========================================================");

        if(result.isPresent()){
            Memo memo = result.get();
            System.out.println(memo);
        }
    }

    /*
    *   업데이트 Test
    * */
    @Test
    public void testUpdate() {
        Memo memo =Memo.builder().mno(100L).memoText("Update Test").build();

        System.out.println(memoRepository.save(memo));
    }

    /*
    *   삭제 Test
    * */
    @Test
    public void testDelete() {
        Long mno =99L;
        memoRepository.deleteById(mno);
        /*###
        *   101~200 한번에 삭제
        * */
//        IntStream.rangeClosed(101,200).forEach(i ->{
//
//            memoRepository.deleteById((long) i);
//        });
    }

}
