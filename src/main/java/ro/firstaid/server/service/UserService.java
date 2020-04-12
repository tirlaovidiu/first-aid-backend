package ro.firstaid.server.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.firstaid.server.entity.dto.UserDto;
import ro.firstaid.server.entity.model.User;
import ro.firstaid.server.exception.GeneralException;
import ro.firstaid.server.repository.UserDao;

import java.util.Optional;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
public class UserService {
    private final UserDao userDao;
    private final ModelMapper modelMapper;

    @Autowired
    public UserService(UserDao userDao, ModelMapper modelMapper) {
        this.userDao = userDao;
        this.modelMapper = modelMapper;
    }

    public UserDto getUser(int userId) {
        Optional<User> optionalUser = userDao.findById(userId);
        if (!optionalUser.isPresent())
            throw new GeneralException("User not found", NOT_FOUND);
        else return userToUserDto(optionalUser.get());
    }

    private UserDto userToUserDto(User user) {
        return modelMapper.map(user, UserDto.class);
    }
}
