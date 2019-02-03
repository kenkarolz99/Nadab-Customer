package com.example.karokojnr.nadab_customer.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.karokojnr.nadab_customer.R;
import com.example.karokojnr.nadab_customer.model.Hotel;

import java.util.ArrayList;


public class HotelAdapter extends RecyclerView.Adapter<HotelAdapter.HotelViewHolder> {

    private ArrayList<Hotel> mDataList;

    public HotelAdapter(ArrayList<Hotel> mDataList) {
        this.mDataList = mDataList;
    }

   private  OnItemlickListener mListener;
    public interface OnItemlickListener{
        void onItemClick(int position);
    }
    public  void setOnItemClickListener(OnItemlickListener listener){
        mListener = listener;
    }

    @Override
    public HotelViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //correct
        LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_hotels, parent, false);

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_hotels, parent, false);
        return new HotelViewHolder(view);
    }

    @Override
    public void onBindViewHolder(HotelViewHolder holder, int position) {
        holder.txtHotelName.setText(mDataList.get(position).getBusinessName ());
        holder.txtAddress.setText(mDataList.get(position).getAddress ());
        holder.txtPayBillNo.setText(mDataList.get(position).getPayBillNo ());
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    class HotelViewHolder extends RecyclerView.ViewHolder {

        TextView txtHotelName, txtAddress, txtPayBillNo;

        HotelViewHolder(View itemView) {
            super(itemView);
            txtHotelName = (TextView) itemView.findViewById(R.id.txt_hotel_name);
            txtAddress = (TextView) itemView.findViewById(R.id.txt_address);
            txtPayBillNo = (TextView) itemView.findViewById(R.id.pay_bill_no);



            itemView.setOnClickListener ( new View.OnClickListener () {
                @Override
                public void onClick(View v) {
                    if (mListener != null){
                        int position = getAdapterPosition ();
                        if (position != RecyclerView.NO_POSITION){
                            mListener.onItemClick ( position );
                        }
                    }
                }
            } );
        }
    }
}