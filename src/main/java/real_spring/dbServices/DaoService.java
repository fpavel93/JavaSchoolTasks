package real_spring.dbServices;

import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;

@Service
public class DaoService {
    @Derby
    Dao dao;

    @PostConstruct
    public void crud(){
        dao.crud();
    }
}
