package real_spring.dbServices;

@Derby
public class DerbyDao implements Dao {
    @Override
    public void crud() {
        System.out.println("Derby Dao do his logic");
    }
}
