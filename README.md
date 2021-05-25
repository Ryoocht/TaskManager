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
### Login Page
  #### Login Configuration (WebSecurityConfig.java)
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
  #### Login Controllers (LoginController.java/ MemberRegistrationController.java)
  - LoginController
      Show login form
---

<a id="todo-page"></a>
### Todo Page
---
