package top.glimpse.lanbitou.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import top.glimpse.lanbitou.data.BillRepository;
import top.glimpse.lanbitou.domain.Bill;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Henvealf on 16-5-14.
 */

@Controller
@RequestMapping(value = "/bill")
public class BillController {

    private static final String SUCCESS = "success";

    private BillRepository billRepository;

    @Autowired
    public BillController(BillRepository billRepository){
        this.billRepository = billRepository;
    }

    @RequestMapping(value="/addOne", produces = "application/json;charset=UTF-8", method = RequestMethod.POST )
    @ResponseBody
    public String addOne(@RequestBody Bill bill){

//        bill = new Bill();          //先试一下
//        bill.setUid(1);
//        bill.setType("玩");
//        bill.setMoney(-34.5);
//        bill.setFolder("日常");
//        bill.setRemark("去了阿尔卑斯玩一玩");
        SimpleDateFormat format = new SimpleDateFormat();
        if(bill.getBillDate() == null){
            bill.setBillDate(format.format(new Date()));
        }
        billRepository.addOne(bill);

        return SUCCESS;
    }

}
