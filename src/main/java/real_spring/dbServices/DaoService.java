package real_spring.dbServices;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import static real_spring.dbServices.DBType.*;

@Service
public class DaoService {
    @DataBase(DERBY)
    private Dao dao;
    @DataBase(ORACLE)
    private Dao backupDao;

    @Scheduled(fixedDelay = 500)
    public void work(){
        dao.saveAll();
    }

    @Scheduled(fixedDelay = 3000)
    public void backup(){
        backupDao.saveAll();
    }
}
