package com.em.controllers;

import com.em.entities.User;
import com.em.entities.User1;
import com.em.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.Map;

/**
 * Created by Administrator on 2017/8/1.
 */
@Controller
@RequestMapping("/")
public class TestResource {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/hello/test")
    public String hello(Map<String,Object> map) throws SQLException {
        map.put("name", "[Angel -- 守护天使]");
        User user = new User("AAA", 10);
        userRepository.save(user);

        System.out.println(user.getId());


        return "hello";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User1 view(@PathVariable("id") Long id) {
        User1 user1 = new User1();
        user1.setId(id);
        user1.setName("zhang");
        return user1;
    }

    @RequestMapping(value = "/hello/entity",method=RequestMethod.GET)
    @ResponseBody
    public HttpEntity getList(HttpServletRequest req, HttpServletResponse rep){
        String id = req.getSession().getId();

        User1 user1 = new User1();
        user1.setId(456L);
        user1.setName("zhang");
        return new ResponseEntity<>(user1, HttpStatus.OK);
    }
}
