package real_spring.dbServices;

import lombok.SneakyThrows;

@DataBase(DBType.DERBY)
public class DerbyDao implements Dao {
    @SneakyThrows
    @Override
    public void saveAll() {
        Thread.sleep(100);
        System.out.println("save to DerbyDB");
    }
}
