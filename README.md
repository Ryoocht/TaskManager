# About TaskManager
A simple web application to manage tasks.

## Table of content
- [Prerequisites](#prerequisites)
  - [Plugins / Dependencies](#plugins-dependencies)
- [Repositories](#repositories)
  - [Login Page](#login-page)
  - [Todo Page](#todo-page)

<a id="prerequisites"></a>
## Prerequisites
- Java 15
- Maven
- Eclipse

<a id="plugins-dependencies"></a>
### Plugins / Dependencies
- Framework: Springframework
  - thymeleaf
  - mybatis
  - devtools
  - jquery
- Database: MySQL

<a id="repositories"></a>
## Repositories
- src
  - main
    - config
    - controllers
    - entities
    - mapper
    - services
  - resources
    - mapper
    - static
    - templates
---
<a id="login-page"></a>
## Login Page
![2021-05-25 (2)](https://user-images.githubusercontent.com/14501804/119484222-24cd1c80-bd99-11eb-8903-ae2d63438df0.png)
- #### Login Configuration (WebSecurityConfig.java)
	- WebSecurityConfig: 
		- Inherit WebSecurityConfigurerAdapter and authenticate inserted user data.
   		- Hashing password
  ~~~
  http.formLogin().loginPage("/login").loginProcessingUrl("/authenticate").usernameParameter("userName")
          .passwordParameter("password").defaultSuccessUrl("/").permitAll();
  ~~~
  ~~~ 
  @Bean 
  PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	} 
  ~~~
- #### Login Controllers (LoginController.java/ MemberRegistrationController.java)
 	- MemberRegistrationController:
  		- Take input data into MemberRegistrationForm and jump to RegistrationForm
		- When user data is authenticated Jump to Result
- #### Login Entities (Account.java / DbUserDetails.java / MemberRegistration.java / MemberRegistrationForm.java)
	- Account: Store member information required for login 
	- DbUserDetails: Obtain user information from DB
	- MemeberRegistration: Store the value to be put in DB
	- MemeberRegistrationForm: Store the value entered in the membership registration form
- #### Login Mapper (LoginMapper.java / RegisterMemberMaper.java)
	- LoginMapper: Get name and password from user_login(DB)
	- RegisterMemberMaper: Insert user info into user_login(DB)
- #### Login Services (DbUserDetailsService.java / RegisterMemberService.java)
	- DbUserDetailsService: Get user information from DB
  ~~~
    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
          Account account = Optional.ofNullable(loginMapper.findAccount(userName))
                  .orElseThrow(() -> new UsernameNotFoundException("User not found."));
          return new DbUserDetails(account, getAuthorities(account));
      }
  ~~~
	- RegisterMemberService: Hashing a password and insert it into DB
  ~~~
    public void registermemeber(MemberRegistration entity) {
    	entity.setPassword(passwordEncoder.encode(entity.getPassword()));
    	registerMemberMapper.insertMemberInfo(entity);
    }
  ~~~
	- Login Mapper(LoginMapper.xml / RegisterMapper.xml)
	- Login Style Sheet (login.css)
	- Login templates (login.html / RegistrationForm.html / Result.html)
---

<a id="todo-page"></a>
## Todo Page
![2021-05-25 (3)](https://user-images.githubusercontent.com/14501804/119488577-103f5300-bd9e-11eb-99bd-6f9fb4919bbf.png)
- #### Todo Controller (TodoController.java)
	- TodoController: 
		- Get database data with todoMapper object and set the list checked on checkbox and the list without checked on input object respectively. 
		- Prepare each post mapping method of add / update / delete and access the database via todoMapper object
- #### Todo Entity (Todo.java)
- #### Todo Mapper (TodoMapper.java)
    ~~~
      public List<Todo> selectIncomplete();
      public List<Todo> selectComplete();
      public void add(Todo todo);
      public void update(Todo todo);
      public void delete();
    ~~~
- #### Todo Mapper (TodoMapper.xml)
    ~~~
      <select id="selectIncomplete" resultType="com.ryochi.taskmanager.entities.Todo">
		SELECT * FROM `todo_items` WHERE done_flag = 0
      </select>
	
      <select id="selectComplete" resultType="com.ryochi.taskmanager.entities.Todo">
		SELECT * FROM `todo_items` WHERE done_flag = 1
      </select>
	
      <insert id="add" useGeneratedKeys="true" keyProperty="id" parameterType="com.ryochi.taskmanager.entities.Todo">
		INSERT INTO `todo_items` (title,due_date) VALUES (#{title},#{due_date})
      </insert>
	
      <update id="update" parameterType="com.ryochi.taskmanager.entities.Todo">
		UPDATE `todo_items` SET 
		title = '${title}',
		due_date = '${due_date}',
		done_flag = '${done_flag}' WHERE id = '${id}'
      </update>
	
      <delete id="delete" parameterType="com.ryochi.taskmanager.entities.Todo">
		DELETE FROM `todo_items` WHERE done_flag = 1
      </delete>
    ~~~
- #### Todo Style Sheet (style.css)
- #### Todo templates (todo.html)
---
