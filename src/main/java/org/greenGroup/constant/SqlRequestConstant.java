package org.greenGroup.constant;

public class SqlRequestConstant {

    public static final String SELECT_ALL_FROM_USERS_BY_ID = "SELECT * FROM users WHERE id = ?";

    public static final String SELECT_ALL_FROM_USERS = "SELECT * FROM users";

    public static final String INSERT_INTO_USERS_BY_VALUES = "INSERT INTO USERS (first_name, last_name, age) VALUES (?,?,?)";

    public static final String DELETE_FROM_USERS_BY_ID = "DELETE FROM users WHERE id = ?";

    public static final String UPDATE_USERS_BY_VALUES = "UPDATE users SET first_name = ?, last_name = ?, age = ? WHERE id = ?";






    private SqlRequestConstant() {}
}
