package com.arturo.jm2api.user.role;

import com.arturo.jm2api.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRoleServiceImpl implements UserRoleService {
    
    @Autowired private UserRoleDAO userRoleDAO;

    @Override
    public UserRole save(UserRole userRole) {
        return userRoleDAO.save(userRole);
    }
    
    @Override
    public UserRole saveDefaultRole(User user) {
        UserRole userRole = new UserRole();
        userRole.setRole(Roles.DEFAULT);
        userRole.setUser(user);
        return userRoleDAO.save(userRole);
    }
}
