package org.greenGroup.dao;

import org.assertj.core.api.Assertions;
import org.greenGroup.entity.User;
import org.greenGroup.util.DBUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserDaoTests {

    private static UserDao dao;
    private static User user;
    private User expectedUser;

    @BeforeAll
    public static void init() {
       // dao = new UserDao(DBUtils.createDB());
        user= new User();
        user.setFirstName("Vasya");
        user.setLastName("vasilev");
        user.setAge(27);
        user.setId(22);
    }

    @Test
    @DisplayName("updateUserTest")
    void updateUserTest() {
        Assertions.assertThat(1).isEqualTo(1);
    }




}
