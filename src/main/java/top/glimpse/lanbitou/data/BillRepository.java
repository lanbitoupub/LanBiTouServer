package top.glimpse.lanbitou.data;

import top.glimpse.lanbitou.domain.Bill;

import java.util.List;

/**
 * 账单的数据库操作抽象类
 * Created by Henvealf on 16-5-14.
 */
public interface BillRepository {

    /**
     * 加一个Bill
     * @param bill
     */
    public void addOne(Bill bill);

    /**
     * 加一些Bill
     * @param billList
     */
    public void addSome(List<Bill> billList);


    /**
     * 通过id获得bill
     * @param id bill id
     */
    public Bill getOneById(int id);

    /**
     * 通过用户Id获得bill们
     * @param uid 用户ID
     * @return
     */
    public List<Bill> getSomeByUserId(int uid);

    /**
     * 根据文件夹获得bill们
     * @param folderName
     * @return
     */
    public List<Bill> getSomeByFolder(String folderName);

    /**
     * 删除相应id的账单
     * @param id
     */
    public void deleteById(int id);


    /**
     * 删除
     * @param bill
     */
    public void delete(Bill bill);


    /**
     * 更新
     * @param bill
     */
    public void update(Bill bill);


}
