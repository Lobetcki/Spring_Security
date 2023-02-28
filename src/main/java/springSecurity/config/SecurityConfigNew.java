package springSecurity.config;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;

@EnableWebSecurity
public class SecurityConfigNew extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        User.UserBuilder userBuilder = User.withDefaultPasswordEncoder();
        auth.inMemoryAuthentication()
                .withUser(userBuilder.username("Vania").password("1").roles("Employee"))
                .withUser(userBuilder.username("Kolia").password("2").roles("IT"))
                .withUser(userBuilder.username("Fedia").password("3").roles("Security"))
                .withUser(userBuilder.username("Petrovich").password("1234").roles("Director"));
    }

    protected void configure (HttpSecurity http) throws Exception {

        http.authorizeHttpRequests()
                .antMatchers("/").hasAnyRole("Employee", "IT", "Security", "Director")
                .antMatchers("/server_Room").hasAnyRole("IT", "Security", "Director")
                .antMatchers("/security_Room").hasAnyRole("Security", "Director")
                .antMatchers("/boss_Office").hasAnyRole("Director")
                .and().formLogin().permitAll();
    }

}
