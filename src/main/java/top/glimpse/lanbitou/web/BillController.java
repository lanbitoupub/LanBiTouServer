package top.glimpse.lanbitou.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.*;
import org.springframework.web.bind.annotation.ResponseBody;
import top.glimpse.lanbitou.data.BillRepository;
import top.glimpse.lanbitou.domain.Bill;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Henvealf on 16-5-14.
 */

@Controller
@RequestMapping(value = "/bill")
public class BillController {

    private static final int SUCCESS = 200;

    private BillRepository billRepository;

    @Autowired
    public BillController(BillRepository billRepository){
        this.billRepository = billRepository;
    }

    @RequestMapping(value="/addOne", produces = "application/json;charset=UTF-8", method = POST )
    @ResponseBody
    public int addOne(@RequestBody Bill bill){

        SimpleDateFormat format = new SimpleDateFormat();
        if(bill.getBillDate() == null){
            bill.setBillDate(format.format(new Date()));
        }
        billRepository.addOne(bill);

        return SUCCESS;
    }

    @RequestMapping(value="/addSome", produces = "application/json;charset=UTF-8", method = POST )
    @ResponseBody
    public int addSome(@RequestBody List<Bill> billList){
        for(Bill bill : billList){
            billRepository.addOne(bill);
        }
        return SUCCESS;
    }


    @RequestMapping(value="/getOneById/{id}",produces = "application/json;charset=UTF-8",method = GET )
    @ResponseBody
    public Bill getOneById(@PathVariable int id){
        return billRepository.getOneById(id);
    }

    @RequestMapping(value="/getSomeByFolder/{uid}/{folderName}",produces = "application/json;charset=UTF-8",method = GET )
    @ResponseBody
    public List<Bill> getSomeByFolder(@PathVariable int uid,
                                      @PathVariable String folderName){
        return billRepository.getSomeByFolder(uid,folderName);
    }

    /**
     * 删除
     * @param id
     */
    @RequestMapping(value="/deleteById/{id}",method = GET )
    public void deleteById(@PathVariable int id){
        billRepository.deleteById(id);
    }

    @RequestMapping(value="/deleteSome", produces = "application/json;charset=UTF-8", method = POST )
    public void deleteSome(@RequestBody List<Bill> billList){

    }



}
