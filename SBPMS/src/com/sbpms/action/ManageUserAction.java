package com.sbpms.action;
import java.util.EnumSet;
import java.util.Map;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sbpms.util.MD5EncrypterUtil;
import com.sbpms.util.EnumForRole.Role;
import com.sbpms.bean.User;
import com.sbpms.service.UserService;
/**
 * This action is used to validate and deal with login processing
 * @author IanLi
 *
 */
@SuppressWarnings("serial")
public class ManageUserAction extends ActionSupport {

    private UserService service;
    private User user;
    private User newUser;
    
    private String password;
    private String rePassword;
    private String passwordJudge;

    public UserService getService() {

        return service;
    }

    public void setService(UserService service) {

        this.service = service;
    }

    public User getUser() {

        return user;
    }

    public void setUser(User user) {

        this.user = user;
    }

    public User getNewUser() {
        return newUser;
    }

    public void setNewUser(User newUser) {
        this.newUser = newUser;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRePassword() {
        return rePassword;
    }

    public void setRePassword(String rePassword) {
        this.rePassword = rePassword;
    }

    public String getPasswordJudge() {
        return passwordJudge;
    }

    public void setPasswordJudge(String passwordJudge) {
        this.passwordJudge = passwordJudge;
    }

    /*
     * This method is used to the login JSP, include the operations of call
     * database and do validation.
     */
    public String login() throws Exception {
     
        // Put all information of this user saved in the database to
        // session by key user_login
        ActionContext.getContext().getSession().put("user_login",
                this.user);
        EnumSet<Role> rolesSet = EnumSet.allOf(Role.class);  
        for (Role role : rolesSet) {  
            if(this.user.getRole().equals(role.toString())){
                return role.toString().toUpperCase();
            }
        }
        return INPUT;
    }
    
    /*
     * Logout of the web
     */
    public String logout() throws Exception {

        @SuppressWarnings("rawtypes")
        Map sessionMap = ActionContext.getContext().getSession();

        sessionMap.remove("user_login");
        ActionContext.getContext().getSession().put("user_login","Logout");
        sessionMap.clear();
        return SUCCESS;
    }
    
    /*
     * Change password and put new password to session
     */
    public String changePassword() throws Exception {

        boolean judge_sql = this.service.updateUser(this.newUser);
        if (judge_sql) {
            ActionContext.getContext().getSession()
                .put("user_login",this.user);
            this.addActionError(this.getText("Change password success!"));
            return SUCCESS;
        } else {
            return INPUT;
        }
    }

    public void validateLogin() {
        
        this.clearActionErrors();

        if (null == this.user) {
            this.addActionError("User name must not be empty");
            return;
        }

        // Judge the the name input by whether it is empty.
        if (null == this.user.getName() || this.user.getName() == "") {
            this.addActionError("User name must not be empty");
        } else {
            // Judge the pre_password input by whether it it empty.
            if (null == this.user.getPre_password() || this.user.getPre_password().isEmpty()) {
                this.addActionError("Password must not be empty");
            } else {
                // Change pre_password into password
                String md5Password;
                try {md5Password = MD5EncrypterUtil.getMD5(
                        this.user.getPre_password());
                
                this.user.setPassword(md5Password);
                // Judge the input name and password by whether they are accord
                // with the database.
                this.user = this.service.login(this.user);
                if (null == this.user) {
                    this.addActionError("User name or Password error");
                    this.user = null;
                } else {
                    // Do Nothing
                }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    public void validateChangePassword() {
        
        this.clearActionErrors();

        // Change all input password into MD5 password
        if(null == this.passwordJudge || null == this.password
                || null == this.rePassword){
            return;
        }
        try {
            String savePasswordJudge = this.passwordJudge;
            String savePassword = this.password;
            String saveRePassword = this.rePassword;
            this.passwordJudge = com.sbpms.util.MD5EncrypterUtil
                    .getMD5(this.passwordJudge);
            this.password = com.sbpms.util.MD5EncrypterUtil
                    .getMD5(this.password);
            this.rePassword = com.sbpms.util.MD5EncrypterUtil
                    .getMD5(this.rePassword);

            // If we change the password, we need update the session
            this.user = new User();
            this.user = (User) ActionContext.getContext().getSession()
                    .get("user_login");
            if (!this.passwordJudge.equals(this.user.getPassword())) {
                this.addActionError("Wrong old password input:"+savePasswordJudge);
            } else {
                boolean isEmpty = (savePassword.isEmpty()
                        && saveRePassword.isEmpty() && savePassword.equals("")
                        && saveRePassword.equals(""));
                boolean isEqual = this.password.equals(this.rePassword);
                if (!(isEqual) || isEmpty) {
                    this.addActionError("Wrong password or repassword input!");
                } else {
                    this.newUser = this.user;
                    newUser.setPassword(this.password);
                }
            }
        } catch (Exception e) {
            // TODO Add log here
        }
    }
}
