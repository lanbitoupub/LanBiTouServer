package top.glimpse.lanbitou.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import top.glimpse.lanbitou.data.BillRepository;
import top.glimpse.lanbitou.domain.Bill;

import java.util.Date;

/**
 * Created by Henvealf on 16-5-14.
 */

@Controller
@RequestMapping(value = "/bill")
public class BillController {

    private BillRepository billRepository;

    @Autowired
    public BillController(BillRepository billRepository){
        this.billRepository = billRepository;
    }

    @RequestMapping(value="/addOne" ,method = RequestMethod.POST )
    public void addOne(Bill bill,Model model){

        bill = new Bill();          //先试一下
        bill.setUid(1);
        bill.setType("玩");
        bill.setMoney(-34.5);
        bill.setFolder("日常");
        bill.setRemark("去了阿尔卑斯玩一玩");

        if(bill.getBillDate() == null){
            bill.setBillDate(new Date());
        }
        billRepository.addOne(bill);
    }

}
