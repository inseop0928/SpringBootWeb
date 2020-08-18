package com.jisweb.app;



import com.test.entity.Test01;
import com.test.entity.Test01Repository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

//@RunWith(SpringJUnit4ClassRunner.class)//jpa문제
@RunWith(SpringRunner.class)
@SpringBootTest
public class CommonTest {

    @Autowired
    private Test01Repository test01Repository;

    @Test
    public void helloWorld(){
        Random random = new Random();

        System.out.println("Random : " + random);
        System.out.println("Random11 : " +   random.nextBoolean());

        System.out.println("world");
    }

    @Test
    public void selectTest01JPA(){
        List<Test01> test01List = test01Repository.findAll();

        for(int i = 0 ;i<test01List.size();i++){
            System.out.println(test01List.get(i).seq);
            System.out.println(test01List.get(i).content);
        }
    }

    @Test
    public void InsertTest01JPA(){

        String title = "코로나1";
        String content = "물러가라?";

        //Date localDate = new LocalDate();
        test01Repository.save(Test01.builder()
                            .title(title)
                            .content(content)
                            .build());
    }
}


