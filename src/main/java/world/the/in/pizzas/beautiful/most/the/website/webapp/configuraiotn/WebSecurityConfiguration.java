package world.the.in.pizzas.beautiful.most.the.website.webapp.configuraiotn;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.csrf().disable().authorizeRequests()
                .antMatchers("/h2-console/**", "/register").permitAll()
                .anyRequest().authenticated()

                .and()
                .formLogin().loginPage("/login").permitAll()
                .loginProcessingUrl("/authenticate")
                .defaultSuccessUrl("/index")
                .failureUrl("/login?error=true")

                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .permitAll()

                //Code below is for h2-console to work without login
                .and()
                .headers().frameOptions().disable();
    }
}
