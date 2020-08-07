package com.forogh.opinionPoll.service;

import com.forogh.opinionPoll.model.User;
import org.springframework.data.domain.Page;

import java.util.List;


public interface IUserService {

    void register(User user);

    User getById(Long userId);

    User update(Long id, User user);

    User getByPhoneNumber(String phoneNumber);

    User getUserByPhoneAndUsername(String phoneNumber, String username);

    User getUser(Long userId);

    List<User> getAllUser();

    Page<User> getAllWithPagination(int page, int pageSize);

    void  deleteUserById(Long userId);

    void  updateTotalAnswerSheet(User user);






}
