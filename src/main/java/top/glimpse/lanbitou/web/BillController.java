package top.glimpse.lanbitou.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import top.glimpse.lanbitou.data.BillRepository;

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

}
