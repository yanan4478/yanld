/**
 * Created by XK on 2016/6/7.
 */
import { normalize, Schema, arrayOf } from 'normalizr';

export const Order = new Schema("Order");
export const OrderDetail = new Schema("OrderDetail",{ idAttribute: 'order_id' });
export const total = new Schema("total",{ idAttribute: 'total' });
export const totalPage = new Schema("totalPage",{ idAttribute: 'totalPage' });
Order.define({
    total :total,
    totalPage:totalPage,
    list: arrayOf(OrderDetail),
    //collections: arrayOf(OrderDetail)
});
