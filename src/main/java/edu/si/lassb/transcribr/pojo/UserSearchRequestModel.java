package edu.si.lassb.transcribr.pojo;

/**
 * Provides a POJO mapped to user search parameters.
 *
 * @see edu.si.lassb.transcribr.controller.UserController::getUserBySearch()
 */
public class UserSearchRequestModel {

    private Integer id;
    private String email;
    private String username;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
