package real_spring.dbServices;

@Oracle
public class OracleDao implements Dao {
    @Override
    public void crud() {
        System.out.println("Oracle Dao do his logic");
    }
}
