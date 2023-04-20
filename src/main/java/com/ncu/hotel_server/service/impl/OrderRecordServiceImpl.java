package com.ncu.hotel_server.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.ncu.hotel_server.entity.OccupantRecord;
import com.ncu.hotel_server.entity.OrderRecord;
import com.ncu.hotel_server.mapper.*;
import com.ncu.hotel_server.service.OrderRecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xph
 * @since 2023-04-03
 */
@Service
public class OrderRecordServiceImpl extends ServiceImpl<OrderRecordMapper, OrderRecord> implements OrderRecordService {
    @Autowired
    CustomerMapper customerMapper;
    @Autowired
    OccupantRecordMapper occupantRecordMapper;
    @Autowired
    DepositMapper depositMapper;
    @Autowired
    CommodityRecordMapper commodityRecordMapper;
    @Override
    public List<Map<String, Object>> getSalesByTime(String start, String end) {
        return baseMapper.getSalesByTime(start, end);
    }

    @Override
    public List<Map<String, Object>> getRecordTotal(String start, String end) {
        return baseMapper.getRecordTotal(start,end);
    }

    @Override
    public List<Map<String, Object>> getOrderByTime(String start, String end) {
        return baseMapper.getOrderByTime(start,end);
    }

    @Override
    @Transactional
    public Integer addFastCheckIn(Map<String, Object> params) throws Exception {
        List<Map<String,Object>> customer=customerMapper.selectOneByPhone((String) params.get("customer_phone"));
        Long customer_id;
        if(customer.size()>=1){
            customer_id= (Long) customer.get(0).get("customer_id");
        }
        else {
            int i=customerMapper.insertOneByPhone((String) params.get("customer_name"),(String) params.get("customer_phone"));
            if(i==1){
                customer=customerMapper.selectOneByPhone((String) params.get("customer_phone"));
                customer_id= (Long) customer.get(0).get("customer_id");
            }
            else
                throw new Exception("顾客数据重复");
        }
        OrderRecord orderRecord=new OrderRecord();
        orderRecord.setCustomerId(customer_id.toString());
        orderRecord.setRoomId( params.get("room_id").toString());
        orderRecord.setRoomType((String) params.get("room_type"));
        orderRecord.setOrderStatus("2");
        orderRecord.setFinalPaymentAmount(Float.parseFloat(params.get("actuallyPaid").toString()) );
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        orderRecord.setCheckInTime(LocalDateTime.parse((String) params.get("check_in_time"),formatter));
        orderRecord.setCheckOutTime(LocalDateTime.parse((String)params.get("check_out_time"),formatter));
        //int result1=baseMapper.insertReservationRecord(customer_id,params.get("room_id"),params.get("room_type"),"2",params.get("check_in_time"),params.get("check_out_time"));
        int result1=baseMapper.insertRecord(orderRecord);
        int result2=depositMapper.insertDeposit(orderRecord.getOrderId(),Double.parseDouble(params.get("deposit").toString()));
        List<Map<String,String>> occupants= (List<Map<String, String>>) params.get("occupants");
        int count=0;
        for(int i=0;i<occupants.size();i++){
            OccupantRecord occupant=new OccupantRecord();
            occupant.setOrderId(orderRecord.getOrderId());
            occupant.setName(occupants.get(i).get("name"));
            occupant.setCardId(occupants.get(i).get("cardId"));
            occupant.setType(occupants.get(i).get("type"));
            count+=occupantRecordMapper.insert(occupant);
        }
        if(count==occupants.size()&&result1==1&&result2==1){
            return 1;
        }
        else
            throw new Exception("插入订单数据出错");

    }

    @Override
    public Integer addBookAStayInfo(Map<String, Object> params) throws Exception {
        int record_id=Integer.parseInt(params.get("record_id").toString());
        int result=baseMapper.updateStatus("2",Double.parseDouble(params.get("actuallyPaid").toString()) , record_id );
        int result1=depositMapper.insertDeposit(record_id,Double.parseDouble(params.get("deposit").toString()));
        List<Map<String,String>> occupants= (List<Map<String, String>>) params.get("occupants");
        int count=0;
        for(int i=0;i<occupants.size();i++){
            OccupantRecord occupant=new OccupantRecord();
            occupant.setOrderId(record_id);
            occupant.setName(occupants.get(i).get("name"));
            occupant.setCardId(occupants.get(i).get("cardId"));
            occupant.setType(occupants.get(i).get("type"));
            count+=occupantRecordMapper.insert(occupant);
        }
        if(count==occupants.size()&&result==1&&result1==1){
            return 1;
        }
        else
            throw new Exception("插入订单数据出错");
    }

    @Override
    public Integer cancelOrderById(Integer id) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return baseMapper.cancelOrder("0",id,dtf.format(LocalDateTime.now()));
    }

    @Override
    public Map<String, Object> getOrderDetailById(String orderId) {
        return baseMapper.getOrderDetailById(Integer.parseInt(orderId));
    }

    @Override
    public List<Map<String, Object>> getCommodityRecordByOrderId(String orderId) {
        return baseMapper.getCommodityRecordByOrderId(Integer.parseInt(orderId));
    }

    @Transactional
    @Override
    public Integer checkoutByOrderId(Map<String,Object> params) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String time=dtf.format(LocalDateTime.now());
        Integer recordId=Integer.parseInt(params.get("order_id").toString());
        List<Integer> commodityRecordIds= (List<Integer>) params.get("commodityRecordIds");
        int result1=baseMapper.checkoutOrder("3",Double.parseDouble(params.get("payment").toString()) ,recordId,time);
        int result2=commodityRecordMapper.checkoutOrder(recordId,"2",time);
        int result3= occupantRecordMapper.checkoutRecord(recordId,time);
        if(result1==1&&result2==commodityRecordIds.size()){
            return 1;
        }
        else
            throw new Exception("结账错误");

    }
    @Transactional
    @Override
    public Integer reimburseOrder(String orderId, Double actualCharge) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String time=dtf.format(LocalDateTime.now());
        Integer recordId=Integer.parseInt(orderId);
        int result1=baseMapper.checkoutOrder("-1",actualCharge ,recordId,time);
        int result2=commodityRecordMapper.checkoutOrder(recordId,"0",time);
        int result3= occupantRecordMapper.checkoutRecord(recordId,time);
        if(result1==1){
            return 1;
        }
        else
            throw new Exception("退款出错");
    }

    @Override
    public List<Map<String, Object>> getCustomerByRecordId(Integer orderId) {
        return occupantRecordMapper.getCustomerByRecordId(orderId);
    }
}
