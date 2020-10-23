//package com.spoto.controller;
//
//import com.spoto.es.EsNotesRep;
//import com.spoto.es.EsQu;
//import com.spoto.es.EsQuery;
//import com.spoto.es.Notes;
//import com.spoto.utils.WebUtils;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.annotation.Resource;
//import java.util.Date;
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//public class EsController {
//
//    @Resource
//    public EsNotesRep esNotesRep;
//
//    @Resource
//    public EsQu esQu;
//
//    @RequestMapping("/es")
//    public EsQuery<Notes> es() {
//      Notes n = new Notes(1,"我们",new Date());
//      Notes n1 = new Notes(2,"我们都是",new Date());
//      Notes n2 = new Notes(3,"我们都是中国",new Date());
//      Notes n3 = new Notes(4,"我们都是中国人",new Date());
//
//      esNotesRep.save(n);
//      esNotesRep.save(n1);
//      esNotesRep.save(n2);
//      esNotesRep.save(n3);
//        System.out.println(esQu.toString());
//
//
//        EsQuery<Notes> query = esQu.query("我们", 1, 10);
//
////      Optional<Notes> byId = esNotesRep.findById(3);
////      Notes notes = byId.get();
////      System.out.println(notes.toString());
//
//        List<Notes> dataList = query.getDataList();
//        for (Notes data:dataList){
//            System.out.println(data.toString());
//        }
//        return query;
//
//
//
//  }
//
//}
