package com.forogh.opinionPoll.service;

import com.forogh.opinionPoll.exception.ConflictException;
import com.forogh.opinionPoll.exception.NotFoundException;
import com.forogh.opinionPoll.model.User;
import com.forogh.opinionPoll.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public void register(User user) {

        Optional<User> findUserPhone = userRepository.findByPhoneNumber(user.getPhoneNumber());
        Optional<User> findUsername = userRepository.findByUserName(user.getUserName());

        if (findUserPhone.isPresent()) {
            throw new ConflictException("this phoneNumber already exist");

        } else if (findUsername.isPresent()) {
            throw new ConflictException("this username already exist");

        } else
            user.setTotalAnswerSheet(0);
            userRepository.save(user);

    }

    @Override
    public User getById(Long userId) {
        Optional<User> user = userRepository.findById(userId);

        if (user.isPresent())
            return user.get();
        else
            throw new NotFoundException("this user  not found:" + userId);
    }


    @Override
    public User update(Long id, User user) {
        Optional<User> findUser = userRepository.findById(id);

        if (findUser.isPresent()) {
            User updateUser = findUser.get();
            updateUser.setUserName(user.getUserName());
            updateUser.setGender(user.getGender());
            userRepository.save(updateUser);
            return updateUser;
        } else {
            throw new NotFoundException("Not found this user");
        }

    }

    @Override
    public User getByPhoneNumber(String phoneNumber) {
        Optional<User> findUserByPhoneNumber = userRepository.findByPhoneNumber(phoneNumber);

        if (findUserByPhoneNumber.isPresent())
            return findUserByPhoneNumber.get();
        else
            throw new NotFoundException("this phoneNumber don't register");

    }

    @Override
    public User getUserByPhoneAndUsername(String phoneNumber, String username) {
        Optional<User> user = userRepository.findByPhoneNumberAndUserName(phoneNumber, username);

        if (!user.isPresent()) {
            throw new NotFoundException("this user not found");
        }
        return user.get();
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();

    }

    @Override
    public Page<User> getAllWithPagination(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize, Sort.by(Sort.Order.desc("createDate")));

        return userRepository.findAll(pageable);
    }

    @Override
    public void deleteUserById(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            userRepository.deleteById(userId);
        } else {
            throw new NotFoundException("Not found user");
        }

    }

    @Override
    public User getUser(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent())
            return user.get();
        else
            throw new RuntimeException();
    }

    @Override
    public void updateTotalAnswerSheet(User user) {
        user.setTotalAnswerSheet(user.getTotalAnswerSheet()+1);
        userRepository.save(user);
    }
}
