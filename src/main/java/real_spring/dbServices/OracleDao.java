package real_spring.dbServices;

import lombok.SneakyThrows;

@DataBase(DBType.ORACLE)
public class OracleDao implements Dao {
    @SneakyThrows
    @Override
    public void saveAll() {
        Thread.sleep(50);
        System.out.println("save to OracleDB");
    }
}
