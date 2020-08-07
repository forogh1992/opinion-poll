package com.forogh.opinionPoll.repository;

import com.forogh.opinionPoll.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends PagingAndSortingRepository<User, Long> {


    Optional<User> findById(Long id);

    Optional<User> findByPhoneNumber(String phoneNumber);

    Optional<User> findByUserName(String username);

    Optional<User> findByPhoneNumberAndUserName(String phoneNumber, String username);

    Page<User> findAll(Pageable pageable);

    List<User> findAll();


}
