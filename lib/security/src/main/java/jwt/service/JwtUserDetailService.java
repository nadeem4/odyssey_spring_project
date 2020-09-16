package jwt.service;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.ObjectMapper;
import jwt.config.UserData;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class JwtUserDetailService  implements UserDetailsService {

    @Value("classpath:user-data.json")
    Resource resource;

    @SneakyThrows
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        ObjectMapper mapper = new ObjectMapper();
        UserData[] userDataProps = mapper.readValue(resource.getFile(), UserData[].class);
        List<UserData> user = Arrays.stream(userDataProps).filter(userData -> userData.getUsername().equals(username)).collect(Collectors.toList());
        log.info("fName {}, roles {}", userDataProps[0].getFirstName(), user.get(0).getRoles());

        if ("javainuse".equals(username)) {
            return new User("javainuse", "$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6",
                    new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }
}
