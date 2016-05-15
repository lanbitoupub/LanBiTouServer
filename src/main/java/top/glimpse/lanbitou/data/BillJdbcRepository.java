package top.glimpse.lanbitou.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;
import top.glimpse.lanbitou.domain.Bill;

import java.util.List;

/**
 * Created by Henvealf on 16-5-14.
 */
@Repository
public class BillJdbcRepository implements BillRepository{

    private JdbcOperations jdbcOperations;

    /**
     * 注入模板类
     * @param jdbcOperations
     */
    @Autowired
    public BillJdbcRepository(JdbcOperations jdbcOperations){
        this.jdbcOperations = jdbcOperations;
    }



    @Override
    public void addOne(Bill bill) {

    }

    @Override
    public void addSome(List<Bill> billList) {

    }

    @Override
    public Bill getOneById(int id) {
        return null;
    }

    @Override
    public List<Bill> getSomeByUserId(int uid) {
        return null;
    }

    @Override
    public List<Bill> getSomeByFolder(String folderName) {
        return null;
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public void delete(Bill bill) {

    }

    @Override
    public void update(Bill bill) {

    }
}
