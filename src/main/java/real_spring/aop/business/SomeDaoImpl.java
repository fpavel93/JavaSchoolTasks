package real_spring.aop.business;

import org.springframework.stereotype.Repository;

@Repository
public class SomeDaoImpl implements SomeDao {
    @Override
    public void saveData() {
        System.out.println("trying to save...");
        throw new DBException("fire all DBA");
    }
}
